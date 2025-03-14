//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-14T13:42:58.879881600
package com.pwb.institutionFeeManager.repository.database

import com.pwb.institutionFeeManager.model.entity.institution
import com.pwb.institutionFeeManager.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.institutionFeeManager.repository.database.query.InstitutionQuery
import org.springframework.stereotype.Repository



@Repository
interface InstitutionRepository{
   	fun create(institution:institution):Long
	fun bulkCreate(institutions:List<institution>)
	fun update(institution:institution):Int
	fun delete(institutionId:Int):Int
	fun truncate(): Boolean
	fun read():MutableList<institution>
	fun readByInstitutionId(institutionId: Int):Institution?
	fun readByInstitutionName(institutionName: String):MutableList<Institution>
	fun readByInstitutionEmail(institutionEmail: String):MutableList<Institution>
	fun readByInstitutionStatus(institutionStatus: String):MutableList<Institution>
	fun readByInstitutionCreatedAt(institutionCreatedAt: String):MutableList<Institution>
	fun readByInstitutionUpdatedAt(institutionUpdatedAt: String):MutableList<Institution>
}

@Repository
class InstitutionRepositoryImpl(private val environment: Environment): InstitutionRepository{
   	override fun create(institution:Institution):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(InstitutionQuery.INSERT)
			.bind(institution)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(institutions:List<institution>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(InstitutionQuery.INSERT, false)
			for (institution in institutions)
				query?.bind(institution)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(institution:Institution):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(InstitutionQuery.UPDATE)
		.bind(institution)
		.executeUpdate().result
	}

	override fun delete(institutionId:Int):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(InstitutionQuery.DELETE)
		.addParameter("institutionId", institutionId)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(InstitutionQuery.TRUNCATE)
	}

	override fun read():MutableList<institution>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(InstitutionQuery.READ)
		.executeAndFetch(institution::class.java)
	}

	override fun readByInstitutionId(institutionId: Int):Institution?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(InstitutionQuery.READ_BY_INSTITUTION_ID)
				.addParameter("institutionId", institutionId)
				.executeAndFetch(Institution::class.java).firstOrNull()
	}

	override fun readByInstitutionName(institutionName: String):MutableList<Institution>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(InstitutionQuery.READ_BY_INSTITUTION_NAME)
				.addParameter("institutionName", institutionName)
				.executeAndFetch(Institution::class.java)
	}

	override fun readByInstitutionEmail(institutionEmail: String):MutableList<Institution>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(InstitutionQuery.READ_BY_INSTITUTION_EMAIL)
				.addParameter("institutionEmail", institutionEmail)
				.executeAndFetch(Institution::class.java)
	}

	override fun readByInstitutionStatus(institutionStatus: String):MutableList<Institution>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(InstitutionQuery.READ_BY_INSTITUTION_STATUS)
				.addParameter("institutionStatus", institutionStatus)
				.executeAndFetch(Institution::class.java)
	}

	override fun readByInstitutionCreatedAt(institutionCreatedAt: String):MutableList<Institution>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(InstitutionQuery.READ_BY_INSTITUTION_CREATED_AT)
				.addParameter("institutionCreatedAt", institutionCreatedAt)
				.executeAndFetch(Institution::class.java)
	}

	override fun readByInstitutionUpdatedAt(institutionUpdatedAt: String):MutableList<Institution>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(InstitutionQuery.READ_BY_INSTITUTION_UPDATED_AT)
				.addParameter("institutionUpdatedAt", institutionUpdatedAt)
				.executeAndFetch(Institution::class.java)
	}
}
