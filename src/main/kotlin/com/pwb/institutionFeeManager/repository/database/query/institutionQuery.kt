//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:58.879881600
package com.pwb.institutionFeeManager.repository.database.query

import com.pwb.institutionFeeManager.utility.constant.PrefixConstant


object institutionQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}INSTITUTION(
			institutionName,
			institutionEmail,
			institutionStatus,
			institutionCreatedAt,
			institutionUpdatedAt
		) VALUES (
			:institutionName,
			:institutionEmail,
			COALESCE(:institutionStatus,'ACTIVE'),
			COALESCE(:institutionCreatedAt,getdate()),
			COALESCE(:institutionUpdatedAt,getdate())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}INSTITUTION SET
			institutionName=:institutionName,
			institutionEmail=:institutionEmail,
			institutionStatus=:institutionStatus,
			institutionCreatedAt=:institutionCreatedAt,
			institutionUpdatedAt=GETDATE()
		WHERE institutionId=:institutionId
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}INSTITUTION SET institutionStatus = 'DELETED', institutionUpdatedAt = GETDATE()
		WHERE institutionId=:institutionId
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}INSTITUTION 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}INSTITUTION WHERE institutionStatus<>'DELETED'
	"""

	const val READ_BY_INSTITUTION_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}INSTITUTION WHERE institutionId=:institutionId AND institutionStatus<>'DELETED'
	"""

	const val READ_BY_INSTITUTION_NAME = """
		SELECT * FROM ${PrefixConstant.ENTITY}INSTITUTION WHERE institutionName=:institutionName AND institutionStatus<>'DELETED'
	"""

	const val READ_BY_INSTITUTION_EMAIL = """
		SELECT * FROM ${PrefixConstant.ENTITY}INSTITUTION WHERE institutionEmail=:institutionEmail AND institutionStatus<>'DELETED'
	"""

	const val READ_BY_INSTITUTION_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}INSTITUTION WHERE institutionStatus=:institutionStatus AND institutionStatus<>'DELETED'
	"""

	const val READ_BY_INSTITUTION_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}INSTITUTION WHERE institutionCreatedAt=:institutionCreatedAt AND institutionStatus<>'DELETED'
	"""

	const val READ_BY_INSTITUTION_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}INSTITUTION WHERE institutionUpdatedAt=:institutionUpdatedAt AND institutionStatus<>'DELETED'
	"""
}
