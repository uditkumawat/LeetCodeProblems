package code.leetcode.studyplan75;

import code.facebook.TreeNode;

import java.util.*;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
//TC - O(N)
//SC - O(N)
public class AllNodesAtDistanceKInBinaryTree {

    Map<TreeNode,TreeNode> map = null;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        map = new HashMap();
        List<Integer> res = new ArrayList();
        if(root==null){
            return res;
        }


        createParentMap(root,null);

        Queue<TreeNode> q = new LinkedList();
        q.add(target);
        Set<TreeNode> visited = new HashSet();
        visited.add(target);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){

                TreeNode node = q.poll();

                if(k==0){
                    res.add(node.val);
                }
                if(k<0){
                    return res;
                }

                if(node.left!=null && !visited.contains(node.left)){
                    q.add(node.left);
                    visited.add(node.left);
                }

                if(node.right!=null && !visited.contains(node.right)){
                    q.add(node.right);
                    visited.add(node.right);
                }

                if(map.containsKey(node) && map.get(node)!=null && !visited.contains(map.get(node))){
                    q.add(map.get(node));
                    visited.add(map.get(node));
                }
            }
            k--;
        }

        return res;
    }

    public void createParentMap(TreeNode root,TreeNode parent){

        if(root==null){
            return;
        }

        map.put(root,parent);
        createParentMap(root.left,root);
        createParentMap(root.right,root);
    }
}
