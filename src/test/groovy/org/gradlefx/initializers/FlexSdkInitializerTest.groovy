/*
 * Copyright (c) 2011 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradlefx.initializers

import spock.lang.Specification

class FlexSdkInitializerTest extends Specification {

    FlexSdkInitializer initializer

    //test spies
    SdkInstallerSpy sdkInstallerSpy

    def setup() {
        sdkInstallerSpy = new SdkInstallerSpy()
        initializer = new FlexSdkInitializer(sdkInstallerSpy)
    }

    def "initialize doesn't install sdk when already installed"() {

        when:
            initializer.initializeOn()
        then:
            sdkInstallerSpy.installerHasRun == false
    }
}
