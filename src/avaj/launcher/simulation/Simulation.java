package avaj.launcher.simulation;

import java.util.ArrayList;
import java.util.List;

import avaj.launcher.exception.FlyableAlreadyRegisteredException;
import avaj.launcher.simulation.entities.AFlyable;
import avaj.launcher.tower.WeatherTower;

public class Simulation
{
	private List<AFlyable> flyables;
	private WeatherTower weatherTower;

	public Simulation(List<AFlyable> flyables)
	{
		assert flyables != null;
		this.flyables = new ArrayList<>();
		this.weatherTower = new WeatherTower();

		try
		{
			for (AFlyable flyable : flyables)
			{
				assert flyable != null;
				flyable.registerTower(weatherTower);
				this.flyables.add(flyable);
			}
		} catch (FlyableAlreadyRegisteredException e)
		{
			// Unreachable
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void step()
	{
		weatherTower.weatherChanged();
	}
}
