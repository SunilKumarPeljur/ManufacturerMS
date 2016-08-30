/**
 * 
 */
package com.training.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author admin
 *
 */

@Repository
public interface ManufacturerRepository extends MongoRepository<Manufacturer, Integer> {
	
	@Query("{'isActive':true}")
	public List<Manufacturer> getAllActiveManufacturers();
	
}
