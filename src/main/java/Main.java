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

}