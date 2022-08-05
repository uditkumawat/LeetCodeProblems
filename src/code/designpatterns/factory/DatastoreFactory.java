package code.designpatterns.factory;

public class DatastoreFactory {

    public static DataStore getDataStore(String type){

        DataStore dataStore=null;
        if("RDS".equals(type)){
            dataStore = new RDSDataStore();
        }
        else if("ORACLE".equals(type)){
            dataStore = new OracleDataStore();
        }

        return dataStore;
    }
}
