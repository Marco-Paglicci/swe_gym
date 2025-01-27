import Employee_GUI_Controller.Interface_Client;
import models.Client;
import models.Employee;
import models.Subscrition;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;



public class Add_Utente_Test {



    private static final String URL = "jdbc:mysql://localhost:3306/palestradb";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";
    int count = 15;

    static Connection testConnection;

    static Client C;

    @BeforeAll
    static void setUp() throws SQLException
    {
        System.out.println("SETUPPING");
        testConnection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Test
    void test_addCliente() {
        try{



            Employee E = new Employee(1,"marco","paglicci");

            int id = count++;
            String nome = "Mario";
            String cognome = "Rossi";
            Date scadenza = Date.valueOf("2027-11-12");
            Subscrition abbonamento = new Subscrition(false, scadenza);
            C = new Client(id, nome, cognome, abbonamento);

            Interface_Client EC = new Interface_Client(E);

            EC.aggiungi_cliente(id,nome,cognome,scadenza);


            System.out.println("trying fetching the new insert client : ");

            String query = "SELECT * FROM utenti WHERE utenti.idUtenti= ? ";

            System.out.println(query);
            PreparedStatement pstmt = testConnection.prepareStatement(query);

            pstmt.setInt(1, C.getID());

            System.out.println("statement preperad");
            ResultSet rs = pstmt.executeQuery();

            assertTrue(rs.next());
            assertEquals("Mario", rs.getString("nome"), "Il nome non corrisponde.");
            assertEquals("Rossi", rs.getString("cognome"), "Il cognome non corrisponde.");
            assertEquals(Date.valueOf("2027-11-12"), rs.getDate("scadenza"), "La scadenza non corrisponde.");

            pstmt.close();

        } catch (SQLException e) {
            fail("Errore nella connessione al database di test: " + e.getMessage());
        }
    }
    @AfterAll
    public static void tearDown() throws SQLException
    {
        System.out.println("Executing teardown");
        String query = "DELETE FROM utenti WHERE utenti.idUtenti = ?";
        PreparedStatement pstmt = testConnection.prepareStatement(query);
        pstmt.setInt(1,C.getID());
        pstmt.executeUpdate();
        pstmt.close();

        if(testConnection!= null)
        {
            testConnection.close();
        }
    }
}







