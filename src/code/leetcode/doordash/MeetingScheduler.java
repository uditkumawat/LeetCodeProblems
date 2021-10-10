package code.leetcode.doordash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time complexity: O(M \log M + N \log N)O(MlogM+NlogN), when MM is the length of slots1 and NN is the length of slots2.
 *
 * Sorting both arrays would take O(M \log M + N \log N)O(MlogM+NlogN). The two pointers take O(M + N)O(M+N) because, during each iteration, we would visit a new element, and there are a total of M+NM+N elements. Putting these together, the total time complexity is O(M \log M + N \log N)O(MlogM+NlogN).
 *
 * Space complexity: O(1)O(1). This is because we do not use any additional data structures; we only use a few fixed-size integer variables.Time complexity: O(M \log M + N \log N)O(MlogM+NlogN), when MM is the length of slots1 and NN is the length of slots2.
 *
 * Sorting both arrays would take O(M \log M + N \log N)O(MlogM+NlogN). The two pointers take O(M + N)O(M+N) because, during each iteration, we would visit a new element, and there are a total of M+NM+N elements. Putting these together, the total time complexity is O(M \log M + N \log N)O(MlogM+NlogN).
 *
 * Space complexity: O(1)O(1). This is because we do not use any additional data structures; we only use a few fixed-size integer variables.
 */
public class MeetingScheduler {

    public static void main(String args[]){

        int slots1[][] = {{10,50},{60,120},{140,120}};
        int slots2[][] = {{0,15},{60,70}};
        int duration = 8;
        List<Integer> list = minAvailableDuration(slots1,slots2,duration);

        for(int i:list){
            System.out.print(i+" ");
        }
    }

    public static List<Integer> minAvailableDuration(int slots1[][], int slots2[][], int duration){

        //Note that sorting by the start time vs the end time is the same, this is because, if a time slot starts earlier, it will end earlier. Remember that for both people, there're no overlapping time slots
        Arrays.sort(slots1,(a,b)->a[0]-b[0]);
        Arrays.sort(slots2,(a,b)->a[0]-b[0]);

        int p1 = 0;
        int p2 = 0;

        while(p1<slots1.length && p2<slots2.length){

            int intersectLeft = Math.max(slots1[p1][0],slots2[p2][0]);
            int intersectRight = Math.min(slots1[p1][1],slots2[p2][1]);

            if(intersectRight-intersectLeft>=duration){
                return new ArrayList<>(Arrays.asList(intersectLeft,intersectLeft+duration));
            }

            if(slots1[p1][1]>slots2[p2][1]){
                p2++;
            }else{
                p1++;
            }
        }

        return new ArrayList<>();
    }
}
