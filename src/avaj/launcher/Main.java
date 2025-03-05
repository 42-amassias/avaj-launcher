package avaj.launcher;

import avaj.launcher.exception.AircraftDescriptorIncompleteException;
import avaj.launcher.exception.AircraftDescriptorTooMuchDataException;
import avaj.launcher.exception.UnknownAircraftException;
import avaj.launcher.simulation.Simulation;
import avaj.launcher.utils.Logger;
import avaj.launcher.simulation.ScenarioParser;

import java.io.EOFException;
import java.io.FileNotFoundException;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		if (args.length < 1)
			throw new RuntimeException("Missing scenario file argument.");
		if (args.length > 1)
			throw new RuntimeException("Too many arguments.");

		Logger.getInstance().start();
		try
		{
			final ScenarioParser parser = new ScenarioParser(args[0]);
			final Simulation simulation = new Simulation(parser.getFlyables());

			for (int i = 0; i < parser.getStepCount(); ++i)
				simulation.step();
		}
		
		catch (FileNotFoundException e)
		{
			System.err.println("Could not find scenario file.");
		} catch (EOFException e)
		{
			System.err.println("Scenario file is not correctly formatted: missing iteration count.");
		} catch (NumberFormatException e)
		{
			System.err.println("Scenario file is not correctly formatted: Number format.");
		} catch (AircraftDescriptorIncompleteException e)
		{
			System.err.println("Scenario file is not correctly formatted: Missing aircraft data.");
		} catch (AircraftDescriptorTooMuchDataException e)
		{
			System.err.println("Scenario file is not correctly formatted: Too much data for an aircraft.");
		} catch (UnknownAircraftException e)
		{
			System.err.println("Scenario file is not correctly formatted: Unknown aircraft.");
		} catch (Exception e)
		{
			System.err.println("Unexpected exception: " + e.getMessage());
		} finally
		{
			Logger.getInstance().stop();
		}
	}
}
