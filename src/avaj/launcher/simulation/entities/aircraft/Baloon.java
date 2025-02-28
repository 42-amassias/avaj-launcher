package avaj.launcher.simulation.entities.aircraft;

import avaj.launcher.utils.Coordinates;
import avaj.launcher.weather.Weather;
import avaj.launcher.weather.WeatherMap;

public class Baloon extends AAircraft
{
	public Baloon(long id, String name, Coordinates coordinates)
	{
		super(id, name, coordinates);
	}

	@Override
	protected void initializeOffsets(WeatherMap<Coordinates> offsets)
	{
		offsets.put(Weather.SUN, new Coordinates(2, 0, 4));
		offsets.put(Weather.RAIN, new Coordinates(0, 0, -5));
		offsets.put(Weather.FOG, new Coordinates(0, 0, -3));
		offsets.put(Weather.SNOW, new Coordinates(0, 0, -15));
	}

	@Override
	protected void initializeWeatherMessages(WeatherMap<String> messages)
	{
		messages.put(Weather.SUN, "SUN");
		messages.put(Weather.RAIN, "RAIN");
		messages.put(Weather.FOG, "FOG");
		messages.put(Weather.SNOW, "SNOW");
	}

	@Override
	protected String getType()
	{
		return ("Baloon");
	}
}
