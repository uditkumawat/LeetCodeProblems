package code.top100;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(6,7);
        Interval i3 = new Interval(2,4);
        Interval i4 = new Interval(2,5);
        Interval i5 = new Interval(9,12);

        List<List<Interval>> list = new ArrayList<>();
        List<Interval> list1 = new ArrayList<>();
        list1.add(i1);
        List<Interval> list2 = new ArrayList<>();
        list1.add(i2);
        List<Interval> list3 = new ArrayList<>();
        list1.add(i3);
        List<Interval> list4 = new ArrayList<>();
        list1.add(i4);
        List<Interval> list5 = new ArrayList<>();
        list1.add(i5);

        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);

        List<Interval> freeIntervals = employeeFreeTime(list);
        for(Interval interval:freeIntervals){
            System.out.println(interval);
        }
    }
    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        if(schedule==null || schedule.size()==0){
            return new ArrayList<>();
        }

        List<Interval> list = new ArrayList<>();

        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b)->{return a.start!=b.start?a.start-b.start:a.end-b.end;});

        for(List<Interval> intervals:schedule){
            for(Interval interval:intervals){
                pq.offer(interval);
            }
        }

        Interval pre = pq.poll();

        while(!pq.isEmpty()){
            Interval curr = pq.poll();

            if(pre.end<curr.start){
                list.add(new Interval(pre.end,curr.start));
            }
            else{
                curr.end = Math.max(curr.end,pre.end);
            }

            pre = curr;
        }

        return list;
    }
}
