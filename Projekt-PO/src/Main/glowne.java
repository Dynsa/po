package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import pacjent1.Adres;
import pacjent1.Pacjent;

public class glowne {
	
	private Text loginT;
	private Text hasloT;

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
	    Display display = new Display();
	    
	    final lekarze lek = new lekarze(display);
	    //lek.open();      

		try {
			glowne window = new glowne();
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
		
		Label lblLogin = new Label(shell, SWT.NONE);
		lblLogin.setBounds(93, 85, 55, 15);
		lblLogin.setText("Login");
		
		Label lblHaslo = new Label(shell, SWT.NONE);
		lblHaslo.setBounds(93, 123, 55, 15);
		lblHaslo.setText("Haslo");
		
		loginT = new Text(shell, SWT.BORDER);
		loginT.setBounds(150, 80, 126, 21);
		
		hasloT = new Text(shell, SWT.BORDER);
		hasloT.setBounds(150, 120, 126, 21);
		
		Button login_btn = new Button(shell, SWT.NONE);
		Button register_btn = new Button(shell, SWT.NONE);
		
		login_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String login,haslo;
				
				login = loginT.getText();
				haslo = hasloT.getText();
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
					java.sql.Statement pick_user = con.createStatement();	
					ResultSet result = pick_user.executeQuery("select * from pass where login = '"+ login.toString()+"' and haslo = '" + haslo.toString() + "' limit 1");
					if( result.next()){

						String active_login = result.getString(1);

						
						loginT.setVisible(false);
						hasloT.setVisible(false);
						lblHaslo.setVisible(false);
						lblLogin.setVisible(false);
						login_btn.setVisible(false);
						register_btn.setVisible(false);
						
						Label signed_in = new Label(shell, SWT.NONE);
						signed_in.setBounds(93, 123, 355, 15);
						signed_in.setText("jestes zalogowany jako "+ active_login);
						
						Display display = Display.getDefault();
					    final lekarze lek = new lekarze(display);
					    lek.open();
						
					}
					else{
						System.out.println("Spróbuj jeszcze raz");
					}
				}
				catch(Exception exc)
				{		
					System.out.println(exc);
				}
				
				
			}
		});
		
		login_btn.setBounds(200, 154, 75, 25);
		login_btn.setText("Zaloguj");
		
		register_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Display display = Display.getDefault();
				final signup rej = new signup(display);
			    rej.open();
			}
		});
		register_btn.setBounds(200, 194, 75, 25);
		register_btn.setText("Rejestracja");
		

	}

}

