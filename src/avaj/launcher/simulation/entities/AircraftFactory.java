package avaj.launcher.simulation.entities;

import avaj.launcher.exception.UnknownAircraftException;
import avaj.launcher.simulation.entities.aircraft.AAircraft;
import avaj.launcher.simulation.entities.aircraft.AircraftType;
import avaj.launcher.utils.Coordinates;

public class AircraftFactory
{
	private static int id = 0;

	private AircraftFactory()
	{}

	/**
	 * @throws UnknownAircraftException If the aircraft type in unknown.
	 */
	public static AAircraft newAircraft(String type, String name, Coordinates coordinates) throws UnknownAircraftException
	{
		final String enumName = convertCamelCaseToUpperSnake(type);
		final AircraftType enumType;

		try
		{
			enumType = AircraftType.valueOf(enumName);
		} catch (Exception e)
		{
			throw new UnknownAircraftException(type);
		}

		assert enumType != null;
		return (enumType.create(AircraftFactory.id++, name, coordinates));
	}

	private static String convertCamelCaseToUpperSnake(String input)
	{
		StringBuilder result = new StringBuilder();
		boolean first = true;

		for (char c : input.toCharArray())
		{
			if (!first && Character.isUpperCase(c))
				result.append("_").append(Character.toLowerCase(c));
			else
				result.append(c);
			first = false;
		}
		return (result.toString().toUpperCase());
	}
}
