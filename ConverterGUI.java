import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ConverterGUI {
    // Variable to store the loaded image
    private static BufferedImage im1 = null;

    public static void main(String[] args) {
        // Initialize the JFrame (Window)
        JFrame root = new JFrame("Converter");
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setSize(300, 280);
        root.setResizable(false);

        // Initialize the JPanel (Canvas equivalent)
        JPanel canvas1 = new JPanel();
        canvas1.setBackground(Color.ORANGE);
        canvas1.setLayout(null); // Allows exact coordinate positioning
        root.add(canvas1);

        // Title Label
        JLabel label1 = new JLabel("File Converter", SwingConstants.CENTER);
        label1.setOpaque(true);
        label1.setBackground(new Color(176, 196, 222)); // lightsteelblue2 equivalent
        label1.setFont(new Font("Helvetica", Font.PLAIN, 20));
        label1.setBounds(65, 40, 160, 40);
        canvas1.add(label1);

        // Styling for buttons
        Font buttonFont = new Font("Helvetica", Font.BOLD, 12);
        Color buttonBg = new Color(65, 105, 225); // royalblue equivalent
        Color buttonFg = Color.WHITE;

        // Browse Button
        JButton browseButtonJPG = new JButton("      Import JPEG File     ");
        browseButtonJPG.setFont(buttonFont);
        browseButtonJPG.setBackground(buttonBg);
        browseButtonJPG.setForeground(buttonFg);
        browseButtonJPG.setFocusPainted(false);
        browseButtonJPG.setBounds(50, 115, 190, 30);
        canvas1.add(browseButtonJPG);

        // Convert Button
        JButton saveAsButtonPNG = new JButton("Convert JPEG to PNG");
        saveAsButtonPNG.setFont(buttonFont);
        saveAsButtonPNG.setBackground(buttonBg);
        saveAsButtonPNG.setForeground(buttonFg);
        saveAsButtonPNG.setFocusPainted(false);
        saveAsButtonPNG.setBounds(50, 165, 190, 30);
        canvas1.add(saveAsButtonPNG);

        // Action Listener for Import Button
        browseButtonJPG.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select a JPEG File");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG Images", "jpg", "jpeg");
            fileChooser.setFileFilter(filter);
            
            int result = fileChooser.showOpenDialog(root);
            if (result == JFileChooser.APPROVE_OPTION) {
                File importFilePath = fileChooser.getSelectedFile();
                try {
                    im1 = ImageIO.read(importFilePath);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(root, "Could not open image.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action Listener for Convert Button
        saveAsButtonPNG.addActionListener(e -> {
            if (im1 == null) {
                JOptionPane.showMessageDialog(root, "No File selected", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save as PNG");
                
                int result = fileChooser.showSaveDialog(root);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File exportFilePath = fileChooser.getSelectedFile();
                    
                    // Force the .png extension if the user doesn't type it
                    if (!exportFilePath.getName().toLowerCase().endsWith(".png")) {
                        exportFilePath = new File(exportFilePath.getAbsolutePath() + ".png");
                    }
                    
                    try {
                        ImageIO.write(im1, "png", exportFilePath);
                        JOptionPane.showMessageDialog(root, "Conversion Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(root, "Failed to save file.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Show the window
        root.setLocationRelativeTo(null); // Centers the window on screen
        root.setVisible(true);
    }
}