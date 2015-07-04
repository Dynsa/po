package Main;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Statement;





import pacjent1.Adres;
import pacjent1.Pacjent;


public class rejestracja extends Shell {
	
	protected Shell shlRejestracja;
	private Text imieT;
	private Text nazwiskoT;
	private Text peselT;
	private Text ulicaT;
	private Text nrulicyT;
	private Text nrdomuT;
	private Text miastoT;
	private Label lblImie;
	private Label lblNazwisko;
	private Label lblPesel;
	private Label lblUlica;
	private Label lblNrUlicy;
	private Label lblNrDomu;
	private Label lblMiasto;
	private Text loginT;
	private Text hasloT;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			rejestracja shell = new rejestracja(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public rejestracja(Display display) {
		super(display, SWT.SHELL_TRIM);
		
	}
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlRejestracja.open();
		shlRejestracja.layout();
		while (!shlRejestracja.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		shlRejestracja = new Shell();
		shlRejestracja.setSize(450, 450);
		shlRejestracja.setText("Rejestracja");
		
		imieT = new Text(shlRejestracja, SWT.BORDER);
		imieT.setBounds(26, 62, 125, 21);
		
		nazwiskoT = new Text(shlRejestracja, SWT.BORDER);
		nazwiskoT.setBounds(26, 110, 125, 21);
		
		peselT = new Text(shlRejestracja, SWT.BORDER);
		peselT.setBounds(26, 158, 125, 21);
		
		ulicaT = new Text(shlRejestracja, SWT.BORDER);
		ulicaT.setBounds(26, 206, 125, 21);
		
		nrulicyT = new Text(shlRejestracja, SWT.BORDER);
		nrulicyT.setBounds(26, 254, 125, 21);
			
		nrdomuT = new Text(shlRejestracja, SWT.BORDER);
		nrdomuT.setBounds(26, 302, 125, 21);
				
		miastoT = new Text(shlRejestracja, SWT.BORDER);
		miastoT.setBounds(26, 350, 125, 21);
		
		loginT = new Text(shlRejestracja, SWT.BORDER);
		loginT.setBounds(203, 110, 76, 21);
		
		hasloT = new Text(shlRejestracja, SWT.BORDER);
		hasloT.setBounds(203, 158, 76, 21);
		
		Label lblLogin = new Label(shlRejestracja, SWT.NONE);
		lblLogin.setBounds(203, 89, 55, 15);
		lblLogin.setText("Login");
		
		Label lblHaslo = new Label(shlRejestracja, SWT.NONE);
		lblHaslo.setBounds(203, 137, 55, 15);
		lblHaslo.setText("Haslo");
		
		Label lblDaneOsobowe = new Label(shlRejestracja, SWT.NONE);
		lblDaneOsobowe.setBounds(46, 20, 90, 15);
		lblDaneOsobowe.setText("Dane Osobowe");

		
		lblImie = new Label(shlRejestracja, SWT.NONE);
		lblImie.setBounds(26, 41, 55, 15);
		lblImie.setText("IMIE");
		
		lblNazwisko = new Label(shlRejestracja, SWT.NONE);
		lblNazwisko.setBounds(26, 89, 65, 15);
		lblNazwisko.setText("NAZWISKO");
		
		lblPesel = new Label(shlRejestracja, SWT.NONE);
		lblPesel.setBounds(26, 137, 55, 15);
		lblPesel.setText("PESEL");
		
		lblUlica = new Label(shlRejestracja, SWT.NONE);
		lblUlica.setBounds(26, 185, 55, 15);
		lblUlica.setText("ULICA");
		
		lblNrUlicy = new Label(shlRejestracja, SWT.NONE);
		lblNrUlicy.setBounds(26, 233, 55, 15);
		lblNrUlicy.setText("NR ULICY");
	
		lblNrDomu = new Label(shlRejestracja, SWT.NONE);
		lblNrDomu.setBounds(26, 281, 55, 15);
		lblNrDomu.setText("NR DOMU");
		
		lblMiasto = new Label(shlRejestracja, SWT.NONE);
		lblMiasto.setBounds(26, 329, 55, 15);
		lblMiasto.setText("MIASTO");
		
		Button btnTak = new Button(shlRejestracja, SWT.NONE);
		btnTak.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				int nru,nrd;
				String ulica,miasto,imie,nazwisko,pesel,login,haslo;
				
				ulica = ulicaT.getText();
				miasto = miastoT.getText();
				imie = imieT.getText();
				nazwisko = nazwiskoT.getText();
				pesel = peselT.getText();
				login = loginT.getText();
				haslo = hasloT.getText();
				nru = Integer.parseInt(nrulicyT.getText());
				nrd = Integer.parseInt(nrulicyT.getText());
				Adres nAdres = new Adres(ulica,nru,nrd,miasto);
				Pacjent nowy = new Pacjent(imie,nazwisko,pesel,nAdres);
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
					java.sql.Statement dodaj = con.createStatement();
					dodaj.executeUpdate("INSERT INTO pacjent " + "VALUES ('"+nowy.Imi�()+"', '"+nowy.Nazwisko()+
							"', '"+nowy.PESEL()+"', '"+nowy.Adres.Ulica()+"', '"+nowy.Adres.NrUlicy()+
							"', '"+nowy.Adres.NrDomu()+"','"+nowy.Adres.Miejscowo��()+"')");
					dodaj.executeUpdate("INSERT INTO pass " + "VALUES ('"+login+"', '"+haslo+"','"+nowy.PESEL()+"')");
					
					PreparedStatement statement = con.prepareStatement("select * from pacjent");		
					ResultSet result = statement.executeQuery();
					
					while(result.next())
					{
						System.out.println(result.getString(1)+ " " + result.getString(2)+ " " + result.getString(3)+
								" " + result.getString(4)+ " " + result.getString(5)+ " " + result.getString(6)+
								" " + result.getString(7));
					}
				}
				catch(Exception exc)
				{			
				}
				
				
			}
		});
		btnTak.setBounds(203, 204, 75, 25);
		btnTak.setText("Zarejestruj");
		
		Button btnNie = new Button(shlRejestracja, SWT.NONE);
		btnNie.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				 shlRejestracja.dispose();
			}
		});
		btnNie.setBounds(308, 204, 75, 25);
		btnNie.setText("Zrezygnuj");
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
