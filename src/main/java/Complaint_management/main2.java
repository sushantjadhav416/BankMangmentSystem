package Complaint_management;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class main2 extends JFrame{
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    private JButton Addnewcomp;
    private JButton DeletComp;
   
    private JButton vewcomp;
    private JButton updComp;
    
    
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    main2 frame = new main2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public main2() {
        
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
        setTitle("              !!!!!!!!!!!!! Admin Main Window !!!!!!!!!!!!!");
        
        JLabel lblNewUserRegister = new JLabel(" Admin Window  "); 
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 35));
        lblNewUserRegister.setBounds(222, 12, 230, 70);
        lblNewUserRegister.setForeground(Color.blue);
        contentPane.add(lblNewUserRegister);
        
        
        /*JLabel lbnNewUserRegister = new JLabel("Please Select option ");
        lbnNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lbnNewUserRegister.setBounds(222, 52, 200, 70);
        contentPane.add(lbnNewUserRegister);*/
        
      
        
        
        
        Addnewcomp= new JButton("Add new Complaint:");
        Addnewcomp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                             //Credite_amt frame = new Credite_amt();
                             //frame.setVisible(true);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
            }
            
        });
        Addnewcomp.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Addnewcomp.setBounds(222, 100, 200, 40);
        Addnewcomp.setBackground(Color.orange);
        contentPane.add(Addnewcomp);
        
        DeletComp= new JButton("Withdraw Amount:");
        DeletComp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            // Withdraw frame = new Withdraw();
                             //rame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        DeletComp.setFont(new Font("Tahoma", Font.PLAIN, 16));
        DeletComp.setBounds(400, 195, 200, 40);
        DeletComp.setBackground(Color.orange);
        contentPane.add(DeletComp);
        
        vewcomp= new JButton("Account details");
        vewcomp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                        	//Details_u frame = new Details_u();
                             //frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        vewcomp.setFont(new Font("Tahoma", Font.PLAIN, 18));
        vewcomp.setBounds(222, 300, 170, 40);
        vewcomp.setBackground(Color.cyan);
        contentPane.add(vewcomp);
        
        
        updComp= new JButton("Money transfer");
        updComp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                        	//Transfer frame = new Transfer();
                             //frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        updComp.setFont(new Font("Tahoma", Font.PLAIN, 18));
        updComp.setBounds(42, 195, 180, 40);
        updComp.setBackground(Color.orange);
        contentPane.add(updComp); 
        
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

