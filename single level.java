import java.util.*;

public class SLD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> files = new ArrayList<String>();

        while(true) {
            System.out.print("Enter the name of the file (or 'exit' to quit): ");
            String fileName = sc.nextLine();

            if(fileName.equals("exit")) {
                System.out.println("Exiting program.");
                break;
            }

            if(files.contains(fileName)) {
                System.out.println("File already exists. Please enter a different name.");
            } else {
                files.add(fileName);
                System.out.println("File added successfully.");
            }
        }

        System.out.println("List of files:");
        for(String fileName : files) {
            System.out.println(fileName);
        }
    }
}
