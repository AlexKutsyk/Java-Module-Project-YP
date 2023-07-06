import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double sum = 0;
        String  list = "";
        int person = Input.identifyQuantityPerson();

        while (true) {
            System.out.println("Введите название товара");
            String name = Input.checkName();
            System.out.println("Введите его стоимость в формате рубли,копейки");
            double cost = Input.checkCost();
            Calculate order = new Calculate(name, cost);
            System.out.println("Спасибо! Товар добавлен успешно");
            list += "\n" + order.name;
            sum += order.cost;

            System.out.println("Добавить ещё один товар (введите любое слово) или завершить ввод (введите \"завершить\")?");
            if ((console.next()).equalsIgnoreCase("Завершить")) {
                break;
            } else {
                System.out.println("Добавьте следующий товар");
            }
        }

        console.close();

        double paymentPerson = Calculate.calculatePayment(sum, person);

        Output.reportInfo(paymentPerson, list);
    }

 /*   public static int identifyQuantityPerson() {
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

    public static String inputName() {
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

    public static double inputCost() {
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

    public static void outputInfo(double paymentPerson, String list) {
        System.out.println(String.format("Добавленные товары:%s", list));
        String strPayment = String.format("%.0f", Math.floor(paymentPerson));
        if ((strPayment.length() > 1) && ((strPayment.substring((strPayment.length() - 2), (strPayment.length()-1))).equals("1"))) {
            System.out.println(String.format("Каждый человек должен заплатить %.2f рублей", paymentPerson));
                } else {
            switch (strPayment.substring((strPayment.length() - 1))) {
                case "1" ->
                        System.out.println(String.format("Каждый человек должен заплатить %.2f рубль", paymentPerson));
                case "2", "3", "4" ->
                        System.out.println(String.format("Каждый человек должен заплатить %.2f рубля", paymentPerson));
                default ->
                        System.out.println(String.format("Каждый человек должен заплатить %.2f рублей", paymentPerson));
            }
        }
    }*/
}