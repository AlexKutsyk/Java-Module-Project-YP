public class Calculate {
    String name;
    double cost;


    Calculate (String nameProduct, double costProduct) {
        name = nameProduct;
        cost = costProduct;
    }

    public static double sumCost(double cost, double sum) {
        sum = sum + cost;
        return sum;
    }

    public static String compilationList(String name, String list) {
        list = list + "\n" + name;
        return list;
    }

    public static double calculatePayment(double sum, int person) {
        return sum/person;
    }
}
