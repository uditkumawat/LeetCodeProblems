package code.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WeightedJobScheduling {

    static class Event{
        int startTime;
        int endTime;
        int profit;
        Event(int startTime,int endTime,int profit){
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
        public int getEndTime(){
            return endTime;
        }
    }

    public static void main(String args[]){

        int startTime[] = {1,1,1};
        int endTime[] = {2,3,4};
        int profit[] = {5,6,4};

        System.out.println(getMaxProfit(startTime,endTime,profit));

    }

    public static int getMaxProfit(int startTime[],int endTime[],int profit[]) {

        int n = startTime.length;
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            events.add(new Event(startTime[i], endTime[i], profit[i]));
        }

        Collections.sort(events, (a, b) -> a.getEndTime() - b.getEndTime());

        int dp[] = new int[n];

        dp[0] = events.get(0).profit;

        for (int i = 1; i < n; i++) {
            int including = events.get(i).profit;
            int last = -1;
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (events.get(mid).endTime <= events.get(i).startTime) {
                    last = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            if (last != -1) {
                including = including + dp[last];
            }

            int exluding = dp[i - 1];

            dp[i] = Math.max(exluding, including);
        }

        return dp[n - 1];
    }
}
