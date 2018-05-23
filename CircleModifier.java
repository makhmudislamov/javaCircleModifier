
// Author: Makhmud Islamov
// Date: Dec 18 2017
// Course: CS111B
// Extra Credit Assignment 
// Objective: Circle Modifier app - moves up, down, left and right. Also, inflates and deflates.
// Limit is the screen

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Toolkit;

public class CircleModifier extends Frame implements ActionListener
{
    Button b1, b2, b3, b4, b5, b6;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Double w = screenSize.getWidth();
    Double h = screenSize.getHeight();
    int x = w.intValue()/5;
    int y = h.intValue()/3;
    int rad = 300;
// ************************main()*********************************************
   public static void main(String...args) 
   {
       CircleModifier cf = new CircleModifier();
       closeFrame(cf);
   }
  // ************************CircleModifier()*********************************************
    public CircleModifier()
    {
        b1 = new Button("Left");// creating button = action event
        b2 = new Button("Up");
        b3 = new Button("Down");
        b4 = new Button("Right");// creating button = action event
        b5 = new Button("Inflate");
        b6 = new Button("Deflate");
        add(b1); 
        add(b2); 
        add(b3); 
        add(b4); 
        add(b5); 
        add(b6);// add to glass layer otherwise nothing will show up 
        b1.addActionListener(this);// catching the action event
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        setSize(w.intValue(), h.intValue());
        setLayout(new FlowLayout());
        setVisible(true);
    }
    // ************************closeFrame()*********************************************
     public static void closeFrame(Frame f)
    {
      f.addWindowListener(new WindowAdapter()
      {
        public void windowClosing(WindowEvent we)
        {
          System.exit(0);
        }
      });
    }
    // ************************actionPerformed()*********************************************
    public void actionPerformed(ActionEvent ae)//this method is called when you click a button.
    
    { 
        // Left button configuration
        int lfmax = x;
        if(ae.getSource()==b1) x -= 15;// Left
        if ( x >= 0)
        {
            repaint();
        }
        else
        {
            x = lfmax;
        }
        // Up button configuration
        int tY = y;
        int maxY = b6.getLocation().y + b6.getHeight();
        if(ae.getSource()==b2) y -= 15; // Up
        if ( y >= maxY)
        {
            repaint();
        }
        else
        {
            y = tY;
        }
        // Down button configuration
        int maxBottomY = y;
        if(ae.getSource()==b3) y += 15;// Down
        maxY = b6.getLocation().y + b6.getHeight() + 14; //14 = padding
        if ( y <= (h.intValue() - rad - maxY))
        {
            repaint();
        }
        else
        {
            y = maxBottomY;
        }
        // Right button configuration
         int maxRightX = x;
        if(ae.getSource()==b4) x += 15;// Right
        if ( x <= (w.intValue() - rad))
        {
            repaint();
        }
        else
        {
            x = maxRightX;
        }
        // Inflate and Deflate button configuration
         if(ae.getSource()==b5) rad +=10;//Inflate
        if(ae.getSource()==b6) rad -= 10;//Deflate
        repaint();
    }
    // ************************paint()*********************************************
    public void paint(Graphics g)
    {  
        g.setColor(Color.BLUE);
        g.fillOval(x, y, rad, rad);
    }

}
