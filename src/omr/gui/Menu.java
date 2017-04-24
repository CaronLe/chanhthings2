package omr.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Menu bar of the main window.
 */
public class Menu extends JMenuBar implements ActionListener {
    private static final long serialVersionUID = 1L;
    private Gui gui;
    
    private JMenuItem newProject;
    private JMenuItem openProject;
    private JMenuItem saveProject;
    private JMenuItem saveProjectAs;
    private JMenuItem importSheets;
    private JMenuItem exportAnswers;
    private JMenuItem exportResults;
    private JMenuItem mailFeedback;
    
    public Menu(Gui gui) {
        this.gui = gui;
        UndoSupport undoSupport = gui.getUndoSupport();
        
        // File menu
        JMenu fileMenu = new JMenu("Bộ Bài Thi");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        //menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
        add(fileMenu);

        // New project
        newProject = new JMenuItem("Tạo Bộ Bài Thi", KeyEvent.VK_N);
        newProject.addActionListener(this);
        fileMenu.add(newProject);
        
        // Open project
        openProject = new JMenuItem("Má»Ÿ Bá»™ BĂ i Thi", KeyEvent.VK_O);
        openProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        openProject.addActionListener(this);
        fileMenu.add(openProject);

        // Save project
        saveProject = new JMenuItem("LÆ°u Bá»™ BĂ i Thi", KeyEvent.VK_A);
        saveProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveProject.addActionListener(this);
        fileMenu.add(saveProject);

        // Save project as
        saveProjectAs = new JMenuItem("LÆ°u Bá»™ BĂ i Thi Táº¡i .....", KeyEvent.VK_S);
        //saveProjectAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveProjectAs.addActionListener(this);
        fileMenu.add(saveProjectAs);

        
        // Sheets management
        JMenu sheetsMenu = new JMenu("Bài Thi");
        sheetsMenu.setMnemonic(KeyEvent.VK_F);
        //menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
        add(sheetsMenu);
        
        importSheets = new JMenuItem("Nhập Bài Thi", KeyEvent.VK_I);
        importSheets.getAccessibleContext().setAccessibleDescription("Nháº­p hĂ¬nh áº£nh bĂ i thi vĂ o bá»™ bĂ i thi");
        importSheets.addActionListener(this);
        sheetsMenu.add(importSheets);

        // Export answers
        exportAnswers = new JMenuItem("Xấu Câu Trắc Nghiệm", KeyEvent.VK_C);
        exportAnswers.getAccessibleContext().setAccessibleDescription("Xuáº¥t ToĂ n Bá»™ CĂ¢u Tráº£ Lá»�i Ra Má»™t Tá»‡p Tin");
        exportAnswers.addActionListener(this);
        sheetsMenu.add(exportAnswers);
        
        // Export results
        exportResults = new JMenuItem("Xuất Kết Quả", KeyEvent.VK_R);
        exportResults.getAccessibleContext().setAccessibleDescription("Xuáº¥t ToĂ n Bá»™ Káº¿t Quáº£ Ra Má»™t Tá»‡p Tin");
        exportResults.addActionListener(this);
        sheetsMenu.add(exportResults);
        
        // Edit menu
        JMenu editMenu = new JMenu("Tùy Chỉnh");
        editMenu.setMnemonic(KeyEvent.VK_E);
        add(editMenu);
        
        // Undo
        JMenuItem undo = new JMenuItem("Undo", KeyEvent.VK_U);
        undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        undo.addActionListener(undoSupport.getUndoAction());
        editMenu.add(undo);
        
        // Redo
        JMenuItem redo = new JMenuItem("Redo", KeyEvent.VK_R);
        redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
        redo.addActionListener(undoSupport.getRedoAction());
        editMenu.add(redo);


        // Cut
        JMenuItem cut = new JMenuItem("Cắt", KeyEvent.VK_T);
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        //cut.addActionListener(new CutAction(undoManager));
        //editMenu.add(cut);

        // Copy
        JMenuItem copy = new JMenuItem("Sao chép", KeyEvent.VK_C);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        //copy.addActionListener(new CopyAction(undoManager));
        //editMenu.add(copy);

        // Paste
        JMenuItem paste = new JMenuItem("Dán", KeyEvent.VK_P);
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        //paste.addActionListener(new PasteAction(undoManager));
        //editMenu.add(paste);

        // Delete
        JMenuItem delete = new JMenuItem("Xóa", KeyEvent.VK_D);
        delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
        //delete.addActionListener(new DeleteAction(undoManager));
        editMenu.add(delete);
        
    

        
        // Mail feedback
        JMenu mailMenu = new JMenu("Gửi Mail");
        mailMenu.setMnemonic(KeyEvent.VK_F);
        //menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
        add(mailMenu);
        
        mailFeedback = new JMenuItem("Gá»­i Mail Káº¿t Quáº£ Cho ThĂ­ Sinh", KeyEvent.VK_M);
        mailFeedback.getAccessibleContext().setAccessibleDescription("Gá»­i Mail Káº¿t Quáº£ Cho ThĂ­ Sinh");
        mailFeedback.addActionListener(this);
        mailMenu.add(mailFeedback);
        

    }

    /**
     * Menu event listener.
     */
    public void actionPerformed(ActionEvent event) {
        JMenuItem source = (JMenuItem)(event.getSource());
        
        if (source == newProject) {
            gui.newProject();
        } else if (source == openProject) {
            gui.openProject();
        } else if (source == saveProject) {
            gui.saveProject();
        } else if (source == saveProjectAs) {
            gui.saveProjectAs();
        } else if (source == importSheets) {
            gui.importSheets();
        } else if (source == exportAnswers) {
            gui.exportAnswers();
        } else if (source == exportResults) {
            gui.exportResults();
        } else if (source == mailFeedback) {
            gui.mailFeedback();
        }
    }

}
