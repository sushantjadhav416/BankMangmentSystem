/*
import java.sql.*;
import java.util.Scanner;

public class Withdraw {
     public void  withdraw(int ID)
        {
            Scanner s=new Scanner(System.in);
            System.out.println("Enter the withdraw amount :- ");
            int Balance = s.nextInt();
            
            
            try {
                Statement stmt = (ConnectionDb.createDBconnection().createStatement());
                int no = stmt.executeUpdate("update tbldeposit set Balance = Balance - "+Balance+" where ID = "+ID+"");
                if(no==1)
                {
                    System.out.println("executed...");
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
     
     public static void main(String[] args)
      {
            Withdraw d = new Withdraw();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter customer id");
            int cid=sc.nextInt();
            d.withdraw(cid);
        }

}
*/

import java.awt.Color;
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
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Withdraw  extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField ID;
    private JTextField Balance;
    private JTextField Fname;
    
   
    private JButton withdrawa;
    private JButton Home;
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Withdraw  frame = new Withdraw ();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public Withdraw() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Java Codes\\CapstoneBackground.webp"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 90, 950, 550);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(SystemColor.black);
        setTitle("***HCLBanking Deposit Amount***");
        
        
        JLabel llblNewUserRegister = new JLabel("HCL BANK   "); 
        llblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 35));
        llblNewUserRegister.setBounds(350, 12, 630, 70);
        llblNewUserRegister.setForeground(Color.blue);
        contentPane.add(llblNewUserRegister);
        
        JLabel lblNewUserRegister = new JLabel("Withdraw Your Amount");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblNewUserRegister.setBounds(420, 92, 325, 30);
        lblNewUserRegister.setForeground(Color.yellow);
        contentPane.add(lblNewUserRegister);
        
        
        JLabel lblName = new JLabel("Enter Account ID:");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblName.setBounds(330, 162, 140, 43);
        lblName.setForeground(Color.white);
        contentPane.add(lblName);
        
        JLabel lblFName = new JLabel("Name:");
        lblFName.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblFName.setBounds(330, 235, 140, 43);
        lblFName.setForeground(Color.white);
        contentPane.add(lblFName);
        
        JLabel lblvalidate = new JLabel("Amount:");
        lblvalidate.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblvalidate.setBounds(330, 304, 140, 43);
        lblvalidate.setForeground(Color.white);
        contentPane.add(lblvalidate);
       



        ID = new JTextField();
        ID.setFont(new Font("Tahoma", Font.PLAIN, 18));
        ID.setBounds(490, 162, 270, 40);
        contentPane.add(ID);
        ID.setColumns(10);
        
        Fname = new JTextField();
        Fname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Fname.setBounds(490, 235, 270, 40);
        contentPane.add(Fname);
        Fname.setColumns(10);


        Balance = new JTextField();
        Balance.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Balance.setBounds(490, 304, 270, 40);
        contentPane.add(Balance);
        Balance.setColumns(10);
        
        
        withdrawa = new JButton("Submit");
        withdrawa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String iD = ID.getText();
                String balance = Balance.getText();
                String Firstname = Fname.getText();
                int b = Integer.parseInt(balance);
                
;                
                LocalDateTime MyDate = LocalDateTime.now();
                DateTimeFormatter myformater = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String Format = MyDate.format(myformater);
                
                ConnectionDb connection = new ConnectionDb();
                Connection con = null;
                PreparedStatement p = null;
                ResultSet rs = null;
                con = ConnectionDb.createDBconnection();
                String DID = null;
                String FirstN = null;
                String Putbalance = null;
                String msg = "" + iD;
                msg += " \n";
                int y_balance = 0;
                try {
                    
                    if(iD.isEmpty())
                    {
                        JOptionPane.showMessageDialog(withdrawa, "ID is required.");
                    }
                    else if(Firstname.isEmpty())
                    {
                        JOptionPane.showMessageDialog(withdrawa, "Name is required.");
                    }
                    else if(balance.isEmpty())
                    {
                        JOptionPane.showMessageDialog(withdrawa, "Balance is required.");
                    }
                    else
                    {
                    Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "Sushant@416");
                    String query = "update tbldeposit set Balance = Balance - "+balance+" where ID = "+iD+" and Fname ='"+Firstname+"'";
                    Statement sta = connection1.createStatement();
                    int x = sta.executeUpdate(query);
                    
                    String sql = "select * from tbldeposit where ID="+iD;
                    p = con.prepareStatement(sql);
                    rs = p.executeQuery();
                    
                    if (rs.next()){
                       
                         DID = rs.getString("ID");
                         FirstN = rs.getString("Fname");
                         y_balance = rs.getInt("Balance");
                         
                     if (x == 0)
                     {
                        JOptionPane.showMessageDialog(withdrawa, "Account does not exist.");
                    }
                     else if(b>y_balance)
                     {
                    	 JOptionPane.showMessageDialog(withdrawa, "You dont have enough balance in your Account.");
                     }
                    if(x==1)
                     {
                         JOptionPane.showMessageDialog(withdrawa, "Your Amount has been debited\n" + "Customer ID: "+msg + balance +" Rs. has been credited in your account \n On Date: " + Format);
                     }
                    
                    connection1.close();
                }}
                }catch (Exception exception)
                {
                    JOptionPane.showMessageDialog(withdrawa, "Please Check Again..");
                }
                }
        });
        
        withdrawa.setFont(new Font("Tahoma", Font.PLAIN, 22));
        withdrawa.setBounds(370, 420, 159, 40);
        contentPane.add(withdrawa);
         
        Home = new JButton("back");
        Home.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
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
        });
        Home.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Home.setBounds(750, 12, 120, 30);
        contentPane.add(Home);
    }
     
}
