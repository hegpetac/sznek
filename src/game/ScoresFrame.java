package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ScoresFrame extends JFrame {
    private JList<String> scores;
    private JButton back = new JButton("BACK");
    JPanel pan = new JPanel();
    private ArrayList<Score> highscores;

    /**
     * Létrehozza a JFrame kívánt megjelenítését, beállítja az attribútumait és létrehozza a szükséges actionlistenereket. Megjelíti az elért legjobb eredményeket csökkenő sorrendben.
     */
    public ScoresFrame(){
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("SCORES");
        setSize(12*30 + 14, 10*30 + 8);
        back.setActionCommand("back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainFrame main = new MainFrame();
            }
        });
        highscores = load("scores");
        Collections.reverse(highscores);
        ArrayList<String> strings = new ArrayList<>();
        for(int i = 0; i < highscores.size(); i++){
            strings.add(highscores.get(i).toString());
        }
        scores = new JList(strings.toArray());
        pan.add(scores);
        pan.add(back);
        add(pan);

    }

    /**
     * betölti fájlból az elmentett legjobb eredményeket.
     * @param file a mentés helye
     * @return eredmények tömbje
     */
    protected static ArrayList<Score> load(String file){
        try{
            FileInputStream f = new FileInputStream(file);
            ObjectInputStream i = new ObjectInputStream(f);
            ArrayList<Score> scores = new ArrayList<>();
            scores = (ArrayList<Score>)i.readObject();
            return scores;
        } catch(IOException e){ }
        catch(ClassNotFoundException e){ }
        return null;
    }
}
