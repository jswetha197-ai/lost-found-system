import javax.swing.*;
import java.awt.*;

public class StudentDashboard {

    JFrame frame;

    public StudentDashboard() {
        frame = new JFrame("Student Dashboard");
        frame.setSize(400, 350);
        frame.setLayout(null);

        // ✅ LIGHT BACKGROUND
        frame.getContentPane().setBackground(Color.WHITE);

        JLabel lbl = new JLabel("Student Dashboard");
        lbl.setBounds(120, 20, 200, 30);
        lbl.setFont(new Font("Arial", Font.BOLD, 16));
        lbl.setForeground(Color.BLACK);
        frame.add(lbl);

        JButton uploadBtn = new JButton("Upload Lost Item");
        uploadBtn.setBounds(120, 70, 150, 30);
        frame.add(uploadBtn);

        JButton foundBtn = new JButton("View Found Items");
        foundBtn.setBounds(120, 120, 150, 30);
        frame.add(foundBtn);

        JButton historyBtn = new JButton("History");
        historyBtn.setBounds(120, 170, 150, 30);
        frame.add(historyBtn);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(20, 240, 80, 30);
        frame.add(backBtn);

        // ---------- BUTTON ACTIONS ----------

        uploadBtn.addActionListener(e -> {
            frame.dispose();
            new UploadLostItem();
        });

        foundBtn.addActionListener(e -> {
            frame.dispose();
            new FoundItemsPage();
        });

        historyBtn.addActionListener(e -> {
            new HistoryPage();
        });

        backBtn.addActionListener(e -> {
            frame.dispose();
            new LoginScreen();
        });

        // ------------------------------------

        // ✅ ✅ ROLE-BASED ACCESS CONTROL (THIS IS THE LINE YOU ASKED ABOUT)
        if (AppData.currentRole.equals("Student")) {
            // Students have ONLY limited access
            // (Nothing extra is enabled here intentionally)
            // Later, this is where we would block admin-only buttons
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
