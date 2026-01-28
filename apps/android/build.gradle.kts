plugins {
  id("com.android.application") version "8.13.2" apply false
  id("org.jetbrains.kotlin.android") version "2.2.21" apply false
  id("org.jetbrains.kotlin.plugin.compose") version "2.2.21" apply false
  id("org.jetbrains.kotlin.plugin.serialization") version "2.2.21" apply false
}

// >> GIT_ALL_IN_ONE:startApi
tasks.register<Exec>("startApi") {
    workingDir = rootProject.projectDir
    val os = org.gradle.internal.os.OperatingSystem.current()
    if (os.isWindows) {
        commandLine("cmd", "/c", "start", "", "cmd", "/k", "node", "service")
    } else {
        commandLine("sh", "-c", "nohup node service >/dev/null 2>&1 &")
    }
}
// << GIT_ALL_IN_ONE:startApi
