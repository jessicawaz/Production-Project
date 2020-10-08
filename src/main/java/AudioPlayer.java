public class AudioPlayer extends Product implements MultimediaControl {

    public String supportedAudioFormats;
    public String supportedPlaylistFormats;

    public AudioPlayer(String name, String manufacturer,
                       String supportedPlaylistFormats, String supportedAudioFormats) {
        super(name, manufacturer, ItemType.AUDIO);
        this.supportedAudioFormats = supportedAudioFormats;
        this.supportedPlaylistFormats = supportedPlaylistFormats;
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
        System.out.println("Previous");
    }

    @Override
    public void next() {
        System.out.println("Next");
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSupported Audio Formats: " + supportedAudioFormats +
                "\nSupported Playlist Formats: " + supportedPlaylistFormats;
    }
}
