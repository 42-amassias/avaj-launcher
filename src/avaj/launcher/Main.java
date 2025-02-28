package avaj.launcher;

import avaj.launcher.simulation.Simulation;
import avaj.launcher.simulation.ScenarioParser;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		if (args.length < 1)
			throw new RuntimeException("Missing scenario file argument.");
		if (args.length > 1)
			throw new RuntimeException("Too many arguments.");

		final ScenarioParser parser = new ScenarioParser(args[0]);
		final Simulation simulation = new Simulation(parser.getFlyables());

		for (int i = 0; i < parser.getSteps(); ++i)
			simulation.step();
	}
}
