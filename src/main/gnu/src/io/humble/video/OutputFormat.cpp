/*
 * Copyright (c) 2013-Forward, Andrew "Art" Clarke
 *
 * This file is part of Humble Video.
 * 
 * Humble Video is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Humble Video is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with Humble Video.  If not, see <http://www.gnu.org/licenses/>.
 *
 * OutputFormat.cpp
 *
 *  Created on: Jun 28, 2013
 *      Author: aclarke
 */

#include "OutputFormat.h"

namespace io {
namespace humble {
namespace video {

OutputFormat::OutputFormat()
{
  mFormat = 0;
}

OutputFormat::~OutputFormat()
{
  mFormat = 0;
}
OutputFormat*
OutputFormat::make(AVOutputFormat* format)
{
  OutputFormat* retval = 0;
  if (format)
  {
    retval = make();
    retval->mFormat = format;
  }
  return retval;
}

OutputFormat*
OutputFormat::guessFormat(const char * shortName, const char *filename,
    const char *mimeType)
{
  OutputFormat *retval = 0;
  AVOutputFormat* format = av_guess_format(shortName, filename, mimeType);
  if (format)
    retval = OutputFormat::make(format);
  return retval;
}
} /* namespace video */
} /* namespace humble */
} /* namespace io */
