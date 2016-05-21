package LibraryGUI;

import Library.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DisplayPanel extends JPanel
{
   private JTextArea tf = new JTextArea();
   private JButton refresh = new JButton("Refresh");
   
   private Manager manager = LibraryGUI.manager;
   
   public DisplayPanel()
   {
      setLayout (new BorderLayout());

      setBackground (Color.green);

      JLabel b2 = new JLabel("Current Books On Loan");
      
      refresh.addActionListener(new ButtonListener());

      add (tf, BorderLayout.CENTER);
      add (b2, BorderLayout.NORTH);
      add (refresh, BorderLayout.SOUTH);
   }
   
   private class ButtonListener implements ActionListener
   {
       public void actionPerformed(ActionEvent event)
       {
           if(event.getSource() == refresh)
           {
               String message="";
               
               for(Student student: manager.getStudents())
               {
                    message += "---------------------------\n";
                    message += student.toString();
                    message += "---------------------------\n";
               }
                
               tf.setText(message);
           }
       }
   }
}
