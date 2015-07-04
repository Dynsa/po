package Main;
import  lekarz.Lekarz;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class lekarze extends Shell {
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			lekarze shell = new lekarze(display);
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
	public lekarze(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Button btnWizytaL1 = new Button(this, SWT.NONE);
		btnWizytaL1.setBounds(297, 113, 111, 55);
		btnWizytaL1.setText("Um\u00F3w Wizyt\u0119");
		
		Button btnTerminyL1 = new Button(this, SWT.NONE);
		btnTerminyL1.setBounds(419, 113, 103, 55);
		btnTerminyL1.setText("Sprawd\u017A Terminy");
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setBounds(297, 174, 111, 55);
		btnNewButton.setText("Um\u00F3w Wizyt\u0119");
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.setBounds(419, 174, 103, 55);
		btnNewButton_1.setText("Sprawd\u017A Terminy");
		
		Button btnNewButton_2 = new Button(this, SWT.NONE);
		btnNewButton_2.setBounds(297, 235, 111, 55);
		btnNewButton_2.setText("Um\u00F3w Wizyt\u0119");
		
		Button btnNewButton_3 = new Button(this, SWT.NONE);
		btnNewButton_3.setBounds(419, 235, 103, 55);
		btnNewButton_3.setText("Sprawd\u017A Terminy");
		
		Button btnNewButton_4 = new Button(this, SWT.NONE);
		btnNewButton_4.setBounds(297, 296, 111, 55);
		btnNewButton_4.setText("Um\u00F3w Wizyt\u0119");
		
		Button btnNewButton_5 = new Button(this, SWT.NONE);
		btnNewButton_5.setBounds(419, 296, 103, 55);
		btnNewButton_5.setText("Sprawd\u017A Terminy");
		
		Button btnNewButton_6 = new Button(this, SWT.NONE);
		btnNewButton_6.setBounds(297, 357, 111, 55);
		btnNewButton_6.setText("Um\u00F3w Wizyt\u0119");
		
		Button btnNewButton_7 = new Button(this, SWT.NONE);
		btnNewButton_7.setBounds(419, 357, 103, 55);
		btnNewButton_7.setText("Sprawd\u017A Terminy");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 81, 525, 344);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.addListener(SWT.MeasureItem, new Listener() {
			@Override
			public void handleEvent(Event event) {
				TableItem item = (TableItem)event.item;
				String text = item.getText(event.index);
				Point size = event.gc.textExtent(text);
				event.width = size.x + 2 * 3;
				event.height = Math.max(event.height, size.y + 3);
			}
		});
		table.addListener(SWT.EraseItem, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.detail &= ~SWT.FOREGROUND;
			}
		});
		table.addListener(SWT.PaintItem, new Listener() {
			@Override
			public void handleEvent(Event event) {
				TableItem item = (TableItem)event.item;
				String text = item.getText(event.index);
				/* center column 1 vertically */
				int yOffset = 0;
				if (event.index == 1) {
					Point size = event.gc.textExtent(text);
					yOffset = Math.max(0, (event.height - size.y) / 2);
				}
				event.gc.drawText(text, event.x + 3, event.y + yOffset, true);
			}
		});
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(275);
		tblclmnNewColumn.setText("Lekarz");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(243);
		tblclmnNewColumn_1.setText("Rezerwacje");

		Lekarz a = new Lekarz();
		String tekst;
		TableItem lekarz1ti = new TableItem(table, SWT.NONE);
		try {
			tekst=a.wyswietlLekarza(123);
			lekarz1ti.setText(tekst);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TableItem lekarz2ti = new TableItem(table, SWT.NONE);
		try {
			tekst=a.wyswietlLekarza(2);
			lekarz2ti.setText(tekst);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TableItem lekarz3ti = new TableItem(table, SWT.NONE);
		try {
			tekst=a.wyswietlLekarza(3);
			lekarz3ti.setText(tekst);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TableItem lekarz4ti = new TableItem(table, SWT.NONE);
		try {
			tekst=a.wyswietlLekarza(4);
			lekarz4ti.setText(tekst);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TableItem lekarz5ti = new TableItem(table, SWT.NONE);
		try {
			tekst=a.wyswietlLekarza(5);
			lekarz5ti.setText(tekst);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Spis Lekarzy");
		setSize(690, 473);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
