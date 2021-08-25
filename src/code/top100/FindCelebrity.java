package code.top100;

//https://leetcode.com/problems/find-the-celebrity/solution/
public class FindCelebrity {

    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
 class Relation{
     public boolean knows(int a,int b){
         return true;
     }
    }
    public class Solution extends Relation {

        private int numberOfPeople;

        public int findCelebrity(int n) {

            this.numberOfPeople = n;

            int celebrityCandidate = 0;

            for(int i=0; i<n ;i++){
                if(knows(celebrityCandidate,i)){
                    celebrityCandidate = i;
                }
            }

            if(isCelebrity(celebrityCandidate)){
                return celebrityCandidate;
            }

            return -1;
        }

        public boolean isCelebrity(int celebrityCandidate){

            for(int i=0;i<numberOfPeople;i++){
                if(i==celebrityCandidate){
                    return false;
                }
                if(knows(celebrityCandidate,i) || !knows(i,celebrityCandidate)){
                    return false;
                }
            }

            return true;
        }
    }
}
