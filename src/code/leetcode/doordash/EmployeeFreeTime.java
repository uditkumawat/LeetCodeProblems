package code.leetcode.doordash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//TC - O(klogk)     k is the number of intervals
//SC - O(k)      worst case, no overlapping intervals
public class EmployeeFreeTime {

    static class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }

        public String toString(){
            return start+" "+end;
        }
    };

    public static void main(String args[]){
             Interval i1 = new   Interval(1,3);
             Interval i2 = new   Interval(6,7);
             Interval i3 = new   Interval(2,4);
             Interval i4 = new   Interval(2,5);
             Interval i5 = new   Interval(9,12);
           List<List<  Interval>> list = new ArrayList<>();
           List<  Interval> list1 = new ArrayList<>();
           list1.add(i1);
           List<  Interval> list2 = new ArrayList<>();
           list1.add(i2);
           List<  Interval> list3 = new ArrayList<>();
           list1.add(i3);
           List<  Interval> list4 = new ArrayList<>();
           list1.add(i4);
           List<  Interval> list5 = new ArrayList<>();
           list1.add(i5);

        
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);


        List<Interval> freeIntervals = getEmployeeFreeTime(list);
        for(Interval interval:freeIntervals){
            System.out.println(interval);
        }
    }
    
    public static List<Interval> getEmployeeFreeTime(List<List<Interval>> employeeTime){

        List<Interval> res = new ArrayList<>();

        if(employeeTime==null || employeeTime.size()==0){
            return res;
        }

           //this should be sorted based on interval start time only
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>((a,b)->{return a.start==b.start?a.end-b.end:a.start-b.start;});

        for(List<Interval> intervals:employeeTime){
            for(Interval interval:intervals){
                pq.add(interval);
            }
        }

        if(pq.isEmpty()){
            return res;
        }

        Interval prev = pq.poll();

        while(!pq.isEmpty()){
            Interval curr = pq.poll();
            System.out.println("prev "+prev+" "+"curr "+" "+curr);
            if(prev.end<curr.start){
                res.add(new Interval(prev.end,curr.start));
            }
            else{
                curr.end = Math.max(prev.end,curr.end);
            }
            prev = curr;
        }

        return res;
    }
}
