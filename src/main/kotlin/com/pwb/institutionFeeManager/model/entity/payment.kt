//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.175791500
package com.pwb.institutionFeeManager.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class payment(
   	@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1,defaultValue="100")
	var paymentId: Int?=null,
	@Column(type="INT", nullable=true,foreignKey=true,reference="USER(userId)")
	var paymentUserId: Int?=null,
	@Column(type="INT", nullable=true,foreignKey=true,reference="FEE(feeId)")
	var paymentFeeId: Int?=null,
	@Column(type="VARCHAR(n)", nullable=true)
	var paymentAmount: String?=null,
	@Column(type="DATETIME", nullable=true)
	var paymentDate: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,defaultValue="'ACTIVE'",length=100)
	var paymentStatus: String?=null,
	@Column(type="DATETIME", nullable=true,defaultValue="getdate()")
	var paymentCreatedAt: String?=null,
	@Column(type="DATETIME", nullable=true,defaultValue="getdate()")
	var paymentUpdatedAt: String?=null
)
