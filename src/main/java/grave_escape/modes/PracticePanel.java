package grave_escape.modes;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import grave_escape.game.Game;
import grave_escape.game.GameFactory;
import grave_escape.levels.Difficulty;
import grave_escape.levels.GameLevel;
import grave_escape.levels.GameMode;

/**
 * modes.PracticePanel class represents the practice section of the menu.
 * It allows the player to select a difficulty and certain level to play independently for practice.
 */
public class PracticePanel extends JPanel {
    /**
     * A layout manager for organizing multiple components (cards) within a single container.
     */
    private CardLayout cardLayout;
    /**
     * The primary panel used as the container for the application components.
     */
    private JPanel mainPanel;
    /**
     * Represents the current difficulty level of the game or application.
     * Initialized to {@code Difficulty.EASY}.
     */
    private Difficulty difficulty = Difficulty.EASY;

    // Components
    /**
     * A button for selecting the "Easy" difficulty level.
     */
    JButton easyButton;
    /**
     * A button for selecting the "Normal" difficulty level.
     */
    JButton normalButton;
    /**
     * A button for selecting the "Hard" difficulty level.
     */
    JButton hardButton;

    /**
     * A button for selecting Level One.
     */
    JButton oneButton;
    /**
     * A button for selecting Level Two.
     */
    JButton twoButton;
    /**
     * A button for selecting Level Three.
     */
    JButton threeButton;
    /**
     * An image used as the background for the Practice Menu panel.
     */
    private Image backgroundImage;

    /**
     * Constructor for the modes.PracticePanel class.
     * @param cardLayout: The CardLayout used for switching panels
     * @param mainPanel: The main JPanel containing all cards (panels)
     */
    public PracticePanel(CardLayout cardLayout, JPanel mainPanel){
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        backgroundImage = new ImageIcon(getClass().getResource("/Menu/menu_background.png")).getImage();

        setLayout(null);

        drawBorderedTextBox("Practice", new Rectangle(100, 50, 200, 50), 25);
        drawDifficulties();
        drawLevelSelector();

        JButton returnButton = drawButton("Return to Main Menu", new Rectangle(50, 600, 200, 50), 15);
        returnButton.addActionListener(e -> showPanel("Menu"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Paint the panel as usual
        // Draw the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    /**
     * Method that draws bordered text boxes
     * @param text: The text to be added
     * @param location: Location on the panel which text box will go
     * @param fontSize: Font size of text
     */
    public void drawBorderedTextBox(String text, Rectangle location, int fontSize){
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        panel.setBounds(location);
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, fontSize));
        label.setForeground(Color.white);
        panel.add(label, BorderLayout.CENTER);
        add(panel);
    }

    /**
     * Creates and returns a button with specified text, location, and font size.
     * @param text: The text to be displayed on the button.
     * @param location: The location and size of the button on the panel.
     * @param fontSize: The font size of the button text.
     * @return The JButton created
     */
    public JButton drawButton(String text, Rectangle location, int fontSize){
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, fontSize));
        button.setBounds(location);
        add(button);
        return button;
    }

    /**
     * Function to draw difficulty selector title, box, and buttons respective to each difficulty.
     */
    public void drawDifficulties(){
        // Draw text
        JLabel difficultyTitle = new JLabel("Difficulty Selection");
        difficultyTitle.setFont(new Font("Arial", Font.BOLD, 20));
        difficultyTitle.setForeground(Color.white);
        difficultyTitle.setBounds(50, 125, 300, 50);
        add(difficultyTitle, BorderLayout.CENTER);
        // Draw border
        JPanel difficultyPanel = new JPanel();
        difficultyPanel.setOpaque(false);
        difficultyPanel.setLayout(null);
        difficultyPanel.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        difficultyPanel.setBounds(50, 175, 300, 300);
        // Draw difficulty buttons
        easyButton = drawButton("Easy", new Rectangle(50, 50, 200, 50), 20);
        easyButton.setName("Easy");
        difficultyPanel.add(easyButton);
        easyButton.addActionListener(e -> {
            difficulty = Difficulty.EASY;
            oneButton.setText("Level One - " + difficulty.name());
            twoButton.setText("Level Two - " + difficulty.name());
            threeButton.setText("Level Three - " + difficulty.name());
        });

        normalButton = drawButton("Normal", new Rectangle(50, 125, 200, 50), 20);
        normalButton.setName("Normal");
        difficultyPanel.add(normalButton);
        normalButton.addActionListener(e -> {
            difficulty = Difficulty.NORMAL;
            oneButton.setText("Level One - " + difficulty.name());
            twoButton.setText("Level Two - " + difficulty.name());
            threeButton.setText("Level Three - " + difficulty.name());
        });

        hardButton = drawButton("Hard", new Rectangle(50, 200, 200, 50), 20);
        hardButton.setName("Hard");
        difficultyPanel.add(hardButton);
        hardButton.addActionListener(e -> {
            difficulty = Difficulty.HARD;
            oneButton.setText("Level One - " + difficulty.name());
            twoButton.setText("Level Two - " + difficulty.name());
            threeButton.setText("Level Three - " + difficulty.name());
        });

        add(difficultyPanel);
    }

    /**
     * Function to draw level selector title, box, and buttons respective to each level.
     */
    public void drawLevelSelector(){
        // Draw text
        JLabel selectorTitle = new JLabel("Select Your Level:");
        selectorTitle.setFont(new Font("Arial", Font.BOLD, 30));
        selectorTitle.setForeground(Color.white);
        selectorTitle.setBounds(530, 125, 700, 50);
        add(selectorTitle, BorderLayout.CENTER);

        // Draw border
        JPanel selectorPanel = new JPanel();
        selectorPanel.setOpaque(false);
        selectorPanel.setLayout(null);
        selectorPanel.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        selectorPanel.setBounds(530, 175, 700, 300);

        // Game factory class to create multiple game levels
        GameFactory gameFactory = new GameFactory(cardLayout, mainPanel, GameMode.PRACTICE);

        // Add level buttons
        oneButton = drawButton("Level One - " + difficulty.name(), new Rectangle(50, 50, 600, 50), 20);
        oneButton.setName("Level One");
        selectorPanel.add(oneButton);
        oneButton.addActionListener(e -> {
            Game game = gameFactory.createGame(difficulty, GameLevel.Level1);
            game.startGame();
        });

        twoButton = drawButton("Level Two - " + difficulty.name(), new Rectangle(50, 125, 600, 50), 20);
        twoButton.setName("Level Two");
        selectorPanel.add(twoButton);
        twoButton.addActionListener(e -> {
            Game game = gameFactory.createGame(difficulty, GameLevel.Level2);
            game.startGame();
        });

        threeButton = drawButton("Level Three - " + difficulty.name(), new Rectangle(50, 200, 600, 50), 20);
        threeButton.setName("Level Three");
        selectorPanel.add(threeButton);
        threeButton.addActionListener(e -> {
            Game game = gameFactory.createGame(difficulty, GameLevel.Level3);
            game.startGame();
        });
        add(selectorPanel);
    }

    /**
     * Shows a specified panel based on the panel name provided.
     * @param panelName The name of the panel to be displayed.
     */
    private void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }
}
