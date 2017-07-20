package com.example;

import com.example.livestore.ItemDAO;
import com.example.livestore.ItemDAOMySQL;
import com.example.livestore.ItemDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("model", "Java");
        return "hello";
    }

    @RequestMapping("/shop")
    public String url2(Model model) {
        String mysqlJdbcUrl = "jdbc:mysql://localhost/"
                + "mydb1"
                + "?user=root"
                + "&password=password";

        Connection conn;
        try {
            conn = DriverManager.getConnection(mysqlJdbcUrl);
            ItemDAO doa = new ItemDAOMySQL(conn);
            ItemDTO item = doa.get(1);
            model.addAttribute("model", item);
        } catch (SQLException ex) {
            
            Logger.getLogger(Hello.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "shop";
    }

}
