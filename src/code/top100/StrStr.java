package code.top100;

public class StrStr {

    public int strStr(String haystack,String needle){

        if(haystack==null || needle==null){
            return -1;
        }

        int l1 = haystack.length();
        int l2 = needle.length();

        for(int i=0;i<l1-l2+1;i++){
            int j=0;

            while(j<l2 && haystack.charAt(i+j)==needle.charAt(j)){
                j++;
            }

            if(j==needle.length()){
                return i;
            }
        }
        return -1;
    }
}
