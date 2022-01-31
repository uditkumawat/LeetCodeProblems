package code.linkedin;

import java.util.*;

/**
 * 244. Shortest Word Distance II
 */
public class ShortestWordDistanceII {

    public Map<String, ArrayList<Integer>> locations;

    public static void main(String args[]){
        String arr[] = {"abc","def","ghi"};
        ShortestWordDistanceII obj = new ShortestWordDistanceII(arr);
        int shortestDistance = obj.shortest("abc","ghi");

        System.out.println(shortestDistance);
    }

    public ShortestWordDistanceII(String[] wordsDict) {

        this.locations = new HashMap<String, ArrayList<Integer>>();

        for(int i=0;i<wordsDict.length;i++){
            ArrayList<Integer> loc = this.locations.getOrDefault(wordsDict[i],new ArrayList<>());
            loc.add(i);
            this.locations.put(wordsDict[i],loc);
        }
    }

    public int shortest(String word1, String word2) {

        ArrayList<Integer> loc1,loc2;

        loc1 = this.locations.get(word1);
        loc2 = this.locations.get(word2);

        int l1=0,l2=0,minDistance=Integer.MAX_VALUE;

        while(l1<loc1.size() && l2<loc2.size()){
            minDistance = Math.min(minDistance,Math.abs(loc1.get(l1)-loc2.get(l2)));
            if(loc1.get(l1)<loc2.get(l2)){
                l1++;
            }
            else{
                l2++;
            }
        }

        return minDistance;
    }
}
