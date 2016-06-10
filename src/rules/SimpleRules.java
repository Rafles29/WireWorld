package rules;

import model.Strip;

public class SimpleRules implements Tribunal {
	
	public SimpleRules()
	{
		
	}
	@Override
	public void determinate (Strip strip1, Strip strip2, int x, int y)
	{
		strip2.changeField(x,y,estimate(strip1, x, y));
	}

	public int estimate(Strip strip1, int x, int y) 
	{
			HeadCounter hc = new Moore();
			switch(strip1.getState(x, y))
			{
				case 0: return 0;
				case 1: return 2;
				case 2: return 3;
				case 3: {
						if(hc.countHeads(strip1, x, y) == 1 || hc.countHeads(strip1, x, y) == 2)
						{
							System.out.println("siema");
							return 1;					
						}
						else return 3;
					}
				default: return 0;
			}
	}
}
