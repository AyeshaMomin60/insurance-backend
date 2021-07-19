package com.cg.policy.Insurance.Policy.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.policy.Insurance.Policy.model.Admin;
import com.cg.policy.Insurance.Policy.model.Login;
import com.cg.policy.Insurance.Policy.model.Policy;
import com.cg.policy.Insurance.Policy.repository.AdminRepository;
import com.cg.policy.Insurance.Policy.repository.LoginRepository;
import com.cg.policy.Insurance.Policy.repository.PlanRepository;

@Service
@Transactional
public class AdminService {

	@Autowired
	AdminRepository Repository;

	@Autowired
	LoginRepository loginRepository;

	@Autowired
	PlanRepository planRepository;

	/**
	 * This method return {@link Login} 
	 * @return {@link Login}
	 * 
	 */
	
	public Login addLogin(Login login) {
		return loginRepository.save(login);
	}


	/**
	 * This method return {@link User} 
	 * @param Email,Password
	 * @return {@link User}
	 */
	public Admin getLoginRecord(String email, String password) {
		return Repository.findByEmail(email);
	}


	/**
	 * This method return {@link Policy} 
	 * @param policyId
	 * @return {@link Policy}
	 */
	public Policy viewPlanByPlanId(int planId) {
		return planRepository.findByPlanId(planId);
	}

	/**
	 * This method return {@link Policy} 
	 * @param policy Name
	 * @return {@link Policy}
	 */
	public Policy viewPlanByName(String name) {
		return planRepository.findPlanByName(name);
	}

	
	

}
