package com.acme.orders.api.rest.v1.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.acme.orders.api.rest.v1.auth.User;
import com.acme.orders.api.services.OrderService;
import com.acme.orders.lib.v1.Order;
import com.codahale.metrics.annotation.Timed;

import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    private OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @GET
    @UnitOfWork
    @Timed
    public Response getOrder(@QueryParam("limit") Integer limit,
                             @QueryParam("offset") Integer offset) {

        List<Order> customers = orderService.findOrders(limit, offset);
        Long customersCount = orderService.findOrdersCount();

        return Response.ok(customers).header("X-Total-Count", customersCount).build();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @Timed
    public Response getOrder(@PathParam("id") String id) {

        Order order = orderService.findOrderById(id);

        return Response.ok(order).build();
    }

    @POST
    @UnitOfWork
    @Timed
	public Response createOrder(Order newOrder, @Auth User user ) {

		Order order = orderService.createOrder(newOrder , user );

        return Response.ok(order).build();
    }

    @POST
    @Path("/{id}/complete")
    @UnitOfWork
    @Timed
    public Response completeOrder(@PathParam("id") String id) {

        Order order = orderService.completeOrder(id);

        return Response.ok(order).build();
    }

    @POST
    @Path("/{id}/cancel")
    @UnitOfWork
    @Timed
    public Response cancelOrder(@PathParam("id") String id) {

        Order order = orderService.cancelOrder(id);

        return Response.ok(order).build();
    }
}
