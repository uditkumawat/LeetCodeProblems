package code.top100;

import java.util.Arrays;

//TC - O(root n Loglogn)

/**
 * Time Complexity: The overall time complexity is O(\sqrt{n} \log \log n))O(
 * n
 * ​
 *  loglogn)). The \sqrt{n}
 * n
 * ​
 *   comes from the outer loop. Each time we hit a prime, we "cross out" the multiples of that prime because we know they aren't prime. But how many iterations do we perform for each prime number? That depends on how many multiples of that number are lower than nn. Let's look at a rough estimate of these values for all the primes.
 *
 *   For 2, we have to cross out n/2 numbers.
 *   For 3, we have to cross out n/3 numbers.
 *   For 5, we have to cross out n/5 numbers.
 *   ...etc for each prime less than n.
 *
 * This means that the time complexity of "crossing out" is O(\frac{n}{2} + \frac{n}{3} + \frac{n}{5} + ... + \frac{n}{\text{last prime < n}})O(
 * 2
 * n
 * ​
 *  +
 * 3
 * n
 * ​
 *  +
 * 5
 * n
 * ​
 *  +...+
 * last prime < n
 * n
 * ​
 *  ). This is bounded by O(\log \log n)O(loglogn) and the proof is available here. Cheers to this discussion post for explaining the complexity analysis in a detailed manner!
 */
public class CountPrimes {

    public static void main(String args[]){
        int n = 10;

        System.out.println(countPrimes(n));
    }

    public static int countPrimes(int n) {

        boolean dp[] = new boolean[n+1];
        Arrays.fill(dp,true);
        dp[0] = false;
        dp[1] = false;
        for(int i=2;i<=(int)Math.sqrt(n);i++){
            if(dp[i]==true){
                for(int j=i*2;j<=n;j=j+i){
                    dp[j] = false;
                }
            }
        }

        int count = 0;
        for(int i=0;i<=n;i++){
            if(dp[i]==true){
                count++;
            }
        }

        return count;
    }
}
