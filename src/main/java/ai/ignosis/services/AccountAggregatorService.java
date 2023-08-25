package ai.ignosis.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.ignosis.entities.AccountAggregator;
import ai.ignosis.entities.Bank;
import ai.ignosis.repositories.AccountAggregatorRepository;
import ai.ignosis.repositories.BankRepository;

@Service
public class AccountAggregatorService {

	@Autowired
	private AccountAggregatorRepository accountAggregatorRepository;
	
	@Autowired
	private BankRepository bankRepository;
	
	public void addAggregator(String aggregatorName, List<String> bankOptions) {
		AccountAggregator ag = new AccountAggregator();
		ag.setName(aggregatorName);
		
		Set<Bank> banks = new HashSet<>();
		for(String bankName : bankOptions)
		{
			Bank b1 = bankRepository.findByBankName(bankName);
			banks.add(b1);
		}
		ag.setBanks(banks);
		accountAggregatorRepository.save(ag);
	}

	public List<AccountAggregator> getAllAggregators() {
		return accountAggregatorRepository.findAll();
	}
	

//	public Set<Bank> addAggregatorInTenant(String aggregatorId) {
//		return getAccountAggregatorById(aggregatorId).getBanks();
//	}
	

//	 public List<Bank> getAggBanks(String id)
//	 {
//		 List<Bank> banks = new ArrayList<>();
//		 for(AccountAggregator agg : aggregators)
//		 {
//			 if(String.valueOf(agg.getId()).equals(id))
//			 {
//				 for(Bank b : agg.getBanks()) {
//					 banks.add(b);
//				 }
//			 }
//		 }
//		 return banks;
//	 }

}
