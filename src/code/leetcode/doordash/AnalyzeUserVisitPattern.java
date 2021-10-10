package code.leetcode.doordash;

import java.util.*;

/**
 * https://leetcode.com/problems/analyze-user-website-visit-pattern/discuss/634634/Java-Two-Hashmaps-%2B-DFS-Combinations
 */
public class AnalyzeUserVisitPattern {

    static class Event{
        String user;
        int timestamp;
        String web;
        Event(String user,int timestamp,String web){
            this.user = user;
            this.timestamp = timestamp;
            this.web = web;
        }
    }

    public static void main(String args[]){

        String users[] = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int timestamps[] = {1,2,3,4,5,6,7,8,9,10};
        String websites[] = {"home","about","career","home","cart","maps","home","home","about","career"};

        List<String> pattern = mostVisitedPattern(users,timestamps,websites);

        for(String str:pattern){
            System.out.println(str);
        }
    }

    public static List<String> mostVisitedPattern(String users[],int timestamps[],String websites[]){

        List<Event> events = new ArrayList<>();
        for(int i=0;i<users.length;i++){
            events.add(new Event(users[i],timestamps[i],websites[i]));
        }

        //sorted events based on timestamp
        Collections.sort(events,(a,b)->a.timestamp-b.timestamp);

        //user to all his visited website mapping
        Map<String,List<String>> userWebMap = new HashMap<>();

        for(Event event:events){
            List<String> webs = new ArrayList<>();
            if(userWebMap.containsKey(event.user)){
                webs = userWebMap.get(event.user);
            }
            webs.add(event.web);
            userWebMap.put(event.user,webs);
        }

        //create sequence in order of visit and count each unique sequence
        Map<String,Integer> webToFreq = new HashMap<>();
        for(String user:userWebMap.keySet()){
            Set<String> seqs = getSequences(userWebMap.get(user));
            for(String seq:seqs){
                webToFreq.put(seq,webToFreq.getOrDefault(seq,0)+1);
            }
        }

        int max = 0;
        String ans = "";
        for (String seq: webToFreq.keySet()) {
            int freq = webToFreq.get(seq);
            if (freq < max) continue;
            if (freq > max) ans = seq;
            if (max == freq) ans = (seq.compareTo(ans) < 0) ? seq: ans;
            max = freq;
        }
        return Arrays.asList(ans.split(","));


    }

    public static Set<String> getSequences(List<String> websites){
        Set<String> res = new HashSet<>();
        if(websites.size()<3){
            return res;
        }
        dfs(websites,0,new ArrayList<>(),res);
        return res;
    }

    public static void dfs(List<String> websites,int index,List<String> list,Set<String> res){
        if(list.size()==3){
            String seq = list.get(0)+","+list.get(1)+","+list.get(2);
            res.add(seq);
            return;
        }

        for(int i=index;i<websites.size();i++){
            list.add(websites.get(i));
            dfs(websites,i+1,list,res);
            list.remove(list.size()-1);
        }
    }
}
