package dao.environment

import environment.EnvironmentCreationRequest
import environment.EnvironmentNameUpdateRequest
import generated.domain.tables.pojos.DmEnvironment
import generated.domain.tables.references.DM_ENVIRONMENT
import org.jooq.DSLContext
import org.jooq.impl.DSL.defaultValue
import org.jooq.impl.DSL.`val`
import java.util.*

class EnvironmentDao(val dslContext: DSLContext) {
    fun insert(data: EnvironmentCreationRequest): DmEnvironment =
        dslContext.insertInto(DM_ENVIRONMENT, DM_ENVIRONMENT.ID, DM_ENVIRONMENT.NAME, DM_ENVIRONMENT.FK_PROJECT_REF)
            .values(
                defaultValue(DM_ENVIRONMENT.ID),
                `val`(data.name),
                `val`(data.fkProjectRef)
            ).returningResult(DM_ENVIRONMENT.ID, DM_ENVIRONMENT.NAME, DM_ENVIRONMENT.FK_PROJECT_REF)
            .fetchSingleInto(DmEnvironment::class.java)

    fun updateEnvironmentName(environmentId: UUID, updateRequest: EnvironmentNameUpdateRequest): DmEnvironment? =
        dslContext.update(DM_ENVIRONMENT)
            .set(DM_ENVIRONMENT.NAME, updateRequest.name)
            .where(DM_ENVIRONMENT.ID.eq(environmentId))
            .returningResult(DM_ENVIRONMENT.ID, DM_ENVIRONMENT.NAME, DM_ENVIRONMENT.FK_PROJECT_REF)
            .fetchOne()
            ?.into(DmEnvironment::class.java)

    fun delete(id: UUID) {
        dslContext.delete(DM_ENVIRONMENT)
            .where(DM_ENVIRONMENT.ID.eq(id))
            .execute()
    }

    fun findOneById(id: UUID): DmEnvironment? =
        dslContext.fetchOne(DM_ENVIRONMENT, DM_ENVIRONMENT.ID.eq(id))
            ?.into(DmEnvironment::class.java)
}