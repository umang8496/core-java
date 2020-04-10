package pattern.adapter;

public class WMPlayer implements AdvancedMediaPlayer {

	public WMPlayer() {
		super();
	}
	
	@Override
	public void playUHD(String fileName) {
		System.out.println("WMPlayer is playing the UHD file: " + fileName);

	}

	@Override
	public void playMP4(String fileName) {
		System.out.println("WMPlayer is playing the MP4 file: " + fileName);
	}

}
