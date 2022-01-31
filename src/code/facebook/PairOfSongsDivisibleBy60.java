package code.facebook;

import java.util.Arrays;

//https://www.youtube.com/watch?v=toYgBIaUdfM&t=1056s
//TC - O(N)
//SC - O(N)
public class PairOfSongsDivisibleBy60 {

    public static void main(String args[]){

        int time[] = {30,20,150,100,40};

        PairOfSongsDivisibleBy60 obj = new PairOfSongsDivisibleBy60();

        System.out.println(obj.numPairsDivisibleBy60(time));
    }
    public int numPairsDivisibleBy60(int[] time) {

        int freq[] = new int[60];

        Arrays.fill(freq,0);

        for(int t:time){
            freq[t%60]++;
        }

        int count = 0;

        for(int i=1;i<=29;i++){
            count+=freq[i]*freq[60-i];
        }

        count+=freq[0]*(freq[0]-1)/2;

        count+=freq[30]*(freq[30]-1)/2;

        return count;

    }
}
