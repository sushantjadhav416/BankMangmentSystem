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

public class Transfer_amt extends JFrame{
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
                    Transfer_amt frame = new Transfer_amt();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public Transfer_amt() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Java Codes\\CapstoneBackground.webp"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 90, 750, 450);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(SystemColor.BLACK);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("              !!!!!!!!!!!!! WELCOME TO HCL BANKINS  !!!!!!!!!!!!!");
        
        JLabel lblewUserRegister = new JLabel("         HCL BANK  ");
        lblewUserRegister.setForeground(Color.BLUE);
        lblewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblewUserRegister.setBounds(222, 12, 220, 70);
        contentPane.add(lblewUserRegister);
        
        JLabel lblNewUserRegister = new JLabel("   Money Transfer  Window ");
        lblNewUserRegister.setForeground(Color.orange);
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblNewUserRegister.setBounds(222, 62, 325, 50);
        contentPane.add(lblNewUserRegister);
        
        
        JLabel lbmNewUserRegister = new JLabel("Note:please Enter your correct Account ID");
        lbmNewUserRegister.setForeground(Color.WHITE);
        lbmNewUserRegister.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        lbmNewUserRegister.setBounds(199, 317, 350, 74);
        contentPane.add(lbmNewUserRegister);
        
        JLabel lblName1 = new JLabel("Enter your account Id:");
        lblName1.setForeground(Color.WHITE);
        lblName1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblName1.setBounds(38, 112, 160, 43);
        contentPane.add(lblName1);
        
        JLabel lblName2 = new JLabel("Enter Receiver Account Id:");
        lblName2.setForeground(Color.WHITE);
        lblName2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblName2.setBounds(38, 172, 180, 43);
        contentPane.add(lblName2);

        JLabel lblNewLabel = new JLabel("Enter Amount:");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(38, 232, 100, 29);
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
                try {
                float iD11 = Float.parseFloat(ID1.getText());
                float iD22 = Float.parseFloat(ID2.getText());
                String balance = Balance.getText();
                int bal=Integer.parseInt(balance);
                String iD1=Float.toString(iD11);
                String iD2=Float.toString(iD22);
                int count=0;
                
                
               // Connection con = null;
                PreparedStatement p=null;
                ResultSet rs = null;



               
         
                
                long TID= 0;
                Random RId = new Random();
                TID = RId.nextLong(100000000,500000000);
                
               
                LocalDateTime MyDate = LocalDateTime.now();
                DateTimeFormatter myformater = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String Formate = MyDate.format(myformater);
               
                
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "Sushant@416");
                    String sql="select Balance from tbldeposit where ID="+iD1+"";
                    p=connection.prepareStatement(sql);
                    
                    rs=p.executeQuery();
                    rs.next();
                   String b=rs.getString("Balance");
                   int b1=Integer.parseInt(b);
                   String co= rs.getString("count");
                   int c = Integer.parseInt(co);
                   
                  
                   
                   if(b1>=bal) {
                       if(iD1.equals(iD2)) {
                           JOptionPane.showMessageDialog(null,"Cant Transfer to Same account");
                       }
                           else{
                        	   
                          c=c+1; 
                          String query = "update tbldeposit set Balance = Balance - "+balance+" where ID = "+iD1+"";
                          Statement sta = connection.createStatement();
                          int x = sta.executeUpdate(query);
                         
                            sta.executeUpdate("update tbldeposit set Balance = Balance + "+balance+" where ID = "+iD2+" ");
                            
                             JOptionPane.showMessageDialog(depositbt, "Your Transaction has been Done\n" + "Your Transaction id: "+ TID +"\n"+Formate);
                        }
                       }
                           
                       else {
                           
                           JOptionPane.showMessageDialog(null, "Insufficient Balance");
                       }
                     
                        
                         
                           String query3 = "INSERT INTO tdetails values("+TID+",'"+Formate+"','"+iD1+"','"+balance+"','"+c+"')";
                            Statement sta3 = connection.createStatement();
                           int x3 = sta3.executeUpdate(query3);
                       
                      
                                             
                        // String sql = "select * from tbldeposit where id="+id+"";
                         // boolean b1=Boolean.parseBoolean(sql); 
                           
                           connection.close();
                } catch ( NumberFormatException er)
                {   
                    //System.out.println("hi");
                    JOptionPane.showMessageDialog(null, "Please Enter Correct Values");
                  //  er.printStackTrace();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null, "Given values does Not exist");
                    e1.printStackTrace();
                }
                
               }
            
          
        });
        depositbt.setFont(new Font("Tahoma", Font.PLAIN, 22));
        depositbt.setBounds(299, 297, 129, 34);
        contentPane.add(depositbt);
        
        
        Home = new JButton("HOME");
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

