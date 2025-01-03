package Panel;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class Koltuk_Sec extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String selectedSeat = "";

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

    public Koltuk_Sec() {
        setResizable(false);
        setBackground(SystemColor.info);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 417, 800);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.scrollbar);
        contentPane.setForeground(SystemColor.info);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JToggleButton[] koltukButtons = {
            new JToggleButton("1A"), new JToggleButton("1B"),
            new JToggleButton("2A"), new JToggleButton("2B"),
            new JToggleButton("3A"), new JToggleButton("3B"),
            new JToggleButton("4A"), new JToggleButton("4B"),
            new JToggleButton("5A"), new JToggleButton("5B"),
            new JToggleButton("6A"), new JToggleButton("6B"),
            new JToggleButton("7A"), new JToggleButton("7B"),
            new JToggleButton("8A"), new JToggleButton("8B")
        };

        int x = 147, y = 121;
        int counter = 0;
        for (JToggleButton button : koltukButtons) {
            button.setBounds(x, y, 49, 44);
            button.setOpaque(true);
            button.setBackground(SystemColor.scrollbar);
            contentPane.add(button);
            x += 58;
            counter++;
            if (counter % 2 == 0) {
                x = 147;
                y += 54;
            }
        }

        for (JToggleButton button : koltukButtons) {
            button.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (button.isSelected()) {
                        button.setBackground(Color.RED);
                        selectedSeat = button.getText();
                        for (JToggleButton otherButton : koltukButtons) {
                            if (otherButton != button) {
                                otherButton.setSelected(false);
                                otherButton.setBackground(SystemColor.scrollbar);
                            }
                        }
                    } else {
                        button.setBackground(SystemColor.scrollbar);
                        if (selectedSeat.equals(button.getText())) {
                            selectedSeat = "";
                        }
                    }
                }
            });
        }

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(10, 10, 370, 671);
        lblNewLabel.setBackground(SystemColor.activeCaptionBorder);
        lblNewLabel.setIcon(new ImageIcon(Koltuk_Sec.class.getResource("/images/ucaksonnn.png")));
        contentPane.add(lblNewLabel);

        JButton geriDonButton = new JButton("Geri Dön");
        geriDonButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        geriDonButton.setBounds(20, 691, 150, 30);
        geriDonButton.addActionListener(e -> {
            try {
                File file = new File("bilet.txt");
                if (file.exists()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    StringBuilder newContent = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        if (line.contains(",Economy,") || line.contains(",EconomyPlus,")) {
                            int index = Math.max(line.indexOf(",Economy,"), line.indexOf(",EconomyPlus,"));
                            newContent.append(line.substring(0, index + 19)).append(System.lineSeparator());
                        }
                    }

                    reader.close();

                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(newContent.toString().trim());
                    writer.close();
                }

                Yolcu_Bilgileri yolcuBilgileriFrame = new Yolcu_Bilgileri();
                yolcuBilgileriFrame.setVisible(true);
                dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Dosya işlemi sırasında bir hata oluştu!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });
        contentPane.add(geriDonButton);

        JButton btnBiletiOnayla = new JButton("Bileti Onayla");
        btnBiletiOnayla.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnBiletiOnayla.setBounds(240, 691, 150, 30);
        btnBiletiOnayla.addActionListener(e -> {
            if (!selectedSeat.isEmpty()) {
                try {
                    File file = new File("bilet.txt");
                    if (!file.exists()) {
                        JOptionPane.showMessageDialog(this, "Bilet dosyası bulunamadı!", "Hata", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    StringBuilder fileContent = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        if (!line.trim().isEmpty()) {
                            fileContent.append(line).append(", Koltuk: ").append(selectedSeat).append(" | ").append(System.lineSeparator());
                        }
                    }
                    
                    reader.close();

                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(fileContent.toString().trim());
                    writer.close();

                    JOptionPane.showMessageDialog(this, "Bilet Onaylandı!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);

                    // Menu Jframe'ine yönlendirme
                    Menu menuFrame = new Menu();
                    menuFrame.setVisible(true);
                    dispose();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Dosya yazma hatası!", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Lütfen bir koltuk seçin!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });
        contentPane.add(btnBiletiOnayla);
    }
}
