import lists.LinkedList;
import queue.Queue;

import java.util.Scanner;

public class Rot {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] inputs = new String[2];

        for (int h = 0; h < inputs.length; h++) inputs[h] = in.nextLine();

        int permutations = Integer.parseInt(inputs[0]);
        String message = inputs[1];
        String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");

        LinkedList<String> alphabetList = new LinkedList<>();
        for (String s : alphabet) alphabetList.push(s);

        Queue<String> alphabetQueue = new Queue<>();
        for(int j = alphabet.length - 1; j >= 0; --j) alphabetQueue.queueUp(alphabet[j]);

        for(int j = alphabet.length - 1; j >= permutations; --j){
            alphabetQueue.unQueue();
            alphabetQueue.queueUp(alphabet[j]);
        }

        LinkedList<String> messageList = new LinkedList<>();
        for(String character: message.split("")) messageList.push(character);

        String messageEncryptedList = "";
        for(int k = 0; k < messageList.length(); ++k){
            messageEncryptedList = alphabetQueue.get(alphabetList.indexOf(messageList.get(k))) + messageEncryptedList;
        }

        System.out.println(messageEncryptedList.replaceAll("\\s",""));

    }

}
