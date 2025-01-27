import Client_GUI_Controller.Notification_Interface;
import models.Client;
import models.Personal_Trainer;
import models.Subscrition;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class Send_Message_Test {

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
    void test_messaggio()
    {
        try
        {
            Date scadenza = Date.valueOf("2027-11-12");
            Subscrition abbonamento = new Subscrition(false, scadenza);
            Client C = new Client(1000,"Mario","Rossi",abbonamento);

            Personal_Trainer PT = new Personal_Trainer(10,"Riccardo","Mancini",22,"Giovane ragazzo esperto in pilates",4.3);

            Notification_Interface NI = new Notification_Interface(C);

            System.out.println("trying sending message");
            String message = "test";
            NI.message_reply(PT.getID(),message);

            System.out.println("trying fetching the new messaggio : ");
            String query = "SELECT * FROM messaggio_u_pt WHERE destinatario = ?";

            System.out.println(query);
            PreparedStatement pstmt = testConnection.prepareStatement(query);
            pstmt.setInt(1, PT.getID());

            System.out.println("statement ready");
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Query executed");

            assertTrue(rs.next());
            assertEquals(C.getID(),rs.getInt("mittente"));
            assertEquals(PT.getID(),rs.getInt("destinatario"));
            assertEquals(message,rs.getString("messaggio"));

            pstmt.close();

        }catch (SQLException e) {
            fail("Errore nella connessione al database di test: " + e.getMessage());
        }
    }

    @AfterAll
    public static void tearDown() throws SQLException
    {
        System.out.println("Executing teardown");
        String query = "DELETE FROM messaggio_u_pt WHERE destinatario = ?";
        PreparedStatement pstmt = testConnection.prepareStatement(query);
        pstmt.setInt(1,10);
        pstmt.executeUpdate();
        pstmt.close();
        if(testConnection!= null)
        {
            testConnection.close();
        }
    }
}
