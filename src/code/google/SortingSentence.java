package code.google;

/**
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of lowercase and uppercase English letters.
 *
 * A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.
 *
 * For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
 * Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.
 */
public class SortingSentence {

    public static void main(String args[]){

        SortingSentence obj = new SortingSentence();

        String s = "is2 sentence4 This1 a3";

        System.out.println(obj.sortSentence(s));
    }

    public String sortSentence(String s) {

        if(s==null || s.length()==0){
            return null;
        }

        String str[] = s.split("\\s+");

        int n = str.length;

        String res[] = new String[n];

        for(int i=0;i<str.length;i++){

            String word = str[i];
            int index = word.charAt(word.length()-1)-'0';

            res[index-1] = word.substring(0,word.length()-1);
        }

        StringBuilder builder = new StringBuilder();
        for(String st:res){
            builder.append(st);
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}
