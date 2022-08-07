package code.leetcode.studyplan75;

import java.util.*;

//https://www.youtube.com/watch?v=5CtKOMPxQuY
public class AccountsMerge {

    class UnionFind{
        int parent[];
        UnionFind(int n){
            this.parent = new int[n];
            for(int i=0;i<n;i++){
                this.parent[i] = i;
            }
        }

        public void union(int x,int y){
            int px = findAbsParent(x);
            int py = findAbsParent(y);
            if(px!=py){
                parent[px] = py;
            }
        }

        public int findAbsParent(int x){
            if(parent[x] == x){
                return x;
            }
            parent[x] = findAbsParent(parent[x]);
            return parent[x];
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        List<List<String>> res = new ArrayList();
        if(accounts==null || accounts.size()==0){
            return res;
        }

        UnionFind uf = new UnionFind(accounts.size());
        Map<String,Integer> map = new HashMap();

        for(int acct=0;acct<accounts.size();acct++){
            List<String> account = accounts.get(acct);
            String name = account.get(0);

            for(int i=1;i<account.size();i++){
                if(map.containsKey(account.get(i))){
                    uf.union(acct,map.get(account.get(i)));
                }
                else{
                    map.put(account.get(i),acct);
                }
            }
        }

        Map<Integer,Account> rootAccounts = new HashMap();

        for(int acct=0;acct<accounts.size();acct++){

            List<String> account = accounts.get(acct);
            int rootAcctId = uf.findAbsParent(acct);

            if(!rootAccounts.containsKey(rootAcctId)){
                String name = accounts.get(rootAcctId).get(0);
                rootAccounts.put(rootAcctId,new Account(name));
            }

            rootAccounts.get(rootAcctId).emails.addAll(account.subList(1,account.size()));
        }

        for(Map.Entry<Integer,Account> entry:rootAccounts.entrySet()){

            List<String> temp = new ArrayList();
            temp.add(entry.getValue().name);
            temp.addAll(entry.getValue().emails);

            res.add(temp);
        }

        return res;
    }

    class Account{
        String name;
        Set<String> emails = new TreeSet();
        Account(String name){
            this.name = name;
        }
    }
}
