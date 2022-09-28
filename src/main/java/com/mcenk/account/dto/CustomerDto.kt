package com.mcenk.account.dto

import com.mcenk.account.model.Account

data class CustomerDto(
// Normal customer bilgileri ile ayni bazen eklemeler ile cikarmalar yapilabilir

    val id:String?,
    val name: String?,
    val surname: String?,
    val account: Set<CustomerAccountDto>

)


