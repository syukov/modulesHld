package com.example.settings

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project


sealed class ProjectModule(
    /**
     * Путь подпроекта в нотации градла
     */
    val path: String,

    /**
     * Многие impl модули имеют соответствующие отдельные модули api.
     * при доступе к :modules:app:impl нужно предоставлять доступ к :modules:app:api
     * при доступе к :modules:domain:some:impl нужно предоставлять доступ к :modules:domain:some:api
     * при доступе к :modules:feature:some:impl нужно предоставлять доступ к :modules:feature:some:api
     */
    val api: ProjectModule?,

    /**
     * Многие модули имеют соответствующие отдельные модули core.
     * Т.к. в core содержатся интерфейсы и базовые сущности, то:
     * - при доступе к :modules:domain:some:impl нужно предоставлять доступ к :modules:domain:core:impl
     * - при доступе к :modules:domain:some:api нужно предоставлять доступ к :modules:domain:core:api
     * - при доступе к :modules:feature:some:impl нужно предоставлять доступ к :modules:feature:core:impl
     * - при доступе к :modules:feature:some:api нужно предоставлять доступ к :modules:feature:core:api
     */
    val core: ProjectModule?
) {

    val transitiveDependencies: List<ProjectModule> = listOf(api, core).mapNotNull { it }

    object App {
        object Api : ProjectModule(path = ":modules:app:api", api = null, core = null)
        object Impl : ProjectModule(path = ":modules:app:impl", api = Api, core = null)
    }

    object Domain {
        object Core {
            object Api : ProjectModule(path = ":modules:domain:core:api", api = null, core = null)
            object Impl : ProjectModule(path = ":modules:domain:core:impl", api = Api, core = null)
        }

        object Network {
            object Api : ProjectModule(path = ":modules:domain:network:api", api = null, core = Core.Api)
            object Impl : ProjectModule(path = ":modules:domain:network:impl", api = Api, core = Core.Impl)
        }

        object Security {
            object Api : ProjectModule(path = ":modules:domain:security:api", api = null, core = Core.Api)
            object Impl : ProjectModule(path = ":modules:domain:security:impl", api = Api, core = Core.Impl)
        }

        object Cart {
            object Api : ProjectModule(path = ":modules:domain:cart:api", api = null, core = Core.Api)
            object Impl : ProjectModule(path = ":modules:domain:cart:impl", api = Api, core = Core.Impl)
        }
    }

    object Feature {
        object Core {
            object Api : ProjectModule(path = ":modules:feature:core:api", api = null, core = null)
            object Impl : ProjectModule(path = ":modules:feature:core:impl", api = Api, core = null)
        }

        object Root {
            object Api : ProjectModule(path = ":modules:feature:root:api", api = null, core = Core.Api)
            object Impl : ProjectModule(path = ":modules:feature:root:impl", api = Api, core = Core.Impl)
        }

        object EmployeeAuth {
            object Impl : ProjectModule(path = ":modules:feature:employeeAuth:impl", api = null, core = Core.Impl)
        }

        object Main {
            object Api : ProjectModule(path = ":modules:feature:main:api", api = null, core = Core.Api)
            object Impl : ProjectModule(path = ":modules:feature:main:impl", api = Api, core = Core.Impl)
        }

        object Catalogue {
            object Impl : ProjectModule(path = ":modules:feature:catalogue:impl", api = null, core = Core.Impl)
        }

        object Pdp {
            object Impl : ProjectModule(path = ":modules:feature:pdp:impl", api = null, core = Core.Impl)
        }

        object Cart {
            object Impl : ProjectModule(path = ":modules:feature:cart:impl", api = null, core = Core.Impl)
        }
    }
}

fun DependencyHandler.modulesApi(vararg projectModules: ProjectModule) =
    projectModules.forEach { projectModule -> add("api", project(projectModule.path)) }

fun DependencyHandler.modulesImplementation(vararg projectModules: ProjectModule) =
    projectModules.forEach { projectModule -> add("implementation", project(projectModule.path)) }