package com.cg.policy.Insurance.Policy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.policy.Insurance.Policy.exception.InsuranceException;
import com.cg.policy.Insurance.Policy.model.Policy;
import com.cg.policy.Insurance.Policy.model.User;
import com.cg.policy.Insurance.Policy.service.AdminService;
import com.cg.policy.Insurance.Policy.service.PlanService;
import com.cg.policy.Insurance.Policy.service.UserService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Aymomin
 *
 */
@RestController
@RequestMapping(path = "api")
@CrossOrigin


public class AdminController {

	@Autowired
	AdminService service;

	@Autowired
	PlanService planService;

	@Autowired
	UserService userService;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * This method return {@link Policy} that is added
	 * 
	 * @param policy
	 * @return {@link Policy}
	 */

	@PostMapping("/CreatePlan")
	public ResponseEntity<Policy> addPlan(@RequestBody Policy policy) {
		Policy result = planService.addPlan(policy);
		 logger.info("New plan added successfully");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * This method return {@link Policy} that is updated
	 * 
	 * @param policy
	 * @return {@link Policy}
	 */
	@PutMapping("/updatePlan")
	public ResponseEntity<Policy> updatePlan(@RequestBody Policy policy) throws InsuranceException {
		Policy planDetails = planService.getPlan(policy.getPlanId());
		System.out.print(planDetails);
		if (planDetails == null) {
			throw new InsuranceException("no plan present");
		}
		planDetails.setCost(policy.getCost());
		planDetails.setDetuctableAmount(policy.getDetuctableAmount());
		Policy setPlan = planService.UpdatePlan(planDetails);
		
		return new ResponseEntity<>(setPlan, HttpStatus.OK);
		
	}

 

	/**
	 * This method Delete the Policy {@link Policy} 
	 * @param policyId
	 * @return {@link Policy}
	 */
	@PutMapping(path = { "/DeletePlan/{planId}" })
	public Policy delete(@PathVariable("planId") int planId) {
		return planService.deletePlans(planId);
	}

	
	/**
	 * This method return {@link Policy} 
	 * @param policyId
	 * @return {@link Policy}
	 */
	@GetMapping("/viewPlanById/{planId}")
	public Policy viewUserbyEmail(@PathVariable("planId") int planId) throws Exception {
		Policy user = service.viewPlanByPlanId(planId);
		if (user == null) {
			throw new InsuranceException("NOT FOUND");
		} else
			return service.viewPlanByPlanId(planId);
	}
	
	/**
	 * This method return {@link Policy} 
	 * @param policy Name
	 * @return {@link Policy}
	 */

	@GetMapping("/viewPlanByName/{Name}")
	public Policy viewUserbyEmail(@RequestParam("name") String name) throws Exception {
		Policy user = service.viewPlanByName(name);
		if (user == null) {
			throw new InsuranceException("NOT FOUND");
		} else
			return service.viewPlanByName(name);
	}

	/**
	 * This method return {@link List} of {@link Policy}
	 * 
	 * @return {@link List} of {@link Policy}
	 */
	@ApiOperation(value = "Show All Plan", response = Policy.class)
	@GetMapping("/AllPlans")
	public ResponseEntity<List<Policy>> AllPlans() {
		List<Policy> list = planService.getAllPlan();
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	

	
	/**
	 * This method return {@link User} 
	 * @param policyId
	 * @return {@link User}
	 */
	@ApiOperation(value = "Show All User Based On Plan", response = Policy.class)
	@GetMapping("/ShowPlanTakenByUser/{planId}")
	public ResponseEntity<List<User>> ShowPlanTakenByUser(@PathVariable("planId") int planId)
			throws InsuranceException {
		return userService.findUserByPolicy(planId);

	}

}
