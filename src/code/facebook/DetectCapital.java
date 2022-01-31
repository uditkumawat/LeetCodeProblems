package code.facebook;

public class DetectCapital {

    public static void main(String args[]){

        String word = "FlaG";

        DetectCapital obj = new DetectCapital();

        System.out.println(obj.detectCapitalUse(word));

    }
    public boolean detectCapitalUse(String word) {

        if(word==null | word.length()==0){
            return false;
        }

        boolean allCapitals = isAllCapitals(word);
        boolean allLowercase = isAllLowercase(word);
        boolean firstLetterCapital = isFirstLetterCapital(word);

        if(allCapitals || allLowercase || firstLetterCapital){
            return true;
        }
        else{
            return false;
        }
    }

    boolean isAllCapitals(String word){

        for(char c:word.toCharArray()){
            if(!(c>='A' && c<='Z')){
                return false;
            }
        }
        return true;
    }

    boolean isAllLowercase(String word){

        for(char c:word.toCharArray()){
            if(!(c>='a' && c<='z')){
                return false;
            }
        }
        return true;
    }

    boolean isFirstLetterCapital(String word){

        return word.charAt(0)>='A' && word.charAt(0)<='Z' && isAllLowercase(word.substring(1));

    }
}
