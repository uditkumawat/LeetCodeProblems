package code.top100;

//TC - O(n)
//SC - O(1)

/**
 * Time Complexity: O(N) since we process each node exactly once.
 * Space Complexity: O(1) since we don't make use of any additional data structure for traversing nodes on a particular level like the previous approach does.
 */
public class ConnectingPointersToNext {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void connectNext(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode levelStart = root;
        while(levelStart!=null){
            TreeNode curr = levelStart;
            while(curr!=null){
                if(curr.left!=null){
                    curr.left.next = curr.right;
                }
                if(curr.right!=null && curr.next!=null){
                    curr.right.next = curr.next.left;
                }

                curr = curr.next;
            }
            levelStart = levelStart.left;
        }
    }
}
