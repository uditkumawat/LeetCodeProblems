package code.feb.challenge;

//https://leetcode.com/problems/compare-version-numbers/solution/
//TC- O(N+M)
//SC - O(max(n,M))
public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {

        String t1[] = version1.split(".");
        String t2[] = version2.split(".");

        int n1 = t1.length;
        int n2 = t2.length;

        for(int i=0;i<Math.max(n1,n2);i++){
            int f = i < n1 ? Integer.parseInt(t1[i]) : 0;
            int s = i < n2 ? Integer.parseInt(t2[i]) : 0;

            if(f != s){
                return f > s ? 1:-1;
            }
        }

        return 0;
    }
}
