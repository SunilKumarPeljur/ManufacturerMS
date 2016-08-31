/**
 * 
 */
package com.training.feign.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.model.Orders;

/**
 * @author admin
 *
 */
@FeignClient("orders-ms")
public interface OrderClient {

	@RequestMapping(value = "/api/order", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Orders> findAll();
	
	@RequestMapping(value = "/api/order", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Orders postNewOrder(Orders orders);
	
	@RequestMapping(value = "/api/order/manufacturer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Orders> findOrdersByManufacturer(@PathVariable(value = "id") Integer id);

}
