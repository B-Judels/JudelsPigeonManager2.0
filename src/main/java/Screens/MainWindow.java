package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JLabel label;

    public MainWindow() {
        frame = new JFrame("Judels Pigeon Manager");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        ImageIcon i = new ImageIcon("src/LOGO.png");
        frame.setIconImage(i.getImage());

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.lightGray);
        frame.add(panel);

        //decorative name image text
        ImageIcon text = new ImageIcon("src/JPM.png");
        label = new JLabel(text);
        label.setBounds(40, 60, text.getIconWidth(), text.getIconHeight());
        panel.add(label);
        //...
        //decorative image
        ImageIcon icon = new ImageIcon("src/FlyingPigeonNoBG_HD.png");
        Image image2 = icon.getImage();
        Image scaledImage2 = image2.getScaledInstance(800, 800,  java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage2);
        label = new JLabel(icon);
        label.setBounds(450, 0, 800, 800);
        panel.add(label);
        //...

        ImageIcon Racericon = new ImageIcon("src/Images/trophy2.png");
        Image imageRace = Racericon.getImage();
        Image scaledImageRace = imageRace.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
        button = new JButton("Add Racer Pigeon");
        button.setBounds(100, 130, 200, 40);
        button.setIcon(new ImageIcon(scaledImageRace));
        button.setHorizontalTextPosition(SwingConstants.LEFT);
        MainWindowButtons(button);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                AddRacerWindow racers = new AddRacerWindow();
                racers.show();
            }
        });

        button = new JButton("Racers");
        button.setBounds(100, 190, 200, 40);
        MainWindowButtons(button);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                RacersWindow racers2 = new RacersWindow();
                racers2.show();
            }
        });

        button = new JButton("three");
        button.setBounds(100, 250, 200, 40);
        MainWindowButtons(button);
        panel.add(button);

        ImageIcon Breedericon = new ImageIcon("src/Images/BreederPigeonIcon.png");
        Image imageBreed = Breedericon.getImage();
        Image scaledImageBreed = imageBreed.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
        button = new JButton("Add Breeder Pigeon");
        button.setBounds(400, 130, 200, 40);
        button.setIcon(new ImageIcon(scaledImageBreed));
        button.setHorizontalTextPosition(SwingConstants.LEFT);
        MainWindowButtons(button);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                AddBreederWindow breeders = new AddBreederWindow();
                breeders.show();
            }
        });

        button = new JButton("Breeders");
        button.setBounds(400, 190, 200, 40);
        MainWindowButtons(button);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                BreedersWindow breeders2 = new BreedersWindow();
                breeders2.show();
            }
        });

        button = new JButton("six");
        button.setBounds(400, 250, 200, 40);
        MainWindowButtons(button);
        panel.add(button);

    }

    private void MainWindowButtons(JButton button){
        button.setBackground(new Color(234, 21, 71));
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Tahoma", Font.BOLD, 20));
        button.setSize(280, 45);
        button.setFocusPainted(false);
    }

    public void show(){
        frame.setVisible(true);
    }
}