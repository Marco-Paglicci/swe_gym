
import Client_GUI_Controller.class_Interface;
import models.Client;
import models.Corso;
import models.Subscrition;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Client_IscrizioneCorso_Test
{
    private static final String URL = "jdbc:mysql://localhost:3306/palestradb";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    static Connection testConnection;

    @BeforeAll
    static void setUp() throws SQLException
    {
        System.out.println("SETUPPING");
        testConnection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Test
    void test_iscrizione()
    {
        try{

            Date scadenza = Date.valueOf("2027-11-12");
            Subscrition abbonamento = new Subscrition(false, scadenza);
            Client C = new Client(1000,"Mario","Rossi",abbonamento);

            class_Interface CI = new class_Interface(C);

            Time durata = Time.valueOf("19:30:00");
            Corso corso = new Corso(1,"pilates",durata,0);

            System.out.println("trying iscrizione corso");
            CI.iscrizione_corso(corso);

            System.out.println("trying fetching the new partecipazione : ");
            String query = "SELECT * FROM partecipazione WHERE partecipazione.idUtente= ? ";

            System.out.println(query);
            PreparedStatement pstmt = testConnection.prepareStatement(query);
            pstmt.setInt(1, C.getID());

            System.out.println("statement ready");
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Query executed");


            assertTrue(rs.next());
            assertEquals(C.getID(),rs.getInt("idUtente"));
            assertEquals(corso.getId(),rs.getInt("idCorso"));

            pstmt.close();

        }catch (SQLException e) {
            fail("Errore nella connessione al database di test: " + e.getMessage());
        }
    }


    @AfterAll
    public static void tearDown() throws SQLException
    {
        System.out.println("Executing teardown");
        String query = "DELETE FROM partecipazione WHERE partecipazione.idUtente = ?";
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
