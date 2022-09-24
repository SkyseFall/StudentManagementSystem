package com.iacsd.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.pojos.Users;

import java.lang.String;
import java.util.List;

public interface UsersDao extends JpaRepository<Users, Integer> {
	Users findByEmail(String email);
	Users save(Users user);
	Users findByuserId(int id);
	List<Users> findByAccountStatus(int acc_status);
	void deleteByEmail(String email);
	List<Users> findAll();
	List<Users> findByTypeJob(String typejob);
	List<Users> findByFirstName(String firstName);
	List<Users> findByLastName(String lastname);
}
