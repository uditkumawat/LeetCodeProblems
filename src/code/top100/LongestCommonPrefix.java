package code.top100;


//https://www.youtube.com/watch?v=bl8ue-dTxgs
public class LongestCommonPrefix {

    public static void main(String args[]){
        String strs[] = {"flower","flow","flight"};

    }

    public String longestCommonPrefix(String strs[]){

        if(strs.length==0){
            return "";
        }

        String prefix = strs[0];

        for(int i=1;i<strs.length;i++){
            //checking at beginning of string str[i]
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }

        return prefix;
    }
}
