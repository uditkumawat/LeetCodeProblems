package code.top100;

import java.util.HashSet;

//https://www.youtube.com/watch?v=99Gw7Hezii8
public class NextClosetTime {

    public static void main(String args[]){
        String time = "19:34";

        System.out.println(nextClosestTime(time));
    }

    public static String nextClosestTime(String time){

        int minutes = Integer.parseInt(time.split(":")[0])*60;
        minutes = minutes + Integer.parseInt(time.split(":")[1]);

        System.out.println(minutes);

        HashSet<Integer> digits = new HashSet<>();
        for(char c:time.toCharArray()){
            digits.add(c-'0');
        }

        while(true){
            minutes = (minutes+1)%(24*60);

            int nextTime[] = {minutes / 60 / 10, minutes / 60 % 10,
                    minutes % 60 / 10 , minutes % 60 % 10};

            boolean isValid = true;
            for(int digit : nextTime){
                if(!digits.contains(digit)){
                    isValid = false;
                }
            }

            if(isValid){
                return String.format("%02d:%02d",minutes/60,minutes%60);
            }
        }
    }
}
