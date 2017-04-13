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
	private OverviewImagesGridPanel overviewImagesGridPanel;
	private Project project;
	public OverviewPanel() {
		this.setLayout(new BorderLayout());
		imagePathArray = new ArrayList<String>();
		overviewImagesGridPanel = new OverviewImagesGridPanel(imagePathArray);
		this.add(overviewImagesGridPanel);
	}
	
	public void setProject(Project project)
	{
		if (project != null)
		{
		  project.getSheetsContainer().addObserver(this);
          AbstractList<Sheet> sheets = project.getSheetsContainer().getSheets();
          for (Sheet sheet : sheets)
          {
	       	  imagePathArray.add(sheet.getFilePath());
	       	  System.out.println(sheet.getFilePath());
          } 
          overviewImagesGridPanel = new OverviewImagesGridPanel(imagePathArray);
          this.add(overviewImagesGridPanel);
		}
	}
		

	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}


	
