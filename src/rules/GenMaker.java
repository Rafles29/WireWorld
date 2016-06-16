package rules;
import model.Strip;
public class GenMaker 
{
	
	public GenMaker()
	{
		
	}

	public Strip doGen(Strip strip)
	{
		Strip tempStrip = strip.duplicateStrip();
		Tribunal judge = new SimpleRules();
		for(int i=0;i<strip.getSize();i++)
		{
			for(int j=0;j<strip.getSize();j++)
			{
				judge.determinate(strip,tempStrip,j,i);
			}
		}
		return tempStrip;
	}
}
