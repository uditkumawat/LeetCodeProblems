package code.facebook;

public class MinTimeToTypeWordUsingSpecialTypeWriter {

    public static void main(String args[]){

        MinTimeToTypeWordUsingSpecialTypeWriter obj = new MinTimeToTypeWordUsingSpecialTypeWriter();

        System.out.println(obj.minTimeToType("abc"));
        System.out.println(obj.minTimeToType("bza"));
        System.out.println(obj.minTimeToType("zjpc"));
    }
    public int minTimeToType(String word) {

        int timeDiff = 0;

        for(int i=1;i<word.length();i++){
            int cdiff = Math.abs(word.charAt(i)-word.charAt(i-1));
            int ccdiff = 26-cdiff;
            timeDiff+=Math.min(cdiff,ccdiff);
        }
        int diffWithStart = Math.abs('a'-word.charAt(0));
        timeDiff+=Math.min(diffWithStart,26-diffWithStart);
        timeDiff+=word.length();

        return timeDiff;
    }
}
