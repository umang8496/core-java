package pattern.adapter;

public class VLCPlayer implements AdvancedMediaPlayer {

	public VLCPlayer() {
		super();
	}

	@Override
	public void playUHD(String fileName) {
		System.out.println("VLCPlayer is playing the UHD file: " + fileName);

	}

	@Override
	public void playMP4(String fileName) {
		System.out.println("VLCPlayer is playing the MP4 file: " + fileName);
	}

}
