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
import java.util.Random;

public class Transfer extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField ID1;
    private JTextField ID2;
    
    private JTextField Balance;
    
    private JButton Home;
    private JButton depositbt;
    
    public static void main(String[] args) {
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
    
    public Transfer() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(""));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 90, 750, 450);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(SystemColor.BLACK);
        setContentPane(contentPane);
        
        contentPane.setLayout(null);
        setTitle("              !!!!!!!!!!!!! WELCOME TO HCL BANKING  !!!!!!!!!!!!!");
        
        JLabel lblewUserRegister = new JLabel("         HCL BANK  "); 
        lblewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblewUserRegister.setBounds(222, 12, 220, 70);
        lblewUserRegister.setForeground(Color.BLUE);
        contentPane.add(lblewUserRegister);
        
        
        JLabel lblNewUserRegister = new JLabel("   Money Transfer  Window ");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewUserRegister.setBounds(222, 62, 325, 50);
        lblNewUserRegister.setForeground(Color.orange);
        contentPane.add(lblNewUserRegister);
        
        JLabel lbmNewUserRegister = new JLabel("Note:please Enter your correct Account ID");
        lbmNewUserRegister.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        lbmNewUserRegister.setForeground(Color.RED);
        lbmNewUserRegister.setBounds(199, 317, 350, 74);
        contentPane.add(lbmNewUserRegister);
        
        JLabel lblName1 = new JLabel("Enter your Account Id:");
        lblName1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblName1.setBounds(58, 112, 160, 43);
        lblName1.setForeground(Color.WHITE);
        contentPane.add(lblName1);
        
        JLabel lblName2 = new JLabel("Enter Receiver Id:");
        lblName2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblName2.setBounds(58, 172, 120, 43);
        lblName2.setForeground(Color.WHITE);
        contentPane.add(lblName2);


        JLabel lblNewLabel = new JLabel("Enter Amount:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(58, 232, 110, 29);
        lblNewLabel.setForeground(Color.WHITE);
        contentPane.add(lblNewLabel);
       
        ID1 = new JTextField();
        ID1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        ID1.setBounds(214, 121, 228, 30);
        contentPane.add(ID1);
        ID1.setColumns(10);
        
        ID2 = new JTextField();
        ID2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        ID2.setBounds(214, 171, 228, 30);
        contentPane.add(ID2);
        ID2.setColumns(10);
        
        Balance = new JTextField();
        Balance.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Balance.setBounds(214, 225, 228, 30);
        contentPane.add(Balance);
        Balance.setColumns(10);
        
        
        depositbt = new JButton("Ok");
        depositbt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String iD1 = ID1.getText();
                String iD2 = ID2.getText();
                String balance = Balance.getText();
                int b = Integer.parseInt(balance);
                
                long TID= 0;
                Random RId = new Random();
                TID = RId.nextLong(100000000,500000000);
                int u_balance=0;
                String id1=null;
                String id2=null;
                String count = null;
                int c = 0;
                
                LocalDateTime MyDate = LocalDateTime.now();
                DateTimeFormatter myformater = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String Formate = MyDate.format(myformater);
                
                Connection connection = null;
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "Sushant@416");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                PreparedStatement p1 = null;
                ResultSet rs1 = null;
                String sql = "select * from tbldeposit where id="+iD1;
                try {
					p1= connection.prepareStatement(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                try {
					rs1 = p1.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                PreparedStatement p2 = null;
                ResultSet rs2 = null;
                String sql2 = "select * from tbldeposit where id="+iD2;
                try {
					p1= connection.prepareStatement(sql2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                try {
					rs2 = p1.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
              
                
                try {
					if (rs1.next()){
						 u_balance = rs1.getInt("Balance");
						 id1 =rs1.getString("ID");
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                try {
					if (rs2.next()){
					 
					 id2 =rs2.getString("ID");
					 
                      }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                PreparedStatement p3 = null;
                ResultSet rs3 = null;
                String sql3 = "select * from details where AID="+iD1;
                try {
					p3= connection.prepareStatement(sql3);
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
                try {
					rs3 = p3.executeQuery();
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
              
                try {
					if (rs3.next()){
					   count = rs3.getString("count");
					   c =Integer.parseInt(count);
                      }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                
                
                
                if (!iD1.equals(id1) || !iD2.equals(id2)){
                    JOptionPane.showMessageDialog(depositbt, "Account not exists");
                }
                
                 else if(b>u_balance){
                	 JOptionPane.showMessageDialog(depositbt, "you do not have enough balance in your account!");
                }
                 else {
                   
               
                try {
                    
                    c++;
                    if (!iD1.equals(id1) || !iD2.equals(id2)) {
                        JOptionPane.showMessageDialog(depositbt, "please enter the valid Account ID");
                    }
                    if(iD1.equals(iD2))
                    {
                    	JOptionPane.showMessageDialog(depositbt, "can not transfer to same account");
                    }
                     else if(b>u_balance){
                    	 JOptionPane.showMessageDialog(depositbt, "you do not have enough balance in your account!");
                    }
                     else{
                        
                    
                    String query = "update tbldeposit set Balance = Balance - "+balance+" where ID = "+iD1+"";
                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    String query2 = "update tbldeposit set Balance = Balance + "+balance+" where ID = "+iD2+"";
                    Statement sta2 = connection.createStatement();
                    int x2 = sta2.executeUpdate(query2);
                   
                    
                    
                
                    String query3 = "INSERT INTO details values("+TID+",'"+Formate+"','"+iD1+"','"+balance+"','"+c+"')";
                    Statement sta3 = connection.createStatement();
                    int x3 = sta.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(depositbt, "Your Transaction has been Done\n" + "Your Transaction id: "+ TID +"\n"+Formate);
                    }
                    connection.close();
                    }
                 catch (Exception exception)
                {
                    exception.printStackTrace();
                }
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
        Home.setBounds(600, 12 ,100, 30);
        contentPane.add(Home);



    }
    
    
    
}

