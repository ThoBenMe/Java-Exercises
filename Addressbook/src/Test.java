public class Test {

    // array of 3 contacts
    private static Contact[] contacts;
    // address book
    private static AddressBook addressbook;

    private static void setup() {
        // generate  3 contacts
        contacts = new Contact[3];
        contacts[0] = new Contact("Durzo", 31232);
        contacts[1] = new Contact("Kylar", 83882);
        contacts[2] = new Contact("Azoth", 29399);

        // generate an address book
        addressbook = new AddressBook();

        // TEST1: add contacts using insertToFront in the following order: Berger, Huber, Maier
        for (Contact c : contacts) {
            addressbook.insertToFront(c);
        }

    }

    // TEST1: check if contacts are in correct order
    private static void test1() {
        setup();

        System.out.println("After insertToFront, addressbook entries are in the following order: ");
        System.out.print(  "Result:     "); addressbook.print();
        System.out.println("Expected:   3 contacts[Durzo-29399][Kylar-83882][Azoth-31232]");
        System.out.println();

    }

    // TEST2: find contact that is contained in address book
    private static void test2() {
        setup();
        System.out.print("Searching for phone number of Durzo -> ");
        Contact foundContact = addressbook.search("Durzo");
        if (foundContact != null) {
            System.out.print("Found: " + foundContact.getPhone());
        }
        else {
            System.out.print("Not found");
        }
        System.out.println(" (Exptected: Found)\n");
    }

    // TEST3: find a contact that is NOT contained in address book
    private static void test3() {
        setup();

        System.out.print("Searching for phone number of Azoth -> ");
        Contact foundContact = addressbook.search("Kylar");
        if (foundContact != null) {
            System.out.print("Found: " + foundContact.getPhone());
        } else {
            System.out.print("Not found");
        }
        System.out.println(" (Expected: Not Found)\n");


    }

    // TEST4: delete contact at the end of the list;
    private static void test4() {
        setup();

        addressbook.delete(contacts[0]);
        System.out.print("After removing Durzo: ");
        addressbook.print();
    }


    public static void main(String[] args) {

        // print emergency number without generating a class
        System.out.println("The emergency number is: " + AddressBook.EMERGENCY_NUMBER + "\n");

        test1();
        test2();
        test3();
        test4();



    }


}
