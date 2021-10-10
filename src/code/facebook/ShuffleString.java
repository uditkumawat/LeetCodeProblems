package code.facebook;

/**
 * Given a string s and an integer array indices of the same length.
 *
 * The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
 *
 * Return the shuffled string.
 */
//TC-O(N)
//SC-O(N)
public class ShuffleString {

    public static void main(String args[]){
        ShuffleString obj = new ShuffleString();

        String s = "codeleet";
        int indices[] = {4,5,6,7,0,2,1,3};

        System.out.println(obj.restoreString(s,indices));
    }

    public String restoreString(String s, int[] indices) {

        int n = s.length();

        char c[] = new char[n];

        for(int i=0;i<n;i++){
            c[indices[i]] = s.charAt(i);
        }

        return String.valueOf(c);
    }
}
