package game;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Viewmodell extends JFrame implements Runnable {
    private Snake sznek = new Snake();
    private Keyboard keyboard = new Keyboard(sznek);
    private ArrayList<Apple> apples = new ArrayList<>();
    private Drawer main;
    Position last = new Position(0, 0);
    private int tickrate = 300;
    private int tickcounter;
    private int lastspecial;
    private int currentscore = 0;
    private int basescore = 100;
    private static ArrayList<Score> highscores;
    private String player;

    /**
     * Létrehozza a JFrame kívánt megjelenítését, beállítja az attribútumait. Beállítja a megfelelő actionListenert.
     * @param _player a játékos neve
     */
    public Viewmodell(String _player) {
        player = _player;
        setTitle("SNAKE");
        setSize(12 * 30 + 14, 10 * 30 + 8);
        setBackground(Color.GREEN);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addKeyListener(keyboard);
        apples.add(new Apple(sznek, Color.RED, new Position(3, 2)));
        apples.add(new GreenApple(sznek, this, new Position(6 ,0)));
        apples.add(new GoldenApple(sznek, this, new Position(15, 16)));
        apples.add(new PoisonedApple(sznek, keyboard, new Position(15, 17)));
        main = new Drawer(sznek, apples);
        main.setSize(400, 400);
        main.setBackground(Color.BLACK);
        add(main);

    }

    public void setTickrate(int newtickrate) {
        tickrate = newtickrate;
    }

    public void setBasescore(int newbase) {
        basescore = newbase;
    }

    /**
     * A játék lefolyásáért felelős függvény. Létrehozza az objektumokat és kirajzoltatja őket, valamint lépteti a kígyót.
     */
    synchronized public void run() {
        highscores = load("scores");
        //highscores = new ArrayList<>();
        sznek.init();

        while (!sznek.collision()) {
            reduceTickCounter();
            sznek.move(sznek.getActual());
            checkAppleEaten();
            main.repaint();
            try {
                wait(tickrate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            last.setPosition(sznek.getSnake().get(sznek.getSnake().size() - 1));
        }

        MainFrame main = new MainFrame();

        handleNewScore();

        apples.get(lastspecial).countereffect();
        setVisible(false);
    }

    private void checkAppleEaten(){
        for (int i = 0; i < 4; i++) {
            Apple currentApple = apples.get(i);
            if (currentApple.isEaten()) {
                sznek.grow(last);
                lastspecial = currentApple.effect(i, lastspecial);
                currentApple.spawn();
                currentscore += basescore;
                if (i == lastspecial) {
                    tickcounter = 50;
                }
            }
        }
    }

    private void reduceTickCounter(){
        tickcounter--;
        if (tickcounter == 20)
            apples.get(lastspecial).countereffect();
        if (tickcounter == 0)
            apples.get((int) (Math.random() * 3) + 1).pickNewPosition();
    }

    private void handleNewScore(){
        highscores.add(new Score(player, currentscore));
        list(highscores);
        for (int i = 0; i < highscores.size(); i++)
            System.out.println(highscores.get(i).toString());
        save("scores", highscores);
        currentscore = 0;
    }

    /**
     * Elmenti a legjobb eredményeket.
     * @param file a mentés helye
     * @param scores az eredmények tömbje
     */
    public static void save(String file, ArrayList<Score> scores) {
        try {
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(scores);
            o.close();
        } catch (IOException e) {
        }
    }

    /**
     * betölti fájlból az elmentett legjobb eredményeket.
     * @param file a mentés helye
     * @return az eredmények tömbje
     */
    public static ArrayList<Score> load(String file) {
        try {
            FileInputStream f = new FileInputStream(file);
            ObjectInputStream i = new ObjectInputStream(f);
            ArrayList<Score> scores = new ArrayList<>();
            scores = (ArrayList<Score>) i.readObject();
            return scores;
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        return null;
    }

    public ArrayList<Score> getHighscores() {
        return highscores;
    }

    /**
     * Rendezi az eredmények tömbjét, és csak a legjobb 5 eredményt tárolja el.
     * @param scores az eredmények tömbje.
     */
    public void list(ArrayList<Score> scores) {
        Collections.sort(scores, (b1, b2) -> Integer.compare(b1.getHighscore(), b2.getHighscore()));
        if (scores.size() > 5) {
            scores.remove(0);
        }
    }
    public int getBasescore(){
        return basescore;
    }
    public int getTickrate(){
        return tickrate;
    }
}
