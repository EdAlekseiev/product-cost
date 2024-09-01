package app;

public class Main {

    public static void main(String[] args) {
        // Отримуємо вхідні дані
        String[] data = getData();
        // Формуємо об'єкт з вхідних даних
        Product product = new Product(data[0],
            Integer.parseInt(data[1]),
            Double.parseDouble(data[2]));

        CostComputable[] calcsCost = {
                new CalcCostBase(),
                new CalcCostDelivery(),
        };
        for(CostComputable calcCost : calcsCost) {
            double cost = calculateCost(product, calcCost);
            String costOutput = formatCostOutput(cost, product);
            getOutput(costOutput);
        }
    }

    // Набір вхідних даних
    public static String[] getData() {
        return new String[] {"abc", "5", "2.5"};
    }

    public static void getOutput(String output) {
        System.out.println(output);
    }

    public static double calculateCost(Product product, CostComputable calcCost) {
        return calcCost.calcCost(product);
    }

    public static String formatCostOutput(double cost, Product product) {
        return product + "\nCost is " +
            Constants.CURRENCY + " " + cost + ".";
    }
}
