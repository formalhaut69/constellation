/*
 * Copyright 2010-2019 Australian Signals Directorate
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
package au.gov.asd.tac.constellation.security.proxy;

/**
 * Definitions for preference keys.
 *
 * @author algol
 */
class ProxyPreferenceKeys {

    static final String USE_DEFAULTS = "use_defaults";
    static final String DEFAULT = "default";
    static final String ADDITIONAL = "proxies";
    static final String BYPASS = "local_hosts";

    // Default values.
    static final boolean USE_DEFAULTS_DEFAULT = true;
    static final String DEFAULT_DEFAULT = "";
    static final String ADDITIONAL_DEFAULT = "";
    static final String BYPASS_DEFAULT = "";
}
