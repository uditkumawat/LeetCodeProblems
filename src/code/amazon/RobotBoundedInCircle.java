package code.amazon;

//https://leetcode.com/problems/robot-bounded-in-circle/
//https://www.youtube.com/watch?v=RNCRxxQx44I
public class RobotBoundedInCircle {

    public static void main(String args[]){

        String str = "GG";

        RobotBoundedInCircle obj = new RobotBoundedInCircle();

        System.out.println(obj.isRobotBounded(str));
    }
    public boolean isRobotBounded(String instructions) {

        int x = 0;
        int y = 0;

        String dir = "N";

        for(char c:instructions.toCharArray()){
            if(c=='G'){
                if("N".equals(dir)){
                    y++;
                }
                else if("S".equals(dir)){
                    y--;
                }
                else if("E".equals(dir)){
                    x++;
                }
                else{
                    x--;
                }
            }
            else if(c=='L'){
                if("N".equals(dir)){
                    dir="W";
                }
                else if("S".equals(dir)){
                    dir="E";
                }
                else if("E".equals(dir)){
                    dir="N";
                }
                else{
                    dir="S";
                }
            }
            else{
                if("N".equals(dir)){
                    dir="E";
                }
                else if("S".equals(dir)){
                    dir="W";
                }
                else if("E".equals(dir)){
                    dir="S";
                }
                else{
                    dir="N";
                }
            }
        }


        if(x==0 && y==0){
            return true;
        }

        if(dir.equals("N")){
            return false;
        }

        return true;
    }
}
