import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Calculate order;
        double sum = 0;
        String list = "";

        int person = identifyQuantityPerson();

        Scanner console = new Scanner(System.in);
        System.out.println("Введите название товара и его стоимость через пробел. Стоимость должна быть в формате рубли.копейки");

        while (true) {
            order = new Calculate(console.next(), console.nextDouble());
            if (order.cost > 0) {
                list = order.compilationList(order.name, list);
                sum = order.sumCost(order.cost, sum);
                System.out.println("Спасибо! Товар добавлен успешно");
                System.out.println("Добавить ещё один товар/ввести любое слово/ или завершить/ввести завершить/?");
                String requestEnd = console.next();
                if (requestEnd.equalsIgnoreCase("Завершить")) {
                    break;
                } else {
                    System.out.println("Добавьте следующий товар");
                }
            } else {
                System.out.println("Стоимость товара должна быть больше нуля");
            }
        }

        console.close();

        double paymentPerson = order.calculatePayment(sum, person);

        outputInfo(paymentPerson, list);
    }

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
                case "5", "6", "7", "8", "9", "0" ->
                        System.out.println(String.format("Каждый человек должен заплатить %.2f рублей", paymentPerson));
            }
        }
    }
}