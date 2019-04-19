
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Temporary
{ 
 public static void main(String [] args)
 {
  stockPortfolio sp = new stockPortfolio();
  try{
    System.out.println(sp.getQuote("TD"));
  }
  catch (IOException ex) {
     Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
 }

 }}