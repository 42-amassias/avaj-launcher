package avaj.launcher.utils;

public class Logger
{
	private static Logger instance = null;

	private Logger()
	{}

	public static Logger getInstance()
	{
		if (instance == null)
			instance = new Logger();
		return (instance);
	}

	public void start()
	{
	}

	public void log(String fmt, Object... args)
	{
		System.out.format(fmt + "\n", args);
	}

	public void stop()
	{
	}
}
