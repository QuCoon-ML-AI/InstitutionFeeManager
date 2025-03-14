//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.175791500
package com.pwb.institutionFeeManager.model.response

import com.pwb.institutionFeeManager.model.entity.payment


data class PaymentReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<payment>
)

data class PaymentReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: payment
)
