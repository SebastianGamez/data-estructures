import lists.LinkedList;

import java.util.Scanner;

public class Border {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] inputArray = input.nextLine().replace("[", "").replace("]", "").split(",");

        int length = inputArray.length;

        LinkedList<String> inputList = new LinkedList<>();
        for (String s : inputArray) {

            inputList.push(s);

        }

        LinkedList<LinkedList<String>> prefixes = new LinkedList<>();
        for(int i = 0; i < length; ++i){

            LinkedList<String> prefix = new LinkedList<>();
            for(int j = 0; j <= i; ++j) prefix.push(inputList.get(j));

            prefixes.push(prefix);

        }

        LinkedList<LinkedList<String>> suffixes = new LinkedList<>();
        for(int i = 0; i < length; ++i){

            LinkedList<String> suffix = new LinkedList<>();
            for(int j = i; j < length; ++j) suffix.push(inputList.get(j));

            suffixes.push(suffix);

        }

        for(int i = 0; i < prefixes.length(); ++i){

            LinkedList<String> prefix = prefixes.get(i);

            for(int j = 0; j < suffixes.length(); ++j){

                LinkedList<String> suffix = suffixes.get(j);

                if (prefix.isEqual(suffix)){

                    System.out.println(prefix);

                }

            }

        }

    }

}
