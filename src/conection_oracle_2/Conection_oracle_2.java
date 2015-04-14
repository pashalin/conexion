/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection_oracle_2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author alumno04
 */
public class Conection_oracle_2 {

    
    public Connection AbrirConexion()
    {Connection cn=conectionBD.conectar();
    return cn;}

   public static void main(String[] args) {
        Conection_oracle_2 co=new Conection_oracle_2();
//        if (conectionBD.conectar()==null) {
//            System.out.println("La conexion falló.");
//        } else { System.out.println("La conexion fue un éxito.");
//        }
        //metodo q inserta un registro en la base de datos
       
       //co.insert();
       //met9odo q muestra los registros de la db
     co.select();
        //metodod q elimina registros mediante un id
       // co.delete(1);
        //metodo pára modificar u7n registro mediante un id
       // co.update(2, "Robert", "Rengifo", "Cardenas", 76645994);
    }
    public void insert(){
        Statement st=null;
        String query="insert into persona values (2,'Randolf','Cardenas','Rengifo',22852515)";
        try {
            st=AbrirConexion().createStatement();
            st.executeUpdate(query);
            AbrirConexion().commit();
            AbrirConexion().close();
            System.out.println("se inserto satisfactoriamente");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                AbrirConexion().rollback();
                AbrirConexion().close();
                
            } catch (Exception ex) {
            }
        }
    }
    public void select(){
    Statement st= null;
        ResultSet rs= null;
        String query="select * from persona";
        try {
            st= AbrirConexion().createStatement();
            rs=st.executeQuery(query);
            while (rs.next()) {                
                System.out.println("ID:"+rs.getInt("idpersona")+",nombre:"+rs.getString("nombre")
                +",apellido_pat:"+rs.getString("apellido_pat")+",apellido_mat:"+rs.getString("apellido_mat")
                        +",DNI:"+rs.getInt("dni"));
            }
            AbrirConexion().close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                AbrirConexion().close();
            } catch (Exception ex) {
            }
        }
    }
    
    public void delete(int id){
       
        Statement st= null;       
        String query="delete from persona where idpersona="+id;
        try {
            st=AbrirConexion().createStatement();
            st.executeUpdate(query);
            AbrirConexion().commit();
            AbrirConexion().close();
            System.out.println("se elimino satisfactoriamente");
        } catch (Exception e) {
            e.printStackTrace();
            
            try {
                AbrirConexion().rollback();
                AbrirConexion().close();
            } catch (Exception ex) {
            }
        }
    }
    public void update(int id, String nombre, String apellido_pat, String apellido_mat, int dni){
    Statement st= null;
    String query="update persona set nombre='"+nombre+"',apellido_pat='"+apellido_pat+"',apellido_mat='"+apellido_mat+"',dni="+dni+" where idpersona="+id;
        try {
            st=AbrirConexion().createStatement();
            st.executeUpdate(query);
            AbrirConexion().commit();
            AbrirConexion().close();
             System.out.println("se modifico satisfactoriamente");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                AbrirConexion().rollback();
                AbrirConexion().close();
            } catch (Exception ex) {
            }
        }
    }
}
    

