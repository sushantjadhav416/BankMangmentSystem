import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

interface Savings {
   public  double  getS_interest(int b);
   
}

interface current {
	
      public double  getC_interest(int b);
      
}
	
public class Accounts extends JFrame implements Savings,current{
	static double interestRate =0;
	   
	@Override
	public  double getS_interest(int b){
		    interestRate =0.5;
		    double netInterest = (interestRate/12);
		    double  mInterest =netInterest*b;
		    b = (int) (b  + mInterest);
		    return b;
	    }
	
	@Override 
	public  double getC_interest(int b){
		 interestRate =0.3;
		    double netInterest = (interestRate/12);
		    double  mInterest = (int) (netInterest*b);
		    b=(int) (b+mInterest);
		    return b;
		 
	   }

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField Fname;
    private JTextField Address;
    private JTextField AdhaarNumber;
    private JTextField ContactNum;
    private JTextField AcType;
    private JTextField Balance;
    private JButton btnNewButton;
    private JButton AbtnNewButton ;
    private JPasswordField Password;
    
    
    
    public static void main(String[] args) {
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
    
    public Accounts() {
    
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(SystemColor.GRAY);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("                             !!!!!!!!!!!!! WELCOME TO HCL BANKING  !!!!!!!!!!!!!");
        
        JLabel lblNeUserRegister = new JLabel("     HCL BANK  "); 
        lblNeUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNeUserRegister.setBounds(390, 6, 390, 70);
        lblNeUserRegister.setForeground(Color.BLUE);
        contentPane.add(lblNeUserRegister);
        
        JLabel lblNewUserRegister = new JLabel("New Account opening");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 32));
        lblNewUserRegister.setBounds(362, 72, 325, 32);
        lblNewUserRegister.setForeground(Color.WHITE);
        contentPane.add(lblNewUserRegister);
        
        JLabel lbmNewUserRegister = new JLabel("Note:please Enter some amount for account creation");
        lbmNewUserRegister.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        lbmNewUserRegister.setBounds(399, 477, 350, 74);
        lbmNewUserRegister.setForeground(Color.RED);
        contentPane.add(lbmNewUserRegister);

        
        JLabel lblName = new JLabel("First name:");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblName.setBounds(58, 140, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Address");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(58, 220, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Adhaar number:");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblEmailAddress.setBounds(58,285, 124, 36);
        contentPane.add(lblEmailAddress);
        
        JLabel lblpmailAddress = new JLabel("Enter password:");
        lblpmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpmailAddress.setBounds(58,345, 124, 36);
        contentPane.add(lblpmailAddress);

        Fname = new JTextField();
        Fname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Fname.setBounds(214, 141, 228, 30);
        contentPane.add(Fname);
        Fname.setColumns(10);
        
        Address = new JTextField();
        Address.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Address.setBounds(214, 200, 228, 70);
        contentPane.add(Address);
        Address.setColumns(10);

        AdhaarNumber = new JTextField();
        AdhaarNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
        AdhaarNumber.setBounds(214, 290, 228, 30);
        contentPane.add(AdhaarNumber);
        AdhaarNumber.setColumns(10);
        
        Password = new JPasswordField();
        Password.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Password.setBounds(214, 345, 228, 30);
        Password.setEchoChar('*');
        contentPane.add(Password);
        Password.setColumns(10);
        

       
        final JCheckBox savings = new JCheckBox("Savings");
        savings.setFont(new Font("Tahoma", Font.PLAIN, 15));
        savings.setBounds(707, 145, 100, 25);
        contentPane.add(savings);
        
        final JCheckBox current = new JCheckBox("Current");
        current.setFont(new Font("Tahoma", Font.PLAIN, 15));
        current.setBounds(707, 165, 100, 25);
        contentPane.add(current);
        
        
        JLabel lblUsername = new JLabel("   Account Type:");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblUsername.setBounds(542, 159, 149, 30);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Enter Some Balance:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPassword.setBounds(542, 240, 159, 24);
        contentPane.add(lblPassword);
        

        JLabel lblMobileNumber = new JLabel("   Mobile number:");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblMobileNumber.setBounds(542, 320, 139, 26);
        contentPane.add(lblMobileNumber);

        ContactNum = new JTextField();
        ContactNum.setFont(new Font("Tahoma", Font.PLAIN, 20));
        ContactNum.setBounds(707, 320, 228, 30);
        contentPane.add(ContactNum);
        ContactNum.setColumns(10);

