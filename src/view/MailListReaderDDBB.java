package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MailListReaderDDBB {
    
    public static List<String> read (String fileName) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        Connection cm = DriverManager.getConnection("jdbc:sqlite:"+fileName);
        Statement st = cm.createStatement();        
        ResultSet rs = st.executeQuery("select Mail from a");
        
        List<String> mailList = new ArrayList<>();
        String leido;
        while(rs.next()){
            if((leido=rs.getString("Mail")).contains("@")){
                //System.out.println(leido);
                mailList.add(leido);
            }            
        }
        
        return mailList;
    }
}