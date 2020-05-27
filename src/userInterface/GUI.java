package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import noteFormatt.TextFrame;
import noteFormatt.LineTooLongException;
import noteFormatt.textTransfer;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerListModel;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;

import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import javax.swing.event.ChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textBorderCorner;
	private JTextField textBorderV;
	private JTextField textBorderH;
	private JTextField textBorderSpacer;
	private JTextField textTextCorner;
	private JTextField textTextV;
	private JTextField textTextH;
	private JTextField textTextSpacer;
	private JTextField textCommentHead;
	
	private boolean commentsEnabled = false;
	private JTextField textLineWidth;
	private JTextField textCommentTail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Set System L&F
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setResizable(false);
		setTitle("Eggplant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 1024);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setBounds(0, 0, 752, 985);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);
		
		JLabel lblInputs = new JLabel("Format Configurations");
		lblInputs.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblInputs.setBounds(10, 11, 177, 14);
		backgroundPanel.add(lblInputs);
		
		JPanel configPanel = new JPanel();
		configPanel.setBackground(new Color(153, 102, 102));
		configPanel.setBounds(10, 30, 721, 480);
		backgroundPanel.add(configPanel);
		configPanel.setLayout(null);
		
		JLabel lblCorner = new JLabel("Frame Corner     :");
		lblCorner.setBounds(20, 12, 126, 17);
		lblCorner.setFont(new Font("Monospaced", Font.BOLD, 12));
		configPanel.add(lblCorner);
		
		JLabel lblBorderVertical = new JLabel("Border Vertical  :");
		lblBorderVertical.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblBorderVertical.setBounds(20, 40, 126, 17);
		configPanel.add(lblBorderVertical);
		
		JLabel lblBorderHoriziontal = new JLabel("Border Horizontal:");
		lblBorderHoriziontal.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblBorderHoriziontal.setBounds(20, 70, 126, 17);
		configPanel.add(lblBorderHoriziontal);
		
		JLabel lblFrameSpacer = new JLabel("Frame Spacer     :");
		lblFrameSpacer.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblFrameSpacer.setBounds(20, 98, 126, 17);
		configPanel.add(lblFrameSpacer);
		
		JLabel lblTextSpacer = new JLabel("Text Spacer      :");
		lblTextSpacer.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblTextSpacer.setBounds(349, 98, 126, 17);
		configPanel.add(lblTextSpacer);
		
		JLabel lblTextHorizontal = new JLabel("Text Horizontal  :");
		lblTextHorizontal.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblTextHorizontal.setBounds(349, 70, 126, 17);
		configPanel.add(lblTextHorizontal);
		
		JLabel lblTextVertical = new JLabel("Text Vertical    :");
		lblTextVertical.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblTextVertical.setBounds(349, 40, 126, 17);
		configPanel.add(lblTextVertical);
		
		JLabel lblTextCorner = new JLabel("Text Corner      :");
		lblTextCorner.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblTextCorner.setBounds(349, 12, 126, 17);
		configPanel.add(lblTextCorner);
		
		textBorderCorner = new JTextField();
		textBorderCorner.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textBorderCorner.setToolTipText("Enter 1 (one) character to be used for the Corners");
		textBorderCorner.setText("+");
		textBorderCorner.setBounds(156, 11, 86, 20);
		configPanel.add(textBorderCorner);
		textBorderCorner.setColumns(10);
		
		textBorderV = new JTextField();
		textBorderV.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textBorderV.setToolTipText("Enter 1 (one) character to be used for the Vertical Frame Borders");
		textBorderV.setText("!");
		textBorderV.setBounds(156, 39, 86, 20);
		configPanel.add(textBorderV);
		textBorderV.setColumns(10);
		
		textBorderH = new JTextField();
		textBorderH.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textBorderH.setToolTipText("Enter 1 (one) character to be used for the Horizontal Frame Borders");
		textBorderH.setText("=");
		textBorderH.setBounds(156, 69, 86, 20);
		configPanel.add(textBorderH);
		textBorderH.setColumns(10);
		
		textBorderSpacer = new JTextField();
		textBorderSpacer.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textBorderSpacer.setText("*");
		textBorderSpacer.setToolTipText("Enter 1 (one) character to be used for the Frame Spacers");
		textBorderSpacer.setBounds(156, 97, 86, 20);
		configPanel.add(textBorderSpacer);
		textBorderSpacer.setColumns(10);
		
		textTextCorner = new JTextField();
		textTextCorner.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textTextCorner.setToolTipText("Enter 1 (one) character to be used for the Text Frame Corners");
		textTextCorner.setText("x");
		textTextCorner.setBounds(485, 11, 86, 20);
		configPanel.add(textTextCorner);
		textTextCorner.setColumns(10);
		
		textTextV = new JTextField();
		textTextV.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textTextV.setToolTipText("Enter 1 (one) character to be used for the Vertical Text Borders");
		textTextV.setText("|");
		textTextV.setBounds(485, 39, 86, 20);
		configPanel.add(textTextV);
		textTextV.setColumns(10);
		
		textTextH = new JTextField();
		textTextH.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textTextH.setToolTipText("Enter 1 (one) character to be used for the Horiziontal Text Borders");
		textTextH.setText("-");
		textTextH.setBounds(485, 69, 86, 20);
		configPanel.add(textTextH);
		textTextH.setColumns(10);
		
		textTextSpacer = new JTextField();
		textTextSpacer.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textTextSpacer.setToolTipText("Enter 1 (one) character to be used for the Text Frame Spacers");
		textTextSpacer.setText(" ");
		textTextSpacer.setBounds(485, 97, 86, 20);
		configPanel.add(textTextSpacer);
		textTextSpacer.setColumns(10);
		
		JLabel lblFlavours = new JLabel("Flavours         :");
		lblFlavours.setForeground(Color.WHITE);
		lblFlavours.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblFlavours.setBounds(349, 424, 126, 17);
		configPanel.add(lblFlavours);
		
		JSpinner txtSku = new JSpinner(new SpinnerListModel(GUI.getPreMadeFlavours()) );
		txtSku.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				String[] flavourOfTheDay = GUI.getPreMadeFlavour( (String) txtSku.getValue() );
				
				textBorderCorner.setText(flavourOfTheDay[0]);		// char at (0,0) (0,width), (length,0), and (width,length)
				textBorderV.setText(flavourOfTheDay[1]);				// exterior line along LEFT/ RIGHT of the perimeter
				textBorderH.setText(flavourOfTheDay[2]);				// exterior line along TOP/ BOTTOM side of the perimeter
				textBorderSpacer.setText(flavourOfTheDay[3]);		// char between borders
				
				textTextV.setText(flavourOfTheDay[4]);					// char that defines the border of a text frame (LEFT/ RIGHT)		| defaults = borderCharV
				textTextH.setText(flavourOfTheDay[5]);			// char that defines the border of a text frame (TOP/ BOTTOM)		| defaults = borderCharH
				textTextCorner.setText(flavourOfTheDay[6]); 		// char that is used for the corner of a text frame | defaults = cornerChar
				textTextSpacer.setText(flavourOfTheDay[7]);
			}
		});
		
		/*
				String[] flavourOfTheDay = FrameBuilder.getPreMadeFlavour( (String) txtSku.getValue() );
				
				textBorderCorner.setText(flavourOfTheDay[0]);		// char at (0,0) (0,width), (length,0), and (width,length)
				textBorderV.setText(flavourOfTheDay[1]);				// exterior line along LEFT/ RIGHT of the perimeter
				textBorderH.setText(flavourOfTheDay[2]);				// exterior line along TOP/ BOTTOM side of the perimeter
				textBorderSpacer.setText(flavourOfTheDay[3]);		// char between borders
				
				textTextV.setText(flavourOfTheDay[4]);					// char that defines the border of a text frame (LEFT/ RIGHT)		| defaults = borderCharV
				textTextH.setText(flavourOfTheDay[5]);			// char that defines the border of a text frame (TOP/ BOTTOM)		| defaults = borderCharH
				textTextCorner.setText(flavourOfTheDay[6]); 		// char that is used for the corner of a text frame | defaults = cornerChar
				textTextSpacer.setText(flavourOfTheDay[7]);
		 * 
		 */
		txtSku.setToolTipText("tasty :)");
		txtSku.setFont(new Font("Monospaced", Font.BOLD, 12));
		txtSku.setBounds(475, 424, 198, 17);
		configPanel.add(txtSku);

		JLabel lblComments = new JLabel("Block Comments   :");
		lblComments.setToolTipText("Used to auto add a languages block comment around the output");
		lblComments.setForeground(Color.WHITE);
		lblComments.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblComments.setBounds(20, 424, 126, 17);
		configPanel.add(lblComments);
		
		textCommentHead = new JTextField();
		textCommentHead.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textCommentHead.setText("/*");
		textCommentHead.setBounds(156, 422, 38, 20);
		configPanel.add(textCommentHead);
		textCommentHead.setColumns(10);
		
		textCommentTail = new JTextField();
		textCommentTail.setText("*/");
		textCommentTail.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textCommentTail.setColumns(10);
		textCommentTail.setBounds(204, 422, 38, 20);
		configPanel.add(textCommentTail);
		
		JSeparator separatorBottom = new JSeparator();
		separatorBottom.setForeground(new Color(255, 255, 255));
		separatorBottom.setBounds(10, 410, 700, 2);
		configPanel.add(separatorBottom);
		
		JLabel lblLineWidth = new JLabel("Line Width       :");
		lblLineWidth.setForeground(Color.WHITE);
		lblLineWidth.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblLineWidth.setBounds(20, 452, 126, 17);
		configPanel.add(lblLineWidth);
		
		textLineWidth = new JTextField();
		textLineWidth.setToolTipText("Adjust the amount of characters per line.      83 is Default  |  129 is SQL developer");
		textLineWidth.setText("83");
		textLineWidth.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textLineWidth.setColumns(10);
		textLineWidth.setBounds(156, 452, 86, 20);
		configPanel.add(textLineWidth);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 128, 681, 271);
		configPanel.add(tabbedPane);
		
		JTextArea textInputArea = new JTextArea();
		textInputArea.setLineWrap(true);
		textInputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textInputArea.setBounds(58, 134, 615, 270);
		textInputArea.setWrapStyleWord(true);
		
		JScrollPane scrollPaneInput = new JScrollPane(textInputArea);
		tabbedPane.addTab("Plain Text  ", null, scrollPaneInput, null);
		scrollPaneInput.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneInput.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JPanel panelBullets = new JPanel();
		tabbedPane.addTab("Bullets  ", null, panelBullets, null);
		
		
		
		
