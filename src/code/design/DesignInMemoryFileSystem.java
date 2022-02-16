package code.design;

import java.util.*;

public class DesignInMemoryFileSystem {

    class TrieNode{
        boolean isFile;
        String contents;
        Map<String,TrieNode> children;
        TrieNode(){
            children = new TreeMap<>();
        }
    }

    TrieNode root;
    public DesignInMemoryFileSystem() {
        root = new TrieNode();
    }

    public static void main(String args[]){
        DesignInMemoryFileSystem obj = new DesignInMemoryFileSystem();
        obj.ls("/");
        obj.mkdir("/a/b/c");
        obj.addContentToFile("/a/b/c/d","hello");
        List<String> list = obj.ls("/");
        for(String str:list){
            System.out.print(str);
        }
        System.out.println(obj.readContentFromFile("/a/b/c/d"));
    }

    public List<String> ls(String path) {
        List<String> res = new ArrayList<>();
        TrieNode current = root;
        String tokens[] = path.split("/");
        for(int i=1;i<tokens.length;i++){
            if(!current.children.containsKey(tokens[i])){
                return new ArrayList<>();
            }
            current = current.children.get(tokens[i]);
        }
        if(current.isFile){
            res.add(tokens[tokens.length-1]);
        }
        else{
            List<String> keys = new ArrayList<String>(current.children.keySet());
            Collections.sort(keys);
            res.addAll(keys);
        }
        return res;
    }

    //create directory if that doesn't exists
    public void mkdir(String path) {

        String tokens[] = path.split("/");
        TrieNode current = root;
        for(int i=1;i<tokens.length;i++){
            String directoryName = tokens[i];
            if(!current.children.containsKey(directoryName)){
                current.children.put(directoryName,new TrieNode());
            }
            current = current.children.get(directoryName);
        }
    }

    public void addContentToFile(String filePath, String content) {

        String tokens[] = filePath.split("/");
        TrieNode current = root;
        for(int i=1;i<tokens.length;i++){
            String directoryName = tokens[i];
            if(!current.children.containsKey(directoryName)){
                current.children.put(directoryName,new TrieNode());
            }
            current = current.children.get(directoryName);
        }
        if(current.contents==null){
            current.contents = content;
        }
        else{
            current.contents+=content;
        }
        current.isFile = true;
    }

    public String readContentFromFile(String filePath) {

        String tokens[] = filePath.split("/");
        TrieNode current = root;
        for(int i=1;i<tokens.length;i++){
            String directoryName = tokens[i];
            if(!current.children.containsKey(directoryName)){
                return null;
            }
            current = current.children.get(directoryName);
        }

        return current.isFile ? current.contents:null;
    }
}
