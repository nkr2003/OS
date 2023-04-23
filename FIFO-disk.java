import java.util.*;

public class FIFOPageReplacement {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of page frames: ");
        int numberOfFrames = scanner.nextInt();
        
        System.out.print("Enter the number of pages: ");
        int numberOfPages = scanner.nextInt();
        
        int[] pages = new int[numberOfPages];
        System.out.println("Enter the reference string:");
        for (int i = 0; i < numberOfPages; i++) {
            pages[i] = scanner.nextInt();
        }
        
        int[] frames = new int[numberOfFrames];
        Arrays.fill(frames, -1);
        int pageFaults = 0;
        int pointer = 0;
        for (int i = 0; i < numberOfPages; i++) {
            int page = pages[i];
            boolean pageFound = false;
            for (int j = 0; j < numberOfFrames; j++) {
                if (frames[j] == page) {
                    pageFound = true;
                    break;
                }
            }
            if (!pageFound) {
                frames[pointer] = page;
                pointer = (pointer + 1) % numberOfFrames;
                pageFaults++;
            }
            System.out.print("Frame: ");
            for (int j = 0; j < numberOfFrames; j++) {
                if (frames[j] == -1) {
                    System.out.print("- ");
                } else {
                    System.out.print(frames[j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("Page Faults: " + pageFaults);
    }
}
