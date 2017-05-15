package TPE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ListaArray implements Lista {
	private Usuario[] users = new Usuario[10000];
	private CSVReader csvr = new CSVReader();
	private CSVWritter csvw = new CSVWritter();
	private String resultBusqueda = "";
	private String resultAlta = "";
	private String pathCargaUsuarios = "";
	private int cantidad = 0;

	public ListaArray(String pathCargaUsuarios, String resultBusqueda, String resultAlta) {
		this.pathCargaUsuarios = pathCargaUsuarios;
		this.resultAlta = resultAlta;
		this.resultBusqueda = resultBusqueda;
		cargarUsuarios(this.pathCargaUsuarios, false);
	}

	private void cargarUsuarios(String pathCarga, boolean imprimir) {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = csvr.reader(pathCarga);
		int temp = cantidad;
		try {
			for (int i = 0; i < (usuarios.size() + temp); i++) {
				
				if (cantidad >= this.users.length) {
					duplicateArrayLength();
				}
				this.users[cantidad] = usuarios.get(i);
				cantidad++;
			
			}
		} catch (IndexOutOfBoundsException e) {		
		}
		if (imprimir){
			csvw.createWritter(resultAlta);
			try {
				csvw.write(usuarios);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void duplicateArrayLength() {
		System.out.println("El tamaño actual del arreglo está por ser: " + this.users.length * 2);
		Usuario[] usersTemp = new Usuario[this.users.length * 2];
		for (int i = 0; i < this.users.length; i++) {
			usersTemp[i] = this.users[i];
		}
		users = usersTemp;
	}

	@Override
	public void buscarUsuarios(String pathSearch) {
		ArrayList<Usuario> usersQuery = new ArrayList<Usuario>();
		usersQuery = csvr.reader(pathSearch);
		for (Usuario user : usersQuery) {
			user.setExists(false);
			boolean found = false;
			int i = 0;
			Date init = new Date();
			while (!found && (i < users.length) && users[i] != null) {
				if (users[i].getUserId().equals(user.getUserId())) {
					found = true;
					user.setExists(true);
				}
				i++;
			}
			Date end = new Date();
			long result = end.getTime() - init.getTime();
			int size;
			if (users.length <= 640000) {
				size = 500000;
			} else if (users.length <= 1280000) {
				size = 1000000;
			} else {
				size = 3000000;
			}
			guardarTiempo(user, size, result);
		}
		csvw.createWritter(resultBusqueda);
		try {
			csvw.write(usersQuery);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void guardarTiempo(Usuario user, int size, long result) {
		if (size <= 500000) {
			user.setTimeArray("500k", result);
		} else if (size <= 1000000) {
			user.setTimeArray("1m", result);
		} else{
			user.setTimeArray("3m", result);
		}
	}

	@Override
	public void altaUsuarios(String pathAlta) {
		cargarUsuarios(pathAlta, true);
		
	
		
		
		ArrayList<Usuario> usuariosAImprimir = new ArrayList<Usuario>();
		for (Usuario usuario : users) {
			if (usuario != null) {
				usuariosAImprimir.add(usuario);
			}

		}

		
	}
}
