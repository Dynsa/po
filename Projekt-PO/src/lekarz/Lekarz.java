package lekarz;

public class Lekarz {
	private String Imi�;
	private String Nazwisko;
	private String Specjalizacja;
	private int NrPokoju;
	private String Opis;
	
	public Lekarz(){}
	public Lekarz(String Imi�, String Nazwisko, String Specjalizacja, int NrPokoju, String Opis){
		this.Imi� = Imi�;
		this.Nazwisko = Nazwisko;
		this.Specjalizacja = Specjalizacja;
		this.NrPokoju = NrPokoju;
		this.Opis = Opis;
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
	
}
