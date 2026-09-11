import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class predefinedexception {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            int[] arr = {1, 2, 3, 4};
            int i, b;

            FileReader fr = new FileReader("abc.txt");

            System.out.print("Enter array index: ");
            i = sc.nextInt();

            System.out.print("Enter divisor: ");
            b = sc.nextInt();

            System.out.println("Array element: " + arr[i]);
            System.out.println("Division result: " + arr[i] / b);

            fr.close();

        } catch (ArithmeticException e) {
            System.out.println("Exception caught is: " + e.getMessage());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught is: " + e.getMessage());

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
        sc.close();
        System.out.println("Program Closed");
    }
}
}