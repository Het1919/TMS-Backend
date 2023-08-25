package ai.ignosis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.ignosis.entities.Bank;
import ai.ignosis.repositories.BankRepository;

import java.util.*;

@Service
public class BankService {
	
	private final BankRepository bankRepository;
	
	@Autowired
	public BankService(BankRepository bankRepository) {
		this.bankRepository = bankRepository;
		initBanks();
	}
	
	private void initBanks() {
		List<Bank> banks = new ArrayList<>();
		banks.add(new Bank("SBI",true));
		banks.add(new Bank("HDFC",true));
		banks.add(new Bank("BOB",true));
		banks.add(new Bank("ICICI",true));
		banks.add(new Bank("PNB",true));
		bankRepository.saveAll(banks);
	}
	
	public List<Bank> getAllBanks()
	{
		return bankRepository.findAll();
	}
	
	public Bank getBankByName(String name)
	{
		Bank bank = bankRepository.findByBankName(name);
		return bank;
	}
}
