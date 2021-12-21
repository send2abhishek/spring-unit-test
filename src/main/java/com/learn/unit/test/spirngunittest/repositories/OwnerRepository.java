package com.learn.unit.test.spirngunittest.repositories;


import com.learn.unit.test.spirngunittest.model.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
