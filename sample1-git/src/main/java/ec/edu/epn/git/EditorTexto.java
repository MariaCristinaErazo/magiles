package ec.edu.epn.git;
import java.awt.*; 

import javax.swing.*; 
import java.io.*; 
import java.awt.event.*; 
import javax.swing.plaf.metal.*; 
import javax.swing.text.*; 
class editor extends JFrame implements ActionListener { 
    // Text component 
    JTextArea t; 
  
    // Frame 
    JFrame f; 
    
    
    public void Vacio(){
        if(t.getText().isEmpty()==true)
        	System.out.print("No hay texto");
        else
        	System.out.print("Si hay texto");
        }
  
    // Constructor 
    editor() 
    { 
        // Create a frame 
        f = new JFrame("editor"); 
  
        try { 
            // Set metl look and feel 
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); 
  
            // Set theme to ocean 
            MetalLookAndFeel.setCurrentTheme(new OceanTheme()); 
        } 
        catch (Exception e) { 
        } 
  
        // Text component 
        t = new JTextArea();
        
          
        // Create a menubar 
        JMenuBar mb = new JMenuBar(); 
  
        // Create amenu for menu 
        JMenu m1 = new JMenu("File"); 
  
        // Create menu items 
        JMenuItem mi1 = new JMenuItem("Nuevo"); 
        JMenuItem mi2 = new JMenuItem("Abrir"); 
        JMenuItem mi3 = new JMenuItem("Guardar"); 
        JMenuItem mi9 = new JMenuItem("Imprimir"); 
  
        // Add action listener 
        mi1.addActionListener(this); 
        mi2.addActionListener(this); 
        mi3.addActionListener(this); 
        mi9.addActionListener(this); 
  
        m1.add(mi1); 
        m1.add(mi2); 
        m1.add(mi3); 
        m1.add(mi9); 
  
        // Create amenu for menu 
        JMenu m2 = new JMenu("Edit"); 
  
        // Create menu items 
        JMenuItem mi4 = new JMenuItem("Cortar"); 
        JMenuItem mi5 = new JMenuItem("Copiar"); 
        JMenuItem mi6 = new JMenuItem("Pegar"); 
  
        // Add action listener 
        mi4.addActionListener(this); 
        mi5.addActionListener(this); 
        mi6.addActionListener(this); 
  
        m2.add(mi4); 
        m2.add(mi5); 
        m2.add(mi6); 
  
        JMenuItem mc = new JMenuItem("close"); 
  
        mc.addActionListener(this); 
  
        mb.add(m1); 
        mb.add(m2); 
        mb.add(mc); 
  
        f.setJMenuBar(mb); 
        f.add(t); 
        f.setSize(500, 500); 
        f.show(); 
    } 
    
    
    public int Guardar(String textArea) {
    	 JFileChooser j = new JFileChooser("f:"); 
    	// textArea=t.getText();
    	
    	  
        // Invoke the showsSaveDialog function to show the save dialog 
        int r = j.showSaveDialog(null); 

        if (r == JFileChooser.APPROVE_OPTION) { 

            // Set the label to the path of the selected directory 
            File fi = new File(j.getSelectedFile().getAbsolutePath()); 

            try { 
                // Create a file writer 
                FileWriter wr = new FileWriter(fi, false); 

                // Create buffered writer to write 
                BufferedWriter w = new BufferedWriter(wr); 

                // Write 
                w.write(textArea); 

                w.flush(); 
                w.close();
                return 1;
            } 
            catch (Exception evt) { 
                JOptionPane.showMessageDialog(f, evt.getMessage()); 
                return 0;
            } 
        } 
        // If the user cancelled the operation 
        else {
            JOptionPane.showMessageDialog(f, "El usuario canceló la operación");
            return 0;
        }
    }
  
    public void Imprimir() {
    	try { 
            // print the file 
            t.print(); 
        } 
        catch (Exception evt) { 
            JOptionPane.showMessageDialog(f, evt.getMessage()); 
        } 
    	
    }
    
    public int Abrir() {
    	// Create an object of JFileChooser class 
        JFileChooser j = new JFileChooser("f:"); 

        // Invoke the showsOpenDialog function to show the save dialog 
        int r = j.showOpenDialog(null); 

        // If the user selects a file 
        if (r == JFileChooser.APPROVE_OPTION) { 
            // Set the label to the path of the selected directory 
            File fi = new File(j.getSelectedFile().getAbsolutePath()); 

            try { 
                // String 
                String s1 = "", sl = "";
                if(fi.getName().endsWith("txt")) {

                // File reader 
                FileReader fr = new FileReader(fi); 

                // Buffered reader 
                BufferedReader br = new BufferedReader(fr); 

                // Initilize sl 
                sl = br.readLine(); 

                // Take the input from the file 
                while ((s1 = br.readLine()) != null) { 
                    sl = sl + "\n" + s1; 
                } 

                // Set the text 
                t.setText(sl);
                return 1;
                }
                else
                  return 0;
            } 
            catch (Exception evt) { 
                JOptionPane.showMessageDialog(f, evt.getMessage());
                return 0;
            }
            
        } 
        // If the user cancelled the operation 
        else {
            JOptionPane.showMessageDialog(f, "El usuario cancelo la operacion"); 
            return 0;
        }
    }
    public int Nuevo() {
    	 t.setText("");
    	 if(t.getText().isEmpty()==true)
         	return 1;
         else
            return 0;
    		 
    }
    // If a button is pressed 
    public void actionPerformed(ActionEvent e) 
    { 
        String s = e.getActionCommand(); 
  
        if (s.equals("Cortar")) { 
            t.cut(); 
        } 
        else if (s.equals("Copiar")) { 
            t.copy(); 
        } 
        else if (s.equals("Pegar")) { 
            t.paste(); 
        } 
        else if (s.equals("Guardar")) { 
            Guardar(t.getText());
        } 
        else if (s.equals("Imprimir")) { 
            Imprimir();
        } 
        else if (s.equals("Abrir")) { 
        	Abrir();
        
        } 
        else if (s.equals("Nuevo")) { 
           Nuevo();
            
        } 
        else if (s.equals("close")) { 
            f.setVisible(false); 
        } 
    }
   
   
    
} 