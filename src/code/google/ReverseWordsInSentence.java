package code.google;

public class ReverseWordsInSentence {

    public static void main(String args[]){

        String sentence = "Hello World";

        ReverseWordsInSentence obj = new ReverseWordsInSentence();

        System.out.println(obj.reverse(sentence));

    }

    public String reverse(String sentence){

        if(sentence==null || sentence.length()==0){
            return null;
        }

        char str[] = sentence.toCharArray();

        int start = 0;
        int end = 0;

        while(true){

            while(start<str.length && !isCorrectCharacter(str[start])){
                start++;
            }

            if(start>=sentence.length()){
                break;
            }

            end = start;
            while(end<str.length && isCorrectCharacter(str[end])){
                end++;
            }

            reverseWord(str,start,end-1);
            start = end;
        }

        reverseWord(str,0,sentence.length()-1);

        return String.valueOf(str);
    }

    public boolean isCorrectCharacter(char c){
        return (c>='a' && c<='z') || (c>='A' && c<='Z');
    }
    public void reverseWord(char str[],int left,int right){

        while(left<=right){
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }
}
