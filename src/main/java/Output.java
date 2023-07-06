public class Output {
    public static void reportInfo(double paymentPerson, String list) {
        System.out.println(String.format("Добавленные товары:%s", list));
        String strPayment = String.format("%.0f", Math.floor(paymentPerson));
        String rub;
        if ((strPayment.length() > 1) && ((strPayment.substring((strPayment.length() - 2), (strPayment.length()-1))).equals("1"))) {
            rub = "рублей";
        } else {
            switch (strPayment.substring((strPayment.length() - 1))) {
                case "1" -> rub = "рубль";
                case "2", "3", "4" -> rub = "рубля";
                default -> rub = "рублей";
            }
        }
        System.out.println((String.format("Каждый человек должен заплатить %.2f ", paymentPerson)) + rub);
    }
}
