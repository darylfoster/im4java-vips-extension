/**
 * This class implements the basic test of vipsthumbnail.
 *
 * Copyright (c) 2014 by Daryl Foster (darylfoster@netzero.net)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Library General Public License as published
 * by  the Free Software Foundation; either version 2 of the License or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public License
 * along with this program; see the file COPYING.LIB.  If not, write to
 * the Free Software Foundation Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307 USA
 *
 */



package org.im4java.test;

//~--- non-JDK imports --------------------------------------------------------

import org.im4java.core.*;

//~--- classes ----------------------------------------------------------------

/**
 *  This class implements the basic test of vipsthumbnail.
 *
 *  @author  $Author: Daryl Foster $
 */
public class TestCase25
        extends AbstractTestCase
{
    //~--- get methods --------------------------------------------------------

    //////////////////////////////////////////////////////////////////////////////

    /**
     *  Return the description of the test.
     *
     * @return
     */
    public String getDescription ()
    {
        return "simple use of vipsthumbnail";
    }

    //~--- methods ------------------------------------------------------------

    //////////////////////////////////////////////////////////////////////////////

    /**
     *  Main method. Just calls AbstractTestCase.runTest(), which catches and
     *  prints exceptions.
     *
     * @param args
     */
    public static void main (String[] args)
    {
        TestCase25 tc = new TestCase25 ();

        tc.runTest (args);
    }

    //////////////////////////////////////////////////////////////////////////////

    /**
     *  Run the test.
     *
     * @throws Exception
     */
    public void run ()
            throws Exception
    {
        System.err.println (" 25. Testing vipsthumbnail ...");

        // setup optional control-variables
        boolean induceError = false;

        if ((iArgs != null) && (iArgs.length > 0))
        {
            induceError = Boolean.parseBoolean (iArgs[0]);
        }

        VipsOperation op = new VipsOperation ();

        if (!induceError)
        {
            // with induceError == true, we will have more images than placeholders
            op.addImage ();
        }

        op.size (200);
        op.outputFormat ("tulip1_thumbnail.jpg");

        String[]         images       = new String[] {iImageDir + "tulip1.jpg"};
        VipsThumbnailCmd thumbnailCmd = new VipsThumbnailCmd ();

        thumbnailCmd.createScript (iImageDir + "append.sh", op);
        thumbnailCmd.run (op, (Object[]) images);
        DisplayCmd.show (iImageDir + "tulip1_thumbnail.jpg");
    }
}
