/**
 * This class adds VIPS methods to an Operation.
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



package org.im4java.core;

/**
 *  This class subclasses Operation and adds methods for command-line
 *  options of VIPS.
 *
 *  @author  $Author: Daryl Foster $
 */
public class VipsOps
        extends Operation
{
    //~--- constructors -------------------------------------------------------

    /**
     * Constructs VipsOps.
     *
     * The constructor is protected. You should only use subclasses of VipsOps.
     *
     */
    protected VipsOps () {}

    //~--- methods ------------------------------------------------------------

    /**
     * Adds compression type for png output image.
     *
     *
     * @param compressionType
     *
     * @return
     */
    public VipsOps addPngCompressionType (int compressionType)
    {
        String compressionArgument = ":" + Integer.toString (compressionType);

        iCmdArgs.add (IMG_PLACEHOLDER + compressionArgument);

        return this;
    }

    /**
     * Sets deep zoom pyramid depth. Possible values are 1pixel, 1tile, and 1.
     *
     *
     * @param depthType
     *
     * @return
     */
    public VipsOps depth (String depthType)
    {
        iCmdArgs.add ("--depth");
        iCmdArgs.add (depthType);

        return this;
    }

    /**
     * Sets deep zoom pyramid directory layout. Possible values are dz, zoomify,
     * and google.
     *
     *
     * @param layoutType
     *
     * @return
     */
    public VipsOps layout (String layoutType)
    {
        iCmdArgs.add ("--layout");
        iCmdArgs.add (layoutType);

        return this;
    }

    /**
     * Sets deep zoom tile overlap in pixels.
     *
     *
     * @param pixels
     *
     * @return
     */
    public VipsOps overlap (int pixels)
    {
        iCmdArgs.add ("--overlap");
        iCmdArgs.add (Integer.toString (pixels));

        return this;
    }

    /**
     * Sets deep zoom filename suffix for tiles.
     *
     *
     * @param suffixType
     *
     * @return
     */
    public VipsOps suffix (String suffixType)
    {
        iCmdArgs.add ("--suffix");
        iCmdArgs.add (suffixType);

        return this;
    }

    /**
     * Sets deep zoom tile size in pixels.
     *
     *
     * @param pixels
     *
     * @return
     */
    public VipsOps tileSize (int pixels)
    {
        iCmdArgs.add ("--tile-size");
        iCmdArgs.add (Integer.toString (pixels));

        return this;
    }
}
