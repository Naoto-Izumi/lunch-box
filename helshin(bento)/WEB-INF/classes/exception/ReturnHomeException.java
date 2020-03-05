package exception;

public class ReturnHomeException extends RuntimeException{
    public ReturnHomeException(String mess,Throwable cause){
        super(mess,cause);
    }
    public ReturnHomeException(String mess){
		super(mess);
	}
}