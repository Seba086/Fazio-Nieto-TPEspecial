package TPE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class UserArray implements IUserList{
	private User[] users = new User[10000]; 
	protected CSVReader csvr = new CSVReader();
	protected CSVWritter csvw = new CSVWritter();
	protected final String resultSearch = "C:/Users/Seba/workspace/Fazio-Nieto-TPEspecial/datasets/salidabusqueda.csv";
	protected final String resultUploading = "C:/Users/Seba/workspace/Fazio-Nieto-TPEspecial/datasets/salidaalta.csv";
	protected String pathCargaUsuarios = "";
	
	public UserArray(String pathCargaUsuarios){
		this.pathCargaUsuarios = pathCargaUsuarios;
		cargarUsuarios();
	}


	@Override
	public void cargarUsuarios() {
		ArrayList<User> usuarios = new ArrayList<User>();
		usuarios = csvr.reader(pathCargaUsuarios);
		for (int i = 0; i < usuarios.size(); i++) {
			if(i >= this.users.length){
				duplicateArrayLength();
			}
			this.users[i] = usuarios.get(i);
		}
		
	}
	private void duplicateArrayLength(){
		System.out.println("El tamaño actual del arreglo está por ser: " + this.users.length*2);
		 User[] usersTemp = new User[this.users.length*2]; 
		for (int i = 0; i < this.users.length; i++) {
			usersTemp[i] = this.users[i];
		}
		users = usersTemp;
	}

	@Override
	public void searchUsers(String pathSearch) {
		ArrayList<User> usersQuery = new ArrayList<User>();
		usersQuery = csvr.reader(pathSearch );
		for (User user : usersQuery) {
			user.setExists(false);
			boolean found = false;
			int i = 0;
			Date init = new Date();
			while(!found && (i < users.length) && users[i] != null){
				if(users[i].getUserId().equals(user.getUserId())){
					found = true;
					user.setExists(true);
				}
				i++;
			}
			Date end = new Date();
			long result = end.getTime() - init.getTime();
			int size;
			if(users.length <= 640000){
				size = 500000;
			}
			else if(users.length <= 1280000){
				size = 1000000;
			}
			else{
				size = 3000000;
			}
			saveResult(user, size, result);
		}
		csvw.createWritter(resultSearch);
		try {
			csvw.write(usersQuery);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void saveResult(User user, int size, long result) {
		// TODO Auto-generated method stub
		if(size <= 500000){
			user.setTimeArray("500k", result);
		}
		else if( size <= 1000000){
			user.setTimeArray("1m",result);
		}
		else if( size > 3000000){
			user.setTimeArray("3m",result);
		}
	}
}
