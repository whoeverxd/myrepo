import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


    public class MySql {
        
        private String user;
        private String pw;
        private String dataBaseName;
        private String host;
        private String url;
        public Connection conexion = null;
       
        
        public MySql() throws SQLException, ClassNotFoundException{
            user = "root";//comunmente el user es root
            pw = "mysql";//la clave
            dataBaseName = "bdfcaiceo";//nombre de la base de datos
            host = "localhost";
            url = "jdbc:mysql://" + host + "/" + dataBaseName;   
            Conectar();
        }
        public void Conectar() throws SQLException, ClassNotFoundException
        {
             Class.forName("com.mysql.jdbc.Driver");            
             conexion = DriverManager.getConnection(url, user, pw);        
             System.out.println("Conexion on");
        }
        public void Desconectar() throws SQLException,ClassNotFoundException
        {
            conexion.close();
            System.out.println("Conexion off");
        }
   
      public void insertData(String table_name, String rut, String name)
      {
        try {
            String Query = "INSERT INTO " + table_name + " VALUES("
                    + "\"" + rut + "\", "
                    + "\"" + name + "\")";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
        }

    
      public void deleteRecord(String table_name, String ID) {
        try {
            String Query = "DELETE FROM " + table_name + " WHERE ID = \"" + ID + "\"";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
        }
    }
    
    
    }
   

  

  

