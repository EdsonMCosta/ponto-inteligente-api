package com.ponto.inteligenteapi.entities;

import com.ponto.inteligenteapi.enums.ProfileEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "employees")
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = -5754246207015712518L;

    private Long id;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private BigDecimal valueHour;
    private Float numberHoursWorkedPerDay;
    private Float numberHoursLunch;
    private ProfileEnum profile;
    private Date creationDate;
    private Date updateDate;
    private CompanyEntity company;
    private List<ReleaseEntity> release;

    public EmployeeEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "cpf", nullable = false)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(name = "valueHour", nullable = false)
    public BigDecimal getValueHour() {
        return valueHour;
    }

    @Transient
    public Optional<BigDecimal> getValueHourOpt() {
        return Optional.ofNullable(valueHour);
    }

    public void setValueHour(BigDecimal valueHour) {
        this.valueHour = valueHour;
    }

    @Column(name = "number_hours_worked_day", nullable = true)
    public Float getNumberHoursWorkedPerDay() {
        return numberHoursWorkedPerDay;
    }

    @Transient
    public Optional<Float> getNumberHoursWorkedPerDayOpt() {
        return Optional.ofNullable(numberHoursWorkedPerDay);
    }

    public void setNumberHoursWorkedPerDay(Float numberHoursWorkedPerDay) {
        this.numberHoursWorkedPerDay = numberHoursWorkedPerDay;
    }

    @Column(name = "number_hours_lunch")
    public Float getNumberHoursLunch() {
        return numberHoursLunch;
    }

    @Transient
    public Optional<Float> getNumberHoursLunchOpt() {
        return getNumberHoursLunchOpt();
    }

    public void setNumberHoursLunch(Float numberHoursLunch) {
        this.numberHoursLunch = numberHoursLunch;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "profile", nullable = false)
    public ProfileEnum getProfile() {
        return profile;
    }

    public void setProfile(ProfileEnum profile) {
        this.profile = profile;
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

    @ManyToOne(fetch = FetchType.EAGER)
    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<ReleaseEntity> getRelease() {
        return release;
    }

    public void setRelease(List<ReleaseEntity> release) {
        this.release = release;
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
        return "EmployeeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cpf='" + cpf + '\'' +
                ", valueHour=" + valueHour +
                ", numberHoursWorkedPerDay=" + numberHoursWorkedPerDay +
                ", numberHoursLunch=" + numberHoursLunch +
                ", profile=" + profile +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", company=" + company +
                ", release=" + release +
                '}';
    }
}
