package code.bloomberg;

//https://leetcode.com/problems/count-and-say/submissions/
public class CountAndSay {

    public String countAndSay(int n) {

        String res = "1";
        if(n==1){
            return res;
        }

        for(int i=1;i<n;i++){
            res = getNext(res);
        }

        return res;
    }

    public String getNext(String res){

        char c = res.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<res.length();i++){
            if(c==res.charAt(i)){
                count++;
            }
            else{
                sb.append(count);
                sb.append(c);
                c = res.charAt(i);
                count = 1;
            }
        }

        sb.append(count);
        sb.append(c);

        return sb.toString();
    }
}
