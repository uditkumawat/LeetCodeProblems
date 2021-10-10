package code.top100;

/**
 * Time complexity: O(n)O(n). For each integer xx, in the range 11 to nn, we need to perform a constant number of operations which does not depend on the number of bits in xx.
 *
 * Space complexity: O(1)O(1). Since the output array does not count towards the space complexity.
 */
public class CountingBits {

    public static void main(String args[]){
        int n = 5;
        int res[] = countBits(n);
        for(int num:res){
            System.out.print(num+ " ");
        }
    }
    public static int[] countBits(int n) {

        if(n==0){
            return new int[0];
        }

        int res[] = new int[n+1];

        for(int i=1;i<=n;i++){
            if(i%2==1){
                res[i] = res[i/2]+1;
            }
            else{
                res[i] = res[i/2];
            }
        }

        return res;
    }
}
