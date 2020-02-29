
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;

public class conectar {
      Connection conectar= null;
      private Connection conn;

    public conectar(Connection conn) {
        this.conn = conn;
    }

    conectar() {
try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/apple?user=root&password=mysqladmin";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.err.println(e);
        }    }

    public Connection getConectar() {
        return conectar;
    }

    public void setConectar(Connection conectar) {
        this.conectar = conectar;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
     
   public Connection conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/apple?user=root&password=mysqladmin";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.err.println(e);
        }
        return conectar();
    }
}
