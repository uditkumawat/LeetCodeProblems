package code.amazon;

import java.util.*;

//https://leetcode.com/problems/kill-process/
public class KillProcess {

    class TreeNode{
        int val;
        List<TreeNode> children;
        TreeNode(int val){
            this.val = val;
            children = new ArrayList<>();
        }
    }

    public static void main(String args[]){

        List<Integer> pid = Arrays.asList(1,3,10,5);
        List<Integer> ppid = Arrays.asList(3,0,5,3);
        int kill = 5;

        KillProcess obj = new KillProcess();

        List<Integer> res = obj.killProcess(pid,ppid,kill);

        System.out.println(res);

    }
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        List<Integer> res = new ArrayList<>();

        Map<Integer,TreeNode> map = new HashMap<>();

        for(int i=0;i<pid.size();i++){
            TreeNode node = new TreeNode(pid.get(i));
            map.put(pid.get(i),node);
        }

        for(int i=0;i<ppid.size();i++){

            TreeNode childNode = map.get(pid.get(i));
            TreeNode parentNode = map.get(ppid.get(i));

            if(parentNode!=null) {
                List<TreeNode> childNodes = parentNode.children;

                childNodes.add(childNode);

                map.put(ppid.get(i), parentNode);
            }
        }


        dfs(map.get(kill),res);

        return res;
    }

    public void dfs(TreeNode node,List<Integer> res){
        if(node==null){
            return;
        }

        res.add(node.val);

        for(TreeNode temp:node.children){
            dfs(temp,res);
        }
    }
}
