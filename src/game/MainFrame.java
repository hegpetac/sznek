package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton play = new JButton("PLAY!");
    private JButton scores = new JButton("VIEW SCORES");
    private JLabel name = new JLabel("Player name:");
    private JTextField text = new JTextField("", 20);
    private JPanel pan = new JPanel();
    private JPanel pan2 = new JPanel();

    /**
     * Létrehozza a JFrame kívánt megjelenítését, beállítja az attribútumait és létrehozza a szükséges actionlistenereket.
     */
    public MainFrame(){
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("SNAKE MENU");
        setSize(12 * 30 + 14, 10 * 30 + 8);
        play.setActionCommand("play");
        scores.setActionCommand("view");
        play.addActionListener(e -> {
            String name = text.getText();
            System.out.println(name);
            dispose();

            Thread thread = new Thread(new Viewmodell(name));
            thread.start();
        });
        scores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ScoresFrame scoresFrame = new ScoresFrame();
            }
        });
        pan.add(play);
        pan.add(scores);
        pan2.add(name);
        pan2.add(text);
        add(pan, BorderLayout.CENTER);
        add(pan2, BorderLayout.SOUTH);
    }


    public static void main(String[] args) {
        MainFrame main = new MainFrame();
    }
}
