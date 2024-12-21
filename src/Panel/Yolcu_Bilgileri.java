package Panel;

import javax.swing.*;
import javax.swing.border.EmptyBorder; // EmptyBorder import ediliyor
import java.awt.*;
import java.awt.event.*;

public class Yolcu_Bilgileri extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfIsim, tfSoyisim, tfDogumTarihi, tfTcKimlik, tfEmail, tfTelefon;
    private JRadioButton rbBay, rbBayan;
    private ButtonGroup cinsiyetGroup;

    public Yolcu_Bilgileri() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  // EmptyBorder kullanımı
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Cinsiyet Seçimi
        JLabel lblCinsiyet = new JLabel("Cinsiyet:");
        lblCinsiyet.setBounds(50, 50, 80, 30);
        contentPane.add(lblCinsiyet);

        rbBay = new JRadioButton("Bay");
        rbBay.setBounds(140, 50, 60, 30);
        rbBayan = new JRadioButton("Bayan");
        rbBayan.setBounds(200, 50, 70, 30);

        cinsiyetGroup = new ButtonGroup();
        cinsiyetGroup.add(rbBay);
        cinsiyetGroup.add(rbBayan);
        contentPane.add(rbBay);
        contentPane.add(rbBayan);

        // İsim ve Soyisim
        JLabel lblIsim = new JLabel("İsim:");
        lblIsim.setBounds(50, 100, 80, 30);
        contentPane.add(lblIsim);
        tfIsim = new JTextField();
        tfIsim.setBounds(140, 100, 200, 30);
        tfIsim.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!Character.isLetter(e.getKeyChar()) && !Character.isWhitespace(e.getKeyChar())) {
                    e.consume(); // Sadece harf ve boşluk girilmesine izin ver
                }
            }
        });
        contentPane.add(tfIsim);

        JLabel lblSoyisim = new JLabel("Soyisim:");
        lblSoyisim.setBounds(50, 150, 80, 30);
        contentPane.add(lblSoyisim);
        tfSoyisim = new JTextField();
        tfSoyisim.setBounds(140, 150, 200, 30);
        tfSoyisim.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!Character.isLetter(e.getKeyChar()) && !Character.isWhitespace(e.getKeyChar())) {
                    e.consume(); // Sadece harf ve boşluk girilmesine izin ver
                }
            }
        });
        contentPane.add(tfSoyisim);

        // Doğum Tarihi
        JLabel lblDogumTarihi = new JLabel("Doğum Tarihi:");
        lblDogumTarihi.setBounds(50, 200, 100, 30);
        contentPane.add(lblDogumTarihi);
        tfDogumTarihi = new JTextField();
        tfDogumTarihi.setBounds(140, 200, 200, 30);
        contentPane.add(tfDogumTarihi);

        // TC Kimlik Numarası
        JLabel lblTcKimlik = new JLabel("TC Kimlik No:");
        lblTcKimlik.setBounds(50, 250, 100, 30);
        contentPane.add(lblTcKimlik);
        tfTcKimlik = new JTextField();
        tfTcKimlik.setBounds(140, 250, 200, 30);
        tfTcKimlik.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (tfTcKimlik.getText().length() >= 11) {
                    e.consume(); // 11 haneli sınır
                }
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume(); // Yalnızca rakam girmeye izin ver
                }
            }
        });
        contentPane.add(tfTcKimlik);

        // E-Posta
        JLabel lblEmail = new JLabel("E-posta:");
        lblEmail.setBounds(50, 300, 80, 30);
        contentPane.add(lblEmail);
        tfEmail = new JTextField();
        tfEmail.setBounds(140, 300, 200, 30);
        contentPane.add(tfEmail);

        // Telefon Numarası
        JLabel lblTelefon = new JLabel("Telefon:");
        lblTelefon.setBounds(50, 350, 80, 30);
        contentPane.add(lblTelefon);
        tfTelefon = new JTextField("+90");
        tfTelefon.setBounds(140, 350, 200, 30);
        tfTelefon.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfTelefon.getText().isEmpty()) {
                    tfTelefon.setText("+90");
                }
            }
        });
        tfTelefon.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (tfTelefon.getText().length() >= 13) {
                    e.consume(); // +90 + 10 haneli telefon numarası
                }
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '+') {
                    e.consume(); // Yalnızca rakam ve "+" işareti
                }
            }
        });
        contentPane.add(tfTelefon);

        // Devam Et Butonu
        JButton devamButton = new JButton("Devam Et");
        devamButton.setBounds(300, 500, 150, 30);
        contentPane.add(devamButton);

        // Geri Dön Butonu
        JButton geriDonButton = new JButton("Geri Dön");
        geriDonButton.setBounds(50, 500, 150, 30);
        contentPane.add(geriDonButton);

        geriDonButton.addActionListener(e -> {
            Sefer_Sec seferSecFrame = new Sefer_Sec("İstanbul", "Ankara", "01/01/2024"); // Örnek veriler
            seferSecFrame.setVisible(true);
            dispose(); // Mevcut pencereyi kapat
        });
    }
}
