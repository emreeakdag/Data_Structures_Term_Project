import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class deneme_panel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField test;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deneme_panel frame = new deneme_panel();
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
	public deneme_panel() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(169, 41, 167, 16);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(62, 42, 45, 13);
		contentPane.add(lblNewLabel);
		
		test = new JTextField();
		test.setBounds(179, 74, 96, 19);
		test.setToolTipText("abc");
		test.setText("abc");
		contentPane.add(test);
		test.setColumns(10);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(196, 129, 5, 16);
		contentPane.add(textArea_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(342, 242, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(293, 73, 93, 21);
		contentPane.add(chckbxNewCheckBox);
	}
}
