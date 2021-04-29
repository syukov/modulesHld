import com.example.settings.ProjectModule
import com.example.settings.modulesImplementation

plugins {
    id("android-library-gradle-plugin")
}

dependencies {
    // nested features:
    modulesImplementation(
        ProjectModule.Feature.EmployeeAuth.Impl,
        ProjectModule.Feature.Main.Impl
    )
}