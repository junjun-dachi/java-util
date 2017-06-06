package org.junjun.util.java.persistence;
// Generated Jun 6, 2017 10:36:31 PM by Hibernate Tools 5.2.3.Final


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="USER"
    ,catalog="MYDB"
)
public class User  implements java.io.Serializable {


     private BigDecimal id;
     private String name;
     private Set<Role> roles = new HashSet<Role>(0);

    public User() {
    }

	
    public User(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
    }
    public User(BigDecimal id, String name, Set<Role> roles) {
       this.id = id;
       this.name = name;
       this.roles = roles;
    }
   
     @Id 

    
    @Column(name="ID", unique=true, nullable=false, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

    
    @Column(name="NAME", nullable=false, length=50)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<Role> getRoles() {
        return this.roles;
    }
    
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }




}

