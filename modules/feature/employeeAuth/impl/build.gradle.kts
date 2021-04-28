import com.example.settings.ProjectModule
import com.example.settings.modulesImplementation
import com.example.settings.initThisModule

plugins {
    id("android-library-gradle-plugin")
}

dependencies {
    initThisModule(ProjectModule.Feature.EmployeeAuth.Impl)

    // parent feature api:
    modulesImplementation(ProjectModule.Feature.Root.Api)

    // domains:
    modulesImplementation(
        ProjectModule.Domain.Security.Api
    )
}