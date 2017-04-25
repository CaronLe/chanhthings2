package omr.gui.navigation;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.AbstractList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import omr.Project;
import omr.gui.RegistrationComponent;
import omr.gui.Gui;
import omr.gui.QuestionGroupComponent;
import omr.gui.SheetViewComponent;

/**
 * A panel for editing answer sheet structure. This is one of the top level tabs.
 * @author Tapio Auvinen
 */
public class NavigationPanel extends JPanel implements ChangeListener, Observer{
    private static final long serialVersionUID = 1L;
    
                                     
    private NavigationTreePanel navigationTreePanel;  
    private JPanel nameProjectPanel;
    private JLabel nameProjectLabel;
    private Project project;
    

    public NavigationPanel(Gui gui) {
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		// Name Project Panel
		nameProjectPanel = new JPanel();
		nameProjectLabel = new JLabel("Math 2011");
		Font fontNameProjectLabel = nameProjectLabel.getFont();
		nameProjectLabel.setFont(fontNameProjectLabel.deriveFont(fontNameProjectLabel.getStyle() ^ Font.BOLD));
		nameProjectLabel.setForeground(new Color(2, 132, 208));
		nameProjectPanel.add(nameProjectLabel);
		nameProjectPanel.setAlignmentX(FlowLayout.TRAILING);


		// Project Tree Panel
		navigationTreePanel = new NavigationTreePanel(gui);
//		navigationTreePanel.setPreferredSize(new Dimension(150, 600));
		
		// Scroll Panel
		JScrollPane navigationScrollPane = new JScrollPane(navigationTreePanel);
		navigationScrollPane.setPreferredSize(new Dimension(200, 500));
		// Add Panels to Main Navigation Frame
		this.setLayout(new BorderLayout());
		this.add(nameProjectPanel, BorderLayout.NORTH);
		this.add(navigationScrollPane, BorderLayout.CENTER);
		

	}
	
	 public void setProject(Project project) {
	        this.project = project;
	        this.navigationTreePanel.setProject(project);
	        if (project != null) {
	            project.getSheetsContainer().addObserver(this);
	            String nameProject =  project.Getname();
	            this.nameProjectLabel.setText(nameProject);
	           
	        }
	       
	    }

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
