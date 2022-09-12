package code.amazon;

//https://www.youtube.com/watch?v=3JQSuBNX8jw
public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {

        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");

        int i=0;
        int j=0;
        int m = v1.length;
        int n = v2.length;

        while(i<m || j<n){
            int first = i<m ? Integer.parseInt(v1[i]):0;
            int second = j<n ? Integer.parseInt(v2[j]):0;

            if(first!=second){
                return first<second?-1:1;
            }

            i++;
            j++;
        }

        return 0;
    }
}
