package com.cg.policy.Insurance.Policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.policy.Insurance.Policy.model.Admin;
/**
 * @author Aymomin This interface extends {@link JpaRepository} which provides
 *         JPA functionalities for the entity class {@link Policy} that
 *         is being managed.
 */
 
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Admin findByEmail(String email);

}
