package code.concurrency;

import java.util.concurrent.Semaphore;

public class PrintEvenOddNumbersUsing2Threads {

    class SharedPrinter{
        Semaphore oddSemaphore = new Semaphore(0);
        Semaphore evenSemaphore = new Semaphore(1);

        public void print(int n){

            for(int i=0;i<n;i++){
                if(i%2==0){

                }
            }
        }
    }
    public static void main(String args[]){

        Thread todd = new Thread(()->{

            for(int i=1;i<10;i+=2){
                System.out.println(i+" ");

            }
        });

        Thread teven = new Thread(()->{
            for(int i=0;i<10;i+=2){
                System.out.println(i+" ");
            }
        });

        todd.start();
        teven.start();
    }
}
