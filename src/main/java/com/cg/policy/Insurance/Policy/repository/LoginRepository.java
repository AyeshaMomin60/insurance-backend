package com.cg.policy.Insurance.Policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.policy.Insurance.Policy.model.Login;

/**
 * @author Aymomin This interface extends {@link JpaRepository} which provides
 *         JPA functionalities for the entity class {@link Policy} that
 *         is being managed.
 */
@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

	// Login findByMobileAndPassword(String mobile, String password);

}
