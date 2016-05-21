package LibraryGUI;

import Library.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RemovePanel extends JPanel
{
   private JLabel label = new JLabel("Student Name: ");
   private JTextField tf = new JTextField();
      
   private JButton remove = new JButton("Remove Student");
   private JButton cancel = new JButton("Cancel");
      
   private JLabel status = new JLabel("Status: ");
   
   private Manager manager = LibraryGUI.manager;
   
   public RemovePanel()
   {
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

      setBackground(Color.green);
      
      JPanel grid = new JPanel();
      
      grid.setBackground(Color.green);
      grid.setLayout(new GridLayout(2,2));
      
      remove.addActionListener(new ButtonListener());
      cancel.addActionListener(new ButtonListener());
      
      grid.add(label);
      grid.add(tf);
      grid.add(remove);
      grid.add(cancel);
      
      add(grid);  
      add(Box.createRigidArea (new Dimension (0, 10)));
      add(status);
      add(Box.createRigidArea (new Dimension (200, 200)));
   }
   
   private class ButtonListener implements ActionListener
   {
       public void actionPerformed(ActionEvent event)
       {
           if(event.getSource() == remove)
           {
               manager.removeStudent(tf.getText());
               tf.setText("");
               status.setText("Status: Student Removed");
           }
           
           else if(event.getSource() == cancel)
           {
               tf.setText("");
               status.setText("");
           }
       }
   }
}
