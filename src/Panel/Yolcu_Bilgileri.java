package Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Yolcu_Bilgileri extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public Yolcu_Bilgileri() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Devam Et Butonu
        JButton devamButton = new JButton("Devam Et");
        devamButton.setBounds(300, 500, 150, 30);
        contentPane.add(devamButton);

        // Devam Et Butonu Dinleyici
        devamButton.addActionListener(e -> {
            System.out.println("Sonraki işleme geçilecek.");
        });

        // Geri Dön Butonu
        JButton geriDonButton = new JButton("Geri Dön");
        geriDonButton.setBounds(50, 500, 150, 30);
        contentPane.add(geriDonButton);

        // Geri Dön Butonu Dinleyici
        geriDonButton.addActionListener(e -> {
            Sefer_Sec seferSecFrame = new Sefer_Sec("İstanbul", "Ankara", "01/01/2024"); // Örnek veriler
            seferSecFrame.setVisible(true);
            dispose(); // Mevcut pencereyi kapat
        });
    }
}
