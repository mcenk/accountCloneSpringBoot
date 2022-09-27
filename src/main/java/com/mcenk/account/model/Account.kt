package com.mcenk.account.model

import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Account(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator)")
    val id:String?,
    val balance: BigDecimal?= BigDecimal.ZERO,
    val creationDate:LocalDateTime,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL]) // customer uzerinde yapilan islemde account uzerinde de gerceklessin
    @JoinColumn(name="customer_id", nullable = false)
    val customer: Customer?,

    // ? javadaki optionala denk geliyor bu alan bos olabilir demek
    // kotlin birden fazla const olusturuyor sonra uygun olani kullaniyor


    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    val transaction: Set<Transaction>?


)

{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Account

        if (id != other.id) return false
        if (balance != other.balance) return false
        if (creationDate != other.creationDate) return false
        if (customer != other.customer) return false
        if (transaction != other.transaction) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (balance?.hashCode() ?: 0)
        result = 31 * result + creationDate.hashCode()
        result = 31 * result + (customer?.hashCode() ?: 0)
        result = 31 * result + (transaction?.hashCode() ?: 0)
        return result
    }
}
