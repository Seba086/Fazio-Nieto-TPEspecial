package TPE;

import java.util.ArrayList;

public interface IUserList {
	
	
	public void buscarUsuarios(String pathSearch);
	
	public void saveResult(User user, int size, long result);
	
	public void altaUsuarios(String pathAlta);
}
