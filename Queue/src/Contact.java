public class Contact {

    // attributes
    private static int contactCounter = 0;
    private String name;
    private long phone;
    private int id;

    // list element 'next'
    private Contact next;

    // constructors
    public Contact(String name){
        contactCounter++;
        id = contactCounter;
        this.name = name;
        this.next = null;
        this.phone = 0;
    }

    public Contact(String name, long phone){
        this(name);
        this.phone = phone;
    }

    /**
     * Creates a string out of given variables.
     *
     * @return a string containing name and phone.
     */
    public String toString(){
        return "Name: " + name + ", Phone: " + phone;
    }

    // getter
    public static int getContactCounter(){
        return contactCounter;
    }

    public long getPhone(){
        return phone;
    }

    public String getName(){
        return name;
    }

    public Contact getNext(){
        return next;
    }

    // setter
    public void setNext(Contact next){
        this.next = next;
    }

}
