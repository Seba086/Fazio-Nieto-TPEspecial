package TPE;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWritter {
	BufferedWriter bw = null;

	public void createWritter(String path) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void write(ArrayList<Usuario> users) throws IOException {
		String k500 = "500k";
		String m1 = "1m";
		String m3 = "3m";
		bw.write("id_usuario;encontrado;tiempo");
		bw.newLine();
		for (Usuario user : users) {
			try {
				int timeOne = (int) (user.getTimeArray(k500)+user.getTimeArray(m1)+user.getTimeArray(m3));
				int timeTwo = (int) (user.getTimeFirst(k500)+ user.getTimeFirst(m1) + user.getTimeFirst(m3));
				int timeThree = (int) (user.getTimeLast(k500) + user.getTimeLast(m1) + user.getTimeLast(m3));
				String contenidoLinea1 = user.getUserId().toString() +";" + user.exists()+ ";" + (int) (timeOne  + timeTwo  + timeThree);
				bw.write(contenidoLinea1);
				bw.newLine();
			} catch (IOException | NullPointerException ioe) {
				ioe.printStackTrace();
			}
		}
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}