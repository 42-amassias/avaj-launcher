package avaj.launcher.weather;

import java.util.EnumMap;

import avaj.launcher.utils.Coordinates;

public class WeatherMap extends EnumMap<Weather, Coordinates>
{

	public WeatherMap()
	{
		super(Weather.class);
	}

}
