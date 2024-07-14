import java.util.Scanner;

public class QuizGame {

    public static void main(String[] args) {
        // Вопросы и ответы
        String[] questions = {
            "Какой самый большой океан в мире?",
            "Какая столица Франции?",
            "Какая самая высокая гора в мире?",
            "Какая река самая длинная в мире?",
            "В какой стране находится Великая Китайская стена?"
        };

        String[][] options = {
            {"1) Атлантический океан", "2) Индийский океан", "3) Тихий океан", "4) Южный океан"},
            {"1) Берлин", "2) Мадрид", "3) Париж", "4) Лондон"},
            {"1) Гора Килиманджаро", "2) Гора Эверест", "3) Гора Аконкагуа", "4) Гора Мак-Кинли"},
            {"1) Амазонка", "2) Нил", "3) Янцзы", "4) Миссисипи"},
            {"1) Индия", "2) Япония", "3) Китай", "4) Монголия"}
        };

        int[] answers = {3, 3, 2, 2, 3}; // Правильные ответы

        int score = 0;
        Scanner scanner = new Scanner(System.in);

        // Приветственное сообщение
        System.out.println("Добро пожаловать в викторину по географии!");

        // Основной цикл викторины
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Ваш ответ: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == answers[i]) {
                System.out.println("Правильно!");
                score++;
            } else {
                System.out.println("Неправильно! Правильный ответ: " + options[i][answers[i] - 1]);
            }

            System.out.println();
        }

        // Результат викторины
        System.out.println("Вы завершили викторину!");
        System.out.println("Ваш результат: " + score + " из " + questions.length);

        scanner.close();
    }
}
