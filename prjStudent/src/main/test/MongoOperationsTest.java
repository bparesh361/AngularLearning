import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.conf.MongoConfiguration;
import com.company.mongo.entity.Address;
import com.company.mongo.entity.Customer;
import com.company.mongo.entity.Discussion;
import com.company.mongo.entity.EmailAddress;
import com.company.mongo.entity.Order;
import com.company.mongo.repositories.CustomerRepository;
import com.company.mongo.repositories.DiscussionForumRepository;
import com.company.mongo.repositories.OrderRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MongoConfiguration.class})
public class MongoOperationsTest {

	@Autowired
	private DiscussionForumRepository discussionForumRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private MongoOperations mongo;
	
	@Before
	public void setUp() throws Exception {
		mongo.dropCollection(Discussion.class);
		mongo.dropCollection(Customer.class);
		mongo.dropCollection(Order.class);
	}
	
	/*@After
	public void tearDown() throws Exception {
		mongo.dropCollection(Discussion.class);
	}*/
	
	@Test
	public void thatItemsIsInsertedIntoRepoWorks() throws Exception {
		assertEquals(0, mongo.getCollection("discussion").count());
		discussionForumRepository.save(simpleDiscussion());
		assertEquals(1, mongo.getCollection("discussion").count());
	}
	
	@Test
	public void testCustomerAndOrder() throws Exception {
		Customer c = simpleCustomer();
		customerRepository.save(c);
		assertEquals(1, mongo.getCollection("customer").count());
		orderRepository.save(simpleOrder(c));
		assertEquals(1, mongo.getCollection("order").count());
		
	}
	
	private Customer simpleCustomer() {		
		Customer c = new Customer("Neha", "bhavsar");
		Address a1 = new Address("24", "ahmedabad");
		Address a2 = new Address("d-202", "ahmedabad");
		c.getAddresses().add(a1);
		c.getAddresses().add(a2);
		c.setEmailAddress(new EmailAddress("nehabhavsar.er@gmail.com"));
		return c;
		
	}
	
	private Order simpleOrder(Customer c){
		return new Order(100.00,c);
	}
	
	private Discussion simpleDiscussion(){
		Discussion d = new Discussion();
		d.setDiscussionName("test discussion");
		return d;
	}
	
	
	
}
