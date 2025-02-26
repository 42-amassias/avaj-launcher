package avaj.launcher.utils;

public class Coordinates
{
	private final int longitude;
	private final int latitude;
	private final int height;

	public Coordinates(int longitude, int latitude, int height)
	{
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public Coordinates offset(Coordinates other)
	{
		assert other != null;

		final int longitude = this.longitude + other.longitude;
		final int latitude = this.latitude + other.latitude;
		final int height = this.height + other.height;

		return (new Coordinates(longitude, latitude, height));
	}

	public int getLongitude()
	{
		return (longitude);
	}

	public int getLatitude()
	{
		return (latitude);
	}

	public int getHeight()
	{
		return (height);
	}

}
