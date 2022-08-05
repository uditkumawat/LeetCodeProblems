package code.designpatterns.factory;

public class OracleDataStore implements DataStore{
    @Override
    public void createDataStore() {
        System.out.println("Oracle data store created");
    }
}
