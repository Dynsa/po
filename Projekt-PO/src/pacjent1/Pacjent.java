package pacjent1;
import java.util.Scanner;

public class Pacjent {
	private String Imiê;
	private String Nazwisko;
	private String PESEL;
	public Adres Adres = new Adres();
	
	public Pacjent(){}
	
	public Pacjent(String Imiê, String Nazwisko, String PESEL, Adres Adres){
		this.Imiê = Imiê;
		this.Nazwisko = Nazwisko;
		this.PESEL = PESEL;
		this.Adres = Adres;
	}
	
	public String Imiê(){
		return Imiê;
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
		
		System.out.println("Podaj imiê");		
		Scanner Imiê = new Scanner(System.in);
	    String nImiê = Imiê.nextLine();
	    
		System.out.println("Podaj Nazwisko");		
		Scanner Nazwisko = new Scanner(System.in);
	    String nNazwisko = Nazwisko.nextLine();
	    
		System.out.println("Podaj PESEL");		
		Scanner PESEL = new Scanner(System.in);
	    String nPESEL = PESEL.nextLine();
	    
	    Adres nAdres = new Adres();
	    
		Pacjent Nowy = new Pacjent(nImiê, nNazwisko, nPESEL, nAdres.Nowy());
		
		return Nowy;
		
	}
	
	public void Wyœwietl(){
		System.out.println("Imiê i Nazwisko: " + Imiê() + " " +  Nazwisko());
		System.out.println("PESEL: " + PESEL());
		System.out.println("Adres: " + Adres.Ulica() + " " + Adres.NrUlicy() + "/" + Adres.NrDomu());
		System.out.println(Adres.Miejscowoœæ());
	}
}
