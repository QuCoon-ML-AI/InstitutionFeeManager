//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.107140500
package com.pwb.institutionFeeManager.repository.database.query

import com.pwb.institutionFeeManager.utility.constant.PrefixConstant


object feeQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}FEE(
			feeStatus,
			feeCreatedAt,
			feeUpdatedAt
		) VALUES (
			COALESCE(:feeStatus,ACTIVE),
			COALESCE(:feeCreatedAt,GETDATE()),
			COALESCE(:feeUpdatedAt,GETDATE())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}FEE SET
			feeCreatedAt=:feeCreatedAt,
			feeUpdatedAt=GETDATE()
		WHERE feeStatus=:feeStatus
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}FEE SET feeStatus = 'DELETED', feeUpdatedAt = GETDATE()
		WHERE feeStatus=:feeStatus
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}FEE 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}FEE WHERE feeStatus<>'DELETED'
	"""

	const val READ_BY_FEE_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}FEE WHERE feeStatus=:feeStatus AND feeStatus<>'DELETED'
	"""

	const val READ_BY_FEE_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}FEE WHERE feeCreatedAt=:feeCreatedAt AND feeStatus<>'DELETED'
	"""

	const val READ_BY_FEE_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}FEE WHERE feeUpdatedAt=:feeUpdatedAt AND feeStatus<>'DELETED'
	"""
}
