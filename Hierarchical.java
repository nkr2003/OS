import java.util.*;

public class HierarchicalFileOrganization {
    private static final String EXIT = "exit";
    private static final String ROOT = "root";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, ArrayList<String>> directoryToFileMap = new HashMap<>();
        Map<String, String> directoryToParentMap = new HashMap<>();

        while(true) {
            System.out.print("Enter the name of the directory (or 'exit' to quit): ");
            String directoryName = sc.nextLine();

            if(directoryName.equals(EXIT)) {
                System.out.println("Exiting program.");
                break;
            }

            System.out.print("Enter the name of the parent directory (or 'root' if this is the root directory): ");
            String parentDirectoryName = sc.nextLine();

            if(parentDirectoryName.equals(EXIT)) {
                System.out.println("Exiting program.");
                break;
            }

            if(!ROOT.equals(parentDirectoryName) && !directoryToParentMap.containsKey(parentDirectoryName)) {
                System.out.println("Parent directory does not exist. Please enter a valid name.");
            } else {
                if(directoryToFileMap.containsKey(directoryName)) {
                    System.out.println("Directory already exists. Please enter a different name.");
                } else {
                    directoryToFileMap.put(directoryName, new ArrayList<String>());
                    directoryToParentMap.put(directoryName, parentDirectoryName);
                    System.out.println("Directory added successfully.");
                }
            }
        }

        while(true) {
            System.out.print("Enter the name of the directory where you want to add a file (or 'exit' to quit): ");
            String directoryName = sc.nextLine();

            if(directoryName.equals(EXIT)) {
                System.out.println("Exiting program.");
                break;
            }

            if(!directoryToFileMap.containsKey(directoryName)) {
                System.out.println("Directory does not exist. Please enter a valid name.");
            } else {
                System.out.print("Enter the name of the file: ");
                String fileName = sc.nextLine();

                ArrayList<String> files = directoryToFileMap.get(directoryName);

                if(files.contains(fileName)) {
                    System.out.println("File already exists. Please enter a different name.");
                } else {
                    files.add(fileName);
                    System.out.println("File added successfully.");
                }
            }
        }

        System.out.println("List of directories and their files:");
        for(String directoryName : directoryToFileMap.keySet()) {
            String currentDirectory = directoryName;
            System.out.print(directoryName);
            while(directoryToParentMap.containsKey(currentDirectory)) {
                currentDirectory = directoryToParentMap.get(currentDirectory);
                System.out.print("/" + currentDirectory);
            }
            System.out.println();
            ArrayList<String> files = directoryToFileMap.get(directoryName);
            for(String fileName : files) {
                System.out.println("   " + fileName);
            }
        }
    }
}
