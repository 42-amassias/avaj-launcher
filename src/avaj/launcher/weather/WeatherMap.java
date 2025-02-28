package avaj.launcher.weather;

import java.util.EnumMap;

public class WeatherMap<T> extends EnumMap<Weather, T>
{

	public WeatherMap()
	{
		super(Weather.class);
	}

}
