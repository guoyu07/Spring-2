package com.sample.spring.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.sample.spring.entity.Account;
import com.sample.spring.utils.ApplicationConstants;


@Service
public class AccountServiceImpl {

	@PersistenceContext
	protected EntityManager em;
	
	public AccountServiceImpl() throws Exception {
		super();
	}

	public List<Account> fetchAllUserAccount(String id) throws Exception {
		/*Query query = em.createQuery("Select a from Account a where a.accountRole.code.value = :role");
		query.setParameter("role", role);
		List<Account> accounts = query.getResultList();*/
		ApplicationConstants.getOutput().add("AccountServiceImpl.class: Service method invoked for fetching all user details..\n");
		TypedQuery<Account> query;
		if(id != null && !id.equals("")){
			query = em.createNamedQuery("Account.lookUpLogin", Account.class);
			query.setParameter("userName", "");
		}else{
			query = em.createNamedQuery("Account.findAll", Account.class);
		}
		List<Account> accounts = query.getResultList();
		return accounts;
	}

}
