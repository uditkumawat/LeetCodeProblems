package code.top100;

//O(nlogn)
public class SortLinkedList {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String args[]){

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(7);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(3);

        ListNode finalList = sortList(l1);

        while(finalList!=null){
            System.out.print(finalList.val+" ");
            finalList = finalList.next;
        }
    }
    public static ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode mid = getMid(head);
        ListNode firstList = sortList(head);
        ListNode secondList = sortList(mid);

        return mergeList(firstList,secondList);
    }

    public static ListNode mergeList(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }

        if(l2==null){
            return l1;
        }

        ListNode head = new ListNode();
        ListNode tail = head;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tail.next = l1;
                l1=l1.next;
            }
            else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next=(l1==null)?l2:l1;

        return head.next;
    }

    public static ListNode getMid(ListNode head){
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        prev.next = null;

        return slow;
    }
}
