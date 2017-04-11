package omr.gui.navigation;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.URL;
import java.util.AbstractList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.border.EtchedBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import apple.laf.JRSUIUtils.Tree;
import omr.Project;
import omr.Sheet;
import omr.gui.Gui;
import omr.gui.SheetEditor;
import omr.gui.UndoSupport;
import omr.gui.calibration.SheetTableModel;

/**
 * A panel where the properties of the sheet structure can be edited.
 * 
 * @author Tapio Auvinen
 */
public class NavigationTreePanel extends JPanel implements Observer {
    private static final long serialVersionUID = 1L;
    
    protected UndoSupport undoSupport;
    
    private Project project;
    private SheetEditor sheetEditor; 
    //private AttributeEdit currentEdit;                // Current undo object. Changes are accumulated until another component is selected. 

    private JTree projectTree;
    private ProjectTreeModel projectTreeModel;
    private String projectName;
    private Gui gui;
    
    public NavigationTreePanel(Gui gui) {
    	// Set up a Tree
    	File root;
    	root = new File("Bộ Bài Thi");
    	projectTreeModel = new ProjectTreeModel(root);
    	projectTree = new JTree(projectTreeModel);
        this.add(projectTree);
        this.gui = gui;
        projectTree.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                	File selectedProjectFile = (File)projectTree.getLastSelectedPathComponent();
                	// TODO: Make the node name shorter
                    gui.openSelectedProject(selectedProjectFile);

                }
            }
        });
    }
    
    public void setUndoSupport(UndoSupport undo) {
        this.undoSupport = undo;
    }
    
    /**
     * Sets the sheet structure to be edited.
     */
    public void setProject(Project project) {
        this.project = project;
        this.projectTreeModel.setProject(project);

    }
    
    
   
    
    public void fetchSheetList() {
    	// Update sheet list
    	projectTree.removeAll();
    	
    	for (Sheet sheet : project.getAnswerSheets()) {
    		JLabel sheetComponent = new JLabel(sheet.getFileName());
    		projectTree.add(sheetComponent);
    		
    	}
    }
    
    /**
     * Notified by the SheetsContainer when the sheet list is updated.
     */
    public void update(Observable source, Object arg1) {
    	fetchSheetList();
    }




//	@Override
//	public void valueChanged(TreeSelectionEvent e) {
//		// TODO Auto-generated method stub
//		DefaultMutableTreeNode node = (DefaultMutableTreeNode)projectTree.getLastSelectedPathComponent();
//		this.gui.openProject();
//		System.out.println("value changed happen");
//	}
	
	
	
    
}
