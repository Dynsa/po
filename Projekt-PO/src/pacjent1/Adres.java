package pacjent1;
import java.util.Scanner;

public class Adres {
	private String Ulica;
	private int NrUlicy;
	private int NrDomu;
	private String Miejscowoœæ;
	
	public Adres(){}
	
	public Adres(String Ulica, int NrUlicy, int NrDomu, String Miejscowoœæ){
		this.Ulica = Ulica;
		this.NrUlicy = NrUlicy;
		this.NrDomu = NrDomu;
		this.Miejscowoœæ = Miejscowoœæ;
	}
	
	public String Ulica(){
		return Ulica;
	}
	public int NrUlicy(){
		return NrUlicy;
	}
	public int NrDomu(){
		return NrDomu;
	}
	public String Miejscowoœæ(){
		return Miejscowoœæ;
	}
	
	public Adres Nowy(){
		
		System.out.println("Podaj ulicê");		
		Scanner Ulica = new Scanner(System.in);
		String nUlica = Ulica.nextLine();
		
		System.out.println("Podaj Numer");		
		Scanner Numer = new Scanner(System.in);
		int nNumer = Numer.nextInt();
		
		System.out.println("Podaj Dom");		
		Scanner Dom = new Scanner(System.in);
		int nDom = Dom.nextInt();
		
		System.out.println("Podaj miejscowoœæ");		
		Scanner Miejscowoœæ = new Scanner(System.in);
		String nMiejscowoœæ = Miejscowoœæ.nextLine();
		
		Adres nAdres = new Adres(nUlica, nNumer, nDom, nMiejscowoœæ);
		
		return nAdres;
		
	}
}
