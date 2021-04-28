import com.example.settings.ProjectModule
import com.example.settings.modulesImplementation
import com.example.settings.initThisModule

plugins {
    id("android-library-gradle-plugin")
}

dependencies {
    initThisModule(ProjectModule.Feature.Pdp.Impl)

    // parent feature api:
    modulesImplementation(
        ProjectModule.Feature.Root.Api,
        ProjectModule.Feature.Main.Api
    )

    // domains:
    modulesImplementation(
        ProjectModule.Domain.Cart.Api
    )
}