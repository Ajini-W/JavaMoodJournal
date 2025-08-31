package ui;

import db.DBConnection;
import util.SentimentAnalyzer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DashboardFrame extends JFrame {

    private int userId;

    public DashboardFrame(int userId) {
        this.userId = userId;

        setTitle("Mood Journal");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Write your thoughts below:", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JTextArea journalArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(journalArea);

        JButton saveButton = new JButton("Save Entry");
        saveButton.setFont(new Font("Arial", Font.PLAIN, 16));

        saveButton.addActionListener((ActionEvent e) -> {
            String text = journalArea.getText();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please write something before saving.");
                return;
            }

            String mood = SentimentAnalyzer.analyze(text);

            try (Connection conn = DBConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO entries (user_id, date, entry_text, mood) VALUES (?, CURDATE(), ?, ?)"
                );
                stmt.setInt(1, userId);
                stmt.setString(2, text);
                stmt.setString(3, mood);
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Mood saved: " + mood);
                journalArea.setText(""); // clear textarea after save

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error saving entry: " + ex.getMessage());
            }
        });

        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}
