import com.example.settings.ProjectModule
import com.example.settings.initThisModule
import com.example.settings.modulesImplementation

plugins {
    id("android-library-gradle-plugin")
}

dependencies {
    initThisModule(ProjectModule.Domain.Cart.Impl)
    modulesImplementation(ProjectModule.Domain.Network.Api)
}