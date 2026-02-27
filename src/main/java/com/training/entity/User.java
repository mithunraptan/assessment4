package com.training.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String password;
    
    @OneToMany(mappedBy = "user")
    private List<InsurancePolicy> lisOfPolicy;

    // getters and setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public List<InsurancePolicy> getLisOfPolicy() {
		return lisOfPolicy;
	}

	public void setLisOfPolicy(List<InsurancePolicy> lisOfPolicy) {
		this.lisOfPolicy = lisOfPolicy;
	}
    
    
}