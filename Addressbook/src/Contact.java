public class Contact {

    private static int contactCounter;

    //attributes
    private String name;
    private long phone;
    private int id;

    //reference to the next node in chain (if there isn't: null)
    private Contact next;

    public Contact(String name){
        this.name = name;
    }

    public Contact(String name, long phone){
        this(name);
        this.phone = phone;
    }

    public String toString(){
        return "Name: " + name + ", Phone: " + phone;
    }

    public long getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public Contact getNext(){
        return next;
    }

    public void setNext(Contact next){
        this.next = next;
    }
}
