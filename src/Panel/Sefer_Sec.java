package Panel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Sefer_Sec extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public Sefer_Sec(String nereden, String nereye, String tarih) {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel bilgilerLabel = new JLabel("Seçilen Uçuş: " + nereden + " -> " + nereye + " | Tarih: " + tarih);
        bilgilerLabel.setBounds(50, 30, 700, 30);
        bilgilerLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(bilgilerLabel);

        // Uçuş seçenekleri için RadioButtonlar
        JRadioButton bilet1Radio = new JRadioButton("09:00 - Economy - 500 TL");
        bilet1Radio.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bilet1Radio.setBounds(50, 119, 300, 30);
        contentPane.add(bilet1Radio);

        JRadioButton bilet2Radio = new JRadioButton("12:00 - Business - 800 TL");
        bilet2Radio.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bilet2Radio.setBounds(50, 182, 300, 30);
        contentPane.add(bilet2Radio);

        JRadioButton bilet3Radio = new JRadioButton("18:00 - Economy - 600 TL");
        bilet3Radio.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bilet3Radio.setBounds(50, 245, 300, 30);
        contentPane.add(bilet3Radio);

        // RadioButtonları gruplama (aynı anda sadece bir tanesi seçilebilir)
        ButtonGroup biletGroup = new ButtonGroup();
        biletGroup.add(bilet1Radio);
        biletGroup.add(bilet2Radio);
        biletGroup.add(bilet3Radio);

        // Bileti Seç Butonu
        JButton biletSecButton = new JButton("Bileti Seç");
        biletSecButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        biletSecButton.setBounds(562, 500, 150, 30);
        contentPane.add(biletSecButton);

        // Dinleyici ekle
        biletSecButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bilet1Radio.isSelected() || bilet2Radio.isSelected() || bilet3Radio.isSelected()) {
                    // Yolcu_Bilgileri penceresine geç
                    Yolcu_Bilgileri yolcuBilgileriFrame = new Yolcu_Bilgileri();
                    yolcuBilgileriFrame.setVisible(true);
                    dispose(); // Mevcut pencereyi kapat
                } else {
                    // Bilet seçilmemişse uyarı mesajı göster
                    JOptionPane.showMessageDialog(Sefer_Sec.this, "Lütfen bir bilet seçin!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Geri Dön Butonu
        JButton geriDonButton = new JButton("Geri Dön");
        geriDonButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        geriDonButton.setBounds(50, 500, 150, 30);
        contentPane.add(geriDonButton);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(46, 70, 553, 330);
        contentPane.add(separator);

        // Geri Dön Butonu Dinleyici
        geriDonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sefer_Ara seferAraFrame = new Sefer_Ara();
                seferAraFrame.setVisible(true);
                dispose(); // Mevcut pencereyi kapat
            }
        });
    }
}
