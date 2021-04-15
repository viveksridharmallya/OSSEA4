import java.util.Scanner;

public class  Bear {

    private static boolean isNumberEven(int number) {
        boolean isEven = false;
        if(number%2 == 0) {
            isEven = true; 
        }
        return isEven;
    }

    private static boolean isDivisibleByThreeOrFour(int number) {
        boolean isDivisible = false;
        if(number%3 == 0 || number%4 == 0){
            isDivisible = true;
        }
        return isDivisible;
    }

    private static boolean isDivisibleByFive(int number) {
        boolean isDivisible = false;
        if(number%5 == 0){
            isDivisible = true;
        }
        return isDivisible;
    }

    // The number could satisfy multiple conditions providing multiple outcomes for same number. So using || operator and parallel if conditions to consider all scenarios.
    private static boolean isGamePossible(int number) {
        boolean isGamePossible = false;
        if(number < 84) {
            return false;
        } else if (number == 84) {
            return true;
        } 
        if (isNumberEven(number)) {
            System.out.println("input : " + number + "\t Output : "+ number/2);
            isGamePossible = isGamePossible || isGamePossible(number/2);
        }
        if (isDivisibleByThreeOrFour(number)) {
            int lastDigitMultiple = number%10 * ((number%100)/10);
            System.out.println("last digi  "+ number%10);
            System.out.println("second last digi  "+ (number%100)/10);
            System.out.println("Last digi multiple "+ lastDigitMultiple);
            System.out.println("Last digi multiple "+ lastDigitMultiple);
            System.out.println("input : " + number + "\t Output : "+ (number - lastDigitMultiple));
            isGamePossible =  isGamePossible || isGamePossible(number - lastDigitMultiple);
            // return false;
        } 
        if (isDivisibleByFive(number)) {
            System.out.println("input : " + number + "\t Output : "+ (number - 42));
            return isGamePossible || isGamePossible(number - 42);
        }
        return isGamePossible;
    }

    private static int getInitialNumberOfBears(Scanner inputScanner){
        
        System.out.print(" Enter initial Number of bears : ");
        int initialNumberOfBears = inputScanner.nextInt();
        
        return initialNumberOfBears;
    }

    public static void main(String argsp[]){
        boolean isGamePossible = false;
        Scanner inputScanner = new Scanner(System.in);
        while(!isGamePossible) {
            int initialNumberOfBears = getInitialNumberOfBears(inputScanner);
            isGamePossible = isGamePossible(initialNumberOfBears);
            if(isGamePossible) {
                System.out.println("The game can be won starting with "+ initialNumberOfBears+ " teddy bears.");
            } else {
                System.out.println("Game cannot be won starting with "+ initialNumberOfBears+ " teddy bears.");
            }
        }
        inputScanner.close();
    }
    
}