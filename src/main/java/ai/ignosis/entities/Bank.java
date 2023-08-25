package ai.ignosis.entities;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bankId;
	private String bankName;
	private boolean globalStatus;

	@ManyToMany(mappedBy = "banks")
	private Set<AccountAggregator> aggregators = new HashSet<>();

	public Bank() {
		super();
	}

	public Bank(int bankId, String bankName, boolean globalStatus, Set<AccountAggregator> aggregators) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.globalStatus = globalStatus;
		this.aggregators = aggregators;
	}

	public Bank(Bank b) {
		this.bankName = b.bankName;
		this.globalStatus = b.globalStatus;
	}

	public Bank(String bankName, boolean globalStatus) {
		super();
		this.bankName = bankName;
		this.globalStatus = globalStatus;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public boolean isGlobalStatus() {
		return globalStatus;
	}

	public void setGlobalStatus(boolean globalStatus) {
		this.globalStatus = globalStatus;
	}

	public Set<AccountAggregator> getAggregators() {
		return aggregators;
	}

	public void setAggregators(Set<AccountAggregator> aggregators) {
		this.aggregators = aggregators;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", globalStatus=" + globalStatus + ", aggregators="
				+ aggregators + "]";
	}

}