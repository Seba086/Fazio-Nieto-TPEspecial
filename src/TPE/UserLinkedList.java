package TPE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class UserLinkedList implements IUserList {
	private User first;
	private User last;
	private int size = 0;
	private boolean insertarInicio = false;
	private CSVReader csvr = new CSVReader();
	private CSVWritter csvw = new CSVWritter();
	private String resultBusqueda= "";
	private String resultAlta = "";
	private String pathCargaUsuarios = "";
	

	public UserLinkedList(boolean insertarAlInicio, String pathCargaUsuarios, String resultBusqueda, String resultAlta) {
		this.pathCargaUsuarios = pathCargaUsuarios;
		this.insertarInicio = insertarAlInicio;
		this.resultAlta = resultAlta;
		this.resultBusqueda = resultBusqueda;
		cargarUsuarios();
	}

	public void insertarUsuario(User user) {
		if (this.insertarInicio) {
			insertarUsuarioInicio(user);
		} else {
			insertarUsuarioFinal(user);
		}

	};

	private void insertarUsuarioInicio(User user) {
		user.setNext(first);
		this.first = user;
		this.size++;
	}

	private void insertarUsuarioFinal(User user) {
		if (this.first == null) {
			this.first = user;
			this.last = first;
		} else {
			this.last.setNext(user);
			this.last = user;
		}
		this.size++;
	}

	private void cargarUsuarios() {
		ArrayList<User> usuarios = new ArrayList<User>();
		usuarios = csvr.reader(pathCargaUsuarios);
		Date init = new Date();
		for (User user : usuarios) {
			insertarUsuarioFinal(user);
			Date end = new Date();
			long result = end.getTime() - init.getTime();
			user.setTimeLast("500k", result);
		}
		Date end = new Date();
		long result = end.getTime() - init.getTime();
	}

	@Override
	public void buscarUsuarios(String pathSearch) {
		ArrayList<User> usersQuery = new ArrayList<User>();
		usersQuery = csvr.reader(pathSearch);
		try {
			for (User user : usersQuery) {
				user.setExists(false);
				boolean found = false;
				User userTemp = first;
				Date init = new Date();
				int i = 0;
				while (!found && (i < size)) {
					if (userTemp.getUserId().equals(user.getUserId())) {
						found = true;
						user.setExists(true);
					} else {
						if (userTemp.hasNext()) {
							userTemp = userTemp.getNext();
						}
					}
					i++;
				}
				Date end = new Date();
				long result = end.getTime() - init.getTime();
				saveResult(user, size, result);
			}
			csvw.createWritter(resultBusqueda);
			csvw.write(usersQuery);

		} catch (NullPointerException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveResult(User user, int size, long result) {
		if (size <= 500000) {
			user.setTimeFirst("500k", result);
		} else if (size <= 1000000) {
			user.setTimeFirst("1m", result);
		} else {
			user.setTimeFirst("3m", result);
		}
	}
	private ArrayList<User> toArrayList(){
		ArrayList<User> usuarios = new ArrayList<User>();
		User usuario = this.first;
		while(usuario.hasNext()) {
			usuarios.add(usuario);
			usuario = usuario.getNext();
		}
		return usuarios;
	}
	@Override
	public void altaUsuarios(String pathAlta) {
		ArrayList<User> usersAlta = new ArrayList<User>();
		usersAlta = csvr.reader(pathAlta);
		try {
			for (User user : usersAlta) {
				insertarUsuario(user);
			}

		} catch (NullPointerException e) {

		}
		csvw.createWritter(resultAlta);
		try {
			csvw.write(this.toArrayList());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}