//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.207795700
package com.pwb.institutionFeeManager.model.response

import com.pwb.institutionFeeManager.model.entity.LoginHistory


data class LoginHistoryReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<LoginHistory>
)

data class LoginHistoryReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: LoginHistory
)
