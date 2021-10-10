package code.microsoft;

/**
 * You are given a string s consisting of lowercase English letters, and an integer k.
 *
 * First, convert s into an integer by replacing each letter with its position in the alphabet (i.e., replace 'a' with 1, 'b' with 2, ..., 'z' with 26). Then, transform the integer by replacing it with the sum of its digits. Repeat the transform operation k times in total.
 *
 * For example, if s = "zbax" and k = 2, then the resulting integer would be 8 by the following operations:
 *
 * Convert: "zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
 * Transform #1: 262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
 * Transform #2: 17 ➝ 1 + 7 ➝ 8
 * Return the resulting integer after performing the operations described above.
 */
public class SumOfDigitsOfStringAfterConvert {

    public static void main(String args[]){
        String s = "zbax";
        int k = 2;

        SumOfDigitsOfStringAfterConvert obj = new SumOfDigitsOfStringAfterConvert();

        System.out.println(obj.getLucky(s,k));
    }
    public int getLucky(String s, int k) {

        StringBuilder sb = new StringBuilder();

        for(char c:s.toCharArray()){
            sb.append(c-'a'+1);
        }

        int num = getNumber(sb.toString(),k);

        return num;
    }

    int getNumber(String s,int k){

        while(k-->0){

            int ans = 0;
            for(int i=s.length()-1;i>=0;i--){
                char c = s.charAt(i);
                ans+=c-'0';
            }
            s = String.valueOf(ans);
        }

        return Integer.parseInt(s);
    }
}
