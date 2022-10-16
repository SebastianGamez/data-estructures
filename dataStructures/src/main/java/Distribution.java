import lists.LinkedList;
import queue.Queue;

import java.util.Scanner;

public class Distribution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        LinkedList<Integer> facultiesDeficit = new LinkedList<>();

        LinkedList<Integer> facultiesDeficitOrder = new LinkedList<>();

        Queue<LinkedList<Integer>> loteQueue = new Queue<>();

        LinkedList<LinkedList<Integer>> distribution = new LinkedList<>();

        for(int g = 0; g < 4; ++g){

            LinkedList<Integer> devices = new LinkedList<>();

            devices.add(0);
            devices.add(0);
            devices.add(0);

            distribution.add(devices);

        }

        while(in.hasNextLine()) {

            String input = in.nextLine();

            if(input.split(" ")[0].equals("Ingenieria")){

                String[] facultiesArray = input.split(" ");

                facultiesDeficit.push(Integer.parseInt(facultiesArray[1]));
                facultiesDeficit.push(Integer.parseInt(facultiesArray[3]));
                facultiesDeficit.push(Integer.parseInt(facultiesArray[5]));
                facultiesDeficit.push(Integer.parseInt(facultiesArray[7]));

            }else if (input.split(" ")[0].equals("Lote")) {
                String[] loteArray =  input.split(" ");

                LinkedList<Integer> devicesList = new LinkedList<>();

                devicesList.push(Integer.parseInt(loteArray[2]));
                devicesList.push(Integer.parseInt(loteArray[4]));
                devicesList.push(Integer.parseInt(loteArray[6]));

                loteQueue.queueUp(devicesList);

            } else if (input.equals("Distribuir lote")) {

                LinkedList<Integer> facultiesDeficitOrdered = new LinkedList<>();
                for(int h = 0; h < facultiesDeficit.length(); ++h) facultiesDeficitOrdered.push(facultiesDeficit.get(h));

                int length = facultiesDeficitOrdered.length();
                int beforeValue = 0;

                for(int i = 0; i < length; ++i){
                    for(int j = 1; j < length; ++j){
                        if(facultiesDeficitOrdered.get(j) > facultiesDeficitOrdered.get(j - 1)){
                            beforeValue = facultiesDeficitOrdered.get(j);
                            facultiesDeficitOrdered.set(j, facultiesDeficitOrdered.get(j - 1));
                            facultiesDeficitOrdered.set(j - 1, beforeValue);
                        }
                    }

                }

                if(facultiesDeficitOrdered.length() != 0){
                    for(int j = 0; j < length; ++j){
                        facultiesDeficitOrder.push(facultiesDeficit.indexOf(facultiesDeficitOrdered.get(j)));
                    }
                }

                LinkedList<Integer> lote = loteQueue.unQueue();
                for(int k = 0; k < length; ++k){

                    int index = facultiesDeficitOrder.get(k);

                    LinkedList<Integer> facultyDistribution = distribution.get(index);

                    while ((!lote.get(0).equals(0) || !lote.get(1).equals(0) || !lote.get(2).equals(0)) && facultiesDeficit.get(index) > 0){

                        if(lote.get(0) > 0 && facultiesDeficit.get(index) > 0){
                            facultiesDeficit.set(index, facultiesDeficit.get(index) - 1);
                            lote.set(0, lote.get(0) - 1);
                            facultyDistribution.set(0, facultyDistribution.get(0) + 1);
                        }
                        if(lote.get(1) > 0 && facultiesDeficit.get(index) > 0){
                            facultiesDeficit.set(index, facultiesDeficit.get(index) - 1);
                            lote.set(1, lote.get(1) - 1);
                            facultyDistribution.set(1, facultyDistribution.get(1) + 1);
                        }
                        if(lote.get(2) > 0 && facultiesDeficit.get(index) > 0){
                            facultiesDeficit.set(index, facultiesDeficit.get(index) - 1);
                            lote.set(2, lote.get(2) - 1);
                            facultyDistribution.set(2, facultyDistribution.get(2) + 1);
                        }

                    }

                }

            } else if (input.equals("Imprimir")) {

                LinkedList<String> results = new LinkedList<>();
                for(int o = 0; o < 4; ++o){

                    int index = facultiesDeficitOrder.get(o);

                    String result = "";
                    switch (index){

                        case 0:
                            result += "Ingenieria ";
                            break;
                        case 1:
                            result += "Humanas ";
                            break;
                        case 2:
                            result += "Artes ";
                            break;
                        case 3:
                            result += "Medicina ";

                    }

                    LinkedList<Integer> facultyDistribution = distribution.get(index);

                    result += facultiesDeficit.get(index) + " - " + "Computers " + facultyDistribution.get(0) + " Laptops " + facultyDistribution.get(1) + " Tablets " + facultyDistribution.get(2);
                    results.push(result);

                }

                distribution.clear();
                for(int g = 0; g < 4; ++g){

                    LinkedList<Integer> devices = new LinkedList<>();

                    devices.add(0);
                    devices.add(0);
                    devices.add(0);

                    distribution.add(devices);

                }

                int length = results.length();
                String beforeValue;

                for(int i = 0; i < length; ++i){
                    for(int j = 1; j < length; ++j){
                        if(Integer.parseInt(results.get(j).split(" ")[1]) < Integer.parseInt(results.get(j - 1).split(" ")[1])){
                            beforeValue = results.get(j);
                            results.set(j, results.get(j - 1));
                            results.set(j - 1, beforeValue);
                        }

                    }

                }

                for(int i = 0; i < length; ++i){
                    for(int j = 1; j < length; ++j){

                        String[] primero = results.get(j - 1).split(" ");
                        String[] segundo = results.get(j).split(" ");

                        if ((Integer.parseInt(segundo[1]) == Integer.parseInt(primero[1])) && segundo[0].equals("Ingenieria")){
                            beforeValue = results.get(j);
                            results.set(j, results.get(j - 1));
                            results.set(j - 1, beforeValue);
                        }

                        if ((Integer.parseInt(segundo[1]) == Integer.parseInt(primero[1])) && segundo[0].equals("Humanas") && !primero[0].equals("Ingenieria")){
                            beforeValue = results.get(j);
                            results.set(j, results.get(j - 1));
                            results.set(j - 1, beforeValue);
                        }

                        if ((Integer.parseInt(segundo[1]) == Integer.parseInt(primero[1])) && segundo[0].equals("Medicina") && !primero[0].equals("Ingenieria") && !primero[0].equals("Humanas")){
                            beforeValue = results.get(j);
                            results.set(j, results.get(j - 1));
                            results.set(j - 1, beforeValue);
                        }

                    }

                }

                for(int p = 0; p < length; ++p) System.out.println(results.get(p));

            }

        }

    }

}