public class RequestNode {
    AccountRequest request;
    RequestNode next;

    public RequestNode(AccountRequest request) {
        this.request = request;
        this.next = null;
    }
}
