package code.leetcode.studyplan75;

//TC - O(logn)
public class BadVersion {

    /**
     * public class Solution extends VersionControl {
     *     public int firstBadVersion(int n) {
     *
     *         int left = 1;
     *         int right = n;
     *         int ans = 0;
     *
     *         while(left<=right){
     *
     *             int mid = left+(right-left)/2;
     *
     *             if(isBadVersion(mid)==false){
     *                 left = mid+1;
     *             }
     *             else{
     *                 ans = mid;
     *                 right = mid-1;
     *             }
     *         }
     *
     *         return ans;
     *     }
     * }
     */
}
