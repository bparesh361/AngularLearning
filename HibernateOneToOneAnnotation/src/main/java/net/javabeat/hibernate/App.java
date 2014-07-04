package net.javabeat.hibernate;
 
import java.util.Iterator;
import java.util.List;
 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
/**
 * Main class
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + HSQL One to One Mapping Annotations");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        App app = new App();
 
        Address address1 = new Address("M.G.Road", "Bangalore", "Karnataka",
                "56000");
        Address address2 = new Address("Tilak Road", "Pune", "Maharashtra",
                "411207");
 
        app.savePersonInfo("Jiya", address1);
        app.savePersonInfo("Manisha", address2);
 
        app.listPersonInfo();
 
    }
 
    /*
     * Save the data to database table
     */
    public Long savePersonInfo(String personName, Address address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Long personId = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Person person = new Person(personName, address);
            
            address.setPerson(person);
            session.save(person);
 
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return personId;
    }
 
    /*
     * Lists the person's from database table
     */
    public void listPersonInfo() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            @SuppressWarnings("unchecked")
            List<Person> personList = session.createQuery("from Person").list();
            for (Iterator<Person> iterator = personList.iterator(); iterator
                    .hasNext();) {
                Person person = (Person) iterator.next();
                System.out.println(person.getName());
                System.out.println(person.getAddress().getStreet() + " "
                        + person.getAddress().getCity() + " "
                        + person.getAddress().getState() + " "
                        + person.getAddress().getZipcode());
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
 
}