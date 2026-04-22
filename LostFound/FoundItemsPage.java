import javax.swing.*;

public class FoundItemsPage {

    JFrame frame;
    JTextArea list;
    JComboBox<String> filterBox;

    public FoundItemsPage() {

        frame = new JFrame("Found Items");
        frame.setSize(400, 350);
        frame.setLayout(null);

        JLabel lbl = new JLabel("Found Items");
        lbl.setBounds(150, 10, 200, 30);
        frame.add(lbl);

        // ✅ CATEGORY FILTER
        String[] filterList = {"All", "Electronics", "Wallet", "Ring", "Bag", "Other"};
        filterBox = new JComboBox<>(filterList);
        filterBox.setBounds(30, 50, 120, 25);
        frame.add(filterBox);

        list = new JTextArea();
        list.setBounds(30, 90, 320, 140);
        list.setEditable(false);
        frame.add(list);

        JButton claimBtn = new JButton("Claim First Item");
        claimBtn.setBounds(110, 240, 160, 30);
        frame.add(claimBtn);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(20, 285, 80, 30);
        frame.add(backBtn);

        // ✅ FILTER LOGIC
        filterBox.addActionListener(e -> loadItems());

        // ✅ CLAIM LOGIC (opens claim form)
        claimBtn.addActionListener(e -> {

            if (AppData.lostItems.size() == 0) {
                JOptionPane.showMessageDialog(frame, "No items to claim");
                return;
            }

            String selectedItem = AppData.lostItems.get(0);
            new ClaimForm(selectedItem);
        });

        backBtn.addActionListener(e -> {
            frame.dispose();
            new StudentDashboard();
        });

        loadItems(); // load data at start

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // ✅ LOAD & FILTER ITEMS FROM AppData
    void loadItems() {

        String selectedFilter = (String) filterBox.getSelectedItem();
        String data = "";

        for (int i = 0; i < AppData.lostItems.size(); i++) {

            String item = AppData.lostItems.get(i);
            String category = AppData.categories.get(i);

            if (selectedFilter.equals("All") || category.equals(selectedFilter)) {
                data = data + item + " - " + category + "\n";
            }
        }

        list.setText(data);
    }
}
