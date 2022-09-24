package com.iacsd.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.pojos.Address;

public interface AddressDao extends JpaRepository<Address, String> {
	
	Address save();
	
}
