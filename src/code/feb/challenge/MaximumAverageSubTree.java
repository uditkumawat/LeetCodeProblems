package code.feb.challenge;

import code.facebook.TreeNode;
//https://leetcode.com/problems/maximum-average-subtree/solution/
public class MaximumAverageSubTree {

    class State{
        int nodeCount;
        int valueSum;
        double average;
        State(int nodeCount,int valueSum,double average){
            this.nodeCount = nodeCount;
            this.valueSum = valueSum;
            this.average = average;
        }
    }

    public static void main(String args[]){

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);

        MaximumAverageSubTree obj = new MaximumAverageSubTree();
        System.out.println(obj.maximumAverageSubtree(root));

    }
    public double maximumAverageSubtree(TreeNode root) {
        return maxAverage(root).average;
    }

    public State maxAverage(TreeNode root){
        if(root==null){
            return new State(0,0,0);
        }

        State left = maxAverage(root.left);
        State right = maxAverage(root.right);

        int nodeCount = left.nodeCount + right.nodeCount + 1;
        int valueSum = left.valueSum + right.valueSum + root.val;

        double average = Math.max((1.0 * valueSum)/nodeCount,Math.max(left.average,right.average));

        return new State(nodeCount,valueSum,average);
    }
}
