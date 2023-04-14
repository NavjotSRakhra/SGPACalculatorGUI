package navjot.sgpaCalculatorGUI;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import navjot.sgpaCalculatorGUI.gui.GUI;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        new GUI();
    }
}
