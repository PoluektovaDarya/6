import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        int size = input.nextInt();
        int[] arr = new int[size];

        for(int i=0; i < size; i++) {
            System.out.printf("Введите %d эллимент массива: ", i);
            arr[i] = input.nextInt();
            System.out.println();
        }
        System.out.println("Введенный массив: "+ Arrays.toString(arr));
        heapSort(arr, size);
        System.out.println("Отсортированный массив: "+ Arrays.toString(arr));

    }

    public static void heapSort(int arr[], int n) {
        // Построить максимальную кучу
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Сортировка
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Сортировка кучи
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int arr[], int n, int i) {
        // Найти наибольший среди кучи, левых дочерних и правых дочерних элементов
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Обмен и продолжение кучи, если корень не самый большой
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}
