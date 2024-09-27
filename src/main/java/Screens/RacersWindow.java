package Screens;

import com.formdev.flatlaf.FlatLightLaf;
import org.example.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RacersWindow {
    private JFrame frame;
    private JPanel panel;
    private JButton backBtn;
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    public RacersWindow() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<PigeonLoad> racersList = Methods.loadRacerPigeonsFromDatabase();

        frame = new JFrame("Add Racer Pigeon");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        ImageIcon i = new ImageIcon("src/LOGO.png");
        frame.setIconImage(i.getImage());

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.lightGray);
        frame.add(panel);

//back button -------------------------------------
        backBtn = new JButton();
        ImageIcon back = new ImageIcon("src/BACK_ARROW.png");
        Image backImage = back.getImage();
        Image scaledBack=  backImage.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH);
        backBtn.setIcon(new ImageIcon(scaledBack));
        backBtn.setBackground(Methods.mainColorTheme());
        backBtn.setBounds(5, 5, 40, 40);
        backBtn.setFocusPainted(false);
        backBtn.setBorder(new LineBorder(Color.BLACK));
        panel.add(backBtn);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                MainWindow main = new MainWindow();
                main.show();
            }
        });
//.................................................

        try{

            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
            } catch (Exception e) {
                e.printStackTrace();
            }

            tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Year", "Letters", "Color", "Gender", "Times Flyed", "Times Scored", "Score Odds", "Sire/Father", "Dam/Mother", "GC1", "GC2", "GC3", "GC4", "GC5", "GC6", "GC7", "GC8"}, 0);
            table = new JTable(tableModel);
            table.setBorder(new LineBorder(Color.BLACK, 1));

            // Load data into the table
            for (PigeonLoad pigeon : racersList) {
                tableModel.addRow(new Object[]{pigeon.getId(), pigeon.getNickname(),
                        pigeon.getYear(), pigeon.getLetters(),pigeon.getColour(), pigeon.getGender(), pigeon.getTimesFlyed(), pigeon.getTimesScored(), pigeon.getScorePercentage(), pigeon.getFather(), pigeon.getMother(), pigeon.getGene1(), pigeon.getGene2(), pigeon.getGene3(), pigeon.getGene4(), pigeon.getGene5(), pigeon.getGene6(), pigeon.getGene7(), pigeon.getGene8()});
            }

            TableColumn column_1 = table.getColumnModel().getColumn(11);
            column_1.setPreferredWidth(33);
            column_1.setCellRenderer(new GCodeCellRenderer());

            TableColumn column_2 = table.getColumnModel().getColumn(12);
            column_2.setPreferredWidth(33);
            column_2.setCellRenderer(new GCodeCellRenderer());

            TableColumn column_3 = table.getColumnModel().getColumn(13);
            column_3.setPreferredWidth(33);
            column_3.setCellRenderer(new GCodeCellRenderer());

            TableColumn column_4 = table.getColumnModel().getColumn(14);
            column_4.setPreferredWidth(33);
            column_4.setCellRenderer(new GCodeCellRenderer());

            TableColumn column_5 = table.getColumnModel().getColumn(15);
            column_5.setPreferredWidth(33);
            column_5.setCellRenderer(new GCodeCellRenderer());

            TableColumn column_6 = table.getColumnModel().getColumn(16);
            column_6.setPreferredWidth(33);
            column_6.setCellRenderer(new GCodeCellRenderer());

            TableColumn column_7 = table.getColumnModel().getColumn(17);
            column_7.setPreferredWidth(33);
            column_7.setCellRenderer(new GCodeCellRenderer());

            TableColumn column_8 = table.getColumnModel().getColumn(18);
            column_8.setPreferredWidth(33);
            column_8.setCellRenderer(new GCodeCellRenderer());
            column_8.setResizable(false);

            Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
            int width = (int)size.getWidth();
            int height = (int)size.getHeight();

            int tableWidth = width - 20;

            scrollPane = new JScrollPane(table);
            scrollPane.setBounds(10, 50, tableWidth, 600);
            scrollPane.setSize(tableWidth, 600);
            scrollPane.setBorder(new LineBorder(Color.BLACK, 1));
            panel.add(scrollPane);


        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void show(){
        frame.setVisible(true);
    }
}
