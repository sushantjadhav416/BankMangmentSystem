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



public class Main2 extends JFrame{
    
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
                    Main2 frame = new Main2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public Main2() {
        
       //setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jadhavsushant.vikas\\OneDrive - HCL Technologies Ltd\\Desktop\\OIP"));
    	JLabel background = new JLabel(new ImageIcon("C:\\Users\\jadhavsushant.vikas\\OneDrive - HCL Technologies Ltd\\Desktop\\OIP")) ;
    	add(background);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 100, 700, 500);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(SystemColor.gray);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("              !!!!!!!!!!!!! WELCOME TO HCL BANKIGNS  !!!!!!!!!!!!!");
        
        JLabel lblNewUserRegister = new JLabel("HCL BANK  "); 
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 35));
        lblNewUserRegister.setBounds(222, 12, 230, 70);
        lblNewUserRegister.setForeground(Color.blue);
        contentPane.add(lblNewUserRegister);
        
        
        /*JLabel lbnNewUserRegister = new JLabel("Please Select option ");
        lbnNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lbnNewUserRegister.setBounds(222, 52, 200, 70);
        contentPane.add(lbnNewUserRegister);*/
        
      
        
        
        
        credite= new JButton("credite Amount:");
        credite.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                             Credite_amt frame = new Credite_amt();
                             frame.setVisible(true);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
            }
            
        });
        
        credite.setFont(new Font("Tahoma", Font.PLAIN, 18));
        credite.setBounds(222, 100, 170, 40);
        credite.setBackground(Color.orange);
        contentPane.add(credite);
        
        Withdraw= new JButton("Withdraw Amount:");
        Withdraw.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                             Withdraw frame = new Withdraw();
                             frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        Withdraw.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Withdraw.setBounds(400, 195, 200, 40);
        Withdraw.setBackground(Color.orange);
        contentPane.add(Withdraw);
        
        Deatil= new JButton("Account details");
        Deatil.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                        	Details_u frame = new Details_u();
                             frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        Deatil.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Deatil.setBounds(222, 300, 170, 40);
        Deatil.setBackground(Color.cyan);
        contentPane.add(Deatil);
        
        
        Transfer= new JButton("Money transfer");
        Transfer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                        	Transfer frame = new Transfer();
                             frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        Transfer.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Transfer.setBounds(42, 195, 180, 40);
        Transfer.setBackground(Color.orange);
        contentPane.add(Transfer); 
        
        JButton Logout = new JButton("Log Out");
        Logout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
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
        });
        
        Logout.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Logout.setBounds(550, 12 ,100, 30);
        contentPane.add(Logout);
    }
    
}

