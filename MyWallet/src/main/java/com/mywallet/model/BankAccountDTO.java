package com.mywallet.model;

import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BankAccountDTO {

    @Id
    private Integer accountNumber;
    @NotNull
    private String bankName;
    @NotNull
    private String IFSCCode;
    @NotNull
    private double balance;

}
