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
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Credite_amt  extends JFrame implements Savings , current{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField ID;
    private JTextField Balance;
    private JTextField Fname;
    
   
    private JButton depositbt;
    private JButton Home;
    
    @Override
    public  double getS_interest(int b){
		    double interestRate =0.5;
		    double netInterest = (interestRate/12);
		    double  mInterest =netInterest*b;
		    b = (int) (b  + mInterest);
		    return b;
	    }
	
    @Override
	public  double getC_interest(int b){
		 double interestRate =0.3;
		    double netInterest = (interestRate/12);
		    int  mInterest = (int) (netInterest*b);
		    b=b+mInterest;
		    return b;
		 
	   }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Credite_amt frame = new Credite_amt();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public Credite_amt() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Java Codes\\CapstoneBackground.webp"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 90, 1000, 450);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(SystemColor.black);
        setTitle("***HCLBanking Deposit Amount***");
        
        JLabel lblNeUserRegister = new JLabel("     HCL BANK  "); 
        lblNeUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNeUserRegister.setBounds(390, 6, 390, 70);
        lblNeUserRegister.setForeground(Color.BLUE);
        contentPane.add(lblNeUserRegister);
        
        JLabel lblNewUserRegister = new JLabel("Credit  Your Amount Window");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewUserRegister.setBounds(420, 56, 375, 50);
        lblNewUserRegister.setForeground(Color.yellow);
        contentPane.add(lblNewUserRegister);
        
        
        JLabel lblName = new JLabel("Enter Account ID:");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblName.setBounds(330, 112, 160, 43);
        lblName.setForeground(Color.white);
        contentPane.add(lblName);
        
        JLabel lblFName = new JLabel("Name:");
        lblFName.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblFName.setBounds(330, 175, 99, 43);
        lblFName.setForeground(Color.white);
        contentPane.add(lblFName);
        
        JLabel lblvalidate = new JLabel("Amount:");
        lblvalidate.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblvalidate.setBounds(330, 245, 110, 29);
        lblvalidate.setForeground(Color.white);
        contentPane.add(lblvalidate);
       



        ID = new JTextField();
        ID.setFont(new Font("Tahoma", Font.PLAIN, 18));
        ID.setBounds(490, 112, 270, 40);
        contentPane.add(ID);
        ID.setColumns(10);
        
        Fname = new JTextField();
        Fname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Fname.setBounds(490, 175, 270, 40);
        contentPane.add(Fname);
        Fname.setColumns(10);


        Balance = new JTextField();
        Balance.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Balance.setBounds(490, 245, 270, 40);
        contentPane.add(Balance);
        Balance.setColumns(10);
        
        
        depositbt = new JButton("Submit");
        depositbt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String iD = ID.getText();
                String balance = Balance.getText();
                int b = Integer.parseInt(balance);
                String Firstname = Fname.getText();
                
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
                String pass = null;
                String actype = null;
                String msg = "" + iD;
                msg += " \n";
                double bal = 0;
            
                try {
                	
                	String sql = "select * from tbldeposit where ID="+iD;
                    p = con.prepareStatement(sql);
                    rs = p.executeQuery();
                    if (rs.next()){
     
                         actype=rs.getString("actype");
                         FirstN = rs.getString("Fname");
                          
                    }

                    //Balance calculation with interest
                    if(actype.equals("savings"))
                    {
                              bal = getS_interest(b);
                    	      System.out.println(bal);
                    	//JOptionPane.showMessageDialog(btnNewButton, "Enter the amount more then 2000rs");
                    }
                    else if(actype.equals("current"))
                    {
                    	     bal= getC_interest(b);
                    	     System.out.println(bal);
                    	//JOptionPane.showMessageDialog(btnNewButton, "Enter the amount more then 1000rs");
                    }
                    
                    
                    if(iD.isEmpty())
                    {
                        JOptionPane.showMessageDialog(depositbt, "ID is required.");
                    }
                    else if(Firstname.isEmpty())
                    {
                        JOptionPane.showMessageDialog(depositbt, "Name is required.");
                    }
                    else if(balance.isEmpty())
                    {
                        JOptionPane.showMessageDialog(depositbt, "Balance is required.");
                    }
                    else
                    {
                  
                    Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "Sushant@416");
                    String query = "update tbldeposit set Balance = Balance + "+bal+" where ID = "+iD+" and Fname ='"+Firstname+"'";
                    Statement sta = connection1.createStatement();
                    int x = sta.executeUpdate(query);
                    
                    
                     if (x == 0)
                     {
                        JOptionPane.showMessageDialog(depositbt, "Account does not exist.");
                    }
                    if(x==1)
                     {
                         JOptionPane.showMessageDialog(depositbt, "Your Amount has been cradited\n" + "Customer ID: "+msg + balance +" Rs. has been credited in your account \n On Date: " + Format);
                     }
                    
                    connection1.close();
                
                    }
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                
             }
        });
        
        depositbt.setFont(new Font("Tahoma", Font.PLAIN, 22));
        depositbt.setBounds(299, 297, 129, 34);
        contentPane.add(depositbt);
         
       
        
       

   
    

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
        Home.setBounds(850, 12, 120, 20);
        contentPane.add(Home);



    }
     
}

