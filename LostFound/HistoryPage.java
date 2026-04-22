import javax.swing.*;

public class HistoryPage {

    JFrame frame;
    JTextArea area;

    public HistoryPage() {

        frame = new JFrame("Claim History");
        frame.setSize(400, 350);
        frame.setLayout(null);

        JLabel title = new JLabel("Claimed Items History");
        title.setBounds(110, 20, 200, 30);
        frame.add(title);

        area = new JTextArea();
        area.setBounds(50, 70, 280, 170);
        area.setEditable(false);
        frame.add(area);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(20, 260, 80, 30);
        frame.add(backBtn);

        backBtn.addActionListener(e -> {
            frame.dispose();
        });

        loadHistory();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void loadHistory() {
        String data = "";

        if (AppData.history.size() == 0) {
            data = "No items claimed yet.";
        } else {
            for (String item : AppData.history) {
                data = data + item + "\n";
            }
        }

        area.setText(data);
    }
}
