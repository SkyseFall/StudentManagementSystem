package com.iacsd.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.daos.UsersDao;
import com.iacsd.dto.AccountDetails;
import com.iacsd.dto.StudentIdentity;
import com.iacsd.pojos.Users;

@Transactional
@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersDao usersdao;

	@Override
	public Users findByEmail(String email) {
		return usersdao.findByEmail(email);
	}

	@Override
	public Users save(Users user) {
		return usersdao.save(user);
	}

	@Override
	public Users authenticate(String email, String password) {
		Users loggedInUser = usersdao.findByEmail(email);
		//System.out.println(loggedInUser);
		if(loggedInUser != null ) {
			if(loggedInUser.getPassword().equals(password)) {
				System.out.println("passowrd match");
				return loggedInUser;
			}else {
				loggedInUser = new Users();
				loggedInUser.setUserId(-1);
				loggedInUser.setAccountStatus(1);
				System.out.println("passowrd not match");
				return loggedInUser;
			}
		}
		
		System.out.println("passowrd NULL match");
		return null;
	}

	@Override
	public Users changePassword(Date dob, String email) {
		Users user = usersdao.findByEmail(email);
		//System.out.println(user);
		//System.out.println(user.getDob().equals(dob));
		//System.out.println(user.getDob().toString());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String format = formatter.format(dob);
		//System.out.println(format);
		if(user != null && user.getDob().toString().equals(format) ) {
			return user;
		}
		return null;
	}

	@Override
	public Users findByuserId(int id) {
		return usersdao.findByuserId(id);
	}
	
	@Override
	public List<AccountDetails> findByAccountStatus(int acc_status) {
		List<AccountDetails> details = new ArrayList<AccountDetails>();
		List<Users> users = usersdao.findByAccountStatus(acc_status);
		for (Users user : users) {
			AccountDetails account = new AccountDetails();
			account.setFirstName(user.getFirstName());
			account.setLastName(user.getLastName());
			account.setEmail(user.getEmail());
			account.setTypeJob(user.getTypeJob());
			account.setMobile(user.getMobile());
			details.add(account);
		}
		return details;
	}

	@Override
	public void deleteByEmail(String email) {
		usersdao.deleteByEmail(email);
	}

	@Override
	public List<AccountDetails> findAllExceptAdmin() {
		List<AccountDetails> nonAdminUsers  = new ArrayList<AccountDetails>();
		List<Users> users = usersdao.findAll();
		System.out.println("Users list : "+users);
		for (Users user : users) {
			if(!user.getTypeJob().equals("admin") && user.getAccountStatus() == 1) {
				AccountDetails account = new AccountDetails();
				account.setFirstName(user.getFirstName());
				account.setLastName(user.getLastName());
				account.setEmail(user.getEmail());
				account.setTypeJob(user.getTypeJob());
				account.setMobile(user.getMobile());
				nonAdminUsers.add(account);
			}
		}
		return nonAdminUsers;
	}

	@Override
	public List<String> findByTypeJob(String typejob) {
		List<Users> list = usersdao.findByTypeJob(typejob);
		List<String> names = new ArrayList<String>();
		String fullName; 
		for (Users user : list) {
			if(user.getAccountStatus() != 0) {
				fullName = "Id: " + user.getUserId() + "-" + user.getFirstName() + " " + user.getLastName();
				names.add(fullName);
			}
		}
		return names;
	}

	@Override
	public List<Users> findUsersByTypeJob(String typejob) {
		List<Users> users = usersdao.findByTypeJob(typejob);
		List<Users> validUsers = new ArrayList<>();
		for (Users user : users) {
			if(user.getAccountStatus() != 0) {
				validUsers.add(user);
			}
		}
		return validUsers;
	}

	@Override
	public List<Users> findByFirstName(String firstName) {
		return usersdao.findByFirstName(firstName);
	}

	@Override
	public List<Users> findByLastName(String lastname) {
		return usersdao.findByLastName(lastname);
	}

	@Override
	public List<Users> findUserByTypeJob(String string) {
		return usersdao.findByTypeJob(string);
	}

	@Override
	public List<StudentIdentity> fetchStudentIdentities(List<Users> usersList) {
		List<StudentIdentity> userIdentities = new ArrayList<StudentIdentity>();
		for (Users user : usersList) {
			StudentIdentity sIdentity = new StudentIdentity();
			sIdentity.setStudentId(user.getUserId());
			sIdentity.setsName(user.getFirstName()+" "+user.getLastName());
			userIdentities.add(sIdentity);
		}
		return userIdentities;
	}
	
	

}
