package pattern.bridge;

public interface Devices {
	public boolean isEnabled();

	public void enable();

	public void disable();

	public int getVolume();

	public void setVolume(int percent);

	public int getChannel();

	public void setChannel(int Channel);

	public void printStatus();
}
