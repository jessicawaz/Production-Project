public abstract class Product implements Item {

  public int id;
  ItemType type;
  private String manufacturer;
  private String name;

  /**
   * Product constructor used to set name, manufacturer, and type of the product.
   *
   * @param name Product name
   * @param manufacturer Product manufacturer
   * @param type Product type
   */
  public Product(String name, String manufacturer, ItemType type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.setType(type);
  }

  /**
   * toString method used to format product information.
   *
   * @return formatted product string
   */
  public String toString() {
    return "\nName               : "
        + name
        + "\nManufacturer       : "
        + manufacturer
        + "\nType               : "
        + type.code;
  }

  /**
   * Product ID getter method.
   *
   * @return Product ID
   */
  @Override
  public int getId() {
    return id;
  }

  /**
   * Product name setter method.
   *
   * @param name Product name
   */
  @Override
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Product name getter method.
   *
   * @return Product name
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Product manufacturer setter method.
   *
   * @param manufacturer Product manufacturer
   */
  @Override
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * Product manufacturer getter method.
   *
   * @return Product manufacturer
   */
  @Override
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * Product type setter method.
   *
   * @param type Product type
   */
  @Override
  public void setType(ItemType type) {
    this.type = type;
  }

  /**
   * Product type getter method.
   *
   * @return Product type
   */
  @Override
  public ItemType getType() {
    return type;
  }
}
