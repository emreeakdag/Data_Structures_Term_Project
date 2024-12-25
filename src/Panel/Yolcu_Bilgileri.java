package Panel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.io.*;

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
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

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

        JLabel lblIsim = new JLabel("İsim:");
        lblIsim.setBounds(50, 100, 80, 30);
        contentPane.add(lblIsim);
        tfIsim = new JTextField();
        tfIsim.setBounds(140, 100, 200, 30);
        tfIsim.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!Character.isLetter(e.getKeyChar()) && !Character.isWhitespace(e.getKeyChar())) {
                    e.consume();
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
                    e.consume();
                }
            }
        });
        contentPane.add(tfSoyisim);

        JLabel lblDogumTarihi = new JLabel("Doğum Tarihi:");
        lblDogumTarihi.setBounds(50, 200, 100, 30);
        contentPane.add(lblDogumTarihi);
        tfDogumTarihi = new JTextField();
        tfDogumTarihi.setBounds(140, 200, 200, 30);
        tfDogumTarihi.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '/') {
                    e.consume();
                }
                if (tfDogumTarihi.getText().length() >= 10) {
                    e.consume();
                }
            }
        });
        contentPane.add(tfDogumTarihi);

        JLabel lblTcKimlik = new JLabel("TC Kimlik No:");
        lblTcKimlik.setBounds(50, 250, 100, 30);
        contentPane.add(lblTcKimlik);
        tfTcKimlik = new JTextField();
        tfTcKimlik.setBounds(140, 250, 200, 30);
        tfTcKimlik.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (tfTcKimlik.getText().length() >= 11) {
                    e.consume();
                }
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });
        contentPane.add(tfTcKimlik);

        JLabel lblEmail = new JLabel("E-posta:");
        lblEmail.setBounds(50, 300, 80, 30);
        contentPane.add(lblEmail);
        tfEmail = new JTextField();
        tfEmail.setBounds(140, 300, 200, 30);
        contentPane.add(tfEmail);

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
                    e.consume();
                }
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '+') {
                    e.consume();
                }
            }
        });
        contentPane.add(tfTelefon);

        JButton devamButton = new JButton("Devam Et");
        devamButton.setBounds(300, 500, 150, 30);
        devamButton.addActionListener(e -> {
            boolean isValid = true;

            if (!rbBay.isSelected() && !rbBayan.isSelected()) {
                JOptionPane.showMessageDialog(this, "Cinsiyet seçmediniz!", "Hata", JOptionPane.ERROR_MESSAGE);
                isValid = false;
            }

            if (tfIsim.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "İsim girmediniz!", "Hata", JOptionPane.ERROR_MESSAGE);
                isValid = false;
            }

            if (tfSoyisim.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Soyisim girmediniz!", "Hata", JOptionPane.ERROR_MESSAGE);
                isValid = false;
            }

            if (!tfDogumTarihi.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
                JOptionPane.showMessageDialog(this, "Doğum tarihini gün/ay/yıl formatında ve eksiksiz giriniz!", "Hata", JOptionPane.ERROR_MESSAGE);
                isValid = false;
            }

            if (tfEmail.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "E-posta girmediniz!", "Hata", JOptionPane.ERROR_MESSAGE);
                isValid = false;
            }

            if (tfTcKimlik.getText().length() != 11) {
                JOptionPane.showMessageDialog(this, "TC kimliğinizi eksik girdiniz!", "Hata", JOptionPane.ERROR_MESSAGE);
                isValid = false;
            }

            if (tfTelefon.getText().length() < 13) {
                JOptionPane.showMessageDialog(this, "Telefon numaranızı eksik girdiniz!", "Hata", JOptionPane.ERROR_MESSAGE);
                isValid = false;
            }

            if (isValid) {
                try {
                    File file = new File("bilet.txt");
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    StringBuilder fileContent = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        fileContent.append(line);
                    }

                    reader.close();

                    String cinsiyet = rbBay.isSelected() ? "Bay" : "Bayan";
                    String yolcuBilgileri = String.format(",%s,%s,%s,%s,%s,%s,%s", cinsiyet, tfIsim.getText(), tfSoyisim.getText(),
                            tfDogumTarihi.getText(), tfTcKimlik.getText(), tfEmail.getText(), tfTelefon.getText());

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                        writer.write(fileContent.toString() + yolcuBilgileri);
                        writer.newLine();
                    }

                    JOptionPane.showMessageDialog(this, "Bilgiler kaydedildi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);

                    Koltuk_Sec koltukSecFrame = new Koltuk_Sec();
                    koltukSecFrame.setVisible(true);
                    dispose();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Dosya yazma hatası!", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        contentPane.add(devamButton);

        JButton geriDonButton = new JButton("Geri Dön");
        geriDonButton.setBounds(50, 500, 150, 30);
        contentPane.add(geriDonButton);

        geriDonButton.addActionListener(e -> {
            Sefer_Sec seferSecFrame = new Sefer_Sec("İstanbul", "Ankara", "01/01/2025"); // Örnek veri
            seferSecFrame.setVisible(true);
            dispose();
        });
    }
}
