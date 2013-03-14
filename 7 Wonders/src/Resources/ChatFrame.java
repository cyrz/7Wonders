package Resources;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
 
@SuppressWarnings("serial")
public class ChatFrame extends JPanel{
    protected JTextField textField;
    protected JTextArea textArea;
    private JFrame frame;
    private final static String newline = "\n";
    private Chat chatHub;

    public ChatFrame(Chat ch) {
        super(new GridBagLayout());
        chatHub = ch;
        textField = new JTextField(20);
        frame = new JFrame("7 Wonders Chat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add contents to the window.
        frame.add(this);
 
        //Display the window.
    
        textField.addActionListener(new ActionListener() {
			
		    public void actionPerformed(ActionEvent evt) {
            String text = textField.getText();
            textField.setText("");
            //textArea.append(text + newline);
            chatHub.sendMsg(text);
            //Make sure the new text is visible, even if there
            //was a selection in the text area.
            textArea.setCaretPosition(textArea.getDocument().getLength());
		    }
        });
 
        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
 
        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
 
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);
 
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
    }
 


    public void appendChat(String c){
    	textArea.append(c + newline);
    	System.out.println("output" + c);	    	
    }
    public void createAndShowGUI() {
        //Create and set up the window.
        frame.pack();
        frame.setVisible(true);
    }
 
}
