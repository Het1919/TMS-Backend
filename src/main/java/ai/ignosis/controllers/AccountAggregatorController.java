package ai.ignosis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import ai.ignosis.dto.AccountAggregatorDto;
import ai.ignosis.entities.AccountAggregator;
import ai.ignosis.services.AccountAggregatorService;

@Controller
public class AccountAggregatorController {
	
	@Autowired
	private AccountAggregatorService accountAggregatorService;

	@PostMapping("/addAggregator")
	public String addAggregator(@RequestBody AccountAggregatorDto aggregator) {
		//System.out.println(aggregator.getName() + " -- "+aggregator.getBanks());
		accountAggregatorService.addAggregator(aggregator.getName(),aggregator.getBanks());
		System.out.println(aggregator);
		return "redirect:/";
	}
	
	@GetMapping("/getAllAggregators")
	public List<AccountAggregator> getAllAggregators()
	{
		return accountAggregatorService.getAllAggregators();
	}
	
}
