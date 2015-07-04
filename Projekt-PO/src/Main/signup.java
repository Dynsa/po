package Main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import pacjent1.Adres;
import pacjent1.Pacjent;

public class signup extends Shell {
	private Text imieT;
	private Text nazwiskoT;
	private Text peselT;
	private Text ulicaT;
	private Text nrdomuT;
	private Text nrmieszkaniaT;
	private Text miejscowoscT;
	private Text loginT;
	private Text hasloT;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			signup shell = new signup(display);
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
	public signup(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label lblDaneOsobowe = new Label(this, SWT.NONE);
		lblDaneOsobowe.setBounds(50, 10, 95, 15);
		lblDaneOsobowe.setText("Dane Osobowe");
		
		Label lblImi = new Label(this, SWT.NONE);
		lblImi.setBounds(10, 31, 55, 15);
		lblImi.setText("IMI\u0118");
		
		imieT = new Text(this, SWT.BORDER);
		imieT.setBounds(10, 50, 135, 21);
		
		Label lblNazwisko = new Label(this, SWT.NONE);
		lblNazwisko.setBounds(10, 77, 76, 15);
		lblNazwisko.setText("NAZWISKO");
		
		nazwiskoT = new Text(this, SWT.BORDER);
		nazwiskoT.setBounds(10, 98, 135, 21);
		
		Label lblPesel = new Label(this, SWT.NONE);
		lblPesel.setBounds(10, 126, 55, 15);
		lblPesel.setText("PESEL");
		
		peselT = new Text(this, SWT.BORDER);
		peselT.setBounds(10, 147, 135, 21);
		
		Label lblUlica = new Label(this, SWT.NONE);
		lblUlica.setBounds(10, 174, 55, 15);
		lblUlica.setText("ULICA");
		
		ulicaT = new Text(this, SWT.BORDER);
		ulicaT.setBounds(10, 195, 135, 21);
		
		Label lblNrDomu = new Label(this, SWT.NONE);
		lblNrDomu.setBounds(10, 222, 55, 15);
		lblNrDomu.setText("NR DOMU");
		
		nrdomuT = new Text(this, SWT.BORDER);
		nrdomuT.setBounds(10, 243, 23, 21);
		
		Label lblNrMieszkania = new Label(this, SWT.NONE);
		lblNrMieszkania.setBounds(82, 222, 95, 15);
		lblNrMieszkania.setText("NR MIESZKANIA");
		
		nrmieszkaniaT = new Text(this, SWT.BORDER);
		nrmieszkaniaT.setBounds(92, 243, 23, 21);
		
		Label label = new Label(this, SWT.NONE);
		label.setBounds(61, 243, 14, 15);
		label.setText("/");
		
		Label lblMiejscowo = new Label(this, SWT.NONE);
		lblMiejscowo.setBounds(10, 270, 95, 15);
		lblMiejscowo.setText("MIEJSCOWO\u015A\u0106");
		
		miejscowoscT = new Text(this, SWT.BORDER);
		miejscowoscT.setBounds(10, 291, 135, 21);
		
		Label lblDaneLogowania = new Label(this, SWT.NONE);
		lblDaneLogowania.setBounds(265, 10, 106, 15);
		lblDaneLogowania.setText("Dane Logowania");
		
		Label lblLogin = new Label(this, SWT.NONE);
		lblLogin.setBounds(219, 31, 55, 15);
		lblLogin.setText("LOGIN");
		
		loginT = new Text(this, SWT.BORDER);
		loginT.setBounds(219, 50, 135, 21);
		
		Label lblHaso = new Label(this, SWT.NONE);
		lblHaso.setBounds(219, 77, 55, 15);
		lblHaso.setText("HAS\u0141O");
		
		hasloT = new Text(this, SWT.BORDER);
		hasloT.setBounds(219, 98, 135, 21);
		
		Button btnZarejestruj = new Button(this, SWT.NONE);
		btnZarejestruj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				int nru,nrd;
				String ulica,miasto,imie,nazwisko,pesel,login,haslo;
				
				ulica = ulicaT.getText();
				miasto = miejscowoscT.getText();
				imie = imieT.getText();
				nazwisko = nazwiskoT.getText();
				pesel = peselT.getText();
				login = loginT.getText();
				haslo = hasloT.getText();
				nru = Integer.parseInt(nrdomuT.getText());
				nrd = Integer.parseInt(nrmieszkaniaT.getText());
				Adres nAdres = new Adres(ulica,nru,nrd,miasto);
				Pacjent nowy = new Pacjent(imie,nazwisko,pesel,nAdres);
				
				nowy.rejestracjaPacjenta(login, haslo);
						
			}
		});
		btnZarejestruj.setBounds(219, 143, 135, 41);
		btnZarejestruj.setText("Zarejestruj");
		
		Button btnZrezygnuj = new Button(this, SWT.NONE);
		btnZrezygnuj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				signup.this.close();
			}
		});
		btnZrezygnuj.setBounds(219, 195, 135, 41);
		btnZrezygnuj.setText("Zrezygnuj");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 462);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
