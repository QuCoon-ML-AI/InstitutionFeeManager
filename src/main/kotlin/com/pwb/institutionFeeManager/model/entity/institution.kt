//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:58.864077700
package com.pwb.institutionFeeManager.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class institution(
   	@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1,defaultValue="100")
	var institutionId: Int?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var institutionName: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var institutionEmail: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,defaultValue="'ACTIVE'",length=100)
	var institutionStatus: String?=null,
	@Column(type="DATETIME", nullable=true,defaultValue="getdate()")
	var institutionCreatedAt: String?=null,
	@Column(type="DATETIME", nullable=true,defaultValue="getdate()")
	var institutionUpdatedAt: String?=null
)
