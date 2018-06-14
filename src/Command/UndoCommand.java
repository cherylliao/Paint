package Command;

public class UndoCommand implements IStartandEndPoint{
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		CommandHistory.undo();
		
	}

}
