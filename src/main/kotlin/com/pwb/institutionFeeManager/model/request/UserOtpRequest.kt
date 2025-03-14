//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.191590700
package com.pwb.institutionFeeManager.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class UserOtpCreateRequest(
   	@get: NotEmpty(message = "userOtpUsername is required")
	var userOtpUsername: String?=null,
	@get: NotEmpty(message = "userOtpOtp is required")
	var userOtpOtp: String?=null,
	@get: NotEmpty(message = "userOtpStatus is required")
	var userOtpStatus: String?=null
)

data class UserOtpUpdateRequest(
   	@get: NotNull(message = "userOtpId is required")
	var userOtpId: Int?=null,
	var userOtpUsername: String?=null,
	var userOtpOtp: String?=null,
	var userOtpStatus: String?=null
)

data class UserOtpReadRequest(
   	var userOtpId: Int?=null,
	var userOtpUsername: String?=null,
	var userOtpOtp: String?=null,
	var userOtpStatus: String?=null,
	var userOtpCreatedAt: String?=null,
	var userOtpUpdatedAt: String?=null
)

data class UserOtpDeleteRequest(
   	@get: NotNull(message = "userOtpId is required")
	var userOtpId: Int?=null
)
