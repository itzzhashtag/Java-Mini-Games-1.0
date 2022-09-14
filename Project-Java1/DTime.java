 

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
public class DTime extends JFrame
{

    Calendar calendar;
    SimpleDateFormat timeFormat;
    JLabel timelabel;
    String time,date;
    
    SimpleDateFormat dateFormat;
    JLabel datelabel;
    
    
    DTime(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setTitle("MY CLOCK");
        this.setLayout(new FlowLayout());
        this.setSize(700,500);
        this.setResizable(false);
        
        timeFormat= new SimpleDateFormat("hh:mm:ss a");
        timelabel=new JLabel();
        timelabel.setFont(new Font("",Font.BOLD,60));
        timelabel.setBackground(Color.BLACK);
        timelabel.setOpaque(true);                            //time
        timelabel.setForeground(Color.GRAY);
        
        dateFormat=new SimpleDateFormat("dd MMMM, yyyy");
        datelabel=new JLabel();                                //date 
        datelabel.setForeground(Color.GRAY);
        datelabel.setFont(new Font("",Font.BOLD,70));
        datelabel.setBackground(Color.black);
        datelabel.setOpaque(true);
    

        this.add(timelabel);
        this.add(datelabel);
        this.setVisible(true);
        
        setTimeandDate();
    
    }
    public void setTimeandDate() 
    {
        while(true) {
            time=timeFormat.format(Calendar.getInstance().getTime());
            date=dateFormat.format(Calendar.getInstance().getTime());
            timelabel.setText(time);
            datelabel.setText(date);
            
        }
        
    }
}