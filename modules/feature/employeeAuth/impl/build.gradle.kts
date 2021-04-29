import com.example.settings.ProjectModule
import com.example.settings.initThisModule
import com.example.settings.modulesImplementation

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