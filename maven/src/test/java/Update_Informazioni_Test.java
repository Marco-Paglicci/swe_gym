import Client_GUI_Controller.Modify_Interface;
import models.Client;
import models.Subscrition;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Update_Informazioni_Test {
    private static final String URL = "jdbc:mysql://localhost:3306/palestradb";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    static Connection testConnection;

    static String name = "Mario";
    static String cognome = "Rossi";
    String newname = "testnome";
    String newcognome = "testcognome";


    @BeforeAll
    static void setUp() throws SQLException
    {
        System.out.println("SETUPPING");
        testConnection = DriverManager.getConnection(URL, USER, PASSWORD);
    }


    @Test
    void update_informazioni()
    {
        try{

            Date scadenza = Date.valueOf("2027-11-12");
            Subscrition abbonamento = new Subscrition(false, scadenza);
            Client C = new Client(1000,name,cognome,abbonamento);

            Modify_Interface MI = new Modify_Interface(C);

            MI.modificaInformazioni(C,newname,newcognome);
            System.out.println("Modifica avvenuta con successo");

            System.out.println("trying fetching the changes : ");
            String query = "SELECT * FROM utenti WHERE idUtenti = ? ";
            System.out.println(query);

            PreparedStatement pstmt = testConnection.prepareStatement(query);
            pstmt.setInt(1, C.getID());

            System.out.println("statement ready");
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Query executed");

            assertTrue(rs.next());
            assertEquals(newname,rs.getString("Nome"));
            assertEquals(newcognome,rs.getString("Cognome"));

            pstmt.close();

        }catch (SQLException e)
        {
            fail("Errore nella connessione al database di test: " + e.getMessage());
        }
    }

    @AfterAll
    public static void tearDown() throws SQLException
    {
        System.out.println("Executing teardown");
        String query = "UPDATE utenti SET Nome = '" + name + "', Cognome = '" + cognome  + "' WHERE idUtenti = ?" ;
        PreparedStatement pstmt = testConnection.prepareStatement(query);
        pstmt.setInt(1,1000);
        pstmt.executeUpdate();
        pstmt.close();
        if(testConnection!= null)
        {
            testConnection.close();
        }
    }

}
