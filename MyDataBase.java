import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class MyDataBase {

    private final String pilote = "com.mysql.jdbc.Driver";
    private final String url ="jdbc:mysql://localhost/java_mini-projet";
    private final String nom_utilisateur ="root";
    private final String password = "";
    private Connection maConnection;
    private Statement stm ;
    private ResultSet res;
    MyDataBase(){
        initDB();
    }

    private void initDB() {
        try
        {
            Class.forName (pilote);
        }
        catch(ClassNotFoundException e)
        {
            System.err.println("Driver loading error: " + e);
        }

        //2)Etape 2:	Etablir une connexion ==>
        try
        {
            maConnection = DriverManager.getConnection(this.url,this.nom_utilisateur,this.password);
        }
        catch(SQLException e)
        {
            System.err.println("Error opening SQL connection: " + e);
        }


        //3)Etape 3:	Cr�er un objet Statement ==>
        try
        {
            stm = maConnection.createStatement();
        }
        catch(SQLException e)
        {
            System.err.println("Error creating SQL statement: " + e);
        }
    }



    public int Ajouter(Personne personne)
    {
        try
        {

            int resUpd=stm.executeUpdate("INSERT INTO personne (nom, genre) VALUES ('"+personne.getNom()+"','"+personne.getGenre()+"')");
            return resUpd;
        }
        catch(SQLException e)
        {
            System.err.println("Error executing query: " + e);
        }
        return 0;
    }
    public int Supprimer(int id)
    {
        try
        {
            int resUpd=stm.executeUpdate("DELETE FROM personne WHERE id="+id);
            return resUpd;
        }
        catch(SQLException e)
        {
            System.err.println("Error executing query: " + e);
        }
        return 0;
    }
    public int Modifier(int id, String nom, String genre)
    {
        try
        {
            int resUpd=stm.executeUpdate("UPDATE personne set nom='"+nom+"', genre='"+genre+"' WHERE id="+id);
            return resUpd;
        }
        catch(SQLException e)
        {
            System.err.println("Error executing query: " + e);
        }
        return 0;
    }
    public void remplirTab(DefaultTableModel model) {
        try {
            model.setRowCount(0);
            this.res = this.stm.executeQuery("select * from personne");
            Object[] ligne = new Object[model.getColumnCount()];

            while(this.res.next()) {
                for(int i = 0; i < ligne.length; ++i) {
                    ligne[i] = this.res.getString(i+1);
                }
                model.addRow(ligne);
            }
        } catch (SQLException var5) {
            System.err.println("Error executing query: " + var5);
        }

    }
    public String getPersonneByGenre(String genre)  {
        String result ="";
        try {
            this.res = this.stm.executeQuery("select count(*) from personne where genre ='"+genre+"'");
            while (this.res.next()) {
                result = this.res.getString(1);
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }


    public String getPersonnes()  {
        String result ="";
        try {
            this.res = this.stm.executeQuery("select count(*) from personne");
            while (this.res.next()) {
                result = this.res.getString(1);
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

}
