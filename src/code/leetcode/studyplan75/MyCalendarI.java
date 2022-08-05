package code.leetcode.studyplan75;

import java.util.TreeMap;

//https://www.youtube.com/watch?v=CC7rHLWbYqQ
//TC - O(N)
//SC - O(1)
public class MyCalendarI {

    TreeMap<Integer,Integer> calendar;

    public MyCalendarI() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {

        if(calendar.floorEntry(start)!=null && start<calendar.floorEntry(start).getValue()){
            return false;
        }

        if(calendar.ceilingEntry(start)!=null && end>calendar.ceilingEntry(start).getKey()){
            return false;
        }

        calendar.put(start,end);
        return true;
    }
}
