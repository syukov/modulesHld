import com.example.settings.ProjectModule
import com.example.settings.modulesImplementation

plugins {
    id("android-library-gradle-plugin")
}

dependencies {
    modulesImplementation(ProjectModule.Domain.Network.Api)
}