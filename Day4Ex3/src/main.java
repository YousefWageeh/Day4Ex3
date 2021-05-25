import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		CityCSVReader cityReader = new CityCSVReader();
        List<City> cities = cityReader.readCitiesFromCSV("F:\\youssef lap\\ITI\\7 Java\\CSV_files\\Cities.csv");
        
        //To print cities
        /*
        for(City c: cities) {
        	System.out.println("id: "+ c.getId() +"name: " + c.getName() + "");
        }
        System.out.println(City.get(0));
        */
        
        CountryCSVReader countryReader = new CountryCSVReader();
        List<Country> countries = countryReader.readCountriesFromCSV("F:\\youssef lap\\ITI\\7 Java\\CSV_files\\Countries.csv");
        
        //To print countries
        /*
        for(Country c: countries) {
        	System.out.println("name: "+ c.getName() +" Area: " + c.getSurfaceArea() + " Pop: "+c.getPopulation());
        }
        */
        
        Map<String, List<String>> citiesPerCountry = new LinkedHashMap < >();
		
        for(Country c: countries) {
        	String code = c.getCode();
        	
        	List<String> x = cities.stream().filter(cit -> cit.getCode().equals(" "+code)).map(City::getName).collect(Collectors.toList());
        	
        	citiesPerCountry.put(code, x);
        }
        
        //To print all the Map
        //System.out.println(citiesPerCountry);
        
        
        //Take input from user
        InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		System.out.println("Enter Country code: ");
		String code = br.readLine();
        
    	List<String> getSort = cities.stream().filter(cit -> cit.getCode().equals(" "+code)).sorted(Comparator.comparing(City::getPopulation)).map(City::getName).collect(Collectors.toList());
        System.out.println("Cities sorted based on population");
    	System.out.println(getSort);

	}

}
