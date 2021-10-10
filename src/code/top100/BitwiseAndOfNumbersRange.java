package code.top100;

/**
 * //https://leetcode.com/problems/bitwise-and-of-numbers-range/solution/
 *
 * one might notice that after the AND operation on all the numbers, the remaining part of bit strings is the common prefix of all these bit strings.
 *
 * The final result asked by the problem consists of this common prefix of bit string as its left part, with the rest of bits as zeros.
 *
 * More specifically, the common prefix of all these bit string is also the common prefix between the starting and ending numbers of the specified range (i.e. 9 and 12 respectively in the above example).
 *
 * As a result, we then can reformulate the problem as "given two integer numbers, we are asked to find the common prefix of their binary strings."
 *
 * Time Complexity: \mathcal{O}(1)O(1).
 *
 * Although there is a loop in the algorithm, the number of iterations is bounded by the number of bits that an integer has, which is fixed.
 *
 * Therefore, the time complexity of the algorithm is constant.
 *
 * Space Complexity: \mathcal{O}(1)O(1). The consumption of the memory for our algorithm is constant, regardless the input.
 */
public class BitwiseAndOfNumbersRange {

    public static void main(String args[]){

        BitwiseAndOfNumbersRange obj = new BitwiseAndOfNumbersRange();

        int left = 5;
        int right = 7;

        System.out.println(obj.rangeBitwiseAnd(left,right));

    }
    public int rangeBitwiseAnd(int left, int right) {

        return getCommonPrefix(left,right);
    }

    public int getCommonPrefix(int left,int right){

        int shift = 0;
        while(left!=right){
            left>>=1;
            right>>=1;
            shift++;
        }

        return left<<shift;
    }
}
