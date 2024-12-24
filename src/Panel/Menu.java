package Panel;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Menu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu frame = new Menu();
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
    public Menu() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton sefer_buton = new JButton("Sefer Ara");
        sefer_buton.setFont(new Font("Tahoma", Font.PLAIN, 25));
        sefer_buton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Sefer_Ara JFrame'ine geçiş
                Sefer_Ara seferAraFrame = new Sefer_Ara();
                seferAraFrame.setVisible(true);
                dispose(); // Menu JFrame'ini kapat
            }
        });
        sefer_buton.setBounds(250, 300, 300, 80);
        contentPane.add(sefer_buton);

        JButton menu_ucus_sorgu_buton = new JButton("Uçuş Sorgulama");
        menu_ucus_sorgu_buton.setFont(new Font("Tahoma", Font.PLAIN, 25));
        menu_ucus_sorgu_buton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ucus_Sorgu JFrame'ine geçiş
                Ucus_Sorgu ucusSorguFrame = new Ucus_Sorgu();
                ucusSorguFrame.setVisible(true);
                dispose(); // Menu JFrame'ini kapat
            }
        });
        menu_ucus_sorgu_buton.setBounds(250, 400, 300, 80);
        contentPane.add(menu_ucus_sorgu_buton);

        JLabel menu_label = new JLabel("Falcon Airways");
        menu_label.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 64));
        menu_label.setBounds(200, 63, 400, 88);
        contentPane.add(menu_label);
    }
}
