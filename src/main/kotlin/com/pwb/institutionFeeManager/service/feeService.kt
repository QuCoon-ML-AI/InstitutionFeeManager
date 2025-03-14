//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.107140500
package com.pwb.institutionFeeManager.service

import com.pwb.institutionFeeManager.repository.database.feeRepository
import com.pwb.institutionFeeManager.model.entity.fee
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.institutionFeeManager.model.response.*
import com.pwb.institutionFeeManager.model.request.*
import org.pwb.utility.exception.*


@Service
class FeeService(
   private val feeRepository: FeeRepository
){
   	fun create(request:FeeCreateRequest):BaseResponse{
		val fee = GSON.fromJson(GSON.toJson(request), Fee::class.java).apply { feeStatus = feeStatus?:"ACTIVE" }
		feeRepository.create(fee)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<FeeCreateRequest>):BaseResponse{
		val fees = GSON.fromJson(GSON.toJson(request), Array<Fee>::class.java).toList()
		feeRepository.bulkCreate(fees)
		return ResponseConstant.SUCCESS
	}

	fun update(request:FeeUpdateRequest):BaseResponse{
		var fee = feeRepository.readByFeeStatus(request.feeStatus!!)
			?:throw UnableToLocateRecordException()
		fee = fee.apply{
				feeStatus = request.feeStatus?:feeStatus
			}
		feeRepository.update(fee)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:FeeDeleteRequest):BaseResponse{
		var updateResponse = feeRepository.delete(request.feeStatus!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():feeReadListResponse{
		var fee = feeRepository.read()
		return feeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = fee
		)
	}

	fun readByFeeStatus(feeStatus:String): FeeReadSingleResponse{
		var fee = feeRepository.readByFeeStatus(feeStatus) 
			?: throw UnableToLocateRecordException()
		return FeeReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = fee
		)
	}

	fun readByFeeCreatedAt(feeCreatedAt:String): FeeReadListResponse{
		var fee = feeRepository.readByFeeCreatedAt(feeCreatedAt) 
		return FeeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = fee
		)
	}

	fun readByFeeUpdatedAt(feeUpdatedAt:String): FeeReadListResponse{
		var fee = feeRepository.readByFeeUpdatedAt(feeUpdatedAt) 
		return FeeReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = fee
		)
	}

}
