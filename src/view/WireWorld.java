package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class WireWorld {

	private JFrame frame;
	MyPanel panel;
	JPanel panel_1;
	JFormattedTextField frmtdtxtfldStarttxt;
	JButton btnLoadFile;
	JFormattedTextField frmtdtxtfldEndtxt;
	JButton btnSaveFile;
	JLabel lblControls;
	JButton btnNewButton_1;
	JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WireWorld window = new WireWorld();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WireWorld() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 717, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new MyPanel();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new MigLayout("", "[120px,grow][55px]", "[][23px][][][][][][][][]"));
		
		JLabel lblSaveAndLoad = new JLabel("Game File");
		panel_1.add(lblSaveAndLoad, "cell 0 0 2 1");
		
		frmtdtxtfldStarttxt = new JFormattedTextField();
		frmtdtxtfldStarttxt.setText("Start.txt");
		panel_1.add(frmtdtxtfldStarttxt, "cell 0 1 2 1,growx");
		
		btnLoadFile = new JButton("Load File");
		btnLoadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel_1.add(btnLoadFile, "cell 0 2 2 1");
		
		frmtdtxtfldEndtxt = new JFormattedTextField();
		frmtdtxtfldEndtxt.setText("End.txt");
		panel_1.add(frmtdtxtfldEndtxt, "cell 0 4 2 1,growx");
		
		btnSaveFile = new JButton("Save File");
		panel_1.add(btnSaveFile, "cell 0 5");
		
		lblControls = new JLabel("Controls");
		panel_1.add(lblControls, "cell 0 8 2 1");
		
		btnNewButton_1 = new JButton("Start");
		panel_1.add(btnNewButton_1, "cell 0 9,alignx left,aligny top");
		
		btnNewButton = new JButton("Stop");
		panel_1.add(btnNewButton, "cell 1 9,alignx left,aligny top");
	}
	public JButton getLoad()
	{
		return btnLoadFile;
	}
	public JButton getSave()
	{
		return btnSaveFile;
	}
	public JButton getStart()
	{
		return btnNewButton_1;
	}
	public JButton getStop()
	{
		return btnNewButton;
	}
	public String getLoadDestination()
	{
		return frmtdtxtfldStarttxt.getText();
	}
	public String getSaveDestination()
	{
		return frmtdtxtfldEndtxt.getText();
	}

}
