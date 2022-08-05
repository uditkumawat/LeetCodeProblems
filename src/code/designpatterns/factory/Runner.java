package code.designpatterns.factory;

public class Runner {

    public static void main(String args[]){

        DataStore rdsDataStore = DatastoreFactory.getDataStore("RDS");
        DataStore oracleDataStore = DatastoreFactory.getDataStore("ORACLE");

        rdsDataStore.createDataStore();
        oracleDataStore.createDataStore();
    }
}
