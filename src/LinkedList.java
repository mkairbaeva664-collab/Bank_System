public class LinkedList {
    private Node head;

    public void addToLast(BankAccount account) {
        Node newNode = new Node(account);
        if(head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void displayAll() {
        Node current = head;
        if (current == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public BankAccount findByusername(String username) {
        Node current = head;
        while (current != null) {
            if(current.data.getUsername().equalsIgnoreCase(username)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }
}
