package ninja.aerodeveloper.dndroll.application;

import java.awt.EventQueue;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ninja.aerodeveloper.dndroll.views.ApplicationWindow;

/** TODO
 * @author Benjamin Law
 * 
 */
public class DungeonsAndDragonsUtilities {
	private static final Logger logger = LogManager.getLogger("GLOBAL");	

	/**
	 * Launch the application.
	 * @param args 
	 * @return 
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					logger.info("Starting GUI");
					ApplicationWindow window = new ApplicationWindow();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					logger.catching(Level.ERROR, e);
				}
			}
		});
	}

}
