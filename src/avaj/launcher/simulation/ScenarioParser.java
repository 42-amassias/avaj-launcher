package avaj.launcher.simulation;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import avaj.launcher.exception.AircraftDescriptorIncompleteException;
import avaj.launcher.exception.AircraftDescriptorTooMuchDataException;
import avaj.launcher.exception.UnknownAircraftException;
import avaj.launcher.simulation.entities.AFlyable;
import avaj.launcher.simulation.entities.AircraftFactory;
import avaj.launcher.simulation.entities.aircraft.AAircraft;
import avaj.launcher.utils.Coordinates;

public class ScenarioParser
{
	private List<AFlyable> flyables;
	private int stepCount;
	private final String path;

	public ScenarioParser(String path) throws FileNotFoundException, EOFException, NumberFormatException, UnknownAircraftException, AircraftDescriptorIncompleteException, AircraftDescriptorTooMuchDataException
	{
		assert path != null;
		this.path = path;
		this.parse();
	}

	public List<AFlyable> getFlyables()
	{
		return (this.flyables);
	}

	public int getStepCount()
	{
		return (this.stepCount);
	}

	private void parse() throws FileNotFoundException, EOFException, NumberFormatException, UnknownAircraftException, AircraftDescriptorIncompleteException, AircraftDescriptorTooMuchDataException
	{
		final File f = new File(path);
		flyables = new ArrayList<>();

		try (Scanner sc = new Scanner(f))
		{
			this.stepCount = this.getStepCount(sc);
			while (sc.hasNextLine())
				flyables.add(this.getAircraft(sc.nextLine()));
		}
	}

	private int getStepCount(Scanner sc) throws EOFException, NumberFormatException
	{
		if (!sc.hasNextLine())
			throw new EOFException();
		String str = sc.nextLine();
		return (Integer.parseInt(str));
	}

	private AAircraft getAircraft(String descriptor) throws UnknownAircraftException, AircraftDescriptorIncompleteException, AircraftDescriptorTooMuchDataException
	{
		final String[] tokens = descriptor.split(" ");
		if (tokens.length < 5)
			throw new AircraftDescriptorIncompleteException();
		if (tokens.length > 5)
			throw new AircraftDescriptorTooMuchDataException();
		final String type = tokens[0];
		final String name = tokens[1];
		final int longitude = Integer.parseInt(tokens[2]);
		final int latitude = Integer.parseInt(tokens[3]);
		final int height = Integer.parseInt(tokens[4]);
		final Coordinates coordinates = new Coordinates(longitude, latitude, height);

		ScenarioParser.validate(coordinates, name);

		return (AircraftFactory.newAircraft(type, name, coordinates));
	}

	private static void validate(Coordinates coordinates, String name)
	{
		if (coordinates.getLongitude() < 0)
			throw new IllegalArgumentException("Negative longitude for aircraft \"" + name + "\"");
		if (coordinates.getLatitude() < 0)
			throw new IllegalArgumentException("Negative latitude for aircraft \"" + name + "\"");
		if (coordinates.getHeight() < 0)
			throw new IllegalArgumentException("Negative height for aircraft \"" + name + "\"");
	}
}
