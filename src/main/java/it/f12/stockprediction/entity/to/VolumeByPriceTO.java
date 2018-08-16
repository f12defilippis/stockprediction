package it.f12.stockprediction.entity.to;

public class VolumeByPriceTO {

	private double volumeIncreased;
	private double volumeDecreased;
	private double volume;
	public double getVolumeIncreased() {
		return volumeIncreased;
	}
	public void setVolumeIncreased(double volumeIncreased) {
		this.volumeIncreased = volumeIncreased;
	}
	public double getVolumeDecreased() {
		return volumeDecreased;
	}
	public void setVolumeDecreased(double volumeDecreased) {
		this.volumeDecreased = volumeDecreased;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	public void increase(double d)
	{
		volumeIncreased += d;
		volume += d;
	}
	
	public void decrease(double d)
	{
		volumeDecreased += d;
		volume += d;
	}
	
	
}
