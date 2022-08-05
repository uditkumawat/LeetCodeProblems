package code.twillio;

//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
//TC - O(N)
//SC - O(K)
public class PairOfSongsDivisibleBy60 {

    public int numPairsDivisibleBy60(int[] time) {

        if(time==null || time.length==0){
            return 0;
        }

        int k = 60;

        int n = time.length;

        int res[] = new int[k];

        for(int i=0;i<n;i++){
            res[time[i] % k]++;
        }

        int count = 0;
        count += res[0]*(res[0]-1)/2;

        count += res[k/2]*(res[k/2]-1)/2;

        for(int i=1;i<k/2;i++){
            count += res[i]*res[k-i];
        }

        return count;
    }
}
