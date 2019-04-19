
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

// By Yagnik Patel
public class sqlDataBase {
    public String username = null;
    public String password = null; 
    public int id;
    boolean flag = false;
    
    /**
    * Method Name: checkAccount
    * Purpose: checks if Username and password match ones in the database
    * Pre: None
    * Post: None
    * Returns: None
    * By: Yagnik
    */
    boolean checkAccount(String username, String password) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/BankUsers", "username", "password");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from ACCOUNTS");
            // Checks if there is a null point and if not continues to loop
            while (rs.next()){
                if (rs.getString(2).equals(username) && rs.getString(3).equals(password)){ // matching user found
                    return true;
                }
            }
        }
  
        catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
    * Method Name: checkAccount
    * Purpose:  registers new user into database
    * Pre: None
    * Post: None
    * Returns: None
    * By: Yagnik
    */
    void registerAccount(String username, String password){
        try {
            int balance = 0;
            int numstock1 = 0;
            int numstock2 = 0;
            int numstock3 = 0;
            String stock1 = "";
            String stock2 = "";
            String stock3 = "";
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/BankUsers", "username", "password");
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT COUNT(ID) FROM ACCOUNTS");
            rs.next();
            id = rs.getInt(1) + 1 ;
            // Inserts new user into database
            st.executeUpdate("insert into ACCOUNTS values ("+id+",'"+username+"','"+password+"',"+balance+",'"+stock1+"',"+numstock1+",'"+stock2+"',"+numstock2+",'"+stock3+"',"+numstock3+")"); 
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
    * Method Name: checkDuplicate
    * Purpose: checks if Username and password match ones in the database and if so returns a value of true
    * Pre: None
    * Post: None
    * Returns: true
    * By: Yagnik
    */
    boolean checkDuplicate(String username){
        boolean check = false;
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/BankUsers", "username", "password");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from ACCOUNTS");
            while (rs.next()){
                if  (rs.getString(2).equals(username)){
                    check = true;
                    rs.close();
                    throw new SQLException("Duplicate info<br>Username " + username );
                }
            }
    } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    return check;
    }
    
    /**
    * Method Name: checkAccount
    * Purpose: checks if User has an empty stock position and returns the position number
    * Pre: None
    * Post: None
    * Returns: Integer
    * By: Yagnik
    */
    int checkEmpty(String username, String password){
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/BankUsers", "username", "password");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from ACCOUNTS");
            while (rs.next()){
                if (rs.getString(2).equals(username) && rs.getString(3).equals(password)){
                    if (rs.getString(5).equals("")){
                        rs.close();
                        return 1;
                    }
                    else if (rs.getString(7).equals("")){
                        rs.close();
                        return 2;
                    }
                    else if (rs.getString(9).equals("")){
                        rs.close();
                        return 3;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
           }
        return 0;
    }
    
    
     /**
    * Method Name: updateStock
    * Purpose: updates user stock info
    * Pre: None
    * Post: None
    * Returns: None
    * By: Yagnik
    */
    void updateStock(int number, String username, String password, String symbol, int StockNumber){
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/BankUsers", "username", "password");
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("Select * from ACCOUNTS");
            while (rs.next()){
                if (rs.getString(2).equals(username) && rs.getString(3).equals(password)){
                    rs.updateString("STOCK"+number+"",symbol);
                    rs.updateInt("NUMSTOCK"+number+"", StockNumber);
                    rs.updateRow();
                    rs.close();
                    break;
                }
            }
            }catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    
     /**
    * Method Name: return items
    * Purpose: returns the users stock quote and name based on number inputted
    * Pre: None
    * Post: None
    * Returns: String
    * By: Yagnik
    */
    String returnItems(String username, String password, int number) throws SQLException{
            try {
                Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/BankUsers", "username", "password");
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("Select * from ACCOUNTS");
                while (rs.next()){
                    if (rs.getString(2).equals(username) && rs.getString(3).equals(password)){
                        if (number == 1){
                            if (rs.getString(5).equals("")){
                                return "new|0";
                            }
                            else {
                                String symbol = rs.getString(5);
                                int numStock = rs.getInt(6);
                                return symbol+"|"+numStock;
                            }
 
                        }
                        else if (number == 2){
                            if (rs.getString(7).equals("")){
                                return "new|0";
                            }
                            else{
                                String symbol = rs.getString(7);
                                String numStock = rs.getString(8);
                                return symbol+"|"+numStock;
                            }
                        }
                        else if (number == 3){
                            if (rs.getString(9).equals("")){
                                return "new|0";
                            }
                            else{
                                String symbol = rs.getString(9);
                                String numStock = rs.getString(10);
                                return symbol+"|"+numStock;
                            }
                        }
                    }
                }   
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "Error";
        }
    
    /**
    * Method Name: returnBalance
    * Purpose: returns the users balance from the database
    * Pre: None
    * Post: None
    * Returns: Double
    * By: Yagnik
    */
    double returnBalance(String username, String password){
        try {
                Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/BankUsers", "username", "password");
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("Select * from ACCOUNTS");
                while (rs.next()){
                    if (rs.getString(2).equals(username) && rs.getString(3).equals(password)){
                        String balance = rs.getString(4);
                        double balance1 = Double.parseDouble(balance);
                        rs.close();
                        return balance1;
                    }
                }
            }catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        return 0;
    }
    
    /**
    * Method Name: updateBalance
    * Purpose: updates the users balance from the database
    * Pre: None
    * Post: None
    * Returns: None
    * By: Yagnik
    */
    void updateBalance(String username, double balance){
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/BankUsers", "username", "password");
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("Select * from ACCOUNTS");
            while (rs.next()){
                if (rs.getString(2).equals(username)){
                    int balance1 = (int) balance;
                    rs.updateInt("BALANCE",balance1);
                    rs.updateRow();
                    rs.close();
                    break;
                }
            }
            }catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
           } 
    }
    
    /**
    * Method Name: check Username
    * Purpose: checks if user exists in database
    * Pre: None
    * Post: None
    * Returns: None
    * By: Yagnik
    */
    boolean checkUsername(String username){
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/BankUsers", "username", "password");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from ACCOUNTS");
            while (rs.next()){
                if (rs.getString(2).equals(username)){
                    rs.close();
                    return true;
                }
            } 
        }catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
    * Method Name: returnBalance
    * Purpose: returns the users balance from the database
    * Pre: None
    * Post: None
    * Returns: Double
    * By: Yagnik
    */
    double returnBalance(String username){
        try {
                Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/BankUsers", "username", "password");
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("Select * from ACCOUNTS");
                while (rs.next()){
                    if (rs.getString(2).equals(username)){
                        String balance = rs.getString(4);
                        double balance1 = Double.parseDouble(balance);
                        rs.close();
                        return balance1;
                    }
                }
            }catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        return 0;
    }
}
    
    



