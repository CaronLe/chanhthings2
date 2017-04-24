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

import omr.Project;
import omr.Sheet;
import sun.awt.image.ImageAccessException;

public class OverviewImagesGridPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Project project;
	
	public OverviewImagesGridPanel(List<String> imagePathArray)
	{
		
		this.setLayout(new GridLayout(0, 2));
		
		if (imagePathArray != null)
		{
//			imagePathArray = new ArrayList<String>();
	//		imagePathArray.add("/Users/swift/Documents/Senior Project/auto-grading-root/testdata/0002.jpg");
	//		imagePathArray.add("/Users/swift/Documents/Senior Project/auto-grading-root/testdata/0010.jpg");
	//		imagePathArray.add("/Users/swift/Documents/Senior Project/auto-grading-root/testdata/0002.jpg");
	//		imagePathArray.add("/Users/swift/Documents/Senior Project/auto-grading-root/testdata/0010.jpg");
			for (String imagePath : imagePathArray) 
			{
					BufferedImage img = null;
					try 
					{
					    img = ImageIO.read(new File(imagePath));
					    Image resizedImg = img.getScaledInstance(650, 800, Image.SCALE_DEFAULT);
					    Thumbnails thumb = new Thumbnails(resizedImg);
					    
						// Create a JScroll Pane containing thumbnails
						JScrollPane jScrollPane = new JScrollPane(thumb);
						jScrollPane.getHorizontalScrollBar().setValue(jScrollPane.getHorizontalScrollBar().getMaximum()/2);
	
						// Create a general Panel containing JScrollPane and JLabel as a name tag of the test image
						JPanel imagePanel = new JPanel();
						imagePanel.setLayout(new BorderLayout());
						imagePanel.add(jScrollPane, BorderLayout.CENTER);
						imagePanel.add(new Label("Picture No. 1"), BorderLayout.SOUTH);
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
