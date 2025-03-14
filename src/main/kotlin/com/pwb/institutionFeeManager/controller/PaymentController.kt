//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.175791500
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
@RequestMapping("/{stage}/payment")
class PaymentController(
	private val paymentService: PaymentService,
	private val environment: Environment
){
   	@PostMapping("/create")
	fun create(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:PaymentCreateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return paymentService.create(request)
	}

	@PostMapping("/bulk-create")
	fun bulkCreate(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:List<PaymentCreateRequest>, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return paymentService.bulkCreate(request)
	}

	@PostMapping("/update")
	fun update(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:PaymentUpdateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.UPDATE),
			authorization)
		return paymentService.update(request)
	}

	@PostMapping("/delete")
	fun delete(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:PaymentDeleteRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.DELETE),
			authorization)
		return paymentService.delete(request)
	}

	@GetMapping("/read")
	fun read(@RequestHeader("Authorization") authorization:String, @PathVariable stage: String):paymentReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return paymentService.read()
	}

	@GetMapping("/read-by-payment-id/{paymentId}")
	fun readByPaymentId(@RequestHeader("Authorization") authorization:String, @PathVariable paymentId:Int, @PathVariable stage: String):PaymentReadSingleResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return paymentService.readByPaymentId(paymentId)
	}

	@GetMapping("/read-by-payment-user-id/{paymentUserId}")
	fun readByPaymentUserId(@RequestHeader("Authorization") authorization:String, @PathVariable paymentUserId:Int, @PathVariable stage: String):PaymentReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return paymentService.readByPaymentUserId(paymentUserId)
	}

	@GetMapping("/read-by-payment-fee-id/{paymentFeeId}")
	fun readByPaymentFeeId(@RequestHeader("Authorization") authorization:String, @PathVariable paymentFeeId:Int, @PathVariable stage: String):PaymentReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return paymentService.readByPaymentFeeId(paymentFeeId)
	}

	@GetMapping("/read-by-payment-amount/{paymentAmount}")
	fun readByPaymentAmount(@RequestHeader("Authorization") authorization:String, @PathVariable paymentAmount:String, @PathVariable stage: String):PaymentReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return paymentService.readByPaymentAmount(paymentAmount)
	}

	@GetMapping("/read-by-payment-date/{paymentDate}")
	fun readByPaymentDate(@RequestHeader("Authorization") authorization:String, @PathVariable paymentDate:String, @PathVariable stage: String):PaymentReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return paymentService.readByPaymentDate(paymentDate)
	}

	@GetMapping("/read-by-payment-status/{paymentStatus}")
	fun readByPaymentStatus(@RequestHeader("Authorization") authorization:String, @PathVariable paymentStatus:String, @PathVariable stage: String):PaymentReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return paymentService.readByPaymentStatus(paymentStatus)
	}

	@GetMapping("/read-by-payment-created-at/{paymentCreatedAt}")
	fun readByPaymentCreatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable paymentCreatedAt:String, @PathVariable stage: String):PaymentReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return paymentService.readByPaymentCreatedAt(paymentCreatedAt)
	}

	@GetMapping("/read-by-payment-updated-at/{paymentUpdatedAt}")
	fun readByPaymentUpdatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable paymentUpdatedAt:String, @PathVariable stage: String):PaymentReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return paymentService.readByPaymentUpdatedAt(paymentUpdatedAt)
	}

}
