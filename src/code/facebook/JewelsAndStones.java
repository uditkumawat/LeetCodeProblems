package code.facebook;


import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
 *
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
//TC - O(s.length + j.length)
//SC - O(j.length) Hashset
public class JewelsAndStones {

    public static void main(String args[]){
        JewelsAndStones obj = new JewelsAndStones();

        String jewels = "aA";
        String stones = "aAAbbbb";

        System.out.println(obj.countJewels(jewels,stones));
    }

    public int countJewels(String jewels,String stones){
        Set<Character> set = new HashSet<>();

        if(stones==null || stones.length()==0){
            return 0;
        }

        for(char c:jewels.toCharArray()){
            set.add(c);
        }

        int count = 0;

        for(char c:stones.toCharArray()){
            if(set.contains(c)){
                count++;
            }
        }

        return count;
    }
}
