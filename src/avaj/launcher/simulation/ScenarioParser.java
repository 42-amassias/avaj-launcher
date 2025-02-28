package avaj.launcher.simulation;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import avaj.launcher.simulation.entities.AFlyable;
import avaj.launcher.simulation.entities.AircraftFactory;
import avaj.launcher.simulation.entities.aircraft.AAircraft;
import avaj.launcher.utils.Coordinates;

public class ScenarioParser
{
	private List<AFlyable> flyables;
	private int steps;
	private final String path;

	public ScenarioParser(String path) throws FileNotFoundException, EOFException, NumberFormatException
	{
		assert path != null;
		this.path = path;
		this.parse();
	}

	public List<AFlyable> getFlyables()
	{
		return (this.flyables);
	}

	public int getSteps()
	{
		return (this.steps);
	}

	private void parse() throws FileNotFoundException, EOFException, NumberFormatException
	{
		final File f = new File(path);
		flyables = new ArrayList<>();

		try (Scanner sc = new Scanner(f))
		{
			this.steps = this.getSteps(sc);
			while (sc.hasNextLine())
			{
				final String line = sc.nextLine();

				flyables.add(this.getAircraft(line));
			}
		}
	}

	private int getSteps(Scanner sc) throws EOFException, NumberFormatException
	{
		if (!sc.hasNextLine())
			throw new EOFException();
		String str = sc.nextLine();
		return (Integer.parseInt(str));
	}

	private AAircraft getAircraft(String descriptor)
	{
		final String[] tokens = descriptor.split(" ");
		final String type = tokens[0];
		final String name = tokens[1];
		final int longitude = Integer.parseInt(tokens[2]);
		final int latitude = Integer.parseInt(tokens[3]);
		final int height = Integer.parseInt(tokens[4]);
		final Coordinates coordinates = new Coordinates(longitude, latitude, height);

		return (AircraftFactory.newAircraft(type, name, coordinates));
	}
}
