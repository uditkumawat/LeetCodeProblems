package code.top100;

import java.util.List;

//https://www.youtube.com/watch?v=-o_YDXNfRUY
public class MinTimeDifference {

    public int findMinDifference(List<String> timePoints){

        boolean bucket[] = new boolean[1440];

        for(String timePoint:timePoints){
            String t[] = timePoint.split(":");
            int hours = Integer.parseInt(t[0]);
            int minutes = Integer.parseInt(t[1]);
            int time = hours*60+minutes;
            bucket[time] = true;
        }

        int min = Integer.MAX_VALUE;
        int first = -1;
        int prev = -1;
        int curr = -1;

        for(int i=0;i<bucket.length;i++){
            if(bucket[i]){
                if(prev==-1){
                    prev = i;
                    first = i;
                }
                else{
                    curr = i;
                    min = Math.min(min,curr-prev);
                    prev = curr;
                }
            }
        }

        return Math.min(min,1440-curr+first);
    }
}
