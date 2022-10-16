import lists.LinkedList;

import java.util.Scanner;

public class Clientes {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String[] input1 = in.nextLine().split(" ");

        int hours = Integer.parseInt(input1[0]);
        int engineers = Integer.parseInt(input1[1]);
        int clients = Integer.parseInt(input1[2]);

        LinkedList<LinkedList<Integer>> engineersInformation = new LinkedList<>();
        for(int i = 0; i < engineers; ++i){

            LinkedList<Integer> engineerInformation = new LinkedList<>();
            for(String j: in.nextLine().split(" ")) engineerInformation.push(Integer.parseInt(j));

            engineersInformation.push(engineerInformation);

        }

        LinkedList<LinkedList<Integer>> clientsInformation = new LinkedList<>();
        for(int i = 0; i < clients; ++i){

            LinkedList<Integer> clientInformation = new LinkedList<>();
            for(String j: in.nextLine().split(" ")) clientInformation.push(Integer.parseInt(j));

            clientsInformation.push(clientInformation);

        }

        for(int i = 0; i < clientsInformation.length(); ++i){

            LinkedList<Integer> clientInformation = clientsInformation.get(i);

            String result = "NO";
            for(int j = 0; j < engineersInformation.length(); ++j){

                LinkedList<Integer> engineerInformation = engineersInformation.get(j);

                boolean hasEnoughExperience = clientInformation.get(0) <= engineerInformation.get(0);
                boolean inHourRange = (engineerInformation.get(1) <= clientInformation.get(1)) && (clientInformation.get(1) <= engineerInformation.get(2));

                if(hasEnoughExperience && inHourRange){

                    result = "YES";

                }

            }

            System.out.println(result);

        }

    }

}
