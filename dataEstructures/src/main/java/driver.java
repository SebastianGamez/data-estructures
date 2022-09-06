import lists.linkedList;

public class driver {
    public static void main(String[] args) {

        linkedList<Integer> list = new linkedList<>();

        list.push(1);
        System.out.println(list);

        list.add(100);
        System.out.println(list);

        list.push(3);
        System.out.println(list);

        list.push(3);
        System.out.println(list);

        System.out.println(list.get(0));
        System.out.println(list.get(3));
        System.out.println(list.get(2));
        System.out.println(list.get(1));

    }
}
