import com.example.settings.ProjectModule
import com.example.settings.modulesImplementation

plugins {
    id("android-application-gradle-plugin")
}

dependencies {
    // app module should know about all domain modules, because they have application scope
    modulesImplementation(
        ProjectModule.Domain.Cart.Impl,
        ProjectModule.Domain.Network.Impl,
        ProjectModule.Domain.Security.Impl
    )

    // nested features:
    modulesImplementation(ProjectModule.Feature.Root.Impl)
}