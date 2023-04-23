import java.util.*;

class Disk {
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

        System.out.print("Enter the direction (left or right): ");
        String direction = scanner.next();

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
        if (direction.equals("right")) {
            order = new int[n - index + 4];
            int j = 0;
            for (int i = index; i < n; i++) {
                order[j] = requests[i];
                j++;
            }
            order[j] = 199;
            j++;
            for (int i = index - 1; i >= 0; i--) {
                order[j] = requests[i];
                j++;
            }
        } else {
            order = new int[index + 4];
            int j = 0;
            for (int i = index - 1; i >= 0; i--) {
                order[j] = requests[i];
                j++;
            }
            order[j] = 0;
            j++;
            for (int i = index; i < n; i++) {
                order[j] = requests[i];
                j++;
            }
        }

        int headMovement = 0;
        System.out.println("Order of disk requests:");
        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + " ");
            if (i == 0) {
                headMovement += Math.abs(head - order[i]);
            } else {
                headMovement += Math.abs(order[i] - order[i-1]);
            }
            head = order[i];
        }
        System.out.println("\nTotal head movement: " + headMovement +"Cylinders");
    }
}
