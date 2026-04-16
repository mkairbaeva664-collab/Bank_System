public class Stack {
    private StackNode top;

    public void push(String action) {
        StackNode newNode = new StackNode(action);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (top == null) return null;
        String action = top.transaction;
        top = top.next;
        return action;
    }

    public String peek() {
        if (top == null) return "No transaction yet.";
        return top.transaction;
    }

    public void displayHistory() {
        StackNode current = top;
        if (current == null) {
            System.out.println("History is empty");
            return;
        }
        while (current != null) {
            System.out.println("- " + current.transaction);
            current = current.next;
        }
    }
}
