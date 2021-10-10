package code.google;

public class HeightChecker {

    public static void main(String args[]){

        HeightChecker obj = new HeightChecker();
        int heights[] = {5,1,2,3,4};

        System.out.println(obj.heightChecker(heights));
    }
    public int heightChecker(int[] heights) {

        if(heights==null || heights.length==0){
            return 0;
        }

        int n = heights.length;

        int expected[] = new int[n];

        int count[] = new int[101];

        for(int num:heights){
            count[num]++;
        }

        int k = 0;
        for(int i=0;i<101;i++){
            while(count[i]-->0){
                expected[k++] = i;
            }
        }

        int ans = 0;

        for(int i=0;i<n;i++){
            if(heights[i]!=expected[i]){
                ans++;
            }
        }

        return ans;
    }
}
