package Complaint_management;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame{
	
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;   
    
    private JButton CreateAcct;     
         
    private JButton Logins;      
   
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
    	
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        setBounds(300, 100, 650, 500);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(SystemColor.BLACK);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle(" Main ");
        
        JLabel lblNewUserRegister = new JLabel(" Samadhan Complaint Managment System "); 
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewUserRegister.setBounds(120, 12, 500, 70);
        lblNewUserRegister.setForeground(Color.blue);
        contentPane.add(lblNewUserRegister);
        
        
        JLabel lbnNewUserRegister = new JLabel(" WELCOME ");
        lbnNewUserRegister.setFont(new Font("Times New Roman", Font.ITALIC, 22));
        lbnNewUserRegister.setBounds(250, 122, 410, 30);
        lbnNewUserRegister.setForeground(Color.orange);
        contentPane.add(lbnNewUserRegister);
        
        Logins= new JButton("Login");
        Logins.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                        	login_Ar frame = new login_Ar();
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
        
        CreateAcct= new JButton("Register");
        CreateAcct.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
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
        });
        CreateAcct.setFont(new Font("Tahoma", Font.PLAIN, 18));
        CreateAcct.setBounds(222, 350, 170, 40);
        CreateAcct.setBackground(Color.orange);
        contentPane.add(CreateAcct);
        
       
    }

	

}
class login_Ar extends JFrame{
	
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;   
    
    private JButton Admin;     
         
    private JButton Coustumer;      
   
    /*public static void main(String[] args){       
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
        
    }*/
    
    public login_Ar() {
        
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
        
        /*JLabel lblNewUserRegister = new JLabel(" Samadhan Complaint Managment System "); 
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewUserRegister.setBounds(120, 12, 500, 70);
        lblNewUserRegister.setForeground(Color.blue);
        contentPane.add(lblNewUserRegister);*/
        
        
        JLabel lbnNewUserRegister = new JLabel(" AS ");
        lbnNewUserRegister.setFont(new Font("Times New Roman", Font.ITALIC, 32));
        lbnNewUserRegister.setBounds(250, 122, 410, 30);
        lbnNewUserRegister.setForeground(Color.orange);
        contentPane.add(lbnNewUserRegister);
        
        Admin= new JButton("Admin");
        Admin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            LoginA frame = new LoginA();
                            frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    
                });
            }
        });
        Admin.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Admin.setBounds(222, 250, 170, 40);
        Admin.setBackground(Color.orange);
        contentPane.add(Admin);
        
        Coustumer= new JButton("Coustemer");
        Coustumer.addActionListener(new ActionListener(){
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
        Coustumer.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Coustumer.setBounds(222, 350, 170, 40);
        Coustumer.setBackground(Color.orange);
        contentPane.add(Coustumer);
        
       
    }

	

}

