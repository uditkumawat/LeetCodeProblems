package code.march.challenge;

//https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/solution/
public class SearchInSortedArrayOfUnknownSize {

    /**
     * interface ArrayReader {
     *  *     public int get(int index) {}
     *  * }
     * @param reader
     * @param target
     * @return
     */
    /*
    public int search(ArrayReader reader, int target) {

        if(reader.get(0)==target){
            return 0;
        }

        int left = 0;
        int right = 1;

        while(reader.get(right)<target){
            left = right;
            right <<= 1;
        }

        int pivot,num;

        while(left<=right){
            pivot = left+(right-left)>>1;

            num = reader.get(pivot);

            if(num==target){
                return pivot;
            }
            else if(num>target){
                right = pivot-1;
            }
            else{
                left = pivot+1;
            }

        }

        return -1;

    }
    */

}
