/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.Category;

/**
 *
 * @author Admin
 */
public class CategoryServices {
    public static List<Category> readCategories() 
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/englishdb2",
                "root", "123456");
        
        String q = "SELECT * FROM category";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(q);
        
        List<Category> kq = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Category c = new Category(id, name);
            
            kq.add(c);
        }
        
        conn.close();
        
        return kq;
    }
}
