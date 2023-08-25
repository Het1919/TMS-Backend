package ai.ignosis.entities;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Tenant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String tenantId;
	private String tenantName;
	
	@ManyToMany
	private Set<AccountAggregator> accountAggregators;	

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public Set<AccountAggregator> getAccountAggregators() {
		return accountAggregators;
	}

	public void setAccountAggregators(Set<AccountAggregator> accountAggregators) {
		this.accountAggregators = accountAggregators;
	}

	

	public Tenant(String tenantId, String tenantName, Set<AccountAggregator> accountAggregators) {
		super();
		this.tenantId = tenantId;
		this.tenantName = tenantName;
		this.accountAggregators = accountAggregators;
	}

	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", tenantName=" + tenantName + ", accountAggregators="
				+ accountAggregators + "]";
	}

	public Tenant() {
		super();
	}

}