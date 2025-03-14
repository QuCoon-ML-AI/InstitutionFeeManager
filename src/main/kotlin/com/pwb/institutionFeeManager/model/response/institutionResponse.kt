//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:58.879881600
package com.pwb.institutionFeeManager.model.response

import com.pwb.institutionFeeManager.model.entity.institution


data class InstitutionReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<institution>
)

data class InstitutionReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: institution
)
