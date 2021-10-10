package code.top100;

import java.util.Arrays;

public class TaskScheduler {

    public static void main(String args[]){

        char arr[] = {'A','A','A','B','B','B'};
        int coolDown = 2;
        System.out.println(leastInterval(arr,coolDown));
    }
    public static int leastInterval(char[] tasks, int n) {
        if(tasks==null || tasks.length==0){
            return 0;
        }

        int freq[] = new int[26];
        for(char c:tasks){
            freq[c-'A']++;
        }

        Arrays.sort(freq);

        int len = tasks.length;

        int fMax = freq[25];
        int idleTime = (fMax-1)*n;

        /**
         * The idea is that if we have two tasks with the same max frequency (for instance A=3 and B=3) then when we try to place B we do not consume 3 idle slots, but 2 (f_max-1), because B overflows the last location of A:
         *
         * ["A", "B", " ", "A", "B", " ", "A", "B"].
         */
        for(int i=freq.length-2;i>=0 && idleTime>0;i--){
            idleTime-=Math.min(freq[i],fMax-1);
        }

        idleTime = Math.max(0,idleTime);

        return idleTime+len;

    }
}
