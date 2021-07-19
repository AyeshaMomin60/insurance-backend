package com.cg.policy.Insurance.Policy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.policy.Insurance.Policy.model.Policy;
import com.cg.policy.Insurance.Policy.repository.EnrollmentRepository;
import com.cg.policy.Insurance.Policy.repository.PlanRepository;

@Service
@Transactional
public class PlanService {

	@Autowired
	PlanRepository repository;

	@Autowired
	EnrollmentRepository enrollmentrepository;


	/**
	 * This method return {@link Policy} 
	 * @param policy
	 * @return {@link Policy}
	 */
	public Policy addPlan(Policy policy) {
		return repository.save(policy);
	}


	/**
	 * This method return {@link Policy} 
	 * @param policy
	 * @return {@link Policy}
	 */
	public Policy UpdatePlan(Policy policy) {
		return repository.save(policy);
	}

	

	/**
	 * This method return {@link Policy} 
	 * @param policyId
	 * @return {@link Policy}
	 */
	public Policy getPlan(int planId) {

		return repository.findByPlanId(planId);
	}



	/**
	 * This method return {@link Policy} 
	 * @return {@link Policy}
	 */
	public List<Policy> getAllPlan() {
        List<Policy> policies = repository.findAll();
        for(int i=0; i<policies.size();i++) {
            Policy policyObject = policies.get(i);
            if(policyObject.isDeleted()==true) {
                policies.remove(i);
            }
        }
        return policies;
    }
	


		/**
		 * This method return {@link Policy} 
		 * @param policyId
		 * @return {@link Policy}
		 */
	public Policy findByPlaneId(int planId) {
		return repository.findByPlanId(planId);
	}


	/**
	 * This method return {@link Policy} 
	 * @return {@link Policy}
	 */
	public List<Policy> showPlan() {
		return repository.findAll();
	}



	/**
	 * This method return {@link Policy} 
	 * @param policy Name
	 * @return {@link Policy}
	 */
	public Policy deletePlans(int planId) {
		Policy plan = findByPlaneId(planId);
		plan.setDeleted(true);	
		return repository.save(plan);
	}

	/**
	 * This method return {@link Policy} 
	 * @param policyId
	 * @return {@link Policy}
	 */

	public Policy getPlanByPlanId(int planId) {
		return repository.findByPlanId(planId);
	}



}
