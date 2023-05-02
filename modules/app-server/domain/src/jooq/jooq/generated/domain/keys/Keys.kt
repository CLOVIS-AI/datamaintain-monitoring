/*
 * This file is generated by jOOQ.
 */
package jooq.generated.domain.keys


import jooq.generated.domain.tables.DmBatchExecution
import jooq.generated.domain.tables.DmEnvironment
import jooq.generated.domain.tables.DmModule
import jooq.generated.domain.tables.DmProject
import jooq.generated.domain.tables.DmScript
import jooq.generated.domain.tables.DmScriptExecution
import jooq.generated.domain.tables.DmTag
import jooq.generated.domain.tables.records.DmBatchExecutionRecord
import jooq.generated.domain.tables.records.DmEnvironmentRecord
import jooq.generated.domain.tables.records.DmModuleRecord
import jooq.generated.domain.tables.records.DmProjectRecord
import jooq.generated.domain.tables.records.DmScriptExecutionRecord
import jooq.generated.domain.tables.records.DmScriptRecord
import jooq.generated.domain.tables.records.DmTagRecord

import org.jooq.ForeignKey
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal



// -------------------------------------------------------------------------
// UNIQUE and PRIMARY KEY definitions
// -------------------------------------------------------------------------

val DM_BATCH_EXECUTION_PKEY: UniqueKey<DmBatchExecutionRecord> = Internal.createUniqueKey(DmBatchExecution.DM_BATCH_EXECUTION, DSL.name("dm_batch_execution_pkey"), arrayOf(DmBatchExecution.DM_BATCH_EXECUTION.ID), true)
val DM_ENVIRONMENT_PKEY: UniqueKey<DmEnvironmentRecord> = Internal.createUniqueKey(DmEnvironment.DM_ENVIRONMENT, DSL.name("dm_environment_pkey"), arrayOf(DmEnvironment.DM_ENVIRONMENT.ID), true)
val DM_MODULE_PKEY: UniqueKey<DmModuleRecord> = Internal.createUniqueKey(DmModule.DM_MODULE, DSL.name("dm_module_pkey"), arrayOf(DmModule.DM_MODULE.ID), true)
val DM_PROJECT_PKEY: UniqueKey<DmProjectRecord> = Internal.createUniqueKey(DmProject.DM_PROJECT, DSL.name("dm_project_pkey"), arrayOf(DmProject.DM_PROJECT.ID), true)
val DM_SCRIPT_PKEY: UniqueKey<DmScriptRecord> = Internal.createUniqueKey(DmScript.DM_SCRIPT, DSL.name("dm_script_pkey"), arrayOf(DmScript.DM_SCRIPT.CHECKSUM), true)
val DM_SCRIPT_EXECUTION_PKEY: UniqueKey<DmScriptExecutionRecord> = Internal.createUniqueKey(DmScriptExecution.DM_SCRIPT_EXECUTION, DSL.name("dm_script_execution_pkey"), arrayOf(DmScriptExecution.DM_SCRIPT_EXECUTION.ID), true)
val DM_TAG_PKEY: UniqueKey<DmTagRecord> = Internal.createUniqueKey(DmTag.DM_TAG, DSL.name("dm_tag_pkey"), arrayOf(DmTag.DM_TAG.NAME), true)

// -------------------------------------------------------------------------
// FOREIGN KEY definitions
// -------------------------------------------------------------------------

val DM_BATCH_EXECUTION__DM_BATCH_EXECUTION_FK_ENVIRONMENT_REF_FKEY: ForeignKey<DmBatchExecutionRecord, DmEnvironmentRecord> = Internal.createForeignKey(DmBatchExecution.DM_BATCH_EXECUTION, DSL.name("dm_batch_execution_fk_environment_ref_fkey"), arrayOf(DmBatchExecution.DM_BATCH_EXECUTION.FK_ENVIRONMENT_REF), jooq.generated.domain.keys.DM_ENVIRONMENT_PKEY, arrayOf(DmEnvironment.DM_ENVIRONMENT.ID), true)
val DM_BATCH_EXECUTION__DM_BATCH_EXECUTION_FK_MODULE_REF_FKEY: ForeignKey<DmBatchExecutionRecord, DmModuleRecord> = Internal.createForeignKey(DmBatchExecution.DM_BATCH_EXECUTION, DSL.name("dm_batch_execution_fk_module_ref_fkey"), arrayOf(DmBatchExecution.DM_BATCH_EXECUTION.FK_MODULE_REF), jooq.generated.domain.keys.DM_MODULE_PKEY, arrayOf(DmModule.DM_MODULE.ID), true)
val DM_ENVIRONMENT__DM_ENVIRONMENT_FK_PROJECT_REF_FKEY: ForeignKey<DmEnvironmentRecord, DmProjectRecord> = Internal.createForeignKey(DmEnvironment.DM_ENVIRONMENT, DSL.name("dm_environment_fk_project_ref_fkey"), arrayOf(DmEnvironment.DM_ENVIRONMENT.FK_PROJECT_REF), jooq.generated.domain.keys.DM_PROJECT_PKEY, arrayOf(DmProject.DM_PROJECT.ID), true)
val DM_MODULE__DM_MODULE_FK_PROJECT_REF_FKEY: ForeignKey<DmModuleRecord, DmProjectRecord> = Internal.createForeignKey(DmModule.DM_MODULE, DSL.name("dm_module_fk_project_ref_fkey"), arrayOf(DmModule.DM_MODULE.FK_PROJECT_REF), jooq.generated.domain.keys.DM_PROJECT_PKEY, arrayOf(DmProject.DM_PROJECT.ID), true)
val DM_SCRIPT_EXECUTION__DM_SCRIPT_EXECUTION_FK_BATCH_EXECUTION_REF_FKEY: ForeignKey<DmScriptExecutionRecord, DmBatchExecutionRecord> = Internal.createForeignKey(DmScriptExecution.DM_SCRIPT_EXECUTION, DSL.name("dm_script_execution_fk_batch_execution_ref_fkey"), arrayOf(DmScriptExecution.DM_SCRIPT_EXECUTION.FK_BATCH_EXECUTION_REF), jooq.generated.domain.keys.DM_BATCH_EXECUTION_PKEY, arrayOf(DmBatchExecution.DM_BATCH_EXECUTION.ID), true)
val DM_SCRIPT_EXECUTION__DM_SCRIPT_EXECUTION_FK_SCRIPT_REF_FKEY: ForeignKey<DmScriptExecutionRecord, DmScriptRecord> = Internal.createForeignKey(DmScriptExecution.DM_SCRIPT_EXECUTION, DSL.name("dm_script_execution_fk_script_ref_fkey"), arrayOf(DmScriptExecution.DM_SCRIPT_EXECUTION.FK_SCRIPT_REF), jooq.generated.domain.keys.DM_SCRIPT_PKEY, arrayOf(DmScript.DM_SCRIPT.CHECKSUM), true)
