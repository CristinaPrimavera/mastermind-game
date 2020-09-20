import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class Checker {

    // TODO: usar el foreach donde puedas
    // TODO: leer sobre Enums y tratar de usarlos

    private static Scanner scanner = new Scanner(System.in);
    private int[] numbers = {1, 2, 2, 4};

    public void start() {

        String[] results;

        do {
            System.out.println("Code breaker -> Enter 4 numbers from 1-4:");
            int[] guessedNumbers = arrayPopulator();
            results = numberChecker(guessedNumbers);
            printArray(results);
        } while (!resultsChecker(results));
    }

    public String[] numberChecker(int[] guessedNumbers) {

        String[] results = new String[4];

        for (int i = 0; i < guessedNumbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (guessedNumbers[i] == numbers[j]) {
                    if (i == j) {
                        results[i] = "blanco";
                        break;
                    } else {
                        results[i] = "rojo";
                    }
                }
            }
        }

        return results;
    }

    /**
     * Esta funcion lee del scanner y guarda en un array con lo introducido
     *
     * @return los guess numbers
     * @throws InputMismatchException
     * @throws IllegalArgumentException
     */
    private int[] arrayPopulator() {
        int[] array = new int[4];

        for (int i = 0; i < array.length; i++) {
            try {
                int numberEntered = scanner.nextInt();
                if (numberEntered < 1 || numberEntered > 4) {
                    throw new IllegalArgumentException("not a valid number");
                }
                array[i] = numberEntered;
            } catch (InputMismatchException | IllegalArgumentException ex) {
                System.out.println("you must enter a number between 1 and 4.");
                scanner.next();
                i--;
            }
        }

        return array;
    }

    private boolean resultsChecker(String[] results) {

        for (String color : results) {
            if (!"blanco".equalsIgnoreCase(color)) {
                System.out.println("Try again!");
                return false;
            }
        }

        System.out.println("You won!");
        return true;
    }

    private void printArray(String[] array) {
        System.out.println(Arrays.toString(array));
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
}
