import javax.swing.*;

public class SecurityDashboard {

    JFrame frame;

    public SecurityDashboard() {
        frame = new JFrame("Security Dashboard");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel lbl = new JLabel("Security Dashboard");
        lbl.setBounds(130, 20, 200, 30);
        frame.add(lbl);

        JButton claimBtn = new JButton("Verify Claims");
        claimBtn.setBounds(120, 80, 150, 30);
        frame.add(claimBtn);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(20, 200, 80, 30);
        frame.add(backBtn);

        claimBtn.addActionListener(e -> {
            frame.dispose();
            new ClaimVerificationPage("Security");
        });

        backBtn.addActionListener(e -> {
            frame.dispose();
            new LoginScreen();
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
