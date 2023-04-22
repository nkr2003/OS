import java.util.*;
class LFUPageReplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of pages: ");
        int n = sc.nextInt();

        int[] pages = new int[n];
        System.out.println("Enter the page reference string:");
        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        System.out.print("Enter the number of page frames: ");
        int capacity = sc.nextInt();

        int[] freq = new int[capacity];
        int[] frame = new int[capacity];
        Arrays.fill(frame, -1);
        int pageFaults = 0;

        for (int i = 0; i < n; i++) {
            int j = find(frame, pages[i]);
            if (j == -1) {
                int k = findMin(freq);
                frame[k] = pages[i];
                freq[k] = 1;
                pageFaults++;
            } else {
                freq[j]++;
            }
        }

        System.out.println("Number of page faults: " + pageFaults);
    }

    public static int find(int[] frame, int page) {
        for (int i = 0; i < frame.length; i++) {
            if (frame[i] == page) {
                return i;
            }
        }
        return -1;
    }

    public static int findMin(int[] freq) {
        int min = freq[0];
        int minIndex = 0;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] < min) {
                min = freq[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
