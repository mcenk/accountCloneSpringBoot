package com.mcenk.account.dto


import com.mcenk.account.model.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime


data class TransactionDto(

    val id:String?,
    val transactionType: TransactionType? = TransactionType.INITIAL,
    val amount: BigDecimal?,
    val transactionDateTime: LocalDateTime?,

){

}
