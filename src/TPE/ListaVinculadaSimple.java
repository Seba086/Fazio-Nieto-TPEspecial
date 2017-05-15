package TPE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ListaVinculadaSimple implements Lista {
	private Usuario first;
	private Usuario last;
	private int size = 0;
	private boolean insertarInicio = false;
	private CSVReader csvr = new CSVReader();
	private CSVWritter csvw = new CSVWritter();
	private String resultBusqueda= "";
	private String resultAlta = "";
	private String pathCargaUsuarios = "";
	

	public ListaVinculadaSimple(boolean insertarAlInicio, String pathCargaUsuarios, String resultBusqueda, String resultAlta) {
		this.pathCargaUsuarios = pathCargaUsuarios;
		this.insertarInicio = insertarAlInicio;
		this.resultAlta = resultAlta;
		this.resultBusqueda = resultBusqueda;
		cargarUsuarios();
	}

	public void insertarUsuario(Usuario user) {
		if (this.insertarInicio) {
			insertarUsuarioInicio(user);
		} else {
			insertarUsuarioFinal(user);
		}

	};

	private void insertarUsuarioInicio(Usuario user) {
		user.setNext(first);
		this.first = user;
		this.size++;
	}

	private void insertarUsuarioFinal(Usuario user) {
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
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = csvr.reader(pathCargaUsuarios);
		Date init = new Date();
		for (Usuario user : usuarios) {
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
		ArrayList<Usuario> usersQuery = new ArrayList<Usuario>();
		usersQuery = csvr.reader(pathSearch);
		try {
			for (Usuario user : usersQuery) {
				user.setExists(false);
				boolean found = false;
				Usuario userTemp = first;
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
				guardarTiempo(user, size, result);
			}
			csvw.createWritter(resultBusqueda);
			csvw.write(usersQuery);

		} catch (NullPointerException | IOException e) {
			e.printStackTrace();
		}
	}

	private void guardarTiempo(Usuario user, int size, long result) {
		if (size <= 500000) {
			user.setTimeFirst("500k", result);
		} else if (size <= 1000000) {
			user.setTimeFirst("1m", result);
		} else {
			user.setTimeFirst("3m", result);
		}
	}
	private ArrayList<Usuario> toArrayList(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = this.first;
		while(usuario.hasNext()) {
			usuarios.add(usuario);
			usuario = usuario.getNext();
		}
		return usuarios;
	}
	@Override
	public void altaUsuarios(String pathAlta) {
		ArrayList<Usuario> usersAlta = new ArrayList<Usuario>();
		usersAlta = csvr.reader(pathAlta);
		try {
			for (Usuario user : usersAlta) {
				insertarUsuario(user);
			}

		} catch (NullPointerException e) {

		}
		csvw.createWritter(resultAlta);
		try {
			csvw.write(usersAlta);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}