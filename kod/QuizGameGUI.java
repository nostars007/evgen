import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizGameGUI extends JFrame implements ActionListener {
    private String[] questions = {
        "Какой самый большой океан в мире?",
        "Какая столица Франции?",
        "Какая самая высокая гора в мире?",
        "Какая река самая длинная в мире?",
        "В какой стране находится Великая Китайская стена?"
    };

    private String[][] options = {
        {"Атлантический океан", "Индийский океан", "Тихий океан", "Южный океан"},
        {"Берлин", "Мадрид", "Париж", "Лондон"},
        {"Гора Килиманджаро", "Гора Эверест", "Гора Аконкагуа", "Гора Мак-Кинли"},
        {"Амазонка", "Нил", "Янцзы", "Миссисипи"},
        {"Индия", "Япония", "Китай", "Монголия"}
    };

    private int[] answers = {3, 3, 2, 2, 3}; // Правильные ответы

    private int currentQuestion = 0;
    private int score = 0;

    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup optionsGroup;
    private JButton nextButton;

    public QuizGameGUI() {
        setTitle("Викторина по географии");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        questionLabel = new JLabel(questions[currentQuestion]);
        optionButtons = new JRadioButton[4];
        optionsGroup = new ButtonGroup();
        
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton(options[currentQuestion][i]);
            optionButtons[i].setActionCommand(String.valueOf(i + 1));
            optionsGroup.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }

        nextButton = new JButton("Далее");
        nextButton.addActionListener(this);

        setLayout(new BorderLayout());
        add(questionLabel, BorderLayout.NORTH);
        add(optionsPanel, BorderLayout.CENTER);
        add(nextButton, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedOption = Integer.parseInt(optionsGroup.getSelection().getActionCommand());
        if (selectedOption == answers[currentQuestion]) {
            score++;
        }

        currentQuestion++;

        if (currentQuestion < questions.length) {
            questionLabel.setText(questions[currentQuestion]);
            optionsGroup.clearSelection();

            for (int i = 0; i < 4; i++) {
                optionButtons[i].setText(options[currentQuestion][i]);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Вы завершили викторину! Ваш результат: " + score + " из " + questions.length);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new QuizGameGUI().setVisible(true);
        });
    }
}