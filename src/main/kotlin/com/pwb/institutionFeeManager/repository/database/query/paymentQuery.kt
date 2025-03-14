//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:59.175791500
package com.pwb.institutionFeeManager.repository.database.query

import com.pwb.institutionFeeManager.utility.constant.PrefixConstant


object paymentQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}PAYMENT(
			paymentUserId,
			paymentFeeId,
			paymentAmount,
			paymentDate,
			paymentStatus,
			paymentCreatedAt,
			paymentUpdatedAt
		) VALUES (
			:paymentUserId,
			:paymentFeeId,
			:paymentAmount,
			:paymentDate,
			COALESCE(:paymentStatus,'ACTIVE'),
			COALESCE(:paymentCreatedAt,getdate()),
			COALESCE(:paymentUpdatedAt,getdate())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}PAYMENT SET
			paymentUserId=:paymentUserId,
			paymentFeeId=:paymentFeeId,
			paymentAmount=:paymentAmount,
			paymentDate=:paymentDate,
			paymentStatus=:paymentStatus,
			paymentCreatedAt=:paymentCreatedAt,
			paymentUpdatedAt=GETDATE()
		WHERE paymentId=:paymentId
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}PAYMENT SET paymentStatus = 'DELETED', paymentUpdatedAt = GETDATE()
		WHERE paymentId=:paymentId
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}PAYMENT 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}PAYMENT WHERE paymentStatus<>'DELETED'
	"""

	const val READ_BY_PAYMENT_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}PAYMENT WHERE paymentId=:paymentId AND paymentStatus<>'DELETED'
	"""

	const val READ_BY_PAYMENT_USER_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}PAYMENT WHERE paymentUserId=:paymentUserId AND paymentStatus<>'DELETED'
	"""

	const val READ_BY_PAYMENT_FEE_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}PAYMENT WHERE paymentFeeId=:paymentFeeId AND paymentStatus<>'DELETED'
	"""

	const val READ_BY_PAYMENT_AMOUNT = """
		SELECT * FROM ${PrefixConstant.ENTITY}PAYMENT WHERE paymentAmount=:paymentAmount AND paymentStatus<>'DELETED'
	"""

	const val READ_BY_PAYMENT_DATE = """
		SELECT * FROM ${PrefixConstant.ENTITY}PAYMENT WHERE paymentDate=:paymentDate AND paymentStatus<>'DELETED'
	"""

	const val READ_BY_PAYMENT_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}PAYMENT WHERE paymentStatus=:paymentStatus AND paymentStatus<>'DELETED'
	"""

	const val READ_BY_PAYMENT_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}PAYMENT WHERE paymentCreatedAt=:paymentCreatedAt AND paymentStatus<>'DELETED'
	"""

	const val READ_BY_PAYMENT_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}PAYMENT WHERE paymentUpdatedAt=:paymentUpdatedAt AND paymentStatus<>'DELETED'
	"""
}
