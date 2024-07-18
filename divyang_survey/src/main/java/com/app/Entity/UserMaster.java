package com.app.Entity;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "tbl_user_master")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserMaster implements UserDetails {

	@Id
	@SequenceGenerator(name="tbl_user_master_seq",sequenceName="tbl_user_master_seq",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tbl_user_master_seq")
	@Column(name = "usm_id",columnDefinition="bigint")
	private Long usmId;
	
	@Column(name = "is_active",columnDefinition="char")
	private Character isActive;
	
	@Column(name = "created_by",columnDefinition="bigint")
	private Long createdBy;
	
	@Column(name = "created_date",columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
	private Date createdDate;
	
	@Column(name = "usm_elc_id",columnDefinition="bigint")
	private Long usmElcId;
	
	@Column(name = "usm_user_name",columnDefinition="text")
	private String usmUserName;
	
	@Column(name = "usm_user_pass",columnDefinition="text")
	private String usmUserPass;
	
	
	@OneToOne(fetch=FetchType.LAZY)  
	@JoinColumn(name = "usm_epm_id", referencedColumnName = "epm_id",columnDefinition="bigint")
	private EmployeeMaster usmEpmId;
	
	@Column(name = "usm_rom_id",columnDefinition="bigint")
	private Long usmRomId;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="tbl_user_role_mapping", 
	joinColumns=@JoinColumn(name="urm_user",referencedColumnName = "usm_id"),
	inverseJoinColumns=@JoinColumn(name="urm_role",referencedColumnName="rm_id"))
	private Set<RoleMaster> roles=new HashSet<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	List<SimpleGrantedAuthority> authorities=	this.roles.stream().map((roles)-> new SimpleGrantedAuthority(roles.getRmName())).collect(Collectors.toList());
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.usmUserPass;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.usmUserName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
