package model;

public class Field {
	
	private int state;
	
	public Field ()
	{
		this.state = 0;
	}
	
	public Field (int state)
	{
		this.state = state;
	}
	
	public void changeState(int state)
	{
		this.state = state;
	}
	public int getState()
	{
		return this.state;
	}
}
