package Main;

import java.io.*;
import java.util.Scanner;

import pacjent1.*;
import lekarz.*;


import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class test extends JFrame implements Serializable {
	
    public test() {
        initUI();
    }

    private void initUI() {
        
    	JButton quitButton = new JButton("Quit");
    	quitButton.setToolTipText("Leave the application");
    	
    	quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
    	
    	createLayout(quitButton);
    	
        setTitle("Przychodnia");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );
    }

	public static void main(String[] args) throws IOException, ClassNotFoundException{
			
		EventQueue.invokeLater(new Runnable() {
	        
            @Override
            public void run() {
                test layout = new test();
                layout.setVisible(true);
            }
        });
			
			
			
			
			
			
			
			
			
			
			
		/*
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
			*/
	    	        
	}
}
