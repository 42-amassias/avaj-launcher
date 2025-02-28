package avaj.launcher.simulation.entities.aircraft;

import avaj.launcher.simulation.entities.AFlyable;
import avaj.launcher.utils.Coordinates;
import avaj.launcher.utils.Logger;
import avaj.launcher.weather.Weather;
import avaj.launcher.weather.WeatherMap;

public abstract class AAircraft extends AFlyable
{
	private final WeatherMap<Coordinates> offsets;
	private final WeatherMap<String> messages;

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
		this.offsets = new WeatherMap<>();
		this.messages = new WeatherMap<>();
		this.initializeOffsets(this.offsets);
		this.initializeWeatherMessages(this.messages);
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
		normalizeCoordinates();

		Logger.getInstance().log("%s: %s", toString(), this.messages.get(super.weatherTower.getWeather(this.coordinates)));

		if (!needsToLand())
			return ;
		try
		{
			weatherTower.unregister(this);
		} catch (Exception e)
		{
			// TODO
		}
		Logger.getInstance().log("%s: %s", toString(), getLandingMessage());
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

	protected abstract void initializeOffsets(WeatherMap<Coordinates> offsets);
	protected abstract void initializeWeatherMessages(WeatherMap<String> messages);

	protected abstract String getType();
	protected String getLandingMessage()
	{
		return ("Landing");
	}

	private void normalizeCoordinates()
	{
		if (coordinates.getHeight() <= 100)
			return;
		coordinates = new Coordinates(
			coordinates.getLongitude(),
			coordinates.getLatitude(),
			100
		);
	}

	private boolean needsToLand()
	{
		return (this.coordinates.getHeight() <= 0);
	}

	private String generateIdentifier()
	{
		return (String.format("%s#%s(%d)",
			this.getType(),
			this.getName(),
			this.getId()
		));
	}

}
