package pattern.adapter;

/**
 * @author UMishra
 * We have a MediaPlayer interface and a concrete class AudioPlayer implementing the MediaPlayer interface.
 * AudioPlayer can play mp3 format audio files by default.
 * 
 * We are having another interface AdvancedMediaPlayer and concrete classes implementing the AdvancedMediaPlayer interface.
 * These classes can play UHD and MP4 format files.
 * 
 * We want to make AudioPlayer to play other formats as well.
 * To attain this, we have created an adapter class MediaAdapter which implements the MediaPlayer(I) and uses AdvancedMediaPlayer objects to play the required format.
 * AudioPlayer uses the adapter class MediaAdapter passing it the desired audio type without knowing the actual class which can play the desired format.
 * MediaAdapterDemo, our demo class will use AudioPlayer class to play various formats.
 * 
 */

public class MediaAdapterDemo {
	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.play("MP3", "beyond the horizon.mp3");
		audioPlayer.play("MP4", "alone.mp4");
		audioPlayer.play("UHD", "far far away.vlc");
		audioPlayer.play("avi", "mind me.avi");
	}
}
