//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.271708100
package com.pwb.institutionFeeManager.model.response

import com.pwb.institutionFeeManager.model.entity.AuditLog


data class AuditLogReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<AuditLog>
)

data class AuditLogReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: AuditLog
)
