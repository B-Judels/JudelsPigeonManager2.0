package Screens;

import org.example.BreederPigeons;
import org.example.GCodeCellRenderer;
import org.example.Methods;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BreedersWindow {
    private JFrame frame;
    private JPanel panel;
    private JTable table, table2;
    private DefaultTableModel tableModel, tableModel2;
    private JScrollPane scrollPane, scrollPane2;
    private JButton backBtn;

    public BreedersWindow() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<BreederPigeons> fathers = Methods.loadPigeonsFatherFromDatabase();
        ArrayList<BreederPigeons> mothers = Methods.loadPigeonsMotherFromDatabase();


        frame = new JFrame("Breeders Window");
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


//father table------------------------------------------------------------------------------------------------------------------
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Year", "Letters", "Color", "Gender", "GC1", "GC2", "GC3", "GC4"}, 0);
        table = new JTable(tableModel);
        table.setBounds(30, 100, 500, 200);

        // Load data into the table
        for (BreederPigeons pigeon : fathers) {
            tableModel.addRow(new Object[]{pigeon.getId(), pigeon.getNickname(),
                    pigeon.getYear(), pigeon.getLetters(),pigeon.getColour(), pigeon.getGender(), pigeon.getGene1(), pigeon.getGene2(), pigeon.getGene3(), pigeon.getGene4()});
        }

        TableColumn column_1 = table.getColumnModel().getColumn(6);
        column_1.setPreferredWidth(33);
        column_1.setCellRenderer(new GCodeCellRenderer());

        TableColumn column_2 = table.getColumnModel().getColumn(7);
        column_2.setPreferredWidth(33);
        column_2.setCellRenderer(new GCodeCellRenderer());

        TableColumn column_3 = table.getColumnModel().getColumn(8);
        column_3.setPreferredWidth(33);
        column_3.setCellRenderer(new GCodeCellRenderer());

        TableColumn column_4 = table.getColumnModel().getColumn(9);
        column_4.setPreferredWidth(33);
        column_4.setCellRenderer(new GCodeCellRenderer());

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 50, 200, 300);
        scrollPane.setSize(500, 500);
        panel.add(scrollPane);
//.........................................................................................................

//mother table------------------------------------------------------------------------------------------------------------------
        tableModel2 = new DefaultTableModel(new String[]{"ID", "Name", "Year", "Letters", "Color", "Gender", "GC1", "GC2", "GC3", "GC4"}, 0);
        table2 = new JTable(tableModel2);
        table2.setBounds(400, 100, 500, 200);

        // Load data into the table
        for (BreederPigeons pigeon : mothers) {
            tableModel2.addRow(new Object[]{pigeon.getId(), pigeon.getNickname(),
                    pigeon.getYear(), pigeon.getLetters(),pigeon.getColour(), pigeon.getGender(), pigeon.getGene1(), pigeon.getGene2(), pigeon.getGene3(), pigeon.getGene4()});
        }

        TableColumn column = table2.getColumnModel().getColumn(6);
        column.setPreferredWidth(33);
        column.setCellRenderer(new GCodeCellRenderer());

        TableColumn column2 = table2.getColumnModel().getColumn(7);
        column2.setPreferredWidth(33);
        column2.setCellRenderer(new GCodeCellRenderer());

        TableColumn column3 = table2.getColumnModel().getColumn(8);
        column3.setPreferredWidth(33);
        column3.setCellRenderer(new GCodeCellRenderer());

        TableColumn column4 = table2.getColumnModel().getColumn(9);
        column4.setPreferredWidth(33);
        column4.setCellRenderer(new GCodeCellRenderer());

        scrollPane2 = new JScrollPane(table2);
        scrollPane2.setBounds(520, 50, 200, 300);
        scrollPane2.setSize(500, 500);
        panel.add(scrollPane2);
//.........................................................................................................
    }

    public void show(){
        frame.setVisible(true);
    }
}
