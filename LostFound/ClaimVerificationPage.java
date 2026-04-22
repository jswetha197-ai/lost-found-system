import javax.swing.*;

public class ClaimVerificationPage {

    JFrame frame;
    JTextArea area;

    public ClaimVerificationPage(String role) {

        frame = new JFrame(role + " Claim Verification");
        frame.setSize(400, 350);
        frame.setLayout(null);

        JLabel title = new JLabel(role + " - Verify Claims");
        title.setBounds(90, 10, 250, 30);
        frame.add(title);

        area = new JTextArea();
        area.setBounds(40, 50, 300, 140);
        area.setEditable(false);
        frame.add(area);

        JButton approveBtn = new JButton("Approve");
        approveBtn.setBounds(70, 210, 100, 30);
        frame.add(approveBtn);

        JButton rejectBtn = new JButton("Reject");
        rejectBtn.setBounds(200, 210, 100, 30);
        frame.add(rejectBtn);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(20, 260, 80, 30);
        frame.add(backBtn);

        loadClaims();

        // ✅ APPROVE = move to history + remove from found
        approveBtn.addActionListener(e -> {

            if (AppData.claimItems.size() > 0) {

                String item = AppData.claimItems.remove(0);
                AppData.claimAnswers.remove(0);

                // ✅ Move to history
                AppData.history.add(item);

                // ✅ Also remove from found list
                if (AppData.lostItems.contains(item)) {
                    int index = AppData.lostItems.indexOf(item);
                    AppData.lostItems.remove(index);
                    AppData.categories.remove(index);
                }

                JOptionPane.showMessageDialog(frame, "Claim Approved!");
                loadClaims();
            }
        });

        // ❌ REJECT = remove claim only
        rejectBtn.addActionListener(e -> {

            if (AppData.claimItems.size() > 0) {
                AppData.claimItems.remove(0);
                AppData.claimAnswers.remove(0);

                JOptionPane.showMessageDialog(frame, "Claim Rejected!");
                loadClaims();
            }
        });

        backBtn.addActionListener(e -> {
            frame.dispose();
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void loadClaims() {

        String data = "";

        if (AppData.claimItems.size() == 0) {
            data = "No pending claims.";
        } else {
            for (int i = 0; i < AppData.claimItems.size(); i++) {
                data += "Item: " + AppData.claimItems.get(i) +
                        "\nAnswer: " + AppData.claimAnswers.get(i) +
                        "\n\n";
            }
        }

        area.setText(data);
    }
}
