package avaj.launcher.simulation.entities.aircraft;

import avaj.launcher.utils.Coordinates;
import avaj.launcher.weather.Weather;
import avaj.launcher.weather.WeatherMap;

public class JetPlane extends AAircraft
{
	public JetPlane(long id, String name, Coordinates coordinates)
	{
		super(id, name, coordinates);
	}

	@Override
	protected void initializeOffsets(WeatherMap offsets)
	{
		offsets.put(Weather.SUN, new Coordinates(0, 10, 2));
		offsets.put(Weather.RAIN, new Coordinates(0, 5, 0));
		offsets.put(Weather.FOG, new Coordinates(0, 1, 0));
		offsets.put(Weather.SNOW, new Coordinates(0, 0, -7));
	}
}
