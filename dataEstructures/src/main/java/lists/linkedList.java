package lists;

public class linkedList<T> {

    // Declare the pointer
    private Nodo<T> p;

    public void add(T inf){

        // Add the information in a new nodo
        Nodo<T> newNodo = new Nodo<>();
        newNodo.setInf(inf);

        // Add the first list nodo like reference in the new nodo
        newNodo.setRef(this.p);

        // Change the pointer direction to the new nodo linked with the list
        this.p = newNodo;

    }

    public T get(int position){

        // Declare an auxiliary pointer to handle the list without lost information
        Nodo<T> aux = this.p;

        // Find the right position in the list
        int i = 0;
        while(i < position){
            aux = aux.getRef();
            i++;
        }

        return aux.getInf();

    }

    public void push(T inf){

        // Add the information in a new nodo
        Nodo<T> newNodo = new Nodo<>();
        newNodo.setInf(inf);

        // Verify if the list is void
        if(this.p == null){
            // The pointer will have the reference to the new nodo if the list is void
            this.p = newNodo;
            // If the list was void, the method would finish here
            return;
        }

        // Declare an auxiliary pointer to handle the list without lost information
        Nodo<T> aux = this.p;

        // Find the last nodo in the list
        while(aux.getRef() != null){
            aux = aux.getRef();
        }

        // Change the reference of the last nodo to the new nodo reference
        aux.setRef(newNodo);

    }

    @Override
    public String toString() {

        // Verify if the list is void
        if(this.p == null){
            return "[]";
        }

        // Create a string tho show the information
        String list = "[";

        // Declare an auxiliary pointer to handle the list without lost information
        Nodo<T> aux = this.p;
        while(aux.getRef() != null){
            list += aux.getInf() + ", ";
            aux = aux.getRef();
        }
        list += aux.getInf() + "]";

        return list;

    }
}