package Screens;

import com.toedter.calendar.JDateChooser;
import org.example.BreederPigeons;
import org.example.Methods;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;



public class AddRacerWindow {
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JTextField nickNameField;
    private JTextField idField;
    private JTextField yearField;
    private JTextField lettersField;
    private JTextField flyedField;
    private JTextField scoredField;
    private JMenuBar colorMenuBar;
    private JMenu colorMenu;
    private JMenuItem c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12;
    private JMenuBar genderMenuBar;
    private JMenu genderMenu;
    private JMenuItem g1, g2;
    private JButton button, backBtn;
    private JLabel iLabel1, iLabel2, iLabel3;
    private JButton button1, button2, button3;
    private JLabel required1, required2, required3, required4, required5;
    private JTextArea descriptionArea;
    private JLabel textAreaCharCounter;
    private JTextField strainField;
    private JTextField winsField;
    private JMenuBar fatherMenuBar, motherMenuBar;
    private JMenu fatherMenu, motherMenu;
    private JMenuItem father1, father2, father3, father4, father5;
    private JMenuItem mother1, mother2, mother3, mother4, mother5;
    private String gC1;
    private String gC2;
    private String gC3;
    private String gC4;
    private String gC5;
    private String gC6;
    private String gC7;
    private String gC8;


    public AddRacerWindow() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<BreederPigeons> FatherList = Methods.loadPigeonsFatherFromDatabase();
        ArrayList<BreederPigeons> MotherList = Methods.loadPigeonsMotherFromDatabase();

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


//nickname input --------------------------------------------------------
        nickNameField = new JTextField("Nickname");
        nickNameField.setFont(new Font("Arial", Font.BOLD, 12));
        nickNameField.setColumns(10);
        nickNameField.setBorder(new LineBorder(new Color(234, 21, 71), 2));
        nickNameField.setBounds(10, 80, 100, 20);
        nickNameField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (nickNameField.getText().equals("Nickname"))
                    nickNameField.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (nickNameField.getText().equals(""))
                    nickNameField.setText("Nickname");
            }
        });
        panel.add(nickNameField);

        label = new JLabel("(Optional)");
        label.setFont(new Font("Arial", Font.PLAIN, 8));
        label.setBounds(10, 95, 100, 20);
        panel.add(label);
//........................................................................

//id input -------------------------------------------------------------------
        required1 = new JLabel();
        required1.setVisible(false);
        Methods.requiredLabel(required1, panel,120,68);

        idField = new JTextField("ID");
        idField.setFont(new Font("Arial", Font.BOLD, 12));
        idField.setColumns(10);
        idField.setBorder(new LineBorder(new Color(234, 21, 71), 2));
        idField.setBounds(120, 80, 100, 20);
        idField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (idField.getText().equals("ID"))
                    idField.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (idField.getText().equals(""))
                    idField.setText("ID");
            }
        });
        panel.add(idField);
//........................................................................

//year input ------------------------------------------------------------------
        required2 = new JLabel();
        Methods.requiredLabel(required2, panel,230, 68);

        yearField = new JTextField("Year");
        yearField.setFont(new Font("Arial", Font.BOLD, 12));
        yearField.setColumns(10);
        yearField.setBorder(new LineBorder(new Color(234, 21, 71), 2));
        yearField.setBounds(230, 80, 100, 20);
        yearField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (yearField.getText().equals("Year"))
                    yearField.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (yearField.getText().equals(""))
                    yearField.setText("Year");
            }
        });
        panel.add(yearField);
//...............................................................................

//letters field-----------------------------------------------------------------
        required3 = new JLabel();
        Methods.requiredLabel(required3, panel,340,68);

        lettersField = new JTextField("Letters");
        lettersField.setFont(new Font("Arial", Font.BOLD, 12));
        lettersField.setColumns(10);
        lettersField.setBorder(new LineBorder(new Color(234, 21, 71), 2));
        lettersField.setBounds(340, 80, 100, 20);
        lettersField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (lettersField.getText().equals("Letters"))
                    lettersField.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (lettersField.getText().equals(""))
                    lettersField.setText("Letters");
            }
        });
        panel.add(lettersField);
//...........................................................................

