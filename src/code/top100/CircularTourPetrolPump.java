package code.top100;

//https://www.youtube.com/watch?v=7WYwqvOSaa8
//TC - O(N)
public class CircularTourPetrolPump {

    public int tour(int petrol[],int distance[]){

        int start = 0;
        int requiredFuel = 0;
        int extraFuel = 0;
        int n = petrol.length;
        for(int i=0;i<n;i++){
            extraFuel += petrol[i]-distance[i];
            if(extraFuel<0){
                start = i+1;
                requiredFuel+=extraFuel;
                extraFuel = 0;
            }
        }

        return requiredFuel+extraFuel>=0?start:-1;
    }
}
