package avaj.launcher.simulation.entities.aircraft;

import avaj.launcher.simulation.entities.AFlyable;
import avaj.launcher.utils.Coordinates;
import avaj.launcher.weather.Weather;
import avaj.launcher.weather.WeatherMap;

public abstract class AAircraft extends AFlyable
{
	private final WeatherMap offsets;

	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected AAircraft(long id, String name, Coordinates coordinates)
	{
		this.id = id;
		this.name = name;
		this.coordinates = coordinates;
		this.offsets = new WeatherMap(Weather.class);
	}

	@Override
	public void updateConditions()
	{
		// TODO: maybe throw exception ??
		if (super.weatherTower == null)
			return ;
		final Weather weather = super.weatherTower.getWeather(this.coordinates);
		final Coordinates offset = offsets.get(weather);

		this.coordinates = this.coordinates.offset(offset);
	}

	protected abstract void initializeOffsets(WeatherMap offsets);

}
