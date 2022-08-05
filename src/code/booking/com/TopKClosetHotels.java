package code.booking.com;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TC-O(N)
//SC-O(N)
//https://leetcode.com/discuss/interview-question/1574201/Booking.com-Top-K-Hotels.
//https://leetcode.com/discuss/interview-question/1567876/Booking.com-or-Phone-Codind-or-Top-K-Hotels
public class TopKClosetHotels {

    public static void main(String args[]){

        int arr[][] = {{1, 2, 0, 1},
                {1, 3, 0, 1},
                {0, 2, 5, 1}
        };

        //1 - road
        //0 - blocker
        //number>1 - price of hotel
        int k = 2;
        int origin_x = 0;
        int origin_y = 3;
        int price = 7;

        TopKClosetHotels obj = new TopKClosetHotels();
        List<Pair<Integer,Integer>> hotels = obj.getTopKHotels(arr,origin_x,origin_y,k,price);

        for(Pair<Integer,Integer> pair:hotels){
            System.out.println(pair.getKey()+" "+pair.getValue());
        }

    }

    public List<Pair<Integer,Integer>> getTopKHotels(int arr[][],int x,int y,int k,int price){

        List<Pair<Integer,Integer>> res = new ArrayList<>();
        if(arr==null || arr.length==0){
            return res;
        }

        int dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};

        Queue<Pair<Integer,Integer>> q = new LinkedList();
        boolean visited[][] = new boolean[arr.length][arr[0].length];
        q.add(new Pair(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Pair<Integer,Integer> pair = q.poll();

            for(int dir[]:dirs){
                int newX = pair.getKey()+dir[0];
                int newY = pair.getValue()+dir[1];

                if(isValidMove(arr,newX,newY,visited)){
                    q.add(new Pair(newX,newY));
                    visited[newX][newY] = true;

                    //reached a hotel
                    if(arr[newX][newY]>1 && arr[newX][newY]<=price && res.size()<k){
                        res.add(new Pair(newX,newY));
                    }
                }
            }
        }

        return res;
    }

    boolean isValidMove(int arr[][],int x,int y,boolean visited[][]){
        if(x<0 || y<0 || x>=arr.length || y>=arr[0].length || arr[x][y]==0 || visited[x][y]){
            return false;
        }
        return true;
    }
}
