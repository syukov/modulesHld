import com.example.settings.ProjectModule
import com.example.settings.initThisModule

plugins {
    id("android-library-gradle-plugin")
}

dependencies {
    initThisModule(ProjectModule.Domain.Security.Api)
}