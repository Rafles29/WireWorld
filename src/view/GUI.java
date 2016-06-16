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
import javax.swing.JSlider;
import javax.swing.JTextField;

public class GUI 
{

	private JFrame frame;
	private MyPanel panel;
	private JPanel menu;
	private JFormattedTextField frmtdtxtfldStarttxt;
	private JButton btnLoadFile;
	private JFormattedTextField frmtdtxtfldEndtxt;
	private JButton btnSaveFile;
	private JLabel lblControls;
	private JLabel lblSaveAndLoad;
	private JButton startButton;
	private JButton endButton;
	private JSlider slider;
	private JLabel lblTempo;
	private JTextField tempoValueTextField;

	/**
	 * Create the application.
	 */
	public GUI(Strip strip) 
	{
		frame = new JFrame("WireWorld");
		panel = new MyPanel();
		menu = new JPanel();
		lblSaveAndLoad = new JLabel("Game File");
		btnLoadFile = new JButton("Load File");
		frmtdtxtfldStarttxt = new JFormattedTextField();
		frmtdtxtfldEndtxt = new JFormattedTextField();
		btnSaveFile = new JButton("Save File");
		lblControls = new JLabel("Controls");
		startButton = new JButton("Start");
		endButton = new JButton("Stop");
		slider = new JSlider(JSlider.VERTICAL, 0, 2000, 1000);
		lblTempo = new JLabel("Tempo");
		tempoValueTextField = new JTextField();
		panel.updateStrip(strip);
		
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					initialize();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		
		frame.setBounds(100, 100, 717, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.getContentPane().add(panel, BorderLayout.WEST);
		
		
		frame.getContentPane().add(menu, BorderLayout.EAST);
		menu.setLayout(new MigLayout("", "[120px,grow][55px]", "[][23px][][][][][][][][][][][]"));
		
		slider.setMajorTickSpacing(500);
		slider.setMinorTickSpacing(100);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		menu.add(slider, "cell 0 11");
		
		menu.add(lblSaveAndLoad, "cell 0 0 2 1");
		
		frmtdtxtfldStarttxt.setText("Start.txt");
		menu.add(frmtdtxtfldStarttxt, "cell 0 1 2 1,growx");

		menu.add(btnLoadFile, "cell 0 2 2 1");
		
		
		frmtdtxtfldEndtxt.setText("End.txt");
		menu.add(frmtdtxtfldEndtxt, "cell 0 4 2 1,growx");
		
		
		menu.add(btnSaveFile, "cell 0 5");
		
		
		menu.add(lblControls, "cell 0 8 2 1");
		
		
		menu.add(startButton, "cell 0 9,alignx left,aligny top");
		
		
		menu.add(endButton, "cell 1 9,alignx left,aligny top");
		
		
		menu.add(lblTempo, "cell 0 10 2 1");
	
		
		tempoValueTextField.setColumns(10);
		tempoValueTextField.setEditable(false);
		tempoValueTextField.setText("1000");
		menu.add(tempoValueTextField, "cell 0 12,growx");
		
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
		return startButton;
	}
	public JButton getStop()
	{
		return endButton;
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
	public JSlider getSlider()
	{
		return slider;
	}
	public JTextField getTempoValueTextField()
	{
		return tempoValueTextField;
	}
}
