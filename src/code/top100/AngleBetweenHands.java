package code.top100;

//https://leetcode.com/problems/angle-between-hands-of-a-clock/solution/
//TC - O(1)
public class AngleBetweenHands {

    public double angleClock(int hour, int minutes) {

        int oneMinAngle = 6;   // 360/60
        int oneHourAngle = 30;   //360/12

        double minuteAngle = minutes*oneMinAngle;
        double hourAngle = (hour%12+minutes/60)*oneHourAngle;

        double diff = Math.abs(hourAngle-minuteAngle);

        return Math.min(diff,360-diff);
    }
}
