package code.leetcode.studyplan75;

import java.util.Arrays;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        for(char c:tasks){
            freq[c-'A']++;
        }

        Arrays.sort(freq);

        int freqMax = freq[25];
        int idleTime = (freqMax-1)*n;

        for(int i=freq.length-2;i>=0 && idleTime>0 ;i--){
            idleTime = idleTime - Math.min(freqMax-1,freq[i]);
        }


        idleTime = Math.max(0,idleTime);

        return idleTime+tasks.length;
    }
}
