package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Cancel extends JFrame implements ActionListener{
    
    JTextField  tfpnr;
    JLabel  tfname, cancellationno ,lbldate,lblfcode;
    JButton cancel,fetchButton;
    
    
    
    public Cancel(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        Random random = new Random();
        
        JLabel heading= new JLabel("CANCELLATION");
        heading.setBounds(180,20,250,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        add(heading);
        
        
        ImageIcon i1= new ImageIcon (ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(470,120,250,250);
        add(image);
        
        
        
        JLabel lblpnr= new JLabel("PNR Number");
        lblpnr.setBounds(60,80,150,25);
        lblpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpnr.setForeground(Color.BLUE);
        add(lblpnr);
        
        tfpnr= new JTextField();
        tfpnr.setBounds(220,80,150,25);
        add(tfpnr);
        
        
        fetchButton = new JButton("SHOW DETAILS");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.white);
        fetchButton.setBounds(380,80,120,25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        

        
        
        
        JLabel lblname= new JLabel("NAME");
        lblname.setBounds(60,130,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblname.setForeground(Color.BLUE);
        add(lblname);
        
        tfname= new JLabel();
        tfname.setBounds(220,130,150,25);
        add(tfname);
        
        
        
        
        
        
        JLabel lblcancellation= new JLabel("CANCELLATION NO");
        lblcancellation.setBounds(60,180,150,25);
        lblcancellation.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblcancellation.setForeground(Color.BLUE);
        add(lblcancellation);
        
        cancellationno= new JLabel(""+random.nextInt(1000000));
        cancellationno.setBounds(220,180,150,25);
        add(cancellationno);
        
        
        
        
        
        lblfcode= new JLabel("FLIGHT CODE");
        lblfcode.setBounds(60,230,150,25);
        lblfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblfcode.setForeground(Color.BLUE);
        add(lblfcode);
        
        lblfcode =new JLabel();
        lblfcode.setBounds(220,230,150,25);
        add(lblfcode);
        
        
        
        
        
        lbldate= new JLabel("DATE");
        lbldate.setBounds(60,280,150,25);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbldate.setForeground(Color.BLUE);
        add(lbldate);
        
        lbldate= new JLabel();
        lbldate.setBounds(220,280,150,25);
        add(lbldate);
        
        
        
       
        
        
        cancel=new JButton("CANCEL");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(220,330,120,25);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        
        setSize(800,450);
        setLocation(350,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==fetchButton){
       
        String pnr= tfpnr.getText();
        
        try{
            Conn conn = new Conn();
            String query="select * from reservation where PNR='"+pnr+"'";
            ResultSet rs=conn.s.executeQuery(query);
            
            if(rs.next()){
                tfname.setText(rs.getString("name"));
                lblfcode.setText(rs.getString("flightcode")); 
                lbldate.setText(rs.getString("ddate"));
            }else{
            JOptionPane.showMessageDialog(null,"Please Enter Correct PNR");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }else if(ae.getSource()==cancel){
       
        String name= tfname.getText();
        String pnr= tfpnr.getText();
        String cancelno = cancellationno.getText();
        String fcode=lblfcode.getText();
        String date= lbldate.getText();
        
        try{
            Conn conn = new Conn();
            String query="Insert into cancel values('"+pnr+"','"+name+"','"+cancelno+"','"+fcode+"','"+date+"')";
            conn.s.executeUpdate(query);
            conn.s.executeUpdate("delete from reservation where PNR='"+pnr+"'");
            
           JOptionPane.showMessageDialog(null,"ticket cancelled");
           setVisible(false);
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    }
    public static void main(String srgs[]){
        new Cancel();
    }
}
