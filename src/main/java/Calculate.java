public class Calculate {
    String name;
    double cost;

    Calculate (String nameProduct, double costProduct) {
        name = nameProduct;
        cost = costProduct;
    }

    public static double calculatePayment(double sum, int person) {
        return sum/person;
    }
}
