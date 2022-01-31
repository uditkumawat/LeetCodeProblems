package code.facebook;

/**
 * Time complexity : \mathcal{O}(H)O(H), where HH is a tree height. That results in \mathcal{O}(\log N)O(logN) in the average case, and \mathcal{O}(N)O(N) in the worst case.
 *
 * Let's compute time complexity with the help of master theorem T(N) = aT\left(\frac{N}{b}\right) + \Theta(N^d)T(N)=aT(
 * b
 * N
 * ​
 *  )+Θ(N
 * d
 *  ). The equation represents dividing the problem up into aa subproblems of size \frac{N}{b}
 * b
 * N
 * ​
 *   in \Theta(N^d)Θ(N
 * d
 *  ) time. Here at step there is only one subproblem a = 1, its size is a half of the initial problem b = 2, and all this happens in a constant time d = 0, as for the binary search. That means that \log_b{a} = dlog
 * b
 * ​
 *  a=d and hence we're dealing with case 2 that results in \mathcal{O}(n^{\log_b{a}} \log^{d + 1} N)O(n
 * log
 * b
 * ​
 *  a
 *  log
 * d+1
 *  N) = \mathcal{O}(\log N)O(logN) time complexity.
 *
 * Space complexity : \mathcal{O}(H)O(H) to keep the recursion stack, i.e. \mathcal{O}(\log N)O(logN) in the average case, and \mathcal{O}(N)O(N) in the worst case.
 */
public class InsertIntoBST {

    public static void main(String args[]){

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        InsertIntoBST obj = new InsertIntoBST();

        obj.printPreOrder(root);

        System.out.println("\nInserting 5");

        obj.insertIntoBST(root,5);

        obj.printPreOrder(root);

        System.out.println("\nInserting 6");

        obj.insertIntoBST(root,6);

        obj.printPreOrder(root);

        System.out.println("\nInserting 8");

        obj.insertIntoBST(root,8);


        obj.printPreOrder(root);
    }

    public void printPreOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root==null){
            return new TreeNode(val);
        }

        return formTree(root,val);
    }

    public TreeNode formTree(TreeNode root,int val){
        if(root==null){
            return new TreeNode(val);
        }

        if(root.val>val){
            root.left = formTree(root.left,val);
        }
        else{
            root.right = formTree(root.right,val);
        }

        return root;
    }
}
