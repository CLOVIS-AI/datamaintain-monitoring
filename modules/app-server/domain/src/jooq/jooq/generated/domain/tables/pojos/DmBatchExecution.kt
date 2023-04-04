/*
 * This file is generated by jOOQ.
 */
package jooq.generated.domain.tables.pojos


import java.io.Serializable
import java.util.UUID


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class DmBatchExecution(
    val id: UUID? = null,
    val fkEnvironmentRef: UUID? = null,
    val fkModuleRef: UUID? = null
): Serializable {

    public override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null)
            return false
        if (this::class != other::class)
            return false
        val o: DmBatchExecution = other as DmBatchExecution
        if (this.id == null) {
            if (o.id != null)
                return false
        }
        else if (this.id != o.id)
            return false
        if (this.fkEnvironmentRef == null) {
            if (o.fkEnvironmentRef != null)
                return false
        }
        else if (this.fkEnvironmentRef != o.fkEnvironmentRef)
            return false
        if (this.fkModuleRef == null) {
            if (o.fkModuleRef != null)
                return false
        }
        else if (this.fkModuleRef != o.fkModuleRef)
            return false
        return true
    }

    public override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + (if (this.id == null) 0 else this.id.hashCode())
        result = prime * result + (if (this.fkEnvironmentRef == null) 0 else this.fkEnvironmentRef.hashCode())
        result = prime * result + (if (this.fkModuleRef == null) 0 else this.fkModuleRef.hashCode())
        return result
    }

    public override fun toString(): String {
        val sb = StringBuilder("DmBatchExecution (")

        sb.append(id)
        sb.append(", ").append(fkEnvironmentRef)
        sb.append(", ").append(fkModuleRef)

        sb.append(")")
        return sb.toString()
    }
}
