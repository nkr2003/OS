import java.util.*;

class CSCAN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of disk requests: ");
        int n = scanner.nextInt();

        int[] requests = new int[n];
        System.out.println("Enter the disk requests:");
        for (int i = 0; i < n; i++) {
            requests[i] = scanner.nextInt();
        }

        System.out.print("Enter the current head position: ");
        int head = scanner.nextInt();

        System.out.print("Enter the maximum cylinder number: ");
        int max = scanner.nextInt();

        // Sort the requests in ascending order
        Arrays.sort(requests);

        int index = -1;
        for (int i = 0; i < n; i++) {
            if (requests[i] >= head) {
                index = i;
                break;
            }
        }

        int[] order;
        if (index == -1) { // head is already at the end
            order = new int[n+2];
            System.arraycopy(requests, 0, order, 0, n);
            order[n] = max;
            order[n+1] = 0;
        } else {
            order = new int[n - index + 5];
            System.arraycopy(requests, index, order, 0, n - index);
            order[n - index] = max;
            order[n - index + 1] = 0;
            if (index > 0) {
                System.arraycopy(requests, 0, order, n - index + 2, index);
            }
        }

        int headMovement = 0;
        System.out.println("Order of disk requests:");
        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + " ");
            headMovement += Math.abs(head - order[i]);
            head = order[i];
        }
        System.out.println("\nTotal head movement: " + headMovement);
    }
}
