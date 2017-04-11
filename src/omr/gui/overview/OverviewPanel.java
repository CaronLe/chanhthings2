package omr.gui.overview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.omg.CORBA.PUBLIC_MEMBER;

import omr.Project;
import omr.Sheet;

public class OverviewPanel extends JPanel implements Observer {
	//Properties
	private java.util.List<String> imagePathArray;
	public OverviewPanel() {
		this.setLayout(new GridLayout(2,2));
		
		
//			
//			for (Sheet sheet : this.sheets) 
//			{
//					BufferedImage img = null;
//					try 
//					{
//					    img = ImageIO.read(new File(sheet.getFilePath())); // eventually C:\\ImageTest\\pic2.jpg
//					} 
//					catch (IOException e) 
//					{
//					    e.printStackTrace();
//					}
//					JLabel picLabel = new JLabel(new ImageIcon(img));
//					this.add(picLabel);
//			}
	
	}
	
	public void setProject(Project project)
	{
		if (project != null) {
            project.getSheetsContainer().addObserver(this);
//          addImagePathArrayToClass();
		}
	}
		
	public void addImagePathArrayToClass()
	{
		  AbstractList<Sheet> sheets = project.getSheetsContainer().getSheets();
          
          for (Sheet sheet : sheets)
          {
       	  imagePathArray.add(sheet.getFilePath());
       	  System.out.println(sheet.getFilePath());
       	  
          }  
       }
	

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}

class Thumbnails extends JPanel {
	private Image image;
	private JLabel label;
	
	public Thumbnails(Image image, String labelString) {
		// do assigning data here
		this.image = image;
		this.label = new JLabel(labelString);
		this.setLayout(new BorderLayout());
		//this.add(image, BorderLayout.CENTER); ??
		this.add(label, BorderLayout.SOUTH);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
}