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
import java.sql.SQLException;
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

	public class Forgot_pass extends JFrame {
	    
	    private static final long serialVersionUID = 1L;
	    private JPanel contentPane;
	    
	    private JTextField ID;
	    private JTextField Username;
	    private JTextField Password;
	    
	    private JButton Passchange;
	    
	    
	    
	    public static void main(String[] args){
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
	   
	    
	    public Forgot_pass() {
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(350, 100, 750, 550);
	        setResizable(false);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	        contentPane.setBackground(SystemColor.black);
	        setTitle("***Welcome To HCLBanking***");
	        
	        JLabel lblNewUserRegister = new JLabel("     HCL BANK    ");
	        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 25));
	        lblNewUserRegister.setBounds(280, 12, 200, 70);
	        lblNewUserRegister.setForeground(Color.BLUE);
	        contentPane.add(lblNewUserRegister);
	        
	        JLabel lblNewText = new JLabel("Change Current Password");
	        lblNewText.setFont(new Font("Times New Roman", Font.BOLD, 22));
	        lblNewText.setBounds(260, 50, 800, 70);
	        lblNewText.setForeground(Color.yellow);
	        contentPane.add(lblNewText);
	        
	        JLabel lblName = new JLabel("Enter the ID:");
	        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        lblName.setBounds(220, 140, 150, 43);
	        lblName.setForeground(Color.white);
	        contentPane.add(lblName);
	         
	        JLabel lblUser = new JLabel("Enter Username:");
	        lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        lblUser.setBounds(220, 210, 150, 43);
	        lblUser.setForeground(Color.white);
	        contentPane.add(lblUser);
	        
	   

	        JLabel lblPass = new JLabel("Enter Password:");
	        lblPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        lblPass.setBounds(220, 270, 150, 43);
	        lblPass.setForeground(Color.white);
	        contentPane.add(lblPass);
	        
	        ID = new JTextField();
	        ID.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        ID.setBounds(350, 140, 228, 30);
	        contentPane.add(ID);
	        ID.setColumns(10);
	        
	        Username = new JTextField();
	        Username.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        Username.setBounds(350, 210, 228, 30);
	        contentPane.add(Username);
	        Username.setColumns(10);
	        
	        Password = new JTextField();
	        Password.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        Password.setBounds(350, 280, 228, 30);
	        contentPane.add(Password);
	        Password.setColumns(10);
	        
	      
	        Passchange= new JButton("Passchange");
	        Passchange.addActionListener(new ActionListener(){
	        	
	            public void actionPerformed(ActionEvent e) {
	                String Id = ID.getText();
	                String UserId = Username.getText();
	                String PassId = Password.getText();
	                
	                ConnectionDb connection = new ConnectionDb();
	                Connection con = null;
	                PreparedStatement p = null;
	                ResultSet rs = null;
	                con = ConnectionDb.createDBconnection();
	                String DID = null;
	                String UserDID = null;
	                String PassDID = null;
	                try {
	                	Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "Sushant@416");
	                    String query = "update tbldeposit set Password = '"+PassId+"' where ID = "+Id+" and Fname ='"+UserId+"'";

	                	Statement sta = connection1.createStatement();
	                     int x = sta.executeUpdate(query);
	                     
	                    String sql = "select * from tbldeposit where id="+Id;
	                    p = con.prepareStatement(sql);
	                    rs = p.executeQuery();
	                    if (rs.next())
	                    {
	                       
	                         DID = rs.getString("ID");
	                         UserDID = rs.getString("Fname");
	                         PassDID = rs.getString("Password");
	                    }
	                    if(Id.isEmpty() || UserId.isEmpty() || PassId.isEmpty()){
	                    	JOptionPane.showMessageDialog(Passchange,"Your Password Updated Successfully...") ; 
	                    }             
	                    else if(Id.equals(DID) && UserDID.equals(UserId)) {
		                       
		                    JOptionPane.showMessageDialog(Passchange,"Your Password Updated Successfully...") ; 
		                }
		                else{
		                    JOptionPane.showMessageDialog(Passchange,"Invalid Details");
		                }  
	                    
	                     
	                }
	                catch (SQLException er) {
	                    System.out.println(er);
	                }
	                
	                
	            }
	            
	            
	            
	        });
	        Passchange.setFont(new Font("Tahoma", Font.BOLD, 20));
	        Passchange.setBounds(280, 380, 199, 40);
	        contentPane.add(Passchange);
	        
	        JButton Logins = new JButton("Login");
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
	        Logins.setBounds(550, 12, 120, 30);
	        Logins.setBackground(Color.orange);
	        contentPane.add(Logins);
	        
	        
	    }





	}

