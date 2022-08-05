package code.may.challenge;

//https://leetcode.com/problems/maximum-product-of-word-lengths/submissions/
//TC - O(n^2)
//SC - O(n)
//https://www.youtube.com/watch?v=3XHAikDnB2w
public class MaximumProductOfWordLength {

    public int maxProduct(String[] words) {

        if(words==null || words.length==0){
            return 0;
        }

        int len = words.length;

        int state[] = new int[len];

        for(int i=0;i<len;i++){
            state[i] = getStateFromWord(words[i]);
        }

        int maxProduct = 0;

        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){

                if((state[i] & state[j])==0){

                    int word1Len = words[i].length();
                    int word2Len = words[j].length();
                    int product = word1Len * word2Len;

                    maxProduct = Math.max(maxProduct,product);
                }
            }
        }

        return maxProduct;
    }

    public int getStateFromWord(String s){

        int state = 0;

        for(char c:s.toCharArray()){
            int index = c-'a';
            state = state | 1<<index;  // setting the bit at index position
        }

        return state;
    }
}
