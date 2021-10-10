package code.top100;

import java.util.ArrayList;
import java.util.List;

//done by my own
public class CombinationOfRElementsFromArraySizeN {

    public static void main(String args[]){

        int arr[]={1,2,3,4,5};
        int r = 3;

        List<List<Integer>> lists = getCombinations(arr,r);

        for(List<Integer> list:lists){
            for(int n:list){
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> getCombinations(int arr[],int r){

        List<List<Integer>> lists = new ArrayList<>();
        util(arr,lists,0,r,new ArrayList<>());
        return lists;
    }

    public static void util(int arr[],List<List<Integer>> lists,int startingIndex,int r,List<Integer> list){
        if(list!=null && list.size()==r){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(startingIndex>arr.length){
            return;
        }
        for(int i=startingIndex;i<arr.length;i++){
            list.add(arr[i]);
            util(arr,lists,i+1,r,list);
            list.remove(list.size()-1);
        }
    }
}
