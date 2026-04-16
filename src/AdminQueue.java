import java.awt.desktop.QuitEvent;

public class AdminQueue {
    private RequestNode front;
    private RequestNode rear;

    public void enqueueRequest(String name, double balance) {
        AccountRequest newReq = new AccountRequest(name, balance);
        RequestNode newNode = new RequestNode(newReq);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public AccountRequest dequeueRequest() {
        if (front == null) return null;
        AccountRequest req = front.request;
        front = front.next;
        if (front == null) rear = null;
        return req;
    }

    public void displayPending() {
        RequestNode current = front;
        if (current == null) {
            System.out.println("No pending requests");
            return;
        }
        System.out.println("Pending Requests:");
        while (current != null) {
            System.out.println("- User: " + current.request.username);
            current = current.next;
        }
    }
}
