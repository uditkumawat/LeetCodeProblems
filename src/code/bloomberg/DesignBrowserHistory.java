package code.bloomberg;

//TC - O(N)
//https://leetcode.com/problems/design-browser-history/
public class DesignBrowserHistory {

    class DLLNode{
        String url;
        DLLNode prev;
        DLLNode next;
        DLLNode(String url){
            this.url = url;
        }
    }

    DLLNode curr;
    public DesignBrowserHistory(String homepage) {
        curr = new DLLNode(homepage);
    }

    public void visit(String url) {
        DLLNode newNode = new DLLNode(url);
        curr.next = newNode;
        newNode.prev = curr;
        curr = newNode;
    }

    public String back(int steps) {
        while(curr.prev!=null && steps>0){
            curr = curr.prev;
            steps--;
        }
        return curr.url;
    }

    public String forward(int steps) {
        while(curr.next!=null && steps>0){
            curr = curr.next;
            steps--;
        }
        return curr.url;
    }
}
