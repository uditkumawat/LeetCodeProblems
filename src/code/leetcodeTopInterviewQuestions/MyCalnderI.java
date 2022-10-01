package code.leetcodeTopInterviewQuestions;

import java.util.TreeMap;

//https://leetcode.com/problems/my-calendar-i/solution/
//TC - O(nlogn)
//SC - O(N)
public class MyCalnderI {

    TreeMap<Integer, Integer> calendar;

    MyCalnderI() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
