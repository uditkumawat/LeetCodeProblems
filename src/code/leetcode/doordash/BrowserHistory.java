package code.leetcode.doordash;

//TC - O(steps)
//SC - O(Number of websites visited)
public class BrowserHistory {

    public static void main(String args[]){
        BrowserHistory obj = new BrowserHistory("google.com");
        obj.visit("youtube.com");
        obj.visit("google.ca");
        obj.visit("youtube.ca");
        System.out.println(obj.back(1));
        System.out.println(obj.back(2));

    }
    class Node{
        String url;
        Node prev;
        Node next;
        Node(String url){
            this.url = url;
        }
    }

    Node head,curr;
    public BrowserHistory(String homepage) {
        Node node = new Node(homepage);
        head = node;
        curr = head;
    }

    public void visit(String url) {
        Node node = new Node(url);
        curr.next = node;
        node.prev = curr;
        curr = node;
    }

    public String back(int steps) {
        while(curr!=null && steps-->0){
            curr = curr.prev;
        }
        return curr.url;
    }

    public String forward(int steps) {
        while(curr!=null && steps-->0){
            curr = curr.next;
        }
        return curr.url;
    }
}
