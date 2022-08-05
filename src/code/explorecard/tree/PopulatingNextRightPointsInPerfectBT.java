package code.explorecard.tree;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//TC - O(N)
//SC - O(1)
public class PopulatingNextRightPointsInPerfectBT {

    class Node{
        int val;
        Node left;
        Node right;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    public Node connect(Node root) {

        if(root==null){
            return root;
        }

        Node currentLevel = root;

        while(currentLevel.left!=null){

            Node head = currentLevel;

            while(head!=null){

                head.left.next = head.right;

                if(head.next!=null){
                    head.right.next = head.next.left;
                }

                head = head.next;
            }

            currentLevel = currentLevel.left;
        }

        return root;
    }
}
