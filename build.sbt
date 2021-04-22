name := "sbt-setting-keys"
majorVersion := 0
scalaVersion := "2.12.13"
crossSbtVersions := Vector("0.13.18", "1.4.9")

sbtPlugin := true

enablePlugins(SbtAutoBuildPlugin, SbtGitVersioning)

makePublicallyAvailableOnBintray := true
