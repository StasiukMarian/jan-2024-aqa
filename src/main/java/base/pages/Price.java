package base.pages;

public class Price {
    private double itemTotal;
    private double tax;
    private double totalWithTax;

    public Price() {
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalWithTax() {
        return totalWithTax;
    }

    public void setTotalWithTax(double totalWithTax) {
        this.totalWithTax = totalWithTax;
    }

    @Override
    public String toString() {
        return "Price{" +
                "itemTotal=" + itemTotal +
                ", tax=" + tax +
                ", totalWithTax=" + totalWithTax +
                '}';
    }
}
