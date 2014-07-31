package org.training.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.training.dao.EventDAO;
import org.training.dao.UserDAO;
import org.training.dao.GroupDAO;
import org.training.dao.TopicDAO;
import org.training.dao.LocationDAO;
import org.training.model.Event;
import org.training.model.Groups;
import org.training.model.Location;
import org.training.model.Topic;
import org.training.model.User;

@Path("/tc")
public class TCResource {

	UserDAO udao = new UserDAO();
	EventDAO edao = new EventDAO();
	TopicDAO tdao=new TopicDAO();
	LocationDAO ldao=new LocationDAO();
	GroupDAO gdao=new GroupDAO();

	/*----------------------------------------user----------------------------------------*/

	@GET
	@Path("/user")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<User> findAllUsers() {
		System.out.println("findAll");
		return udao.findAll();
	}

	@GET
	@Path("/user/searche/{email}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User findByEmail(@PathParam("email") String email) {
		System.out.println("findByEmail: " + email);
		return udao.findByEmail(email);
	}

/*	@GET
	@Path("/user/auth/{email}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User findAuth(@PathParam("email") String email) {
		System.out.println("findByEmail: " + email);
		return udao.findPass(email);
	}*/

	@GET
	@Path("/user/auth/{email},{password}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User findAuth(@PathParam("email") String email,@PathParam("password") String pass) {
		System.out.println("findByEmail: " + email);	
		return udao.findRole(email,pass);
	}	 

	@POST
	@Path("/user")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User createUser(User user) {
		System.out.println("create user");
		System.out.println("name is" + user.getFirstName());
		return udao.create(user);
	}

	@PUT
	@Path("/user")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User updateUser(User user) {
		user.setFirstName(user.getFirstName());
		System.out.println("Updating user: " + user.getFirstName());
		udao.update(user);
		return user;
	}

	@DELETE
	@Path("/user/{email}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<User> removeUser(@PathParam("email") String email) {
		System.out.println("Deleted id : " + email);
		udao.remove(email);
		return udao.findAll();
	}

/*	@DELETE
	@Path("/user/{email}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void removeUser(@PathParam("email") String email) {
		System.out.println("Deleted id : " + email);
		udao.remove(email);
	}*/

	/*-----------------------------------------user-------------------------------------------*/

	/*@POST
	@Path("/show")
	public Response addUser(@FormParam("fname") String name,

	@FormParam("lname") int age) {
		return Response.status(200)
				.entity("addUser is called, name : " + name + ", lname : "+ age).build();
	}*/

	/*----------------------------------------event----------------------------------------*/

	@GET
	@Path("/event")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Event> findAll() {
		System.out.println("findAll");
		return edao.findAll();
	}

	@GET
	@Path("/event/searchid/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Event> findById(@PathParam("id") int id) {
		System.out.println("findById: " + id);
		return edao.findById(id);
	}

	@GET
	@Path("/event/searchd/{date}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Event> findByDate(@PathParam("date") String date) {
		System.out.println("findByDate: " + date);
		return edao.findByDate(date);
	}

	@GET
	@Path("/event/searchg/{group}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Event> findByGroup(@PathParam("group") String group) {
		System.out.println("findByGroup: " + group);
		return edao.findByGroup(group);
	}

	@GET
	@Path("/event/searcht/{topic}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Event> findByTopic(@PathParam("topic") String topic) {
		System.out.println("findByTopic: " + topic);
		return edao.findByTopic(topic);
	}

	@GET
	@Path("/event/searchl/{location}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Event> findByLocation(@PathParam("location") String location) {
		System.out.println("findByLocation: " + location);
		return edao.findByLocation(location);
	}

	@GET
	@Path("/event/searche/{email}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Event> eventFindByEmail(@PathParam("email") String email) {
		System.out.println("eventFindByEmail: " + email);
		return edao.eventFindByEmail(email);
	}

	@POST
	@Path("/event")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Event create(Event event) {
		System.out.println("create event");
		event.setDate(event.getDate());
		System.out.println("date is" + event.getDate());
		return edao.create(event);
	}

	@DELETE
	@Path("/event/{id}")
	public List<Event> remove(@PathParam("id") int id) {
		System.out.println("Deleted event on: " + id);
		edao.remove(id);
		return edao.findAll();
	}

	@PUT
	@Path("/event")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Event update(Event event) {
		event.setDate(event.getDate());
		System.out.println("Updating event: " + event.getDate());
		edao.update(event);
		return event;
	}	
	
/*----------------------------------------topic----------------------------------------*/
	
