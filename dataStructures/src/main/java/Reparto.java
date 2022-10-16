import lists.LinkedList;
import queue.Queue;
import stack.Stack;

import java.util.Scanner;

public class Reparto {

    public static void main(String[] args) {

        // Scanner to handle the inputs
        Scanner in = new Scanner(System.in);

        int cases = Integer.parseInt(in.nextLine());

        for(int h = 0; h < cases; ++h){

            LinkedList<String> inputs = new LinkedList<>();
            for (int i = 0; i < 4; ++i) inputs.push(in.nextLine());

            int quantity = Integer.parseInt(inputs.get(0));

            Queue<String> products = new Queue<>();
            for(String i: inputs.get(1).split(" ")) products.queueUp(i);

            int storesQuantity = Integer.parseInt(inputs.get(2));

            Stack<LinkedList<String>> stores = new Stack<>();
            for(int i = 0; i < storesQuantity; ++i) stores.pile(new LinkedList<>());

            LinkedList<Integer> capacityStores = new LinkedList<>();
            for(String i: inputs.get(3).split(" ")) capacityStores.push(Integer.parseInt(i));

            for(int i = 0; i < storesQuantity; ++i){

                while(capacityStores.get(i) != 0 && quantity != 0){

                    LinkedList<String> listProductsUpdated = stores.get(i);
                    listProductsUpdated.push(products.unQueue());
                    stores.set(i, listProductsUpdated);

                    capacityStores.set(i, capacityStores.get(i) - 1);
                    --quantity;

                }

            }

            for(int i = 0; i < storesQuantity; ++i) System.out.println(stores.unPile());

        }

    }

}
