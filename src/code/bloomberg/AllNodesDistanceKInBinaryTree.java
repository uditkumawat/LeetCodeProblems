package code.bloomberg;

import code.facebook.TreeNode;

import java.util.*;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solution/
//TC - O(N)
//SC - O(N)
public class AllNodesDistanceKInBinaryTree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> res = new ArrayList<>();

        if(root==null){
            return res;
        }

        Map<TreeNode,TreeNode> parentMap = new HashMap();
        dfs(root,null,parentMap);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet();
        int dist = 0;

        q.add(target);
        visited.add(target);

        while(!q.isEmpty()){
            int size = q.size();

            if(dist==k){
                while(!q.isEmpty()){
                    res.add(q.poll().val);
                }
            }
            else{
                for(int i=0;i<size;i++){
                    TreeNode node = q.poll();

                    if(!visited.contains(node.left) && node.left!=null){
                        visited.add(node.left);
                        q.add(node.left);
                    }

                    if(!visited.contains(node.right) && node.right!=null){
                        visited.add(node.right);
                        q.add(node.right);
                    }

                    TreeNode parent = parentMap.get(node);
                    if(!visited.contains(parent) && parent!=null){
                        visited.add(parent);
                        q.add(parent);
                    }
                }
            }
            dist++;
        }
        return res;
    }

    public void dfs(TreeNode child,TreeNode parent,Map<TreeNode,TreeNode> parentMap){
        if(child==null){
            return;
        }
        parentMap.put(child,parent);
        dfs(child.left,child,parentMap);
        dfs(child.right,child,parentMap);
    }
}
