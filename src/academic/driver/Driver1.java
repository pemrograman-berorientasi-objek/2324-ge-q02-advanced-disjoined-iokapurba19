package academic.driver;
import academic.model.Controller;
import java.util.Scanner;

/**
 * @author 12S22031 Ioka Purba
 * @author 12S22039 Meilyna Hutajulu
 */

public class Driver1 {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller doThis = new Controller();

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            if(command.equals("---")){
                break;
            }
            doThis.processCommand(command);
        }

        doThis.printData();
        scanner.close();
    }
   
}
