/*
 * This file is generated by jOOQ.
 */
package generated.domain.enums


import generated.domain.Public

import org.jooq.Catalog
import org.jooq.EnumType
import org.jooq.Schema


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
enum class ScriptExecutionStatus(@get:JvmName("literal") public val literal: String) : EnumType {
    OK("OK"),
    KO("KO");
    public override fun getCatalog(): Catalog? = schema.catalog
    public override fun getSchema(): Schema = Public.PUBLIC
    public override fun getName(): String = "script_execution_status"
    public override fun getLiteral(): String = literal
}
