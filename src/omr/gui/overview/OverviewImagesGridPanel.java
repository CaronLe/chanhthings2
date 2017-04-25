package omr.gui.overview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import omr.Project;
import omr.Sheet;
import sun.awt.image.ImageAccessException;

public class OverviewImagesGridPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Project project;
	
	public OverviewImagesGridPanel(List<String> imagePathArray, List<String> imageNameArray)
	{
		
		this.setLayout(new GridLayout(0, 2));
		

		if (imagePathArray != null)
		{
			
			for (int index = 1; index < imagePathArray.size(); index = index + 1) 
			{
				
					BufferedImage img = null;
					try 
					{
					    img = ImageIO.read(new File(imagePathArray.get(index)));
					    Image resizedImg = img.getScaledInstance(650, 820, Image.SCALE_DEFAULT);
					    Thumbnails thumb = new Thumbnails(resizedImg);
						// Create a general Panel containing JPanel and JLabel as a name tag of the test image
						JPanel imagePanel = new JPanel();
						imagePanel.setLayout(new BorderLayout());
						imagePanel.add(thumb, BorderLayout.CENTER);
						imagePanel.add(new Label(imageNameArray.get(index)), BorderLayout.SOUTH);
						this.add(imagePanel);
					} 
					catch (IOException e) 
					{
					    e.printStackTrace();
					}
			
					
			}
			
		
			
		}
	}
	
	

}

class Thumbnails extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;
	
	public Thumbnails(Image image) {
		// do assigning data here
		this.image = image;
		this.setLayout(new BorderLayout());
		JLabel picLabel = new JLabel(new ImageIcon(image));
		this.add(picLabel, BorderLayout.CENTER);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
