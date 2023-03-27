import java.util.Arrays;
import java.util.Scanner;

public class Priority {

    public static void main(String[] args) {
System.out.print("Enter Number of Process: ");
        Scanner sc = new Scanner(System.in);
        int NOP = sc.nextInt();  //NOP=no.of process
        String process[] = new String[NOP];

        int p = 1;
        for (int i = 0; i < NOP; i++) {
            process[i] = "P" + p;
            p++;
        }

        System.out.println(Arrays.toString(process));

        System.out.print("Enter Burst Time for " + NOP + " process: ");

        int burstTime[] = new int[NOP];
        for (int i = 0; i < NOP; i++) {
            burstTime[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(burstTime));

        System.out.print("Enter Priority for " + NOP + " process: ");

        int priority[] = new int[NOP];
        for (int i = 0; i < NOP; i++) {
            priority[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(priority));
int temp;
String temp2;
for (int i = 0; i < NOP - 1; i++) {
      for (int j = 0; j < NOP - 1; j++) {
            if (priority[j] > priority[j + 1]) {
                   temp = priority[j];
                    priority[j] = priority[j + 1];
                    priority[j + 1] = temp;

                    temp = burstTime[j];
                    burstTime[j] = burstTime[j + 1];
                    burstTime[j + 1] = temp;

                    temp2 = process[j];
                    process[j] = process[j + 1];
                    process[j + 1] = temp2;

                }
            }
        }

        int TAT[] = new int[NOP + 1];
        int waitingTime[] = new int[NOP + 1];
        
        for (int i = 0; i < NOP; i++) {
            TAT[i] = burstTime[i] + waitingTime[i];
            waitingTime[i + 1] = TAT[i];
        }

        int totalWT = 0;
        int totalTAT = 0;
        double avgWT;
        double avgTAT;

        System.out.println("Process     BT      WT        TAT");
        for (int i = 0; i < NOP; i++) {

            System.out.println(process[i] + "          " + burstTime[i] + "       " + waitingTime[i] + "         " + (TAT[i]));
            totalTAT += (waitingTime[i] + burstTime[i]);
            totalWT += waitingTime[i];

        }

        avgWT = totalWT / (double) NOP;
        avgTAT = totalTAT / (double) NOP;

        System.out.println("\n Average Wating Time: " + avgWT);
        System.out.println(" Average Turn Around Time: " + avgTAT);

    }

}
