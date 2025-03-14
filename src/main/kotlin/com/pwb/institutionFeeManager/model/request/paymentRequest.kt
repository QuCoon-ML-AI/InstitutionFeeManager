//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.175791500
package com.pwb.institutionFeeManager.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class PaymentCreateRequest(
   	@get: NotNull(message = "paymentUserId is required")
	var paymentUserId: Int?=null,
	@get: NotNull(message = "paymentFeeId is required")
	var paymentFeeId: Int?=null,
	@get: NotEmpty(message = "paymentAmount is required")
	var paymentAmount: String?=null,
	@get: NotEmpty(message = "paymentDate is required")
	var paymentDate: String?=null
)

data class PaymentUpdateRequest(
   	@get: NotNull(message = "paymentId is required")
	var paymentId: Int?=null,
	var paymentUserId: Int?=null,
	var paymentFeeId: Int?=null,
	var paymentAmount: String?=null,
	var paymentDate: String?=null,
	var paymentStatus: String?=null
)

data class PaymentReadRequest(
   	var paymentId: Int?=null,
	var paymentUserId: Int?=null,
	var paymentFeeId: Int?=null,
	var paymentAmount: String?=null,
	var paymentDate: String?=null,
	var paymentStatus: String?=null,
	var paymentCreatedAt: String?=null,
	var paymentUpdatedAt: String?=null
)

data class PaymentDeleteRequest(
   	@get: NotNull(message = "paymentId is required")
	var paymentId: Int?=null
)
