package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class GCodeCellRenderer extends DefaultTableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            Color mintCream = new Color(245, 255, 250);
            Color peachPuff = new Color(255, 218, 185);
            Color lightCoral = new Color(240, 128, 128);
            Color darkOrange = new Color(255, 140, 0);
            Color lightSeaGreen = new Color(32, 178, 170);
            Color seaGreen = new Color(46, 139, 87);
            Color slateGray = new Color(112, 128, 144);
            Color mediumOrchid = new Color(186, 85, 211);
            Color darkSlateBlue = new Color(72, 61, 139);
            Color darkBlue = Color.BLUE;
            Color darkSeaGreen = new Color(143, 188, 143);
            Color darkOliveGreen = new Color(85, 107, 47);
            Color darkSlateGray = new Color(47, 79, 79);
            Color fireBrick = new Color(178, 34, 34);
            Color black = Color.BLACK;

            String gCode = (String) value;

            // Set the background color based on the year value
            switch (gCode) {
                case "mc":
                    cellComponent.setForeground(mintCream);
                    cellComponent.setBackground(mintCream);
                    break;
                case "pp":
                    cellComponent.setForeground(peachPuff);
                    cellComponent.setBackground(peachPuff);
                    break;
                case "bl":
                    cellComponent.setForeground(black);
                    cellComponent.setBackground(black);
                    break;
                case "lc":
                    cellComponent.setForeground(lightCoral);
                    cellComponent.setBackground(lightCoral);
                    break;
                case "do":
                    cellComponent.setForeground(darkOrange);
                    cellComponent.setBackground(darkOrange);
                    break;
                case "lsg":
                    cellComponent.setForeground(lightSeaGreen);
                    cellComponent.setBackground(lightSeaGreen);
                    break;
                case "sg":
                    cellComponent.setForeground(seaGreen);
                    cellComponent.setBackground(seaGreen);
                    break;
                case "sgr":
                    cellComponent.setForeground(slateGray);
                    cellComponent.setBackground(slateGray);
                    break;
                case "mo":
                    cellComponent.setForeground(mediumOrchid);
                    cellComponent.setBackground(mediumOrchid);
                    break;
                case "dsb":
                    cellComponent.setForeground(darkSlateBlue);
                    cellComponent.setBackground(darkSlateBlue);
                    break;
                case "db":
                    cellComponent.setForeground(darkBlue);
                    cellComponent.setBackground(darkBlue);
                    break;
                case "dsg":
                    cellComponent.setForeground(darkSeaGreen);
                    cellComponent.setBackground(darkSeaGreen);
                    break;
                case "dog":
                    cellComponent.setForeground(darkOliveGreen);
                    cellComponent.setBackground(darkOliveGreen);
                    break;
                case "dsgr":
                    cellComponent.setForeground(darkSlateGray);
                    cellComponent.setBackground(darkSlateGray);
                    break;
                case "fb":
                    cellComponent.setForeground(fireBrick);
                    cellComponent.setBackground(fireBrick);
                    break;
                default:
                    cellComponent.setForeground(Color.BLACK);
                    cellComponent.setBackground(Color.WHITE);// Default color
                    break;
            }

                return cellComponent;


        }


}