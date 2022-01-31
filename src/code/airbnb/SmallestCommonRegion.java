package code.airbnb;

import java.util.*;

/**
 * You are given some lists of regions where the first region of each list includes all other regions in that list.
 *
 * Naturally, if a region x contains another region y then x is bigger than y. Also, by definition, a region x contains itself.
 *
 * Given two regions: region1 and region2, return the smallest region that contains both of them.
 *
 * If you are given regions r1, r2, and r3 such that r1 includes r3, it is guaranteed there is no r2 such that r2 includes r3.
 *
 * It is guaranteed the smallest region exists.
 */
public class SmallestCommonRegion {

    public static void main(String args[]){

        String regions[][]={{"Earth","North America","South America"},
                {"North America","United States","Canada"},
                {"United States","New York","Boston"},
                {"Canada","Ontario","Quebec"},
                {"South America","Brazil"}};

        SmallestCommonRegion obj = new SmallestCommonRegion();

        System.out.println(obj.findSmallestRegion(regions,"Quebec","New York"));
        System.out.println(obj.findSmallestRegion(regions,"Canada","South America"));
    }

    /*
            The idea is very simple here. We need to get one of the region and its ancestors in a set and then check if region2 or its any of the
            parent or ancestor is present in the set. If we find a match then that is the smallest common region between region1 and region2.
            Follwing are the steps:
            1. Get the map of child-parent, Key = child, Value = parent
                This will make our life easier as iterating a map is easy than a bunch of lists
            2. We have to keep adding region1, its parent, grandparent, etc. in a set till it doesn't become null
            3. Now keep checking for region2 or its parents/ancestors in a set
            4. Wherever we find a match, that is our answer!
        */
    public String findSmallestRegion(String regions[][], String region1, String region2) {

        //creating parent map
        Map<String,String> parentMap = new HashMap<>();

        for(String region[]:regions){
            String parent = region[0];

            for(int i=1;i<region.length;i++){
                parentMap.put(region[i],parent);
            }
        }

        //storing all ancestors of region1, moving backwards
        Set<String> ancestors = new HashSet<>();
        while(region1!=null){
            ancestors.add(region1);
            region1 = parentMap.get(region1);
        }

        while(region2!=null){
            if(ancestors.contains(region2)){
                return region2;
            }
            region2 = parentMap.get(region2);
        }

        return null;
    }
}
