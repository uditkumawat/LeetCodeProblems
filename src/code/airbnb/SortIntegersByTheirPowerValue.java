package code.airbnb;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortIntegersByTheirPowerValue {

    Map<Integer,Integer> map;
    SortIntegersByTheirPowerValue(){
       map = new HashMap<>();
        init();
    }

    public static void main(String args[]){

        SortIntegersByTheirPowerValue obj = new SortIntegersByTheirPowerValue();
        int k = 2;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
           if(a[1]==b[1]){
               return a[0]-b[0];
           }
           else{
               return a[1]-b[1];
           }
        });

        for(Map.Entry<Integer,Integer> entry:obj.map.entrySet()){
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }

        while(!pq.isEmpty() && k-->=0){
            pq.poll();
        }

        System.out.println(pq.poll()[0]);
    }

    public void init(){
        for(int i=1;i<1001;i++){
            map.put(i,getPowerValue(i));
        }
    }

    public int getKth(int lo, int hi, int k) {

        return -1;
    }

    public int getPowerValue(int num){
        if(num==1){
            return 0;
        }
        if(map.containsKey(num)){
            return map.get(num);
        }
        int moves = 0;
        if(num%2==0){
            moves+=getPowerValue(num/2)+1;
        }
        else{
            moves+=getPowerValue(3*num+1)+1;
        }

        return moves;
    }
}