	@GET
	@Path("/topic")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Topic> findAllTopic() {
		System.out.println("findAllTopic");
		return tdao.findAllTopic();
	}	
	@GET
	@Path("/topic/searchtid/{topicId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Topic findByTopicIdTopic(@PathParam("topicId") int topicId) {
		System.out.println("findByTopicIdTopic: "+topicId);
		return tdao.findByTopicIdTopic(topicId);
	}	
		
	@GET
	@Path("/topic/searcht/{topic}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Topic findByTopicTopic(@PathParam("topic") String topic) {
		System.out.println("findByTopic: " + topic);
		return tdao.findByTopicTopic(topic);
		
	}
	
	@GET
	@Path("/topic/searchtr/{trainer}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Topic findByTrainerTopic(@PathParam("trainer") String trainer) {
		System.out.println("findByTrainer: " + trainer);	
		return tdao.findByTrainerTopic(trainer);		
	}	
	
	@POST
	@Path("/topic")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Topic createTopic(Topic topic) {
		System.out.println("create topic");
		topic.setTopic(topic.getTopic());
		System.out.println("Topic is" + topic.getTopic());
		return tdao.createTopic(topic);
	}
		
	@DELETE
	@Path("/topic/{topicId}")	
	public List<Topic> removeTopic(@PathParam("topicId") int topicId) {
		System.out.println("Deleted topic on: " + topicId);
		tdao.removeTopic(topicId);
		return tdao.findAllTopic();
	}	
	
	@PUT
	@Path("/topic")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Topic updateTopic(Topic topic) {
		topic.setTopic(topic.getTopic());		
		System.out.println("Updating topic: " + topic.getTopic());
		tdao.updateTopic(topic);
		return topic;
	}
	
	
/*----------------------------------------location----------------------------------------*/
	
	@GET
	@Path("/location")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Location> findAllLocation() {
		System.out.println("findAllLocation");
		return ldao.findAllLocation();
	}	
	@GET
	@Path("/location/searchloid/{locationId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Location findByLocationIdLocation(@PathParam("locationId") int locationId) {
		System.out.println("findByLocationIdLocation: "+locationId);
		return ldao.findByLocationIdLocation(locationId);
	}	
		
	@GET
	@Path("/location/searchlo/{location}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Location findByLocationLocation(@PathParam("location") String location) {
		System.out.println("findByLocationLocation: " + location);
		return ldao.findByLocationLocation(location);		
	}	
	
	@POST
	@Path("/location")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Location createLocation(Location location) {
		System.out.println("create location");
		location.setLocation(location.getLocation());
		System.out.println("Location is" + location.getLocation());
		return ldao.createLocation(location);
	}
		
	@DELETE
	@Path("/location/{locationId}")	
	public List<Location> removeLocation(@PathParam("locationId") int locationId) {
		System.out.println("Deleted location on: " + locationId);
		ldao.removeLocation(locationId);
		return ldao.findAllLocation();
	}	
	
	@PUT
	@Path("/location")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Location updateLocation(Location location) {
		location.setLocation(location.getLocation());		
		System.out.println("Updating location: " + location.getLocation());
		ldao.updateLocation(location);
		return location;
	}
	
/*----------------------------------------groups----------------------------------------*/
	
	@GET
	@Path("/groups")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Groups> findAllGroups() {
		System.out.println("findAllGroups");
		return gdao.findAllGroups();
	}	
	
	@GET
	@Path("/groups/searchi/{groupId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Groups findByGroupIdGroups(@PathParam("groupId") int groupId) {
		System.out.println("findByGroupIdgroups: "+groupId);
		return gdao.findByGroupIdGroups(groupId);
	}	
		
	@GET
	@Path("/groups/searchg/{group}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Groups findByGroupGroups(@PathParam("group") String group) {
		System.out.println("findByGroupGroups: " + group);
		return gdao.findByGroupGroups(group);
		
	}
	
	
	@POST
	@Path("/groups")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Groups createGroups(Groups group) {
		System.out.println("create group");
		group.setGroup(group.getGroup());
		System.out.println("Location is" + group.getGroup());
		return gdao.createGroups(group);
	}
		
	@DELETE
	@Path("/groups/{groupId}")	
	public List<Groups> removeGroups(@PathParam("groupId") int groupId) {
		System.out.println("Deleted group on: " + groupId);
		gdao.removeGroups(groupId);
		return gdao.findAllGroups();
	}	
	
	@PUT
	@Path("/groups")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Groups updateGroups(Groups group) {
		group.setGroup(group.getGroup());		
		System.out.println("Updating group: " + group.getGroup());
		gdao.updateGroups(group);
		return group;
	}
}