package LibraryGUI;

import Library.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FindPanel extends JPanel
{
   private JLabel label = new JLabel("Student Name: ");
   private JTextField tf = new JTextField();
      
   private JButton search = new JButton("Search");
   private JButton cancel = new JButton("Cancel");
      
   private JLabel sName = new JLabel("Student Name: ");
   private JLabel sClass = new JLabel("Student Class: ");
   private JLabel bISBN = new JLabel("Book ISBN: ");
   private JLabel bName = new JLabel("Book Name: ");
   private JLabel bAuth = new JLabel("Book Author: ");
   private JLabel bPubl = new JLabel("Book Publisher: ");
   
   private Manager manager = LibraryGUI.manager;
      
   public FindPanel()
   {
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

      setBackground(Color.green);
      
      JPanel grid = new JPanel();
      
      grid.setBackground(Color.green);
      grid.setLayout(new GridLayout(2,2));
      
      search.addActionListener(new ButtonListener());
      cancel.addActionListener(new ButtonListener());
      
      grid.add(label);
      grid.add(tf);
      grid.add(search);
      grid.add(cancel);
      
      add(grid);  
      add(Box.createRigidArea (new Dimension (100, 100)));
      add(sName);
      add(sClass);
      add(bISBN);
      add(bName);
      add(bAuth);
      add(bPubl);
      add(Box.createRigidArea (new Dimension (30, 30)));
   }
   
   private class ButtonListener implements ActionListener
   {
       public void actionPerformed(ActionEvent event)
       {
           if(event.getSource() == search)
           {
               Student found = manager.findStudent(tf.getText());
               
               sName.setText("Student Name: "+found.getName());
               sClass.setText("Student Class: "+found.getClass());
               bISBN.setText("Book ISBN: "+found.getBook().getISBN());
               bName.setText("Book Name: "+found.getBook().getName());
               bAuth.setText("Book Author: "+found.getBook().getAuthor());
               bPubl.setText("Book Publisher: "+found.getBook().getPublisher());
           }
           
           else if(event.getSource() == cancel)
           {
               tf.setText("");
           }
       }
   }
}
