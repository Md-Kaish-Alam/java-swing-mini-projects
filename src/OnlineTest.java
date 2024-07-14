import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener {

    JLabel questionLabel;
    JRadioButton[] options = new JRadioButton[5];
    JButton nextButton, bookmarkButton;
    ButtonGroup optionGroup;

    int score = 0, currentQuestionIndex = 0, bookmarkIndex = 1, tempIndex = 0;
    int[] bookmarkedQuestions = new int[10];

    OnlineTest(String title) {
        super(title);
        questionLabel = new JLabel();
        add(questionLabel);
        optionGroup = new ButtonGroup();

        for (int i = 0; i < 5; i++) {
            options[i] = new JRadioButton();
            add(options[i]);
            optionGroup.add(options[i]);
        }

        nextButton = new JButton("Next");
        bookmarkButton = new JButton("Bookmark");

        nextButton.addActionListener(this);
        bookmarkButton.addActionListener(this);
        add(nextButton);
        add(bookmarkButton);

        displayQuestion();

        questionLabel.setBounds(30, 40, 450, 20);
        options[0].setBounds(50, 80, 100, 20);
        options[1].setBounds(50, 110, 100, 20);
        options[2].setBounds(50, 140, 100, 20);
        options[3].setBounds(50, 170, 100, 20);
        nextButton.setBounds(100, 240, 100, 30);
        bookmarkButton.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            if (isAnswerCorrect()) {
                score++;
            }

            currentQuestionIndex++;
            displayQuestion();

            if (currentQuestionIndex == 9) {
                nextButton.setEnabled(false);
                bookmarkButton.setText("Result");
            }
        }

        if (e.getActionCommand().equals("Bookmark")) {
            JButton bookmark = new JButton("Bookmark" + bookmarkIndex);
            bookmark.setBounds(480, 20 + 30 * bookmarkIndex, 100, 30);
            add(bookmark);
            bookmark.addActionListener(this);
            bookmarkedQuestions[bookmarkIndex] = currentQuestionIndex;
            bookmarkIndex++;
            currentQuestionIndex++;
            displayQuestion();

            if (currentQuestionIndex == 9)
                bookmarkButton.setText("Result");

            setVisible(false);
            setVisible(true);
        }

        for (int i = 0, j = 1; i < bookmarkIndex; i++, j++) {
            if (e.getActionCommand().equals("Bookmark" + j)) {
                if (isAnswerCorrect()) {
                    score++;
                }

                tempIndex = currentQuestionIndex;
                currentQuestionIndex = bookmarkedQuestions[j];
                displayQuestion();
                ((JButton)e.getSource()).setEnabled(false);
                currentQuestionIndex = tempIndex;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (isAnswerCorrect()) {
                score++;
            }
            currentQuestionIndex++;

            JOptionPane.showMessageDialog(this, "Correct answers = " + score);
            System.exit(0);
        }
    }

    void displayQuestion() {
        options[4].setSelected(true);
        if (currentQuestionIndex == 0) {
            questionLabel.setText("Que1: Which one among these is not a primitive datatype?");
            options[0].setText("int");
            options[1].setText("Float");
            options[2].setText("boolean");
            options[3].setText("char");
        }
        if (currentQuestionIndex == 1) {
            questionLabel.setText("Que2: Which class is available to all the class automatically?");
            options[0].setText("Swing");
            options[1].setText("Applet");
            options[2].setText("Object");
            options[3].setText("ActionEvent");
        }
        if (currentQuestionIndex == 2) {
            questionLabel.setText("Que3: Which package is directly available to our class without importing it?");
            options[0].setText("swing");
            options[1].setText("applet");
            options[2].setText("net");
            options[3].setText("lang");
        }
        if (currentQuestionIndex == 3) {
            questionLabel.setText("Que4: String class is defined in which package?");
            options[0].setText("lang");
            options[1].setText("Swing");
            options[2].setText("Applet");
            options[3].setText("awt");
        }
        if (currentQuestionIndex == 4) {
            questionLabel.setText("Que5: Which institute is best for java coaching?");
            options[0].setText("Utek");
            options[1].setText("Aptech");
            options[2].setText("SSS IT");
            options[3].setText("jtek");
        }
        if (currentQuestionIndex == 5) {
            questionLabel.setText("Que6: Which one among these is not a keyword?");
            options[0].setText("class");
            options[1].setText("int");
            options[2].setText("get");
            options[3].setText("if");
        }
        if (currentQuestionIndex == 6) {
            questionLabel.setText("Que7: Which one among these is not a class?");
            options[0].setText("Swing");
            options[1].setText("Actionperformed");
            options[2].setText("ActionEvent");
            options[3].setText("Button");
        }
        if (currentQuestionIndex == 7) {
            questionLabel.setText("Que8: Which one among these is not a function of Object class?");
            options[0].setText("toString");
            options[1].setText("finalize");
            options[2].setText("equals");
            options[3].setText("getDocumentBase");
        }
        if (currentQuestionIndex == 8) {
            questionLabel.setText("Que9: Which function is not present in Applet class?");
            options[0].setText("init");
            options[1].setText("main");
            options[2].setText("start");
            options[3].setText("destroy");
        }
        if (currentQuestionIndex == 9) {
            questionLabel.setText("Que10: Which one among these is not a valid component?");
            options[0].setText("JButton");
            options[1].setText("JList");
            options[2].setText("JButtonGroup");
            options[3].setText("JTextArea");
        }
        questionLabel.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            options[j].setBounds(50, 80 + i, 200, 20);
    }

    boolean isAnswerCorrect() {
        if (currentQuestionIndex == 0)
            return options[1].isSelected();
        if (currentQuestionIndex == 1)
            return options[2].isSelected();
        if (currentQuestionIndex == 2)
            return options[3].isSelected();
        if (currentQuestionIndex == 3)
            return options[0].isSelected();
        if (currentQuestionIndex == 4)
            return options[2].isSelected();
        if (currentQuestionIndex == 5)
            return options[2].isSelected();
        if (currentQuestionIndex == 6)
            return options[1].isSelected();
        if (currentQuestionIndex == 7)
            return options[3].isSelected();
        if (currentQuestionIndex == 8)
            return options[1].isSelected();
        if (currentQuestionIndex == 9)
            return options[2].isSelected();
        return false;
    }

    public static void main(String[] args) {
        new OnlineTest("Online Test of Java");
    }
}
