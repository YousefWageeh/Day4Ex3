import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList; 
import java.util.List;

public class CountryCSVReader {
	public List<Country> readCountriesFromCSV(String filePath){
		List<Country> countries = new ArrayList<>();
		
		try {

        	FileReader fr = new FileReader(filePath);
        	BufferedReader bufferedReader = new BufferedReader(fr);
        	String line;
            //String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
            	countries.add(createCountry(line.split(",")));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
		
		return countries;
	}
	
	public static Country createCountry(String[] metadata) {
		String code  = metadata[0];
		String name = metadata[1];
		String continent = metadata[2];
		double surfaceArea = Double.parseDouble(metadata[3]);
		double population = Double.parseDouble(metadata[4]);
		double gnp = Double.parseDouble(metadata[5]);
		int capital = Integer.parseInt(metadata[6]);
		
		return new Country(code, name, continent, surfaceArea, population, gnp, capital);
	}
}
