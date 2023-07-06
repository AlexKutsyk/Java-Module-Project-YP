import java.util.Scanner;

public class Input {
    public static int identifyQuantityPerson() {
        Scanner console = new Scanner(System.in);
        System.out.println("На скольких человек необходимо разделить счёт?");
        int quantityPerson;

        while (true) {
            if (console.hasNextInt()) {
                quantityPerson = console.nextInt();
                if (quantityPerson < 1) {
                    System.out.println("Это некорректное значение для подсчёта");
                    System.out.println("Введите корректное количество гостей");
                }
                if (quantityPerson == 1) {
                    System.out.println("Количество человек равно 1 - нет смысла ничего считать и делить");
                    System.out.println("Введите корректное количество гостей");
                }
                if (quantityPerson > 1) {
                    break;
                }
            } else {
                System.out.println("Введите целое число");
                console.next();
            }
        }
        return quantityPerson;
    }

    public static String checkName() {
        Scanner console = new Scanner(System.in);
        String line;
        while (true) {
            if (console.hasNextLine()) {
                line = console.next();
                break;
            } else {
                System.out.println("Убедитесь, что вводите название текстом");
                console.next();
            }
        }
        return line;
    }

    public static double checkCost() {
        Scanner console = new Scanner(System.in);
        double line;
        while (true) {
            if (console.hasNextDouble()) {
                line = console.nextDouble();
                if (line > 0) {
                    break;
                } else {
                    System.out.println("Стоимость товара должна быть больше нуля");
                }
            } else {
                System.out.println("Убедитесь, что вводите дробное число");
                console.next();
            }
        }
        return line;
    }
}
