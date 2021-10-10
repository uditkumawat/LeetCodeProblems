package code.microsoft;

/**
 * The power of the string is the maximum length of a non-empty substring that contains only one unique character.
 *
 * Given a string s, return the power of s.
 */
public class ConsecutiveCharacters {

    public static void main(String args[]){
        String s = "hooraaaaaaaaaaay";

        ConsecutiveCharacters obj = new ConsecutiveCharacters();

        System.out.println(obj.maxPower(s));
    }

    public int maxPower(String s) {

        if(s==null || s.length()==0){
            return 0;
        }

        int maxLength=1;
        int len=1;

        for(int i=1;i<s.length();i++){

            if(s.charAt(i-1)==s.charAt(i)){
                len++;
                maxLength = Math.max(maxLength,len);
            }
            else{
                len=1;
            }
        }

        return maxLength;
    }
}
