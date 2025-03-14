//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.191590700
package com.pwb.institutionFeeManager.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class UserOtp(
   	@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1,defaultValue="100")
	var userOtpId: Int?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var userOtpUsername: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var userOtpOtp: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,defaultValue="'ACTIVE'",length=100)
	var userOtpStatus: String?=null,
	@Column(type="DATETIME", defaultValue="getdate()")
	var userOtpCreatedAt: String?=null,
	@Column(type="DATETIME", defaultValue="getdate()")
	var userOtpUpdatedAt: String?=null
)
