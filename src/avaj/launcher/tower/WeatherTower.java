package avaj.launcher.tower;

import avaj.launcher.utils.Coordinates;
import avaj.launcher.weather.WeatherProvider;

public class WeatherTower extends Tower
{
	public String getWeather(Coordinates coordinates)
	{
		return (WeatherProvider.getInstance().getCurrentWeather(coordinates));
	}

	public void weatherChanged()
	{
		super.conditionChanged();
	}
}
