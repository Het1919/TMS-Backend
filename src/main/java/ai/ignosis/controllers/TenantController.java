package ai.ignosis.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ai.ignosis.entities.AccountAggregator;
import ai.ignosis.entities.Bank;
import ai.ignosis.entities.Tenant;
import ai.ignosis.services.AccountAggregatorService;
import ai.ignosis.services.BankService;

@Controller
public class TenantController {

//	@Autowired
//	private TenantService tenantService;

	@Autowired
	private BankService bankService;

	@Autowired
	private AccountAggregatorService accountAggregatorService;

	@GetMapping("/")
	public String home(Model model) {
//		List<Tenant> tenants = tenantService.getAllTenants();
//		model.addAttribute("tenants", tenants);
//
//		List<AccountAggregator> accountAggregators = accountAggregatorService.getAggregators();
//		model.addAttribute("accountAggregators", accountAggregators);

		model.addAttribute("bankOptions", bankService.getAllBanks());
		
		return "index";
	}

//	@PostMapping("/handleDropdownChange")
//	public String handleDropdownChange(@RequestParam("selectedValue") String selectedValue,
//			@RequestParam("aggregators_id") String aggregatorsId, @RequestParam("bank_id") String bankId) {
//		tenantService.handleDropdownChange(selectedValue, aggregatorsId, bankId);
//		return "redirect:/";
//	}
//
//	@PostMapping("/handleDropdownChangeForTenant")
//	public String handleDropdownChangeForTenant(@RequestParam("selectedValue1") String selectedValue1,
//			@RequestParam("tenant_id") String tenantId, @RequestParam("aggregators_id") String aggregatorsId,
//			@RequestParam("bank_id") String bankId) {
//		tenantService.handleDropdownChangeForTenant(selectedValue1, tenantId, aggregatorsId, bankId);
//		return "redirect:/";
//	}
//
	
//
//	@PostMapping("/addTenant")
//	public String addTenant(@RequestParam String tenantName) {
//		tenantService.saveTenant(tenantName);
//		return "redirect:/";
//	}
//
//	@GetMapping("/getBanks")
//	@ResponseBody
//	public List<Bank> getBanks(@RequestParam String selected, Model model) {
//		List<AccountAggregator> aggregators = accountAggregatorService.getAggregators();
//		List<Bank> banks = new ArrayList<>();
//
//		for (AccountAggregator agg : aggregators) {
//			if (String.valueOf(agg.getId()).equals(selected)) {
//				banks.addAll(agg.getBanks());
//				break;
//			}
//		}
//
//		return banks;
//	}
//
//	@PostMapping("/addAggregatorInTenant/{tenantId}")
//	public String addBankToTenant(@PathVariable String tenantId, @RequestParam String aggregatorId,
//			@RequestParam List<String> bankOptions) {
//
//		Tenant tenant = tenantService.getTenant(tenantId);
//		Set<AccountAggregator> accountAggregators = tenant.getAccountAggregators();
//
//		AccountAggregator agg = null;
//
//		if (!accountAggregators.isEmpty()) {
//			boolean flag = true;
//			for (AccountAggregator ag : accountAggregators) {
//				if (String.valueOf(ag.getId()).equals(aggregatorId)) {
//					agg = ag;
//					flag = false;
//					break;
//				}
//			}
//			if(flag == true)
//			{
//				AccountAggregator aggregator = accountAggregatorService.getAccountAggregatorById(aggregatorId);
//				AccountAggregator aggregator1 = new AccountAggregator(aggregator);
//				agg = aggregator1;
//				tenant.getAccountAggregators().add(agg);
//			}
//		} else {
//			AccountAggregator aggregator = accountAggregatorService.getAccountAggregatorById(aggregatorId);
//			AccountAggregator aggregator1 = new AccountAggregator(aggregator);
//			agg = aggregator1;
//			tenant.getAccountAggregators().add(agg);
//		}
//
//		Set<Bank> banksOfAggregator = agg.getBanks();
//
//		Set<Bank> banks = new HashSet<>();
//		
//		Set<String> addedBankIds = new HashSet<>();
//
//		for (String bId : bankOptions) {
//			for (Bank b : banksOfAggregator) {
//				if (String.valueOf(b.getBankId()).equals(bId)) {
//					Bank b1 = new Bank(b);
//		            banks.add(b1);
//		            addedBankIds.add(bId);
//				}
//			}
//		}
//		
//		for(Bank b: agg.getSelectedBanks())
//		{
//			 if (!addedBankIds.contains(String.valueOf(b.getBankId()))) {
//			        banks.add(b);
//			        addedBankIds.add(String.valueOf(b.getBankId())); // Mark this bank ID as added
//			    }
//		}
//
//		agg.setSelectedBanks(banks);
//		return "redirect:/";
//	}


}