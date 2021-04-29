import com.example.settings.ProjectModule
import com.example.settings.modulesApi

plugins {
    id("android-library-gradle-plugin")
}

dependencies {
    // Все фичи будут видеть базовые классы юзкейсов
    modulesApi(ProjectModule.Domain.Core.Api)
}