//colours input ----------------------------------------------------------------
        required4 = new JLabel();
        Methods.requiredLabel(required4, panel,450,68);

        colorMenuBar = new JMenuBar();
        colorMenuBar.setBorder(new LineBorder(Color.BLACK, 2));
        colorMenuBar.setBackground(Methods.mainColorTheme());
        colorMenu = new JMenu("Color");
        ImageIcon icon = new ImageIcon("src/DOWN_ARROW.png");
        Image image2_1 = icon.getImage();
        Image scaledImage2 = image2_1.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage2);
        colorMenu.setIcon(icon);
        colorMenu.setHorizontalTextPosition(SwingConstants.LEFT);

        c1 = new JMenuItem();
        c1.setText("BB");
        c2 = new JMenuItem();
        c2.setText("CH");
        c3 = new JMenuItem();
        c3.setText("BB WF");
        c4 = new JMenuItem();
        c4.setText("CH WF");
        c5 = new JMenuItem();
        c5.setText("BB PD");
        c6 = new JMenuItem();
        c6.setText("CH PD");
        c7 = new JMenuItem();
        c7.setText("DRK CH");
        c8 = new JMenuItem();
        c8.setText("RED CH");
        c9 = new JMenuItem();
        c9.setText("BLACK");
        c10 = new JMenuItem();
        c10.setText("GRIZZLE");
        c11 = new JMenuItem();
        c11.setText("DUNN");
        c12 = new JMenuItem();
        c12.setText("WHITE");
        colorMenu.add(c1);
        colorMenu.add(c2);
        colorMenu.add(c3);
        colorMenu.add(c4);
        colorMenu.add(c5);
        colorMenu.add(c6);
        colorMenu.add(c7);
        colorMenu.add(c8);
        colorMenu.add(c9);
        c1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("BB");
                colorMenu.setIcon(null);
                colorMenuBar.setBackground(Color.WHITE);
                colorMenuBar.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
            }
        });
        c2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("CH");
                colorMenu.setIcon(null);
                colorMenuBar.setBackground(Color.WHITE);
                colorMenuBar.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
            }
        });
        c3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("BB WF");
                colorMenu.setIcon(null);
                colorMenuBar.setBackground(Color.WHITE);
                colorMenuBar.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
            }
        });
        c4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("CH WF");
                colorMenu.setIcon(null);
                colorMenuBar.setBackground(Color.WHITE);
                colorMenuBar.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
            }
        });
        c5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("BB PD");
                colorMenu.setIcon(null);
                colorMenuBar.setBackground(Color.WHITE);
                colorMenuBar.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
            }
        });
        c6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("CH PD");
                colorMenu.setIcon(null);
                colorMenuBar.setBackground(Color.WHITE);
                colorMenuBar.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
            }
        });
        c7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("DRK CH");
                colorMenu.setIcon(null);
                colorMenuBar.setBackground(Color.WHITE);
                colorMenuBar.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
            }
        });
        c8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("RED CH");
                colorMenu.setIcon(null);
                colorMenuBar.setBackground(Color.WHITE);
                colorMenuBar.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
            }
        });
        c9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("BLACK");
                colorMenu.setIcon(null);
                colorMenuBar.setBackground(Color.WHITE);
                colorMenuBar.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
            }
        });
        c10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("GRIZZLE");
                colorMenu.setIcon(null);
                colorMenuBar.setBackground(Color.WHITE);
                colorMenuBar.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
            }
        });
        c11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("DUNN");
                colorMenu.setIcon(null);
                colorMenuBar.setBackground(Color.WHITE);
                colorMenuBar.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
            }
        });
        c12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorMenu.setText("WHITE");
                colorMenu.setIcon(null);
                colorMenuBar.setBackground(Color.WHITE);
                colorMenuBar.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
            }
        });
        colorMenu.add(c10);
        colorMenu.add(c11);
        colorMenu.add(c12);
        colorMenuBar.add(colorMenu);
        colorMenuBar.setBounds(450, 80, 60, 20);
        panel.add(colorMenuBar);
//.............................................................................

