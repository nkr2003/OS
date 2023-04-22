import java.util.*;

public class OptimalPageReplacement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of frames: ");
        int numFrames = scanner.nextInt();
        
        int[] frames = new int[numFrames];
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
                    found = true;
                    break;
                }
            }
            if (!found) {
                int maxIndex = -1;
                int maxDist = -1;
                for (int j = 0; j < numFrames; j++) {
                    int dist = -1;
                    for (int k = i + 1; k < numPages; k++) {
                        if (frames[j] == pages[k]) {
                            dist = k - i;
                            break;
                        }
                    }
                    if (dist == -1) {
                        maxIndex = j;
                        break;
                    }
                    if (dist > maxDist) {
                        maxIndex = j;
                        maxDist = dist;
                    }
                }
                frames[maxIndex] = page;
                numFaults++;
            }
            System.out.print("Page " + page + " -> ");
            for (int j = 0; j < numFrames; j++) {
                System.out.print(frames[j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Number of page faults: " + numFaults);
    }
}
