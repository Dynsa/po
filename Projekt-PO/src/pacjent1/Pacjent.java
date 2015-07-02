package pacjent1;
import java.util.Scanner;

public class Pacjent {
	private String Imi�;
	private String Nazwisko;
	private String PESEL;
	public Adres Adres = new Adres();
	
	public Pacjent(){}
	
	public Pacjent(String Imi�, String Nazwisko, String PESEL, Adres Adres){
		this.Imi� = Imi�;
		this.Nazwisko = Nazwisko;
		this.PESEL = PESEL;
		this.Adres = Adres;
	}
	
	public String Imi�(){
		return Imi�;
	}
	public String Nazwisko(){
		return Nazwisko;
	}
	public String PESEL(){
		return PESEL;
	}
	public Adres Adres(){
		return Adres;
	}
	
	public Pacjent Nowy(){
		
		System.out.println("Podaj imi�");		
		Scanner Imi� = new Scanner(System.in);
	    String nImi� = Imi�.nextLine();
	    
		System.out.println("Podaj Nazwisko");		
		Scanner Nazwisko = new Scanner(System.in);
	    String nNazwisko = Nazwisko.nextLine();
	    
		System.out.println("Podaj PESEL");		
		Scanner PESEL = new Scanner(System.in);
	    String nPESEL = PESEL.nextLine();
	    
	    Adres nAdres = new Adres();
	    
		Pacjent Nowy = new Pacjent(nImi�, nNazwisko, nPESEL, nAdres.Nowy());
		
		return Nowy;
		
	}
	
	public void Wy�wietl(){
		System.out.println("Imi� i Nazwisko: " + Imi�() + " " +  Nazwisko());
		System.out.println("PESEL: " + PESEL());
		System.out.println("Adres: " + Adres.Ulica() + " " + Adres.NrUlicy() + "/" + Adres.NrDomu());
		System.out.println(Adres.Miejscowo��());
	}
}
