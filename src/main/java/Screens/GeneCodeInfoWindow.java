package Screens;

import javax.swing.*;
import java.awt.*;

public class GeneCodeInfoWindow {
    private JFrame frame;
    private JPanel panel;
    private JLabel label;

    public GeneCodeInfoWindow() {
        ImageIcon iconInfo = new ImageIcon("src/Images/CodeExplination.png");
        Image imageInfo = iconInfo.getImage();
        Image scaledImageInfo = imageInfo.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH);

        frame = new JFrame("Genetic Code Info");
        frame.setIconImage(new ImageIcon("src/Images/info2.png").getImage());
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        label = new JLabel("The Genetic Code is the perfect way to monitor and improve your breeding!");
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setBounds(10, 0, 500, 20);
        panel.add(label);

        label = new JLabel("The Gene code is a color code that uses a grid of 8 colors.\n");
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setBounds(10, 15, 500, 20);
        panel.add(label);

        label = new JLabel("4 from the Father's side and 4 from the mothers' side.");
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setBounds(10, 30, 500, 20);
        panel.add(label);

        label = new JLabel("This code let's you see the bloodline of your racing pigeons and allows you to");
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setBounds(10, 60, 500, 20);
        panel.add(label);

        label = new JLabel("compare them according to their genetics.");
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setBounds(10, 75, 500, 20);
        panel.add(label);

        label = new JLabel("");
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setBounds(10, 0, 500, 20);
        panel.add(label);

        label = new JLabel();
        label.setIcon(new ImageIcon(scaledImageInfo));
        label.setBounds(95, 50, 300, 300);
        panel.add(label);

        label = new JLabel("Father's Gene Code:");
        label.setFont(new Font("Arial", Font.BOLD, 10));
        label.setBounds(120,115,100,20);
        panel.add(label);

        label = new JLabel("Mother's Gene Code:");
        label.setFont(new Font("Arial", Font.BOLD, 10));
        label.setBounds(270,115,120,20);
        panel.add(label);

        label = new JLabel("Offspring's Gene Code:");
        label.setFont(new Font("Arial", Font.BOLD, 10));
        label.setBounds(160,200,130,20);
        panel.add(label);

    }

    public void show() {
        frame.setVisible(true);
    }
}
