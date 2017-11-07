/**
 * This class implements the basic test of vips dzsave.
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
 *  This class implements the basic test of vips dzsave.
 *
 *  @author  $Author: Daryl Foster $
 */
public class TestCase27
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
        return "simple use of vips im_copy";
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
        TestCase27 tc = new TestCase27 ();

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
        System.err.println (" 27. Testing vips deep zoom ...");

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

        op.addImage ();
        op.layout ("google");
        op.suffix (".png[compression=9]");
        op.overlap (0);
        op.tileSize (100);
        op.depth ("onetile");

        String[]        images      = new String[] {iImageDir + "tulip1.jpg", iImageDir + "tiles"};
        VipsDeepZoomCmd deepZoomCmd = new VipsDeepZoomCmd ();

        deepZoomCmd.createScript (iImageDir + "append.sh", op);
        deepZoomCmd.run (op, (Object[]) images);
        DisplayCmd.show (iImageDir + "tiles/2/0/1.png");
    }
}
