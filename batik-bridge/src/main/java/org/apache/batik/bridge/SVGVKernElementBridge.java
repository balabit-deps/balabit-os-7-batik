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

/**
 * Bridge class for the &lt;vkern&gt; element.
 *
 * @author <a href="mailto:dean.jackson@cmis.csiro.au">Dean Jackson</a>
 * @version $Id: SVGVKernElementBridge.java 1805408 2017-08-18 12:21:52Z ssteiner $
 */
public class SVGVKernElementBridge extends SVGKernElementBridge {

    /**
     * Constructs a new bridge for the &lt;vkern&gt; element.
     */
    public SVGVKernElementBridge() {}

    /**
     * Returns 'vkern'.
     */
    public String getLocalName() {
        return SVG_VKERN_TAG;
    }

}
