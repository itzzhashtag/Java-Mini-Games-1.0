import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class GuessColor {
    
    private DisplayPanel randomDisplayPanel;
    private DisplayPanel userDisplayPanel;
    
    private GameModel model;
    
    private JFrame frame;
    
    private JPanel randomPanel;
    private JPanel userPanel;

    public GuessColor() {
        this.model = new GameModel();
        this.model.createColors();
        
        frame = new JFrame("Match the color!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        frame.add(createMainPanel(), BorderLayout.CENTER);
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    // sets up the frame and functionality of UI
    private JPanel createMainPanel() { 
        JPanel panel = new JPanel(new BorderLayout());
        
        JLabel title = new JLabel("Match The Color!", JLabel.CENTER);
        Font font = new Font("Times New Roman", Font.BOLD, 30);
        title.setFont(font);
        title.setBackground(Color.BLACK);
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        panel.add(title, BorderLayout.NORTH);

        JPanel center = new JPanel(new BorderLayout());
        center.setBackground(Color.CYAN);
        panel.add(center, BorderLayout.CENTER);
        
        Dimension d = new Dimension(500, 500); // color panel size

        randomPanel = new JPanel(new BorderLayout()); // random color panel
        randomPanel.setBackground(model.getRandomColor());
        randomPanel.setPreferredSize(d);
        randomDisplayPanel = new DisplayPanel(model.getRandomColor() ); // hide RGB

        randomPanel.add(randomDisplayPanel.getPanel(), BorderLayout.NORTH);
        center.add(randomPanel, BorderLayout.WEST);

        userPanel = new JPanel(new BorderLayout()); // adjustable color panel
        userPanel.setBackground(model.getUserColor());
        userPanel.setPreferredSize(d);
        userDisplayPanel = new DisplayPanel(model.getUserColor());
        userPanel.add(userDisplayPanel.getPanel(), BorderLayout.NORTH);
        center.add(userPanel, BorderLayout.EAST);

        /** BUTTONS **/

        JPanel buttonPanel = new JPanel();
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        // This Object array makes it possible to create the JButtons in a loop
        // buttonObject[0] - JButton labels
        // buttonObject[1] - JButton action commands
        // buttonObject[2] - JButton background colors
        // buttonObject[3] - JButton foreground colors
        Object[][] buttonObject = new Object[][] { { "+", "-", "+", "-", "+", "-" },
                { "red", "red", "green", "green", "blue", "blue" },
                { Color.RED, Color.RED, Color.GREEN, 
                        Color.GREEN, Color.BLUE, Color.BLUE },
                { Color.WHITE, Color.WHITE, Color.BLACK, 
                        Color.BLACK, Color.WHITE, Color.WHITE } };
        Dimension b = new Dimension(50, 50); // button size
        ButtonListener listener = new ButtonListener();
        
        for (int i = 0; i < buttonObject[0].length; i++) {
            JButton button = new JButton((String) buttonObject[0][i]);
            button.setActionCommand((String) buttonObject[1][i]);
            button.setBackground((Color) buttonObject[2][i]);
            button.setForeground((Color) buttonObject[3][i]);
            button.setPreferredSize(b);
            button.setFocusPainted(false);
            button.addActionListener(listener);
            buttonPanel.add(button);
        }

        return panel;   
    }
    
    public void setRandomPanelColor() {
        randomPanel.setBackground(model.getRandomColor());
        randomDisplayPanel.setColor(model.getRandomColor());
    }
    
    public void setUserPanelColor() {
        userPanel.setBackground(model.getUserColor());
        userDisplayPanel.setColor(model.getUserColor());
    }
    
    // main method
    public static void main(String[] args) {
        try {
            String laf = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(laf);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GuessColor();
            }
        });
    }
    
    public class DisplayPanel 
    {
        
        private JPanel panel;
        
        private JTextField redField;
        private JTextField greenField;
        private JTextField blueField;
        
        private boolean showValues;
        public DisplayPanel(Color color) 
        {
            this.showValues = showValues;
            createJPanel();
            setColor(color);
        }
        
        private void createJPanel() 
        {
            panel = new JPanel(new GridBagLayout());
            panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridx = 0;
            gbc.gridy = 0;

            if (showValues) 
                 {
                JLabel redLabel = new JLabel("Red:");
                redLabel.setForeground(Color.WHITE);
                panel.add(redLabel, gbc);
        
                gbc.gridx++;
                redField = new JTextField(3);
                redField.setEditable(false);
                redField.setHorizontalAlignment(JTextField.TRAILING);
                panel.add(redField, gbc);
        
                gbc.gridx = 0;
                gbc.gridy++;
                JLabel greenLabel = new JLabel("Green:");
                greenLabel.setForeground(Color.WHITE);
                panel.add(greenLabel, gbc);
        
                gbc.gridx++;
                greenField = new JTextField(3);
                greenField.setEditable(false);
                greenField.setHorizontalAlignment(JTextField.TRAILING);
                panel.add(greenField, gbc);
        
                gbc.gridx = 0;
                gbc.gridy++;
                JLabel blueLabel = new JLabel("Blue:");
                blueLabel.setForeground(Color.WHITE);
                panel.add(blueLabel, gbc);
        
                gbc.gridx++;
                blueField = new JTextField(3);
                blueField.setEditable(false);
                blueField.setHorizontalAlignment(JTextField.TRAILING);
                panel.add(blueField, gbc);
            }
        }
        

        public JPanel getPanel() 
        {
            return panel;
        }

        public void setColor(Color color) 
        {
            panel.setBackground(color);
            if (showValues) {
                redField.setText(Integer.toString(color.getRed()));
                greenField.setText(Integer.toString(color.getGreen()));
                blueField.setText(Integer.toString(color.getBlue()));
            }
        }   
        
    }
    
    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            JButton button = (JButton) event.getSource();
            String text = button.getText();
            String action = event.getActionCommand();
            
            Color color = model.getUserColor();
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
            
            if (action.equals("red")) {
                if (text.equals("+")) {
                    red += 15;
                    red = Math.min(255, red);
                } else {
                    red -= 15;
                    red = Math.max(0, red);
                }
            } else if (action.equals("green")) {
                if (text.equals("+")) {
                    green += 15;
                    green = Math.min(255, green);
                } else {
                    green -= 15;
                    green = Math.max(0, green);
                }
            } else if (action.equals("blue")) {
                if (text.equals("+")) {
                    blue += 15;
                    blue = Math.min(255, blue);
                } else {
                    blue -= 15;
                    blue = Math.max(0, blue);
                }
            }
            
            model.setUserColor(red, green, blue);
            setUserPanelColor();
            check();
        }
        
        // checks if the color panels are the same and displays 
        // winning message if they are the same

        private void check() {
            if (model.getRandomColor().equals(model.getUserColor())) {
                int choose = JOptionPane.showConfirmDialog(frame, 
                        "You win!  Play again?");
                if (choose == JOptionPane.YES_OPTION) {
                    model.createColors();
                    setRandomPanelColor();
                    setUserPanelColor();
                } else if (choose == JOptionPane.NO_OPTION) {
                    frame.dispose();
                    System.exit(0);
                }
            }
        }
        
    }
    
    public class GameModel {
        
        private Color randomColor;
        private Color userColor;
        
        private final Random random;
        
        public GameModel() {
            this.random = new Random();
        }
        
        public void createColors() {
            setRandomColor();
            setUserColor();
        }

        public Color getUserColor() {
            return userColor;
        }

        public void setUserColor() {
            int userRed = 135;
            int userGrn = 135;
            int userBlu = 135;
            this.userColor = new Color(userRed, userGrn, userBlu);
        }
        
        public void setUserColor(int red, int green, int blue) {
            this.userColor = new Color(red, green, blue);
        }

        public Color getRandomColor() {
            return randomColor;
        }

        public void setRandomColor() {
            int randRed = (random.nextInt(17) + 1) * 15;
            int randGrn = (random.nextInt(17) + 1) * 15;
            int randBlu = (random.nextInt(17) + 1) * 15;
            this.randomColor = new Color(randRed, randGrn, randBlu);
        }
        
    }
}