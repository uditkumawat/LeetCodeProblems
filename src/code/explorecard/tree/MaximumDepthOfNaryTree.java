package code.explorecard.tree;


public class MaximumDepthOfNaryTree {

    int maxRes;

    public static void main(String args[]){

        Node root = new Node(1);

        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);

        Node node4 = new Node(5);
        Node node5 = new Node(6);

        node1.children.add(node4);
        node1.children.add(node5);

        MaximumDepthOfNaryTree obj = new MaximumDepthOfNaryTree();
        System.out.println(obj.maxDepth(root));
    }

    public int maxDepth(Node root) {
        maxRes = 0;
        if(root==null){
            return maxRes;
        }

        maxDepthUtil(root,1);

        return maxRes;
    }

    public void maxDepthUtil(Node root,int level){
        if(root==null){
            return;
        }
        maxRes = Math.max(maxRes,level);
        for(Node child:root.children){
            maxDepthUtil(child,level+1);
        }
    }
}
