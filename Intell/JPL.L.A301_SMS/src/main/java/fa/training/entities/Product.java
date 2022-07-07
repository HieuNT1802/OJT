package fa.training.entities;

public class Product {
    private int prodcutId;
    private String productName;
    private double listPrice;

    public Product() {
    }

    public Product(int prodcutId, String productName, double listPrice) {
        this.prodcutId = prodcutId;
        this.productName = productName;
        this.listPrice = listPrice;
    }

    public int getProdcutId() {
        return prodcutId;
    }

    public void setProdcutId(int prodcutId) {
        this.prodcutId = prodcutId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodcutId=" + prodcutId +
                ", productName='" + productName + '\'' +
                ", listPrice=" + listPrice +
                '}';
    }
}
