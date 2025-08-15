
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener{
    
    JTextField  tfpnr;
    JLabel  tfname, tfnationality , lblsrc,lbldest,labelfname,labelfcode,labeldate;
    JButton bookflight,fetchButton,flight;
    
    
    
    public BoardingPass(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading= new JLabel("AIR INDIA");
        heading.setBounds(380,10,450,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        add(heading);
        
        
        
        JLabel subheading= new JLabel("BOARDING PASS");
        subheading.setBounds(380,50,300,35);
        subheading.setFont(new Font("Tahoma",Font.PLAIN,20));
        subheading.setForeground(Color.BLUE);
        add(subheading);
        
        
        
        JLabel lblaadhar= new JLabel("PNR DETAILS");
        lblaadhar.setBounds(60,100,150,25);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblaadhar.setForeground(Color.BLUE);
        add(lblaadhar);
        
        tfpnr= new JTextField();
        tfpnr.setBounds(220,100,150,25);
        add(tfpnr);
        
        
        fetchButton = new JButton("ENTER");
        fetchButton.setBackground(Color.GRAY);
        fetchButton.setForeground(Color.white);
        fetchButton.setBounds(380,100,120,25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        
        
        JLabel lblname= new JLabel("NAME");
        lblname.setBounds(60,140,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblname.setForeground(Color.BLUE);
        add(lblname);
        
        tfname= new JLabel();
        tfname.setBounds(220,140,150,25);
        add(tfname);
        
        
        
        
        JLabel lblnationality= new JLabel("NATIONALITY");
        lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblnationality.setForeground(Color.BLUE);
        add(lblnationality);
        
        tfnationality= new JLabel();
        tfnationality.setBounds(220,180,150,25);
        add(tfnationality);
        
        
        
        
        lblsrc= new JLabel("SRC");
        lblsrc.setBounds(60,220,150,25);
        lblsrc.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblsrc.setForeground(Color.BLUE);
        add(lblsrc);
        
        lblsrc =new JLabel();
        lblsrc.setBounds(220,220,150,25);
        add(lblsrc);
        
        
        
        
        
        lbldest= new JLabel("DEST");
        lbldest.setBounds(60,260,150,25);
        lbldest.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbldest.setForeground(Color.BLUE);
        add(lbldest);
        
        lbldest= new JLabel();
        lbldest.setBounds(220,260,150,25);
        add(lbldest);
        
        
        
       
      
        
        
        JLabel lblfname= new JLabel("FLIGHT NAME");
        lblfname.setBounds(60,300,150,25);
        lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblfname.setForeground(Color.BLUE);
        add(lblfname);
        
        labelfname= new JLabel();
        labelfname.setBounds(220,300,150,25);
        add(labelfname);
        
        
        
        
        JLabel lblfcode= new JLabel("FLIGHT CODE");
        lblfcode.setBounds(60,340,150,25);
        lblfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblfcode.setForeground(Color.BLUE);
        add(lblfcode);
        
        labelfcode= new JLabel();
        labelfcode.setBounds(220,340,150,25);
        add(labelfcode);
        
        
        
        
        
        JLabel lbldate= new JLabel("DATE");
        lbldate.setBounds(60,530,150,25);     
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldate);
        
        labeldate= new JLabel();
        labeldate.setBounds(220,530,150,25);
        add(labeldate);
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
        Image i2= i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i2);
        JLabel lblimage= new JLabel(image);
        lblimage.setBounds(600,40,300,300);
        add(lblimage);
        
        
        
        setSize(1000,450);
        setLocation(300,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       
        String pnr= tfpnr.getText();
        
        try{
            Conn conn = new Conn();
            String query="select * from reservation where PNR='"+pnr+"'";
            ResultSet rs=conn.s.executeQuery(query);
            
             if(rs.next()){
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                lblsrc.setText(rs.getString("src"));
                lbldest.setText(rs.getString("dest"));
                labelfname.setText(rs.getString("flightname"));
                labelfcode.setText(rs.getString("flightcode"));
                labeldate.setText(rs.getString("ddate"));
            }else{
            JOptionPane.showMessageDialog(null,"Please Enter Correct PNR");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String srgs[]){
        new BoardingPass();
    }
}
