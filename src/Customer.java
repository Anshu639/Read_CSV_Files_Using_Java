public class Customer {
    private int customerId;
    private String customerName;
    private String prodcuctId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProdcuctId() {
        return prodcuctId;
    }

    public void setProdcuctId(String prodcuctId) {
        this.prodcuctId = prodcuctId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", prodcuctId='" + prodcuctId + '\'' +
                '}';
    }
}