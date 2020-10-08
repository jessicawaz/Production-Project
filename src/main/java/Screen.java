public class Screen implements ScreenSpec {

    String resolution;
    int refreshRate;
    int responseTime;

    public Screen(String resolution, int refreshRate, int responseTime) {
        this.resolution = resolution;
        this.refreshRate = refreshRate;
        this.responseTime = responseTime;
    }

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

    @Override
    public String toString() {
        return "\nScreen resolution  : " + resolution +
                "\nRefresh Rate       : " + refreshRate +
                "\nResponse Time      : " + responseTime;
    }
}
