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
 * ContainerFormat.cpp
 *
 *  Created on: Jun 28, 2013
 *      Author: aclarke
 */

#include "ContainerFormat.h"

/**
 * This is dangerous as it breaks the FFmpeg ABI, but I need it to
 * generate a list of supported codecs.
 */
extern "C" {
typedef struct AVCodecTag
{
  enum AVCodecID id;
  uint32_t tag;
} AVCodecTag;

}
namespace io {
namespace humble {
namespace video {

ContainerFormat::ContainerFormat()
{
}

ContainerFormat::~ContainerFormat()
{
}

/**
 * Get total number of different codecs this container can output.
 */
int32_t
ContainerFormat::getNumSupportedCodecs(const struct AVCodecTag * const * tags)
{
  int numCodecs = 0;

  for (int i = 0; tags && tags[i]; i++)
  {
    for (const struct AVCodecTag * tag = tags[i];
        tag && tag->id != (enum AVCodecID) CODEC_ID_NONE; ++tag)
    {
      ++numCodecs;
    }
  }
  return numCodecs;
}
/**
 * Get the CodecId for the n'th codec supported by this container.
 *
 * @param n The n'th codec supported by this codec. Lower n are higher priority.
 *   n must be < {@link #getNumSupportedCodecs()}
 * @return the {@link CodecId} at the n'th slot, or {@link CodecId.ID_NONE} if none.
 */
Codec::Id
ContainerFormat::getSupportedCodecId(const struct AVCodecTag * const * tags, int32_t n)
{
  if (n < 0 || !tags) return Codec::ID_NONE;

  int numCodecs = 0;

  for (int i = 0; tags[i]; i++)
  {
    for (const struct AVCodecTag * tag = tags[i];
        tag && tag->id != (enum AVCodecID) Codec::ID_NONE; ++tag, ++numCodecs)
    {
      if (numCodecs == n) return (Codec::Id) tag->id;
    }
  }
  return Codec::ID_NONE;

}
/**
 * Get the 32-bit Codec Tag for the n'th codec supported by this container.
 *
 * @param n The n'th codec supported by this codec. Lower n are higher priority.
 *   n must be < {@link #getNumSupportedCodecs()}
 * @return the codec tag at the n'th slot, or 0 if none.
 */
uint32_t
ContainerFormat::getSupportedCodecTag(const struct AVCodecTag * const * tags, int32_t n) {
  if (n < 0 || !tags) return Codec::ID_NONE;

  int numCodecs = 0;

  for (int i = 0; tags[i]; i++)
  {
    for (const struct AVCodecTag * tag = tags[i];
        tag && tag->id != (enum AVCodecID) Codec::ID_NONE; ++tag, ++numCodecs)
    {
      if (numCodecs == n) return tag->tag;
    }
  }
  return 0;
}

} /* namespace video */
} /* namespace humble */
} /* namespace io */
