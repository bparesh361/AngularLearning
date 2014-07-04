package org.springframework.cassandra.test.unit.core.cql.generator;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cassandra.core.cql.generator.CreateTableCqlGenerator;
import org.springframework.cassandra.core.keyspace.CreateTableSpecification;
import org.springframework.cassandra.core.keyspace.Option;
import org.springframework.cassandra.core.keyspace.TableOption;
import org.springframework.cassandra.core.keyspace.TableOption.CachingOption;
import org.springframework.cassandra.core.keyspace.TableOption.CompactionOption;
import org.springframework.cassandra.core.keyspace.TableOption.CompressionOption;

import com.datastax.driver.core.DataType;

public class CreateTableCqlGeneratorTests {

	private static final Logger log = LoggerFactory.getLogger(CreateTableCqlGeneratorTests.class);

	/**
	 * Asserts that the preamble is first & correctly formatted in the given CQL string.
	 */
	public static void assertPreamble(String tableName, String cql) {
		assertTrue(cql.startsWith("CREATE TABLE " + tableName + " "));
	}

	/**
	 * Asserts that the given primary key definition is contained in the given CQL string properly.
	 * 
	 * @param primaryKeyString IE, "foo", "foo, bar, baz", "(foo, bar), baz", etc
	 */
	public static void assertPrimaryKey(String primaryKeyString, String cql) {
		assertTrue(cql.contains(", PRIMARY KEY (" + primaryKeyString + "))"));
	}

	/**
	 * Asserts that the given list of columns definitions are contained in the given CQL string properly.
	 * 
	 * @param columnSpec IE, "foo text, bar blob"
	 */
	public static void assertColumns(String columnSpec, String cql) {
		assertTrue(cql.contains("(" + columnSpec + ","));
	}

	/**
	 * Asserts that the read repair change is set properly
	 */
	public static void assertStringOption(String name, String value, String cql) {
		log.info(name + " -> " + value);
		assertTrue(cql.contains(name + " = '" + value + "'"));
	}

	/**
	 * Asserts that the option is set
	 */
	public static void assertDoubleOption(String name, Double value, String cql) {
		log.info(name + " -> " + value);
		assertTrue(cql.contains(name + " = " + value));
	}

	public static void assertLongOption(String name, Long value, String cql) {
		log.info(name + " -> " + value);
		assertTrue(cql.contains(name + " = " + value));
	}

	/**
	 * Asserts that the read repair change is set properly
	 */
	public static void assertNullOption(String name, String cql) {
		log.info(name);
		assertTrue(cql.contains(" " + name + " "));
	}

	/**
	 * Convenient base class that other test classes can use so as not to repeat the generics declarations or
	 * {@link #generator()} method.
	 */
	public static abstract class CreateTableTest extends
			TableOperationCqlGeneratorTest<CreateTableSpecification, CreateTableCqlGenerator> {

		public CreateTableCqlGenerator generator() {
			return new CreateTableCqlGenerator(specification);
		}
	}

	public static class BasicTest extends CreateTableTest {

		public String name = "mytable";
		public DataType partitionKeyType0 = DataType.text();
		public String partitionKey0 = "partitionKey0";
		public DataType columnType1 = DataType.text();
		public String column1 = "column1";

		public CreateTableSpecification specification() {
			return CreateTableSpecification.createTable().name(name).partitionKeyColumn(partitionKey0, partitionKeyType0)
					.column(column1, columnType1);
		}

		@Test
		public void test() {
			prepare();

			assertPreamble(name, cql);
			assertColumns(String.format("%s %s, %s %s", partitionKey0, partitionKeyType0, column1, columnType1), cql);
			assertPrimaryKey(partitionKey0, cql);
		}
	}

	public static class CompositePartitionKeyTest extends CreateTableTest {

		public String name = "composite_partition_key_table";
		public DataType partKeyType0 = DataType.text();
		public String partKey0 = "partKey0";
		public DataType partKeyType1 = DataType.text();
		public String partKey1 = "partKey1";
		public String column0 = "column0";
		public DataType columnType0 = DataType.text();

		@Override
		public CreateTableSpecification specification() {
			return CreateTableSpecification.createTable().name(name).partitionKeyColumn(partKey0, partKeyType0)
					.partitionKeyColumn(partKey1, partKeyType1).column(column0, columnType0);
		}

		@Test
		public void test() {
			prepare();

			assertPreamble(name, cql);
			assertColumns(
					String.format("%s %s, %s %s, %s %s", partKey0, partKeyType0, partKey1, partKeyType1, column0, columnType0),
					cql);
			assertPrimaryKey(String.format("(%s, %s)", partKey0, partKey1), cql);
		}
	}

	/**
	 * Test just the Read Repair Chance
	 * 
	 * @author David Webb
	 * 
	 */
	public static class ReadRepairChanceTest extends CreateTableTest {

