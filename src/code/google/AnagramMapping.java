package code.google;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * You are given two integer arrays nums1 and nums2 where nums2 is an anagram of nums1. Both arrays may contain duplicates.
 *
 * Return an index mapping array mapping from nums1 to nums2 where mapping[i] = j means the ith element in nums1 appears in nums2 at index j. If there are multiple answers, return any of them.
 *
 * An array a is an anagram of an array b means b is made by randomizing the order of the elements in a.
 */
public class AnagramMapping {

    public static void main(String args[]){

        AnagramMapping obj = new AnagramMapping();
        int nums1[] = {12,28,46,32,50};
        int nums2[] = {50,12,32,46,28};

        int output[] = obj.anagramMappings(nums1,nums2);

        for(int out:output){
            System.out.print(out+" ");
        }
    }

    public int[] anagramMappings(int[] nums1, int[] nums2) {

        int n = nums1.length;

        if(nums2==null || nums2.length==0){
            return new int[0];
        }

        int output[] = new int[n];

        Map<Integer, Queue<Integer>> map = new HashMap();

        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
                map.get(nums2[i]).add(i);
            }
            else{
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                map.put(nums2[i],q);
            }
        }

        for(int i=0;i<nums1.length;i++){
            output[i] = map.get(nums1[i]).poll();
        }

        return output;
    }
}
