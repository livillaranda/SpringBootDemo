package com.revature.SpringBootDemo.repos;

import com.revature.SpringBootDemo.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ShopRepo extends JpaRepository<Shop, Integer> {
/**
The Spring Data module takes this simplification one step further by providing standard implementation
for common DAO methods allowing for the removal of the DAO implementation and only requiring the
definition of the DAO interface methods.

In order to leverage the Sping Data programming model with JPA, a DAO interface should extend the
Spring JpaRepository interface from the org.springframework.data.jpa.repository package.
**/

/**
    Extending the CrudRepository should implement the following CRUD operations for us:
 .save()
    saveAll()
    findById()
    existsById()
    findAll()
    findAllById()
    count()
    deleteById()
    delete()
    deleteAll()
**/

/*
When using the Query annotation, the wildcard (?) must be added with param numbers to indicate the
index of the values.
EX: Update method using @Query
 */

    @Query(value="UPDATE shops SET s_name=?1, s_inv_count=?2, WHERE s_id=?3", nativeQuery = true)
    public boolean update(String name, int invCount, int id);

}
