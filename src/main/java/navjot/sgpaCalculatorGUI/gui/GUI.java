package navjot.sgpaCalculatorGUI.gui;

import navjot.sgpaCalculator.CalculateSGPA;
import navjot.sgpaCalculator.grade.Grade;
import navjot.sgpaCalculator.subject.SubjectGradeList;
import navjot.sgpaCalculatorGUI.gui.textField.FocusJTextField;
import navjot.sgpaCalculatorGUI.textVerifier.NumericTextVerifier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI {
    private final static String TITLE_OF_APPLICATION = "SGPA Calculator", subjectInputLabelText = "Enter number of subjects: ", SUBMIT = "Submit",
            SUBJECT = "Subject ", CALCULATE = "Calculate", SGPA_CALCULATED_MESSAGE = "Your SGPA is: ", CREDITS = "Made by: Navjot Singh Rakhra",
            SUBJECT_COLUMN_TITLE = "Subject number", GRADE_COLUMN_TITLE = "Grade", CREDITS_COLUMN_TITLE = "Credits", DEFAULT_SUBJECTS_COUNT = "8",
            ERROR_MESSAGE_INVALID_INPUT_IN_SUBJECTS = "Please enter an integral number between 0 and 13 in the number of subjects input",
            ERROR_MESSAGE_INVALID_INPUT_IN_CREDITS = "Please enter an integral number in the credits input";
    private final static Font DEFAULT_TEXT_FONT = new Font(Font.MONOSPACED, Font.PLAIN, 15);
    private final static int WINDOW_SIDE = 250;
    private final static int WINDOW_HEIGHT = 700;
    private final static int WINDOW_WIDTH = 425;
    private final JFrame mainFrame;
    private final JPanel mainPanel;
    private final JLabel subjectInputLabel;
    private final JTextField subjectInputTextField;
    private final JButton submit;
    private final JButton calculateSGPA;
    private JLabel[] subjects;
    private JComboBox<String>[] gradeOptions;
    private JTextField[] credits;

    public GUI() {
        mainFrame = new JFrame();
        mainPanel = new JPanel();
        subjectInputLabel = new JLabel(subjectInputLabelText);
        subjectInputTextField = new FocusJTextField();
        submit = new JButton(SUBMIT);
        calculateSGPA = new JButton(CALCULATE);

        initializeTextFieldAndButton();
        initializeCalculateSGPAButton();
        initializeMainPanel();
        simulateEnteredEightSubjectsAndSubmitButtonClicked();
        initializeMainFrame();
    }

    private void simulateEnteredEightSubjectsAndSubmitButtonClicked() {
        subjectInputTextField.setText(DEFAULT_SUBJECTS_COUNT);
        submitButtonClicked(null);
    }

    private void initializeTextFieldAndButton() {
        subjectInputTextField.setInputVerifier(new NumericTextVerifier());
        subjectInputTextField.setFont(DEFAULT_TEXT_FONT);

        submit.addActionListener(this::submitButtonClicked);
        submit.setFont(DEFAULT_TEXT_FONT);
        submit.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                enterPressed(submit, e);
            }
        });
    }

    private void enterPressed(JButton button, KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            button.doClick();
        }
    }

    private void submitButtonClicked(ActionEvent actionEvent) {
        int size;
        try {
            size = Integer.parseInt(subjectInputTextField.getText());
        } catch (NumberFormatException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(mainFrame, ERROR_MESSAGE_INVALID_INPUT_IN_SUBJECTS);
            return;
        }

        if (size > 12 || size <= 0) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(mainFrame, ERROR_MESSAGE_INVALID_INPUT_IN_SUBJECTS);
            return;
        }

        mainPanel.removeAll();
        initializeMainPanel();
        int height = (int) (mainPanel.getLayout().preferredLayoutSize(mainPanel).getHeight() * (Math.pow((size + 1), 1.00003)));
        height = Math.max(Math.min(height, WINDOW_HEIGHT), WINDOW_SIDE);
        mainPanel.setPreferredSize(new Dimension(WINDOW_WIDTH, height));

        initializeNewItems(size);
        addNewItemsToMainPanel();
    }

    private void initializeNewItems(int size) {
        subjects = new JLabel[size];
        //noinspection unchecked
        gradeOptions = new JComboBox[size];
        credits = new JTextField[size];

        for (int i = 0; i < subjects.length; i++) {
            subjects[i] = new JLabel(SUBJECT + (i + 1));
            subjects[i].setFont(DEFAULT_TEXT_FONT);
        }
        for (int i = 0; i < gradeOptions.length; i++) {
            gradeOptions[i] = new JComboBox<>();
            gradeOptions[i].setFont(DEFAULT_TEXT_FONT);

            for (Grade value : Grade.values()) {
                gradeOptions[i].addItem(value.getUserFriendlyString());
            }
        }
        for (int i = 0; i < credits.length; i++) {
            credits[i] = new FocusJTextField();
            credits[i].setInputVerifier(new NumericTextVerifier());
            credits[i].setFont(DEFAULT_TEXT_FONT);
        }
    }

    private void initializeCalculateSGPAButton() {
        calculateSGPA.addActionListener(this::calculateSGPA);
        calculateSGPA.setFont(DEFAULT_TEXT_FONT);
        calculateSGPA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                enterPressed(calculateSGPA, e);
            }
        });
    }

    private void addNewItemsToMainPanel() {
        int size = credits.length;

        GridBagConstraints g = new GridBagConstraints();

        g.insets = new Insets(0, 10, 0, 0);
        g.weightx = 0.5;
        g.weighty = 0.5;
        g.fill = GridBagConstraints.HORIZONTAL;


        g.gridx = 0;
        g.gridy = 3;
        g.gridwidth = 1;

        JLabel subjectColumnTitle = new JLabel(SUBJECT_COLUMN_TITLE);
        subjectColumnTitle.setFont(DEFAULT_TEXT_FONT);

        mainPanel.add(subjectColumnTitle, g);

        g.insets = new Insets(0, 0, 0, 0);
        g.gridx++;

        JLabel gradeColumnTitle = new JLabel(GRADE_COLUMN_TITLE);
        gradeColumnTitle.setFont(DEFAULT_TEXT_FONT);

        mainPanel.add(gradeColumnTitle, g);

        g.insets = new Insets(0, 0, 0, 10);
        g.gridx++;

        JLabel creditsColumnTitle = new JLabel(CREDITS_COLUMN_TITLE);
        creditsColumnTitle.setFont(DEFAULT_TEXT_FONT);

        mainPanel.add(creditsColumnTitle, g);

        for (int i = 0; i < size; i++) {
            g.insets = new Insets(0, 10, 0, 0);
            g.gridx = 0;
            g.gridy = i + 4;
            mainPanel.add(subjects[i], g);

            g.insets = new Insets(0, 0, 0, 10);
            g.gridx = 1;
            mainPanel.add(gradeOptions[i], g);

            g.gridx = 2;
            g.insets = new Insets(0, 0, 0, 10);
            mainPanel.add(credits[i], g);
            credits[i].setText("1");
        }
        g.insets = new Insets(0, 10, 0, 10);
        g.gridx = 0;
        g.gridy++;
        g.gridwidth = 3;

        mainPanel.add(calculateSGPA, g);

        mainFrame.pack();
        mainFrame.validate();
    }

    private void calculateSGPA(ActionEvent actionEvent) {

        SubjectGradeList subjectGradeList = new SubjectGradeList();
        int size = credits.length;

        for (int i = 0; i < size; i++) {
            for (Grade value : Grade.values()) {
                if (value.getUserFriendlyString().equals(gradeOptions[i].getSelectedItem())) {
                    try {
                        subjectGradeList.add(value, Integer.parseInt(credits[i].getText()));
                    } catch (NumberFormatException e) {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(mainFrame, ERROR_MESSAGE_INVALID_INPUT_IN_CREDITS);
                        return;
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(mainFrame, SGPA_CALCULATED_MESSAGE + Math.rint(CalculateSGPA.compute(subjectGradeList) * 100) / 100);
    }

    private void initializeMainPanel() {
        mainPanel.setPreferredSize(new Dimension(WINDOW_SIDE, WINDOW_SIDE));
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();

        g.insets = new Insets(0, 10, 0, 0);
        g.weightx = 0.5;
        g.weighty = 0.5;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;

        subjectInputLabel.setFont(DEFAULT_TEXT_FONT);

        mainPanel.add(subjectInputLabel, g);


        g.gridx = 1;
        g.gridy = 0;
        g.gridwidth = 2;
        g.insets = new Insets(0, 0, 0, 10);
        mainPanel.add(subjectInputTextField, g);

        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 3;
        g.insets = new Insets(0, 10, 0, 10);
        mainPanel.add(submit, g);

        g.gridx = 0;
        g.gridy = 2;
        g.gridwidth = 3;
        g.weightx = 0.0;

        JLabel credits = new JLabel(CREDITS, SwingConstants.CENTER);
        credits.setFont(DEFAULT_TEXT_FONT);

        mainPanel.add(credits, g);
    }

    private void initializeMainFrame() {
        mainFrame.add(mainPanel);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setTitle(TITLE_OF_APPLICATION);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}
