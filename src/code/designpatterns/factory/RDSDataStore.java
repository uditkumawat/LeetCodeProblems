package code.designpatterns.factory;

public class RDSDataStore implements DataStore{
    @Override
    public void createDataStore() {
        System.out.println("RDSDataStore created");
    }
}
