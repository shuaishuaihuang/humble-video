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
 * OutputFormat.h
 *
 *  Created on: Jun 28, 2013
 *      Author: aclarke
 */

#ifndef OUTPUTFORMAT_H_
#define OUTPUTFORMAT_H_

#include <io/humble/video/ContainerFormat.h>
#include <io/humble/video/Codec.h>

namespace io {
namespace humble {
namespace video {

class VS_API_HUMBLEVIDEO OutputFormat : public ContainerFormat
{
VS_JNIUTILS_REFCOUNTED_OBJECT_PRIVATE_MAKE(OutputFormat)
public:
  /**
   * Name for format.
   */
  virtual const char*
  getName()
  {
    return mFormat->name;
  }

  /**
   * Descriptive name for the format, meant to be more human-readable
   * than name.
   */
  virtual const char*
  getLongName()
  {
    return mFormat->long_name;
  }

  /** A comma-separated list of supported filename extensions */
  virtual const char*
  getExtensions()
  {
    return mFormat->extensions;
  }

  /**
   * Flags that tell you what capabilities this format supports.
   *
   * @return a bitmask of {@link Flags}
   */
  virtual int32_t
  getFlags()
  {
    return mFormat->flags;
  }

  /**
   * Get the default audio codec for this format.
   */
  virtual Codec::Id
  getDefaultAudioCodecId()
  {
    return (Codec::Id) mFormat->audio_codec;
  }
  virtual Codec::Id
  getDefaultVideoCodecId()
  {
    return (Codec::Id) mFormat->video_codec;
  }
  virtual Codec::Id
  getDefaultSubtitleCodecId()
  {
    return (Codec::Id) mFormat->subtitle_codec;
  }
  virtual const char *
  getMimeType()
  {
    return mFormat->mime_type;
  }

  /**
   * Return the output format in the list of registered output formats
   * which best matches the provided parameters, or return NULL if
   * there is no match.
   *
   * @param shortName if non-NULL checks if short_name matches with the
   * names of the registered formats
   * @param filename if non-NULL checks if filename terminates with the
   * extensions of the registered formats
   * @param mimeType if non-NULL checks if mime_type matches with the
   * MIME type of the registered formats
   */
  static OutputFormat*
  guessFormat(const char * shortName, const char *filename,
      const char *mimeType);
  virtual Codec::Id
  guessCodec(const char * shortName, const char * filename,
      const char* mimeType, MediaType type)
  {
    return (Codec::Id) av_guess_codec(mFormat, shortName, filename, mimeType,
        (enum AVMediaType) type);
  }

protected:
  // methods here that will not be directly exposed to SWIG (but will be used by hand-crafted
  // generated methods

  /**
   * Get total number of different codecs this container can output.
   */
  virtual int32_t
  getNumSupportedCodecs()
  {
    return ContainerFormat::getNumSupportedCodecs(mFormat->codec_tag);
  }
  /**
   * Get the CodecId for the n'th codec supported by this container.
   *
   * @param n The n'th codec supported by this codec. Lower n are higher priority.
   *   n must be < {@link #getNumSupportedCodecs()}
   * @return the {@link CodecId} at the n'th slot, or {@link CodecId.ID_NONE} if none.
   */
  virtual Codec::Id
  getSupportedCodecId(int32_t n)
  {
    return ContainerFormat::getSupportedCodecId(mFormat->codec_tag, n);
  }
  /**
   * Get the 32-bit Codec Tag for the n'th codec supported by this container.
   *
   * @param n The n'th codec supported by this codec. Lower n are higher priority.
   *   n must be < {@link #getNumSupportedCodecs()}
   * @return the codec tag at the n'th slot, or 0 if none.
   */
  virtual uint32_t
  getSupportedCodecTag(int32_t n)
  {
    return ContainerFormat::getSupportedCodecTag(mFormat->codec_tag, n);
  }

  static OutputFormat*
  make(AVOutputFormat* format);

private:
  OutputFormat();
  virtual
  ~OutputFormat();

private:
  AVOutputFormat *mFormat;
};

} /* namespace video */
} /* namespace humble */
} /* namespace io */
#endif /* OUTPUTFORMAT_H_ */
