public class MyQueue {
    private QueueNode front;
    private QueueNode rear;

    public void enqueue(String bill) {
        QueueNode newNode = new QueueNode(bill);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public String dequeue() {
        if (front == null) return null;

        String bill = front.billName;
        front = front.next;

        if(front == null) rear = null;
        return bill;
    }

    public void displayQueue() {
        QueueNode current = front;
        if (current == null) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Current Queue: ");
        while (current != null) {
            System.out.println("[" + current.billName + "]");
            current = current.next;
        }
        System.out.println();
    }
}
