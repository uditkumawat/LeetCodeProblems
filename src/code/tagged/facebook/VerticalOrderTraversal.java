package code.tagged.facebook;

import code.facebook.BinaryTreeVerticalOrderTraversal;
import code.facebook.TreeNode;
import com.apple.laf.AquaEditorPaneUI;

import java.util.*;

//https://leetcode.com/problems/binary-tree-vertical-order-traversal/discuss/76463/Using-HashMapBFS-Java-Solution
//TC - O(N)
//SC - O(N)
public class VerticalOrderTraversal {

    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeVerticalOrderTraversal obj = new BinaryTreeVerticalOrderTraversal();

        List<List<Integer>> res = obj.verticalOrder(root);

        for(List<Integer> list:res){
            System.out.println(list);
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root){

        List<List<Integer>> res = new ArrayList<>();

        Map<Integer,List<Integer>> map = new HashMap();
        int startingValue = 0;
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode,Integer> widthMap = new HashMap<>();
        q.add(root);
        widthMap.put(root,0);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            int width = widthMap.get(node);

            List<Integer> list = map.getOrDefault(width,new ArrayList<>());
            list.add(node.val);
            map.put(width,list);

            if(node.left!=null){
                widthMap.put(node.left,width-1);
                q.add(node.left);
            }

            if(node.right!=null){
                widthMap.put(node.right,width+1);
                q.add(node.right);
            }

            startingValue = Math.min(startingValue,width);
        }

        while(map.containsKey(startingValue)){
            res.add(map.get(startingValue++));
        }

        return res;
    }
}
