public class QueueNode {
    String billName;
    QueueNode next;

    public QueueNode(String billName) {
        this.billName = billName;
        this.next = null;
    }
}