		public String name = "mytable";
		public DataType partitionKeyType0 = DataType.text();
		public String partitionKey0 = "partitionKey0";
		public DataType partitionKeyType1 = DataType.timestamp();
		public String partitionKey1 = "create_timestamp";
		public DataType columnType1 = DataType.text();
		public String column1 = "column1";
		public Double readRepairChance = 0.5;

		public CreateTableSpecification specification() {
			return (CreateTableSpecification) CreateTableSpecification.createTable().name(name)
					.partitionKeyColumn(partitionKey0, partitionKeyType0).partitionKeyColumn(partitionKey1, partitionKeyType1)
					.column(column1, columnType1).with(TableOption.READ_REPAIR_CHANCE, readRepairChance);
		}

		@Test
		public void test() {
			prepare();

			assertPreamble(name, cql);
			assertColumns(String.format("%s %s, %s %s, %s %s", partitionKey0, partitionKeyType0, partitionKey1,
					partitionKeyType1, column1, columnType1), cql);
			assertPrimaryKey(String.format("(%s, %s)", partitionKey0, partitionKey1), cql);
			assertDoubleOption(TableOption.READ_REPAIR_CHANCE.getName(), readRepairChance, cql);
		}
	}

	/**
	 * Fully test all available create table options
	 * 
	 * @author David Webb
	 * 
	 */
	public static class MultipleOptionsTest extends CreateTableTest {

		public String name = "timeseries_table";
		public DataType partitionKeyType0 = DataType.timeuuid();
		public String partitionKey0 = "tid";
		public DataType partitionKeyType1 = DataType.timestamp();
		public String partitionKey1 = "create_timestamp";
		public DataType columnType1 = DataType.text();
		public String column1 = "data_point";
		public Double readRepairChance = 0.5;
		public Double dcLocalReadRepairChance = 0.7;
		public Double bloomFilterFpChance = 0.001;
		public Boolean replcateOnWrite = Boolean.FALSE;
		public Long gcGraceSeconds = 600l;
		public String comment = "This is My Table";
		public Map<Option, Object> compactionMap = new LinkedHashMap<Option, Object>();
		public Map<Option, Object> compressionMap = new LinkedHashMap<Option, Object>();

		public CreateTableSpecification specification() {

			// Compaction
			compactionMap.put(CompactionOption.CLASS, "SizeTieredCompactionStrategy");
			compactionMap.put(CompactionOption.MIN_THRESHOLD, "4");
			// Compression
			compressionMap.put(CompressionOption.SSTABLE_COMPRESSION, "SnappyCompressor");
			compressionMap.put(CompressionOption.CHUNK_LENGTH_KB, 128);
			compressionMap.put(CompressionOption.CRC_CHECK_CHANCE, 0.75);

			return (CreateTableSpecification) CreateTableSpecification.createTable().name(name)
					.partitionKeyColumn(partitionKey0, partitionKeyType0).partitionKeyColumn(partitionKey1, partitionKeyType1)
					.column(column1, columnType1).with(TableOption.COMPACT_STORAGE)
					.with(TableOption.READ_REPAIR_CHANCE, readRepairChance).with(TableOption.COMPACTION, compactionMap)
					.with(TableOption.COMPRESSION, compressionMap).with(TableOption.BLOOM_FILTER_FP_CHANCE, bloomFilterFpChance)
					.with(TableOption.CACHING, CachingOption.KEYS_ONLY).with(TableOption.REPLICATE_ON_WRITE, replcateOnWrite)
					.with(TableOption.COMMENT, comment).with(TableOption.DCLOCAL_READ_REPAIR_CHANCE, dcLocalReadRepairChance)
					.with(TableOption.GC_GRACE_SECONDS, gcGraceSeconds);
		}

		@Test
		public void test() {

			prepare();

			log.info(cql);

			assertPreamble(name, cql);
			assertColumns(String.format("%s %s, %s %s, %s %s", partitionKey0, partitionKeyType0, partitionKey1,
					partitionKeyType1, column1, columnType1), cql);
			assertPrimaryKey(String.format("(%s, %s)", partitionKey0, partitionKey1), cql);
			assertNullOption(TableOption.COMPACT_STORAGE.getName(), cql);
			assertDoubleOption(TableOption.READ_REPAIR_CHANCE.getName(), readRepairChance, cql);
			assertDoubleOption(TableOption.DCLOCAL_READ_REPAIR_CHANCE.getName(), dcLocalReadRepairChance, cql);
			assertDoubleOption(TableOption.BLOOM_FILTER_FP_CHANCE.getName(), bloomFilterFpChance, cql);
			assertStringOption(TableOption.CACHING.getName(), CachingOption.KEYS_ONLY.getValue(), cql);
			assertStringOption(TableOption.REPLICATE_ON_WRITE.getName(), replcateOnWrite.toString(), cql);
			assertStringOption(TableOption.COMMENT.getName(), comment, cql);
			assertLongOption(TableOption.GC_GRACE_SECONDS.getName(), gcGraceSeconds, cql);

		}
	}

}
