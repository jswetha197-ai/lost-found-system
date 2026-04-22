import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class UploadLostItem {

    JFrame frame;
    BufferedImage uploadedImage;   // stores selected image
    String imagePath = "";         // stores image path

    public UploadLostItem() {

        frame = new JFrame("Upload Lost Item");
        frame.setSize(400, 470);
        frame.setLayout(null);

        JLabel lbl = new JLabel("Upload Lost Item");
        lbl.setBounds(130, 20, 200, 30);
        lbl.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(lbl);

        JLabel n = new JLabel("Item Name:");
        n.setBounds(50, 70, 100, 20);
        frame.add(n);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 70, 150, 20);
        frame.add(nameField);

        JLabel d = new JLabel("Description:");
        d.setBounds(50, 110, 100, 20);
        frame.add(d);

        JTextField descField = new JTextField();
        descField.setBounds(150, 110, 150, 20);
        frame.add(descField);

        // ✅ CATEGORY DROPDOWN (NEW)
        JLabel c = new JLabel("Category:");
        c.setBounds(50, 150, 100, 20);
        frame.add(c);

        String[] categoryList = {"Electronics", "Wallet", "Ring", "Bag", "Other"};
        JComboBox<String> categoryBox = new JComboBox<>(categoryList);
        categoryBox.setBounds(150, 150, 150, 25);
        frame.add(categoryBox);

        // ---------- IMAGE UPLOAD ----------
        JLabel imgLabel = new JLabel("Upload Image:");
        imgLabel.setBounds(50, 190, 100, 20);
        frame.add(imgLabel);

        JButton chooseImgBtn = new JButton("Choose File");
        chooseImgBtn.setBounds(150, 190, 150, 25);
        frame.add(chooseImgBtn);

        // ✅ IMAGE PREVIEW LABEL
        JLabel imagePreview = new JLabel();
        imagePreview.setBounds(120, 230, 120, 80);
        imagePreview.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.add(imagePreview);

        chooseImgBtn.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try {
                    uploadedImage = ImageIO.read(file);
                    imagePath = file.getAbsolutePath();

                    // ✅ SHOW IMAGE PREVIEW
                    Image scaledImg = uploadedImage.getScaledInstance(120, 80, Image.SCALE_SMOOTH);
                    imagePreview.setIcon(new ImageIcon(scaledImg));

                    JOptionPane.showMessageDialog(frame, "Image uploaded successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error loading image.");
                }
            }
        });
        // ----------------------------------

        JButton uploadBtn = new JButton("Submit");
        uploadBtn.setBounds(120, 330, 150, 30);
        frame.add(uploadBtn);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(20, 370, 80, 30);
        frame.add(backBtn);

        // ---------- SUBMIT BUTTON ----------
        uploadBtn.addActionListener(e -> {

            String itemName = nameField.getText();
            String description = descField.getText();
            String selectedCategory = (String) categoryBox.getSelectedItem();

            if (itemName.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter item name!");
                return;
            }

            // ✅ Save item & category into AppData
            AppData.lostItems.add(itemName);
            AppData.categories.add(selectedCategory);

            JOptionPane.showMessageDialog(frame,
                    "Item Uploaded Successfully!\n\nName: " + itemName +
                            "\nDescription: " + description +
                            "\nCategory: " + selectedCategory +
                            "\nImage: " + (imagePath.isEmpty() ? "No Image" : "Selected"));

            // ✅ CLEAR EVERYTHING AFTER SUBMIT
            nameField.setText("");
            descField.setText("");
            uploadedImage = null;
            imagePath = "";
            imagePreview.setIcon(null);
        });
        // ----------------------------------

        backBtn.addActionListener(e -> {
            frame.dispose();
            new StudentDashboard();
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
