package foosball.exceptions;

public class PlayerIndexOutOfBoundsException extends Exception{
	private static final long serialVersionUID = 1L;

	public PlayerIndexOutOfBoundsException(String msg) {
		super(msg);
	}
}
