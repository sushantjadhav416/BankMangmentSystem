
/*import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.*;
public class Details {

    
    //public static void main(String[] args)
    public void get_details()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Customer ID..");
        String num = sc.nextLine();
       
        ConnectionDb connection = new ConnectionDb();
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        con = ConnectionDb.createDBconnection();

        try {
            
            
            String sql = "select * from tbldeposit where id="+num;
            p = con.prepareStatement(sql);
            rs = p.executeQuery();
            System.out.println("id\t\tname\t\temail\t\tpassword");
            if (rs.next()){
               
                int ID = rs.getInt("ID");
                String Fname = rs.getString("Fname");
                String Address = rs.getString("Address");
                String AdhaarNumber = rs.getString("AdhaarNumber");
                String ContactNum = rs.getString("ContactNum");
                String AcType = rs.getString("AcType");
                String Balance = rs.getString("Balance");
                 
                System.out.println(ID + "\t\t" + Fname+ "\t\t" + Address +"\t\t"+ AdhaarNumber+ "\t\t" + ContactNum+ "\t\t" + AcType+ "\t\t" + Balance);
            }
        }

        catch (SQLException e) {

            System.out.println(e);
        }
    }
}*/
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Details extends JFrame{
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    private JTextField ID;
    private JTextField ContactNum;
    
    private JButton getdetails;
    
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Details frame = new Details();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
   
   public Details(){
        
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jadhavsushant.vikas\\OneDrive - HCL Technologies Ltd\\Desktop\\OIP"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 100, 650, 450);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("              !!!!!!!!!!!!! WELCOME TO HCL BANKINS  !!!!!!!!!!!!!");
        
        JLabel lblNewUserRegister = new JLabel("     HCL BANK  "); 
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewUserRegister.setBounds(222, 12, 200, 70);
        contentPane.add(lblNewUserRegister);
        
        JLabel lbnNewUserRegister = new JLabel("    Account Details ");
        lbnNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lbnNewUserRegister.setBounds(222, 52, 200, 70);
        contentPane.add(lbnNewUserRegister);
        
        JLabel lblName = new JLabel("Enter the ID:");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblName.setBounds(58, 138, 99, 43);
        contentPane.add(lblName);
        
        JLabel lblNewLabel = new JLabel("Contact number:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);
        
        ID = new JTextField();
        ID.setFont(new Font("Tahoma", Font.PLAIN, 25));
        ID.setBounds(214, 145, 228, 40);
        contentPane.add(ID);
        ID.setColumns(10);
        

        ContactNum = new JTextField();
        ContactNum.setFont(new Font("Tahoma", Font.PLAIN, 25));
        ContactNum.setBounds(214, 235, 228, 40);
        contentPane.add(ContactNum);
        ContactNum.setColumns(10);

        
        getdetails= new JButton("show details");
        getdetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	String Id = ID.getText();
                String Contact = ContactNum.getText(); 
                
                ConnectionDb connection = new ConnectionDb();
                Connection con = null;
                PreparedStatement p = null;
                ResultSet rs = null;
                
                con = ConnectionDb.createDBconnection();
                String DID = null;
                String ContactNum=null;
                String Fname = null;
                String address = null;
                String Adhaarnumber = null;
                String AcTpe = null;
                int u_balance= 0;
                

                LocalDateTime MyDate = LocalDateTime.now();
                DateTimeFormatter myformater = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String Formate = MyDate.format(myformater);
                
                try {
                    
                    
                    String sql = "select * from tbldeposit where id="+Id;
                    p = con.prepareStatement(sql);
                    rs = p.executeQuery();
                    if (rs.next()){
                       
                         DID = rs.getString("ID");
                         Fname= rs.getString("Fname");
                         ContactNum = rs.getString("ContactNum");
                         address = rs.getString("Address");
                         Adhaarnumber = rs.getString("AdhaarNumber");
                         AcTpe = rs.getString("AcType");
                         u_balance = rs.getInt("Balance");
                          
                    }
                }
                catch (SQLException er) {
                    System.out.println(er);
                }
                if(Id.equals(DID) && ContactNum.equals(Contact)){
                	JOptionPane.showMessageDialog(getdetails,"Your Name: "+Fname+"\n"+"your balance:"+u_balance+"\n"+"\n"+"Details viewed on time "+Formate);
                }
                else{
                	JOptionPane.showMessageDialog(getdetails,"detals is invalid");
                }  
            }
        });
        getdetails.setFont(new Font("Tahoma", Font.PLAIN, 22));
        getdetails.setBounds(222, 325, 199, 50);
        contentPane.add(getdetails); 
    }
	
}


