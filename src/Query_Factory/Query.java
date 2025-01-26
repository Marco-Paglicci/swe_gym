package src.Query_Factory;



public class Query {



    private String content;

    public String getQuery() {
        return content;
    }

    public void setQuery(String query) {
        this.content = query;
    }

    @Override
    public String toString() {
        return "Query{" +
                "content='" + content + '\'' +
                '}';
    }
}
