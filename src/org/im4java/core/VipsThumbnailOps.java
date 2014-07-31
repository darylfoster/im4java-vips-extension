/**
 * This class adds Vipsthumbnail methods to an Operation.
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
 *  options of Vipsthumbnail.
 *
 *  @author  $Author: Daryl Foster $
 */
public class VipsThumbnailOps
        extends Operation
{
    //~--- constructors -------------------------------------------------------

    /**
     * Constructs VipsThumbnailOps.
     *
     * The constructor is protected. You should only use subclasses of VipsThumbnailOps.
     *
     */
    protected VipsThumbnailOps () {}

    //~--- methods ------------------------------------------------------------

    /**
     * Add option -e to VIPS command-line.
     * Export thumbnails with this ICC profile. Images are only colour-
     * transformed if there is both an output and an input profile available.
     * The input profile can either be embedded in the input image or supplied
     * with the --iprofile option.
     *
     *
     * @param profile
     *
     * @return
     */
    public VipsThumbnailOps eProfile (String profile)
    {
        iCmdArgs.add ("-e");
        iCmdArgs.add (profile);

        return this;
    }

    /**
     * Add option -i to VIPS command-line.
     * Import images with this ICC profile, if no profile is embdedded in the
     * image. Images are only colour-transformed if there is both an output and
     * an input profile available. The output profile should be supplied with
     * the --oprofile option.
     *
     *
     * @param profile
     *
     * @return
     */
    public VipsThumbnailOps iProfile (String profile)
    {
        iCmdArgs.add ("-i");
        iCmdArgs.add (profile);

        return this;
    }

    /**
     * Add option -l to VIPS command-line.
     * Don't delete the profile from the output image. Since all output images
     * will generally have the same profile, vipsthumbnail(1) will usually
     * delete it. This option leaves the profile inside the image.
     *
     *
     * @return
     */
    public VipsThumbnailOps noDelete ()
    {
        iCmdArgs.add ("-l");

        return this;
    }

    /**
     * Add option -n to VIPS command-line.
     * By default, vipsthumbnail(1) will sharpen thumbnails slightly to make
     * them look more pleasing. This option disables this sharpening.
     *
     *
     * @return
     */
    public VipsThumbnailOps noSharpen ()
    {
        iCmdArgs.add ("-n");

        return this;
    }

    /**
     * Add option -o to VIPS command-line.
     * Set the output format string. The input filename has any file type
     * suffix removed, then that value is substituted into FORMAT replacing %s.
     * The default value is tn_%s.jpg meaning JPEG output, with tn_ prepended.
     * You can add format options too, for example tn_%s.jpg:20 will write JPEG
     * images with Q set to 20.
     *
     *
     * @param format
     *
     * @return
     */
    public VipsThumbnailOps outputFormat (String format)
    {
        iCmdArgs.add ("-o");
        iCmdArgs.add (format);

        return this;
    }

    /**
     * Add option -p to the VIPS command-line.
     * Set the output format string. The input filename has any file type
     * suffix removed, then that value is substituted into FORMAT replacing %s.
     * The default value is tn_%s.jpg meaning JPEG output, with tn_ prepended.
     * You can add format options too, for example tn_%s.jpg:20 will write JPEG
     * images with Q set to 20.
     *
     *
     * @param interpolator
     *
     * @return
     */
    public VipsThumbnailOps resampleInterpolator (String interpolator)
    {
        iCmdArgs.add ("-p");
        iCmdArgs.add (interpolator);

        return this;
    }

    /**
     * Add option -s to the VIPS command-line.
     * Set the output thumbnail size to pixels x pixels. The image is shrunk so
     * that it just fits within this area. Images which are smaller than this
     * are expanded.
     *
     *
     * @param pixels
     *
     * @return
     */
    public VipsThumbnailOps size (int pixels)
    {
        iCmdArgs.add ("-s");
        iCmdArgs.add (Integer.toString (pixels));

        return this;
    }

    /**
     * Add option -v to the VIPS command-line.
     * vipsthumbnail(1) normally runs silently, except for warning and error
     * messages. This option makes it print a list of the operations it
     * performs on each image.
     *
     *
     * @return
     */
    public VipsThumbnailOps verbose ()
    {
        iCmdArgs.add ("-v");

        return this;
    }
}
