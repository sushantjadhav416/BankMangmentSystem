import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javafx.scene.paint.Color;


class Loginw extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    private JTextField ID;
    private JPasswordField pwd;
    private JButton login;
    private JButton fpass;
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Loginw frame = new Loginw();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();    }
            }});  }
   
   public Loginw() {
        

       //setLayout(new BorderLayout());
      
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 100, 650, 450);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("              !!!!!!!!!!!!! WELCOME TO HCL BANKINS  !!!!!!!!!!!!!");
        contentPane.setBackground(SystemColor.BLACK);
        
        JLabel lblNewUserRegister = new JLabel("     HCL BANK  ");
        lblNewUserRegister.setForeground(java.awt.Color.white);
      
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewUserRegister.setBounds(220, 12, 200, 70);
        contentPane.add(lblNewUserRegister);
        
        JLabel lbnNewUserRegister = new JLabel("Please login : ");
        lbnNewUserRegister.setForeground(java.awt.Color.white);
        lbnNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lbnNewUserRegister.setBounds(250, 52, 200, 70);
        contentPane.add(lbnNewUserRegister);
        
        JLabel lblName = new JLabel("Enter Account ID: ");
        lblName.setForeground(java.awt.Color.white);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblName.setBounds(58, 138, 99, 43);
        contentPane.add(lblName);
        
        JLabel lblNamee = new JLabel("Password: ");
        lblNamee.setForeground(java.awt.Color.white);
        lblNamee.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNamee.setBounds(58, 238, 99, 43);
        contentPane.add(lblNamee);
        
        ID = new JTextField();
        ID.setFont(new Font("Tahoma", Font.PLAIN, 25));
        ID.setBounds(214, 145, 228, 40);
        contentPane.add(ID);
        ID.setColumns(10);



        pwd = new JPasswordField();
        
        pwd.setFont(new Font("Tahoma", Font.PLAIN, 25));
        pwd.setBounds(214, 235, 228, 40);
        pwd.setEchoChar('*');
        contentPane.add(pwd);
        pwd.setColumns(10);
        
        final JCheckBox showp = new JCheckBox("show password");
        showp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	if(showp.isSelected()) {
            		 pwd.setEchoChar((char)0);
            	}
            	else {
            		 pwd.setEchoChar('*');
            	}
            	
            	
            }
            });
        showp .setFont(new Font("Tahoma", Font.PLAIN, 17));
        showp .setBounds(150, 295, 150, 20);
        contentPane.add(showp );
            	
        
        
        login= new JButton("Login");
        login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String Id = ID.getText();
                String password = pwd.getText();
                
                ConnectionDb connection = new ConnectionDb();
                Connection con = null;
                PreparedStatement p = null;
                ResultSet rs = null;
                con = ConnectionDb.createDBconnection();
                String DID = null;
                String pwd=null;
                try {
                    String sql = "select * from tbldeposit where ID="+Id;
                    p = con.prepareStatement(sql);
                    rs = p.executeQuery();
                    if (rs.next()){
                         DID = rs.getString("ID");
                         pwd = rs.getString("password");   }
                }
                catch (SQLException er) {
                    System.out.println(er);
                }
                
                if(Id.isEmpty() || password.isEmpty())
                {
                	JOptionPane.showMessageDialog(login," Please enter all laogin details");
                }
                else if(Id.equals(DID) && pwd.equals(password)){
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            try {
                                Main2 frame = new Main2();
                                frame.setVisible(true);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                           }
                        });    
                }
                else{
                    JOptionPane.showMessageDialog(login,"Login details is invalid");
                }  
            }
        });
        
        login.setFont(new Font("Tahoma", Font.PLAIN, 22));
        login.setBounds(222, 325, 150, 30);
        contentPane.add(login);
        
        fpass= new JButton("Forgot password");
        fpass.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            Forgot_pass frame = new Forgot_pass();
                             frame.setVisible(true);
                        } catch (Exception e) {
                            
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        fpass.setFont(new Font("Tahoma", Font.PLAIN, 17));
        fpass.setBounds(422, 325, 170, 30);
        contentPane.add(fpass);
    }





}
