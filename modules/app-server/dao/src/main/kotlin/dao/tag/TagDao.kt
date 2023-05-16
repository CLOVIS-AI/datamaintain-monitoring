package dao.tag

import generated.domain.tables.pojos.DmTag
import generated.domain.tables.references.DM_TAG

import org.jooq.DSLContext
import org.jooq.impl.DSL.`val`

class TagDao(val dslContext: DSLContext) {
    fun insert(data: DmTag): DmTag? =
        dslContext.insertInto(DM_TAG, DM_TAG.NAME)
            .values(
                `val`(data.name)
            )
            .onDuplicateKeyIgnore()
            .returningResult(DM_TAG.NAME)
            .fetchOne()
            ?.into(DmTag::class.java)

    fun delete(id: String) {
        dslContext.delete(DM_TAG)
            .where(DM_TAG.NAME.eq(id))
            .execute()
    }

    fun findOneById(id: String): DmTag? =
        dslContext.fetchOne(DM_TAG, DM_TAG.NAME.eq(id))
            ?.into(DmTag::class.java)
}