package avaj.launcher.simulation.entities;

import avaj.launcher.exception.FlyableAlreadyRegisteredException;
import avaj.launcher.tower.WeatherTower;

public abstract class AFlyable
{
	protected WeatherTower weatherTower;

	public void registerTower(WeatherTower weatherTower) throws FlyableAlreadyRegisteredException
	{
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}

	public abstract void updateConditions();
}
