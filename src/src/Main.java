import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String args[]) {
        Graph graph = new Graph();
        int entries = 0;
        String inputLine = null;
        String[] inputArray;
        String job = null;
        String name = null;
        int number = 0;

        Scanner scan = new Scanner(System.in);
        System.out.println("input number of job/applicant pairs: ");
        entries = scan.nextInt();
        System.out.println(entries);

        for (int i = 0; i < entries; i++) {
            System.out.println("Enter jobs and applicants in the form of: job/name/qualificationScore");
            inputLine = scan.next();

            inputArray = inputLine.split("/");
            for (int j = 0; j < inputArray.length; j++) {
                //System.out.println("inputArray[" + j + "] = " + inputArray[j]);
            }
            job = inputArray[0];
            //System.out.println(job);
            name = inputArray[1];
            //System.out.println(name);
            number = Integer.parseInt(inputArray[2]);
            //System.out.println(number);

            Job job1 = new Job(job);
            Applicant applicant1 = new Applicant(name, number);
            graph.addVertex(job1, false);
            graph.addVertex(applicant1, false);
            graph.addEdge(applicant1, job1, number);

            Set<Edge> edges = graph.getEdges();


            while (!(edges.isEmpty())) {
                Edge edge = edges.iterator().next();
                int w = edge.getWeight();

                edges.remove(edge);
                if (w > 3) {
                    System.out.println("Suggested Hire: " +edge);
                }


            }

        }
    }
}