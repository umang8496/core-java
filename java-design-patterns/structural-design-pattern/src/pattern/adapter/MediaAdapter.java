package pattern.adapter;

public class MediaAdapter implements MediaPlayer {

	AdvancedMediaPlayer advancedMediaPlayer;

	public MediaAdapter(String audioType) {
		if (audioType.equalsIgnoreCase("UHD")) {
			advancedMediaPlayer = new VLCPlayer();
		} else {
			advancedMediaPlayer = new WMPlayer();
		}
	}

	@Override
	public void play(String audioType, String fileName) {
		if (audioType.equalsIgnoreCase("UHD")) {
			advancedMediaPlayer.playUHD(fileName);
		} else if (audioType.equalsIgnoreCase("MP4")) {
			advancedMediaPlayer.playMP4(fileName);
		}
	}

}
