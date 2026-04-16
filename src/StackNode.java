public class StackNode {
    String transaction;
    StackNode next;

    public StackNode(String transaction) {
        this.transaction = transaction;
        this.next = null;
    }
}
