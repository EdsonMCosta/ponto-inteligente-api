package com.ponto.inteligenteapi.dataproviders.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "companies")
public class CompanyEntity implements Serializable {

    private static final long serialVersionUID = 3960436649365666213L;

    private Long id;
    private String companyName;
    private String cnpj;
    private Date creationDate;
    private Date updateDate;
    private List<EmployeeEntity> employees;

    public CompanyEntity() {
    }

    public CompanyEntity(String companyName, String cnpj, Date creationDate, Date updateDate) {
        this.companyName = companyName;
        this.cnpj = cnpj;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public static CompanyEntity of(final String companyName, final String cnpj,
                                   final Date creationDate, final Date updateDate) {
        return new CompanyEntity(companyName, cnpj, new Date(), new Date());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "company_name", nullable = false)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(name = "cnpj", nullable = false)
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Column(name = "creation_date", nullable = false)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "update_date", nullable = false)
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }

    @PreUpdate
    public void preUpdate() {
        updateDate = new Date();
    }

    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        creationDate = atual;
        updateDate = atual;
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", employees=" + employees +
                '}';
    }
}
