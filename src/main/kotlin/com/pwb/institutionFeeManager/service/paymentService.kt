//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.175791500
package com.pwb.institutionFeeManager.service

import com.pwb.institutionFeeManager.repository.database.paymentRepository
import com.pwb.institutionFeeManager.model.entity.payment
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.institutionFeeManager.model.response.*
import com.pwb.institutionFeeManager.model.request.*
import org.pwb.utility.exception.*


@Service
class PaymentService(
   private val paymentRepository: PaymentRepository
){
   	fun create(request:PaymentCreateRequest):BaseResponse{
		val payment = GSON.fromJson(GSON.toJson(request), Payment::class.java).apply { paymentStatus = paymentStatus?:"ACTIVE" }
		paymentRepository.create(payment)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<PaymentCreateRequest>):BaseResponse{
		val payments = GSON.fromJson(GSON.toJson(request), Array<Payment>::class.java).toList()
		paymentRepository.bulkCreate(payments)
		return ResponseConstant.SUCCESS
	}

	fun update(request:PaymentUpdateRequest):BaseResponse{
		var payment = paymentRepository.readByPaymentId(request.paymentId!!)
			?:throw UnableToLocateRecordException()
		payment = payment.apply{
				paymentId = request.paymentId?:paymentId
				paymentUserId = request.paymentUserId?:paymentUserId
				paymentFeeId = request.paymentFeeId?:paymentFeeId
				paymentAmount = request.paymentAmount?:paymentAmount
				paymentDate = request.paymentDate?:paymentDate
				paymentStatus = request.paymentStatus?:paymentStatus
			}
		paymentRepository.update(payment)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:PaymentDeleteRequest):BaseResponse{
		var updateResponse = paymentRepository.delete(request.paymentId!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():paymentReadListResponse{
		var payment = paymentRepository.read()
		return paymentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = payment
		)
	}

	fun readByPaymentId(paymentId:Int): PaymentReadSingleResponse{
		var payment = paymentRepository.readByPaymentId(paymentId) 
			?: throw UnableToLocateRecordException()
		return PaymentReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = payment
		)
	}

	fun readByPaymentUserId(paymentUserId:Int): PaymentReadListResponse{
		var payment = paymentRepository.readByPaymentUserId(paymentUserId) 
		return PaymentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = payment
		)
	}

	fun readByPaymentFeeId(paymentFeeId:Int): PaymentReadListResponse{
		var payment = paymentRepository.readByPaymentFeeId(paymentFeeId) 
		return PaymentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = payment
		)
	}

	fun readByPaymentAmount(paymentAmount:String): PaymentReadListResponse{
		var payment = paymentRepository.readByPaymentAmount(paymentAmount) 
		return PaymentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = payment
		)
	}

	fun readByPaymentDate(paymentDate:String): PaymentReadListResponse{
		var payment = paymentRepository.readByPaymentDate(paymentDate) 
		return PaymentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = payment
		)
	}

	fun readByPaymentStatus(paymentStatus:String): PaymentReadListResponse{
		var payment = paymentRepository.readByPaymentStatus(paymentStatus) 
		return PaymentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = payment
		)
	}

	fun readByPaymentCreatedAt(paymentCreatedAt:String): PaymentReadListResponse{
		var payment = paymentRepository.readByPaymentCreatedAt(paymentCreatedAt) 
		return PaymentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = payment
		)
	}

	fun readByPaymentUpdatedAt(paymentUpdatedAt:String): PaymentReadListResponse{
		var payment = paymentRepository.readByPaymentUpdatedAt(paymentUpdatedAt) 
		return PaymentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = payment
		)
	}

}
