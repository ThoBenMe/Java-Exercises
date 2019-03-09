import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Year;

public class QueueTest {

    private Queue queue;
    private Contact c1;
    private Contact c2;
    private Contact c3;

    @Before
    public void setUp(){
        queue = new Queue();
        c1 = new Contact("Naruto", 12345);
        c2 = new Contact("Sasuke", 54321);
        c3 = new Contact("Sakura", 13254);
    }

    @Test
    public void testCreateQueue(){
        Assert.assertNull("Tail", queue.getTail());
        Assert.assertNull("Head", queue.getHead());
        Assert.assertEquals("Num contacts", 0, queue.getNumContacts());
    }

    @Test
    public void testEnqueue(){
        queue.enqueue(c1);
        queue.enqueue(c2);
        queue.enqueue(c3);
        Assert.assertEquals("Num Contacts", 3, queue.getNumContacts());
        Assert.assertSame(c1, queue.getHead());
        Assert.assertSame(c3, queue.getTail());
    }

    @Test
    public void testDequeue(){
        queue.enqueue(c1);
        queue.enqueue(c2);
        queue.enqueue(c3);
        Contact val = queue.dequeue();
        Assert.assertSame("Removed element", c1, val);
        Assert.assertSame("Head", c2, queue.getHead());
        Assert.assertSame("tail", c3, queue.getTail());
    }

    @Test
    public void testDequeueOneElement(){
        queue.enqueue(c1);
        Contact val = queue.dequeue();
        Assert.assertNull("Head", queue.getHead());
        Assert.assertNull("Tail", queue.getTail());
        Assert.assertEquals("Num Contacts", 0, queue.getNumContacts());
    }

    @Test(timeout = 50) // max. 50ms to create 1000 contacts
    public void testPerformance(){
        for(int i = 0; i < 1000; i++){
            Contact c = new Contact("Name"+i, i);
            queue.enqueue(c);
        }
    }

    @Test
    public void testContactCounter(){
        int before = Contact.getContactCounter();
        Contact c = new Contact("Dude", 57372);
        int after = Contact.getContactCounter();
        Assert.assertEquals("Num Contacts", 1, after-before);
    }

}
