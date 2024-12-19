package grave_escape.modes;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;

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
import grave_escape.objectives.HighestResult;

/**
 * Represents the campaign selection menu in the game.
 * Allows the player to choose a difficulty level and displays previous high scores.
 */
public class CampaignPanel extends JPanel {
    /**
     * The CardLayout used for switching panels.
     */
    private CardLayout cardLayout;

    /**
     * The main JPanel containing all cards (panels).
     */
    private JPanel mainPanel;

    /**
     * The currently selected difficulty level.
     */
    private Difficulty difficulty = Difficulty.EASY;

    // Components
    /**
     * Button for selecting "Easy" difficulty.
     */
    JButton easyButton;

    /**
     * Button for selecting "Normal" difficulty.
     */
    JButton normalButton;

    /**
     * Button for selecting "Hard" difficulty.
     */
    JButton hardButton;

    /**
     * The background image for the panel.
     */
    private Image backgroundImage;

    /**
     * Constructor for the CampaignPanel class.
     * 
     * @param cardLayout The CardLayout used for switching panels.
     * @param mainPanel  The main JPanel containing all cards (panels).
     */
    public CampaignPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        backgroundImage = new ImageIcon(getClass().getResource("/Menu/menu_background.png")).getImage();
        setLayout(null);

        drawBorderedTextBox("Campaign", new Rectangle((1280 / 2) - 100, 50, 200, 50), 25);
        drawDifficulties();
        drawPreviousHiScore();

        JButton returnButton = drawButton("Return to Main Menu", new Rectangle((1280 / 2) - (200 / 2), 600, 200, 50), 15);
        returnButton.addActionListener(e -> showPanel("Menu"));
    }

    /**
     * Refreshes the leaderboard by clearing existing components and redrawing them.
     */
    public void refreshLeaderboard() {
        // Remove all previous leaderboard components
        removeAll();
        // Redraw the components
        drawBorderedTextBox("Campaign", new Rectangle((1280 / 2) - 100, 50, 200, 50), 25);
        drawDifficulties();
        drawPreviousHiScore();

        JButton returnButton = drawButton("Return to Main Menu", new Rectangle((1280 / 2) - (200 / 2), 600, 200, 50), 15);
        returnButton.addActionListener(e -> showPanel("Menu"));

        // Revalidate and repaint the panel
        revalidate();
        repaint();
    }

    /**
     * Paints the component with the background image.
     * 
     * @param g The Graphics object used for drawing.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Paint the panel as usual
        // Draw the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    /**
     * Draws a bordered text box with specified text, location, and font size.
     * 
     * @param text     The text to be displayed inside the text box.
     * @param location The location and size of the text box on the panel.
     * @param fontSize The font size of the text.
     */
    public void drawBorderedTextBox(String text, Rectangle location, int fontSize) {
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
     * 
     * @param text     The text to be displayed on the button.
     * @param location The location and size of the button on the panel.
     * @param fontSize The font size of the button text.
     * @return The JButton created.
     */
    public JButton drawButton(String text, Rectangle location, int fontSize) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, fontSize));
        button.setBounds(location);
        add(button);
        return button;
    }

    /**
     * Draws difficulty selection panels.
     */
    public void drawDifficulties() {
        // Draw text
        JLabel diffcultyTitle = new JLabel("Difficulty Selection");
        diffcultyTitle.setFont(new Font("Arial", Font.BOLD, 20));
        diffcultyTitle.setForeground(Color.white);
        diffcultyTitle.setBounds((1280 / 2) - (300 / 2), 125, 300, 50);
        add(diffcultyTitle, BorderLayout.CENTER);
        // Draw border
        JPanel difficultyPanel = new JPanel();
        difficultyPanel.setOpaque(false);
        difficultyPanel.setLayout(null);
        difficultyPanel.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        difficultyPanel.setBounds((1280 / 2) - (300 / 2), 175, 300, 300);

        // Game factory class to create multiple game levels
        GameFactory gameFactory = new GameFactory(cardLayout, mainPanel, GameMode.CAMPAIGN);

        // Draw difficulty buttons
        easyButton = drawButton("Easy", new Rectangle(50, 50, 200, 50), 20);
        difficultyPanel.add(easyButton);
        easyButton.addActionListener(e -> {
            Game game = gameFactory.createGame(Difficulty.EASY, GameLevel.Level1);
            game.startGame();
        });

        normalButton = drawButton("Normal", new Rectangle(50, 125, 200, 50), 20);
        difficultyPanel.add(normalButton);
        normalButton.addActionListener(e -> {
            Game game = gameFactory.createGame(Difficulty.NORMAL, GameLevel.Level1);
            game.startGame();
        });

        hardButton = drawButton("Hard", new Rectangle(50, 200, 200, 50), 20);
        difficultyPanel.add(hardButton);
        hardButton.addActionListener(e -> {
            Game game = gameFactory.createGame(Difficulty.HARD, GameLevel.Level1);
            game.startGame();
        });

        add(difficultyPanel);
    }

    /**
     * Displays previous high scores for different levels.
     */
    public void drawPreviousHiScore() {
        // Draw text
        JLabel selectorTitle = new JLabel("Previous Hi-Score");
        selectorTitle.setForeground(Color.white);
        selectorTitle.setFont(new Font("Arial", Font.BOLD, 20));
        selectorTitle.setBounds((1280) - (700 / 2), 300, 700, 50);
        add(selectorTitle, BorderLayout.CENTER);

        HighestResult highestResult = HighestResult.getInstance();
        List<HighestResult.PlayerResult> leaderboard = highestResult.getLeaderboard();
        int x = 1;

        if (leaderboard.isEmpty()) {
            JLabel result = new JLabel("No players played yet");
            result.setForeground(Color.gray);
            result.setFont(new Font("Arial", Font.BOLD, 14));
            result.setBounds(1280 - (700 / 2), 300 + x * 50, 700, 50);
            add(result);
            return;
        }

        // for looping the player name with score (Singleton instance for later)
        for (HighestResult.PlayerResult entry : leaderboard) {
            JLabel result = new JLabel(x + ". " + entry.getName() + ": " + entry.getHighestScore());
            result.setForeground(Color.gray);
            result.setFont(new Font("Arial", Font.BOLD, 14));
            result.setBounds(1280 - (700 / 2), 300 + x * 50, 700, 50);
            add(result, BorderLayout.CENTER);
            x++;
        }
    }

    /**
     * Shows a specified panel based on the panel name provided.
     * 
     * @param panelName The name of the panel to be displayed.
     */
    private void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }
}
