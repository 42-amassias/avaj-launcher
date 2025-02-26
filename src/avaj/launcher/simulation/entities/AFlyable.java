package avaj.launcher.simulation.entities;

import avaj.launcher.tower.WeatherTower;

public abstract class AFlyable
{
	protected WeatherTower weatherTower;

	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
	}

	public abstract void updateConditions();
}
