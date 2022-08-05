package code.bloomberg;

//https://leetcode.com/explore/interview/card/bloomberg/68/array-and-strings/402/
//Tc- O(N)
public class StringCompression {

    public int compress(char[] chars) {

        int index = 0;
        int i = 0;

        while(i<chars.length){
            int j = i;

            while(j<chars.length && chars[i]==chars[j]){
                j++;
            }

            chars[index++] = chars[i];

            if(j-i>1){
                String count = j-i+"";
                for(char c:count.toCharArray()){
                    chars[index++] = c;
                }
            }

            i = j;
        }

        return index;
    }
}
