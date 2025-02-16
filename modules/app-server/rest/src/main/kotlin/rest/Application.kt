package rest

import environment.EnvironmentService
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import module.ModuleService
import project.ProjectService
import rest.v1.route.routeV1

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(
    projectService: ProjectService,
    moduleService: ModuleService,
    environmentService: EnvironmentService
) {
    configureSerialization()
    configureRouting(
        projectService = projectService,
        moduleService = moduleService,
        environmentService = environmentService
    )
}

fun Application.configureRouting(
    projectService: ProjectService,
    moduleService: ModuleService,
    environmentService: EnvironmentService
) {
    routing {
        route("/api") {
            routeV1(
                projectService = projectService,
                moduleService = moduleService,
                environmentService = environmentService
            )
        }
    }
}

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}