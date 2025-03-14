//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.239756300
package com.pwb.institutionFeeManager.model.response

import com.pwb.institutionFeeManager.model.entity.RolePrivilege


data class RolePrivilegeReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<RolePrivilege>
)

data class RolePrivilegeReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: RolePrivilege
)
