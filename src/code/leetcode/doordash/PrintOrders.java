package code.leetcode.doordash;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/discuss/941175/Evolve-from-brute-force
public class PrintOrders {

    public static void main(String args[]){

            System.out.println(countOrders(4));

    }

    public static int countOrders(int n) {
        List<List<String>> res=new ArrayList<>();
        dfs(new boolean[n],new boolean[n],new ArrayList<>(), res);
        for(List<String> list:res){
            for(String str:list){
                System.out.print(str+" ");
            }
            System.out.println();
        }
        return res.size();
    }
    private static void dfs(boolean[] pickup, boolean[] delivery, List<String> cur, List<List<String>> res) {
        int n=pickup.length;
        if(cur.size() == 2*n) {
            res.add(new ArrayList(cur));
            return;
        }
        for(int i=0;i<n;i++) {
            if(!pickup[i]) {
                pickup[i]=true;
                cur.add("P"+i);
                dfs(pickup, delivery, cur, res);
                cur.remove(cur.size()-1);
                pickup[i]=false;
            }
        }
        for(int i=0;i<n;i++) {
            if(pickup[i] && !delivery[i]) {
                delivery[i]=true;
                cur.add("D"+i);
                dfs(pickup, delivery, cur, res);
                cur.remove(cur.size()-1);
                delivery[i]=false;
            }
        }
    }
}
