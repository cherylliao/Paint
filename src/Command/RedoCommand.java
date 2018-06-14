package Command;

public class RedoCommand implements IStartandEndPoint{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		CommandHistory.redo();
	}

	

}
