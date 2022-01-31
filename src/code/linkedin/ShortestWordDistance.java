package code.linkedin;

/**
 *
 * Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2, return the shortest distance between these two words in the list.
 *
 * Time complexity: O(N \cdot M)O(N⋅M) where NN is the number of words in the input list, and MM is the total length of two input words.
 *
 * Space complexity: O(1)O(1), since no additional space is allocated.
 */
public class ShortestWordDistance {

    public static void main(String args[]){

        ShortestWordDistance obj = new ShortestWordDistance();

        String arr[] = {"abc","def","ghi"};

        int shortestDistance = obj.getShortestDistance(arr,"abc","ghi");

        System.out.println(shortestDistance);
    }

    int getShortestDistance(String words[],String word1,String word2){

        int minDistance = Integer.MAX_VALUE;

        int firstIndex = -1;
        int secondIndex = -1;

        for(int i=0;i<words.length;i++) {
            if (words[i].equals(word1)) {
                firstIndex = i;
            } else if (words[i].equals(word2)) {
                secondIndex = i;
            }

            if (firstIndex != -1 && secondIndex != -1) {
                minDistance = Math.min(minDistance,Math.abs(firstIndex-secondIndex));
            }
        }

        return minDistance;
    }
}
