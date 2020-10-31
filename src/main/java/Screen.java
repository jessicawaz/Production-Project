public class Screen implements ScreenSpec {

  // fields
  String resolution;
  int refreshRate;
  int responseTime;

  /** Screen constructor. */
  public Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  // getters & setters
  @Override
  public String getResolution() {
    return resolution;
  }

  @Override
  public int getRefreshRate() {
    return refreshRate;
  }

  @Override
  public int getResponseTime() {
    return responseTime;
  }

  // toString method
  @Override
  public String toString() {
    return "\nScreen resolution  : "
        + resolution
        + "\nRefresh Rate       : "
        + refreshRate
        + "\nResponse Time      : "
        + responseTime;
  }
}
