package code.may.challenge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
//TC - O((n-k)*K)
//SC - O(2^k)
public class CheckIfStringContainsAllBinaryCodesOfSizeK {

    public boolean hasAllCodes(String s, int k) {

        Set<String> subStringsSet = new HashSet<>();

        for(int i=0;i<=s.length()-k;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<i+k;j++){
                sb.append(s.charAt(j));
            }
            subStringsSet.add(sb.toString());
        }

        return subStringsSet.size()==Math.pow(2,k);
    }

    public void getAllBinaryCodesOfLengthk(int arr[], int startIndex, List<String> res, int k){
        if(startIndex>=arr.length){
            res.add(getString(arr));
            return;
        }


        arr[startIndex] = 0;
        getAllBinaryCodesOfLengthk(arr,startIndex+1,res,k);
        arr[startIndex] = 1;
        getAllBinaryCodesOfLengthk(arr,startIndex+1,res,k);
    }

    private String getString(int arr[]){
        StringBuilder sb = new StringBuilder();
        for(int num:arr){
            sb.append(num);
        }
        return sb.toString();
    }
}
