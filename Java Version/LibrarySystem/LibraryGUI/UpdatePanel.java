package LibraryGUI;

import Library.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class UpdatePanel extends JPanel
{
   private JLabel label = new JLabel("Student Name: ");
   private JTextField tf = new JTextField();
      
   private JButton find = new JButton("Find Student");
   private JButton cancel = new JButton("Cancel");
   
   private JLabel b1 = new JLabel("Student Name: ");
   private JTextField t1 = new JTextField();
      
   private JLabel b2 = new JLabel("Student Class: ");
   private JTextField t2 = new JTextField();
      
   private JLabel b3 = new JLabel("Book ISBN: ");
   private JTextField t3 = new JTextField();
      
   private JLabel b4 = new JLabel("Book Name: ");
   private JTextField t4 = new JTextField();
      
   private JLabel b5 = new JLabel("Book Author: ");
   private JTextField t5 = new JTextField();
      
   private JLabel b6 = new JLabel("Book Publisher: ");
   private JTextField t6 = new JTextField();
      
   private JButton update = new JButton("Update Student");
   private JButton cancel2 = new JButton("Cancel");
      
   private JLabel status = new JLabel("Status: ");
   
   private Manager manager = LibraryGUI.manager;
   
   public UpdatePanel()
   {
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

      setBackground(Color.green);
      
      JPanel grid = new JPanel();
      
      grid.setBackground(Color.green);
      grid.setLayout(new GridLayout(2,2));
      
      find.addActionListener(new ButtonListener());
      cancel.addActionListener(new ButtonListener());
      
      update.addActionListener(new ButtonListener());
      cancel2.addActionListener(new ButtonListener());
      
      grid.add(label);
      grid.add(tf);
      grid.add(find);
      grid.add(cancel);
      
      add(grid);  
      add(Box.createRigidArea (new Dimension (0, 10)));
      
      JPanel grid2 = new JPanel();
      grid2.setLayout(new GridLayout(9,2));
      grid2.setBackground(Color.green);

      grid2.add(b1);
      grid2.add(t1);
      grid2.add(b2);
      grid2.add(t2);
      grid2.add(b3);
      grid2.add(t3);
      grid2.add(b4);
      grid2.add(t4);
      grid2.add(b5);
      grid2.add(t5);
      grid2.add(b6);
      grid2.add(t6);
      grid2.add(update);
      grid2.add(cancel2);
      grid2.add(status);
      
      add(grid2);
   }
   
   private class ButtonListener implements ActionListener
   {
       public void actionPerformed(ActionEvent event)
       {
           if(event.getSource() == find)
           {
               Student found = manager.findStudent(tf.getText());
               
               t1.setText(found.getName());
               t2.setText(found.getSClass());
               t3.setText(found.getBook().getISBN());
               t4.setText(found.getBook().getName());
               t5.setText(found.getBook().getAuthor());
               t6.setText(found.getBook().getPublisher());
           }
           
           else if(event.getSource() == update)
           {
               Book bk = new Book(t3.getText(),t4.getText(),t5.getText(),t6.getText());
               manager.updateStudent(new Student(t1.getText(),t2.getText(),bk));
               
               tf.setText("");
               t1.setText("");
               t2.setText("");
               t3.setText("");
               t4.setText("");
               t5.setText("");
               t6.setText("");
               
               status.setText("Status: Student Updated");
           }
           
           else if(event.getSource() == cancel)
           {
               tf.setText("");
               status.setText("Status: ");
           }
           
           else if(event.getSource() == cancel2)
           {
               tf.setText("");
               t1.setText("");
               t2.setText("");
               t3.setText("");
               t4.setText("");
               t5.setText("");
               t6.setText("");
               status.setText("Status: ");
           }
       }
   }
}
