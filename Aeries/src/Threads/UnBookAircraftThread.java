package Threads;
import java.util.ArrayList;

import businesslogic.*;
public class UnBookAircraftThread extends Thread{
	Aircraft aircraft;
	public UnBookAircraftThread(Aircraft aircraft) {
		this.aircraft=aircraft;
	}
	@Override
	public void run()
	{
		ArrayList<Seat> allSeats = aircraft.getSeats();
		for(Seat seat : allSeats)
		{
			seat.unBookSeat();
		}
	}

}
