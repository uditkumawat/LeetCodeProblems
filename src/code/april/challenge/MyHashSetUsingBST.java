package code.april.challenge;

/**
 * Time Complexity: \mathcal{O}(\log{\frac{N}{K}})O(log
 * K
 * N
 * ​
 *  ) where NN is the number of all possible values and KK is the number of predefined buckets, which is 769.
 *
 * Assuming that the values are evenly distributed, we could consider that the average size of bucket is \frac{N}{K}
 * K
 * N
 * ​
 *  .
 *
 * When we traverse the BST, we are conducting binary search, as a result, the final time complexity of each operation is \mathcal{O}(\log{\frac{N}{K}})O(log
 * K
 * N
 * ​
 *  ).
 *
 * Space Complexity: \mathcal{O}(K+M)O(K+M) where KK is the number of predefined buckets, and MM is the number of unique values that have been inserted into the HashSet.
 */
public class MyHashSetUsingBST {

    public static void main(String args[]){

        MyHashSetUsingBST set = new MyHashSetUsingBST();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        System.out.println(set.contains(1));
        System.out.println(set.contains(6));
        System.out.println(set.contains(3));
        System.out.println(set.contains(4));
        set.remove(4);
        System.out.println(set.contains(4));

    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){

        }
        TreeNode(int val){
            this.val = val;
        }
    }

    class BST{
        TreeNode root;
        BST(){
            root = null;
        }

        public TreeNode insertIntoBST(TreeNode root,int key){
            if(root==null){
                return new TreeNode(key);
            }

            if(key<root.val){
                root.left = insertIntoBST(root.left,key);
            }
            else if(key>root.val){
                root.right = insertIntoBST(root.right,key);
            }

            return root;
        }

        public TreeNode searchInBST(TreeNode root,int key){
            if(root==null || root.val==key){
                return root;
            }

            if(key<root.val){
                return searchInBST(root.left,key);
            }
            else if(key>root.val){
                return searchInBST(root.right,key);
            }
            else{
                return root;
            }
        }

        public TreeNode deleteNodeInBST(TreeNode root,int key){
            if(root==null){
                return null;
            }

            if(key<root.val){
                root.left = deleteNodeInBST(root.left,key);
            }
            else if(key>root.val){
                root.right = deleteNodeInBST(root.right,key);
            }
            else{
                if(root.left!=null && root.right!=null){
                    TreeNode node = predecessor(root.left);
                    root.val = node.val;
                    root.left = deleteNodeInBST(root.left,node.val);
                }
                else if(root.left!=null){
                    TreeNode node = predecessor(root);
                    root.val = node.val;
                    root.left = deleteNodeInBST(root.left,node.val);
                }
                else if(root.right!=null){
                    TreeNode node = sucessor(root);
                    root.val = node.val;
                    root.right = deleteNodeInBST(root.right,node.val);
                }
                else{
                    return null;
                }
            }

            return root;
        }

        private TreeNode sucessor(TreeNode root){
            root = root.right;
            while(root!=null && root.left!=null){
                root = root.left;
            }
            return root;
        }


        private TreeNode predecessor(TreeNode root){
            root = root.left;
            while(root!=null && root.right!=null){
                root = root.right;
            }
            return root;
        }

    }

    class Bucket{
        private BST tree;

        public Bucket(){
            tree = new BST();
        }

        public void insert(Integer element){
            tree.root = tree.insertIntoBST(tree.root,element);
        }

        public void remove(Integer element){
            tree.root = tree.deleteNodeInBST(tree.root,element);
        }

        public boolean containsElement(Integer element){
            if(tree.searchInBST(tree.root,element)!=null){
                return true;
            }
            return false;
        }
    }


    public final int SIZE = 31;
    public Bucket buckets[];
    public MyHashSetUsingBST() {
        buckets = new Bucket[SIZE];
        for(int i=0;i<SIZE;i++){
            buckets[i] = new Bucket();
        }
    }

    public void add(int key) {
        int bucketIndex = getBucketIndex(key);
        buckets[bucketIndex].insert(key);
    }

    public void remove(int key) {
        int bucketIndex = getBucketIndex(key);
        buckets[bucketIndex].remove(key);
    }

    public boolean contains(int key) {
        int bucketIndex = getBucketIndex(key);
        return buckets[bucketIndex].containsElement(key);
    }

    public int getBucketIndex(int key){
        return key % SIZE;
    }
}
