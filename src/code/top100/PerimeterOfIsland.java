package code.top100;

public class PerimeterOfIsland {

    public static void main(String args[]){

        int arr[][]={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int perimeter = 0;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==1)
                    perimeter+=perimterFunction(arr,i,j);
            }
        }
        System.out.println(perimeter);
    }

    public static int perimterFunction(int arr[][],int i,int j){
        int count=0;

        if(j-1<0 || arr[i][j-1]==0)
            count++;
        if(i-1<0 || arr[i-1][j]==0)
            count++;
        if(j+1>=arr[0].length || arr[i][j+1]==0)
            count++;
        if(i+1>=arr.length || arr[i+1][j]==0)
            count++;

        return count;
    }
}
