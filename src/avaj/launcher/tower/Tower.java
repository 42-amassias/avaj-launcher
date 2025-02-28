package avaj.launcher.tower;

import java.util.ArrayList;
import java.util.List;

import avaj.launcher.exception.FlyableAlreadyRegisteredException;
import avaj.launcher.exception.NoSuchFlyableException;
import avaj.launcher.simulation.entities.AFlyable;

public class Tower
{
	private final List<AFlyable> observers;

	public Tower()
	{
		observers = new ArrayList<>();
	}

	public void register(AFlyable flyable) throws FlyableAlreadyRegisteredException
	{
		if (observers.contains(flyable))
			throw new FlyableAlreadyRegisteredException();
		observers.add(flyable);
	}

	public void unregister(AFlyable flyable) throws NoSuchFlyableException
	{
		if (!observers.contains(flyable))
			throw new NoSuchFlyableException();
		observers.remove(flyable);
	}

	protected void conditionChanged()
	{
		List<AFlyable> copy = new ArrayList<>();
		observers.forEach(copy::add);
		copy.forEach(AFlyable::updateConditions);
	}
}
