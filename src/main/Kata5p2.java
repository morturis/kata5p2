package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.Histogram;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;
import view.MailListReaderDDBB;

public class Kata5p2 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        //String fileName = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata4\\emails.txt";
        String fileName = "C:\\Users\\usuario\\Downloads\\SQLiteDatabaseBrowserPortable\\Data\\Kata5.db";
        /*
        Class.forName("org.sqlite.JDBC");
        Connection cm = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\usuario\\Downloads\\SQLiteDatabaseBrowserPortable\\Data\\Kata5.db");
        Statement st = cm.createStatement();        
        System.out.println(st.executeQuery("select count(*) from a").getInt(1));
        */
        output(process(input(fileName)));        
    }
    private static List<String> input(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        return MailListReaderDDBB.read(fileName);        
    }
    private static Histogram<String> process(List<String> mailList){        
        return MailHistogramBuilder.build(mailList);
    }
    private static void output(Histogram<String> histogram){
        HistogramDisplay histoDisplay = new HistogramDisplay (histogram);
        histoDisplay.execute(); //hace visible
    }
}
