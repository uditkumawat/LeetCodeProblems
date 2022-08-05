package code.dp;

//https://leetcode.com/problems/best-sightseeing-pair/
//TC - O(N)
//SC - O(1)
public class BestSightSeeingPair {

    public static void main(String args[]){

        int values[] = {8,1,5,2,6};

        BestSightSeeingPair obj = new BestSightSeeingPair();

        System.out.println(obj.maxScoreSightseeingPair(values));
    }
    public int maxScoreSightseeingPair(int[] a) {

        int max_so_far = a[0];
        int result = 0;
        for(int i=1;i<a.length;i++){
            result = Math.max(result, max_so_far + a[i] - i);
            max_so_far = Math.max(max_so_far, a[i] + i);
        }
        return result;

    }
}
