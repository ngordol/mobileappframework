package utils;

public class TV {

    private String name;
    private String price;

    public TV() {
        name = "";
        price = "";
    }

    public TV(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }


}
