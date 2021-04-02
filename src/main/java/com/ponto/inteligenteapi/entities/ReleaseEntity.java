package com.ponto.inteligenteapi.entities;

import com.ponto.inteligenteapi.enums.TypeEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "releases")
public class ReleaseEntity implements Serializable {

    private static final long serialVersionUID = 6524560251526772839L;

    private Long id;
    private Date date;
    private String location;
    private String description;
    private Date creationDate;
    private Date updateDate;
    private TypeEnum type;
    private EmployeeEntity employee;

    public ReleaseEntity() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "location", nullable = true)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "description", nullable = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "creationDate", nullable = false)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "updateDate", nullable = false)
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type", nullable = false)
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
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
        return "ReleaseEntity{" +
                "id=" + id +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", type=" + type +
                ", employee=" + employee +
                '}';
    }
}
