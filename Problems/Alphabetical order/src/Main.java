import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] strings = input.split(" ");
        boolean flag = true;
        String tmp = null;
        for (int i = 0; i < strings.length; i++) {

            if (i != 0 && tmp.compareTo(strings[i]) > 0) {
                flag = false;
                break;
            }
            tmp = strings[i];
        }
        System.out.println(flag);

    }
}