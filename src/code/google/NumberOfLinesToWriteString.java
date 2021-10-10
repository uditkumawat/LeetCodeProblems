package code.google;

/**
 * You are given a string s of lowercase English letters and an array widths denoting how many pixels wide each lowercase English letter is. Specifically, widths[0] is the width of 'a', widths[1] is the width of 'b', and so on.
 *
 * You are trying to write s across several lines, where each line is no longer than 100 pixels. Starting at the beginning of s, write as many letters on the first line such that the total width does not exceed 100 pixels. Then, from where you stopped in s, continue writing as many letters as you can on the second line. Continue this process until you have written all of s.
 *
 * Return an array result of length 2 where:
 *
 * result[0] is the total number of lines.
 * result[1] is the width of the last line in pixels.
 */
public class NumberOfLinesToWriteString {

    public static void main(String args[]){

        NumberOfLinesToWriteString obj = new NumberOfLinesToWriteString();

        int widths[] = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};

        String s = "bbbcccdddaaa";

        int res[] = obj.numberOfLines(widths,s);

        System.out.println(res[0]);
        System.out.println(res[1]);
    }
    public int[] numberOfLines(int[] widths, String s) {

        int res[] = new int[2];

        int lines = 1;
        int width = 0;

        for(char c:s.toCharArray()){
            int w = widths[c-'a'];
            width+=w;
            if(width>100){
                lines++;
                width = w;
            }
        }

        res[0] = lines;
        res[1] = width;

        return res;
    }
}
