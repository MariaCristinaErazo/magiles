package ec.edu.epn.git;
import java.awt.*; 

import javax.swing.*; 
import java.io.*; 
import java.awt.event.*; 
import javax.swing.plaf.metal.*; 
import javax.swing.text.*; 
class editor extends JFrame implements ActionListener { 
    // Área de edición de texto
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
        // Crea un nuevo formulario
        f = new JFrame("Editor de Texto"); 
  
        try { 
            // Seteado del UI
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); 
  
            // Seteado del theme del UI
            MetalLookAndFeel.setCurrentTheme(new OceanTheme()); 
        } 
        catch (Exception e) { 
        } 
  
        // Area de edicion del texto
        t = new JTextArea();
        
          
        // MenuBar
        JMenuBar mb = new JMenuBar(); 
  
        // Submenus
        JMenu m1 = new JMenu("Archivo"); 
  
        // Items
        JMenuItem mi1 = new JMenuItem("Nuevo"); 
        JMenuItem mi2 = new JMenuItem("Abrir"); 
        JMenuItem mi3 = new JMenuItem("Guardar"); 
        JMenuItem mi9 = new JMenuItem("Imprimir"); 
  
        // Eventos 
        mi1.addActionListener(this); 
        mi2.addActionListener(this); 
        mi3.addActionListener(this); 
        mi9.addActionListener(this); 
  
        m1.add(mi1); 
        m1.add(mi2); 
        m1.add(mi3); 
        m1.add(mi9); 
  
        // Crear submenu
        JMenu m2 = new JMenu("Editar"); 
  
        // Crear menu items 
        JMenuItem mi4 = new JMenuItem("Cortar"); 
        JMenuItem mi5 = new JMenuItem("Copiar"); 
        JMenuItem mi6 = new JMenuItem("Pegar"); 
  
        // Eventos
        mi4.addActionListener(this); 
        mi5.addActionListener(this); 
        mi6.addActionListener(this); 
  
        m2.add(mi4); 
        m2.add(mi5); 
        m2.add(mi6); 
  
        JMenuItem mc = new JMenuItem("Cerrar"); 
  
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
    	  
        // Ventana de dialogo para la accion guardar
        int r = j.showSaveDialog(null); 

        if (r == JFileChooser.APPROVE_OPTION) { 

            // Obtiene y setea la ruta de guardado del archivo
            File fi = new File(j.getSelectedFile().getAbsolutePath()); 

            try { 
                // Crear el archivo a ser escrito
                FileWriter wr = new FileWriter(fi, false); 

                // Crea un buffer para escribir el archivo
                BufferedWriter w = new BufferedWriter(wr); 

                // Escritura del archivo
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
        // Si el usuario cancela la operacion de guardar
        else {
            JOptionPane.showMessageDialog(f, "El usuario canceló la operación");
            return 0;
        }
    }
  
    public int Guardar(String ruta, String texto) {
    	
    	try {
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    
    	return 1;
    }
    
    public void Imprimir() {
    	try { 
            // Imprime el archivo
            t.print(); 
        } 
        catch (Exception evt) { 
            JOptionPane.showMessageDialog(f, evt.getMessage()); 
        } 
    	
    }
    
    public int Abrir() {
    	// Crea un objeto de la clase JFileChooser 
        JFileChooser j = new JFileChooser("f:"); 

        // Ventana de dialogo para la operacion de Abrir
        int r = j.showOpenDialog(null); 

        // Si el usuario selecciona un archivo
        if (r == JFileChooser.APPROVE_OPTION) { 
            // Obtiene y setea la ruta del archivo que se va a Abrir
            File fi = new File(j.getSelectedFile().getAbsolutePath()); 

            try { 
                // Cadena para guardar lo leido desde el archivo 
                String s1 = "", sl = "";
                if(fi.getName().endsWith("txt")) {

                // Archivo de lectura 
                FileReader fr = new FileReader(fi); 

                // Buffer de lectura
                BufferedReader br = new BufferedReader(fr); 

                // Inicializa la lectura 
                sl = br.readLine(); 

                // Guarda el contenido del texto en el string s1
                while ((s1 = br.readLine()) != null) { 
                    sl = sl + "\n" + s1; 
                } 

                // Setea el area de edicion con el valor del estring s1
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
        // Si el usuario cancela la operacion de Abrir
        else {
            JOptionPane.showMessageDialog(f, "El usuario cancelo la operacion"); 
            return 0;
        }
    }
    public int Abrir(String ruta) {
    	String s1 = "", sl = "";
    	try {
	    	FileReader fr = new FileReader(ruta); 		
		    // Buffer de lectura
		    BufferedReader br = new BufferedReader(fr); 		
		    // Inicializa la lectura 
		    sl = br.readLine(); 		
		    // Guarda el contenido del texto en el string s1
		    while ((s1 = br.readLine()) != null) { 
		        sl = sl + "\n" + s1; 
		    }	
		    // Setea el area de edicion con el valor del estring s1
		    t.setText(sl);
		    return 1;
		    }

		catch (Exception e) { 
			e.printStackTrace();
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
    // Si un item del menu es seleccionado
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