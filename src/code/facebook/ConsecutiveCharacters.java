package code.facebook;

public class ConsecutiveCharacters {

    public static void main(String args[]){

        ConsecutiveCharacters obj = new ConsecutiveCharacters();
        System.out.println(obj.maxPower("leetcode"));
        System.out.println(obj.maxPower("abbcccddddeeeeedcba"));
        System.out.println(obj.maxPower("triplepillooooow"));
        System.out.println(obj.maxPower("hooraaaaaaaaaaay"));
        System.out.println(obj.maxPower("tourist"));
    }
    public int maxPower(String s) {

        if(s==null || s.length()==0){
            return 0;
        }

        return getMaxPower(s);
    }

    public int getMaxPower(String s){
        int len = 1;
        int maxLen = 1;

        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                len++;
                maxLen = Math.max(maxLen,len);
            }
            else{
                len = 1;
            }
        }

        return maxLen;
    }
}
