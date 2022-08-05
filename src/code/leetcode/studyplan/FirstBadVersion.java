package code.leetcode.studyplan;

//https://leetcode.com/problems/first-bad-version/submissions/
public class FirstBadVersion {

    /**
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {

            int left = 1;
            int right = n;
            int ans = 0;

            while(left<=right){

                int mid = left+(right-left)/2;

                if(isBadVersion(mid)==false){
                    left = mid+1;
                }
                else{
                    ans = mid;
                    right = mid-1;
                }
            }

            return ans;
        }
    }
     */
}
