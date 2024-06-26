/*
 * Copyright 2021 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.sbtsettingkeys

import sbt.{AutoPlugin, KeyRanks, Setting, settingKey}


object SbtSettingKeys extends AutoPlugin {

  // this is needed to ensure the plugin is auto-enabled when it is added as a dependency of a global plugin
  override def requires = sbt.plugins.JvmPlugin
  override def trigger = allRequirements

  object autoImport extends Keys

  import autoImport._
  override def globalSettings: Seq[Setting[_]] =
    Seq(
      isPublicArtefact := false
    )
}

trait Keys {
  val isPublicArtefact =
    settingKey[Boolean]("Indicates whether an artifact is public and should be published publically")
      // this key is only read by sbt-artifactory, which is available as a global plugin on build server
      // suppress the warning given for development when sbt-artifactory is not present
      .withRank(KeyRanks.Invisible)
}

object Keys extends Keys
