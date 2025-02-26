package avaj.launcher.simulation.entities.aircraft;

import java.lang.reflect.Constructor;

import avaj.launcher.utils.Coordinates;

public enum AircraftType
{
	JET_PLANE(JetPlane.class),
	HELICOPTER(Helicopter.class),
	BALOON(Baloon.class);

	private final Constructor<? extends AAircraft> constructor;

	AircraftType(Class<? extends AAircraft> c)
	{
		assert c != null;
		constructor = getConstructor(c);
		assert constructor != null;
	}

	public AAircraft create(long id, String name, Coordinates coordinates)
	{
		AAircraft aircraft = null;
		try
		{
			aircraft = constructor.newInstance(id, name, coordinates);
		} catch (Exception e)
		{}
		return (aircraft);
	}

	private static <T> Constructor<T> getConstructor(Class<T> c)
	{
		Constructor<T> constructor = null;
		try {
			constructor = c.getConstructor(long.class, String.class, Coordinates.class);
		} catch(Exception e)
		{}
		return (constructor);
	}
}
