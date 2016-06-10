package model;

public class Strip implements Cloneable{
	private Field[][] grid;
	private int size;
	
	public Strip(int size)
	{
		grid = new Field[size][size];
		this.size = size;
		clearStrip();
	}
	public Strip(int size, Field[][] grid)
	{
		this.grid = grid;
		this.size = size;
	}
	public void clearStrip()
	
	{
		clearGrid(this.grid,size);
	}
	private void clearGrid(Field[][] randomGrid, int hisSize)
	{
		for(int i=0;i<hisSize;i++)
		{
			for(int j=0;j<hisSize;j++)
			{
				grid[i][j] = new Field(0);
			}
		}
	}
	public void changeField(int x, int y, int state)
	{
		grid[y][x].changeState(state);
	}
	public int getState(int x, int y)
	{
		return grid[y][x].getState();
	}
	public Field[][] duplicateGrid()
	{
		Field[][] gridDuplicate = new Field[size][size];
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				gridDuplicate[i][j] = new Field(this.getState(j, i));
			}
		}
		return gridDuplicate;
	}
	public Strip duplicateStrip()
	{
		Field[][] test = this.duplicateGrid();
		Strip stripDuplicate = new Strip(size,test);
		return stripDuplicate;
	}
	public int getSize()
	{
		return this.size;
	}
	public void setSize(int size)
	{
		this.size = size;
	}
	public void show()
	{
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				System.out.print(this.getState(j, i));
				System.out.print(" ");
			}
			System.out.print("\n");				
		}
	}

}
