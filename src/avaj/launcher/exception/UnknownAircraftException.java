package avaj.launcher.exception;

public class UnknownAircraftException extends Exception
{
	public UnknownAircraftException(String type)
	{
		super(type);
	}
}
