package code.facebook;

//https://www.youtube.com/watch?v=JpU9T3BPLlo
public class LinkedListCycleII {

    public static void main(String args[]){

        ListNode head = new ListNode(3);

        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        LinkedListCycleII obj = new LinkedListCycleII();

        ListNode node = obj.detectCycle(head);

        if(node!=null){
            System.out.println(node.val);
        }
    }
    public ListNode detectCycle(ListNode head) {

        if(head==null){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        boolean cycleDetected = false;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                System.out.println("Cycle detected");
                cycleDetected = true;
                break;
            }
        }

        if(!cycleDetected){
            return null;
        }

        System.out.println("slow " + slow.val);
        System.out.println("fast " + fast.val);

        slow = head;

        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
}
