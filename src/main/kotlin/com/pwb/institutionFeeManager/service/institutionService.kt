//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:58.879881600
package com.pwb.institutionFeeManager.service

import com.pwb.institutionFeeManager.repository.database.institutionRepository
import com.pwb.institutionFeeManager.model.entity.institution
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.institutionFeeManager.model.response.*
import com.pwb.institutionFeeManager.model.request.*
import org.pwb.utility.exception.*


@Service
class InstitutionService(
   private val institutionRepository: InstitutionRepository
){
   	fun create(request:InstitutionCreateRequest):BaseResponse{
		val institution = GSON.fromJson(GSON.toJson(request), Institution::class.java).apply { institutionStatus = institutionStatus?:"ACTIVE" }
		institutionRepository.create(institution)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<InstitutionCreateRequest>):BaseResponse{
		val institutions = GSON.fromJson(GSON.toJson(request), Array<Institution>::class.java).toList()
		institutionRepository.bulkCreate(institutions)
		return ResponseConstant.SUCCESS
	}

	fun update(request:InstitutionUpdateRequest):BaseResponse{
		var institution = institutionRepository.readByInstitutionId(request.institutionId!!)
			?:throw UnableToLocateRecordException()
		institution = institution.apply{
				institutionId = request.institutionId?:institutionId
				institutionName = request.institutionName?:institutionName
				institutionEmail = request.institutionEmail?:institutionEmail
				institutionStatus = request.institutionStatus?:institutionStatus
			}
		institutionRepository.update(institution)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:InstitutionDeleteRequest):BaseResponse{
		var updateResponse = institutionRepository.delete(request.institutionId!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():institutionReadListResponse{
		var institution = institutionRepository.read()
		return institutionReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = institution
		)
	}

	fun readByInstitutionId(institutionId:Int): InstitutionReadSingleResponse{
		var institution = institutionRepository.readByInstitutionId(institutionId) 
			?: throw UnableToLocateRecordException()
		return InstitutionReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = institution
		)
	}

	fun readByInstitutionName(institutionName:String): InstitutionReadListResponse{
		var institution = institutionRepository.readByInstitutionName(institutionName) 
		return InstitutionReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = institution
		)
	}

	fun readByInstitutionEmail(institutionEmail:String): InstitutionReadListResponse{
		var institution = institutionRepository.readByInstitutionEmail(institutionEmail) 
		return InstitutionReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = institution
		)
	}

	fun readByInstitutionStatus(institutionStatus:String): InstitutionReadListResponse{
		var institution = institutionRepository.readByInstitutionStatus(institutionStatus) 
		return InstitutionReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = institution
		)
	}

	fun readByInstitutionCreatedAt(institutionCreatedAt:String): InstitutionReadListResponse{
		var institution = institutionRepository.readByInstitutionCreatedAt(institutionCreatedAt) 
		return InstitutionReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = institution
		)
	}

	fun readByInstitutionUpdatedAt(institutionUpdatedAt:String): InstitutionReadListResponse{
		var institution = institutionRepository.readByInstitutionUpdatedAt(institutionUpdatedAt) 
		return InstitutionReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = institution
		)
	}

}
