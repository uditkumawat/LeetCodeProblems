package code.bloomberg;

//https://www.youtube.com/watch?v=1KgxLOlmNmw
//https://www.youtube.com/watch?v=vG-PcRVt1LU&t=465s
//TC - O(N)
//SC - O(1)
public class PopulateNextRightPointersInEachNode {

    class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode next;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode connect(TreeNode root) {
        if(root==null){
            return null;
        }

        TreeNode curr = root;
        TreeNode next = null;
        while(curr!=null){

            next = curr.left;

            while(curr!=null){

                if(curr.left!=null){
                    curr.left.next = curr.right;
                }

                if(curr.right!=null && curr.next!=null){
                    curr.right.next = curr.next.left;
                }

                curr = curr.next;
            }

            curr = next;
        }

        return root;
    }
}
