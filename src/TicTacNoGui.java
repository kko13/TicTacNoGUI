import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacNoGui {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel boardPanel;
    private JButton buttons[] = new JButton[9];

    public TicTacNoGui() {
        InitGame();
    }

    private void InitGame() {
        mainFrame = new JFrame("Tic-Tac-No");
        mainFrame.setSize(1000, 1000);
        BoxLayout bLayout = new BoxLayout(mainFrame.getContentPane(),BoxLayout.Y_AXIS);
        mainFrame.setLayout(bLayout);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        headerLabel.setSize(950, 100);
        statusLabel.setSize(950, 100);

        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3,3));
        for (int i = 0; i <= 8; i++) {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].addActionListener(new buttonListener());
            boardPanel.add(buttons[i]);
        }

        mainFrame.add(headerLabel);
        mainFrame.add(boardPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void UpdateGui() {
        headerLabel.setText("Player X");
        statusLabel.setText("Round 1");
        mainFrame.setVisible(true);
    }

    private class buttonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton clicked = (JButton)e.getSource();
            clicked.setText("X");
        }
    }

    public static void main(String[] args) {
        TicTacNoGui ticGui = new TicTacNoGui();
        ticGui.UpdateGui();
    }
}
