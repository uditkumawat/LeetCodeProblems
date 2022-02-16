package code.feb.challenge;

//https://www.youtube.com/watch?v=IhJgguNiYYk
//https://leetcode.com/problems/string-compression/
public class StringCompression {

    public static void main(String args[]){

        char chars[] = {'a','a','b','b','c','c','c'};

        StringCompression obj = new StringCompression();

        System.out.println(obj.compress(chars));
    }
    public int compress(char[] chars) {

        int index = 0;
        int i = 0;

        while(i<chars.length){
            int j = i;
            while(j<chars.length && chars[j]==chars[i]){
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
