package Main;

import java.io.*;
import java.util.Scanner;

import pacjent1.*;
import lekarz.*;

public class test implements Serializable{

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		while(true){
			System.out.println("MENU");
			System.out.println("1. Dodanie nowego pacjenta");
			
			Scanner numer = new Scanner(System.in);
			int Opcja = numer.nextInt();
	    
			switch(Opcja){
			case 1:
				Pacjent a = new Pacjent();
				Pacjent nowy = new Pacjent();
				nowy = a.Nowy();
				
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");
				System.out.println("Poda�e� nast�puj�ce dane: ");
				
				nowy.Wy�wietl();
				
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");
				System.out.println("Czy dane si� zgadzaj�?");
    	
				Scanner potw = new Scanner(System.in);
				String Odp = potw.nextLine();
		    
				if(Odp.equals("tak") || Odp.equals("TAK") || Odp.equals("Tak")) {
					FileWriter zapis = new FileWriter("Pacjenci.txt", true);
				    BufferedWriter out = new BufferedWriter(zapis);
				    out.write(nowy.Imi�() + "\t" + nowy.Nazwisko() + "\t" + nowy.PESEL() + "\t" + nowy.Adres.Ulica() + "\t" + nowy.Adres.NrUlicy() + "\\" + nowy.Adres.NrDomu() + "\t" + nowy.Adres.Miejscowo��());
				    out.close();
				    
					System.out.println("Dodano!");
					System.out.println(" ");
					System.out.println(" ");
					System.out.println(" ");
				}
		    
				else {
					System.out.println("Dane nie zosta�y zapisane. Wprowad� ponownie dane");
					Opcja = 1;
				}
	    	
				break;
	    	
			}	        
		}
	}
}
