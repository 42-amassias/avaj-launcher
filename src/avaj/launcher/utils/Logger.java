package avaj.launcher.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Logger
{
	private static final String OUTPUT_FILE_NAME = "./simulation.txt";

	private static Logger instance = null;

	private FileOutputStream output;

	private Logger()
	{}

	public static Logger getInstance()
	{
		if (instance == null)
			instance = new Logger();
		return (instance);
	}

	public void start() throws IOException
	{
		File outputFile = new File(OUTPUT_FILE_NAME);
		if (!outputFile.exists())
			outputFile.createNewFile();
		this.output = new FileOutputStream(outputFile);
	}

	public void log(String fmt, Object... args)
	{
		final String message = String.format(fmt + "\n", args);
		try
		{
			this.output.write(message.getBytes());
		} catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public void stop() throws IOException
	{
		this.output.close();
	}

}
