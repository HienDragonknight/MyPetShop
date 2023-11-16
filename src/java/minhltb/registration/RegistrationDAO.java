/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhltb.registration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import minhltb.util.DBHelper;

/**
 *
 * @author Minh
 */
public class RegistrationDAO implements Serializable {

    public boolean checkLogin(String username, String password) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            //1. Create Connection
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
//                String sql = "Select username "
//                        + "From Registration "
//                        + "Where username = ? "
//                        + "And password = ? ";
                String sql = "Select [username],[password],[lastname],[isAdmin] \n"
                        + "from [dbo].[Registration]\n"
                        + "where [username]= ? and [password] = ? ";
                //3.Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4.Execute Query
                rs = stm.executeQuery();
                //5. Process
                if (rs.next()) {
                    result = true;
                }//username and password is existed
            }//end connection is open
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