//gender input --------------------------------------------------------------
        required5 = new JLabel();
        Methods.requiredLabel(required5, panel,520,68);

        genderMenuBar = new JMenuBar();
        genderMenuBar.setBorder(new LineBorder(Color.BLACK, 2));
        genderMenuBar.setBounds(520, 80, 70, 20);
        genderMenuBar.setBackground(new Color(234, 21, 71));
        genderMenu = new JMenu("Gender");
        genderMenu.setIcon(icon);
        genderMenu.setHorizontalTextPosition(SwingConstants.LEFT);
        g1 = new JMenuItem();
        g1.setText("C");
        ImageIcon iconMale = new ImageIcon("src/Male_Icon.png");
        Image imageM = iconMale.getImage();
        Image scaledImageM = imageM.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH);
        g1.setIcon(new ImageIcon(scaledImageM));
        g1.setHorizontalTextPosition(SwingConstants.LEFT);
        g1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genderMenu.setText("C");
                ImageIcon iconMale = new ImageIcon("src/Male_Icon.png");
                Image imageM = iconMale.getImage();
                Image scaledImageM = imageM.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH);
                ImageIcon iconM = new ImageIcon(scaledImageM);
                genderMenuBar.setBorder(new LineBorder(Methods.mainColorTheme(), 2));

                genderMenu.setIcon(iconM);

                genderMenuBar.setBackground(Color.WHITE);
            }
        });
        g2 = new JMenuItem();
        g2.setText("H");
        ImageIcon iconFemale = new ImageIcon("src/Female_Icon.png");
        Image imageF = iconFemale.getImage();
        Image scaledImageF = imageF.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH);
        g2.setIcon(new ImageIcon(scaledImageF));
        g2.setHorizontalTextPosition(SwingConstants.LEFT);
        g2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genderMenu.setText("H");

                ImageIcon iconFemale = new ImageIcon("src/Female_Icon.png");
                Image imageF = iconFemale.getImage();
                Image scaledImageF = imageF.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH);
                ImageIcon iconF = new ImageIcon(scaledImageF);
                genderMenuBar.setBorder(new LineBorder(Methods.mainColorTheme(), 2));


                genderMenu.setIcon(iconF);

                genderMenuBar.setBackground(Color.WHITE);
            }
        });
        genderMenu.add(g1);
        genderMenu.add(g2);
        genderMenuBar.add(genderMenu);
        panel.add(genderMenuBar);
//...........................................................................
//Date weaned input---------------------------------------------------------
        Methods dateWeaned = new Methods();

        JDateChooser dater = dateWeaned.datePicker(panel);
        dater.setBounds(600, 80, 120, 20);

        Methods.optionalLabel(panel, 600, 100);
//.......................................................................

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)size.getWidth();
        int height = (int)size.getHeight();

        int imageX = width - 160;
//image upload 1 ------------------------------------------------------------------------------------------
        ImageIcon uploadImageIcon = new ImageIcon("src/UPLOAD_IMAGE.png");
        Image upload = uploadImageIcon.getImage();
        Image scaledImageUploader = upload.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon uploadeImageIcon = new ImageIcon(scaledImageUploader);

        button1 = new JButton("Browse");
        button1.setBounds(imageX, 80, 150, 150);
        button1.setFont(new Font("Arial", Font.BOLD, 13));
        button1.setIcon(uploadeImageIcon);
        button1.setHorizontalTextPosition(SwingConstants.CENTER);
        button1.setVerticalTextPosition(SwingConstants.BOTTOM);
        button1.setBorder(new LineBorder(Color.BLACK, 2));
        button1.setBackground(Methods.mainColorTheme());
        button1.setFocusable(true);
        button1.setFocusPainted(true);

        panel.add(button1);

        iLabel1 = new JLabel();
        iLabel1.setBounds(imageX, 80, 150, 150);
        iLabel1.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
        iLabel1.setForeground(Color.WHITE);
        panel.add(iLabel1);

        Methods.uploadImageButtonListener(button1, frame, iLabel1);

        label = new JLabel("Upload Image 1:");
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setBounds(imageX, 66, 100, 14);
        panel.add(label);

        Methods.optionalLabel(panel, imageX, 230);
//......................................................................................
//image upload 2 -----------------------------------------------------------------------
        button2 = new JButton("Browse");
        button2.setBounds(imageX, 260, 150, 150);
        button2.setFont(new Font("Arial", Font.BOLD, 13));
        button2.setIcon(uploadeImageIcon);
        button2.setHorizontalTextPosition(SwingConstants.CENTER);
        button2.setVerticalTextPosition(SwingConstants.BOTTOM);
        button2.setBorder(new LineBorder(Color.BLACK, 2));
        button2.setBackground(Methods.mainColorTheme());
        button2.setFocusable(true);
        button2.setFocusPainted(true);

        panel.add(button2);

        iLabel2 = new JLabel();
        iLabel2.setBounds(imageX, 260, 150, 150);
        iLabel2.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
        iLabel2.setForeground(Color.WHITE);
        panel.add(iLabel2);

        Methods.uploadImageButtonListener(button2, frame, iLabel2);

        label = new JLabel("Upload Image 2:");
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setBounds(imageX, 246, 100, 14);
        panel.add(label);

        Methods.optionalLabel(panel, imageX, 410);
