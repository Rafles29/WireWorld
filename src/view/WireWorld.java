package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import model.Strip;
import net.miginfocom.swing.MigLayout;

public class WireWorld {

	private JFrame frame;
	MyPanel panel;
	JPanel panel_1;
	JFormattedTextField frmtdtxtfldStarttxt;
	JButton btnLoadFile;
	JFormattedTextField frmtdtxtfldEndtxt;
	JButton btnSaveFile;
	JLabel lblControls;
	JLabel lblSaveAndLoad;
	JButton btnNewButton_1;
	JButton btnNewButton;
	private JToggleButton tglbtnOnoff;

	/**
	 * Create the application.
	 */
	public WireWorld(Strip strip) {
		frame = new JFrame("WireWorld");
		panel = new MyPanel();
		panel_1 = new JPanel();
		lblSaveAndLoad = new JLabel("Game File");
		btnLoadFile = new JButton("Load File");
		frmtdtxtfldStarttxt = new JFormattedTextField();
		frmtdtxtfldEndtxt = new JFormattedTextField();
		btnSaveFile = new JButton("Save File");
		lblControls = new JLabel("Controls");
		btnNewButton_1 = new JButton("Start");
		btnNewButton = new JButton("Stop");
		panel.updateStrip(strip);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame.setBounds(100, 100, 717, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.getContentPane().add(panel, BorderLayout.WEST);
		
		
		frame.getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new MigLayout("", "[120px,grow][55px]", "[][23px][][][][][][][][][][]"));
		
		
		panel_1.add(lblSaveAndLoad, "cell 0 0 2 1");
		
		frmtdtxtfldStarttxt.setText("Start.txt");
		panel_1.add(frmtdtxtfldStarttxt, "cell 0 1 2 1,growx");
		
		
		//btnLoadFile.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent e) {
				
		//	}
		//});
		panel_1.add(btnLoadFile, "cell 0 2 2 1");
		
		
		frmtdtxtfldEndtxt.setText("End.txt");
		panel_1.add(frmtdtxtfldEndtxt, "cell 0 4 2 1,growx");
		
		
		panel_1.add(btnSaveFile, "cell 0 5");
		
		
		panel_1.add(lblControls, "cell 0 8 2 1");
		
		
		panel_1.add(btnNewButton_1, "cell 0 9,alignx left,aligny top");
		
		
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
	public MyPanel getPanel() 
	{
		return panel;
	}
}
