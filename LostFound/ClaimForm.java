import javax.swing.*;

public class ClaimForm {

    JFrame frame;

    public ClaimForm(String itemName) {

        frame = new JFrame("Claim Item");
        frame.setSize(350, 300);
        frame.setLayout(null);

        JLabel title = new JLabel("Claim Form");
        title.setBounds(130, 20, 150, 30);
        frame.add(title);

        JLabel itemLbl = new JLabel("Item: " + itemName);
        itemLbl.setBounds(50, 60, 250, 20);
        frame.add(itemLbl);

        JLabel nameLbl = new JLabel("Your Name:");
        nameLbl.setBounds(50, 100, 100, 20);
        frame.add(nameLbl);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 100, 120, 20);
        frame.add(nameField);

        JLabel qLbl = new JLabel("Verification Answer:");
        qLbl.setBounds(30, 140, 150, 20);
        frame.add(qLbl);

        JTextField answerField = new JTextField();
        answerField.setBounds(150, 140, 120, 20);
        frame.add(answerField);

        JButton submitBtn = new JButton("Submit Claim");
        submitBtn.setBounds(90, 190, 150, 30);
        frame.add(submitBtn);

        submitBtn.addActionListener(e -> {

            String name = nameField.getText();
            String answer = answerField.getText();

            if (name.isEmpty() || answer.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Fill all details!");
                return;
            }

            AppData.claimItems.add(itemName);
            AppData.claimAnswers.add(answer);

            JOptionPane.showMessageDialog(frame, "Claim Submitted for Verification!");

            frame.dispose();
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
