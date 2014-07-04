import java.util.Date;
import java.util.Set;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoTest {

	public static void main(String args[]) throws Exception {

		MongoClient client = new MongoClient();
		DB db = client.getDB("student");
		Set<String> collections = db.getCollectionNames();
		for (String c : collections) {
			System.out.println(c);
		}

		DBCollection collection = db.getCollection("person");
		BasicDBObject object = new BasicDBObject("fname", "paresh").append(
				"lname", "bhavsar").append("dob", new Date());
		collection.insert(object);

		System.out.println(collection.getCount());

		DBCursor cursor = collection.find();
		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
		} finally {
			cursor.close();
		}

		for (int x = 0; x < 100; x++) {
			BasicDBObject obj = new BasicDBObject("x", x);
			collection.insert(obj);
		}

		System.out.println(collection.getCount());

		BasicDBObject obj = new BasicDBObject("x", 4);
		cursor = collection.find(obj);

		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
		} finally {
			cursor.close();
		}
		
		System.out.println("---");
		
		obj = new BasicDBObject("x", new BasicDBObject("$lte",1));
		cursor = collection.find(obj);

		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next().get("x"));
			}
		} finally {
			cursor.close();
		}
		
		
		// geo spatial indexes...
		
	
		
		collection.createIndex(new BasicDBObject("loc", "2dsphere"));
		
		BasicDBList coordinates = new BasicDBList();
		coordinates.put(0, -73.97);
		coordinates.put(1, 40.77);
		collection.insert(new BasicDBObject("name", "Central Park")
		                .append("loc", new BasicDBObject("type", "Point").append("coordinates", coordinates))
		                .append("category", "Parks"));

		coordinates.put(0, -73.88);
		coordinates.put(1, 40.78);
		collection.insert(new BasicDBObject("name", "La Guardia Airport")
		        .append("loc", new BasicDBObject("type", "Point").append("coordinates", coordinates))
		        .append("category", "Airport"));
		
		DBObject myDoc = collection.findOne(
	            new BasicDBObject("loc",
	                new BasicDBObject("$near",
	                        new BasicDBObject("$geometry",
	                                new BasicDBObject("type", "Point")
	                                    .append("coordinates", coordinates))
	                             .append("$maxDistance",  1)
	                        )
	                )
	            );
	System.out.println(myDoc);
	db.dropDatabase();	
		
		

		/*
		 * MongoOperations operations = new MongoTemplate(new
		 * SimpleMongoDbFactory(new Mongo(),"student")); Query query = new
		 * Query();
		 * query.addCriteria(Criteria.where("discussionName").regex("java"
		 * ,"i")); List<Discussion> list = operations.find(query,
		 * Discussion.class); System.out.println(list); list =
		 * operations.findAll(Discussion.class); System.out.println(list);
		 * 
		 * query = new Query();
		 * query.addCriteria(Criteria.where("discussionName"
		 * ).regex("java","i")).limit(1); list = operations.find(query,
		 * Discussion.class); System.out.println(list);
		 * 
		 * query = new Query();
		 * query.addCriteria(Criteria.where("discussionName"
		 * ).regex("java","i")).skip(2); list = operations.find(query,
		 * Discussion.class); System.out.println(list);
		 * 
		 * query = new Query();
		 * query.addCriteria(Criteria.where("discussionName"
		 * ).regex("java","i")).so list = operations.find(query,
		 * Discussion.class); System.out.println(list);
		 */

		/*
		 * Discussion d = new Discussion("1","mongo");
		 * d.setDiscussionName("mongo .. capabilities"); operations.insert(d);
		 * Discussion d1 = operations.findById(d.getId(), Discussion.class);
		 * System.out.println(d1.getDiscussionName());
		 * operations.updateFirst(query
		 * (where("_id").is("1")),update("discussionName"
		 * ,"mongo new challenges"),Discussion.class); d1 =
		 * operations.findById(d.getId(), Discussion.class);
		 * 
		 * System.out.println(d1.getDiscussionName()); List<Discussion> list =
		 * operations
		 * .find(query(where("discussionName").is("mongo new challenges")),
		 * Discussion.class); System.out.println(list);
		 * 
		 * // inserting document with reply d = new Discussion("1","mongo");
		 * d.setDiscussionName("mongo .. capabilities"); Reply reply = new
		 * Reply(); reply.setText("test reply"); Reply reply1 = new Reply();
		 * reply1.setText("test reply1"); d.getReplies().add(reply);
		 * d.getReplies().add(reply1); operations.save(d);
		 * 
		 * // find in complex manner list =
		 * operations.find(query(where("replies.text").is("test reply1")),
		 * Discussion.class); System.out.println(list);
		 * 
		 * // MR job ... MapReduceResults<ValueObject> results =
		 * operations.mapReduce("mr", "map.js", "reduce.js", ValueObject.class);
		 * for(ValueObject valueObject : results){
		 * System.out.println(valueObject); }
		 */

	}

}
