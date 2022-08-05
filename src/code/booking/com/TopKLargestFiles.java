package code.booking.com;

import java.util.*;

/**
 * Find the top K largest files when you are given three apis and root path:
 *
 * boolean isFolder();
 * List<String> listFiles(String path);
 * double size(String path);
 *
 * // function to complete
 * List<String> topKLargestFiles(String root){
 *
 * }
 */
public class TopKLargestFiles {

    public static void main(String args[]){

        TopKLargestFiles obj = new TopKLargestFiles();
        int k = 3;


    }

    public List<String> getTopKLargest(String paths[],int k){

        List<String> res = new ArrayList<>();
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<Map.Entry<String,Integer>>((entry1, entry2)->{
            return entry1.getValue()-entry2.getValue();
        });

        Map<String,Integer> map = new HashMap<>();

        for(String path:paths){
            int size = getSize(path);
            map.put(path,size);
        }

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            pq.add(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
            res.add(pq.poll().getKey());
        }

        return res;
    }

    private int getSize(String path){

        int size = 0;
        /**
         * if(path.isFolder()){
         *      for(String filePath:listFiles(path)){
         *          size = size + getSize(filePath);
         *
         *      }
         * }
         * else{
         *
         *     size  = size + size(path);
         * }
         */

        return size;
    }
}