//......................................................................................
//image upload 3 -----------------------------------------------------------------------
        button3 = new JButton("Browse");
        button3.setBounds(imageX, 440, 150, 150);
        button3.setFont(new Font("Arial", Font.BOLD, 13));
        button3.setIcon(uploadeImageIcon);
        button3.setHorizontalTextPosition(SwingConstants.CENTER);
        button3.setVerticalTextPosition(SwingConstants.BOTTOM);
        button3.setBorder(new LineBorder(Color.BLACK, 2));
        button3.setBackground(Methods.mainColorTheme());
        button3.setFocusable(true);
        button3.setFocusPainted(true);

        panel.add(button3);

        iLabel3 = new JLabel();
        iLabel3.setBounds(imageX, 440, 150, 150);
        iLabel3.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
        iLabel3.setForeground(Color.WHITE);
        panel.add(iLabel3);

        Methods.uploadImageButtonListener(button3, frame, iLabel3);

        label = new JLabel("Upload Image 3:");
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setBounds(imageX, 426, 100, 14);
        panel.add(label);

        Methods.optionalLabel(panel, imageX, 590);
//......................................................................................
//flyed input --------------------------------------------------------
        flyedField = new JTextField("Times Flyed");
        flyedField.setFont(new Font("Arial", Font.BOLD, 12));
        flyedField.setColumns(10);
        flyedField.setBorder(new LineBorder(new Color(234, 21, 71), 2));
        flyedField.setBounds(10, 120, 100, 20);
        flyedField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (flyedField.getText().equals("Times Flyed"))
                    flyedField.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (flyedField.getText().equals(""))
                    flyedField.setText("Times Flyed");
            }
        });
        panel.add(flyedField);

        label = new JLabel("(Optional)");
        label.setFont(new Font("Arial", Font.PLAIN, 8));
        label.setBounds(10, 135, 100, 20);
        panel.add(label);
//........................................................................
//scored input --------------------------------------------------------
        scoredField = new JTextField("Times Scored");
        scoredField.setFont(new Font("Arial", Font.BOLD, 12));
        scoredField.setColumns(10);
        scoredField.setBorder(new LineBorder(new Color(234, 21, 71), 2));
        scoredField.setBounds(120, 120, 100, 20);
        scoredField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (scoredField.getText().equals("Times Scored"))
                    scoredField.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (scoredField.getText().equals(""))
                    scoredField.setText("Times Scored");
            }
        });
        panel.add(scoredField);

        label = new JLabel("(Optional)");
        label.setFont(new Font("Arial", Font.PLAIN, 8));
        label.setBounds(120, 135, 100, 20);
        panel.add(label);
//........................................................................
//wins input ----------------------------------------------------------------------
        winsField = new JTextField("Wins");
        winsField.setFont(new Font("Arial", Font.BOLD, 12));
        winsField.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
        winsField.setBounds(230, 120, 100, 20);
        winsField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (winsField.getText().equals("Wins"))
                    winsField.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (winsField.getText().equals(""))
                    winsField.setText("Wins");
            }
        });
        panel.add(winsField);

        Methods.optionalLabel(panel, 230,140);
