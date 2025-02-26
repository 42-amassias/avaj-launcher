package avaj.launcher.tower;

import avaj.launcher.utils.Coordinates;
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
}
