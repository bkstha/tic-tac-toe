import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);

        String type = scanner.next();

        switch (type.toLowerCase()) {
            case "triangle":
                calculateTriangle(scanner);
                break;
            case "circle":
                calculateCircle(scanner);
                break;
            case "rectangle":
                calculateRectangle(scanner);
                break;
            default:
                System.out.println("not a valid area");
        }
    }

    public static void calculateTriangle(Scanner scanner) {
        double l1 = scanner.nextDouble();
        double l2 = scanner.nextDouble();
        double l3 = scanner.nextDouble();
        double p = (l1 + l2 + l3) / 2;
        System.out.println(Math.sqrt(p * (p - l1) * (p - l2) * (p - l3)));
    }

    public static void calculateCircle(Scanner scanner) {
        double r = scanner.nextDouble();
        System.out.println((3.14 * r * r));
    }

    public static void calculateRectangle(Scanner scanner) {
        double l1 = scanner.nextDouble();
        double l2 = scanner.nextDouble();
        System.out.println(l1 * l2);
    }
}