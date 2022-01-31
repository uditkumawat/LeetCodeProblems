package code.airbnb;

import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem {

    class FileSystem {

        class TrieNode{
            String name;
            int val;
            Map<String,TrieNode> map;
            TrieNode(String name){
                this.name = name;
                this.val = -1;
                this.map = new HashMap<>();
            }
        }

        TrieNode root;
        public FileSystem() {
            this.root = new TrieNode("");
        }

        public boolean createPath(String path, int value) {
            TrieNode current = root;
            String components[] = path.split("/");

            for(int i=0;i<components.length;i++){
                String component = components[i];
                if(current.map.containsKey(component)==false){
                    if(i==components.length-1){
                        current.map.put(component,new TrieNode(component));
                    }
                    else{
                        return false;
                    }
                }

                current = current.map.get(component);
            }

            if(current.val!=-1){
                return false;
            }

            current.val = value;
            return true;
        }

        public int get(String path) {

            String components[] = path.split("/");

            TrieNode current = root;

            for(int i=0;i<components.length;i++){

                String component = components[i];

                if(current.map.containsKey(component)==false){
                    return -1;
                }

                current = current.map.get(component);
            }

            return current.val;
        }
    }

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
}
