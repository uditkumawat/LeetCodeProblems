package code.google;

/**
 * There is a special keyboard with all keys in a single row.
 *
 * Given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25). Initially, your finger is at index 0. To type a character, you have to move your finger to the index of the desired character. The time taken to move your finger from index i to index j is |i - j|.
 *
 * You want to type a string word. Write a function to calculate how much time it takes to type it with one finger.
 */
public class SingleRowKeyboard {

    public static void main(String args[]){

        SingleRowKeyboard obj = new SingleRowKeyboard();
        String keyboard = "abcdefghijklmnopqrstuvwxyz";
        String word = "cba";

        System.out.println(obj.calculateTime(keyboard,word));
    }
    public int calculateTime(String keyboard, String word) {

        int keyIndicies[] = new int[26];

        for(int i=0;i<keyboard.length();i++){
            char c = keyboard.charAt(i);
            keyIndicies[c-'a'] = i;
        }

        int time = 0;
        int lastIndex = 0;

        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            time+=Math.abs(lastIndex-keyIndicies[c-'a']);
            lastIndex = keyIndicies[c-'a'];
        }

        return time;
    }
}
