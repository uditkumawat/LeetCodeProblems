package code.leetcode.doordash;

//TC - O(N)
//SC - O(1)
public class NearestPoint {

    public static void main(String args[]){
        int x=3;
        int y=4;

        int points[][] = {{1,2},{3,1},{2,4},{2,3},{4,4}};

        System.out.println(nearestValidPoint(x,y,points));
    }
    public static int nearestValidPoint(int x, int y, int[][] points) {

        int minDist = Integer.MAX_VALUE;
        int minIndex = -1;
        int index = 0;
        for(int point[]:points){
            if(x==point[0] || y==point[1]){
                int dist = distance(x,y,point[0],point[1]);
                if(dist<minDist){
                    minDist = dist;
                    minIndex = index;
                }
            }
            index++;
        }
        return minIndex;
    }

    public static int distance(int x1,int y1,int x2,int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
}
