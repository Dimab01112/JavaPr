package org.example;

import lombok.Generated;

public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private Category category;

    public String toString() {
        int var10000 = this.id;
        return "Товар{id=" + var10000 + ", назва='" + this.name + "', ціна=" + this.price + ", опис='" + this.description + "', категорія='" + this.category.getName() + "'}";
    }

    @Generated
    public int getId() {
        return this.id;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public double getPrice() {
        return this.price;
    }

    @Generated
    public String getDescription() {
        return this.description;
    }

    @Generated
    public Category getCategory() {
        return this.category;
    }

    @Generated
    public void setId(int id) {
        this.id = id;
    }

    @Generated
    public void setName(String name) {
        this.name = name;
    }

    @Generated
    public void setPrice(double price) {
        this.price = price;
    }

    @Generated
    public void setDescription(String description) {
        this.description = description;
    }

    @Generated
    public void setCategory(Category category) {
        this.category = category;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Product)) {
            return false;
        } else {
            Product other = (Product)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else if (Double.compare(this.getPrice(), other.getPrice()) != 0) {
                return false;
            } else {
                label52: {
                    Object this$name = this.getName();
                    Object other$name = other.getName();
                    if (this$name == null) {
                        if (other$name == null) {
                            break label52;
                        }
                    } else if (this$name.equals(other$name)) {
                        break label52;
                    }

                    return false;
                }

                Object this$description = this.getDescription();
                Object other$description = other.getDescription();
                if (this$description == null) {
                    if (other$description != null) {
                        return false;
                    }
                } else if (!this$description.equals(other$description)) {
                    return false;
                }

                Object this$category = this.getCategory();
                Object other$category = other.getCategory();
                if (this$category == null) {
                    if (other$category != null) {
                        return false;
                    }
                } else if (!this$category.equals(other$category)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof Product;
    }

    @Generated
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getId();
        long $price = Double.doubleToLongBits(this.getPrice());
        result = result * 59 + (int)($price >>> 32 ^ $price);
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $description = this.getDescription();
        result = result * 59 + ($description == null ? 43 : $description.hashCode());
        Object $category = this.getCategory();
        result = result * 59 + ($category == null ? 43 : $category.hashCode());
        return result;
    }

    @Generated
    public Product(int id, String name, double price, String description, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }
}
