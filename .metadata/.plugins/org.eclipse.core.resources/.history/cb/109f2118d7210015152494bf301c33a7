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


public class okno {

	protected Shell shell;
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

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args){
		
		
		
		try {
			okno window = new okno();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		imieT = new Text(shell, SWT.BORDER);
		imieT.setBounds(26, 23, 76, 21);
		
		nazwiskoT = new Text(shell, SWT.BORDER);
		nazwiskoT.setBounds(26, 70, 76, 21);
		
		peselT = new Text(shell, SWT.BORDER);
		peselT.setBounds(26, 118, 101, 21);
		
		ulicaT = new Text(shell, SWT.BORDER);
		ulicaT.setBounds(26, 167, 76, 21);
		
		nrulicyT = new Text(shell, SWT.BORDER);
		nrulicyT.setBounds(26, 212, 76, 21);
			
		nrdomuT = new Text(shell, SWT.BORDER);
		nrdomuT.setBounds(128, 212, 76, 21);
				
		miastoT = new Text(shell, SWT.BORDER);
		miastoT.setBounds(252, 212, 109, 21);
		
		lblImie = new Label(shell, SWT.NONE);
		lblImie.setBounds(26, 2, 55, 15);
		lblImie.setText("IMIE");
		
		lblNazwisko = new Label(shell, SWT.NONE);
		lblNazwisko.setBounds(26, 49, 65, 15);
		lblNazwisko.setText("NAZWISKO");
		
		lblPesel = new Label(shell, SWT.NONE);
		lblPesel.setBounds(26, 97, 55, 15);
		lblPesel.setText("PESEL");
		
		lblUlica = new Label(shell, SWT.NONE);
		lblUlica.setBounds(26, 146, 55, 15);
		lblUlica.setText("ULICA");
		
		lblNrUlicy = new Label(shell, SWT.NONE);
		lblNrUlicy.setBounds(26, 191, 55, 15);
		lblNrUlicy.setText("NR ULICY");
	
		lblNrDomu = new Label(shell, SWT.NONE);
		lblNrDomu.setBounds(129, 191, 55, 15);
		lblNrDomu.setText("NR DOMU");
		
		lblMiasto = new Label(shell, SWT.NONE);
		lblMiasto.setBounds(252, 191, 55, 15);
		lblMiasto.setText("MIASTO");
		
		Button btnTak = new Button(shell, SWT.NONE);
		btnTak.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				int nru,nrd;
				String ulica,miasto,imie,nazwisko,pesel;
				
				ulica = ulicaT.getText();
				miasto = miastoT.getText();
				imie = imieT.getText();
				nazwisko = nazwiskoT.getText();
				pesel = peselT.getText();
				nru = Integer.parseInt(nrulicyT.getText());
				nrd = Integer.parseInt(nrulicyT.getText());
				Adres nAdres = new Adres(ulica,nru,nrd,miasto);
				Pacjent nowy = new Pacjent(imie,nazwisko,pesel,nAdres);
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
					java.sql.Statement dodaj = con.createStatement();
					dodaj.executeUpdate("INSERT INTO pacjent " + "VALUES ('"+nowy.Imiê()+"', '"+nowy.Nazwisko()+"', '"+nowy.PESEL()+"', '"+nowy.Adres.Ulica()+"', '"+nowy.Adres.NrUlicy()+"', '"+nowy.Adres.NrDomu()+"','"+nowy.Adres.Miejscowoœæ()+"')");
					
					PreparedStatement statement = con.prepareStatement("select * from pacjent");		
					ResultSet result = statement.executeQuery();
					
					while(result.next())
					{
						System.out.println(result.getString(1)+ " " + result.getString(2)+ " " + result.getString(3)+ " " + result.getString(4)+ " " + result.getString(5)+ " " + result.getString(6)+ " " + result.getString(7));
					}
				}
				catch(Exception exc)
				{			
				}
				
				
			}
		});
		btnTak.setBounds(252, 19, 75, 25);
		btnTak.setText("TAK");
		
		Button btnNie = new Button(shell, SWT.NONE);
		btnNie.setBounds(252, 70, 75, 25);
		btnNie.setText("NIE");

	}
}
