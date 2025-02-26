package avaj.launcher.weather;

import avaj.launcher.utils.Coordinates;

public class WeatherProvider
{
	private static final String[] weather = new String[]{
		"RAIN",
		"FOG",
		"SUN",
		"SNOW"
	};

	private static WeatherProvider instance;

	private WeatherProvider()
	{}

	public String getCurrentWeather(Coordinates coordinates)
	{
		int rng = coordinates.getHeight() * coordinates.getLongitude();
		rng *= 32196864;
		rng ^= coordinates.getLongitude() + coordinates.getLatitude();
		return (weather[rng & 3]);
	}

	public static WeatherProvider getInstance()
	{
		if (WeatherProvider.instance == null)
			WeatherProvider.instance = new WeatherProvider();
		return (WeatherProvider.instance);
	}
}
