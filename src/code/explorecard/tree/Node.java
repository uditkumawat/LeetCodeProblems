package code.explorecard.tree;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public int val;
    public List<Node> children;
    public Node(int val){
        this.val = val;
        this.children = new ArrayList<>();
    }

    public Node(int val,List<Node> children){
        this.val = val;
        this.children = children;
    }
}
