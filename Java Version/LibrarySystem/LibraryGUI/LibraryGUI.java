package LibraryGUI;

import Library.*;
import javax.swing.*;

public class LibraryGUI
{
   static Manager manager = new Manager();
    
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Library Manager");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
     
      manager.start();

      JTabbedPane tp = new JTabbedPane();
      tp.addTab ("Add", new AddPanel());
      tp.addTab ("Find", new FindPanel());
      tp.addTab ("Remove", new RemovePanel());
      tp.addTab ("Display", new DisplayPanel());

      frame.getContentPane().add(tp);
      frame.pack();
      frame.setVisible(true);
   }
}
