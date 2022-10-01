package code.october2022.challenge;

public class CountAndSay {

    public String countAndSay(int n) {

        if(n==1){
            return "1";
        }

        String res = "1";

        for(int i=2;i<=n;i++){
            res = generate(res);
        }

        return res;
    }

    private String generate(String num){
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for(int i=0;i<num.length()-1;i++){
            char current = num.charAt(i);
            char next = num.charAt(i+1);
            if(current==next){
                count++;
            }
            else{
                sb.append(count);
                sb.append(current);
                count=1;
            }
        }

        sb.append(count);
        sb.append(num.charAt(num.length()-1));

        return sb.toString();
    }
}
