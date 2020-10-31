public class MoviePlayer extends Product implements MultimediaControl {

  Screen screen;
  MonitorType monitorType;

  /** MoviePlayer constructor. */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    this(name, manufacturer, ItemType.VISUAL);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  public MoviePlayer(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }

  @Override
  public void play() {
    System.out.println("Playing");
  }

  @Override
  public void stop() {
    System.out.println("Stopping");
  }

  @Override
  public void previous() {
    System.out.println("Going back");
  }

  @Override
  public void next() {
    System.out.println("Skipping");
  }

  @Override
  public String toString() {
    return super.toString()
        + "\nScreen             : "
        + screen
        + "\nMonitor Type       : "
        + monitorType;
  }
}
