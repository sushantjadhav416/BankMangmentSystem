import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main extends JFrame{
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;   
    
    private JButton CreateAcct;     
    private JButton Withdraw;
    private JButton Deatil;       
    private JButton Logins;      
    private JButton Transfer;
    private JButton credite;
    
    public static void main(String[] args){       
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try { 
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }); 
        
    }
    
    public Main() {
        
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jadhavsushant.vikas\\Downloads\\hcl.png"));
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        setBounds(300, 100, 650, 500);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(SystemColor.BLACK);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle(" Main ");
        
        JLabel lblNewUserRegister = new JLabel("HCL BANK   "); 
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 35));
        lblNewUserRegister.setBounds(222, 12, 230, 70);
        lblNewUserRegister.setForeground(Color.blue);
        contentPane.add(lblNewUserRegister);
        
        
        JLabel lbnNewUserRegister = new JLabel(" WELCOME TO HCL BANK  ");
        lbnNewUserRegister.setFont(new Font("Times New Roman", Font.ITALIC, 22));
        lbnNewUserRegister.setBounds(200, 102, 360, 30);
        lbnNewUserRegister.setForeground(Color.orange);
        contentPane.add(lbnNewUserRegister);
        
        Logins= new JButton("Login");
        Logins.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            Loginw frame = new Loginw();
                            frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    
                });
            }
        });
        Logins.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Logins.setBounds(222, 250, 170, 40);
        Logins.setBackground(Color.orange);
        contentPane.add(Logins);
        
        CreateAcct= new JButton("Create account");
        CreateAcct.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try { 
                            Accounts frame = new Accounts();
                            frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }); 
            }
        });
        CreateAcct.setFont(new Font("Tahoma", Font.PLAIN, 18));
        CreateAcct.setBounds(222, 350, 170, 40);
        CreateAcct.setBackground(Color.orange);
        contentPane.add(CreateAcct);
        
       
    }
    
}


