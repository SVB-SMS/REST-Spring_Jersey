package com.svbsms.springjersey.rest.response;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.svbsms.springjersey.rest.model.Vehicle;
import com.svbsms.springjersey.rest.service.MitchellService;

@Component("vehicleResponse")
@Path("/vehicles")
public class VehicleResponse {
//	private static final Logger LOGGER = LoggerFactory.getLogger(VehicleServiceImpl.class);
	
	@Autowired
	private MitchellService mitchellService;
	
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getVehicle(@PathParam("id") int id) {
		System.out.println("In Get Vehicle id: "+id+" mitchellService: "+mitchellService);
		Vehicle vehicle = this.mitchellService.getVehicle(id);
		if(vehicle == null){
			System.out.println("vehicle is null");
			return Response.status(Response.Status.NO_CONTENT).entity("The requested Vehicle does not exist!").build();
		}
		System.out.println("vehicle is not null vehicle: "+vehicle);
		GenericEntity<Vehicle> entity = new GenericEntity<Vehicle>(vehicle){};
		System.out.println("vehicle is not null entity: "+entity);
		return Response.status(Response.Status.OK).entity(entity).build();
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getVehicles(@QueryParam("make") String make, @QueryParam("model") String model) {
//		LOGGER.info("getVehicles called");
		System.out.println("getVehicles called");
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		if(null != make && null != model){
			vehicles = this.mitchellService.getVehiclesByMakeAndModel(make, model);
		}
		else{
			vehicles = this.mitchellService.getVehicles();	
		}		
		System.out.println("getVehicles vehicles: "+vehicles);
		if(vehicles.isEmpty())
			return Response.status(Response.Status.NO_CONTENT).entity("There is no related data!").build();
		GenericEntity<List<Vehicle>> entity;
		entity = new GenericEntity<List<Vehicle>>(vehicles){};
		return Response.status(Response.Status.OK).entity(entity).build();
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createVehicle(@Valid Vehicle vehicle, @Context UriInfo uriInfo) {
		System.out.println("In createVehicle");
		if(null != mitchellService.getVehicle(vehicle.getId())){
			return Response.status(Response.Status.NOT_MODIFIED).entity("This Vehicle already exist!").build();
		}
		Vehicle newVehicle = this.mitchellService.createVehicle(vehicle);
		if(uriInfo == null)
			return Response.status(Response.Status.CREATED).build();
		return Response.status(Response.Status.CREATED)
				.header("Location:", String.format("%s/%s", uriInfo.getAbsolutePath().toString(), newVehicle.getId())).build();
	}

	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response updateVehicleDetails(@Valid Vehicle vehicle) {
		if(null == mitchellService.getVehicle(vehicle.getId())){
			return Response.status(Response.Status.NOT_MODIFIED).entity("This Vehicle does not exist to modify!").build();
		}
		this.mitchellService.updateVehicleDetails(vehicle);
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Path("{id}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response deleteVehicle(@PathParam("id") int id) {
		if(null == mitchellService.getVehicle(id)){
			return Response.status(Response.Status.NOT_FOUND).entity("This Vehicle does not exist. Hence cannot be deleted!").build();
		}
		this.mitchellService.deleteVehicle(id);
		return Response.status(Response.Status.OK).build();
	}

}