        Balance = new JTextField();
        Balance.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Balance.setBounds(707, 235, 228, 30);
        contentPane.add(Balance);

        
       
        
        
        
        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            
                long Id = 0;
                Random RId = new Random();
                Id = RId.nextLong(100000,500000);
                
                
                String YourName = Fname.getText();
                String lastaddress = Address.getText();
                String adhaarId = AdhaarNumber.getText();
                int lenAd = adhaarId.length();
                String contactnum  = ContactNum.getText();
                int len = contactnum.length();
                
                String balance = Balance.getText();
                int b = Integer.parseInt(balance);
                
                String password = Password.getText();
                int plen = password.length();
                double bal = 1;
                
                
                //Account type 
                String actype="";
                if(savings.isSelected()){
                	actype="savings";
                	}
                if(current.isSelected()) {
                	actype="current";
                }
                if(savings.isSelected() && current.isSelected()) {
                	actype="";
                }
                	
                
                
                
                //Balance calculation with interest
                if(actype.equals("savings"))
                {
                          bal = getS_interest(b);
                	      System.out.println(bal);
                	
                }
                else if(actype.equals("current"))
                {
                	     bal= getC_interest(b);
                	     System.out.println(bal);
                	
                }
                
                
                
               //validations part 
                
                if(YourName.isEmpty()){
                	JOptionPane.showMessageDialog(btnNewButton, "Please Enter all requred field");
                }
                else if(lastaddress.isEmpty()) {
                	JOptionPane.showMessageDialog(btnNewButton, "Please Enter all requred field");
                }
                else if(adhaarId.isEmpty()) {
                	JOptionPane.showMessageDialog(btnNewButton, "Please Enter all requred field");
                }
                else if(lenAd < 12 || lenAd >  12) {
                	JOptionPane.showMessageDialog(btnNewButton, "Please Enter valid adhaar Number! ");
                }
                else if(plen<6) {
                	JOptionPane.showMessageDialog(btnNewButton, "Enter the Password more then 6 digits");
                	
                }
                else if(balance.isEmpty()) {
                	JOptionPane.showMessageDialog(btnNewButton, "Please Enter Some balance for account openings");
                	
                }
                else if(actype.equals("")) {
                	JOptionPane.showMessageDialog(btnNewButton, "Please Select one account type");
                }
                else if(actype.isEmpty()) {
                	JOptionPane.showMessageDialog(btnNewButton, "Please Enter all requierd fields");
                }
                else if (len < 10 || len >  10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }
                
                else {
                	
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "Sushant@416");

                    String query = "INSERT INTO tbldeposit values("+Id+",'"+YourName+"','" +lastaddress+"','"+adhaarId+"','"+contactnum+"','"+actype+"','"+bal+"','"+password+"')";
                   
                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0){
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,"Welcome, " + YourName + "Your  "+ actype+" account is sucessfully created\n"+"Your account Id: "+Id);
                        setVisible(false);
                    }
                    
                    EventQueue.invokeLater(new Runnable(){
                        public void run() {
                            try {
                                Main frame = new Main();
                                frame.setVisible(true);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    
                    connection.close();
                    
                }catch (Exception exception){
                    exception.printStackTrace();
                }
              }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 427, 259, 54);
        contentPane.add(btnNewButton);
        
        AbtnNewButton = new JButton("Upload");
        AbtnNewButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	 try {
            	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "Sushant@416");
            	String adhaarId = AdhaarNumber.getText();
            	
            	JFileChooser file_upload = new JFileChooser();
            	int res = file_upload.showOpenDialog(null);
            	File f = file_upload.getSelectedFile();
            	
            	FileInputStream  f1 = new FileInputStream(f);
            	//String  = .getAbsolutePath();
            	//File = new File();
                byte[] doc = new byte[(int)f.length()];
                f1.read(doc);
                ByteArrayInputStream bais = new ByteArrayInputStream(doc);
                
                
				String sql ="INSERT INTO pfile values("+adhaarId+",'"+bais+"')";
				Statement sta = connection.createStatement();
				
                int x = sta.executeUpdate(sql);
                if (x == 0) {
                    JOptionPane.showMessageDialog(btnNewButton, "file not added");
                } else {
                    JOptionPane.showMessageDialog(btnNewButton, "File added Successfully!! ");
                }
				
				f1.close();
				connection.close();
            	
            }catch (Exception exception) {
                exception.printStackTrace();
            }
            }
        });
        AbtnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        AbtnNewButton.setBounds(450, 290,80, 20);
        contentPane.add(AbtnNewButton);
    }

	
}