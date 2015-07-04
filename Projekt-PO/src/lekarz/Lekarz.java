package lekarz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Lekarz {
	private int ID;
	private String Imi�;
	private String Nazwisko;
	private String Specjalizacja;
	private int NrPokoju;
	private String Opis;
	private int iloscOcen;
	private int sumaOcen;
	
	public Lekarz(){}
	public Lekarz(int ID,String Imi�, String Nazwisko, String Specjalizacja, int NrPokoju, String Opis){
		this.ID = ID;
		this.Imi� = Imi�;
		this.Nazwisko = Nazwisko;
		this.Specjalizacja = Specjalizacja;
		this.NrPokoju = NrPokoju;
		this.Opis = Opis;
		System.out.println(".");
	}
	
	public String Imi�(){
		return Imi�;
	}
	public String Nazwisko(){
		return Nazwisko;
	}
	public String Specjalizacja(){
		return Specjalizacja;
	}
	public int NrPokoju(){
		return NrPokoju;
	}
	public String Opis(){
		return Opis;
	}
	
	public void dodajOcene(int ocena) throws Exception{
		int suma,liczba;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
		
		PreparedStatement stmt = con.prepareStatement("SELECT LiczbaOcen,SumaOcen FROM lekarz WHERE ID=" + this.ID);		    
	    ResultSet result = stmt.executeQuery();
	    while(result.next())
		{
	    	liczba = Integer.parseInt(result.getString(1));
	    	suma = Integer.parseInt(result.getString(2));
	    	suma +=ocena;
	    	liczba++;
		    java.sql.Statement dodaj = con.createStatement();
		    dodaj.executeUpdate("UPDATE lekarz " + "SET LiczbaOcen="+liczba+" , SumaOcen="+suma+" WHERE ID="+this.ID);
		}
	}
	
	public String wyswietlLekarza(int ID) throws Exception{

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");			
			PreparedStatement statement = con.prepareStatement("select * from lekarz where ID="+ID);		
			ResultSet result = statement.executeQuery();
			String tekst = "";
				result.next();
				tekst ="Imi�: "+result.getString(2)+ "\t\tNazwisko: " + result.getString(3)+
						"\nSpecjalizacja: " + result.getString(4)+ "\tNr Pokoju: " + result.getString(5)+
						"\nSrednia ocen: "+result.getFloat(8)/result.getFloat(7)+"\nOpis: " + result.getString(6);
				return tekst;

	}
	
}
