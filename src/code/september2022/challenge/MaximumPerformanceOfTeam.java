package code.september2022.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/maximum-performance-of-a-team/submissions/
//https://www.youtube.com/watch?v=V-TuDMMf-S4
//TC - O(nlogn)
//SC - O(n)
public class MaximumPerformanceOfTeam {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {


        class Engineer{

            int speed;
            int eff;

            Engineer(int speed,int eff){
                this.speed = speed;
                this.eff = eff;
            }
        }

        List<Engineer> list = new ArrayList();
        for(int i=0;i<speed.length;i++){
            list.add(new Engineer(speed[i],efficiency[i]));
        }

        Collections.sort(list,(Engineer e1, Engineer e2)->{
            return e2.eff-e1.eff;
        });

        //creating min heap which will remove slow speed guy first
        PriorityQueue<Engineer> currentTeam = new PriorityQueue<Engineer>((e1, e2)->{
            return e1.speed-e2.speed;
        });

        long maxPerformance = 0;
        long teamSpeed = 0;

        for(int i=0;i<list.size();i++){

            //removing slow speed guy
            if(currentTeam.size()==k){

                Engineer slowGuy = currentTeam.poll();

                teamSpeed = teamSpeed - slowGuy.speed;
            }

            currentTeam.add(list.get(i));

            teamSpeed = teamSpeed + list.get(i).speed;

            int eff = list.get(i).eff;

            long performance = teamSpeed * (long)eff;

            maxPerformance = Math.max(maxPerformance,performance);
        }

        return (int)(maxPerformance%1000000007);
    }
}
