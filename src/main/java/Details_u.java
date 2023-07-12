import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import com.itextpdf.*;





import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.protocol.Resultset;

public class Details_u extends JFrame{
	    private static final long serialVersionUID = 1L;
	    private JPanel contentPane;
	    
	    private JTextField ID;
	    private JTextField Password;
	    
	    private JButton getdetails;
	    
	    public static void main(String[] args){
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
	    
	public Details_u(){
	     Color color = Color.RED;
	        
	        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ichakevinayak.bhaus\\Downloads\\hcl.png"));
	        
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(350, 100, 650, 450);
	        setResizable(false);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        contentPane.setBackground(SystemColor.BLACK);
	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	        setTitle("                                                   !!!!!!!!!!!!! WELCOME TO HCL BANKINS  !!!!!!!!!!!!!");
	        
	        JLabel lblNewUserRegister = new JLabel("     HCL BANK  ");
	        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 25));
	        lblNewUserRegister.setBounds(222, 12, 200, 70);
	        lblNewUserRegister.setForeground(color.BLUE);
	        contentPane.add(lblNewUserRegister);
	        
	        JLabel lbnNewUserRegister = new JLabel("Get Details : ");
	        lbnNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 22));
	        lbnNewUserRegister.setBounds(265, 52, 200, 70);
	        lbnNewUserRegister.setForeground(color.orange);
	        contentPane.add(lbnNewUserRegister);
	        


	 
	JLabel lblName = new JLabel("Enter Account ID:");
	        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        lblName.setBackground(color);
	        lblName.setForeground(color.white);
	        lblName.setBounds(58, 138, 140, 43);
	        contentPane.add(lblName);
	        
	        JLabel lblNewLabel = new JLabel("Password :");
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        lblNewLabel.setBackground(color);
	        lblNewLabel.setForeground(Color.white);
	        lblNewLabel.setBounds(58, 243, 110, 29);
	        contentPane.add(lblNewLabel);
	        
	        ID = new JTextField();
	        ID.setFont(new Font("Tahoma", Font.PLAIN, 25));
	        ID.setBounds(214, 145, 228, 40);
	        contentPane.add(ID);
	        ID.setColumns(10);
	        



	        Password = new JTextField();
	        Password.setFont(new Font("Tahoma", Font.PLAIN, 25));
	        Password.setBounds(214, 235, 228, 40);
	        contentPane.add(Password);
	        Password.setColumns(10);

	       
	         getdetails= new JButton("show details");
	         getdetails.addActionListener(new ActionListener(){
	             @SuppressWarnings("null")
	            public void actionPerformed(ActionEvent e) {
	                 String Id = ID.getText();
	                 String pass = Password.getText();
	                 
	                 ConnectionDb connection = new ConnectionDb();
	                 Connection con = null;
	                 PreparedStatement p = null;
	                 PreparedStatement q=null;
	                 ResultSet rs = null;
	                 ResultSet z=null;
	                 
	                 con = ConnectionDb.createDBconnection();
	                 String DID = null;
	                 String ContactNum=null;
	                 String tid = null;
	                 String id2 = null;
	                 String Adhaarnumber = null;
	                 String AcTpe = null;
	                 int u_balance= 0;
	                 String password=null;
	                 String uname =null;
	                 int bal=0;
	                 
	                 try {
	                   
	                     String sql = "select * from tbldeposit where ID="+Id;
	                     String que="select * from details where AID="+Id;
	                     
	                     p = con.prepareStatement(sql);
	                     q=con.prepareStatement(que);
	                     
	                     rs = p.executeQuery();
	                     z=q.executeQuery();
	                     
	                     /*while(rs.next()){
	                    	 uname= rs.getString("Fname");
	                     }*/
	                     
	                     
	                     String file="C:\\Users\\jadhavsushant.vikas\\project documents\\_Account_Details.pdf";
	                     Document document=new Document();
	                     PdfWriter.getInstance(document, new FileOutputStream(file));
	                     document.open();
	                     document.add(Image.getInstance("C:\\Users\\jadhavsushant.vikas\\Downloads\\hcl.png"));
	                     
	                      while(rs.next()){
	                        
	                          DID = rs.getString("ID"); 
	                          password = rs.getString("password");
	                         
	                          Paragraph para=new Paragraph("**Account Deatils:"+"\n"+"Your ID:"+rs.getString("ID")+" \n"+"Your Fname:"+rs.getString("Fname")+"\n "+"Your Contact:"+rs.getString("ContactNum")+"\n "+"Your Address:"+rs.getString("Address")
	                          +"\n "+"Your Adhar Number:"+rs.getString("AdhaarNumber")+"\n "+"Your Account Type:"+rs.getString("AcType")+"\n "+"Your Balance:"+rs.getString("Balance"));
	                          document.add(para);
	                          document.add(new Paragraph(" "));
	                          
	                     }
	                         

	
	           while(z.next()) {
	        	   
	                          tid=z.getString("TID");
	                          id2=z.getString("AID");
	                          Paragraph para1=new Paragraph("**Transaction details:"+"\n"+"Your ID:"+z.getString("AID")+"\n"+"Your Transaction ID:"+z.getString("TID")+"\n"+"Last transaction amount:"+z.getString("Amt"));
	                          document.add(para1);
	                          document.add(new Paragraph(" ")); 
	                      }
	                      document.close();
	       
	                 }
	                 catch (SQLException | DocumentException | IOException er) {
	                     System.out.println(er);
	                 }
	                 
	                 if(Id.isEmpty() || pass.isEmpty()) {
	                	 JOptionPane.showMessageDialog(getdetails,"Please Enter the required feilds");
	                 }
	                 else if(!Id.equals(DID)){
	                	 JOptionPane.showMessageDialog(getdetails,"Invalid Account ID!");
	                 }
	                 else if(!pass.equals(password)){
	                	 JOptionPane.showMessageDialog(getdetails,"Invalid Password !");
	                 }
	                 else if(Id.equals(DID) || pass.equals(password)){
	                     
	                     JOptionPane.showMessageDialog(getdetails,"Your details Generated Successfully");
	                 }
	                
	                 else{
	                     JOptionPane.showMessageDialog(getdetails,"details is invalid");
	                 }  
	             }
	         });
	         getdetails.setFont(new Font("Tahoma", Font.PLAIN, 22));
	         getdetails.setBounds(222, 325, 199, 50);
	         contentPane.add(getdetails);
	         
	         JButton Logout = new JButton("Back");
	         Logout.addActionListener(new ActionListener(){
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
	         
	         Logout.setFont(new Font("Tahoma", Font.PLAIN, 15));
	         Logout.setBounds(500, 12 ,100, 30);
	         contentPane.add(Logout);
	     }
	     
	}
  

