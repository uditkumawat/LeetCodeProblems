package code.leetcode.studyplan;

//https://leetcode.com/problems/nested-list-weight-sum/
public class NestedListWeightSum {

    /*
    public int depthSum(List<NestedInteger> nestedList) {

        if(nestedList==null || nestedList.size()==0){
            return 0;
        }

        return depthSum(nestedList, 1);
    }

    public int depthSum(List<NestedInteger> nestedList,int depth){
        if(nestedList==null || nestedList.size()==0){
            return 0;
        }

        int sum = 0;

        for(NestedInteger nestedInteger:nestedList){
            if(nestedInteger.isInteger()){
                sum = sum + nestedInteger.getInteger() * depth;
            }
            else{
                sum = sum + depthSum(nestedInteger.getList(),depth+1);
            }
        }

        return sum;
    }
    */

}
