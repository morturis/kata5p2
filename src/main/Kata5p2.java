package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import model.Histogram;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;

public class Kata5p2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileName = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata4\\emails.txt";
        
        output(process(input(fileName)));        
    }
    private static List<String> input(String fileName) throws FileNotFoundException, IOException{
        return MailListReader.read(fileName);        
    }
    private static Histogram<String> process(List<String> mailList){        
        return MailHistogramBuilder.build(mailList);
    }
    private static void output(Histogram<String> histogram){
        HistogramDisplay histoDisplay = new HistogramDisplay (histogram);
        histoDisplay.execute(); //hace visible
    }
}
