/*!
* Copyright 2010 - 2013 Pentaho Corporation.  All rights reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*
*/

package org.apache.commons.vfs.provider.gzip;

import org.apache.commons.vfs.FileName;
import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.provider.compressed.CompressedFileFileObject;
import org.apache.commons.vfs.provider.compressed.CompressedFileFileSystem;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * the gzip file.
 *
 * @author <a href="mailto:imario@apache.org">Mario Ivankovits</a>
 * @version $Revision: 804644 $ $Date: 2009-08-16 04:02:15 -0400 (Sun, 16 Aug 2009) $
 */
public class GzipFileObject extends CompressedFileFileObject
{
    protected GzipFileObject(FileName name, FileObject container, CompressedFileFileSystem fs)
    {
        super(name, container, fs);
    }

    protected InputStream doGetInputStream() throws Exception
    {
        InputStream is = getContainer().getContent().getInputStream();
        return new GZIPInputStream(is);
    }

    protected OutputStream doGetOutputStream(boolean bAppend) throws Exception
    {
        OutputStream os = getContainer().getContent().getOutputStream(false);
        return new GZIPOutputStream(os);
    }
}
