import javax.swing.*;

public class LoginScreen {

    JFrame frame;

    public LoginScreen() {
        frame = new JFrame("Login");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel lbl = new JLabel("Select Your Role:");
        lbl.setBounds(160, 20, 150, 30);
        frame.add(lbl);

        JButton studentBtn = new JButton("Student");
        studentBtn.setBounds(140, 70, 120, 30);
        frame.add(studentBtn);

        JButton adminBtn = new JButton("Admin");
        adminBtn.setBounds(140, 120, 120, 30);
        frame.add(adminBtn);

        JButton secBtn = new JButton("Security");
        secBtn.setBounds(140, 170, 120, 30);
        frame.add(secBtn);

        studentBtn.addActionListener(e -> {
            AppData.currentRole = "Student";
            new StudentDashboard();
            frame.dispose();
        });
        adminBtn.addActionListener(e -> {
            frame.dispose();
            new AdminDashboard();
            frame.dispose();
        });

        secBtn.addActionListener(e -> {
            frame.dispose();
            new SecurityDashboard();
            frame.dispose();
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
