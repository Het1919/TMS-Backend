//package ai.ignosis.services;
//
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.*;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import ai.ignosis.entities.Tenant;
//import ai.ignosis.entities.AccountAggregator;
//import ai.ignosis.entities.Bank;
//
//@Service
//public class TenantService {
//
//	private final ConcurrentHashMap<String, Tenant> tenants = new ConcurrentHashMap<>();
//
//	@Autowired
//	private AccountAggregatorService accountAggregatorService;
//
//	@Autowired
//	private BankService bankService;
//
//	private static int counter = 1;
//
//	public List<Tenant> getAllTenants() {
//		return new ArrayList<>(tenants.values());
//	}
//
//	public void handleDropdownChange(String selectedValue, String aggregatorsId, String bankId) {
//
//		for (AccountAggregator accAgg : accountAggregatorService.getAggregators()) {
//			if (String.valueOf(accAgg.getId()).equals(aggregatorsId)) {
//				for (Bank b : accAgg.getBanks()) {
//					if (String.valueOf(b.getBankId()).equals(bankId)) {
//						b.setGlobalStatus(Boolean.parseBoolean(selectedValue));
//						break;
//					}
//				}
//				break;
//			}
//		}
//		
//		List<Tenant> allTenants = getAllTenants();
//		
//		
//		for(Tenant t : allTenants)
//		{
//			Set<AccountAggregator> aggregators = t.getAccountAggregators();
//			for(AccountAggregator ag : aggregators)
//			{
//				if(String.valueOf(ag.getId()).equals(aggregatorsId))
//				{
//					Set<Bank> banks = ag.getSelectedBanks();
//					for(Bank b : banks)
//					{
//						if(String.valueOf(b.getBankId()).equals(bankId))
//						{
//							//b.setStatus(Boolean.parseBoolean(selectedValue));
//						}
//					}
//				}
//			}
//		}
//		
//	}
//
//	public void saveTenant(String tenantName) {
//		String prefix = "TID";
//		String formattedCounter = String.format("%02d", counter);
//		String randomID = prefix + formattedCounter;
//
//		Tenant t = new Tenant();
//		t.setTenantId(randomID);
//		t.setTenantName(tenantName);
//		t.setAccountAggregators(new HashSet<AccountAggregator>());
//
//		counter++;
//		tenants.put(randomID, t);
//	}
//
//	public Tenant getTenant(String tenantId) {
//		return tenants.get(tenantId);
//	}
//
//	public void handleDropdownChangeForTenant(String selectedValue1, String tenantId, String aggregatorsId,
//			String bankId) {
//
//		List<Tenant> allTenants = getAllTenants();
//		for (Tenant t : allTenants) {
//			if (t.getTenantId().equals(tenantId)) {
//				
//				Set<AccountAggregator> aggregators = t.getAccountAggregators();
//				
//				for(AccountAggregator ag : aggregators)
//				{
//					if(String.valueOf(ag.getId()).equals(aggregatorsId))
//					{
//						Set<Bank> selectedBanks = ag.getSelectedBanks();
//						for(Bank b : selectedBanks)
//						{
//							if(String.valueOf(b.getBankId()).equals(bankId))
//							{
//							//	b.setStatus(Boolean.parseBoolean(selectedValue1));
//								return;
//							}
//						}
//					}
//				}
//			}
//		}
//	}
//
//}
