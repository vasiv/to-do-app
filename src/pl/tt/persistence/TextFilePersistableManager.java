package pl.tt.persistence;

/**
 * @author ciepluchs
 */
public class TextFilePersistableManager  implements PersistanceManager{

    @Override
    public void save(Persistable persistable){
        String valueToBeSavedIntoFile = persistable.toCsv();
        //TODO Implement method which saves given persistable using CSV format
    }

}
