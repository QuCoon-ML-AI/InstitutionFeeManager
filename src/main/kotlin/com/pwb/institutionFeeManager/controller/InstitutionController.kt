//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:58.879881600
package com.pwb.institutionFeeManager.controller

import com.pwb.institutionFeeManager.service.*
import org.pwb.utility.model.response.BaseResponse
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import com.pwb.institutionFeeManager.model.response.*
import com.pwb.institutionFeeManager.model.request.*
import org.pwb.utility.exception.BadRequestException
import org.pwb.utility.exception.ActivityAlreadyPerformedException
import org.pwb.utility.general.camelToSnakeCase
import org.pwb.utility.constant.*
import com.pwb.institutionFeeManager.utility.constant.*
import com.pwb.institutionFeeManager.utility.*
import org.pwb.utility.model.request.ModulePrivilege


@RestController
@RequestMapping("/{stage}/institution")
class InstitutionController(
	private val institutionService: InstitutionService,
	private val environment: Environment
){
   	@PostMapping("/create")
	fun create(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:InstitutionCreateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return institutionService.create(request)
	}

	@PostMapping("/bulk-create")
	fun bulkCreate(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:List<InstitutionCreateRequest>, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return institutionService.bulkCreate(request)
	}

	@PostMapping("/update")
	fun update(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:InstitutionUpdateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.UPDATE),
			authorization)
		return institutionService.update(request)
	}

	@PostMapping("/delete")
	fun delete(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:InstitutionDeleteRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.DELETE),
			authorization)
		return institutionService.delete(request)
	}

	@GetMapping("/read")
	fun read(@RequestHeader("Authorization") authorization:String, @PathVariable stage: String):institutionReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return institutionService.read()
	}

	@GetMapping("/read-by-institution-id/{institutionId}")
	fun readByInstitutionId(@RequestHeader("Authorization") authorization:String, @PathVariable institutionId:Int, @PathVariable stage: String):InstitutionReadSingleResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return institutionService.readByInstitutionId(institutionId)
	}

	@GetMapping("/read-by-institution-name/{institutionName}")
	fun readByInstitutionName(@RequestHeader("Authorization") authorization:String, @PathVariable institutionName:String, @PathVariable stage: String):InstitutionReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return institutionService.readByInstitutionName(institutionName)
	}

	@GetMapping("/read-by-institution-email/{institutionEmail}")
	fun readByInstitutionEmail(@RequestHeader("Authorization") authorization:String, @PathVariable institutionEmail:String, @PathVariable stage: String):InstitutionReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return institutionService.readByInstitutionEmail(institutionEmail)
	}

	@GetMapping("/read-by-institution-status/{institutionStatus}")
	fun readByInstitutionStatus(@RequestHeader("Authorization") authorization:String, @PathVariable institutionStatus:String, @PathVariable stage: String):InstitutionReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return institutionService.readByInstitutionStatus(institutionStatus)
	}

	@GetMapping("/read-by-institution-created-at/{institutionCreatedAt}")
	fun readByInstitutionCreatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable institutionCreatedAt:String, @PathVariable stage: String):InstitutionReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return institutionService.readByInstitutionCreatedAt(institutionCreatedAt)
	}

	@GetMapping("/read-by-institution-updated-at/{institutionUpdatedAt}")
	fun readByInstitutionUpdatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable institutionUpdatedAt:String, @PathVariable stage: String):InstitutionReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return institutionService.readByInstitutionUpdatedAt(institutionUpdatedAt)
	}

}
