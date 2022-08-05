package code.explorecard.binarySearch;

public class FindSmallestLetterGreaterThanTarget {

    public static void main(String args[]){

        char letters[] = {'c','f','j'};
        char target = 'e';

        FindSmallestLetterGreaterThanTarget obj = new FindSmallestLetterGreaterThanTarget();

        System.out.println(obj.nextGreatestLetter(letters,target));
    }
    public char nextGreatestLetter(char[] letters, char target) {

        int left = 0;
        int right = letters.length-1;
        char res='\0';

        while(left<=right){

            int mid = left+(right-left)/2;

            if(letters[mid]>target){
                res = letters[mid];
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return res;
    }
}
