package omr.gui.overview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class OverviewPanel extends JPanel {
	// TODO: do a stuff....
	public OverviewPanel() {
		this.setLayout(new GridLayout(2,2));
		for (int i = 0; i < 4; i++) {
			Thumbnails thumb = new Thumbnails(null, "Image no. " + i);
			this.add(thumb);
		}
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