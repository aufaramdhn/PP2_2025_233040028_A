package latihan.pertemuan5;

import javax.swing.*;
import java.io.*;
import java.awt.*;

public class AplikasiFileIO extends JFrame {
    private JTextArea textArea;
    private JButton btnOpenText, btnSaveText;
    private JButton btnSaveBinary, btnLoadBinary;
    private JButton btnSaveObject, btnLoadObject;
    private JButton btnAppendText;
    private JFileChooser fileChooser;


    public AplikasiFileIO() {
        // Konstruktor
        super("Tutorial File I/O & Exception Handling");

        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        fileChooser = new JFileChooser();

        JPanel buttonPanel = new JPanel();
        btnOpenText = new JButton("Open Text File");
        btnSaveText = new JButton("Save Text File");
        btnSaveBinary = new JButton("Save Binary File");
        btnLoadBinary = new JButton("Load Binary File");
        btnSaveObject = new JButton("Save User Config");
        btnLoadObject = new JButton("Load User Config");
        btnAppendText = new JButton("Append Text File");

        buttonPanel.add(btnAppendText);
        buttonPanel.add(btnOpenText);
        buttonPanel.add(btnSaveText);
        buttonPanel.add(btnSaveBinary);
        buttonPanel.add(btnLoadBinary);
        buttonPanel.add(btnSaveObject);
        buttonPanel.add(btnLoadObject);

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        btnOpenText.addActionListener(e -> bukaTextFile());
        btnSaveText.addActionListener(e -> simpanTextFile());
        btnSaveBinary.addActionListener(e -> simpanConfigBinary());
        btnLoadBinary.addActionListener(e -> muatConfigBinary());
        btnSaveObject.addActionListener(e -> simpanUserConfig());
        btnLoadObject.addActionListener(e -> muatUserConfig());
        btnAppendText.addActionListener(e -> appendTextFile());

        otomatisBukaFile();
    }

    private void otomatisBukaFile() {
        String filename = "C://Users//Ramad//IdeaProjects//pemrog2//src//latihan//pertemuan5//testFile.txt";

        try {
            FileInputStream fis = new FileInputStream(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            textArea.setText("");
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
            reader.close();

            JOptionPane.showMessageDialog(this, "Last note loaded successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No last note found.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void bukaTextFile()
    {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new FileReader(file));
                textArea.setText("");
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                JOptionPane.showMessageDialog(this, "File berhasil dimuat!.");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "File tidak ditemukan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error membaca file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (reader != null) reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void simpanTextFile() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "File berhasil disimpan!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error menyimpan file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void simpanConfigBinary() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("config.bin"))) {

            int fontSize = textArea.getFont().getSize();
            dos.writeInt(fontSize);

            JOptionPane.showMessageDialog(this, "File biner berhasil disimpan!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error menyimpan file biner: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void muatConfigBinary() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("config.bin"))) {

            int fontSize = dis.readInt();
            textArea.setFont(new Font("Monospaced", Font.PLAIN, fontSize));

            JOptionPane.showMessageDialog(this, "Font diubah menjadi ukuran: " + fontSize);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "File biner tidak ditemukan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error membaca file biner: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void simpanUserConfig() {
        String username = JOptionPane.showInputDialog(this, "Masukkan username:");

        if (username == null || username.isEmpty()) return;

        int fontSize = textArea.getFont().getSize();
        UserConfig config = new UserConfig(username, fontSize);

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("userconfig.ser"))) {

            oos.writeObject(config);
            JOptionPane.showMessageDialog(this, "UserConfig berhasil disimpan!");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Gagal menyimpan object: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void muatUserConfig() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("userconfig.ser"))) {

            UserConfig config = (UserConfig) ois.readObject();

            textArea.setFont(new Font("Monospaced", Font.PLAIN, config.getFontSize()));
            JOptionPane.showMessageDialog(this,
                    "Config dimuat!\nUsername: " + config.getUsername() +
                            "\nFont Size: " + config.getFontSize());

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this,
                    "File config tidak ditemukan!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,
                    "Gagal membaca object: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void appendTextFile() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedWriter writer =
                         new BufferedWriter(new FileWriter(file, true))) {

                writer.write("\n");
                writer.write(textArea.getText());

                JOptionPane.showMessageDialog(this,
                        "Text berhasil ditambahkan ke file!");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "Error append file: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AplikasiFileIO().setVisible(true);
        });
    }
}
