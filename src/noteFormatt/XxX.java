package noteFormatt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;

public class XxX extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XxX frame = new XxX();
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
	public XxX() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblEnterEachBullet = new JLabel("Enter each bullet in a seperate box");
		lblEnterEachBullet.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblEnterEachBullet.setBounds(0, 0, 288, 14);
		panel.add(lblEnterEachBullet);
		
		JTextArea textInputArea = new JTextArea();
		textInputArea.setLineWrap(true);
		textInputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textInputArea.setBounds(58, 134, 615, 270);
		textInputArea.setWrapStyleWord(true);
		
		JScrollPane scrollPaneInput = new JScrollPane(textInputArea);
		scrollPaneInput.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneInput.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
}
