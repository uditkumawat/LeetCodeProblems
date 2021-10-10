package code.top100;

import java.util.ArrayList;
import java.util.List;

public class PermutationswithCaseChange {

    public static void main(String args[]){

        String str = "ab";

        List<String> list = new ArrayList<>();

        getPermutations(str.toCharArray(),0,list);

        for(String s:list){
            System.out.println(s);
        }
    }

    public static void getPermutations(char str[],int index,List<String> list){
        if(index==str.length){
            list.add(new String(str));
            return;
        }
        else{
                str[index] = Character.toLowerCase(str[index]);
                getPermutations(str,index+1,list);
                str[index] = Character.toUpperCase(str[index]);
                getPermutations(str,index+1,list);

        }
    }
}
