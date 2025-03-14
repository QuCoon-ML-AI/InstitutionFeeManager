//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.107140500
package com.pwb.institutionFeeManager.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class fee(
   	@Column(type="VARCHAR(n)", defaultValue="ACTIVE",length=50)
	var feeStatus: String?=null,
	@Column(type="DATETIME", defaultValue="GETDATE()",length=50)
	var feeCreatedAt: String?=null,
	@Column(type="DATETIME", defaultValue="GETDATE()",length=50)
	var feeUpdatedAt: String?=null
)
