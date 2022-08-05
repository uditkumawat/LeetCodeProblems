package code.explorecard.binarySearch;

/**
 * Time complexity : \mathcal{O}(\log T)O(logT), where TT is an index of target value.
 *
 * There are two operations here: to define search boundaries and to perform binary search.
 *
 * Let's first find the number of steps k to setup the boundaries. On the first step, the boundaries are 2^0 .. 2^{0 + 1}2
 * 0
 *  ..2
 * 0+1
 *  , on the second step 2^1 .. 2^{1 + 1}2
 * 1
 *  ..2
 * 1+1
 *  , etc. When everything is done, the boundaries are 2^k .. 2^{k + 1}2
 * k
 *  ..2
 * k+1
 *   and 2^k < T \le 2^{k + 1}2
 * k
 *  <T≤2
 * k+1
 *  . That means one needs k = \log Tk=logT steps to setup the boundaries, that means \mathcal{O}(\log T)O(logT) time complexity.
 *
 * Now let's discuss the complexity of the binary search. There are 2^{k + 1} - 2^k = 2^k2
 * k+1
 *  −2
 * k
 *  =2
 * k
 *   elements in the boundaries, i.e. 2^{\log T} = T2
 * logT
 *  =T elements. As discussed, binary search has logarithmic complexity, that results in \mathcal{O}(\log T)O(logT) time complexity.
 */

public class SearchInSortedArrayOfUnknownSize {

    class ArrayReader {
        public int get(int index) {
            return -1;
        }
    }

    public int search(ArrayReader reader, int target) {

        int left = 0;
        int right = 0;

        while(reader.get(right)<target){
            left = right;
            right = right*2;
        }

        while(left<=right){

            int mid = left+(right-left)/2;

            int pivot = reader.get(mid);

            if(pivot==target){
                return mid;
            }
            else if(pivot>target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return -1;
    }
}
