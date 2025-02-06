public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = {5,2,6,3,5,6,4,6};
        selectionSort(arr);
        display(arr);
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { 
            int min = i;
            for (int j = i + 1; j < arr.length; j++) { 
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    public static void display(int[] arr) {
        for(int i : arr) {
            System.out.print(i  + " ");
        }
    }
}

