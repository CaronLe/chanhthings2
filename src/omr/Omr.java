package omr;
import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import omr.gui.Gui;

import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.nilo.plaf.nimrod.NimRODTheme;
import com.seaglasslookandfeel.*;
/**
 * Main class of the application. Starts the Gui.
 * 
 * @author Tapio Auvinen
 */
public class Omr {

    public static void main(String[] args) {
    	 try {
    	        UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
        new Omr();
    }

    /**
     * Constructor
     */
    public Omr() {
        //Schedule a job for the event-dispatching thread
    	
        try {
            javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
	private void createAndShowGUI() {
        // Set look and feel
		NimRODTheme nt = new NimRODTheme("whitelight.theme");
		

		NimRODLookAndFeel NimRODLF = new NimRODLookAndFeel();
		NimRODLF.setCurrentTheme( nt);
    	
    	
    	 try {
    		 UIManager.setLookAndFeel(NimRODLF);
 	    } catch (Exception e) {
 	        e.printStackTrace();
 	    }
    	
    	
//    	try
//    	{
//    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//    	} catch (Exception e)
//    	{
//    		e.printStackTrace();
//    	}
//        try {
//            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (Exception e) {
//        }
        
        // Create gui
        new Gui();
    }
}
