//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.232161500
package com.pwb.institutionFeeManager.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class Role(
   	@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1,defaultValue="100")
	var roleId: Int?=null,
	@Column(type="VARCHAR(n)", length=100)
	var roleName: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var roleDescription: String?=null,
	@Column(type="VARCHAR(n)", defaultValue="'YES'",length=3)
	var roleIsPublic: String?=null,
	@Column(type="VARCHAR(n)", defaultValue="'ACTIVE'",length=100)
	var roleStatus: String?=null,
	@Column(type="DATETIME", defaultValue="getdate()")
	var roleCreatedAt: String?=null,
	@Column(type="DATETIME", defaultValue="getdate()")
	var roleUpdatedAt: String?=null
)
