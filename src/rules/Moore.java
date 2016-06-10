package rules;
import model.Strip;

public class Moore implements HeadCounter {
	
	public Moore()
	{
		
	}
	@Override
	public int countHeads(Strip strip, int x, int y)
	{
		
		int surr=0;
		for(int i=-1;i<2;i++)
        {
            for(int j=-1;j<2;j++)
            {
                if(i==0 && j==0)
                {
                    continue;
                }
                else
                {
                    if((x+j)>=0 || (x+j)<strip.getSize() || (y+i)>=0 || (y+i)<strip.getSize())
                    {
                        if(strip.getState(x+j, y+i) == 1)
                            surr++;
                    }
                }
            }
        }
		return surr;
	}

}
