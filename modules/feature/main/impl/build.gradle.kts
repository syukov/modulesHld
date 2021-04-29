import com.example.settings.ProjectModule
import com.example.settings.initThisModule
import com.example.settings.modulesImplementation

plugins {
    id("android-library-gradle-plugin")
}

dependencies {
    initThisModule(ProjectModule.Feature.Main.Impl)

    // parent feature api:
    modulesImplementation(ProjectModule.Feature.Root.Api)

    // nested features:
    modulesImplementation(
        ProjectModule.Feature.Catalogue.Impl,
        ProjectModule.Feature.Pdp.Impl,
        ProjectModule.Feature.Cart.Impl
    )
}