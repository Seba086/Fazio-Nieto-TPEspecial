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

	public void write(ArrayList<User> users) {
		String k500 = "500k";
		String m1 = "1m";
		String m3 = "3m";
		for (User user : users) {
			try {
				String timeOne = user.getTimeArray(k500)+ ";" + user.getTimeArray(m1)+ ";" + user.getTimeArray(m3);
				String timeTwo = user.getTimeFirst(k500)+ ";" + user.getTimeFirst(m1)+ ";" + user.getTimeFirst(m3);
				String timeThree = user.getTimeLast(k500)+ ";" + user.getTimeLast(m1)+ ";" + user.getTimeLast(m3);
				String contenidoLinea1 = user.getUserId().toString() + timeOne + timeTwo + timeThree;
				bw.write(contenidoLinea1);
				bw.newLine();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}