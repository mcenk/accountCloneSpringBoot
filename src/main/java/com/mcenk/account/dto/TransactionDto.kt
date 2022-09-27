package com.mcenk.account.dto

import com.mcenk.account.model.Account
import com.mcenk.account.model.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.CascadeType
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

data class TransactionDto(

    val id:String?,
    val transactionType: TransactionType? = TransactionType.INITIAL,
    val amount: BigDecimal?,
    val transactionDateTime: LocalDateTime?,

){

}
