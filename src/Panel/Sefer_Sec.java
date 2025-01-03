package Panel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;

public class Sefer_Sec extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public Sefer_Sec(String nereden, String nereye, String tarih) {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 641, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Uçuş seçenekleri için RadioButtonlar
        JRadioButton bilet1Radio = new JRadioButton("09:00 - Economy - 500 TL");
        bilet1Radio.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bilet1Radio.setBounds(152, 126, 300, 30);
        contentPane.add(bilet1Radio);

        JRadioButton bilet2Radio = new JRadioButton("12:00 - EconomyPlus - 800 TL");
        bilet2Radio.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bilet2Radio.setBounds(152, 187, 300, 30);
        contentPane.add(bilet2Radio);

        JRadioButton bilet3Radio = new JRadioButton("18:00 - Economy - 600 TL");
        bilet3Radio.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bilet3Radio.setBounds(152, 257, 300, 30);
        contentPane.add(bilet3Radio);

        // RadioButtonları gruplama (aynı anda sadece bir tanesi seçilebilir)
        ButtonGroup biletGroup = new ButtonGroup();
        biletGroup.add(bilet1Radio);
        biletGroup.add(bilet2Radio);
        biletGroup.add(bilet3Radio);

        // Bileti Seç Butonu
        JButton biletSecButton = new JButton("Bileti Seç");
        biletSecButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        biletSecButton.setBounds(436, 500, 150, 30);
        contentPane.add(biletSecButton);

        // Dinleyici ekle
        biletSecButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String secilenBilet = null;

                if (bilet1Radio.isSelected()) {
                    secilenBilet = "09:00,Economy,500 TL";
                } else if (bilet2Radio.isSelected()) {
                    secilenBilet = "12:00,EconomyPlus,800 TL";
                } else if (bilet3Radio.isSelected()) {
                    secilenBilet = "18:00,Economy,600 TL";
                }

                if (secilenBilet != null) {
                    // Seçilen bileti bilet.txt dosyasına mevcut satırın sonuna ekle
                    File file = new File("bilet.txt");

                    try {
                        StringBuilder updatedContent = new StringBuilder();
                        boolean foundMatch = false;

                        if (file.exists()) {
                            BufferedReader reader = new BufferedReader(new FileReader(file));
                            String line;

                            while ((line = reader.readLine()) != null) {
                                if (line.contains(nereden + "," + nereye + "," + tarih)) {
                                    foundMatch = true;
                                    line += "," + secilenBilet;
                                }
                                updatedContent.append(line).append(System.lineSeparator());
                            }
                            reader.close();
                        }

                        if (!foundMatch) {
                            updatedContent.append(nereden).append(",").append(nereye).append(",").append(tarih).append(",").append(secilenBilet).append(System.lineSeparator());
                        }

                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        writer.write(updatedContent.toString().trim());
                        writer.close();

                        JOptionPane.showMessageDialog(contentPane, "Bilet seçimi başarılı!");

                        // Yolcu Bilgileri Paneline geçiş yap
                        Yolcu_Bilgileri yolcuBilgileriFrame = new Yolcu_Bilgileri();
                        yolcuBilgileriFrame.setVisible(true);
                        dispose(); // Bu pencereyi kapat
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(contentPane, "Bilet kaydedilemedi.", "Hata", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Lütfen bir uçuş seçin.", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Geri Dön butonu
        JButton geriDonButton = new JButton("Geri Dön");
        geriDonButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        geriDonButton.setBounds(88, 500, 150, 30);
        contentPane.add(geriDonButton);

        geriDonButton.addActionListener(e -> {
            Sefer_Ara seferAraFrame = new Sefer_Ara();
            seferAraFrame.setVisible(true);
            dispose();
        });

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 91, 617, 2);
        contentPane.add(separator);
        
        JLabel lblNewLabel = new JLabel("Uçuş saati ve Sınıf türünü seçiniz");
        lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 35));
        lblNewLabel.setBounds(57, 23, 512, 58);
        contentPane.add(lblNewLabel);
    }
}
