//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.107140500
package com.pwb.institutionFeeManager.model.response

import com.pwb.institutionFeeManager.model.entity.fee


data class FeeReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<fee>
)

data class FeeReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: fee
)
