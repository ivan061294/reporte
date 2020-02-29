package javaapplication1;

import java.security.Principal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import sun.security.krb5.internal.ktab.KeyTabConstants;

public class JavaApplication1 {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/apple?user=root&password=mysqladmin";
            Connection connect = DriverManager.getConnection(url);
            Statement statement = connect.createStatement();
            String query = "SELECT * FROM dispositivo";
            ResultSet resultSet = statement.executeQuery(query);
            String format = "|%1$-3d|%2$-17s|%3$-5d|%4$-17s\n";
            while (resultSet.next()) {
                int id_dipositivo = resultSet.getInt("id_dispositivo");
                String descProd = resultSet.getString("nombre");
                int precio = resultSet.getInt("precio");
                String tipo = resultSet.getString("tipo");
                System.out.format(format, id_dipositivo, descProd, precio, tipo);
            }
            Scanner scan = new Scanner(System.in);
            System.out.println("¿Qué deseas hacer: INSERTAR / BORRAR / CONSULTAR / ACTUALIZAR ?");
            String accion = scan.nextLine();
            if (accion.equals("INSERTAR")) {
                scan = new Scanner(System.in);
                System.out.println("Ingresa el id_dispositivo");
                String id_dispositivo = scan.nextLine();

                scan = new Scanner(System.in);
                System.out.println("Ingresa el nombre");
                String nombre = scan.nextLine();

                scan = new Scanner(System.in);
                System.out.println("Ingresa el precio");
                int precio = scan.nextInt();

                scan = new Scanner(System.in);
                System.out.println("Ingresa el tipo");
                String tipo = scan.nextLine();

                query = "{call insertar_dispositivo(?, ?, ?, ?)}";
                CallableStatement stmt = connect.prepareCall(query);
                stmt.setInt(1, Integer.parseInt(id_dispositivo));
                stmt.setString(2, nombre);
                stmt.setInt(3, precio);
                stmt.setString(4, tipo);
                stmt.execute();

            } else if (accion.equals("BORRAR")) {
                scan = new Scanner(System.in);
                System.out.println("Ingresa el id_dispositivo");
                String id_disp = scan.nextLine();

                query = "{call eliminar_dispositivo(?)}";
                PreparedStatement ps = connect.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(id_disp));
                ps.executeUpdate();
            } else if (accion.equals("ACTUALIZAR")) {
                scan = new Scanner(System.in);
                System.out.println("Ingresa el id_dispositivo");
                String id_dispositivo = scan.nextLine();

                scan = new Scanner(System.in);
                System.out.println("Ingresa el nombre");
                String nombre = scan.nextLine();

                scan = new Scanner(System.in);
                System.out.println("Ingresa el precio");
                int precio = scan.nextInt();

                scan = new Scanner(System.in);
                System.out.println("Ingresa el tipo");
                String tipo = scan.nextLine();

                query = "{call actualizar_dispositivo(?,?,?,?)}";
                PreparedStatement stmt = connect.prepareStatement(query);
                stmt.setInt(1, Integer.parseInt(id_dispositivo));
                stmt.setString(2, nombre);
                stmt.setInt(3, precio);
                stmt.setString(4, tipo);
                stmt.execute();
            }
            try {
                conectar con = new conectar();
                con.conectar();
                String dir = "C:\\Users\\Administrador.W10L03M10\\Desktop\\pea1-sql-java\\src\\ivan.JRXML";
                JasperReport reportejasper = JasperCompileManager.compileReport(dir);
                JasperPrint mostrarreporte = JasperFillManager.fillReport(reportejasper, null, con.getConn());
                JasperViewer.viewReport(mostrarreporte);
            } catch (Exception e) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, e);
            }
            resultSet.close();
            statement.close();
            connect.close();

        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
