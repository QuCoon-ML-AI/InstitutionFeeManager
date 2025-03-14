//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.191590700
package com.pwb.institutionFeeManager.model.response

import com.pwb.institutionFeeManager.model.entity.UserOtp


data class UserOtpReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<UserOtp>
)

data class UserOtpReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: UserOtp
)
