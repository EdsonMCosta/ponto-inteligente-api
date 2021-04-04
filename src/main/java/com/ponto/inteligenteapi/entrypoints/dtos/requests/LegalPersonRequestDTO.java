package com.ponto.inteligenteapi.entrypoints.dtos.requests;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * LegalPersonRequestDTO
 *
 * @author : Edson Costa
 * @since : 04/04/2021
 **/
public class LegalPersonRequestDTO {

    private Long id;

    @NotEmpty(message = "Name should not be empty.")
    @Length(min = 3, max = 200, message = "Name should contain between 3 and 200 characters.")
    private String name;

    @Email(message = "Invalid e-mail.")
    @NotEmpty(message = "E-mail should not be empty.")
    @Length(min = 5, max = 200, message = "E-mail should contain between 5 and 200 characters.")
    private String email;

    @NotEmpty(message = "Password should not be empty.")
    private String password;

    @CPF(message = "Invalid CPF.")
    @NotEmpty(message = "CPF should not be empty.")
    private String cpf;

    @NotEmpty(message = "Company Name should not be empty.")
    private String companyName;

    @CNPJ(message = "Invalid CNPJ")
    @NotEmpty(message = "CNPJ should not be empty.")
    private String cnpj;

    public LegalPersonRequestDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "LegalPersonRequestDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cpf='" + cpf + '\'' +
                ", companyName='" + companyName + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
