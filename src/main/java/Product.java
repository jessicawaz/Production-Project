public abstract class Product implements Item {

  // fields
  int id;
  ItemType type;
  String manufacturer;
  String name;

  /** Product Constructor (abstract). */
  public Product(String name, String manufacturer, ItemType type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  /** toString method used to print Product. */
  public String toString() {
    return "\nName               : "
        + name
        + "\nManufacturer       : "
        + manufacturer
        + "\nType               : "
        + type.code;
  }

  // getters & setters
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

  @Override
  public void setType(ItemType type) {
    this.type = type;
  }

  @Override
  public ItemType getType() {
    return type;
  }
}
