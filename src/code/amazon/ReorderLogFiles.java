package code.amazon;

import java.util.Arrays;

//https://www.youtube.com/watch?v=Nj2Bpw1KKds&t=518s

/**
 * Let NN be the number of logs in the list and MM be the maximum length of a single log.
 *
 * Time Complexity: \mathcal{O}(M \cdot N \cdot \log N)O(M⋅N⋅logN)
 *
 * First of all, the time complexity of the Arrays.sort() is \mathcal{O}(N \cdot \log N)O(N⋅logN), as stated in the API specification, which is to say that the compare() function would be invoked \mathcal{O}(N \cdot \log N)O(N⋅logN) times.
 *
 * For each invocation of the compare() function, it could take up to \mathcal{O}(M)O(M) time, since we compare the contents of the logs.
 *
 * Therefore, the overall time complexity of the algorithm is \mathcal{O}(M \cdot N \cdot \log N)O(M⋅N⋅logN).
 *
 * Space Complexity: \mathcal{O}(M \cdot \log N)O(M⋅logN)
 *
 * For each invocation of the compare() function, we would need up to \mathcal{O}(M)O(M) space to hold the parsed logs.
 *
 * In addition, since the implementation of Arrays.sort() is based on quicksort algorithm whose space complexity is \mathcal{O}(\log n)O(logn), assuming that the space for each element is \mathcal{O}(1)O(1)). Since each log could be of \mathcal{O}(M)O(M) space, we would need \mathcal{O}(M \cdot \log N)O(M⋅logN) space to hold the intermediate values for sorting.
 *
 * In total, the overall space complexity of the algorithm is \mathcal{O}(M + M \cdot \log N) = \mathcal{O}(M \cdot \log N)O(M+M⋅logN)=O(M⋅logN).
 */
public class ReorderLogFiles {

    public static void main(String args[]){

        String str[] = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

        ReorderLogFiles obj = new ReorderLogFiles();

        String res[] = obj.reorderLogFiles(str);

        for(String s:res){
            System.out.println(s);
        }

    }
    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs,(log1, log2)->{

            int index1 = log1.indexOf(" ");
            String id1 = log1.substring(0,index1);
            String main1 = log1.substring(index1+1);

            int index2 = log2.indexOf(" ");
            String id2 = log2.substring(0,index2);
            String main2 = log2.substring(index2+1);

            boolean isLetter1 = Character.isLetter(main1.charAt(0));
            boolean isLetter2 = Character.isLetter(main2.charAt(0));

            if(isLetter1 && isLetter2){
                int value = main1.compareTo(main2);
                if(value==0){
                    return id1.compareTo(id2);
                }
                return value;
            }

            return !isLetter1?(!isLetter2 ? 0 : 1):-1;
        });

        return logs;
    }
}
