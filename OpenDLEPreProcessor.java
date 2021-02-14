/* This file will contain the simulation listener, rocket discretization, mass calcs, and aerodynamic calcs
 * This file will determine the burntime of the selected motor then wait until that burn time is reached to 
 * pull the necessary flight data and flight conditions in order to compute everything
*/

package net.sf.openrocket.example;

import net.sf.openrocket.simulation.SimulationStatus;
import net.sf.openrocket.simulation.exception.SimulationException;
import net.sf.openrocket.simulation.listeners.AbstractSimulationListener;

/**
 * The simulation listener that is attached to the simulation.
 * It is instantiated when the simulation run is started and the
 * methods are called at each step of the simulation.
 */
public class OpenDLESimulationListener extends AbstractSimulationListener {
	
	private double multiplier;
	
	public OpenDLESimulationListener(double multiplier) {
		super();
		this.multiplier = multiplier;
	}
	
	@Override
	public double postSimpleThrustCalculation(SimulationStatus status, double thrust) throws SimulationException {
		return thrust * multiplier;
	}
	
}