package patterns.visitor;

public interface PayableReceivableVisitorWithReturn<T> {

    T payable();

    T receivable();

}
