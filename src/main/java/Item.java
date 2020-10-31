public interface Item {

  // methods to be implemented
  int getId();

  void setName(String name);

  String getName();

  void setManufacturer(String manu);

  String getManufacturer();

  ItemType getType();

  void setType(ItemType type);
}
