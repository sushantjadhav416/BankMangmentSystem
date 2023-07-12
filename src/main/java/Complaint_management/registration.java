package Complaint_management;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class registration extends JFrame{
	
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField Fname;
    private JTextField Address;
    private JTextField AdhaarNumber;
    private JTextField ContactNum;
    private JTextField AcType;
    private JTextField Balance;
    private JButton btnNewButton;
    private JButton AbtnNewButton ;
    private JPasswordField Password;
    
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	registration frame = new registration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public registration() {
    
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 950, 497);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(SystemColor.GRAY);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("                             !!!!!!!!!!!!! WELCOME samadhan complaint Management System  !!!!!!!!!!!!!");
        
        JLabel lblNeUserRegister = new JLabel("  New  Customer   "); 
        lblNeUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNeUserRegister.setBounds(390, 6, 390, 70);
        lblNeUserRegister.setForeground(Color.BLUE);
        contentPane.add(lblNeUserRegister);
        
        JLabel lblNewUserRegister = new JLabel("New Registration");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 32));
        lblNewUserRegister.setBounds(362, 72, 325, 32);
        lblNewUserRegister.setForeground(Color.WHITE);
        contentPane.add(lblNewUserRegister);
        
        JLabel lbmNewUserRegister = new JLabel("Note:please Enter some amount for account creation");
        lbmNewUserRegister.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        lbmNewUserRegister.setBounds(399, 427, 350, 74);
        lbmNewUserRegister.setForeground(Color.RED);
        contentPane.add(lbmNewUserRegister);

        
        JLabel lblName = new JLabel("First name:");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblName.setBounds(108, 140, 149, 43);
        contentPane.add(lblName);

       
        /*JLabel lblEmailAddress = new JLabel("Adhaar number:");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblEmailAddress.setBounds(58,285, 124, 36);
        contentPane.add(lblEmailAddress);*/
        
        JLabel lblpmailAddress = new JLabel("Enter password:");
        lblpmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpmailAddress.setBounds(108,285, 149, 36);
        contentPane.add(lblpmailAddress);

        Fname = new JTextField();
        Fname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Fname.setBounds(264, 141, 278, 30);
        contentPane.add(Fname);
        Fname.setColumns(10);
        
        

        /*AdhaarNumber = new JTextField();
        AdhaarNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
        AdhaarNumber.setBounds(214, 290, 228, 30);
        contentPane.add(AdhaarNumber);
        AdhaarNumber.setColumns(10);*/
        
        Password = new JPasswordField();
        Password.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Password.setBounds(264, 285, 278, 30);
        Password.setEchoChar('*');
        contentPane.add(Password);
        Password.setColumns(10);
        

       
   
        JLabel lblMobileNumber = new JLabel("   Mobile number:");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblMobileNumber.setBounds(108, 220, 160, 29);
        contentPane.add(lblMobileNumber);

        ContactNum = new JTextField();
        ContactNum.setFont(new Font("Tahoma", Font.PLAIN, 20));
        ContactNum.setBounds(264, 200, 278, 30);
        contentPane.add(ContactNum);
        ContactNum.setColumns(10);

        
        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            
                long Id = 0;
                Random RId = new Random();
                Id = RId.nextLong(100000,500000);
                
                
                String YourName = Fname.getText();
               
               
               
                String contactnum  = ContactNum.getText();
                int len = contactnum.length();
               
                
                String password = Password.getText();
                int plen = password.length();
               
             
               //validations part 
                
                if(YourName.isEmpty()){
                	JOptionPane.showMessageDialog(btnNewButton, "Please Enter all requred field");
                }
               
                else if(plen<6) {
                	JOptionPane.showMessageDialog(btnNewButton, "Enter the Password more then 6 digits");
                	
                }
                else if (len < 10 || len >  10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }
                
                else {
                	
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "Sushant@416");

                    String query = "INSERT INTO customer values("+Id+",'"+YourName+"','" +contactnum+"','"+password+"')";
                   
                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,"Welcome, " + YourName + "Your  "+" account is sucessfully created\n"+"Your CUSTOMER Id: "+Id);
                        setVisible(false);
                    }
                    
                    EventQueue.invokeLater(new Runnable(){
                        public void run() {
                            try {
                                Main frame = new Main();
                                frame.setVisible(true);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    
                    connection.close();
                    
                }catch (Exception exception){
                    exception.printStackTrace();
                }
              }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(329, 357, 189, 34);
        contentPane.add(btnNewButton);
        
      
    }

	

}
