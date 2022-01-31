package code.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * A sparse vector is a vector that has mostly zero values, while a dense vector is a vector where most of the elements are non-zero. It is inefficient to store a sparse vector as a one-dimensional array (Approach 1). Instead, we can store the non-zero values and their corresponding indices in a dictionary, with the index being the key (Approach 2). Alternatively, we can represent elements of a sparse vector as an array of pairs for each non-zero value. Each pair has an integer index and a numerical value (Approach 3).
 */

/**
 * Let nn be the length of the input array and LL and L_{2}L
 * 2
 * ​
 *   be the number of non-zero elements for the two vectors.
 *
 * Time complexity: O(n)O(n) for creating the <index, value> pair for non-zero values; O(L+L_{2})O(L+L
 * 2
 * ​
 *  ) for calculating the dot product.
 *
 * Space complexity: O(L)O(L) for creating the <index, value> pairs for non-zero values. O(1)O(1) for calculating the dot product.
 */
public class SparseVectors {

    List<int[]> pairs;
    SparseVectors(int[] nums) {

        pairs = new ArrayList<>();

        for(int i=0;i<nums.length;i++){

            if(nums[i]!=0){
                pairs.add(new int[]{i,nums[i]});
            }
        }
    }

    public static void main(String args[]){

        int nums[] = {1,0,0,2,3};
        SparseVectors obj = new SparseVectors(nums);

        int onums[] = {0,3,0,4,0};
        SparseVectors oobj = new SparseVectors(onums);
        System.out.println(obj.dotProduct(oobj));
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVectors vec) {
        int result=0;
        int p=0;
        int q=0;
        while(p<pairs.size() && q<vec.pairs.size()){
            int fIndex = pairs.get(p)[0];
            int sIndex = vec.pairs.get(q)[0];

            int fValue = pairs.get(p)[1];
            int sValue = vec.pairs.get(q)[1];

            if(fIndex==sIndex){
                result+=fValue*sValue;
                p++;
                q++;
            }
            else if(fIndex>sIndex){
                q++;
            }
            else{
                p++;
            }
        }
        return result;
    }
}
