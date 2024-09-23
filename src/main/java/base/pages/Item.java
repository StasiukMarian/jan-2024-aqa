package base.pages;

import java.util.Objects;

public class Item {
    private String header;
    private String description;
    private String price;

    public Item() {
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(header, item.header) && Objects.equals(description, item.description) && Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, description, price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "header='" + header + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
