package ai.ignosis.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class AccountAggregator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToMany
	private Set<Bank> banks = new HashSet<>();
	
	@ManyToMany
	private Set<Bank> selectedBanks = new HashSet<>();
	
	@ManyToMany(mappedBy="accountAggregators")
	private Set<Tenant> tenants = new HashSet<>();
	
	public AccountAggregator() {
		super();
	}
	
	public AccountAggregator(String name, Set<Bank> banks) {
		this.name = name;
		this.banks = banks;
	}
	
	public AccountAggregator(int id, String name, Set<Bank> banks, Set<Bank> selectedBanks) {
		super();
		this.id = id;
		this.name = name;
		this.banks = banks;
		this.selectedBanks = selectedBanks;
	}
	
	public AccountAggregator(AccountAggregator aggregator) {
		this.id = aggregator.id;
		this.name = aggregator.name;
		this.banks = aggregator.banks;
		this.selectedBanks = aggregator.selectedBanks;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Bank> getBanks() {
		return banks;
	}
	public void setBanks(Set<Bank> banks) {
		this.banks = banks;
	}
	public Set<Bank> getSelectedBanks() {
		return selectedBanks;
	}
	public void setSelectedBanks(Set<Bank> selectedBanks) {
		this.selectedBanks = selectedBanks;
	}
	
	
	@Override
	public String toString() {
		return "AccountAggregator [id=" + id + ", name=" + name + ", banks=" + banks + ", selectedBanks="
				+ selectedBanks + "]";
	}
}
