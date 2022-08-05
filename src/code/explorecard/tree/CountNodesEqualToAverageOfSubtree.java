package code.explorecard.tree;

import code.facebook.TreeNode;

public class CountNodesEqualToAverageOfSubtree {

    class Info{
        int sum;
        int count;
        Info(int sum,int count){
            this.sum = sum;
            this.count = count;
        }
    }

    public static void main(String args[]){

        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(8);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(1);
        node.right.right = new TreeNode(6);

        CountNodesEqualToAverageOfSubtree obj = new CountNodesEqualToAverageOfSubtree();

        System.out.println(obj.averageOfSubtree(node));


    }
    int counter;
    public int averageOfSubtree(TreeNode root) {

        counter = 0;

        if(root==null){
            return 0;
        }

        countNodes(root);

        return counter;
    }

    public Info countNodes(TreeNode root){
        if(root==null){
            return null;
        }

        Info left = countNodes(root.left);
        Info right = countNodes(root.right);

        int sumLeftRight = 0;
        int countLeftRight = 0;
        if(left!=null){
            sumLeftRight = left.sum;
            countLeftRight = left.count;
        }
        if(right!=null){
            sumLeftRight += right.sum;
            countLeftRight += right.count;
        }

        int totalSum = root.val+sumLeftRight;
        int totalCount = countLeftRight+1;
        int average = totalSum/totalCount;
        if(average==root.val){
            counter++;
        }

        return new Info(totalSum,totalCount);
    }
}
