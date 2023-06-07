package db.model;

public class PaymentMethod {
    private int paymentMethodId;
    private String paymentMethod;

    public PaymentMethod() {
    }

    public PaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "paymentMethodId=" + paymentMethodId +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
