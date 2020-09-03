package patterns.visitor;

import com.google.common.base.Preconditions;

// esempio di visitor su enumerato
/**
 * Categoria del documento fiscale attivo o passivo
 */
public enum PayableReceivableEnum {
    PAYABLE("Payable"),

    RECEIVABLE("Receivable");

    private String description;

    private PayableReceivableEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void visit(PayableReceivableEnum payableReceivableEnum, PayableReceivableVisitor visitor) {

        Preconditions.checkNotNull(payableReceivableEnum,
                "null value is not admitted.");

        Preconditions.checkNotNull(visitor, "Visitor cannot be null");

        if (payableReceivableEnum == PayableReceivableEnum.PAYABLE) {
            visitor.payable();

        } else if (payableReceivableEnum == PayableReceivableEnum.RECEIVABLE) {
            visitor.receivable();

        } else {
            throw new IllegalArgumentException("Payable Receivable Type = " + payableReceivableEnum + " not supported.");

        }

    }

    public static <T> T visitAndReturn(PayableReceivableEnum payableReceivableEnum, PayableReceivableVisitorWithReturn<T> visitorWithReturn) {

        Preconditions.checkNotNull(payableReceivableEnum,
                "null value is not admitted.");

        Preconditions.checkNotNull(visitorWithReturn, "Visitor cannot be null");

        if (payableReceivableEnum == PayableReceivableEnum.PAYABLE) {
            return visitorWithReturn.payable();

        } else if (payableReceivableEnum == PayableReceivableEnum.RECEIVABLE) {
            return visitorWithReturn.receivable();

        } else {
            throw new IllegalArgumentException("Payable Receivable Type = " + payableReceivableEnum + " not supported.");

        }

    }

}
