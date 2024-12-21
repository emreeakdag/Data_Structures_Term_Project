package Panel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Ucus_Sorgu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ucus_Sorgu frame = new Ucus_Sorgu();
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
	public Ucus_Sorgu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Uçuş Sorgu");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 30));
		lblNewLabel.setBounds(50, 45, 248, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T.C");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(50, 97, 136, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("İSİM");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(50, 174, 136, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("SOYİSİM");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(50, 251, 136, 27);
		contentPane.add(lblNewLabel_1_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(50, 134, 176, 30);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(50, 211, 176, 30);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(50, 288, 176, 30);
		contentPane.add(textField_2);
		
		JButton btnSorgula = new JButton("Sorgula");
		btnSorgula.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSorgula.setBounds(538, 467, 189, 44);
		contentPane.add(btnSorgula);
		
		JButton btnGeriDn = new JButton("Geri Dön");
		btnGeriDn.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnGeriDn.setBounds(50, 467, 189, 44);
		contentPane.add(btnGeriDn);
	}
}
