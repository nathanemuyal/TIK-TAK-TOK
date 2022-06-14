package labExe;

import javax.swing.*;
import java.awt.*;

class Window extends JFrame {

    public static void main(String[] args) {
        Window window = new Window();
    }

    boolean play = true;
    boolean isX = false;
    int num = 0;
    int fullCells = 0;

    public static final int WINDOW_WHIDTH = 250;
    public static final int WINDOW_HIGHET = 250;

    public Window() {
//        Screen screen = new Screen(0, 0, WINDOW_WHIDTH, WINDOW_HIGHET, Color.cyan);
//        this.add(screen);
        this.setSize(WINDOW_WHIDTH, WINDOW_HIGHET);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        if (num <= 9) {
            GridLayout gridLayout = new GridLayout(3, 3);
            this.setLayout(gridLayout);
            for (int i = 0; i < 9; i++) {
                JButton cell = new JButton();
                cell.addActionListener((e) -> {
                    if (cell.getText().equals("")) {
                        fullCells++;
                        if (fullCells == 9) {
                            System.out.println("FULL");
                            JOptionPane.showMessageDialog(this, "The X and the 0 lose");

                        }
                            if (isX) {
                                cell.setText("0");
                                num++;
                                isX = false;

                            } else {
                                cell.setText("X");
                                num++;
                                isX = true;
                            }

                    }
                });
                this.add(cell);
            }
        }
        this.setResizable(false);
        this.setTitle("TIK-TAK-TOK");
        this.setVisible(true);

    }
    public void win(){
        
    }
}

