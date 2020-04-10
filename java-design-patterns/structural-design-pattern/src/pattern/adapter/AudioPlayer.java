package pattern.adapter;

public class AudioPlayer implements MediaPlayer {

	MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {
		if (audioType.equalsIgnoreCase("MP3")) {
			System.out.println("AudioPlayer is playing the " + audioType + " file: " + fileName);
		} else if (audioType.equalsIgnoreCase("UHD") || audioType.equalsIgnoreCase("MP4")) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		} else {
			System.out.println("Invalid media. " + audioType + " format not supported");
		}
	}

}
