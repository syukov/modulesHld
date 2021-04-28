import com.example.settings.ProjectModule
import com.example.settings.modulesImplementation
import com.example.settings.initThisModule

plugins {
    id("android-library-gradle-plugin")
}

dependencies {
    initThisModule(ProjectModule.Feature.Root.Impl)

    // nested features:
    modulesImplementation(
        ProjectModule.Feature.EmployeeAuth.Impl,
        ProjectModule.Feature.Main.Impl
    )
}