package code.atlassian;

import java.util.*;

/**
 * https://leetcode.com/problems/rank-teams-by-votes/
 * In a special ranking system, each voter gives a rank from highest to lowest to all teams participated in the competition.
 *
 * The ordering of teams is decided by who received the most position-one votes. If two or more teams tie in the first position, we consider the second position to resolve the conflict, if they tie again, we continue this process until the ties are resolved. If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.
 *
 * Given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to the ranking system described above.
 *
 * Return a string of all teams sorted by the ranking system.
 */
public class RankTeamByVotes {

    public static void main(String args[]){

        RankTeamByVotes obj = new RankTeamByVotes();
        String votes[] = {"WXYZ","XYZW"};

        String res = obj.rankTeams(votes);

        System.out.println(res);
    }
    public String rankTeams(String[] votes){

        Map<Character,int[]> map = new HashMap<>();
        int len = votes[0].length();

        for(String vote:votes){
            for(int i=0;i<len;i++){
                char c = vote.charAt(i);

                map.putIfAbsent(c,new int[len]);
                map.get(c)[i]++;
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(a, b)->{
            for(int i=0;i<len;i++){
                if(map.get(a)[i]!=map.get(b)[i]){
                    return map.get(b)[i]-map.get(a)[i];
                }
            }
            return a-b;
        });

        StringBuilder sb = new StringBuilder();
        for(char c:list){
            sb.append(c);
        }

        return sb.toString();
    }
}
