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
    int turnCounter = 0;
    static char[][] board = new char[3][3];
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
                JButton cell = new JButton(     );
                cell.addActionListener((e) -> {
                    turnCounter++;
                    if (cell.getText().equals("")) {

                            if (isX) {
                                cell.setText("0");
                                convert(cell.getX(), cell.getY(), 'O');
                                num++;
                                isX = false;

                            } else {
                                cell.setText("X");
                                convert(cell.getX(), cell.getY(), 'X');
                                num++;
                                isX = true;
                            }

                    }
                });
                this.add(cell);
            }
        }
        this.setResizable(false);
        this.setTitle("TIK-TAK-TOE");
        this.setVisible(true);

    }

    private boolean convert(int x, int y, char c){
        int xCor = -1;
        int yCor = -1;
        if (y == 0) xCor = 0;
        if (y == 71) xCor = 1;
        if (y > 71) xCor = 2;

        if (x == 1) yCor = 0;
        if (x == 79) yCor = 1;
        if (x == 157) yCor = 2;
        board[xCor][yCor] = c;
        checkWin();
        return false;
    }

    public void checkWin(){
        char winner = checkWinner(board);
        if (winner == 'X')  {
            JOptionPane.showMessageDialog(this, "X won");
            System.exit(0);
        }
        if (winner == 'O')  {
            JOptionPane.showMessageDialog(this, "O won");
            System.exit(0);
        }
        if (turnCounter == 9 && winner == '-'){
            JOptionPane.showMessageDialog(this, "draw");
            System.exit(0);
        }
    }

    public static char checkWinner(char[][] array) {
        // check for row winners
        for (char[] chars : array) {
            // if all three columns are the same then that player wins!
            if (chars[0] == chars[1] && chars[1] == chars[2]) {
                // return the winner!
                return chars[0];
            }
        }

        // check for column winners
        for (int col = 0; col < array.length; col++) {
            // if all three rows are the same then that player wins!
            if (array[0][col] == array[1][col] && array[1][col] == array[2][col]) {
                // return our winner!
                return array[0][col];
            }
        }

        // check for diag winners
        if (array[0][0] == array[1][1] && array[1][1] == array[2][2]) {
            return array[0][0];
        }

        if (array[0][2] == array[1][1] && array[1][1] == array[2][0]) {
            return array[0][2];
        }
        return '-';
    }

}

