package com.amumu.chapter2;

import java.awt.*;
import java.io.File;
import javax.swing.*;

public class ImageViewer {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            var frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
                });
    }
}

class ImageViewerFrame extends JFrame{
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 400;

    public ImageViewerFrame()
    {
        setSize(DEFAULT_WIDTH,DEFAULT_WIDTH);

        var label = new JLabel();
        add(label);

        var chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        var menu = new JMenu("File");
        menuBar.add(menu);

        var openItem = new JMenuItem("open");
        menu.add(openItem);
        openItem.addActionListener(event -> {
            int result = chooser.showOpenDialog(null);

            if(result == JFileChooser.APPROVE_OPTION){
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });

        var exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event ->System.exit(0));
    }
}
