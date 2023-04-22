import java.util.*;

public class LFUPageReplacement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of frames: ");
        int numFrames = scanner.nextInt();
        
        int[] frames = new int[numFrames];
        int[] counts = new int[numFrames];
        int numFaults = 0;
        
        System.out.print("Enter the number of pages: ");
        int numPages = scanner.nextInt();
        int[] pages = new int[numPages];
        
        System.out.println("Enter the pages:");
        for (int i = 0; i < numPages; i++) {
            pages[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < numPages; i++) {
            int page = pages[i];
            boolean found = false;
            for (int j = 0; j < numFrames; j++) {
                if (frames[j] == page) {
                    counts[j]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                int minCount = counts[0];
                int minIndex = 0;
                for (int j = 1; j < numFrames; j++) {
                    if (counts[j] < minCount) {
                        minCount = counts[j];
                        minIndex = j;
                    }
                }
                frames[minIndex] = page;
                counts[minIndex] = 1;
                numFaults++;
            }
            System.out.print("Page References: ");
            for (int j = 0; j < numFrames; j++) {
                System.out.print(frames[j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Number of page faults: " + numFaults);
    }
}
