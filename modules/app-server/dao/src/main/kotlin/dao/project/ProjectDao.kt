package dao.project

import generated.domain.tables.references.DM_PROJECT
import org.jooq.DSLContext
import org.jooq.impl.DSL.defaultValue
import org.jooq.impl.DSL.`val`
import project.Project
import project.ProjectCreationRequest
import project.ProjectDaoInterface
import project.ProjectNameUpdateRequest
import java.util.*

class ProjectDao(val dslContext: DSLContext) : ProjectDaoInterface {
    override fun insert(data: ProjectCreationRequest): Project =
        dslContext.insertInto(DM_PROJECT, DM_PROJECT.ID, DM_PROJECT.NAME)
            .values(
                defaultValue(DM_PROJECT.ID),
                `val`(data.name)
            )
            .returningResult(DM_PROJECT.ID, DM_PROJECT.NAME)
            .fetchSingleInto(Project::class.java)

    override fun updateProjectName(id: UUID, updateRequest: ProjectNameUpdateRequest): Project? =
        dslContext.update(DM_PROJECT)
            .set(DM_PROJECT.NAME, updateRequest.name)
            .where(DM_PROJECT.ID.eq(id))
            .returningResult(DM_PROJECT.ID, DM_PROJECT.NAME)
            .fetchOne()
            ?.into(Project::class.java)

    override fun delete(id: UUID) {
        dslContext.delete(DM_PROJECT)
            .where(DM_PROJECT.ID.eq(id))
            .execute()
    }

    override fun findOneById(id: UUID): Project? =
        dslContext.fetchOne(DM_PROJECT, DM_PROJECT.ID.eq(id))
            ?.into(Project::class.java)
}