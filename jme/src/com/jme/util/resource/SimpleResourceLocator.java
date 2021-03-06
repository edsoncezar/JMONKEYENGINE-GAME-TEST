/*
 * Copyright (c) 2003-2007 jMonkeyEngine
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'jMonkeyEngine' nor the names of its contributors 
 *   may be used to endorse or promote products derived from this software 
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.jme.util.resource;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * This locator takes a base URL for finding resources specified with a relative path. If it cannot find the path
 * relative to the URL, it successively omits the starting components of the relative path until it can find
 * a resources with such a trimmed path. If no resource is found with this method null is returned.
 * 
 * @author Joshua Slack
 */
public class SimpleResourceLocator implements ResourceLocator {

    protected URI baseDir;

    public SimpleResourceLocator(URI baseDir) {
        if (baseDir == null) {
            throw new NullPointerException("baseDir can not be null.");
        }
        this.baseDir = baseDir;
    }

    public SimpleResourceLocator(URL baseDir) throws URISyntaxException {
        if (baseDir == null) {
            throw new NullPointerException("baseDir can not be null.");
        }
        this.baseDir = baseDir.toURI();
    }
    
    public URL locateResource(String resourceName) {
        // Try to locate using resourceName as is.
        try {
            String spec = URLEncoder.encode( resourceName, "UTF-8" );
            //this fixes a bug in JRE1.5 (file handler does not decode "+" to spaces)
            spec = spec.replaceAll( "\\+", "%20" );

            URL rVal = new URL( baseDir.toURL(), spec );
            // open a stream to see if this is a valid resource
            // XXX: Perhaps this is wasteful?  Also, what info will determine validity?
            rVal.openStream().close();
            return rVal;
        } catch (IOException e) {
            // URL wasn't valid in some way, so try up a path.
        } catch (IllegalArgumentException e) {
            // URL wasn't valid in some way, so try up a path.
        }
    
        resourceName = trimResourceName(resourceName);
        if (resourceName == null) {
            return null;
        } else {
            return locateResource(resourceName);
        }
    }

    protected String trimResourceName(String resourceName) {
        // we are sure this is part of a URL so using slashes only is fine:
        final int firstSlashIndex = resourceName.indexOf( '/' );
        if ( firstSlashIndex >= 0 && firstSlashIndex < resourceName.length() - 1 )
        {
            return resourceName.substring( firstSlashIndex + 1 );
        }
        else
        {
            return null;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SimpleResourceLocator) {
            return baseDir.equals(((SimpleResourceLocator)obj).baseDir);
        }
        return false;
    }
}
