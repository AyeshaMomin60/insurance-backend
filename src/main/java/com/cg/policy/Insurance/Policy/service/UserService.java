package com.cg.policy.Insurance.Policy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.policy.Insurance.Policy.exception.InsuranceException;
import com.cg.policy.Insurance.Policy.model.EnrollmentRequest;
import com.cg.policy.Insurance.Policy.model.Login;
import com.cg.policy.Insurance.Policy.model.Policy;
import com.cg.policy.Insurance.Policy.model.User;
import com.cg.policy.Insurance.Policy.repository.EnrollmentRepository;
import com.cg.policy.Insurance.Policy.repository.LoginRepository;
import com.cg.policy.Insurance.Policy.repository.UserRepository;

@Transactional
@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	LoginRepository loginRepository;

	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Autowired
	PlanService planService;


	/**
	 * This method return {@link User} 
	 * @param User
	 * @return {@link User}
	 */
	public ResponseEntity<User> addUser(User user) throws InsuranceException {
		String email = user.getEmail();

		if (email != null && !"".equals(email)) {
			User userDetails = fetchUserByEmail(email);
			if (userDetails != null) {
				//logger.info("User Already Exsist");
				throw new InsuranceException("User Already Exsist");
			}

		}
		user.setRole("User");
		user.setStatus("Inactive");
		User users = userRepository.save(user);
		
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	/**
	 * This method return {@link login} 
	 * @param Login
	 * @return {@link login}
	 */
	public Login addLogin(Login login) {
		return loginRepository.save(login);
	}

	/**
	 * This method return {@link User} 
	 * @param User
	 * @return {@link User}
	 */
	public User getLoginRecord(String email, String password) {
		User user = userRepository.findByEmail(email);
		System.out.println(user);
		return user;
	}

	/**
	 * This method return {@link request} 
	 * @param Enrollment
	 * @return {@link User}
	 */
	public EnrollmentRequest addEnrollmentDetails(EnrollmentRequest request) {
		return enrollmentRepository.save(request);

	}

	/**
	 * This method return {@link User,plan} 
	 * @param User
	 * @return {@link User}
	 */
	public void setPlanId(User users, Policy policy) {
		users.setPolicy(policy);
		userRepository.save(users);
	}

	/**
	 * This method return {@link User} 
	 * @param userId
	 * @return {@link User}
	 */
	public User findByUserId(int userId) {
		return userRepository.findByUserId(userId);
	}
	
	/**
	 * This method return {@link Enrollment} 
	 * @param EnrollmentId
	 * @return {@link Enrollment}
	 */

	public EnrollmentRequest findByEnrollmentId(int enrollmentId) {

		return enrollmentRepository.findByEnrollmentId(enrollmentId);
	}

	/**
	 * This method return {@link String}
	 * @param EnrollmentId
	 * @return {@link String}
	 */
	public String DeleteByEnrollmentId(int enrollmentId) {

		enrollmentRepository.deleteById(enrollmentId);
		return ("Request deleted successfully");
	}

	/**
	 * This method return {@link User} 
	 * @param Email
	 * @return {@link User}
	 */

	public User fetchUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	/**
	 * This method return {@link User} 
	 * @param Email,Password
	 * @return {@link User}
	 */
	public User fetchUserByEmailandPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	/**
	 * This method return {@link User} 
	 * @param Email
	 * @return {@link User}
	 */
	public User viewUserbyEmail(String email) {

		return userRepository.findByEmail(email);
	}

	/**
	 * This method return {@link User} 
	 * @param UserId
	 * @return {@link User}
	 */
	public User getEnrollmentDetails(int userId) {
		return userRepository.findByUserId(userId);
	}

	/**
	 * This method return {@link User} 
	 * @param Email
	 * @return {@link User}
	 */
	public User findUserByEmail(String email) {

		return userRepository.findByEmail(email);
	}
	
	/**
	 * This method return {@link User} 
	 * @return {@link User}
	 */
	public ResponseEntity<List<User>> listOfUser() {

		List<User> list =userRepository.findAll();
		for(int i=0; i<list.size();i++) {
            User userObject = list.get(i);
            if(userObject.getRole().equals("SUPER-ADMIN")) {
                list.remove(i);
            }
        }
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	/**
	 * This method return {@link User} 
	 * @param UserId
	 * @return {@link User}
	 */
	public User getUser(int userId) {
		return userRepository.findByUserId(userId);
	}

	/**
	 * This method return {@link User} 
	 * @param UserDetails
	 * @return {@link User}
	 */
	public User UpdateUser(User userDetails) {
		return userRepository.save(userDetails);
	}
	
	/**
	 * This method return {@link User} 
	 * @return {@link User}
	 */

	public List<User> showAllUser() {
		return userRepository.findAll();
	}

	
	/**
	 * This method return {@link User} 
	 * @param planId
	 * @return {@link User}
	 */
	public ResponseEntity<List<User>> findUserByPolicy(int planId) throws InsuranceException {
		
		Policy planDetail =  planService.findByPlaneId(planId);
		if (planDetail == null) {
			throw new InsuranceException("No Plan Present with given details");
		}
		List<User> userDetails = userRepository.findAllUserByPolicy(planDetail);
		
		return new ResponseEntity<>(userDetails, HttpStatus.OK);
		
	}

}
