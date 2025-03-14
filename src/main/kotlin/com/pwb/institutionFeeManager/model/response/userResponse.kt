//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.027437500
package com.pwb.institutionFeeManager.model.response

import com.pwb.institutionFeeManager.model.entity.user


data class UserReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<user>
)

data class UserReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: user
)
