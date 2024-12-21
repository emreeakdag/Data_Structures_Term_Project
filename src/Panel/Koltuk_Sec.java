package Panel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Koltuk_Sec extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Koltuk_Sec frame = new Koltuk_Sec();
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
	public Koltuk_Sec() {
		setBackground(SystemColor.info);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 995, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setForeground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("8A");
		tglbtnNewToggleButton.setBounds(147, 499, 48, 44);
		contentPane.add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnb_7 = new JToggleButton("8B");
		tglbtnb_7.setBounds(205, 499, 49, 44);
		contentPane.add(tglbtnb_7);
		
		JToggleButton tglbtna = new JToggleButton("2A");
		tglbtna.setBounds(147, 175, 49, 44);
		contentPane.add(tglbtna);
		
		JToggleButton tglbtnb_1 = new JToggleButton("2B");
		tglbtnb_1.setBounds(205, 175, 49, 44);
		contentPane.add(tglbtnb_1);
		
		JToggleButton tglbtna_1 = new JToggleButton("3A");
		tglbtna_1.setBounds(147, 229, 49, 44);
		contentPane.add(tglbtna_1);
		
		JToggleButton tglbtnb_2 = new JToggleButton("3B");
		tglbtnb_2.setBounds(205, 229, 49, 44);
		contentPane.add(tglbtnb_2);
		
		JToggleButton tglbtna_2 = new JToggleButton("4A");
		tglbtna_2.setBounds(147, 283, 49, 44);
		contentPane.add(tglbtna_2);
		
		JToggleButton tglbtnb_3 = new JToggleButton("4B");
		tglbtnb_3.setBounds(205, 283, 49, 44);
		contentPane.add(tglbtnb_3);
		
		JToggleButton tglbtna_3 = new JToggleButton("5A");
		tglbtna_3.setBounds(147, 337, 49, 44);
		contentPane.add(tglbtna_3);
		
		JToggleButton tglbtnb_4 = new JToggleButton("5B");
		tglbtnb_4.setBounds(205, 337, 49, 44);
		contentPane.add(tglbtnb_4);
		
		JToggleButton tglbtna_4 = new JToggleButton("6A");
		tglbtna_4.setBounds(147, 391, 49, 44);
		contentPane.add(tglbtna_4);
		
		JToggleButton tglbtnb_5 = new JToggleButton("6B");
		tglbtnb_5.setBounds(205, 391, 49, 44);
		contentPane.add(tglbtnb_5);
		
		JToggleButton tglbtna_5 = new JToggleButton("7A");
		tglbtna_5.setBounds(147, 445, 49, 44);
		contentPane.add(tglbtna_5);
		
		JToggleButton tglbtnb_6 = new JToggleButton("7B");
		tglbtnb_6.setBounds(205, 445, 49, 44);
		contentPane.add(tglbtnb_6);
		
		JToggleButton tglbtnNewToggleButton_14 = new JToggleButton("1A");
		tglbtnNewToggleButton_14.setBounds(147, 121, 49, 44);
		contentPane.add(tglbtnNewToggleButton_14);
		
		JToggleButton tglbtnb = new JToggleButton("1B");
		tglbtnb.setBounds(205, 121, 49, 44);
		contentPane.add(tglbtnb);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 10, 370, 671);
		lblNewLabel.setBackground(SystemColor.activeCaptionBorder);
		lblNewLabel.setIcon(new ImageIcon(Koltuk_Sec.class.getResource("/images/ucaksonnn.png")));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seçilen uçuş ");
		lblNewLabel_1.setBounds(492, 79, 370, 140);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(444, 50, 15, 631);
		contentPane.add(separator);
	}
}
