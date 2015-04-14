/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection_oracle_2;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alumno04
 */
public class conectionBD {

    public static Connection conectar() {
        Connection cn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:orcl", "prueba2", "Robert1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }
}
