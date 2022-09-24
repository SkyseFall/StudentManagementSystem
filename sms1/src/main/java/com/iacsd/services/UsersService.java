package com.iacsd.services;

import java.util.Date;
import java.util.List;

import com.iacsd.dto.AccountDetails;
import com.iacsd.dto.StudentIdentity;
import com.iacsd.pojos.Users;

public interface UsersService {
	Users findByEmail(String email);
	Users save(Users user);
	Users authenticate(String email, String password);
	Users changePassword(Date dob,String email);
	Users findByuserId(int id);
	List<AccountDetails> findByAccountStatus(int acc_status);
	void deleteByEmail(String email);
	List<AccountDetails> findAllExceptAdmin();
	List<String> findByTypeJob(String typejob);
	List<Users> findUsersByTypeJob(String typejob);
	List<Users> findByFirstName(String firstName);
	List<Users> findByLastName(String lastname);
	List<Users> findUserByTypeJob(String string);
	List<StudentIdentity> fetchStudentIdentities(List<Users> usersList);
}
