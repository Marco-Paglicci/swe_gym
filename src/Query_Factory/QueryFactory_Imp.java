package src.Query_Factory;



public class QueryFactory_Imp implements QueryFactory{
    @Override
    public Query createQuery(String string) {
        Query Q = new Query();
        Q.setQuery(string);

        return  Q;
    }
}