//...................................................................................
// Description input ----------------------------------------------------------------
        JTextArea descriptionArea = new JTextArea("Description...");
        descriptionArea.setFont(new Font("Arial", Font.BOLD, 13));
        descriptionArea.setBounds(10, 180, 220, 100);
        descriptionArea.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (descriptionArea.getText().equals("Description..."))
                    descriptionArea.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (descriptionArea.getText().equals(""))
                    descriptionArea.setText("Description...");
            }
        });

        // Limit to 50 characters using DocumentFilter
        ((AbstractDocument) descriptionArea.getDocument()).setDocumentFilter(new DocumentFilter() {
            private static final int MAX_CHARACTERS = 75;

            @Override
            public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + string.length() <= MAX_CHARACTERS) {
                    super.insertString(fb, offset, string, attr);
                } else {
                    Toolkit.getDefaultToolkit().beep();  // Optional: beep if limit exceeded
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
                if (fb.getDocument().getLength() + text.length() - length <= MAX_CHARACTERS) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    Toolkit.getDefaultToolkit().beep();  // Optional: beep if limit exceeded
                }
            }
        });

        // Add character counter -------------------------------------------------------------
        JLabel textAreaCharCounter = new JLabel();
        textAreaCharCounter.setFont(new Font("Arial", Font.BOLD, 10));
        textAreaCharCounter.setBounds(152, 280, 100, 11);
        textAreaCharCounter.setText("Characters: 0/75");


        // Add DocumentListener to update character count
        descriptionArea.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateCharCount();
            }

            public void removeUpdate(DocumentEvent e) {
                updateCharCount();
            }

            public void changedUpdate(DocumentEvent e) {
                updateCharCount();
            }

            private void updateCharCount() {
                int charCount = descriptionArea.getText().length();
                textAreaCharCounter.setText("Characters: " + charCount + "/75");
            }
        });

        // Add components to the panel
        panel.add(descriptionArea);
        panel.add(textAreaCharCounter);

        Methods.optionalLabel(panel, 10, 280);
//...................................................................................
//strain input ----------------------------------------------------------------------
        strainField = new JTextField("Strain");
        strainField.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
        strainField.setBounds(340, 180, 380, 20);
        strainField.setFont(new Font("Arial", Font.BOLD, 12));
        strainField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (strainField.getText().equals("Strain"))
                    strainField.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (strainField.getText().equals(""))
                    strainField.setText("Strain");
            }
        });
        panel.add(strainField);

        Methods.optionalLabel(panel, 340, 200);

//father input -------------------------------------------------------------
        fatherMenuBar = new JMenuBar();
        fatherMenuBar.setOpaque(true);
        fatherMenuBar.setBorder(new LineBorder(Color.BLACK, 2));
        fatherMenuBar.setBounds(800, 80, 100, 20);
        fatherMenuBar.setBackground(Methods.mainColorTheme());
        fatherMenu = new JMenu("Sire/Father");
        fatherMenu.setBackground(Methods.mainColorTheme());
        fatherMenu.setIcon(icon);
        fatherMenu.setFont(new Font("Arial", Font.BOLD, 12));
        fatherMenu.setHorizontalTextPosition(SwingConstants.LEFT);
        for (int ii = 0; ii < FatherList.size(); ii++){
            JMenuItem menuItem = new JMenuItem();
            menuItem.setText(FatherList.get(ii).getNickname() + "  (" +String.valueOf(FatherList.get(ii).getId()) + ")");
            fatherMenu.add(menuItem);

            // Capture the value of i at this point in a final variable
            final int selectedIndex = ii;

            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Use selectedIndex instead of j
                    fatherMenu.setText(FatherList.get(selectedIndex).getNickname() + "  (" +String.valueOf(FatherList.get(selectedIndex).getId()) + ")");
                    gC1 = FatherList.get(selectedIndex).getGene1();
                    gC2 = FatherList.get(selectedIndex).getGene2();
                    gC3 = FatherList.get(selectedIndex).getGene3();
                    gC4 = FatherList.get(selectedIndex).getGene4();
                    System.out.println(selectedIndex);

                    fatherMenuBar.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
                    fatherMenuBar.setBackground(Color.WHITE);
                    fatherMenu.setIcon(null);
                }
            });
        }

        fatherMenuBar.add(fatherMenu);
        panel.add(fatherMenuBar);
// ........................................................................
//mother input -------------------------------------------------------------
        motherMenuBar = new JMenuBar();
        motherMenuBar.setOpaque(true);
        motherMenuBar.setBorder(new LineBorder(Color.BLACK, 2));
        motherMenuBar.setBounds(910, 80, 100, 20);
        motherMenuBar.setBackground(Methods.mainColorTheme());
        motherMenu = new JMenu("Dam/Mother");
        motherMenu.setBackground(Methods.mainColorTheme());
        motherMenu.setFont(new Font("Arial", Font.BOLD, 12));
        motherMenu.setIcon(icon);
        motherMenu.setHorizontalTextPosition(SwingConstants.LEFT);

        for (int ii = 0; ii < MotherList.size(); ii++){
            JMenuItem menuItem = new JMenuItem();
            menuItem.setText(MotherList.get(ii).getNickname() + "  (" +String.valueOf(MotherList.get(ii).getId()) + ")");
            motherMenu.add(menuItem);

            // Capture the value of i at this point in a final variable
            final int selectedIndex2 = ii;

            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Use selectedIndex instead of j
                    motherMenu.setText(MotherList.get(selectedIndex2).getNickname() + "  (" +String.valueOf(MotherList.get(selectedIndex2).getId()) + ")");
                    gC5 = MotherList.get(selectedIndex2).getGene1();
                    gC6 = MotherList.get(selectedIndex2).getGene2();
                    gC7 = MotherList.get(selectedIndex2).getGene3();
                    gC8 = MotherList.get(selectedIndex2).getGene4();
                    System.out.println(selectedIndex2);

                    motherMenuBar.setBorder(new LineBorder(Methods.mainColorTheme(), 2));
                    motherMenuBar.setBackground(Color.WHITE);
                    motherMenu.setIcon(null);
                }
            });
        }

        motherMenuBar.add(motherMenu);
        panel.add(motherMenuBar);
