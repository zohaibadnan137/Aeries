package businesslogic;

import java.util.ArrayList;

public class Fleet {
	ArrayList<Aircraft> aircrafts;
	
	public Fleet()
	{
		aircrafts=null;
	}
	public void addAircraft(Aircraft aircraft)
	{
		if(this.aircrafts == null)
		{
			this.aircrafts = new ArrayList<Aircraft>();
		}
		this.aircrafts.add(aircraft);
	}
}
