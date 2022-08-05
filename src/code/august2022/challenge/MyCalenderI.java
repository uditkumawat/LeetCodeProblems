package code.august2022.challenge;

import java.util.TreeMap;

//https://leetcode.com/problems/my-calendar-i/solution/
//TC - O(NlogN) - where N is the number of events booked
//for each event, we search that the event is legal in O(logn) time, then insert it in O(1) time
//SC - O(N), the size of map or number of evevnts stored in map
public class MyCalenderI {

    TreeMap<Integer,Integer> calendar;

    public MyCalenderI() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {

        if(calendar.floorEntry(start)!=null && start<calendar.floorEntry(start).getValue()){
            return false;
        }

        if(calendar.ceilingEntry(start)!=null && calendar.ceilingEntry(start).getKey()<end){
            return false;
        }

        calendar.put(start,end);
        return true;
    }
}
