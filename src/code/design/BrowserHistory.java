package code.design;

public class BrowserHistory {

    class DLLNode{
        String url;
        DLLNode prev;
        DLLNode next;
        DLLNode(String url){
            this.url = url;
            this.prev = null;
            this.next = null;
        }
        DLLNode(){

        }
    }


    DLLNode curr;
    public BrowserHistory(String homepage) {
        curr = new DLLNode(homepage);
    }

    public void visit(String url) {
        DLLNode temp = new DLLNode(url);
        temp.prev = curr;
        curr.next = temp;
        curr = temp;
    }

    public String back(int steps) {
        while(curr.prev!=null && steps-->0){
            curr = curr.prev;
        }
        return curr.url;
    }

    public String forward(int steps) {
        while(curr.next!=null && steps-->0){
            curr = curr.next;
        }

        return curr.url;
    }
}
