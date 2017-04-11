package omr.gui.navigation;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import omr.Project;
import omr.Sheet;

public class ProjectTreeModel implements TreeModel, Observer{
	 protected File root;
	 private Project project;
	  public ProjectTreeModel(Project root) 
	  { 
		  this.project = root;
//		  this.root = root; 
	  }

	  // The model knows how to return the root object of the tree
	  public Object getRoot() { return project; }

	  // Tell JTree whether an object in the tree is a leaf
	  public boolean isLeaf(Object node) 
	  {  
		  return false;
		  
		
	  }

	  // Tell JTree how many children a node has
	  public int getChildCount(Object parent) {
		  Project p = (Project)parent;
//	    String[] children = ((File)parent).list();
//	    if (children == null) return 0;
//	    return children.length;
		  return p.getAnswerSheets().size();
	  }

	  // Fetch any numbered child of a node for the JTree.
	  // Our model returns File objects for all nodes in the tree.  The
	  // JTree displays these by calling the File.toString() method.
	  public Object getChild(Object parent, int index) {
//	    String[] children = ((File)parent).list();
//	    if ((children == null) || (index >= children.length)) return null;
////	    return new File((File) parent, children[index]);
//	    return new File(children[index]);
		  Project p = (Project)parent;
		  return p.getAnswerSheets().get(index);
	  }

	  // Figure out a child's position in its parent node.
	  public int getIndexOfChild(Object parent, Object child) {
//	    String[] children = ((File)parent).list();
//	    if (children == null) return -1;
//	    String childname = ((File)child).getName();
//	    for(int i = 0; i < children.length; i++) {
//	      if (childname.equals(children[i])) return i;
//	    }
//	    return -1;
		Project p = (Project)parent;
		Sheet c = (Sheet)child;
		return p.getAnswerSheets().indexOf(c);
	  }

	  // This method is invoked by the JTree only for editable trees.  
	  // This TreeModel does not allow editing, so we do not implement 
	  // this method.  The JTree editable property is false by default.
	  public void valueForPathChanged(TreePath path, Object newvalue) {}

	  // Since this is not an editable tree model, we never fire any events,
	  // so we don't actually have to keep track of interested listeners
	  public void addTreeModelListener(TreeModelListener l) 
	  {
		  
	  }
	  public void removeTreeModelListener(TreeModelListener l) {}
	  
	  public void setProject(Project project) {
	        // Unsubscribe from previous model
	        if (this.project != null) {
	            this.project.getSheetsContainer().deleteObserver(this);
	        }
	        
	        this.project = project;
	        
	        // Subscribe to new model
	        if (project != null) {
	            project.getSheetsContainer().addObserver(this);
	        }
	        
	     
	    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	  
	  
}
