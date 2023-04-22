import java.util.*;

public class FCFSDiskScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disk requests: ");
        int totalRequests = sc.nextInt();

        int[] requests = new int[totalRequests];

        System.out.println("Enter the disk requests:");
        for(int i = 0; i < totalRequests; i++) {
            requests[i] = sc.nextInt();
        }

        System.out.print("Enter the starting position of the disk head: ");
        int startPosition = sc.nextInt();

        int totalDistance = 0;
        int currentPosition = startPosition;

        for(int i = 0; i < totalRequests; i++) {
            int distance = Math.abs(requests[i] - currentPosition);
            totalDistance += distance;
            currentPosition = requests[i];
        }

        System.out.println("Total head movement: " + totalDistance+" "+"Cylinders");
    }
}
