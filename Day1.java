import java.util.Scanner;

class Day1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter any string: ");
        String n = sc.nextLine();

        char a[] = n.toCharArray();
        int l = a.length;

        for (int i = 0; i < l / 2; i++) {
            char temp = a[i];
            a[i] = a[l - i - 1];
            a[l - i - 1] = temp;
        }

        System.out.println("Reversed string: " + new String(a));
    }
}