package com.mcenk.account.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class CustomerAccountDto(
    val id:String?,
    val balance: BigDecimal?,
    val creationDate: LocalDateTime,
    val transaction: Set<TransactionDto>? // DTO konusuna detayli bak

)
