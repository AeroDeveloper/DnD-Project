/**
 * 
 */
package ninja.aerodeveloper.dndroll.views;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.text.DefaultCaret;


import net.miginfocom.swing.MigLayout;
import ninja.aerodeveloper.dndroll.dice.RollHelper;
import java.awt.Toolkit;
import java.awt.Dimension;

/**
 * @author Benjamin Law
 *
 */
public class ApplicationWindow {



	private JFrame frmDungeonsAndDragons;
	private final JRadioButton rdbtnD4 = new JRadioButton("D4");
	private final JRadioButton rdbtnD6 = new JRadioButton("D6");
	private final JRadioButton rdbtnD8 = new JRadioButton("D8");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JRadioButton rdbtnD10 = new JRadioButton("D10");
	private final JRadioButton rdbtnD12 = new JRadioButton("D12");
	private final JRadioButton rdbtnD20 = new JRadioButton("D20");
	private final JRadioButton rdbtnDp = new JRadioButton("DP");
	private final JPanel panel = new JPanel();
	private final JButton btnRoll = new JButton("Roll!");
	private final JTextArea textResultOutputArea = new JTextArea();
	private final JScrollPane scrollPane = new JScrollPane();
	
	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();
//		scrollPane
	}
	
	/**
	 * Appends the string on a new line in the textResultOutputArea TextArea
	 * @param s the string to be added on a new line
	 */
	public void append(String s) {
		this.textResultOutputArea.append(s);
	}
	
	/**
	 * @return the buttonGroup as ButtonGroup
	 */
	public ButtonGroup getButtonGroup() {
		return this.buttonGroup;
	}
	
	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frmDungeonsAndDragons;
	}
	
	/**
	 * @return the textResultOutputArea as JTextArea
	 */
	public JTextArea getTextResultOutputArea() {
		return this.textResultOutputArea;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frmDungeonsAndDragons = new JFrame();
		frmDungeonsAndDragons.setMinimumSize(new Dimension(450, 350));
		frmDungeonsAndDragons.setTitle("Dungeons and Dragons Utility - Dice Roll");
		frmDungeonsAndDragons.setIconImage(Toolkit.getDefaultToolkit().getImage(ApplicationWindow.class.getResource("/icon.png")));
		this.frmDungeonsAndDragons.setBounds(100, 100, 450, 300);
		this.frmDungeonsAndDragons.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.frmDungeonsAndDragons.getContentPane().setLayout(new MigLayout("", "[434px,grow]", "[top][][grow,fill]"));
		{
			this.frmDungeonsAndDragons.getContentPane().add(this.panel, "cell 0 0,growx,aligny top");
		}
		this.panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			this.buttonGroup.add(this.rdbtnD20);
		}
		{
			this.buttonGroup.add(this.rdbtnD12);
		}
		{
			this.buttonGroup.add(this.rdbtnD10);
		}
		{
			this.buttonGroup.add(this.rdbtnD8);
		}
		{
			this.buttonGroup.add(this.rdbtnD6);
		}
		{
			this.buttonGroup.add(this.rdbtnD4);
		}
		this.panel.add(this.rdbtnD4);
		this.panel.add(this.rdbtnD6);
		this.panel.add(this.rdbtnD8);
		this.panel.add(this.rdbtnD10);
		this.panel.add(this.rdbtnD12);
		this.rdbtnD20.setSelected(true);
		this.panel.add(this.rdbtnD20);
		this.panel.add(this.rdbtnDp);
		{
			this.buttonGroup.add(this.rdbtnDp);
		}
		this.btnRoll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RollHelper rollHelper = new RollHelper();
				int result = -1;
				String name = "ERROR";
				JTextArea jTextArea = getTextResultOutputArea();
				Enumeration<AbstractButton> buttongroup = getButtonGroup().getElements();
				while (buttongroup.hasMoreElements()) {
					AbstractButton button = buttongroup.nextElement();
					if (button.isSelected()) {
						name = button.getText();
						result = rollHelper.roll(name);
					}
				}
				if (result == -1) jTextArea.append("Error on roll\n");
				else jTextArea.append("Rolled a " + name + ": " + result + "\n");
			}
		});
		
		this.frmDungeonsAndDragons.getContentPane().add(this.btnRoll, "cell 0 1,alignx center");
		DefaultCaret caret = (DefaultCaret) this.textResultOutputArea.getCaret(); 
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);    
		this.frmDungeonsAndDragons.getContentPane().add(this.scrollPane, "cell 0 2,grow");
		this.scrollPane.setViewportView(this.textResultOutputArea);
	}
}
