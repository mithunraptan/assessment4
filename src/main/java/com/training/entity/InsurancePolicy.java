package com.training.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "insurancepolicy")
public class InsurancePolicy {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(unique = true)
	    private String policyName;

	    private String premiumMonth;
	    
	    private String durationMonth;
	    
	    @ManyToOne
	    @JoinColumn(name = "userId")
	    private User user;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getPolicyName() {
			return policyName;
		}

		public void setPolicyName(String policyName) {
			this.policyName = policyName;
		}

		public String getPremiumMonth() {
			return premiumMonth;
		}

		public void setPremiumMonth(String premiumMonth) {
			this.premiumMonth = premiumMonth;
		}

		public String getDurationMonth() {
			return durationMonth;
		}

		public void setDurationMonth(String durationMonth) {
			this.durationMonth = durationMonth;
		}
	    
	    

}
