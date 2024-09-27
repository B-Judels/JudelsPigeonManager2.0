package org.example;

import Screens.GeneCodeInfoWindow;
import com.formdev.flatlaf.FlatLightLaf;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class Methods {

    public static void uploadImageButtonListener(JButton button, JFrame frame, JLabel imageLabel) {
        // Set the FlatLaf Look and Feel
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File selectedFile;
                // Open a file chooser
                JFileChooser fileChooser = new JFileChooser();

                // Set file filter for image types
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
                fileChooser.setFileFilter(filter);

                // Set initial directory to the user's Pictures folder
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"), "Pictures"));

                // Show the file chooser dialog
                int returnValue = fileChooser.showOpenDialog(frame);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    try {
                        button.setVisible(false);
                        // Load the image
                        BufferedImage image = ImageIO.read(selectedFile);

                        Image upload = image;
                        Image scaledImageUploader = upload.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);

                        // Set the image to the label
                        imageLabel.setIcon(new ImageIcon(scaledImageUploader));
                    } catch (IOException ex) {
                        // Show error dialog if loading the image fails
                        JOptionPane.showMessageDialog(frame, "Error loading image: " + ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    public static Color mainColorTheme(){
        Color color = new Color(234, 21, 71);
        return color;
    }

    public static JDateChooser datePicker(JPanel panel){

        //Date Input -------------------------------------------------------
        JDateChooser dateChooser = new JDateChooser(new Date());
        dateChooser.setPreferredSize(new Dimension(120, 20));

        //text field
        JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser.getDateEditor();
        editor.setText("Date Weaned");
        editor.setForeground(Color.GRAY);
        editor.setFont(new Font("Arial", Font.BOLD, 12));
        editor.setEditable(false);
        editor.setFocusable(false);
        editor.setBorder(new LineBorder(Methods.mainColorTheme(), 2));


        //button
        for (Component component : dateChooser.getComponents()) {
            if (component instanceof JButton) {
                JButton dateButton = (JButton) component;
                dateButton.setBorder(new LineBorder(Color.BLACK, 2));

                ImageIcon customIcon = new ImageIcon("src/calendar.png");
                Image calander = customIcon.getImage();
                Image scaledCalander = calander.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
                dateButton.setIcon(new ImageIcon(scaledCalander));
                dateButton.setBackground(Methods.mainColorTheme());
                break;
            }
        }

        panel.add(dateChooser);
        return dateChooser;

//.............................................................................................................
    }


    public static byte[] getImageSaveFormat(JLabel imageLabel) throws IOException {
        // Get the icon from the label
        Icon icon = imageLabel.getIcon();
        if (icon instanceof ImageIcon) {
            ImageIcon imageIcon = (ImageIcon) icon;
            Image image = imageIcon.getImage();

            // Create a BufferedImage from the Image
            BufferedImage bufferedImage = new BufferedImage(
                    image.getWidth(null),
                    image.getHeight(null),
                    BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d = bufferedImage.createGraphics();
            g2d.drawImage(image, 0, 0, null);
            g2d.dispose();

            // Convert BufferedImage to byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String imageFormat = "png"; // Default format

            // Check if imageIcon has a description for file format
            if (imageIcon.getDescription() != null) {
                String fileExtension = imageIcon.getDescription().toLowerCase();
                if (fileExtension.endsWith(".jpg") || fileExtension.endsWith(".jpeg")) {
                    imageFormat = "jpg"; // Set format for JPG files
                } else if (fileExtension.endsWith(".gif")) {
                    imageFormat = "gif"; // Set format for GIF files
                } else if (fileExtension.endsWith(".bmp")) {
                    imageFormat = "bmp"; // Set format for BMP files
                }
            }

            // Write the image to the ByteArrayOutputStream
            ImageIO.write(bufferedImage, imageFormat, baos);
            return baos.toByteArray(); // Return the byte array
        } else {
            // Load the default image when no image is found
            BufferedImage defaultImage = ImageIO.read(new File("src/Images/imagePlaceholder.png"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(defaultImage, "png", baos); // Assuming PNG format for the default image
            return baos.toByteArray(); // Return the byte array of the default image
        }
    }

    public static void optionalLabel(JPanel panel, int x, int y){
        JLabel label = new JLabel("(Optional)");
        label.setFont(new Font("Arial", Font.PLAIN, 8));
        label.setBounds(x, y, 100, 9);
        panel.add(label);
    }

    public static JLabel requiredLabel(JLabel label,JPanel panel, int x, int y){
        label = new JLabel("Required!");
        label.setFont(new Font("Arial", Font.BOLD, 10));
        label.setForeground(Color.RED);
        label.setBounds(x, y, 100, 12);
        label.setVisible(false);
        panel.add(label);

        return label;
    }


    public static JMenu geneCodeSelection(JMenuBar menuBar,JPanel panel, int x, int y, int num){
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

        menuBar.setOpaque(true);  // Make sure the background is painted
        menuBar.setBackground(Methods.mainColorTheme());
        menuBar.setBorder(new LineBorder(Color.black, 2));
        menuBar.setBounds(x, y, 75, 20);

        ImageIcon icon = new ImageIcon("src/DOWN_ARROW.png");
        Image image2_1 = icon.getImage();
        Image scaledImage2 = image2_1.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH);

        JMenu menu = new JMenu("Code " + num);
        menu.setIcon(new ImageIcon(scaledImage2));
        menu.setHorizontalTextPosition(SwingConstants.LEFT);
        menu.setFont(new Font("Arial", Font.BOLD, 12));
        menuBar.add(menu);

        JMenuItem item = new JMenuItem();
        item.setOpaque(true);  // Make sure the background is painted
        item.setBackground(mintCream);
        item.setBorder(new LineBorder(Color.black, 1));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setOpaque(true);
                menuBar.setBackground(mintCream);
                menuBar.repaint();  // Force the component to repaint

                menu.setText("mc");
                menuBar.setForeground(mintCream);
                menu.setIcon(null);
            }
        });
        menu.add(item);

        JMenuItem item3 = new JMenuItem();
        item3.setOpaque(true);  // Make sure the background is painted
        item3.setBackground(peachPuff);
        item3.setBorder(new LineBorder(Color.black, 1));
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setOpaque(true);
                menuBar.setBackground(peachPuff);
                menuBar.repaint();  // Force the component to repaint

                menu.setText("pp");
                menuBar.setForeground(peachPuff);
                menu.setIcon(null);
            }
        });
        menu.add(item3);

        JMenuItem item4 = new JMenuItem();
        item4.setOpaque(true);  // Make sure the background is painted
        item4.setBackground(lightCoral);
        item4.setBorder(new LineBorder(Color.black, 1));
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setOpaque(true);
                menuBar.setBackground(lightCoral);
                menuBar.repaint();  // Force the component to repaint

                menu.setText("lc");
                menuBar.setForeground(lightCoral);
                menu.setIcon(null);
            }
        });
        menu.add(item4);

        JMenuItem item5 = new JMenuItem();
        item5.setOpaque(true);  // Make sure the background is painted
        item5.setBackground(darkOrange);
        item5.setBorder(new LineBorder(Color.black, 1));
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setOpaque(true);
                menuBar.setBackground(darkOrange);
                menuBar.repaint();  // Force the component to repaint

                menu.setText("do");
                menuBar.setForeground(darkOrange);
                menu.setIcon(null);
            }
        });
        menu.add(item5);

        JMenuItem item6 = new JMenuItem();
        item6.setOpaque(true);  // Make sure the background is painted
        item6.setBackground(lightSeaGreen);
        item6.setBorder(new LineBorder(Color.black, 1));
        item6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setOpaque(true);
                menuBar.setBackground(lightSeaGreen);
                menuBar.repaint();  // Force the component to repaint

                menu.setText("lsg");
                menuBar.setForeground(lightSeaGreen);
                menu.setIcon(null);
            }
        });
        menu.add(item6);

        JMenuItem item7 = new JMenuItem();
        item7.setOpaque(true);  // Make sure the background is painted
        item7.setBackground(seaGreen);
        item7.setBorder(new LineBorder(Color.black, 1));
        item7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setOpaque(true);
                menuBar.setBackground(seaGreen);
                menuBar.repaint();  // Force the component to repaint

                menu.setText("sg");
                menuBar.setForeground(seaGreen);
                menu.setIcon(null);
            }
        });
        menu.add(item7);

        JMenuItem item8 = new JMenuItem();
        item8.setOpaque(true);  // Make sure the background is painted
        item8.setBackground(slateGray);
        item8.setBorder(new LineBorder(Color.black, 1));
        item8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setOpaque(true);
                menuBar.setBackground(slateGray);
                menuBar.repaint();  // Force the component to repaint

                menu.setText("sgr");
                menuBar.setForeground(slateGray);
                menu.setIcon(null);
            }
        });
        menu.add(item8);

        JMenuItem item9 = new JMenuItem();
        item9.setOpaque(true);  // Make sure the background is painted
        item9.setBackground(mediumOrchid);
        item9.setBorder(new LineBorder(Color.black, 1));
        item9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setOpaque(true);
                menuBar.setBackground(mediumOrchid);
                menuBar.repaint();  // Force the component to repaint

                menu.setText("mo");
                menuBar.setForeground(mediumOrchid);
                menu.setIcon(null);
            }
        });
        menu.add(item9);

        JMenuItem item10 = new JMenuItem();
        item10.setOpaque(true);  // Make sure the background is painted
        item10.setBackground(darkSlateBlue);
        item10.setBorder(new LineBorder(Color.black, 1));
        item10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setOpaque(true);
                menuBar.setBackground(darkSlateBlue);
                menuBar.repaint();  // Force the component to repaint

                menu.setText("dsb");
                menuBar.setForeground(darkSlateBlue);
                menu.setIcon(null);
            }
        });
        menu.add(item10);

        JMenuItem item11 = new JMenuItem();
        item11.setOpaque(true);  // Make sure the background is painted
        item11.setBackground(darkBlue);
        item11.setBorder(new LineBorder(Color.black, 1));
        item11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setOpaque(true);
                menuBar.setBackground(darkBlue);
                menuBar.repaint();  // Force the component to repaint

                menu.setText("db");
                menuBar.setForeground(darkBlue);
                menu.setIcon(null);
            }
        });
        menu.add(item11);

        JMenuItem item12 = new JMenuItem();
        item12.setOpaque(true);  // Make sure the background is painted
        item12.setBackground(darkSeaGreen);
        item12.setBorder(new LineBorder(Color.black, 1));
        item12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setOpaque(true);
                menuBar.setBackground(darkSeaGreen);
                menuBar.repaint();  // Force the component to repaint

                menu.setText("dsg");
                menuBar.setForeground(darkSeaGreen);
                menu.setIcon(null);
            }
        });
        menu.add(item12);

        JMenuItem item13 = new JMenuItem();
        item13.setOpaque(true);  // Make sure the background is painted
        item13.setBackground(darkOliveGreen);
        item13.setBorder(new LineBorder(Color.black, 1));
        item13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setOpaque(true);
                menuBar.setBackground(darkOliveGreen);
                menuBar.repaint();  // Force the component to repaint

                menu.setText("dog");
                menuBar.setForeground(darkOliveGreen);
                menu.setIcon(null);
            }
        });
        menu.add(item13);

        JMenuItem item14 = new JMenuItem();
        item14.setOpaque(true);  // Make sure the background is painted
        item14.setBackground(darkSlateGray);
        item14.setBorder(new LineBorder(Color.black, 1));
        item14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setOpaque(true);
                menuBar.setBackground(darkSlateGray);
                menuBar.repaint();  // Force the component to repaint

                menu.setText("dsgr");
                menuBar.setForeground(darkSlateGray);
                menu.setIcon(null);
            }
        });
        menu.add(item14);

        JMenuItem item2 = new JMenuItem();
        item2.setOpaque(true);  // Make sure the background is painted
        item2.setBackground(fireBrick);
        item2.setBorder(new LineBorder(Color.black, 1));
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setOpaque(true);
                menuBar.setBackground(fireBrick);
                menuBar.repaint();  // Force the component to repaint

                menu.setText("fb");
                menuBar.setForeground(fireBrick);
                menu.setIcon(null);
            }
        });
        menu.add(item2);


        JMenuItem item15 = new JMenuItem();
        item15.setOpaque(true);  // Make sure the background is painted
        item15.setBackground(black);
        item15.setBorder(new LineBorder(Color.black, 1));
        item15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuBar.setOpaque(true);
                menuBar.setBackground(black);
                menuBar.repaint();  // Force the component to repaint

                menu.setText("bl");
                menuBar.setForeground(black);
                menu.setIcon(null);
            }
        });
        menu.add(item15);

        menuBar.add(menu);
        panel.add(menuBar);

        return menu;
    }

    public static JButton infoButton(JPanel panel, int x, int y){
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon iconInfo = new ImageIcon("src/Images/info3.png");
        Image imageInfo = iconInfo.getImage();
        Image scaledImageInfo = imageInfo.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);

        JButton button = new JButton();
        button.setIcon(new ImageIcon(scaledImageInfo));
        button.setBounds(x, y, 12, 12);
        button.setBackground(Methods.mainColorTheme());
        button.setToolTipText("info");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GeneCodeInfoWindow gene = new GeneCodeInfoWindow();
                gene.show();
            }
        });

        panel.add(button);

        return button;
    }

    public static void saveRacerData(String nickName, int id, String letters, int year, String colour, String gender, String weaned, int flyed, int scored, double scorePercentage, int wins, String description, String strain, String father, String mother, byte[] image1, byte[] image2, byte[] image3, String gene1, String gene2, String gene3, String gene4, String gene5, String gene6, String gene7, String gene8) {
        String sql = "INSERT INTO Racer_Pigeon(nickname, pigeonId, letters, year, colour, gender, weaned, "
                + "timesFlyed, timesScored, scorePercentage, wins, description, strain, Father, Mother, image1, image2, image3, gene1, gene2, gene3, gene4, gene5, gene6, gene7, gene8) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:src/JudelsPigeonManager");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nickName);
            pstmt.setInt(2, id);
            pstmt.setString(3, letters);
            pstmt.setInt(4, year);
            pstmt.setString(5, colour);
            pstmt.setString(6, gender);
            pstmt.setString(7, weaned);
            pstmt.setInt(8, flyed);
            pstmt.setInt(9, scored);
            pstmt.setDouble(10, scorePercentage);
            pstmt.setInt(11, wins);
            pstmt.setString(12, description);
            pstmt.setString(13, strain);
            pstmt.setString(14, father);
            pstmt.setString(15, mother);
            pstmt.setBytes(16, image1);
            pstmt.setBytes(17, image2);
            pstmt.setBytes(18, image3);
            pstmt.setString(19, gene1);
            pstmt.setString(20, gene2);
            pstmt.setString(21, gene3);
            pstmt.setString(22, gene4);
            pstmt.setString(23, gene5);
            pstmt.setString(24, gene6);
            pstmt.setString(25, gene7);
            pstmt.setString(26, gene8);


            pstmt.executeUpdate();
            System.out.println("Pigeon data saved successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveBreederDataFather(String nickName, int id, String letters, int year, String colour, String gender, String description, String strain, byte[] image1, byte[] image2, byte[] image3, String gene1, String gene2, String gene3, String gene4) {
        String sql = "INSERT INTO Breeder_Pigeon_Father(nickname, pigeonId, letters, year, colour, gender,"
                + "description, strain, image1, image2, image3, gene1, gene2, gene3, gene4) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:src/JudelsPigeonManager");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nickName);
            pstmt.setInt(2, id);
            pstmt.setString(3, letters);
            pstmt.setInt(4, year);
            pstmt.setString(5, colour);
            pstmt.setString(6, gender);
            pstmt.setString(7, description);
            pstmt.setString(8, strain);
            pstmt.setBytes(9, image1);
            pstmt.setBytes(10, image2);
            pstmt.setBytes(11, image3);
            pstmt.setString(12, gene1);
            pstmt.setString(13, gene2);
            pstmt.setString(14, gene3);
            pstmt.setString(15, gene4);

            pstmt.executeUpdate();
            System.out.println("Pigeon data saved successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveBreederDataMother(String nickName, int id, String letters, int year, String colour, String gender, String description, String strain, byte[] image1, byte[] image2, byte[] image3, String gene1, String gene2, String gene3, String gene4) {
        String sql = "INSERT INTO Breeder_Pigeon_Mother(nickname, pigeonId, letters, year, colour, gender,"
                + "description, strain, image1, image2, image3, gene1, gene2, gene3, gene4) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:src/JudelsPigeonManager");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nickName);
            pstmt.setInt(2, id);
            pstmt.setString(3, letters);
            pstmt.setInt(4, year);
            pstmt.setString(5, colour);
            pstmt.setString(6, gender);
            pstmt.setString(7, description);
            pstmt.setString(8, strain);
            pstmt.setBytes(9, image1);
            pstmt.setBytes(10, image2);
            pstmt.setBytes(11, image3);
            pstmt.setString(12, gene1);
            pstmt.setString(13, gene2);
            pstmt.setString(14, gene3);
            pstmt.setString(15, gene4);

            pstmt.executeUpdate();
            System.out.println("Pigeon data saved successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<BreederPigeons> loadPigeonsFatherFromDatabase() {
        ArrayList<BreederPigeons> pigeonList = new ArrayList<>();

        try {
            // Establish a connection to the SQLite database
            String url = "jdbc:sqlite:src/JudelsPigeonManager";
            Connection conn = DriverManager.getConnection(url);

            // Create a statement and execute a query
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Breeder_Pigeon_Father";  // Replace with your actual table name
            ResultSet rs = stmt.executeQuery(query);

            // Iterate over the result set and populate BreederPigeon objects
            while (rs.next()) {
                BreederPigeons pigeon = new BreederPigeons(
                        rs.getString("nickname"),
                        rs.getInt("pigeonId"),
                        rs.getString("letters"),
                        rs.getInt("year"),
                        rs.getString("colour"),
                        rs.getString("gender"),
                        rs.getString("description"),
                        rs.getString("strain"),
                        rs.getBytes("image1"),
                        rs.getBytes("image2"),
                        rs.getBytes("image3"),
                        rs.getString("gene1"),
                        rs.getString("gene2"),
                        rs.getString("gene3"),
                        rs.getString("gene4")
                );
                // Add the BreederPigeon object to the list
                pigeonList.add(pigeon);
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pigeonList;  // Return the populated list
    }



    public static ArrayList<BreederPigeons> loadPigeonsMotherFromDatabase() {
        ArrayList<BreederPigeons> pigeonList = new ArrayList<>();

        try {
            // Establish a connection to the SQLite database
            String url = "jdbc:sqlite:src/JudelsPigeonManager";
            Connection conn = DriverManager.getConnection(url);

            // Create a statement and execute a query
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Breeder_Pigeon_Mother";  // Replace with your actual table name
            ResultSet rs = stmt.executeQuery(query);

            // Iterate over the result set and populate BreederPigeon objects
            while (rs.next()) {
                BreederPigeons pigeon = new BreederPigeons(
                        rs.getString("nickname"),
                        rs.getInt("pigeonId"),
                        rs.getString("letters"),
                        rs.getInt("year"),
                        rs.getString("colour"),
                        rs.getString("gender"),
                        rs.getString("description"),
                        rs.getString("strain"),
                        rs.getBytes("image1"),
                        rs.getBytes("image2"),
                        rs.getBytes("image3"),
                        rs.getString("gene1"),
                        rs.getString("gene2"),
                        rs.getString("gene3"),
                        rs.getString("gene4")
                );
                // Add the BreederPigeon object to the list
                pigeonList.add(pigeon);
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pigeonList;  // Return the populated list
    }

    public static ArrayList<PigeonLoad> loadRacerPigeonsFromDatabase() {
        ArrayList<PigeonLoad> pigeonList = new ArrayList<>();

        try {
            // Establish a connection to the SQLite database
            String url = "jdbc:sqlite:src/JudelsPigeonManager";
            Connection conn = DriverManager.getConnection(url);

            // Create a statement and execute a query
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Racer_Pigeon";  // Replace with your actual table name
            ResultSet rs = stmt.executeQuery(query);

            // Iterate over the result set and populate BreederPigeon objects
            while (rs.next()) {
                PigeonLoad pigeon = new PigeonLoad(
                        rs.getString("nickname"),
                        rs.getInt("pigeonId"),
                        rs.getString("letters"),
                        rs.getInt("year"),
                        rs.getString("colour"),
                        rs.getString("gender"),
                        rs.getString("weaned"),
                        rs.getInt("timesFlyed"),
                        rs.getInt("timesScored"),
                        rs.getDouble("scorePercentage"),
                        rs.getInt("wins"),
                        rs.getString("description"),
                        rs.getString("strain"),
                        rs.getString("father"),
                        rs.getString("mother"),
                        rs.getBytes("image1"),
                        rs.getBytes("image2"),
                        rs.getBytes("image3"),
                        rs.getString("gene1"),
                        rs.getString("gene2"),
                        rs.getString("gene3"),
                        rs.getString("gene4"),
                        rs.getString("gene5"),
                        rs.getString("gene6"),
                        rs.getString("gene7"),
                        rs.getString("gene8")

                );
                // Add the BreederPigeon object to the list
                pigeonList.add(pigeon);
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pigeonList;  // Return the populated list
    }



}
