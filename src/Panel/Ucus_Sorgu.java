package Panel;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		JLabel lblNewLabel = new JLabel("U\u00e7u\u015f Sorgu");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 30));
		lblNewLabel.setBounds(50, 45, 248, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T.C");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(50, 97, 136, 27);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(50, 134, 176, 30);
		contentPane.add(textField);
		
		JButton btnSorgula = new JButton("Sorgula");
		btnSorgula.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSorgula.setBounds(538, 467, 189, 44);
		contentPane.add(btnSorgula);
		
		JButton btnGeriDn = new JButton("Geri D\u00f6n");
		btnGeriDn.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnGeriDn.setBounds(50, 467, 189, 44);
		contentPane.add(btnGeriDn);
		
		btnGeriDn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Menu menuFrame = new Menu();
				menuFrame.setVisible(true);
				dispose();
			}
		});
	}
}
