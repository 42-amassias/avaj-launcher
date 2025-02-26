package avaj.launcher.weather;

import java.util.EnumMap;
import java.util.Map;

import avaj.launcher.utils.Coordinates;

public class WeatherMap extends EnumMap<Weather, Coordinates>
{

	public WeatherMap(Map<Weather, ? extends Coordinates> m)
	{
		super(m);
	}

	public WeatherMap(EnumMap<Weather, ? extends Coordinates> m)
	{
		super(m);
	}

	public WeatherMap(Class<Weather> keyType)
	{
		super(keyType);
	}

}
