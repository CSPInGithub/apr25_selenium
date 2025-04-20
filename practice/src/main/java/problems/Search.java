package problems;

public class Search {

    public static void main(String[] args) {

        int[] arrOfNumbers = { 2, 3, 5, 3, 6 };
        int numberToSearch = 36;

        if (!getIndexOfNumberToSearch(arrOfNumbers, numberToSearch)) {

            System.out.println(numberToSearch + " not found in the array");

        }

    }

    private static boolean getIndexOfNumberToSearch(int[] arr, int numberToSearch) {

        int sizeofArray = arr.length;
        // System.out.println(sizeofArray);

        boolean number_found = false;
        // int count = 0;

        for (int i = 0; i < sizeofArray; i++) {

            int number = arr[i];

            if (number == numberToSearch) {
                System.out.println(numberToSearch + " found at " + " index " + i);
                // count = count + 1;
                number_found = true;
            } 

        }
        return number_found;

    }

}
