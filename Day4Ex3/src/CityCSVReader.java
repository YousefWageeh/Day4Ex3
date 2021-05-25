import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList; 
import java.util.List;

public class CityCSVReader {
	
	public List<City> readCitiesFromCSV(String filePath){
		List<City> cities = new ArrayList<>();
		
		try {

        	FileReader fr = new FileReader(filePath);
        	BufferedReader bufferedReader = new BufferedReader(fr);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                cities.add(createCity(line.split(",")));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
		
		return cities;
	}
	
	public static City createCity(String[] metadata) {
		int id = Integer.parseInt(metadata[0]);
		String name = metadata[1];
		int population = Integer.parseInt(metadata[2]);
		String countryCode = metadata[3];
		
		return new City(id, name, population, countryCode);
	}
}
