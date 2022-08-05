package code.april.challenge;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/design-file-system/
//TC - O(Length of string)
public class FileSystem {

    Map<String,Integer> pathMap;
    public FileSystem() {
        pathMap = new HashMap();
    }

    public static void main(String args[]){

        FileSystem obj = new FileSystem();

        System.out.println(obj.createPath("/leet",1));
        System.out.println(obj.createPath("/leet/code",2));
        System.out.println(obj.get("/leet/code"));
        System.out.println(obj.createPath("/c/d",1));
        System.out.println(obj.get("/c"));

    }


    public boolean createPath(String path, int value) {
        String paths[] = path.split("/");
        for(int i=1;i<paths.length;i++){
            if(i==paths.length-1){
                pathMap.put(paths[i],value);
            }
            else{
                if(!pathMap.containsKey(paths[i])){
                    return false;
                }
            }
        }

        return true;
    }

    public int get(String path) {
        String paths[] = path.split("/");
        String lastPath = paths[paths.length-1];
        if(pathMap.containsKey(lastPath)) {
            return pathMap.get(lastPath);
        }
        else{
            return -1;
        }
    }
}
