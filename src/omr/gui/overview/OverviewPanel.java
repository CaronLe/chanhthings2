package omr.gui.overview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import org.omg.CORBA.PUBLIC_MEMBER;

import omr.Project;
import omr.Sheet;

public class OverviewPanel extends JPanel implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Properties
	private java.util.List<String> imagePathArray;
	private java.util.List<String> imageNameArray;
	private OverviewImagesGridPanel overviewImagesGridPanel;
	private Project project;
	public OverviewPanel() {
		this.setLayout(new BorderLayout());
		imagePathArray = new ArrayList<String>();
		imageNameArray = new ArrayList<String>();
		overviewImagesGridPanel = new OverviewImagesGridPanel(imagePathArray, imageNameArray);
		this.add(overviewImagesGridPanel);
	}
	
	public void setProject(Project project)
	{
		if (project != null)
		{
		  project.getSheetsContainer().addObserver(this);
		  this.project = project;
          AbstractList<Sheet> sheets = project.getSheetsContainer().getSheets();
          imagePathArray.clear();
          imageNameArray.clear();
          for (Sheet sheet : sheets)
          {
	       	  imagePathArray.add(sheet.getFilePath());
	       	  imageNameArray.add(sheet.getFileName());
	       	  System.out.println(sheet.getFilePath());
          } 
          System.out.println("test");
          OverviewImagesGridPanel newOverviewImagesGridPanel = new OverviewImagesGridPanel(imagePathArray, imageNameArray);
          this.add(newOverviewImagesGridPanel);
           
		}
	}
		

	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}


	
