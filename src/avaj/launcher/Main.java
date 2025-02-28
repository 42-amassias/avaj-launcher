package avaj.launcher;

import avaj.launcher.simulation.Simulation;
import avaj.launcher.simulation.ScenarioParser;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		final ScenarioParser parser = new ScenarioParser("subject/scenario.txt");
		final Simulation simulation = new Simulation(parser.getFlyables());

		for (int i = 0; i < parser.getSteps(); ++i)
			simulation.step();
	}
}
