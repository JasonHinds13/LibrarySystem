package LibraryGUI;

import Library.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddPanel extends JPanel
{
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
      
   private JButton addBtn = new JButton("Add Student");
   private JButton cancel = new JButton("Cancel");
   private JLabel status = new JLabel("Status: ");
   
   private Manager manager = LibraryGUI.manager;   
   
   public AddPanel()
   {
      setLayout(new GridLayout(9, 2));

      setBackground(Color.green);
      
      setPreferredSize(new Dimension(600,300));
      
      addBtn.addActionListener(new ButtonListener());
      cancel.addActionListener(new ButtonListener());

      add (b1);
      add (t1);
      add (b2);
      add (t2);
      add (b3);
      add (t3);
      add (b4);
      add (t4);
      add (b5);
      add (t5);
      add (b6);
      add (t6);
      add(addBtn);
      add(cancel);
      add(status);
   }
   
   private class ButtonListener implements ActionListener
   {
       public void actionPerformed(ActionEvent event)
       {
           if(event.getSource() == addBtn)
           {
               Book bk = new Book(t3.getText(),t4.getText(),t5.getText(),t6.getText());
               manager.addStudent(new Student(t1.getText(),t2.getText(),bk));
               
               t1.setText("");
               t2.setText("");
               t3.setText("");
               t4.setText("");
               t5.setText("");
               t6.setText("");
               status.setText("Status: Student Added");
           }
           
           else if(event.getSource() == cancel)
           {
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
