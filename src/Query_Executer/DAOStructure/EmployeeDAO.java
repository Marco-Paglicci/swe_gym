package src.Query_Executer.DAOStructure;


import models.Employee;
import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private final Execute_Query executeQuery;


    public EmployeeDAO(Execute_Query executeQuery) {
        this.executeQuery = executeQuery;
    }

    public List<Employee> getAllEmployee(Query query) {
        List<Employee> Employee_list = new ArrayList<>();

        try {
            try(ResultSet rs = executeQuery.executeGet(query)) {
                if (rs == null || rs.isClosed()) {
                    System.err.println("ERRORE: il ResultSet è nullo o chiuso!");
                    return Employee_list; // Ritorna una lista vuota
                }
                // Trasforma il ResultSet in una lista di oggetti Utente
                while (rs.next()) {

                    Employee E = new Employee(
                            rs.getInt("idpersonale"),
                            rs.getString("nome"),
                            rs.getString("cognome")

                    );
                    Employee_list.add(E);
                    System.out.println("Employee aggiunto alla lista");
                }
                System.out.println("Trasformazione completata con successo");
            }

        }catch (SQLException e) {
            System.err.println("Errore durante l'esecuzione della query:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Errore generico durante il recupero degli Employe:");
            e.printStackTrace();
        }

        return Employee_list;
    }


    public Employee getEmployeeById(Query query) {
        Employee E = null;

        try {
            try(ResultSet rs = executeQuery.executeGet(query)) {
                if (rs == null || rs.isClosed()) {
                    System.err.println("ERRORE: il ResultSet è nullo o chiuso!");
                    return E; // Ritorna una lista vuota
                }

                // Trasforma il ResultSet in una lista di oggetti Utente
                if(rs.next()) {

                    E = new Employee(
                            rs.getInt("idpersonale"),
                            rs.getString("nome"),
                            rs.getString("cognome")
                    );
                }
                System.out.println("Trasformazione eseguita correttamente");
                return E;
            }
        } catch (SQLException e) {
            System.err.println("Errore durante l'esecuzione della query:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Errore generico durante il recupero degli Employe:");
            e.printStackTrace();
        }
        return null;
    }
}
