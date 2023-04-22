
import java.util.*;
class LRUPageReplacement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of frames: ");
        int numFrames = scanner.nextInt();

        int[] pageTable = new int[numFrames];
        int[] timestamps = new int[numFrames];

        int numPageFaults = 0;

        System.out.print("Enter the number of page requests: ");
        int numRequests = scanner.nextInt();

        System.out.print("Enter the page references: ");
        int[] pageRequests = new int[numRequests];
        for (int i = 0; i < numRequests; i++) {
            pageRequests[i] = scanner.nextInt();
        }

        for (int i = 0; i < numRequests; i++) {
            int page = pageRequests[i];
            int index = -1;
            for (int j = 0; j < numFrames; j++) {
                if (pageTable[j] == page) {
                    index = j;
                    break;
                }
            }

            if (index == -1) {
                int minTimestamp = Integer.MAX_VALUE;
                int replaceIndex = -1;
                for (int j = 0; j < numFrames; j++) {
                    if (timestamps[j] < minTimestamp) {
                        minTimestamp = timestamps[j];
                        replaceIndex = j;
                    }
                }
                pageTable[replaceIndex] = page;
                timestamps[replaceIndex] = i;
                numPageFaults++;
            } else {
                timestamps[index] = i;
            }

            System.out.print("Page table: ");
            for (int j = 0; j < numFrames; j++) {
                if (pageTable[j] == -1) {
                    System.out.print("_ ");
                } else {
                    System.out.print(pageTable[j] + " ");
                }
            }
            System.out.println();
        }

        System.out.println("Total number of page faults: " + numPageFaults);
        scanner.close();
    }
}

