package code.leetcodeTopInterviewQuestions;

import java.util.Stack;

/**
 * Time Complexity: O(maxK⋅n), where maxK is the maximum value of kk and nn is the length of a given string ss. We traverse a string of size nn and iterate kk times to decode each pattern of form \text{k[string]}k[string]. This gives us worst case time complexity as \mathcal{O}(\text{maxK} \cdot n)O(maxK⋅n).
 *
 * Space Complexity: O(m+n), where mm is the number of letters(a-z) and nn is the number of digits(0-9) in string ss. In worst case, the maximum size of \text{stringStack}stringStack and \text{countStack}countStack could be mm and nn respectively.
 */
public class DecodeString {

    String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                // push the number k to countStack
                countStack.push(k);
                // push the currentString to stringStack
                stringStack.push(currentString);
                // reset currentString and k
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decodedString = stringStack.pop();
                // decode currentK[currentString] by appending currentString k times
                for (int currentK = countStack.pop(); currentK > 0; currentK--) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }
}
