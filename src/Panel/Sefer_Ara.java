package Panel;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class Sefer_Ara extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    // Kullanıcı seçimlerini kaydetmek için statik değişkenler
    protected static String secilenNereden = "İstanbul";
    protected static String secilenNereye = "Ankara";
    protected static Date secilenTarih = new Date();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Sefer_Ara frame = new Sefer_Ara();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Sefer_Ara() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel nereden_label = new JLabel("Nereden");
        nereden_label.setFont(new Font("Tahoma", Font.PLAIN, 30));
        nereden_label.setBounds(125, 50, 120, 40);
        contentPane.add(nereden_label);

        JLabel nereye_label = new JLabel("Nereye");
        nereye_label.setFont(new Font("Tahoma", Font.PLAIN, 30));
        nereye_label.setBounds(500, 50, 120, 40);
        contentPane.add(nereye_label);

        ArrayList<String> sehirler = new ArrayList<>();
        sehirler.add("İstanbul");
        sehirler.add("Ankara");
        sehirler.add("İzmir");
        sehirler.add("Antalya");
        sehirler.add("Adana");

        JComboBox<String> nereden_comboBox = new JComboBox<>();
        nereden_comboBox.setModel(new DefaultComboBoxModel<>(sehirler.toArray(new String[0])));
        nereden_comboBox.setBounds(125, 100, 200, 30);
        contentPane.add(nereden_comboBox);

        JComboBox<String> nereye_comboBox = new JComboBox<>();
        nereye_comboBox.setModel(new DefaultComboBoxModel<>(sehirler.toArray(new String[0])));
        nereye_comboBox.setBounds(500, 100, 200, 30);
        contentPane.add(nereye_comboBox);

        JDateChooser tarih_secici = new JDateChooser();
        tarih_secici.setBounds(210, 310, 188, 25);
        contentPane.add(tarih_secici);

        JLabel tarih_label = new JLabel("Tarih");
        tarih_label.setFont(new Font("Tahoma", Font.PLAIN, 30));
        tarih_label.setBounds(125, 300, 82, 40);
        contentPane.add(tarih_label);

        // Seçimleri yükle
        nereden_comboBox.setSelectedItem(secilenNereden);
        nereye_comboBox.setSelectedItem(secilenNereye);
        tarih_secici.setDate(secilenTarih);

        JButton ucus_ara_buton = new JButton("Uçuş Ara");
        ucus_ara_buton.addActionListener(e -> {
            String nereden = (String) nereden_comboBox.getSelectedItem();
            String nereye = (String) nereye_comboBox.getSelectedItem();
            Date selectedDate = tarih_secici.getDate();
            Date today = new Date();

            if (selectedDate == null) {
                JOptionPane.showMessageDialog(contentPane, "Lütfen bir tarih seçin.", "Hata", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (selectedDate.before(today)) {
                JOptionPane.showMessageDialog(contentPane, "Geçmiş bir tarih seçemezsiniz.", "Hata", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Seçimleri kaydet
            secilenNereden = nereden;
            secilenNereye = nereye;
            secilenTarih = selectedDate;

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String tarih = dateFormat.format(selectedDate);

            if (nereden != null && nereye != null) {
                Sefer_Sec seferSecFrame = new Sefer_Sec(nereden, nereye, tarih);
                seferSecFrame.setVisible(true);
                dispose(); // Mevcut pencereyi kapat
            }
        });
        ucus_ara_buton.setBounds(523, 300, 149, 59);
        contentPane.add(ucus_ara_buton);

        nereden_comboBox.addActionListener(e -> {
            String selectedCity = (String) nereden_comboBox.getSelectedItem();
            ArrayList<String> updatedSehirler = new ArrayList<>(sehirler);
            updatedSehirler.remove(selectedCity);
            nereye_comboBox.setModel(new DefaultComboBoxModel<>(updatedSehirler.toArray(new String[0])));

            // Kaydedilen 'Nereye' değeri varsa seçimi koru
            if (updatedSehirler.contains(secilenNereye)) {
                nereye_comboBox.setSelectedItem(secilenNereye);
            }
        });
    }
}
