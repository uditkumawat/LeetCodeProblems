package code.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * Time complexity : O(N)O(N).
 *
 * Building the hashmap takes O(N)O(N) time, as there are NN nodes to add, and adding items to a hashmap has a cost of O(1)O(1), so we get N \cdot O(1) = O(N)N⋅O(1)=O(N).
 *
 * Building the tree also takes O(N)O(N) time. The recursive helper method has a cost of O(1)O(1) for each call (it has no loops), and it is called once for each of the NN nodes, giving a total of O(N)O(N).
 *
 * Taking both into consideration, the time complexity is O(N)O(N).
 *
 * Space complexity : O(N)O(N).
 *
 * Building the hashmap and storing the entire tree each requires O(N)O(N) memory. The size of the implicit system stack used by recursion calls depends on the height of the tree, which is O(N)O(N) in the worst case and O(\log N)O(logN) on average. Taking both into consideration, the space complexity is O(N)O(N).
 */
public class BinaryTreeFromPreorderInorder {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static int index = 0;

    public TreeNode buildTree(int inorder[],int preorder[]){

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return buildTreeUtil(preorder,0,preorder.length-1,map);
    }

    public TreeNode buildTreeUtil(int preorder[],int left,int right,Map<Integer,Integer> map){
        if(left>right){
            return null;
        }

        int value = preorder[index];
        TreeNode root = new TreeNode(value);
        index++;

        root.left = buildTreeUtil(preorder,left,map.get(value)-1,map);
        root.right = buildTreeUtil(preorder,map.get(value)+1,right,map);

        return root;
    }
}
