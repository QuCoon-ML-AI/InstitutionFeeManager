//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.175791500
package com.pwb.institutionFeeManager.repository.database

import com.pwb.institutionFeeManager.model.entity.payment
import com.pwb.institutionFeeManager.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.institutionFeeManager.repository.database.query.PaymentQuery
import org.springframework.stereotype.Repository



@Repository
interface PaymentRepository{
   	fun create(payment:payment):Long
	fun bulkCreate(payments:List<payment>)
	fun update(payment:payment):Int
	fun delete(paymentId:Int):Int
	fun truncate(): Boolean
	fun read():MutableList<payment>
	fun readByPaymentId(paymentId: Int):Payment?
	fun readByPaymentUserId(paymentUserId: Int):MutableList<Payment>
	fun readByPaymentFeeId(paymentFeeId: Int):MutableList<Payment>
	fun readByPaymentAmount(paymentAmount: String):MutableList<Payment>
	fun readByPaymentDate(paymentDate: String):MutableList<Payment>
	fun readByPaymentStatus(paymentStatus: String):MutableList<Payment>
	fun readByPaymentCreatedAt(paymentCreatedAt: String):MutableList<Payment>
	fun readByPaymentUpdatedAt(paymentUpdatedAt: String):MutableList<Payment>
}

@Repository
class PaymentRepositoryImpl(private val environment: Environment): PaymentRepository{
   	override fun create(payment:Payment):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(PaymentQuery.INSERT)
			.bind(payment)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(payments:List<payment>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(PaymentQuery.INSERT, false)
			for (payment in payments)
				query?.bind(payment)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(payment:Payment):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(PaymentQuery.UPDATE)
		.bind(payment)
		.executeUpdate().result
	}

	override fun delete(paymentId:Int):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(PaymentQuery.DELETE)
		.addParameter("paymentId", paymentId)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(PaymentQuery.TRUNCATE)
	}

	override fun read():MutableList<payment>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(PaymentQuery.READ)
		.executeAndFetch(payment::class.java)
	}

	override fun readByPaymentId(paymentId: Int):Payment?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(PaymentQuery.READ_BY_PAYMENT_ID)
				.addParameter("paymentId", paymentId)
				.executeAndFetch(Payment::class.java).firstOrNull()
	}

	override fun readByPaymentUserId(paymentUserId: Int):MutableList<Payment>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(PaymentQuery.READ_BY_PAYMENT_USER_ID)
				.addParameter("paymentUserId", paymentUserId)
				.executeAndFetch(Payment::class.java)
	}

	override fun readByPaymentFeeId(paymentFeeId: Int):MutableList<Payment>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(PaymentQuery.READ_BY_PAYMENT_FEE_ID)
				.addParameter("paymentFeeId", paymentFeeId)
				.executeAndFetch(Payment::class.java)
	}

	override fun readByPaymentAmount(paymentAmount: String):MutableList<Payment>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(PaymentQuery.READ_BY_PAYMENT_AMOUNT)
				.addParameter("paymentAmount", paymentAmount)
				.executeAndFetch(Payment::class.java)
	}

	override fun readByPaymentDate(paymentDate: String):MutableList<Payment>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(PaymentQuery.READ_BY_PAYMENT_DATE)
				.addParameter("paymentDate", paymentDate)
				.executeAndFetch(Payment::class.java)
	}

	override fun readByPaymentStatus(paymentStatus: String):MutableList<Payment>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(PaymentQuery.READ_BY_PAYMENT_STATUS)
				.addParameter("paymentStatus", paymentStatus)
				.executeAndFetch(Payment::class.java)
	}

	override fun readByPaymentCreatedAt(paymentCreatedAt: String):MutableList<Payment>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(PaymentQuery.READ_BY_PAYMENT_CREATED_AT)
				.addParameter("paymentCreatedAt", paymentCreatedAt)
				.executeAndFetch(Payment::class.java)
	}

	override fun readByPaymentUpdatedAt(paymentUpdatedAt: String):MutableList<Payment>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(PaymentQuery.READ_BY_PAYMENT_UPDATED_AT)
				.addParameter("paymentUpdatedAt", paymentUpdatedAt)
				.executeAndFetch(Payment::class.java)
	}
}
