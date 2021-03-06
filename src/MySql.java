import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

    public class MySql {
        
        private String user;
        private String pw;
        private String dataBaseName;
        private String host;
        private String url;
       private  String table_name;
        public Connection conexion = null;
       
        
        public MySql() throws SQLException, ClassNotFoundException{
            user = "root";//comunmente el user es root
            pw = "mysql";//la clave
            dataBaseName = "bdfcaiceo";//nombre de la base de datos
            table_name="datosfcaiceo";
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
   
      public void insertData(String rut, String name , String apellido,String salario,char sexo,int gastos, int restante,int ahorro , int gananciaA, int ahorroA)
     {
          System.out.println("entro");
        try {
            String Query = "INSERT INTO " + table_name + " VALUES("
                    + "\"" + rut + "\", "
                    + "\"" + name + "\", "
                    + "\"" + apellido + "\", "
                     + "\"" + Integer.parseInt(salario)+"\", "
                     + "\"" + sexo + "\", "
                     + "\"" + gastos+ "\", "
                     + "\"" + restante + "\", "
                     + "\"" + ahorro + "\", "
                     + "\"" + gananciaA + "\", "
                     + "\"" + ahorroA      
                    + "\");";
            System.out.println(Query);
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
           
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
        }
      
      
      public void buscar(String columna , String buscado , DefaultTableModel model )
      {
      
       try
            {
                String query = "SELECT * FROM "+table_name + " WHERE "+ columna + " = " +"\"" + buscado + "\" "+";";
                Statement st = conexion.createStatement();
                System.out.println(query);
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    String rut = rs.getString("rut");
                    String nombre = rs.getString("nombre"); //aqui solo mando a escribir las dos primeras columnas
                    String apellido= rs.getString("apellido");
                    int Salario=rs.getInt("SALARIO");
                    String sexo=rs.getString("sexo");
                    int gastos=rs.getInt("total_gastos");      
                    int restante=rs.getInt("Restante_gastos");
                    int ahorro=rs.getInt("monto_ahorro");
                    int gananciaA=rs.getInt("Resultado_sa");
                     int ahorroA=rs.getInt("resultado_ahorro_anual");
                    model.addRow(new Object[]{rut,nombre,apellido,Salario,sexo,gastos,restante,ahorro,gananciaA,ahorroA});
                }
                st.close();
                }
            catch (Exception e)
            {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }
      
      
      
      
      }

       public void SelectData(DefaultTableModel model )
      {
            try
            {
                String query = "SELECT * FROM "+table_name;
                Statement st = conexion.createStatement();

                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                  String rut = rs.getString("rut");
                    String nombre = rs.getString("nombre"); //aqui solo mando a escribir las dos primeras columnas
                    String apellido= rs.getString("apellido");
                    int Salario=rs.getInt("SALARIO");
                    String sexo=rs.getString("sexo");
                    int gastos=rs.getInt("total_gastos");      
                    int restante=rs.getInt("Restante_gastos");
                    int ahorro=rs.getInt("monto_ahorro");
                    int gananciaA=rs.getInt("Resultado_sa");
                     int ahorroA=rs.getInt("resultado_ahorro_anual");
                    model.addRow(new Object[]{rut,nombre,apellido,Salario,sexo,gastos,restante,ahorro,gananciaA,ahorroA});
                }
                st.close();
                }
            catch (Exception e)
            {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }
    }
       
    public boolean modificar(String rut,String campo, String nuevo){
        boolean exito=false;
        try
        {
            String query = "UPDATE  datosfcaiceo set "+campo+" = "+ "\"" + nuevo + "\" " + " where rut = "+"\"" + rut + "\" "+";";
            System.out.print(query);
            Statement st = conexion.createStatement();
            int cantidad = st.executeUpdate(query);
            if (cantidad==1) {
                exito=true;
            } else {
                exito=false;
            }
        }
        catch (Exception e)
        {
        }
        return exito;
    }
        
      

    
      public void deleteRecord( String ID) {
        try {
            String Query = "DELETE FROM " + table_name + " WHERE RUT = \"" + ID + "\"";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
        }
    }
    boolean existe(String ID)
    {
    	boolean exists=false;
    	
    	try {
    		String query = "SELECT COUNT(*) AS contador FROM " + table_name + " WHERE rut='"+ ID +"'";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query); 
                 while(rs.next()){
                     if(0 == rs.getInt("contador"))
                         exists=false;
                     else
                         exists=true;
                 }
                
          
    	}
    	 catch (SQLException ex) {
            
         }
    	
    	return exists;
    	
    }
    
    }
   

  

  

