package code.airbnb;

public class RepeatedSubstringPattern {

    public static void main(String args[]){

        RepeatedSubstringPattern obj = new RepeatedSubstringPattern();

        String str = "abababab";

        String subStr = obj.getRepeatedSubStr(str);

        System.out.println(subStr);
    }

    public String getRepeatedSubStr(String str){

        int len = str.length();
        for(int i=1;i<len/2;i++){
            //it should be even length
            if(len%i==0){
                int repeatitions = len/i;
                String substr = str.substring(0,i);
                StringBuilder temp = new StringBuilder();
                for(int j=0;j<repeatitions;j++){
                    temp.append(substr);
                }
                if(temp.toString().equals(str)){
                    return substr;
                }
            }
        }

        return null;
    }
}
