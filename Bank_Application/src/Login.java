/**
 * By: Yagnik, Akash, Anthony
 * For: Mr.Patterson
 * Date: June 14th 2017
 * Course: ICS4U1
 * Name of Program:AAY Banking Solutions GUI
 * Purpose: to create a bank GUI where users can conduct transactions
 */

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Main Class To Display GUI
 */

public class Login extends javax.swing.JFrame {
    //Initialize Variables
    public String username;
    public String password; 
    public int id;
    public String stock1;
    public String stock2;
    public String stock3;
    public int numStock1;
    public int numStock2;
    public int numStock3;
    private double balance;
    sqlDataBase db = new sqlDataBase();
    stockPortfolio sp = new stockPortfolio();
    MortgageClass mc = new MortgageClass();
    boolean test;
    DecimalFormat df = new DecimalFormat(".##");
 

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        loginPanel();
    }
    
    // Displays only the login panel
    void loginPanel(){
        loginPanel.setVisible(true);
        BankPanel.setVisible(false);
        StockPanel.setVisible(false);
        AccountPanel.setVisible(false);
        usernameTxt.setText("");
        passwordTxt.setText("");
        this.setSize(601, 390);
    }
    
    // Displays only the bank panel
    void bankPanel(){
        loginPanel.setVisible(false);
        BankPanel.setVisible(true);
        StockPanel.setVisible(false);
        AccountPanel.setVisible(false);
        this.setSize(681, 395);
    }
    
    // Displays only the stock panel
    void stockPanel(){
        StockPanel.setVisible(true);
        loginPanel.setVisible(false);
        BankPanel.setVisible(false);
        AccountPanel.setVisible(false);
        this.setSize(1020, 429);
    }
    
    // Displays only the account panel
    void AccountPanel(){
        StockPanel.setVisible(false);
        loginPanel.setVisible(false);
        BankPanel.setVisible(false);
        AccountPanel.setVisible(true);
        this.setSize(552, 287);
    }
  
    // Displays only the account panel
    void mortgagePanel(){
        StockPanel.setVisible(false);
        loginPanel.setVisible(false);
        BankPanel.setVisible(false);
        AccountPanel.setVisible(false);
        MortgagePanel.setVisible(true);
        this.setSize(736, 325);
    }
    
    /**
    * Method Name: getTableValues
    * Purpose: To get the table values for stock name and price from the Accounts database using the sqlDataBase class
    * Pre: None
    * Post: None
    * Returns: returns an object that is made up of a string,string,string,integer,string array.
    * By: Yagnik
    */
    Object[] getTableValues(int number) throws SQLException, IOException{
        String uno = db.returnItems(username, password, number); // sqlDataBase method which returns stock price and name based on user,pass, and stock position provided
        if (uno.contains("new")){ // check if stock is not avalible and create a blank object
            Object[] objects = new Object[]{number, ".", ".", "$0", 0, "$0"};
        }
        // if stock is avalible then the string is seperated into the name and price and then an obejct is created with that data
        else{
            String unoStock = uno.substring(0, uno.indexOf("|"));
            int unoNumber = Integer.parseInt(uno.substring(uno.indexOf("|") + 1, uno.length()));
            String quote1 = sp.getQuote(unoStock);
            String name1 = quote1.substring(0, quote1.indexOf("|"));
            String price1 = quote1.substring(quote1.indexOf("|") + 2, quote1.length());
            double prices = Double.parseDouble(price1);
            double values = prices * unoNumber;
            String totalz = "$"+df.format(values)+"";
            Object[] objects = new Object[]{number, name1, unoStock, "$"+price1, unoNumber, totalz};
            return objects; 
        }
        // default case to return a blank object
        Object[] objects = new Object[]{number, ".", ".", "$0", 0, "$0"};
        return objects;
    }
    
    /**
    * Method Name: changeObject
    * Purpose: To see if an object is of an integer type or a string type and return it as a string
    * Pre: None
    * Post: None
    * Returns: A string object
    * By: Yagnik
    */
    
    String changeObject (Object obj){
        Object priceNumber = obj;
        if (priceNumber instanceof Integer){
            String pricesNumber = Integer.toString((int)priceNumber);
            return pricesNumber;
        }
        else if(priceNumber instanceof String){
            String pricesNumber = (String) priceNumber;
            return pricesNumber;
        }
        return "0";
    }
    
    /**
     * Code created by NetBeans for the alignment and positioning of swing class elements.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new javax.swing.JPanel();
        signUpPanel = new javax.swing.JPanel();
        signupLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        signInBtn = new javax.swing.JButton();
        signUpBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        usernameTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JPasswordField();
        correctLabel = new javax.swing.JLabel();
        bankNameLabel = new javax.swing.JLabel();
        sloganLabel = new javax.swing.JLabel();
        iconLabel = new javax.swing.JLabel();
        BankPanel = new javax.swing.JPanel();
        bankNameLabel2 = new javax.swing.JLabel();
        accountBtn = new javax.swing.JButton();
        mortgageBtn = new javax.swing.JButton();
        stockBtn = new javax.swing.JButton();
        accountLbl1 = new javax.swing.JLabel();
        accountLbl2 = new javax.swing.JLabel();
        mortgageLbl1 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        mortgageLbl2 = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        stockLbl1 = new javax.swing.JLabel();
        stockLbl2 = new javax.swing.JLabel();
        accountImg = new javax.swing.JLabel();
        mortgageImg = new javax.swing.JLabel();
        stockImg = new javax.swing.JLabel();
        exit2Btn = new javax.swing.JButton();
        StockPanel = new javax.swing.JPanel();
        bankNameLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        subTitleLbl = new javax.swing.JLabel();
        buyBtn = new javax.swing.JButton();
        sellBtn = new javax.swing.JButton();
        stockSelectBox = new javax.swing.JComboBox<>();
        numberTxt = new javax.swing.JTextField();
        infoLbl = new javax.swing.JLabel();
        symbolTxt = new javax.swing.JTextField();
        exisStockLbl = new javax.swing.JLabel();
        newStockLbl = new javax.swing.JLabel();
        numberLbl = new javax.swing.JLabel();
        errorLbl = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        AccountPanel = new javax.swing.JPanel();
        titleLbl = new javax.swing.JLabel();
        depositBtn = new javax.swing.JButton();
        withdrawBtn = new javax.swing.JButton();
        balanceLbl = new javax.swing.JLabel();
        transferBtn = new javax.swing.JButton();
        changeTxt = new javax.swing.JTextField();
        instructionsLbl = new javax.swing.JLabel();
        userTxt1 = new javax.swing.JTextField();
        exitBtn1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        MortgagePanel = new javax.swing.JPanel();
        titleLbl1 = new javax.swing.JLabel();
        exitBtn2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Box1 = new javax.swing.JComboBox<>();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        t3 = new javax.swing.JTextField();
        t4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        calculateMortgage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        loginPanel.setBackground(new java.awt.Color(97, 212, 195));

        signUpPanel.setBackground(new java.awt.Color(36, 47, 65));
        signUpPanel.setToolTipText("");

        signupLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        signupLabel.setForeground(new java.awt.Color(255, 255, 255));
        signupLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signupLabel.setText("Sign in Or Sign Up");

        passwordLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordLabel.setText("PASSWORD");

        usernameLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setText("USERNAME");

        signInBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        signInBtn.setForeground(new java.awt.Color(36, 47, 65));
        signInBtn.setText("Sign In");
        signInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInBtnActionPerformed(evt);
            }
        });

        signUpBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        signUpBtn.setText("Sign Up");
        signUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });

        usernameTxt.setBackground(new java.awt.Color(36, 47, 65));
        usernameTxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        usernameTxt.setForeground(new java.awt.Color(255, 255, 255));
        usernameTxt.setBorder(null);
        usernameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTxtActionPerformed(evt);
            }
        });

        passwordTxt.setBackground(new java.awt.Color(36, 47, 65));
        passwordTxt.setForeground(new java.awt.Color(255, 255, 255));
        passwordTxt.setBorder(null);

        correctLabel.setFont(new java.awt.Font("Century Gothic", 2, 10)); // NOI18N
        correctLabel.setForeground(new java.awt.Color(255, 255, 255));
        correctLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout signUpPanelLayout = new javax.swing.GroupLayout(signUpPanel);
        signUpPanel.setLayout(signUpPanelLayout);
        signUpPanelLayout.setHorizontalGroup(
            signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signUpPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signUpPanelLayout.createSequentialGroup()
                        .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(correctLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, signUpPanelLayout.createSequentialGroup()
                                .addComponent(signInBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addComponent(signUpBtn)))
                        .addGap(23, 23, 23)))
                .addGap(19, 19, 19))
            .addGroup(signUpPanelLayout.createSequentialGroup()
                .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signUpPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(signUpPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(signUpPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(jSeparator1)))
                    .addGroup(signUpPanelLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(signupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        signUpPanelLayout.setVerticalGroup(
            signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signUpPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(signupLabel)
                .addGap(44, 44, 44)
                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signInBtn)
                    .addComponent(signUpBtn))
                .addGap(29, 29, 29)
                .addComponent(correctLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        bankNameLabel.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        bankNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        bankNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bankNameLabel.setText("AAY Banking Solutions");

        sloganLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        sloganLabel.setForeground(new java.awt.Color(255, 255, 255));
        sloganLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sloganLabel.setText("Where Banking Is Made Simple");

        iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12669e62dbbb0c66620b9c48dd3dad.png"))); // NOI18N

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bankNameLabel)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sloganLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(signUpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signUpPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bankNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(sloganLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        BankPanel.setBackground(new java.awt.Color(36, 47, 65));

        bankNameLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        bankNameLabel2.setForeground(new java.awt.Color(255, 255, 255));
        bankNameLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bankNameLabel2.setText("AAY Banking Solutions");

        accountBtn.setText("Check Account");
        accountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountBtnActionPerformed(evt);
            }
        });

        mortgageBtn.setText("View Mortgage Options");
        mortgageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mortgageBtnActionPerformed(evt);
            }
        });

        stockBtn.setText("Stock Portfolio");
        stockBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockBtnActionPerformed(evt);
            }
        });

        accountLbl1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        accountLbl1.setForeground(new java.awt.Color(255, 255, 255));
        accountLbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accountLbl1.setText("Select this to view your account");

        accountLbl2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        accountLbl2.setForeground(new java.awt.Color(255, 255, 255));
        accountLbl2.setText("and conduct transactions.");

        mortgageLbl1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        mortgageLbl1.setForeground(new java.awt.Color(255, 255, 255));
        mortgageLbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mortgageLbl1.setText("Select this to view your mortgage");

        mortgageLbl2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        mortgageLbl2.setForeground(new java.awt.Color(255, 255, 255));
        mortgageLbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mortgageLbl2.setText("and view your options and rates.");

        stockLbl1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        stockLbl1.setForeground(new java.awt.Color(255, 255, 255));
        stockLbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stockLbl1.setText("Select this to view your portoflio");

        stockLbl2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        stockLbl2.setForeground(new java.awt.Color(255, 255, 255));
        stockLbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stockLbl2.setText("and trades socks in real time.");

        accountImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/piggy-bank-clipart-free-piggy-.png"))); // NOI18N

        mortgageImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tn_duplex-house-building-clipa.jpg"))); // NOI18N

        stockImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/b8bf249347adc1906467f9083d8efb.png"))); // NOI18N

        exit2Btn.setText("Exit");
        exit2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit2BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BankPanelLayout = new javax.swing.GroupLayout(BankPanel);
        BankPanel.setLayout(BankPanelLayout);
        BankPanelLayout.setHorizontalGroup(
            BankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BankPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BankPanelLayout.createSequentialGroup()
                        .addGroup(BankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(accountLbl1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BankPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(accountImg)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BankPanelLayout.createSequentialGroup()
                        .addGroup(BankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(accountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accountLbl2))
                        .addGap(27, 27, 27)))
                .addGroup(BankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BankPanelLayout.createSequentialGroup()
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(BankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mortgageLbl1)
                            .addComponent(mortgageLbl2)
                            .addComponent(mortgageImg, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BankPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(mortgageBtn)))
                        .addGap(10, 10, 10)
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(BankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BankPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(stockLbl1))
                            .addGroup(BankPanelLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(stockImg))
                            .addGroup(BankPanelLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(stockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BankPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(stockLbl2)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(BankPanelLayout.createSequentialGroup()
                        .addComponent(bankNameLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit2Btn)
                        .addGap(40, 40, 40))))
        );
        BankPanelLayout.setVerticalGroup(
            BankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BankPanelLayout.createSequentialGroup()
                .addGroup(BankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bankNameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit2Btn))
                .addGap(17, 17, 17)
                .addGroup(BankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BankPanelLayout.createSequentialGroup()
                        .addGroup(BankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BankPanelLayout.createSequentialGroup()
                                .addGroup(BankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(BankPanelLayout.createSequentialGroup()
                                        .addComponent(accountLbl1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(accountLbl2))
                                    .addGroup(BankPanelLayout.createSequentialGroup()
                                        .addGroup(BankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(mortgageLbl1)
                                            .addComponent(stockLbl1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(BankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(mortgageLbl2)
                                            .addComponent(stockLbl2))))
                                .addGroup(BankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BankPanelLayout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(accountImg, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(accountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BankPanelLayout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addGroup(BankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(mortgageImg)
                                            .addComponent(stockImg))
                                        .addGap(31, 31, 31)
                                        .addGroup(BankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(mortgageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(stockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(BankPanelLayout.createSequentialGroup()
                                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addContainerGap(53, Short.MAX_VALUE))))
        );

        StockPanel.setBackground(new java.awt.Color(36, 47, 65));

        bankNameLabel3.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        bankNameLabel3.setForeground(new java.awt.Color(255, 255, 255));
        bankNameLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bankNameLabel3.setText("AAY Banking Solutions");

        jScrollPane1.setEnabled(false);
        jScrollPane1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        stockTable.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, ".", null, "0",  new Integer(0), null},
                {null, ".", null, "0",  new Integer(0), null},
                {null, ".", null, "0",  new Integer(0), null}
            },
            new String [] {
                "Stock Number", "Stock Name", "Stock Symbol", "Stock Price", "Number of Stocks", "Total Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stockTable.setPreferredSize(new java.awt.Dimension(500, 100));
        stockTable.setRowHeight(25);
        jScrollPane1.setViewportView(stockTable);
        if (stockTable.getColumnModel().getColumnCount() > 0) {
            stockTable.getColumnModel().getColumn(0).setResizable(false);
            stockTable.getColumnModel().getColumn(1).setResizable(false);
            stockTable.getColumnModel().getColumn(2).setResizable(false);
            stockTable.getColumnModel().getColumn(3).setResizable(false);
            stockTable.getColumnModel().getColumn(4).setResizable(false);
            stockTable.getColumnModel().getColumn(5).setResizable(false);
        }

        subTitleLbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        subTitleLbl.setForeground(new java.awt.Color(255, 255, 255));
        subTitleLbl.setText("Your Stock Portfolio");

        buyBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        buyBtn.setText("Buy Stock");
        buyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyBtnActionPerformed(evt);
            }
        });

        sellBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        sellBtn.setText("Sell Stock");
        sellBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellBtnActionPerformed(evt);
            }
        });

        stockSelectBox.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        stockSelectBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Stock 1", "Stock 2", "Stock 3" }));
        stockSelectBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockSelectBoxActionPerformed(evt);
            }
        });

        numberTxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        infoLbl.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        infoLbl.setForeground(new java.awt.Color(255, 255, 255));
        infoLbl.setText("Select a stock number and enter an amount to either buy or sell. To buy a new stock select none , enter symbol, and amount.");

        symbolTxt.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        symbolTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                symbolTxtActionPerformed(evt);
            }
        });

        exisStockLbl.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        exisStockLbl.setForeground(new java.awt.Color(255, 255, 255));
        exisStockLbl.setText("Existing Stock");

        newStockLbl.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        newStockLbl.setForeground(new java.awt.Color(255, 255, 255));
        newStockLbl.setText("New Stock Symbol");

        numberLbl.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        numberLbl.setForeground(new java.awt.Color(255, 255, 255));
        numberLbl.setText("Number to Buy / Sell");

        errorLbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        errorLbl.setForeground(new java.awt.Color(255, 255, 255));
        errorLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        exitBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        updateBtn.setText("Update Prices");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Balance:");

        javax.swing.GroupLayout StockPanelLayout = new javax.swing.GroupLayout(StockPanel);
        StockPanel.setLayout(StockPanelLayout);
        StockPanelLayout.setHorizontalGroup(
            StockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StockPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(StockPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StockPanelLayout.createSequentialGroup()
                        .addGap(0, 256, Short.MAX_VALUE)
                        .addComponent(bankNameLabel3)
                        .addGap(299, 299, 299)
                        .addComponent(exitBtn))
                    .addGroup(StockPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(StockPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(StockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(errorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(StockPanelLayout.createSequentialGroup()
                        .addGroup(StockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exisStockLbl)
                            .addComponent(stockSelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(StockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StockPanelLayout.createSequentialGroup()
                                .addComponent(newStockLbl)
                                .addGap(82, 82, 82)
                                .addComponent(numberLbl))
                            .addGroup(StockPanelLayout.createSequentialGroup()
                                .addComponent(symbolTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(numberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(59, 59, 59)
                .addComponent(buyBtn)
                .addGap(52, 52, 52)
                .addComponent(sellBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateBtn)
                .addGap(26, 26, 26))
            .addGroup(StockPanelLayout.createSequentialGroup()
                .addGroup(StockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StockPanelLayout.createSequentialGroup()
                        .addGap(407, 407, 407)
                        .addComponent(subTitleLbl))
                    .addGroup(StockPanelLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(infoLbl)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        StockPanelLayout.setVerticalGroup(
            StockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StockPanelLayout.createSequentialGroup()
                .addGroup(StockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StockPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bankNameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(StockPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(exitBtn)))
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(subTitleLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoLbl)
                .addGap(28, 28, 28)
                .addGroup(StockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(symbolTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sellBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockSelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBtn))
                .addGap(18, 18, 18)
                .addGroup(StockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newStockLbl)
                    .addComponent(numberLbl)
                    .addComponent(exisStockLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        AccountPanel.setBackground(new java.awt.Color(36, 47, 65));

        titleLbl.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        titleLbl.setForeground(new java.awt.Color(255, 255, 255));
        titleLbl.setText("AAY Banking Solutions");

        depositBtn.setText("Deposit");
        depositBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositBtnActionPerformed(evt);
            }
        });

        withdrawBtn.setText("Withdraw");
        withdrawBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawBtnActionPerformed(evt);
            }
        });

        balanceLbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        balanceLbl.setForeground(new java.awt.Color(255, 255, 255));
        balanceLbl.setText("Your Account Balance Is: ");

        transferBtn.setText("Transfer");
        transferBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferBtnActionPerformed(evt);
            }
        });

        changeTxt.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        instructionsLbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        instructionsLbl.setForeground(new java.awt.Color(255, 255, 255));
        instructionsLbl.setText("Enter the amount you would like to deposit, withdraw, or transfer.");

        userTxt1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        exitBtn1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        exitBtn1.setText("Exit");
        exitBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtn1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter the username you want to transfer to.");

        javax.swing.GroupLayout AccountPanelLayout = new javax.swing.GroupLayout(AccountPanel);
        AccountPanel.setLayout(AccountPanelLayout);
        AccountPanelLayout.setHorizontalGroup(
            AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccountPanelLayout.createSequentialGroup()
                .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AccountPanelLayout.createSequentialGroup()
                        .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AccountPanelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AccountPanelLayout.createSequentialGroup()
                                        .addComponent(changeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(depositBtn))
                                    .addComponent(balanceLbl)
                                    .addComponent(instructionsLbl)))
                            .addGroup(AccountPanelLayout.createSequentialGroup()
                                .addGap(362, 362, 362)
                                .addComponent(withdrawBtn))
                            .addGroup(AccountPanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(AccountPanelLayout.createSequentialGroup()
                                        .addComponent(userTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(76, 76, 76)
                                        .addComponent(transferBtn)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccountPanelLayout.createSequentialGroup()
                        .addGap(0, 59, Short.MAX_VALUE)
                        .addComponent(titleLbl)
                        .addGap(35, 35, 35)
                        .addComponent(exitBtn1)))
                .addContainerGap())
        );
        AccountPanelLayout.setVerticalGroup(
            AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLbl)
                    .addComponent(exitBtn1))
                .addGap(36, 36, 36)
                .addComponent(balanceLbl)
                .addGap(33, 33, 33)
                .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(depositBtn)
                        .addComponent(withdrawBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructionsLbl)
                .addGap(12, 12, 12)
                .addGroup(AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(AccountPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(userTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                    .addComponent(transferBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MortgagePanel.setBackground(new java.awt.Color(36, 47, 65));
        MortgagePanel.setPreferredSize(new java.awt.Dimension(736, 286));

        titleLbl1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        titleLbl1.setForeground(new java.awt.Color(255, 255, 255));
        titleLbl1.setText("AAY Banking Solutions");

        exitBtn2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        exitBtn2.setText("Exit");
        exitBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtn2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("What would you like to calculate?");

        Box1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Box1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Term", "Max Mortgage", "Monthly Payment", "Interest Rate" }));

        t1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });

        t2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        t3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        t4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Select what you would like to calculate and leave the other inputs as 0.");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Term");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Max. Mortgage");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Monthly Payment");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Interest Rate");

        calculateMortgage.setText("Calculate");
        calculateMortgage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateMortgageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MortgagePanelLayout = new javax.swing.GroupLayout(MortgagePanel);
        MortgagePanel.setLayout(MortgagePanelLayout);
        MortgagePanelLayout.setHorizontalGroup(
            MortgagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MortgagePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLbl1)
                .addGap(92, 92, 92)
                .addComponent(exitBtn2)
                .addGap(43, 43, 43))
            .addGroup(MortgagePanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(MortgagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MortgagePanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(85, 85, 85)
                        .addComponent(Box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(225, Short.MAX_VALUE))
                    .addGroup(MortgagePanelLayout.createSequentialGroup()
                        .addGroup(MortgagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MortgagePanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel5))
                            .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(MortgagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MortgagePanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(MortgagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(44, 44, 44)
                        .addGroup(MortgagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(112, 112, 112))))
            .addGroup(MortgagePanelLayout.createSequentialGroup()
                .addGroup(MortgagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MortgagePanelLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MortgagePanelLayout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(calculateMortgage)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MortgagePanelLayout.setVerticalGroup(
            MortgagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MortgagePanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(MortgagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitBtn2)
                    .addComponent(titleLbl1))
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGroup(MortgagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MortgagePanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(MortgagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MortgagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(2, 2, 2))
                    .addGroup(MortgagePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(MortgagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addGroup(MortgagePanelLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addComponent(calculateMortgage)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StockPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BankPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AccountPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MortgagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BankPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StockPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AccountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MortgagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTxtActionPerformed

    }//GEN-LAST:event_usernameTxtActionPerformed

    /**
    * Method Name: signUpBtnActionPerformed
    * Purpose: To sign user up when the button is pressed. If the user is already registered then present an error else create a new user in the database
    * Pre: None
    * Post: None
    * Returns: None
    * By: Anthony
    */
    private void signUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtnActionPerformed
        correctLabel.setText("");
        username = usernameTxt.getText(); // Get Text from user textbox
        password = passwordTxt.getText(); // get Text from password textbox
        test = db.checkDuplicate(username); // Method accesed from sqlDataBase class
        if (test){
            correctLabel.setText("Error: Duplicate User!");
        }
        else{
            db.registerAccount(username, password);
            JOptionPane.showMessageDialog(null, "You have sucessfully Created an Account!\nNow Please Log In!");
        }
    }//GEN-LAST:event_signUpBtnActionPerformed

    /**
    * Method Name: signInBtnActionPerformed
    * Purpose: To sign user in if the user has entered a correct user name and password.
    * Pre: None
    * Post: None
    * Returns: None
    * By: Anthony
    */
    private void signInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInBtnActionPerformed
        // TODO add your handling code here:
        correctLabel.setText("");
        username = usernameTxt.getText(); // get text from textbox
        password = passwordTxt.getText();// get text from textbox
        test = db.checkAccount(username, password); // Use checkAccount method from sqlDatabase to see if username and password are correct
        if (test){
            JOptionPane.showMessageDialog(null, "You have sucessfully logged in!");
            balance = db.returnBalance(username, password); // Use return balance method from sqlDataBase class to return balance of user
            bankPanel();
        }
        else{
            correctLabel.setText("Invalid User or Password!");
        }
    }//GEN-LAST:event_signInBtnActionPerformed
    
    /**
    * Method Name: accountBtnActionPerformed
    * Purpose: Display account panel when button is pressed
    * Pre: None
    * Post: None
    * Returns: None
    * By: Anthony
    */
    private void accountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountBtnActionPerformed
    balanceLbl.setText("Your Balance: $"+df.format(balance));
    AccountPanel();
        
    }//GEN-LAST:event_accountBtnActionPerformed

    /**
    * Method Name: stockBtnActionPerformed
    * Purpose: To display stock panel when the stock button is pressed. When button is pressed it also prepares table for stock information if previous stocks are owned.
    * Pre: None
    * Post: None
    * Returns: None
    * By: Yagnik
    */
    private void stockBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockBtnActionPerformed

        try {
            DefaultTableModel model = (DefaultTableModel) stockTable.getModel();
            Object[] objects1 = getTableValues(1); // Uses getTableValues method to create a row in the table based on the number provided (ie. row 1 = 1)
            Object[] objects2 = getTableValues(2);
            Object[] objects3 = getTableValues(3);
            model.removeRow(0); // Remove pre existing row 
            model.insertRow(0, objects1); // Insert new row
            model.removeRow(1);
            model.insertRow(1, objects2);
            model.removeRow(2);
            model.insertRow(2, objects3);
            symbolTxt.setText("");
            numberTxt.setText("");
            stockSelectBox.setSelectedIndex(0);
            jLabel1.setText("Balance: $"+df.format(balance));
            stockPanel(); // Display stock panel

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_stockBtnActionPerformed
    
    /**
    * Method Name: sellBtnActionPerformed
    * Purpose: To sell a certain number of a certain stock based on the users request  and update this information in the database
    * Pre: None
    * Post: None
    * Returns: None
    * By: Yagnik
    */
    private void sellBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellBtnActionPerformed
        // TODO add your handling code here:
        String selection = (String) stockSelectBox.getSelectedItem();
        String price = null;
        String totalz;
        double prices = 0;

        DefaultTableModel model = (DefaultTableModel) stockTable.getModel();
        symbolTxt.setText("");
        
        Object priceNumber;
        // check if text in number of stock text box is actually a number
        if (numberTxt.getText().matches(("\\d+"))){
            int number = Integer.parseInt(numberTxt.getText());
            // Makes sure that user has selected a stock
            if (selection == "None") {
                JOptionPane.showMessageDialog(null, "Please select a stock from the dropdown menu.");
                // If stock is equal to one then it sells the stock on position 1 in the table and updates the data in the database
            } else if (selection == "Stock 1") {
                String symbol2 = model.getValueAt(0, 2).toString();
                price = model.getValueAt(0, 3).toString();
                priceNumber = model.getValueAt(0, 4);
                int number2 = Integer.parseInt(changeObject(priceNumber));
                price = price.substring(1, price.length());
                prices = new Double(price);
                // if user has enough stock to sell then sell the amount wanted
                if (number < number2) {
                    balance = balance + (number * prices);
                    number = number2 - number;
                    double q = number;
                    double values = prices * q;
                    totalz = "$" + df.format(values) + "";
                    model.setValueAt(number, 0, 4);
                    model.setValueAt(totalz, 0, 5);
                    db.updateStock(2, username, password, symbol2, number);
                 // else if user wants to sell all stock then remove current stock and replace with default values
                } else if (number == number2) {
                    balance = balance + (number * prices);
                    model.removeRow(0);
                    model.insertRow(0, new Object[]{1, "", ".", "$0", "0", ""});
                    db.updateStock(1, username, password, "", 0); // update the database  if all stock is sold
                } else if (number > number2) {
                    JOptionPane.showMessageDialog(null, "Error you do not have enough stocks.");
                }
            }else if (selection == "Stock 2"){
                String symbol2 = model.getValueAt(1, 2).toString();
                price = model.getValueAt(1, 3).toString();
                priceNumber = model.getValueAt(1, 4);
                int number2 = Integer.parseInt(changeObject(priceNumber));
                price = price.substring(1, price.length());
                prices = new Double(price);
                if (number < number2) {
                    balance = balance + (number * prices);
                    number = number2 - number;
                    double q = number;
                    double values = prices * q;
                    totalz = "$" + df.format(values) + "";
                    model.setValueAt(number, 1, 4);
                    model.setValueAt(totalz, 1, 5);
                    db.updateStock(2, username, password, symbol2, number);
                } else if (number == number2) {
                    balance = balance + (number * prices);
                    model.removeRow(1);
                    model.insertRow(1, new Object[]{2, "", ".", "$0", "0", ""});
                    db.updateStock(2, username, password, "", 0);
                } else if (number > number2) {
                    JOptionPane.showMessageDialog(null, "Error you do not have enough stocks.");
                }
            }else if (selection == "Stock 3"){
                String symbol2 = model.getValueAt(2, 2).toString();
                price = model.getValueAt(2, 3).toString();
                priceNumber = model.getValueAt(2, 4);
                int number2 = Integer.parseInt(changeObject(priceNumber));
                price = price.substring(1, price.length());
                prices = new Double(price);
                if (number < number2) {
                    balance = balance + (number * prices);
                    number = number2 - number;
                    double q = number;
                    double values = prices * q;
                    totalz = "$" + df.format(values) + "";
                    model.setValueAt(number, 2, 4);
                    model.setValueAt(totalz, 2, 5);
                    db.updateStock(3, username, password, symbol2, number);
                } else if (number == number2) {
                    balance = balance + (number * prices);
                    model.removeRow(2);
                    model.insertRow(2, new Object[]{3, "", ".", "$0", "0", ""});
                    db.updateStock(3, username, password, "", 0);
                } else if (number > number2) {
                    JOptionPane.showMessageDialog(null, "Error you do not have enough stocks.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Please select a stock from the dropdown menu.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Invalid input for number of stocks.");
        }
        jLabel1.setText("Balance: $"+df.format(balance));
        db.updateBalance(username,balance);
   
    }//GEN-LAST:event_sellBtnActionPerformed
     
    private void stockSelectBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockSelectBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockSelectBoxActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        // Show bank panel and exit current panel
        bankPanel();
    }//GEN-LAST:event_exitBtnActionPerformed

    /**
    * Method Name: buyBtnActionPerformed
    * Purpose: To buy a certain stock based on the information provided by the user and record the data in the database.
    * Pre: None
    * Post: None
    * Returns: None
    * By: Yagnik
    */
    private void buyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyBtnActionPerformed
        // TODO add your handling code here:
        String symbol = symbolTxt.getText();
        symbol = symbol.toUpperCase();
        String selection = (String) stockSelectBox.getSelectedItem();
        String quote = null;
        String name = null;
        String price = null;
        String totalz;
        double prices = 0;
        int check = db.checkEmpty(username, password); // check which stocks are rmpty 
        DefaultTableModel model = (DefaultTableModel) stockTable.getModel();
     
        // Check if string text in number text box is a number
        if (numberTxt.getText().matches(("\\d+"))) {
            int number = Integer.parseInt(numberTxt.getText());
            // Check if user is buying a new stock
            if (selection.equals("None")) {
                if (symbol.equals("")){
                   JOptionPane.showMessageDialog(null, "Error you have left the stock symbol blank");
                }
                else{
                    if (!(symbol.equals(model.getValueAt(0, 2)) || symbol.equals(model.getValueAt(1, 2)) || symbol.equals(model.getValueAt(2, 2)))) {
                    try {
                        quote = sp.getQuote(symbol); // get the stock name and price from the getQuote method in the stockPortfolio class
                        if (!quote.equals("Error")) {
                            if (check == 0) {
                                JOptionPane.showMessageDialog(null, "Error you have bought the max. number of stocks!");
                                // Check if stock position 1 is empty and if it is then buy the stock and input the data in the database
                            } else if (check == 1) {
                                name = quote.substring(0, quote.indexOf("|"));
                                price = quote.substring(quote.indexOf("|") + 2, quote.length());
                                prices = Double.parseDouble(price);
                                if (balance >= (prices * number)) {
                                    double q = number;
                                    double values = prices * q;
                                    totalz = "$"+df.format(values)+"";
                                    model.removeRow(0);
                                    model.insertRow(0, new Object[]{1, name, symbol, "$"+price, number, totalz});
                                    db.updateStock(1, username, password, symbol, number); // input the stock price, and symbol into the database.
                                    balance = balance - values;
                                }else{
                                    JOptionPane.showMessageDialog(null, "Not enough balance!");
                                }
                            } else if (check == 2) {
                                name = quote.substring(0, quote.indexOf("|"));
                                price = quote.substring(quote.indexOf("|") + 2, quote.length());
                                prices = Double.parseDouble(price);
                                if (balance >= (prices * number)) {
                                    double q = number;
                                    double values = prices * q;
                                    totalz = "$"+df.format(values)+"";
                                    model.removeRow(1);
                                    model.insertRow(1, new Object[]{2, name, symbol,"$"+price, number, totalz});
                                    db.updateStock(2, username, password, symbol, number);
                                    balance = balance - values;
                                }else{
                                    JOptionPane.showMessageDialog(null, "Not enough balance!");
                                }
                            } else if (check == 3) {
                                name = quote.substring(0, quote.indexOf("|"));
                                price = quote.substring(quote.indexOf("|") + 2, quote.length());
                                prices = Double.parseDouble(price);
                                if (balance >= (prices * number)) {
                                    double q = number;
                                    double values = prices * q;
                                    totalz = "$"+df.format(values)+"";
                                    model.removeRow(2);
                                    model.insertRow(2, new Object[]{3, name, symbol, "$"+price, number, totalz});
                                    db.updateStock(3, username, password, symbol, number);
                                    balance = balance - values;
                                }else{
                                    JOptionPane.showMessageDialog(null, "Not enough balance!");
                                }
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Stock cannot be found!");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else if (symbol.equals(model.getValueAt(0, 2)) || symbol.equals(model.getValueAt(1, 2)) || symbol.equals(model.getValueAt(2, 2))) {
                    JOptionPane.showMessageDialog(null, "This stock has already been bought. Please clear the symbol box and select the stock from the menu");
                    symbolTxt.setText("");
                }
                }
            // Check if user wants to buy more of an existing stock and if the selectino is stock 1 then buy more of that stock and update the data table
            } else if (selection.equals("Stock 1")) {
                String symbol2 = model.getValueAt(0,2).toString();
                if (symbol.equals("") &&  !symbol2.equals(".")){
                    try {
                        quote = sp.getQuote(symbol2);
                    } catch (IOException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    price = quote.substring(quote.indexOf("|") + 2, quote.length());
                    prices = Double.parseDouble(price);
                    if (balance >= (prices * number)) {
                        number += (int) (model.getValueAt(0, 4));
                        double q = number;
                        double values = prices * q;
                        totalz = "$"+df.format(values)+"";
                        model.setValueAt(number, 0, 4);
                        model.setValueAt(totalz, 0, 5);
                        db.updateStock(1, username, password, symbol, number);
                        balance = balance - values;
                        }
                }else if (!symbol.equals("")){
                    JOptionPane.showMessageDialog(null, "Error symbol textbox needs to be empty!");
                    symbolTxt.setText("");
                }else if(symbol2.equals(".")){
                    JOptionPane.showMessageDialog(null, "Error you do not own that stock! \n Please select None from the drop down menu and enter your symbol to buy the stock.");
                    stockSelectBox.setSelectedIndex(0);
                    }
            }else if (selection.equals("Stock 2")) {
                String symbol2 = model.getValueAt(1,2).toString();
                if (symbol.equals("") &&  !symbol2.equals(".")){
                    try {
                        quote = sp.getQuote(symbol2);
                    } catch (IOException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    price = quote.substring(quote.indexOf("|") + 2, quote.length());
                    prices = Double.parseDouble(price);
                    if (balance >= (prices * number)) {
                        number += (int) (model.getValueAt(1, 4));
                        double q = number;
                        double values = prices * q;
                        totalz = "$"+df.format(values)+"";
                        model.setValueAt(number, 1, 4);
                        model.setValueAt(totalz, 1, 5);
                        db.updateStock(2, username, password, symbol, number);
                        balance = balance - values;
                        }
                    }else if (!symbol.equals("")){
                        JOptionPane.showMessageDialog(null, "Error symbol textbox needs to be empty!");
                        symbolTxt.setText("");
                    }else if(symbol2.equals(".")){
                        JOptionPane.showMessageDialog(null, "Error you do not own that stock! \n Please select None from the drop down menu and enter your symbol to buy the stock.");
                        stockSelectBox.setSelectedIndex(0);
                    }
            }else if (selection.equals("Stock 3")) {
                String symbol2 = model.getValueAt(2,2).toString();
                if (symbol.equals("") &&  !symbol2.equals(".")){
                    try {
                        quote = sp.getQuote(symbol2);
                    } catch (IOException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    price = quote.substring(quote.indexOf("|") + 2, quote.length());
                    prices = Double.parseDouble(price);
                    if (balance >= (prices * number)) {
                        number += (int) (model.getValueAt(2, 4));
                        double q = number;
                        double values = prices * q;
                        totalz = "$"+df.format(values)+"";
                        model.setValueAt(number, 2, 4);
                        model.setValueAt(totalz, 2, 5);
                        db.updateStock(3, username, password, symbol, number); 
                        balance = balance - values;
                        }
                    }else if (!symbol.equals("")){
                        JOptionPane.showMessageDialog(null, "Error symbol textbox needs to be empty!");
                        symbolTxt.setText("");
                    }else if(symbol2.equals(".")){
                        JOptionPane.showMessageDialog(null, "Error you do not own that stock! \n Please select None from the drop down menu and enter your symbol to buy the stock.");
                        stockSelectBox.setSelectedIndex(0);
                    }
            }
        }else{
            JOptionPane.showMessageDialog(null, "You have entered an invalid amount!");
        }
        jLabel1.setText("Balance: $"+df.format(balance));
        db.updateBalance(username,balance);
    }//GEN-LAST:event_buyBtnActionPerformed

    private void symbolTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_symbolTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_symbolTxtActionPerformed

    /**
    * Method Name: updateBtnActionPerformed
    * Purpose: Update the database and data table with the latest stock prices
    * Pre: None
    * Post: None
    * Returns: None
    * By: Yagnik
    */
    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        
        try {
            DefaultTableModel model = (DefaultTableModel) stockTable.getModel();
            Object[] objects1 = getTableValues(1);
            Object[] objects2 = getTableValues(2);
            Object[] objects3 = getTableValues(3);
            model.insertRow(0, objects1);
            model.insertRow(1, objects2);
            model.insertRow(2, objects3);
            symbolTxt.setText("");
            numberTxt.setText("");
            stockSelectBox.setSelectedIndex(0);

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    /**
    * Method Name: depositBtnActionPerformed
    * Purpose: Deposit money into a users account and update their balance in the database.
    * Pre: None
    * Post: None
    * Returns: None
    * By: Anthony
    */
    private void depositBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositBtnActionPerformed
        String change = changeTxt.getText();
        try{
            double s = Double.parseDouble(change);
            balance += s;
            db.updateBalance(username,balance);
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Invalid input.");
        }
        balanceLbl.setText("Your Balance: $"+df.format(balance));
        changeTxt.setText("");
        userTxt1.setText("");
    }//GEN-LAST:event_depositBtnActionPerformed

    /**
    * Method Name: depositBtnActionPerformed
    * Purpose: Withdraw money into a users account and update their balance in the database.
    * Pre: None
    * Post: None
    * Returns: None
    * By: Anthony
    */
    private void withdrawBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawBtnActionPerformed
        // TODO add your handling code here:
        String change = changeTxt.getText();
        try {
            double s = Double.parseDouble(change);
            if (balance >= s){
                balance -= s;
                db.updateBalance(username,balance);
            }else{
                JOptionPane.showMessageDialog(null, "Insufficient Funds!");
            }
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Invalid input.");
        }
        balanceLbl.setText("Your Balance: $"+df.format(balance));
        changeTxt.setText("");
        userTxt1.setText("");
    }//GEN-LAST:event_withdrawBtnActionPerformed
   
    /**
    * Method Name: transferBtnActionPerformed
    * Purpose: Transfer money from one user to another user and update their balances in the database.
    * Pre: None
    * Post: None
    * Returns: None
    * By: Anthony
    */
    private void transferBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferBtnActionPerformed
        // TODO add your handling code here:
        String change = changeTxt.getText();
        boolean userExis =  false;
        String transferUser = userTxt1.getText();
        userExis = db.checkUsername(transferUser);
        try{
            if ((userExis) && (!transferUser.isEmpty()) && (!change.isEmpty())) {
                double changes = Double.parseDouble(change);
                if (balance >= changes) {
                    balance -= changes;
                    db.updateBalance(username, balance);
                    db.updateBalance(transferUser, db.returnBalance(transferUser) + changes);
                    changeTxt.setText("");
                    userTxt1.setText("");
                    JOptionPane.showMessageDialog(null, "Sucessfully transfered $" + df.format(changes) + " to " + transferUser + "!");
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient Funds!");
                }
            } else if (!userExis) {
                JOptionPane.showMessageDialog(null, "User does not exist.");
                userTxt1.setText("");
            } else if (transferUser.isEmpty() || change.isEmpty()) {
                JOptionPane.showMessageDialog(null, "User field or number amount is empty");
            }
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Invalid input.");
        }
        balanceLbl.setText("Your Balance: $"+df.format(balance));

    }//GEN-LAST:event_transferBtnActionPerformed

    private void exitBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtn1ActionPerformed
    bankPanel();
    }//GEN-LAST:event_exitBtn1ActionPerformed

    private void exit2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit2BtnActionPerformed
        // TODO add your handling code here:
        username = null;
        password = null;
        loginPanel();
    }//GEN-LAST:event_exit2BtnActionPerformed

    private void exitBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtn2ActionPerformed
        // TODO add your handling code here:
        bankPanel();
    }//GEN-LAST:event_exitBtn2ActionPerformed

    private void calculateMortgageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateMortgageActionPerformed
        //Term, Max Mortgage, Monthly Payment, Interest Rate calulations
        String selection = (String) Box1.getSelectedItem();
        String s1 = t1.getText();
        String s2 = t2.getText();
        String s3 = t3.getText();
        String s4 = t4.getText();
        if (s1.matches(("\\d+")) && s2.matches(("\\d+")) && s3.matches(("\\d+")) && s4.matches(("\\d+"))) {
            int n1 = Integer.parseInt(s1);
            double n2 = Double.parseDouble(s2);
            double n3 = Double.parseDouble(s3);
            double n4 = Double.parseDouble(s4);
            if (selection.equals("Term")){
                JOptionPane.showMessageDialog(null, "The number of terms is " + df.format(mc.calculateTerm(n3, n2, n4)));
            }else if (selection.equals("Max Mortgage")){
                JOptionPane.showMessageDialog(null, "The max mortgage is " + df.format(mc.calculateMaxMortgage(n1, n2, n3)));
            }else if (selection.equals("Monthly Payment")){
                JOptionPane.showMessageDialog(null, "The Monthly Payment is " + df.format(mc.calculateMonthlyPayment(n1, n2, n4)));
            }else if (selection.equals("Interest Rate")){
                JOptionPane.showMessageDialog(null, "The Interest Rate is " + df.format(mc.calculateInterestRate(n1, n4, n3)));
            }
        }else{
               JOptionPane.showMessageDialog(null, "Invalid Input"); 
            }
        t1.setText("0");
        t2.setText("0");
        t3.setText("0");
        t4.setText("0");
    }//GEN-LAST:event_calculateMortgageActionPerformed

    private void mortgageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mortgageBtnActionPerformed
        mortgagePanel();
    }//GEN-LAST:event_mortgageBtnActionPerformed

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AccountPanel;
    private javax.swing.JPanel BankPanel;
    private javax.swing.JComboBox<String> Box1;
    private javax.swing.JPanel MortgagePanel;
    private javax.swing.JPanel StockPanel;
    private javax.swing.JButton accountBtn;
    private javax.swing.JLabel accountImg;
    private javax.swing.JLabel accountLbl1;
    private javax.swing.JLabel accountLbl2;
    private javax.swing.JLabel balanceLbl;
    private javax.swing.JLabel bankNameLabel;
    private javax.swing.JLabel bankNameLabel2;
    private javax.swing.JLabel bankNameLabel3;
    private javax.swing.JButton buyBtn;
    private javax.swing.JButton calculateMortgage;
    private javax.swing.JTextField changeTxt;
    private javax.swing.JLabel correctLabel;
    private javax.swing.JButton depositBtn;
    private javax.swing.JLabel errorLbl;
    private javax.swing.JLabel exisStockLbl;
    private javax.swing.JButton exit2Btn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton exitBtn1;
    private javax.swing.JButton exitBtn2;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel infoLbl;
    private javax.swing.JLabel instructionsLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JButton mortgageBtn;
    private javax.swing.JLabel mortgageImg;
    private javax.swing.JLabel mortgageLbl1;
    private javax.swing.JLabel mortgageLbl2;
    private javax.swing.JLabel newStockLbl;
    private javax.swing.JLabel numberLbl;
    private javax.swing.JTextField numberTxt;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JButton sellBtn;
    private javax.swing.JButton signInBtn;
    private javax.swing.JButton signUpBtn;
    private javax.swing.JPanel signUpPanel;
    private javax.swing.JLabel signupLabel;
    private javax.swing.JLabel sloganLabel;
    private javax.swing.JButton stockBtn;
    private javax.swing.JLabel stockImg;
    private javax.swing.JLabel stockLbl1;
    private javax.swing.JLabel stockLbl2;
    private javax.swing.JComboBox<String> stockSelectBox;
    private javax.swing.JTable stockTable;
    private javax.swing.JLabel subTitleLbl;
    private javax.swing.JTextField symbolTxt;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JLabel titleLbl1;
    private javax.swing.JButton transferBtn;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField userTxt1;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTxt;
    private javax.swing.JButton withdrawBtn;
    // End of variables declaration//GEN-END:variables
}
