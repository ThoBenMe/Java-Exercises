public class AddressBook {

    public static final long EMERGENCY_NUMBER = 112;

    private int numContacts;
    private Contact head;

    //constructor
    public AddressBook() {
        head = null;
        numContacts = 0;
    }

    public int getNumContacts() {
        return numContacts;
    }

    public void insertToFront(Contact c) {
        c.setNext(head);
        head = c;
        ++numContacts;
    }

    public Contact search(String name) {
        Contact current = head;
        while (current != null && !current.getName().equals(name)) {
            current = current.getNext();
        }
        return current;
    }


    public void delete(Contact c) {
        Contact current = head;
        Contact previous = null;
        while (current != c && current != null) {
            previous = current;
            current = current.getNext();
        }
        if (current != null) {
            if (previous == null) {
                head = current.getNext();
            } else {
                previous.setNext(current.getNext());
            }
            --numContacts;
        }
    }

    public void print() {
        Contact current = head;
        System.out.println(numContacts + " contacts.\n");
        while(current != null){
            System.out.println("[" + current.toString() + "]");
            current = current.getNext();
        }
        System.out.println();
    }

}

