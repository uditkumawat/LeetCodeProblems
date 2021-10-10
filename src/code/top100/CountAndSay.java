package code.top100;

public class CountAndSay {

    public static void main(String args[]){

        int n = 5;

        String res = new String("1");

        System.out.println(res);

        for(int i=1;i<=n;i++){
            res = getNext(res);
            System.out.println(res);
        }
    }

    public static String getNext(String str){

        StringBuilder res = new StringBuilder();
        int count = 1;
        char c = str.charAt(0);

        for(int i=1;i<str.length();i++){
            if(c==str.charAt(i)){
                count++;
            }
            else{
                res.append(count);
                res.append(c);
                c = str.charAt(i);
                count = 1;
            }
        }
        res.append(count);
        res.append(c);

        return res.toString();
    }
}
