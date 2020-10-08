public abstract class Product implements Item {

    int id;
    ItemType type;
    String manufacturer;
    String name;

    public Product(String name, String manufacturer, ItemType type) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
    }

    public String toString() {
        return "\nName               : " + name +
                "\nManufacturer       : " + manufacturer +
                "\nType               : " + type.code;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

}
