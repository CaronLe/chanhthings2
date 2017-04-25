package omr.gui;

import java.awt.Color;
import java.awt.Font;
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
        fileMenu.setForeground(new Color(48,47,95));
        fileMenu.setFont(new Font("Century Gothic", Font.BOLD, 14));
        add(fileMenu);
        
        // New project
        newProject = new JMenuItem("Tạo Bộ Bài Thi Mới", KeyEvent.VK_N);
        newProject.addActionListener(this);
        fileMenu.add(newProject);
        
        // Open project
        openProject = new JMenuItem("Mở Bộ Bài Thi", KeyEvent.VK_O);
        openProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        openProject.addActionListener(this);
        fileMenu.add(openProject);

        // Save project
        saveProject = new JMenuItem("Lưu Bộ Bài Thi", KeyEvent.VK_A);
        saveProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveProject.addActionListener(this);
        fileMenu.add(saveProject);

        // Save project as
        saveProjectAs = new JMenuItem("Lưu Bộ Bài Thi Tại .....", KeyEvent.VK_S);
        //saveProjectAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveProjectAs.addActionListener(this);
        fileMenu.add(saveProjectAs);

        
        // Sheets management
        JMenu sheetsMenu = new JMenu("Bài Thi");
        sheetsMenu.setMnemonic(KeyEvent.VK_F);
        sheetsMenu.setForeground(new Color(48,47,95));
        sheetsMenu.setFont(new Font("Century Gothic", Font.BOLD, 14));
        //menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
        add(sheetsMenu);
        
        importSheets = new JMenuItem("Nhập Bài Thi", KeyEvent.VK_I);
        importSheets.getAccessibleContext().setAccessibleDescription("Nhập hình ảnh bài thi vào bộ bài thi");
        importSheets.addActionListener(this);
        sheetsMenu.add(importSheets);

        // Export answers
        exportAnswers = new JMenuItem("Xuất Câu Trả Lời", KeyEvent.VK_C);
        exportAnswers.getAccessibleContext().setAccessibleDescription("Xuất Toàn Bộ Câu Trả Lời Ra Một Tệp Tin");
        exportAnswers.addActionListener(this);
        sheetsMenu.add(exportAnswers);
        
        // Export results
        exportResults = new JMenuItem("Xuất Kết Quả", KeyEvent.VK_R);
        exportResults.getAccessibleContext().setAccessibleDescription("Xuất Toàn Bộ Kết Quả Ra Một Tệp Tin");
        exportResults.addActionListener(this);
        sheetsMenu.add(exportResults);
        
        // Edit menu
        JMenu editMenu = new JMenu("Tuỳ Chỉnh");
        editMenu.setMnemonic(KeyEvent.VK_E);
        editMenu.setForeground(new Color(48,47,95));
        editMenu.setFont(new Font("Century Gothic", Font.BOLD, 14));
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
        JMenuItem delete = new JMenuItem("Xoá", KeyEvent.VK_D);
        delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
        //delete.addActionListener(new DeleteAction(undoManager));
        editMenu.add(delete);
        
    

        
//        // Mail feedback
//        JMenu mailMenu = new JMenu("Gửi Mail");
//        mailMenu.setMnemonic(KeyEvent.VK_F);
//        //menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
//        add(mailMenu);
//        
//        mailFeedback = new JMenuItem("Gửi Mail Kết Quả Cho Thí Sinh", KeyEvent.VK_M);
//        mailFeedback.getAccessibleContext().setAccessibleDescription("Gửi Mail Kết Quả Cho Thí Sinh");
//        mailFeedback.addActionListener(this);
//        mailMenu.add(mailFeedback);
        

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
