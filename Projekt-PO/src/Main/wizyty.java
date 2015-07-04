package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class wizyty extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			wizyty shell = new wizyty(display);
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
	public wizyty(Display display) {
		super(display, SWT.SHELL_TRIM);
		Button btnCheckButton = new Button(this, SWT.CHECK);
		btnCheckButton.setBounds(169, 0, 85, 34);
		btnCheckButton.setText("8:00-9:30");
		
		Button btnCheckButton_1 = new Button(this, SWT.CHECK);
		btnCheckButton_1.setBounds(169, 29, 85, 34);
		btnCheckButton_1.setText("9:30-11:00");
		
		Button btnCheckButton_2 = new Button(this, SWT.CHECK);
		btnCheckButton_2.setBounds(169, 57, 85, 34);
		btnCheckButton_2.setText("11:00-12:30");
		
		Button btnCheckButton_3 = new Button(this, SWT.CHECK);
		btnCheckButton_3.setBounds(169, 87, 85, 34);
		btnCheckButton_3.setText("12:30-14:00");
		
		Button btnCheckButton_4 = new Button(this, SWT.CHECK);
		btnCheckButton_4.setBounds(169, 117, 85, 34);
		btnCheckButton_4.setText("14:00-15:30");

		final DateTime calendar = new DateTime (this, SWT.CALENDAR | SWT.BORDER);
		calendar.setBounds(0, 0, 163, 151);
		calendar.addSelectionListener (new SelectionAdapter () {
			@Override
			public void widgetSelected (SelectionEvent e) {
				//System.out.println ("Calendar date selected (MM/DD/YYYY) = " + (calendar.getMonth () + 1) + "/" + calendar.getDay () + "/" + calendar.getYear ());
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");

					
					PreparedStatement statement = con.prepareStatement("select dostepnosc from wizyty1 where dzien="+calendar.getDay()+", miesiac="+calendar.getMonth());		
					ResultSet result = statement.executeQuery();
					
					while(result.next())
					{
						System.out.println(result.getString(1));
					}
				}
				catch(Exception exc)
				{			
				}
				if(calendar.getDay()==5){
					btnCheckButton.setEnabled(false);
					btnCheckButton_1.setEnabled(false);
					btnCheckButton_2.setEnabled(false);
				}
				else
				{
					btnCheckButton.setEnabled(true);
					btnCheckButton_1.setEnabled(true);
					btnCheckButton_2.setEnabled(true);
					btnCheckButton_3.setEnabled(true);
					btnCheckButton_4.setEnabled(true);
				}
			}

		});

		Button ok = new Button (this, SWT.PUSH);
		ok.setBounds(10, 157, 153, 34);
		GridData gd_ok = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_ok.widthHint = 162;
		ok.setLayoutData(gd_ok);
		ok.setText ("Wybierz");
		ok.addSelectionListener (new SelectionAdapter () {
			@Override
			public void widgetSelected (SelectionEvent e) {
				System.out.println ("Calendar date selected (MM/DD/YYYY) = " + (calendar.getMonth () + 1) + "/" + calendar.getDay () + "/" + calendar.getYear ());
				
				wizyty.this.close ();
			}

		});
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(279, 232);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
