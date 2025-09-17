package avaj.launcher.tower;

import avaj.launcher.exception.FlyableAlreadyRegisteredException;
import avaj.launcher.exception.NoSuchFlyableException;
import avaj.launcher.simulation.entities.AFlyable;
import avaj.launcher.utils.Coordinates;
import avaj.launcher.utils.Logger;
import avaj.launcher.weather.Weather;
import avaj.launcher.weather.WeatherProvider;

public class WeatherTower extends Tower
{
	public Weather getWeather(Coordinates coordinates)
	{
		final WeatherProvider weatherProvider = WeatherProvider.getInstance();
		final Weather weather = weatherProvider.getCurrentWeather(coordinates);

		return (weather);
	}

	public void weatherChanged()
	{
		super.conditionChanged();
	}

	@Override
	public void register(AFlyable aircraft) throws FlyableAlreadyRegisteredException
	{
		super.register(aircraft);
		Logger.getInstance().log("Weather tower: %s registered to weather tower.", aircraft.toString());
	}

	@Override
	public void unregister(AFlyable aircraft) throws NoSuchFlyableException
	{
		super.unregister(aircraft);
		Logger.getInstance().log("Weather tower: %s unregistered from weather tower.", aircraft.toString());
	}
}
