/*
 * Programación III - TPE
 */
package TPE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * Ejemplo de cómo leer un archivo CSV
 * 
 * @author Mariano A. Fernandez <fernandez.mariano.a@gmail.com>
 */
public class CSVReader {

    public ArrayList<User> reader(String path)  {
    	ArrayList<User> users = new ArrayList<User>();
    	String csvFile = path;
        String line = "";
        String csvSplitBy = ";";
        int numLine = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
            	if(numLine > 0){
            		User user = new User();
                    String[] items = line.split(csvSplitBy);
                    user.setUserId(items[0].toString());
                    for(int i=1; i < items.length-1; i++){
                    	user.addInterest(items[i].toString());
                    }
                    users.add(user);
            	}
            	numLine++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
   
}