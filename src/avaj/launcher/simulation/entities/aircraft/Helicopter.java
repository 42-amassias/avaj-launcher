package avaj.launcher.simulation.entities.aircraft;

import avaj.launcher.utils.Coordinates;
import avaj.launcher.weather.Weather;
import avaj.launcher.weather.WeatherMap;

public class Helicopter extends AAircraft
{

	public Helicopter(long id, String name, Coordinates coordinates)
	{
		super(id, name, coordinates);
	}

	@Override
	protected void initializeOffsets(WeatherMap<Coordinates> offsets)
	{
		offsets.put(Weather.SUN, new Coordinates(10, 0, 2));
		offsets.put(Weather.RAIN, new Coordinates(5, 0, 0));
		offsets.put(Weather.FOG, new Coordinates(1, 0, 0));
		offsets.put(Weather.SNOW, new Coordinates(0, 0, -12));
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
		return ("Helicopter");
	}
}
