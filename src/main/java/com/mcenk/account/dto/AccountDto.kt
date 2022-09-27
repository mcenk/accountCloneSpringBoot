package com.mcenk.account.dto

import com.mcenk.account.model.Customer
import com.mcenk.account.model.Transaction
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.FetchType
import javax.persistence.OneToMany

data class AccountDto(
    val id:String?,
    val balance: BigDecimal?,
    val creationDate: LocalDateTime,
    val customer: AccountCustomerDto?,
    val transaction: Set<TransactionDto>? // DTO konusuna detayli bak


)
