/*

   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package org.apache.batik.bridge;

import org.apache.batik.test.*;

import org.apache.batik.test.svg.SVGOnLoadExceptionTest;

/**
 * Checks that JAR Scripts which should not be loaded are not
 * loaded.
 *
 * @author <a href="mailto:vincent.hardy@sun.com">Vincent Hardy</a>
 * @version $Id: JarNoLoadTest.java 1804130 2017-08-04 14:41:11Z ssteiner $
 */
public class JarNoLoadTest extends DefaultTestSuite {
    public JarNoLoadTest() {
        String scripts = "text/ecmascript";
        String[] scriptSource = {"bridge/jarCheckNoLoadAny",
                                 "bridge/jarCheckNoLoadSameAsDocument",
                                 "bridge/jarCheckNoLoadEmbed",
        };
        boolean[] secure = {true, false};
        String[] scriptOrigin = {"ANY", "DOCUMENT", "EMBEDED", "NONE"};

        //
        // If "application/java-archive" is disallowed, scripts
        // should not be loaded, no matter their origin or the
        // other security settings.
        //
        for (String aScriptSource : scriptSource) {
            for (boolean aSecure : secure) {
                for (String aScriptOrigin : scriptOrigin) {
                    SVGOnLoadExceptionTest t = buildTest(scripts,
                            aScriptSource,
                            aScriptOrigin,
                            aSecure);
                    addTest(t);
                }
            }
        }

        //
        // If "application/java-archive" is allowed, but the accepted
        // script origin is lower than the candidate script, then
        // the script should not be loaded (e.g., if scriptOrigin
        // is embeded and trying to load an external script).
        //
        scripts = "application/java-archive";
        for (int j=0; j<scriptOrigin.length; j++) {
            for (int i=0; i<j; i++) {
                for (boolean aSecure : secure) {
                    SVGOnLoadExceptionTest t = buildTest(scripts, scriptSource[i],
                            scriptOrigin[j],
                            aSecure);
                    addTest(t);
                }
            }
        }
    }

    SVGOnLoadExceptionTest buildTest(String scripts, String id, String origin, boolean secure) {
        SVGOnLoadExceptionTest t = new SVGOnLoadExceptionTest();
        String desc = 
            "(scripts=" + scripts + 
            ")(scriptOrigin=" + origin +
            ")(secure=" + secure + ")";
        
        t.setId(id + desc);
        t.setScriptOrigin(origin);
        t.setSecure(secure);
        t.setScripts(scripts);
        t.setExpectedExceptionClass("java.lang.SecurityException");

        return t;
    }
                             
}
