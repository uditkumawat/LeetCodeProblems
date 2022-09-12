package code.salesforce;

//https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/solution/
// TC - O(logT), where T is an index of target value
public class SearchInSortedArrayOfUnknownSize {

    interface ArrayReader {
     public int get(int index);
    }

    public int search(ArrayReader reader, int target) {

        if(reader.get(0)==target){
            return 0;
        }

        int left = 0;
        int right = 1;
        while(reader.get(right)<target){
            left = right;
            right<<=1;
        }

        int mid , num;

        while(left<=right){
            mid = left+(right-left)/2;
            num = reader.get(mid);

            if(num==target){
                return mid;
            }
            if(num>target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return -1;
    }
}
