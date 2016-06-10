package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import model.Strip;

public class MyPanel extends JPanel {
	
	private Graphics2D g2d;
	private int width;
	private int height;
	private Strip s;
	
	public MyPanel() {
		width = 500;
		height = 500;
		setPreferredSize(new Dimension(width, height));
		s = new Strip(10);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;

		drawGrid(s);		
	}
	public void updateStrip(Strip s)
	{
		this.s = s; 
		super.repaint();
	}
	public void showGrid(Strip strip)
	{
		drawGrid(s);
	}
	public void updateDimensions(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	private void drawGrid(Strip strip)
	{
		
		int w = width/strip.getSize();
		int h = height/strip.getSize();
		for(int i=0;i<strip.getSize();i++)
		{
			for(int j=0;j<strip.getSize();j++)
			{
				drawCell(j*w,i*h,estimateColor(strip.getState(j, i)),w,h);
			}
		}
	}
	private Color estimateColor(int i)
	{
		switch(i)
		{
		case 0: return Color.BLACK;
		case 1: return Color.BLUE;
		case 2: return Color.RED;
		case 3: return Color.YELLOW;
		default: return Color.BLACK;
		}
	}
	
	private void drawCell(int x, int y, Color color, int width, int height)
	{
		
		g2d.setColor(color);
		g2d.fillRect(x,y,width,height);
		
		g2d.setColor(Color.GRAY);
		g2d.drawRect(x, y, width, height);
		
		g2d.setColor(Color.BLACK);
	}
}