package Panel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Odeme extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JSeparator separator;
	private JTextField textField_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Odeme frame = new Odeme();
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
	public Odeme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kart Bilgileri");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 30));
		lblNewLabel.setBounds(40, 41, 260, 44);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(40, 217, 176, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(40, 302, 176, 30);
		contentPane.add(textField_2);
		
		lblNewLabel_1 = new JLabel("Ad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(40, 170, 56, 25);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Soyad");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(40, 267, 56, 25);
		contentPane.add(lblNewLabel_2);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(361, 115, 15, 330);
		contentPane.add(separator);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(386, 150, 370, 30);
		contentPane.add(textField_3);
		
		lblNewLabel_4 = new JLabel("Kart Numarası");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(386, 115, 153, 25);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Son Kullanma Tarihi");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(386, 215, 198, 25);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(386, 250, 83, 30);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(479, 250, 83, 30);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("CVC");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(386, 315, 56, 25);
		contentPane.add(lblNewLabel_3_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(386, 350, 67, 30);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("Ödemeyi Tamamla");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(546, 453, 189, 44);
		contentPane.add(btnNewButton);
	}
}
