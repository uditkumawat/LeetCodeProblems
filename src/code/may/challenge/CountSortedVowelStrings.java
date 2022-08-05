package code.may.challenge;

import java.util.ArrayList;
import java.util.List;

public class CountSortedVowelStrings {

    public static void main(String args[]){

        CountSortedVowelStrings obj = new CountSortedVowelStrings();

        System.out.println(obj.countVowelStrings(2));
    }
    public int countVowelStrings(int n) {

        if(n==0){
            return 0;
        }

        char vowels[] = {'a','e','i','o','u'};

        List<String> res = new ArrayList<>();

        countUtil(n,vowels,res,new StringBuilder(),0);

        System.out.println(res);
        return res.size();
    }

    public void countUtil(int n,char vowels[],List<String> res,StringBuilder sb,int start){

        if(n==sb.length()){
            res.add(new String(sb));
            return;
        }

        for(int end=start;end<vowels.length;end++){
            sb.append(vowels[end]);
            countUtil(n,vowels,res,sb,end);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