//===== RESULTS PANEL
		JLabel lblResults = new JLabel("Formatted Text");
		lblResults.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblResults.setBounds(15, 549, 124, 14);
		backgroundPanel.add(lblResults);
		
		JPanel resultPanel = new JPanel();
		resultPanel.setBackground(Color.DARK_GRAY);
		resultPanel.setBounds(10, 570, 721, 404);
		backgroundPanel.add(resultPanel);
		resultPanel.setLayout(null);
		
		JTextArea textResultArea = new JTextArea();
		textResultArea.setToolTipText(" -Click n' Copy   ");
		textResultArea.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				// Click n' Copy
				textTransfer tc = new textTransfer();
				tc.setClipboardContents(textResultArea.getText());
			}
		});
		textResultArea.setEditable(false);
		textResultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textResultArea.setBounds(10, 0, 615, 409);
		textResultArea.setWrapStyleWord(true);
		
		JScrollPane scrollPaneResult = new JScrollPane(textResultArea);
		scrollPaneResult.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneResult.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneResult.setBounds(29, 0, 692, 404);
		resultPanel.add(scrollPaneResult);
		
		JRadioButton rdbtnEnableComments = new JRadioButton("Enable Comments");
		rdbtnEnableComments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				commentsEnabled = !commentsEnabled;		
				System.out.println("commentsEnabled : " + commentsEnabled);
			}
		});
		rdbtnEnableComments.setBounds(438, 525, 144, 23);
		backgroundPanel.add(rdbtnEnableComments);
		rdbtnEnableComments.setFont(new Font("Monospaced", Font.PLAIN, 12));
		
		
		JButton btnBuild = new JButton("Build");
		btnBuild.setToolTipText("Builds the text based on the Format Configurations");
		btnBuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Builds values					// defaults to white space
				char cornerChar  = ' ';				// char at (0,0) (0,width), (length,0), and (width,length)
				char borderCharV = ' ';				// exterior line along LEFT/ RIGHT of the perimeter
				char borderCharH = ' ';				// exterior line along TOP/ BOTTOM side of the perimeter
				char lineChar    = ' ';				// char between borders
				
				char frameCharV  	 = ' ';			// char that defines the border of a text frame (LEFT/ RIGHT)		| defaults = borderCharV
				char frameCharH  	 = ' ';			// char that defines the border of a text frame (TOP/ BOTTOM)		| defaults = borderCharH
				char frameCornerChar = ' '; 		// char that is used for the corner of a text frame | defaults = cornerChar
				char textFrameChar   = ' ';			// char between text border and text
				
				try {
					// builds based on user inputs
					cornerChar  = textBorderCorner.getText().charAt(0);			// char at (0,0) (0,width), (length,0), and (width,length)
					borderCharV = textBorderV.getText().charAt(0);				// exterior line along LEFT/ RIGHT of the perimeter
					borderCharH = textBorderH.getText().charAt(0);				// exterior line along TOP/ BOTTOM side of the perimeter
					lineChar    = textBorderSpacer.getText().charAt(0);			// char between borders
					
					frameCharV  	 = textTextV.getText().charAt(0);			// char that defines the border of a text frame (LEFT/ RIGHT)		| defaults = borderCharV
					frameCharH  	 = textTextH.getText().charAt(0);			// char that defines the border of a text frame (TOP/ BOTTOM)		| defaults = borderCharH
					frameCornerChar	 = textTextCorner.getText().charAt(0); 		// char that is used for the corner of a text frame | defaults = cornerChar
					textFrameChar    = textTextSpacer.getText().charAt(0);		// char between text border and text
				} catch (StringIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(contentPane, "Format Configurations can not be null\nEnter a space instead", "Error", JOptionPane.INFORMATION_MESSAGE, null);
				}
				
				TextFrame fb = new TextFrame(cornerChar, borderCharV, borderCharH, lineChar, frameCharV, frameCharH, frameCornerChar, textFrameChar);
				
				// updates line size
				try {
					fb.setLINEWIDTH( Integer.parseInt( textLineWidth.getText() ));
				} catch ( NumberFormatException e ) {
					System.out.println("LINEWIDTH set to 83  ( default )");
					fb.setLINEWIDTH(83); 			// default from 8.5x11 page notepad pt.12
				}
				
				// comments?
				String lineCommentHead  = "/*" ;			// optionally defined comment type '//' or '--' or '/* */' or 'ect.'| replaces (0,2) & (len-2, len) with comment type | HEAD
				String lineCommentTail  = "*/";				// the opposite half
				try {
					String toReturn = textInputArea.getText();
					toReturn = fb.buildText(toReturn);
					if( commentsEnabled )			
					{
						// State changed on radio button
						lineCommentHead = textCommentHead.getText();	// updates value 
						lineCommentTail = textCommentTail.getText();
						
						toReturn = lineCommentHead +"\n"+ toReturn + lineCommentTail;
					}  
					textResultArea.setText(toReturn);
					
				} catch (LineTooLongException e) {
					JOptionPane.showMessageDialog(contentPane, "Text is too wide to fit on one line\nBreak up text and try again", "Error", JOptionPane.INFORMATION_MESSAGE, null);
					e.printStackTrace();
				}
			}
		});
		btnBuild.setFont(new Font("Monospaced", Font.PLAIN, 12));
		btnBuild.setBounds(313, 525, 89, 23);
		backgroundPanel.add(btnBuild);
	}
	
	// ------ HELPERS
	public static String[] getPreMadeFlavour(String key) 
	{
		
		/*
		 * textBorderCorner.setText(flavourOfTheDay[0]);		// char at (0,0) (0,width), (length,0), and (width,length)
			textBorderV.setText(flavourOfTheDay[1]);				// exterior line along LEFT/ RIGHT of the perimeter
			textBorderH.setText(flavourOfTheDay[2]);				// exterior line along TOP/ BOTTOM side of the perimeter
			textBorderSpacer.setText(flavourOfTheDay[3]);		// char between borders
			
			textTextV.setText(flavourOfTheDay[4]);					// char that defines the border of a text frame (LEFT/ RIGHT)		| defaults = borderCharV
			textTextH.setText(flavourOfTheDay[5]);			// char that defines the border of a text frame (TOP/ BOTTOM)		| defaults = borderCharH
			textTextCorner.setText(flavourOfTheDay[6]); 		// char that is used for the corner of a text frame | defaults = cornerChar
			textTextSpacer.setText(flavourOfTheDay[7]);
		 * 
		 */
		
		String[][] flavours = {
			{"+","!","=","#",		"|","-","o"," ",  "Default"},
			{"+","|","=","o",		"|","-","O",".",  "Bubbles"},
			{"O","|","-",".",		"=","=","o"," ",  "Dots"},
			{"X","+","+","-",		"=","=","x","*",  "(De)Classified"},
			{"+"," ","^"," ",		"|"," ","o"," ",  "Gas Station"},
			
			{"O","=","|","|",		"=","=","o"," ",  "Pillars"},
			{"O","=","|","|",		"=","=","o"," ",  "Pillars"},
			{"O","=","|","|",		"=","=","o"," ",  "Pillars"},
			{"O","=","|","|",		"=","=","o"," ",  "Pillars"},
			{"O","=","|","|",		"=","=","o"," ",  "Pillars"}
		};
		for( String[] s : flavours)
		{
			if( key.equals(s[8]) )
			{
				return s;
			}
		}
		return new String[] {"+","!","=","#",		"|","-","o"," ",  "Default"};
	}
	public static String[] getPreMadeFlavours() 
	{
		/*
		 * Names of the preset flavours
		 * must match in getPreMadeFlavour(String key) to work
		 */
		return new String[] {"Default", "Bubbles", "Dots", "(De)Classified", "Gas Station", "Pillars"};
	}
}




