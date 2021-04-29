import com.example.settings.ProjectModule
import com.example.settings.modulesImplementation

plugins {
    id("android-library-gradle-plugin")
}

dependencies {
    // parent feature api:
    modulesImplementation(
        ProjectModule.Feature.Root.Api,
        ProjectModule.Feature.Main.Api
    )

    // domains:
    modulesImplementation(
        ProjectModule.Domain.Security.Api
    )
}