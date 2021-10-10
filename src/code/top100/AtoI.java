package code.top100;

//https://www.youtube.com/watch?v=2I9XO8jwZCA&list=PLEJXowNB4kPxQIN2dCUAnQ_92HIziG4x6&index=39
//TC - O(string length)

public class AtoI {

    public static void main(String args[]){

       String str = "324a";

       int num = getNum(str);

       System.out.println(num);
    }

    public static int getNum(String str){

        int num = 0;
        for(char c:str.toCharArray()){
            if(c>='0' && c<='9'){
                num = num*10 + c-'0';
            }
            else{
                return -1;
            }
        }
        return num;
    }
}
