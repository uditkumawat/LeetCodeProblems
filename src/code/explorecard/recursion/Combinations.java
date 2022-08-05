package code.explorecard.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String args[]){

        int n = 4;
        int k = 2;

        Combinations obj = new Combinations();

        List<List<Integer>> res = obj.combine(n,k);

        for(List<Integer> list:res){
            for(int num:list){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();


        combineUtil(1,n,k,res,new ArrayList<>());

        return res;
    }

    public void combineUtil(int startNumber,int n,int k,List<List<Integer>> res,List<Integer> temp){

        if(temp!=null && temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int endNumber=startNumber;endNumber<=n;endNumber++){
            temp.add(endNumber);
            combineUtil(endNumber+1,n,k,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}