//.................................................................................



//the submit / add button -------------------------------------------------------
        int halfscreen = width / 2;

        button = new JButton("Add Racer");
        button.setBounds(halfscreen - 100, 600, 200, 50);
        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setBorder(new LineBorder(Color.BLACK, 2));
        button.setBackground(Methods.mainColorTheme());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id_calc = idField.getText();
                String year_calc = yearField.getText();
                String letters = lettersField.getText();
                String colour = colorMenu.getText();
                String gender_calc = genderMenu.getText();

                // Use equals() for string comparison
                if (!id_calc.equals("ID") && !year_calc.equals("Year") && !letters.equals("Letters") && !colour.equals("Colour") && !gender_calc.equals("Gender")) {
                    try {
                        String nickname = nickNameField.getText();

                        int id = Integer.parseInt(id_calc);

                        // Parse the year directly into an int
                        int formattedYear = Integer.parseInt(year_calc);

                        // Ensure gender is not empty before accessing charAt
                        char gender = gender_calc.charAt(0);
                        String formattedGender = String.valueOf(gender);

                        Date weaned = dater.getDate();

                        // Use the correct format
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                        String formattedDate = dateFormat.format(weaned);

                        byte[] image1 = Methods.getImageSaveFormat(iLabel1);
                        byte[] image2 = Methods.getImageSaveFormat(iLabel2);
                        byte[] image3 = Methods.getImageSaveFormat(iLabel3);

                        String flyed_calc = flyedField.getText();
                        int flyed = Integer.parseInt(flyed_calc);

                        String scored_calc = scoredField.getText();
                        int scored = Integer.parseInt(scored_calc);

                        // Calculate score percentage only if flyed is greater than 0 to avoid division by zero
                        double scorePercentage = flyed > 0 ? (Double.parseDouble(scored_calc) / flyed) * 100 : 0;

                        String description = descriptionArea.getText();
                        String strain = strainField.getText();

                        String wins_calc = winsField.getText();
                        int wins = Integer.parseInt(wins_calc);

                        String father = fatherMenu.getText();
                        String mother = motherMenu.getText();

                        // Call the save method
                        Methods.saveRacerData(nickname, id, letters, formattedYear, colour, formattedGender, formattedDate, flyed, scored, scorePercentage, wins, description, strain, father, mother, image1, image2, image3, gC1, gC2, gC3, gC4, gC5, gC6, gC7, gC8);

                        // Print output for debugging
                        System.out.println(nickname + "\n" +
                                id + "\n" +
                                formattedYear + "\n" +
                                letters + "\n" +
                                colour + "\n" +
                                formattedGender + "\n" +
                                formattedDate + "\n" +
                                flyed + "\n" +
                                scored + "\n" +
                                scorePercentage + "%\n" +
                                description + "\n" +
                                strain + "\n" +
                                wins + "\n" +
                                image1 + "\n" +
                                image2 + "\n" +
                                image3 + "\n" +
                                father + "\n" +
                                mother + "\n");


                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(frame, e1.getMessage());
                        required1.setVisible(true);
                        required2.setVisible(true);
                        required3.setVisible(true);
                        required4.setVisible(true);
                        required5.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Some required inputs are missing.");
                    required1.setVisible(true);
                    required2.setVisible(true);
                    required3.setVisible(true);
                    required4.setVisible(true);
                    required5.setVisible(true);
                }
            }
        });

        panel.add(button);
//..............................................................................

    }
    public void show(){ frame.setVisible(true); }
}
