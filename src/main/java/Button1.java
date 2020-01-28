import javax.swing.*;
import java.awt.*;

public class Button1 {
    public static void main(String[] args) {
        Button1 gui = new Button1();
        gui.go();
    }

    private void go() {
        JFrame frame = new JFrame();
        JButton button = new JButton("Click This!");
        Font font = new Font("serif", Font.BOLD, 28);
        button.setFont(font);
        frame.getContentPane().add(BorderLayout.NORTH, button);
        frame.setSize(200, 200);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
