
import Employee_GUI_Controller.Employee_Interface;
import Employee_GUI_Controller.Interface_Client;
import PT_GUI_Controller.Client_Interface;
import PT_GUI_Controller.PT_Interface;
import models.Client;
import models.Employee;
import models.Personal_Trainer;
import models.Subscrition;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;

import src.DB_Add.Add_Controller;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;




public class PT_getClient_Test {

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
    void test_getClient()
    {
        try{

            //setup Interfaccia

            Personal_Trainer PT = new Personal_Trainer(10,"Riccardo","Mancini",22,"Giovane ragazzo esperto in pilates",4.3);
            PT_Interface PI = new PT_Interface(PT);
            Client_Interface CI = new Client_Interface(PT);

            System.out.println(">Prelevo tabella clienti");


            List<Client> client_list = CI.getClientiAssociati();
            List<Client> utenti = new ArrayList<>();



            System.out.println("Generating query");

            //metto su clientlist i clienti prelevati da client
            //interface per confrontarli coi risultati della query

            String query = "SELECT utenti.idUtenti,utenti.Nome,utenti.Cognome,utenti.metodo_di_pagamento,utenti.scadenza,utenti.premium " +
                    "FROM utenti  LEFT JOIN affilliazione ON  utenti.idUtenti = affilliazione.idUtente" +
                    " WHERE idPersonaltrainer = ? ";

            System.out.println(query);

            PreparedStatement pstmt = testConnection.prepareStatement(query);
            pstmt.setInt(1, PT.getID());

            System.out.println("statement ready");

            ResultSet rs = pstmt.executeQuery();

            //controllo che rs non sia vuoto
            assertTrue(rs.next());

            // Trasforma il ResultSet in una lista di oggetti Utente
            while (rs.next()) {
                Subscrition sb = new Subscrition(
                        rs.getBoolean("premium"),
                        rs.getDate("scadenza")
                );
                Client utente = new Client(
                        rs.getInt("idUtenti"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        sb
                );
                utenti.add(utente);
            }



            for(Client cliente : client_list )
            {
                for (Client c : utenti)
                {
                    assertEquals(cliente,c);
                }

            }

            pstmt.close();

        }catch (SQLException e) {
            fail("Errore nella connessione al database di test: " + e.getMessage());
        }
    }

    @AfterAll
    public static void tearDown() throws SQLException
    {
        System.out.println("Executing teardown");
        if(testConnection!= null)
        {
            testConnection.close();
        }
    }
}
