package com.tim.project.repository;

import com.tim.project.model.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<Shop,Integer> {

}
