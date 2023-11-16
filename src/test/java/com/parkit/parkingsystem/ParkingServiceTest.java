package com.parkit.parkingsystem;

import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.dao.ParkingSpotDAO;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.model.ParkingSpot;
import com.parkit.parkingsystem.model.Ticket;
import com.parkit.parkingsystem.service.ParkingService;
import com.parkit.parkingsystem.util.InputReaderUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ParkingServiceTest {

	private static ParkingService parkingService;
	@Mock
	private static InputReaderUtil inputReaderUtil;
	@Mock
	private static ParkingSpotDAO parkingSpotDAO;
	@Mock
	private static TicketDAO ticketDAO;

	@BeforeEach
	public void setUpPerTest() { 
  when(inputReaderUtil.readVehicleRegistrationNumber()).thenReturn("ABCDEF");

            ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR,false);
            Ticket ticket = new Ticket();
            //one hour ago
            ticket.setInTime(new Date(System.currentTimeMillis() - (60*60*1000)));
            ticket.setParkingSpot(parkingSpot);
            ticket.setVehicleRegNumber("ABCDEF");
            when(ticketDAO.getTicket(anyString())).thenReturn(ticket);
            when(ticketDAO.updateTicket(any(Ticket.class))).thenReturn(true);

            when(parkingSpotDAO.updateParking(any(ParkingSpot.class))).thenReturn(true);

            parkingService = new ParkingService(inputReaderUtil, parkingSpotDAO, ticketDAO);
	}

	// @Test
	// public void testprocessExitingVehicle() {
		
	// 	when(ticketDAO.updateTicket(any(Ticket.class))).thenReturn(true);	

	// 	parkingService.processExitingVehicle();

	// 	verify(inputReaderUtil, Mockito.times(1)).readVehicleRegistrationNumber();
	// 	verify(ticketDAO, Mockito.times(1)).getTicket("ABCDEF");
	// 	verify(ticketDAO, Mockito.times(1)).getNbTicket("ABCDEF");
	// 	verify(ticketDAO, Mockito.times(1)).updateTicket(any(Ticket.class));
	// 	verify(parkingSpotDAO, Mockito.times(1)).updateParking(any(ParkingSpot.class));
		

	// }

	// @Test
    // public void testProcessIncomingVehicle() {
    		
    // 	when(inputReaderUtil.readSelection()).thenReturn(1);
    // 	when(parkingSpotDAO.getNextAvailableSlot(any(ParkingType.class))).thenReturn(1);  	
    // 	when(ticketDAO.saveTicket(any(Ticket.class))).thenReturn(true);
    		
    // 	parkingService.processIncomingVehicle();
    	  		
    // 	verify(inputReaderUtil, Mockito.times(1)).readSelection();
    // 	verify(inputReaderUtil, Mockito.times(1)).readVehicleRegistrationNumber();
    //     verify(parkingSpotDAO, Mockito.times(1)).getNextAvailableSlot(any(ParkingType.class));
    //     verify(parkingSpotDAO, Mockito.times(1)).updateParking(any(ParkingSpot.class));
    //     verify(ticketDAO, Mockito.times(1)).getNbTicket("ABCDEF");
    //     verify(ticketDAO, Mockito.times(1)).saveTicket(any(Ticket.class)); 	
    	
    // }

	// @Test
	// public void testProcessExitingVehicleUnableUpdate() {
	
	// 	when(ticketDAO.updateTicket(any(Ticket.class))).thenReturn(false);

	// 	parkingService.processExitingVehicle();

	// 	verify(inputReaderUtil, Mockito.times(1)).readVehicleRegistrationNumber();
	// 	verify(ticketDAO, Mockito.times(1)).getTicket("ABCDEF");
	// 	verify(ticketDAO, Mockito.times(1)).getNbTicket("ABCDEF");
	// 	verify(ticketDAO, Mockito.times(1)).updateTicket(any(Ticket.class));		
	// 	verify(parkingSpotDAO, never()).updateParking(any(ParkingSpot.class));

	// }

	// @Test
	// public void testGetNextParkingNumberIfAvailable() {

	// 	when(inputReaderUtil.readSelection()).thenReturn(1);
	// 	when(parkingSpotDAO.getNextAvailableSlot(any(ParkingType.class))).thenReturn(1);

	// 	parkingService.getNextParkingNumberIfAvailable();

	// 	verify(inputReaderUtil, Mockito.times(1)).readSelection();
	// 	verify(parkingSpotDAO, Mockito.times(1)).getNextAvailableSlot(ParkingType.CAR);

	// }

	// @Test
	// public void testGetNextParkingNumberIfAvailableParkingNumberNotFound() {

	// 	when(inputReaderUtil.readSelection()).thenReturn(1);
	// 	when(parkingSpotDAO.getNextAvailableSlot(any(ParkingType.class))).thenReturn(0);

	// 	parkingService.getNextParkingNumberIfAvailable();

	// 	verify(inputReaderUtil, Mockito.times(1)).readSelection();
	// 	verify(parkingSpotDAO, Mockito.times(1)).getNextAvailableSlot(ParkingType.CAR);

	// }

	// @Test
	// public void testGetNextParkingNumberIfAvailableParkingNumberWrongArgument() {

	// 	when(inputReaderUtil.readSelection()).thenReturn(3);

	// 	parkingService.getNextParkingNumberIfAvailable();

	// 	verify(inputReaderUtil, Mockito.times(1)).readSelection();

	// }

}