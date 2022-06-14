package labExe;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    public ImageIcon screen = new ImageIcon("src/labExe/images.png");
    public ImageIcon theX = new ImageIcon("src/labExe/theX.png");
    public ImageIcon theY = new ImageIcon("src/labExe/theO.png");

    public Screen(int x, int y, int windowWhidth, int windowHighet, Color color) {

    }
    protected void paintComponent(Graphics g){
        g.drawImage(screen.getImage(),0,0,getWidth(),getHeight(),null);

    }
}
