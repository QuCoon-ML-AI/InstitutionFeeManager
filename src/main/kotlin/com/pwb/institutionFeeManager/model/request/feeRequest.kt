//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.107140500
package com.pwb.institutionFeeManager.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class FeeCreateRequest(
   	var feeStatus: String?=null
)

data class FeeUpdateRequest(
   	var feeStatus: String?=null
)

data class FeeReadRequest(
   	var feeStatus: String?=null,
	var feeCreatedAt: String?=null,
	var feeUpdatedAt: String?=null
)

data class FeeDeleteRequest(
   	var feeStatus: String?=null
)
