package MiniMidi;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui {
    private JFrame frame;
    JLabel label;

    private JButton colorButton;
    private JButton labelButton;
    private DrawPanel panel;

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new DrawPanel();
        label = new JLabel();
        labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListener());

        colorButton = new JButton("Change colors");
        colorButton.addActionListener(new ColorListener());

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    private class LabelListener implements ActionListener { //for labelButton
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("Ouch!");
        }
    }

    private class ColorListener implements ActionListener { //for colorButton
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.repaint(); //after every click will change the oval`s color
        }
    }
}
