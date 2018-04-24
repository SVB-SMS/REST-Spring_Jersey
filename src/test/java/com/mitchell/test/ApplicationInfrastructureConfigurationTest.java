package com.mitchell.test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.svbsms.springjersey.configuration.ApplicationConfiguration;
import com.svbsms.springjersey.configuration.ApplicationInitializer;
import com.svbsms.springjersey.configuration.JerseyAppConfig;
import com.svbsms.springjersey.rest.model.Vehicle;
import com.svbsms.springjersey.rest.response.VehicleResponse;

@RunWith( SpringJUnit4ClassRunner.class )
@WebAppConfiguration
@ContextConfiguration( 
		  classes = { JerseyAppConfig.class, ApplicationInitializer.class, ApplicationConfiguration.class },
		  loader = AnnotationConfigWebContextLoader.class )
public class ApplicationInfrastructureConfigurationTest {
	
	private static final String RESTURI = "http://localhost:8080/mitchell/resources/vehicles";
	private Client client = ClientBuilder.newClient();
	
		@Autowired
	    private VehicleResponse vehicleResponse;

		@Test
		public void testVehicleResponse(){		
			assertEquals("class com.svbsms.springjersey.rest.response.VehicleResponse", vehicleResponse.getClass().toString());
		}
		
	    @Test
	    public void createVehicle(){
	    	Vehicle vehicle = new Vehicle();
	    	vehicle.setId(777);
	    	vehicle.setMake("Honda");
	    	vehicle.setModel("Camry");
	    	vehicle.setYear(2011);
	    	Response response = vehicleResponse.createVehicle(vehicle, null);
	//    	Response response = client.target(RESTURI).request(MediaType.APPLICATION_JSON).post(Entity.entity(vehicle, MediaType.APPLICATION_JSON));
			System.out.println("in createVehicle response: "+response);
			assertEquals("Should return status 201", 201, response.getStatus());
	//    	return response;
		}
	    
	    @Test
	    public void testGetVehicleExisting() {
	    	Integer id = 777;
	        Response response = vehicleResponse.getVehicle(id);
	        System.out.println("In testFlow response: "+response);
	        assertNotNull("Should return vehicle with id 777 ", response.getEntity());
	        Vehicle outputVehicle = (Vehicle)response.getEntity();
	        assertEquals("Should return true ", new Integer(outputVehicle.getId()), new Integer(id));
	    }
	    

	    @Test
		public void getAllVehicles() {
	        System.out.println("Testing get all vehicles");
	    	Response response = vehicleResponse.getVehicles(null, null);
	    	assertNotNull("Should return list ", response.getEntity());
//	        return output;
	    }

}
