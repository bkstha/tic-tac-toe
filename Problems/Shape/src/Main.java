import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        String result = getResult(input);

        if (result.equals("error")) {
            System.out.println("There is no such shape!");
        } else {
            System.out.printf("You have chosen a %s", result);
        }


    }

    public static String getResult(int input) {
        switch (input) {
            case 1:
                return "square";
            case 2:
                return "circle";
            case 3:
                return "triangle";
            case 4:
                return "rhombus";
            default:
                return "error";
        }
    }
}