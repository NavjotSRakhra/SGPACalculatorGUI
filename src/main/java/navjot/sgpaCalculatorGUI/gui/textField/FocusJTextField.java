package navjot.sgpaCalculatorGUI.gui.textField;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FocusJTextField extends JTextField {
    public FocusJTextField() {
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                FocusJTextField.this.select(0, getText().length());
            }

            @Override
            public void focusLost(FocusEvent e) {
                FocusJTextField.this.select(0, 0);
            }
        });
    }
}
