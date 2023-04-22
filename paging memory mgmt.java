import java.util.*;

public class PagingMemoryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of frames: ");
        int numFrames = scanner.nextInt();

        int[] frames = new int[numFrames];
        int[] referenceBits = new int[numFrames];
        int[] pageTable = new int[numFrames];
        Arrays.fill(pageTable, -1);
        int numFaults = 0;

        System.out.print("Enter the page size: ");
        int pageSize = scanner.nextInt();

        System.out.print("Enter the memory size: ");
        int memorySize = scanner.nextInt();

        int numPages = memorySize / pageSize;
        int[] pages = new int[numPages];

        System.out.println("Enter the pages:");
        for (int i = 0; i < numPages; i++) {
            pages[i] = scanner.nextInt();
        }

        for (int i = 0; i < numPages; i++) {
            int page = pages[i];
            int pageIndex = page / pageSize;
            boolean found = false;
            for (int j = 0; j < numFrames; j++) {
                if (pageTable[j] == pageIndex) {
                    found = true;
                    referenceBits[j] = 1;
                    break;
                }
            }
            if (!found) {
                int minIndex = 0;
                int minRefBit = referenceBits[0];
                for (int j = 1; j < numFrames; j++) {
                    if (referenceBits[j] < minRefBit) {
                        minIndex = j;
                        minRefBit = referenceBits[j];
                    }
                }
                pageTable[minIndex] = pageIndex;
                frames[minIndex] = page;
                referenceBits[minIndex] = 1;
                numFaults++;
            }
            System.out.print("Page References: ");
            for (int j = 0; j < numFrames; j++) {
                if (pageTable[j] == -1) {
                    System.out.print(" - ");
                } else {
                    System.out.print(frames[j] + " ");
                }
            }
            System.out.println();
            for (int j = 0; j < numFrames; j++) {
                referenceBits[j] = referenceBits[j] >> 1;
            }
        }

        System.out.println("Number of page faults: " + numFaults);
    }
}
