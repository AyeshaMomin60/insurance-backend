package com.cg.policy.Insurance.Policy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.security.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.policy.Insurance.Policy.exception.InsuranceException;
import com.cg.policy.Insurance.Policy.model.EnrollmentRequest;
import com.cg.policy.Insurance.Policy.model.Policy;
import com.cg.policy.Insurance.Policy.model.User;
import com.cg.policy.Insurance.Policy.service.PlanService;
import com.cg.policy.Insurance.Policy.service.UserService;

import io.swagger.annotations.ApiOperation;


/**
 * @author aymomin
 *
 */
@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;

	@Autowired
	PlanService planService;
	
	/**
	 * 
	 * @param user
	 * @return This method return {@link User} with their respective Details
	 * @throws InsuranceException
	 */
	@PostMapping("/addUser")
	
	
	public ResponseEntity<User> registerUser(@RequestBody User user) throws InsuranceException {
		return userService.addUser(user);
	}
	
	/**
	 * This method return {@link User} 
	 * @param Email and Password
	 * @return {@link User}
	 */

	@ApiOperation(value = "get login record by username and password", response = User.class)
	@GetMapping("/user/login/{email}/{password}")
	
	public ResponseEntity<User> getLogin(@PathVariable("email") String email, @PathVariable("password") String password)
			throws InsuranceException {
		User result = userService.getLoginRecord(email, password);
		if (result != null && ((result.getRole().equals("User") || result.getRole().equals("Admin")
				|| result.getRole().equals("SUPER-ADMIN")) && result.getStatus().equalsIgnoreCase("Active"))) {

			return new ResponseEntity<>(result, HttpStatus.OK);

		} else {
			throw new InsuranceException("No User Present");
		}

	}

	/**
	 * This method return {@link Policy} 
	 * @return {@link Policy}
	 */
	@ApiOperation(value = "View Plans", response = Policy.class)
	@GetMapping("/showAllPlans")
	public ResponseEntity<List<Policy>> showAllPlans() {
		List<Policy> list = planService.getAllPlan();
		return new ResponseEntity<>(list, HttpStatus.OK);

	}


	/**
	 * This method return {@link Policy} 
	 * @param userId
	 * @return {@link Policy}
	 */
	@ApiOperation(value = "get policy taken by user", response = User.class)
	@GetMapping("/UserTakenPlan/{userId}")
	public ResponseEntity<Policy> ViewEnrollPlan(@PathVariable("userId") int userId) throws InsuranceException {
		User userDetails = userService.getEnrollmentDetails(userId);
		if (userDetails == null) {
			throw new InsuranceException("No Policy Is being Taken");
		}
		Policy policy = planService.getPlanByPlanId(userDetails.getPolicy().getPlanId());
		return new ResponseEntity<>(policy, HttpStatus.OK);
	}

	@ApiOperation(value = "get user By user Id", response = User.class)
	@GetMapping("/UserByUserId/{userId}")
	
	/**
     * This method return {@link List} of {@link User} with their respective {@link Policy}
     * @param id : policyId
     * @return {@link List} of {@link User}
     */
	
	public ResponseEntity<User> ViewUser(@PathVariable("userId") int userId) throws InsuranceException {
		User user = userService.getEnrollmentDetails(userId);
		if (user == null) {
			throw new InsuranceException("No Policy Is being Taken");
		}
		// Plan p=planService.getPlanByPlanId(r.getPlan().getPlanId());
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	
	/**
	 * This method return {@link EnrollmentRequest} 
	 * @param Enrollment Details
	 * @return {@link EnrollmentRequest }
	 */
	@PostMapping("/EnrollIntoPlane")
	@ApiOperation("Enrolls a member in a benefit plan")
	public ResponseEntity<EnrollmentRequest> createEnrollment(@RequestBody EnrollmentRequest request) throws Exception {

		Policy policy = planService.findByPlaneId(request.getPolicy().getPlanId());
		User users = userService.findByUserId(request.getUser().getUserId());
		System.out.println(users);

		if (policy == null) {
			throw new InsuranceException("No policy present");
		}
		if (users == null) {
			throw new InsuranceException("No User present");
		}

		EnrollmentRequest enrollmentDetails =userService.addEnrollmentDetails(request);
		userService.setPlanId(users, policy);

		return new ResponseEntity<>(enrollmentDetails, HttpStatus.OK);
	}

	/**
	 * This method cancel the enrollment  
	 * @param EnrollmentId
	 * 
	 */
	
	@DeleteMapping("/cancelPlanRequest/{EnrollmentId}")
	@ApiOperation("Cancels a member's enrollment in a benefit plan")
	public ResponseEntity<Integer> cancelEnrollment(@PathVariable int EnrollmentId) {
		EnrollmentRequest result = userService.findByEnrollmentId(EnrollmentId);
		// User users=userService.findByUserId(request.getUser().getUserId());
		if (result == null) {
			throw new Error("No Plan is present");
		}
		userService.DeleteByEnrollmentId(EnrollmentId);

		return new ResponseEntity<>(0, HttpStatus.OK);
	}

	/**
	 * This method cancel the enrollment  
	 * @param EnrollmentId
	 * 
	 * 
	 */
	@GetMapping("/userDetails/{email:.+}/")
	// @GetMapping("/userDetails/{email:.+}")
	public User UserDetails(@PathVariable(value = "email") String email) {
		User user = userService.findUserByEmail(email.toString());
		System.out.println(user);
		return user;
	}
	
	/**
	 * This method return {@link ListofUser} 
	 * @return {@link ListofUser }
	 * 
	 */

//	@ApiOperation(value = "List of User", response = Policy.class)
//	@GetMapping("/ListOfUser")
//	public ResponseEntity<List<User>> showAllUser() {
//		List<User> list = userService.listOfUser();
//		for(int i=0; i<list.size();i++) {
//            User userObject = list.get(i);
//            if(userObject.getRole().equals("SUPER-ADMIN")) {
//                list.remove(i);
//            }
//        }
//		return new ResponseEntity<>(list, HttpStatus.OK);
//
//	}
	@ApiOperation(value = "List of User", response = Policy.class)
	@GetMapping("/ListOfUser")
	public ResponseEntity<List<User>> showAllUser() {
		
		return userService.listOfUser();

	}
	
	/**
	 * This method update {@link UserDetails}
	 * @param user 
	 * @return {@link UserDetails }
	 * 
	 */

	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws InsuranceException {
		User userDetails = userService.getUser(user.getUserId());
		if (userDetails == null) {
			throw new InsuranceException("no User present");
		}
		 if(userDetails.getRole().equalsIgnoreCase("SUPER-ADMIN")) {
			throw new InsuranceException("Admin data cannot be updated");
			
		}
		userDetails.setStatus(user.getStatus());
		userDetails.setRole(user.getRole());
		userService.UpdateUser(userDetails);
		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}

}