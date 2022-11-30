import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try(FileWriter fileWriter = new FileWriter("task.txt")){
            fileWriter.write("""
                     1-кардардын жашын кайтаруучу метод жазыныз,
                     2-мамлекети окшош кардарларды кайтарыныз,
                     3-кардарлардын мамлекетин сорттоп чыгарыныз,
                     4-баардык кардарларды кайтаруучу метод жазыныз.
                     Ал интерфейсти Customer клласына impliments кылып методдорго логикасын жазыныз.
                     Mainдан жазган логиканызды иштетиниз.
                    """);
        }catch (IOException e){
            System.out.println("File not created!");
        }
        try (FileReader fileReader = new FileReader("task.txt")){
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }catch (IOException e){
            System.out.println("File not found!");
        }
        Customer customer1 = new Customer("Iskhak","Abdukhamitov","Kyrgyzstan", LocalDate.of(2002,8,28),"Abdukhamitov@gmail.com");
        Customer customer2 = new Customer("Azamat","Kamalov","Russia", LocalDate.of(2003,1,14),"Kamalov@gmail.com");
        Customer customer3 = new Customer("Mukhammed","Islambekov","Armenia", LocalDate.of(2003,5,10),"Islambekov@gmail.com");
        Customer[] customers = {customer1,customer2,customer3};
        while (true) {
            System.out.print("Choice 1(Similar country), 2(Sort countries), 3(Show all customers): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(Arrays.toString(customer1.similarCountry(scanner.next(), customers)));
                    break;
                case 2:
                    System.out.println(Arrays.toString(customer1.sortCountries(customers)));
                    break;
                case 3:
                    System.out.println(Arrays.toString(customer1.showAllCustomers(customers)));
                    break;
                default:
                    System.out.println("");
                    break;
            }
        }
    }
}