//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:58.879881600
package com.pwb.institutionFeeManager.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class InstitutionCreateRequest(
   	@get: NotEmpty(message = "institutionName is required")
	var institutionName: String?=null,
	@get: NotEmpty(message = "institutionEmail is required")
	var institutionEmail: String?=null
)

data class InstitutionUpdateRequest(
   	@get: NotNull(message = "institutionId is required")
	var institutionId: Int?=null,
	var institutionName: String?=null,
	var institutionEmail: String?=null,
	var institutionStatus: String?=null
)

data class InstitutionReadRequest(
   	var institutionId: Int?=null,
	var institutionName: String?=null,
	var institutionEmail: String?=null,
	var institutionStatus: String?=null,
	var institutionCreatedAt: String?=null,
	var institutionUpdatedAt: String?=null
)

data class InstitutionDeleteRequest(
   	@get: NotNull(message = "institutionId is required")
	var institutionId: Int?=null
)
