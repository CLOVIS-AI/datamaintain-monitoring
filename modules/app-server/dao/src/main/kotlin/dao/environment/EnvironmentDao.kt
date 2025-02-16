package dao.environment

import environment.*
import generated.domain.tables.references.DM_ENVIRONMENT
import org.jooq.DSLContext
import org.jooq.impl.DSL.defaultValue
import org.jooq.impl.DSL.`val`
import java.util.*

class EnvironmentDao(val dslContext: DSLContext): EnvironmentDaoInterface {
    override fun insert(data: EnvironmentCreationRequest): Environment =
        dslContext.insertInto(DM_ENVIRONMENT, DM_ENVIRONMENT.ID, DM_ENVIRONMENT.NAME, DM_ENVIRONMENT.FK_PROJECT_REF)
            .values(
                defaultValue(DM_ENVIRONMENT.ID),
                `val`(data.name),
                `val`(data.fkProjectRef)
            ).returningResult(DM_ENVIRONMENT.ID, DM_ENVIRONMENT.NAME, DM_ENVIRONMENT.FK_PROJECT_REF)
            .fetchSingleInto(Environment::class.java)

    override fun updateEnvironmentName(environmentId: UUID, updateRequest: EnvironmentNameUpdateRequest): Environment? =
        dslContext.update(DM_ENVIRONMENT)
            .set(DM_ENVIRONMENT.NAME, updateRequest.name)
            .where(DM_ENVIRONMENT.ID.eq(environmentId))
            .returningResult(DM_ENVIRONMENT.ID, DM_ENVIRONMENT.NAME, DM_ENVIRONMENT.FK_PROJECT_REF)
            .fetchOne()
            ?.into(Environment::class.java)

    override fun delete(id: UUID) {
        dslContext.delete(DM_ENVIRONMENT)
            .where(DM_ENVIRONMENT.ID.eq(id))
            .execute()
    }

    override fun findOneById(id: UUID): Environment? =
        dslContext.fetchOne(DM_ENVIRONMENT, DM_ENVIRONMENT.ID.eq(id))
            ?.into(Environment::class.java)
}