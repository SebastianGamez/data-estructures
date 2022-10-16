package queue;

public class Nodo<T> {

    private T inf;
    private lists.Nodo<T> ref;

    public T getInf() {
        return inf;
    }

    public void setInf(T inf) {
        this.inf = inf;
    }

    public lists.Nodo<T> getRef() {
        return ref;
    }

    public void setRef(lists.Nodo<T> ref) {
        this.ref = ref;
    }

}
