package edu.iu.c322.finalProject.returnservice.repository;

import edu.iu.c322.finalProject.returnservice.model.entity.RentedItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentedItemRepository extends JpaRepository<RentedItems, Integer> {

    @Query(value = "SELECT * FROM rentalservice.rented_Items WHERE customer_Id = :customer_Id", nativeQuery = true)
    List<RentedItems> findByCustomer_Id(@Param("customer_Id") Integer customerId);

    @Query(value = "SELECT * FROM rentalservice.rented_Items WHERE customer_Id = :customer_Id AND item_Id = :item_Id", nativeQuery = true)
    RentedItems findByCustomer_IdAndItemId(@Param("customer_Id") Integer customerId, @Param("item_Id") Integer itemId);

}