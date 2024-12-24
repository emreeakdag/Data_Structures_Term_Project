package Panel;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Ucus_Sorgu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;

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

        JLabel lblTitle = new JLabel("Uçuş Sorgu");
        lblTitle.setFont(new Font("Sylfaen", Font.BOLD, 30));
        lblTitle.setBounds(50, 45, 248, 42);
        contentPane.add(lblTitle);

        JLabel lblTc = new JLabel("T.C");
        lblTc.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTc.setBounds(50, 97, 136, 27);
        contentPane.add(lblTc);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(50, 134, 176, 30);
        contentPane.add(textField);

        // Restrict input to digits only and limit to 11 characters
        textField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) || textField.getText().length() >= 11) {
                    evt.consume();
                }
            }
        });

        JButton btnSorgula = new JButton("Sorgula");
        btnSorgula.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnSorgula.setBounds(538, 467, 189, 44);
        contentPane.add(btnSorgula);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 200, 677, 200);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        scrollPane.setViewportView(textArea);

        btnSorgula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tc = textField.getText();
                if (tc.length() != 11) {
                    JOptionPane.showMessageDialog(null, "T.C. kimlik numarası 11 rakamdan oluşmalıdır!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                } else {
                    LinkedList<String> biletler = new LinkedList<>();
                    try (BufferedReader br = new BufferedReader(new FileReader("bilet.txt"))) {
                        StringBuilder currentBilet = new StringBuilder();
                        int index = 0;
                        int matchedIndex = -1;

                        String line;
                        while ((line = br.readLine()) != null) {
                            for (char c : line.toCharArray()) {
                                if (c == '|') {
                                    biletler.add(currentBilet.toString());
                                    if (currentBilet.toString().contains(tc)) {
                                        matchedIndex = index;
                                    }
                                    currentBilet = new StringBuilder();
                                    index++;
                                } else {
                                    currentBilet.append(c);
                                }
                            }
                        }

                        if (matchedIndex != -1) {
                            String matchedBilet = biletler.get(matchedIndex);
                            String formattedBilet = matchedBilet.replace(",", "\n");
                            textArea.setText("Bilet Bilgileri:\n" + formattedBilet);
                        } else {
                            textArea.setText("Girilen T.C. kimlik numarası ile eşleşen bilet bulunamadı.");
                        }

                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Dosya okuma hatası: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        JButton btnGeriDon = new JButton("Geri Dön");
        btnGeriDon.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnGeriDon.setBounds(50, 467, 189, 44);
        contentPane.add(btnGeriDon);

        btnGeriDon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu menuFrame = new Menu();
                menuFrame.setVisible(true);
                dispose();
            }
        });
    }
}
