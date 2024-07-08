public class CellPhone {
    public String model = "Unknown";
    public int cnCount;
    public String[] contacts = new String[3];
    public int i = 0;

    public void storeContact(String a) {
        if (cnCount == contacts.length) {
            System.out.println("Memory full. New contact can't be stored.");
        } else {
            contacts[i] = a;
            System.out.println("Contact Stored");
            i++;
            cnCount++;
        }
    }

    public void printDetails() {
        System.out.println("Phone Model: " + model);
        System.out.println("Contacts Stored: " + cnCount);
        if (cnCount > 0) {
            System.out.println("Stored contacts: ");
            for (int i = 0; i < cnCount; i++) {
                System.out.println(contacts[i]);
            }
        }
    }
}