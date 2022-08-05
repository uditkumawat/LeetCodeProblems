package code.booking.com;

import java.util.*;

public class TwoOutOfThree {

    public static void main(String args[]){

        int nums1[] = {3,1};
        int nums2[] = {2,3};
        int nums3[] = {1,2};

        TwoOutOfThree obj = new TwoOutOfThree();

        System.out.println(obj.twoOutOfThree(nums1,nums2,nums3));

    }
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

        List<Integer> res = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        addElements(map,nums1,1);
        addElements(map,nums2,2);
        addElements(map,nums3,3);

        for(Map.Entry<Integer,Set<Integer>> entry:map.entrySet()){
            if(entry.getValue().size()>1){
                res.add(entry.getKey());
            }
        }

        return res;
    }

    private void addElements(Map<Integer,Set<Integer>> map,int arr[],int index){
        for(int num:arr){
            Set<Integer> set = map.getOrDefault(num,new HashSet<Integer>());
            set.add(index);
            map.put(num,set);
        }
    }
}
