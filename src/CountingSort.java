import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CountingSort {

    public static void sort(ArrayList<Integer> input, int size) {
        int max = Collections.max(input);
        int[] counts = new int[max + 1];
        int[] output = new int[size];

        for (int i = 0; i < size; i++) {
            int inputElement = input.get(i);
            counts[inputElement]++;
        }

        for (int i = 1; i <= max; i++) {
            counts[i] += counts[i - 1];
        }


        for (int item: input) {
            output[counts[item] - 1] =  item;
            --counts[item];
        }

        for (int item: output) {
            System.out.print(item + "\t");
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<>();
        System.out.println("Enter Size");
        int n = scanner.nextInt();
        System.out.println("Enter Array");
        for (int i = 0; i < n; i++) {
            input.add(scanner.nextInt());
        }
        sort(input, n);
    }
}
