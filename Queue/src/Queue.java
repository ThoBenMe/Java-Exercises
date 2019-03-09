public class Queue {

    private int numContacts;
    private Contact head;
    private Contact tail;

    // constructor
    public Queue() {
        head = null;
        tail = null;
        numContacts = 0;
    }

    /**
     * Enqueues an element to the list. Also checks the condition if the list is empty or not.
     *
     * @param c new element which is to be added to the list.
     */
    public void enqueue(Contact c) {
        if (numContacts == 0) {
            head = tail = c;
        } else {
            tail.setNext(c);
        }
        tail = c;
        ++numContacts;
    }

    /**
     * Deletes an element from the list.
     *
     * @return null, if deletion failed, otherwise returns the deleted element
     */
    public Contact dequeue() {
        if (numContacts > 0) {
            Contact c = head;
            head = head.getNext();
            --numContacts;
            if (numContacts == 0) {
                tail = null;
            }
            return c;
        }
        return null;
    }


    // getter
    public int getNumContacts() {
        return numContacts;
    }

    /**
     * Returns the list's tail element
     *
     * @return tail of the list
     */
    public Contact getTail() {
        return tail;
    }

    /**
     * Returns the list's head element
     *
     * @return head of the list
     */
    public Contact getHead() {
        return head;
    }

}
