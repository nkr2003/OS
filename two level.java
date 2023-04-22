import java.util.*;

public class TwoLevelDirectory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, ArrayList<String>> directories = new HashMap<String, ArrayList<String>>();

        while(true) {
            System.out.print("Enter the name of the directory (or 'exit' to quit): ");
            String directoryName = sc.nextLine();

            if(directoryName.equals("exit")) {
                System.out.println("Exiting program.");
                break;
            }

            if(directories.containsKey(directoryName)) {
                System.out.println("Directory already exists. Please enter a different name.");
            } else {
                directories.put(directoryName, new ArrayList<String>());
                System.out.println("Directory added successfully.");
            }
        }

        while(true) {
            System.out.print("Enter the name of the directory where you want to add a file (or 'exit' to quit): ");
            String directoryName = sc.nextLine();

            if(directoryName.equals("exit")) {
                System.out.println("Exiting program.");
                break;
            }

            if(!directories.containsKey(directoryName)) {
                System.out.println("Directory does not exist. Please enter a valid name.");
            } else {
                System.out.print("Enter the name of the file: ");
                String fileName = sc.nextLine();

                ArrayList<String> files = directories.get(directoryName);

                if(files.contains(fileName)) {
                    System.out.println("File already exists. Please enter a different name.");
                } else {
                    files.add(fileName);
                    System.out.println("File added successfully.");
                }
            }
        }

        System.out.println("List of directories and their files:");
        for(String directoryName : directories.keySet()) {
            System.out.println(directoryName);
            ArrayList<String> files = directories.get(directoryName);
            for(String fileName : files) {
                System.out.println("   " +"*" +fileName);
            }
        }
    }
}
