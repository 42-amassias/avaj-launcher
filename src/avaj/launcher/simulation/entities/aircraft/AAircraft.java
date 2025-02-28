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

	protected final String identifier;

	protected AAircraft(long id, String name, Coordinates coordinates)
	{
		this.id = id;
		this.name = name;
		this.coordinates = coordinates;
		this.identifier = this.generateIdentifier();
		this.offsets = new WeatherMap();
		this.initializeOffsets(this.offsets);
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

	public long getId()
	{
		return (this.id);
	}

	public String getName()
	{
		return (this.name);
	}

	public Coordinates getCoordinates()
	{
		return (this.coordinates);
	}

	@Override
	public String toString()
	{
		return (this.identifier);
	}

	protected abstract void initializeOffsets(WeatherMap offsets);

	protected abstract String getType();

	private String generateIdentifier()
	{
		return (String.format("%s#%s(%d)",
			this.getType(),
			this.getName(),
			this.getId()
		));
	}

}
