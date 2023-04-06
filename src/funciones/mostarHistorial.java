/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import loginform.DBConnection;



/**
 *
 * @author jordyvega
 */
public class mostarHistorial {
    public DefaultTableModel mostrarHistorial(){
        String [] nombreColumnas = {"Id", "Nombre","Cuenta", "Descripcion", "Monto", "Fecha"};
        String [] registros = new String[6];
        
        DefaultTableModel modelo = new DefaultTableModel(null, nombreColumnas);
        String sql = "SELECT us.id,us.nombre, cu.cuenta, trans.descripcion, trans.monto, trans.fecha_transaccion\n" +
                     "FROM user us\n" +
                     "INNER JOIN cuenta cu ON us.id = cu.id\n" +
                     "INNER JOIN transaccion trans ON cu.id = trans.id_cuenta;";
        Connection dbconn = DBConnection.connectDB();
        
        PreparedStatement pst= null;
        
        ResultSet rs = null;
        
        try{
            pst = dbconn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("id");
                
                registros[1] = rs.getString("nombre");
                
                registros[2] = rs.getString("cuenta");
                registros[3] = rs.getString("descripcion");
                registros[4] = rs.getString("monto");
                registros[5] = rs.getString("fecha_transaccion");

                modelo.addRow(registros);
                
            }
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"Error al conectar");
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (dbconn != null) dbconn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
        
    }
}
