/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.humble.video;
import io.humble.ferry.*;
public class ContainerFormat extends RefCounted {
  // JNIHelper.swg: Start generated code
  // >>>>>>>>>>>>>>>>>>>>>>>>>>>
  /**
   * This method is only here to use some references and remove
   * a Eclipse compiler warning.
   */
  @SuppressWarnings("unused")
  private void noop()
  {
    IBuffer.make(null, 1);
  }
   
  private volatile long swigCPtr;

  /**
   * Internal Only.
   */
  protected ContainerFormat(long cPtr, boolean cMemoryOwn) {
    super(VideoJNI.SWIGContainerFormatUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }
  
  /**
   * Internal Only.
   */
  protected ContainerFormat(long cPtr, boolean cMemoryOwn,
      java.util.concurrent.atomic.AtomicLong ref)
  {
    super(VideoJNI.SWIGContainerFormatUpcast(cPtr),
     cMemoryOwn, ref);
    swigCPtr = cPtr;
  }
    
  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that obj is proxying for.
   *   
   * @param obj The java proxy object for a native object.
   * @return The raw pointer obj is proxying for.
   */
  public static long getCPtr(ContainerFormat obj) {
    if (obj == null) return 0;
    return obj.getMyCPtr();
  }

  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that we're proxying for.
   *   
   * @return The raw pointer we're proxying for.
   */  
  public long getMyCPtr() {
    if (swigCPtr == 0) throw new IllegalStateException("underlying native object already deleted");
    return swigCPtr;
  }
  
  /**
   * Create a new ContainerFormat object that is actually referring to the
   * exact same underlying native object.
   *
   * @return the new Java object.
   */
  @Override
  public ContainerFormat copyReference() {
    if (swigCPtr == 0)
      return null;
    else
      return new ContainerFormat(swigCPtr, swigCMemOwn, getJavaRefCount());
  }

  /**
   * Compares two values, returning true if the underlying objects in native code are the same object.
   *
   * That means you can have two different Java objects, but when you do a comparison, you'll find out
   * they are the EXACT same object.
   *
   * @return True if the underlying native object is the same.  False otherwise.
   */
  public boolean equals(Object obj) {
    boolean equal = false;
    if (obj instanceof ContainerFormat)
      equal = (((ContainerFormat)obj).swigCPtr == this.swigCPtr);
    return equal;
  }
  
  /**
   * Get a hashable value for this object.
   *
   * @return the hashable value.
   */
  public int hashCode() {
     return (int)swigCPtr;
  }
  
  // <<<<<<<<<<<<<<<<<<<<<<<<<<<
  // JNIHelper.swg: End generated code
  

  /**
    * info about this format object
    * @return information about this object
    */
    
   @Override
   public String toString()
   {
     StringBuilder result = new StringBuilder();
     
     result.append(this.getClass().getName()+"@"+hashCode()+"[");
     result.append("name:"+getName()+";");
     result.append("longname:"+getName()+";");
     result.append("extensions:"+getExtensions()+";");
     result.append("flags:"+getFlags()+";");
     result.append("]");
     return result.toString();
   }
   /**
    * Returns a list of all codecs supported for this Object.
    *
    * <p>
    *
    * If this object hasn't been set up for output, then
    * we return null.
    *
    * </p>
    *
    * @return A list of supported codecs, in decreasing preferred order.
    */
   public java.util.List<Codec.Id> getOutputCodecsSupported()
   {
     final java.util.List<Codec.Id> retval =
       new java.util.LinkedList<Codec.Id>();
     final java.util.Set<Codec.Id> uniqueSet =
       new java.util.HashSet<Codec.Id>();
     
     int numCodecs = getNumSupportedCodecs();
     for(int i = 0; i < numCodecs; i++)
     {
       Codec.Id id = getSupportedCodecId(i);
       // remove duplicate IDs
       if (id != Codec.Id.ID_NONE && !uniqueSet.contains(id))
         retval.add(id);
       uniqueSet.add(id);
     }    
     return retval;
   }

   /**
    * Returns a list of all codec tags supported for this container.
    *
    * <p>
    *
    * If this object hasn't been set up for output, then
    * we return null.
    *
    * </p>
    *
    * @return A list of supported codec tags, in decreasing preferred order.
    */
   public java.util.List<Long> getOutputTagsSupported()
   {
     final java.util.List<Long> retval =
       new java.util.LinkedList<Long>();
     final java.util.Set<Long> uniqueSet =
       new java.util.HashSet<Long>();
     
     int numCodecs = getNumSupportedCodecs();
     for(int i = 0; i < numCodecs; i++)
     {
       long tag = getSupportedCodecTag(i);
       Codec.Id id = getSupportedCodecId(i);
       // remove duplicate tags
       if (id != Codec.Id.ID_NONE && !uniqueSet.contains(tag))
         retval.add(tag);
       uniqueSet.add(tag);
     }    
     return retval;
   }


/**
 * Name for format.  
 */
  public String getName() {
    return VideoJNI.ContainerFormat_getName(swigCPtr, this);
  }

/**
 * Descriptive name for the format, meant to be more human-readable 
 *  
 * than name.  
 */
  public String getLongName() {
    return VideoJNI.ContainerFormat_getLongName(swigCPtr, this);
  }

/**
 * A comma-separated list of supported filename extensions  
 */
  public String getExtensions() {
    return VideoJNI.ContainerFormat_getExtensions(swigCPtr, this);
  }

/**
 * Flags that tell you what capabilities this format supports.  
 * @return	a bitmask of {@link Flags}  
 */
  public int getFlags() {
    return VideoJNI.ContainerFormat_getFlags(swigCPtr, this);
  }

/**
 *  
 */
  protected int getNumSupportedCodecs() {
    return VideoJNI.ContainerFormat_getNumSupportedCodecs(swigCPtr, this);
  }

/**
 *  
 * @param	n The n'th codec supported by this codec. Lower n are higher 
 *		 priority.  
 * n must be < {@link #getNumSupportedCodecs()}  
 * @return	the {@link CodecId} at the n'th slot, or {@link CodecId.ID_NONE} 
 *		 if none.  
 */
  protected Codec.Id getSupportedCodecId(int n) {
    return Codec.Id.swigToEnum(VideoJNI.ContainerFormat_getSupportedCodecId(swigCPtr, this, n));
  }

/**
 * Get the 32-bit Codec Tag for the n'th codec supported by this container. 
 *  
 * @param	n The n'th codec supported by this codec. Lower n are higher 
 *		 priority.  
 * n must be < {@link #getNumSupportedCodecs()}  
 * @return	the codec tag at the n'th slot, or 0 if none.  
 */
  protected long getSupportedCodecTag(int n) {
    return VideoJNI.ContainerFormat_getSupportedCodecTag(swigCPtr, this, n);
  }

  public enum MediaType {
  /**
   * The type of media contained in a container's stream
   * Usually treated as DATA
   */
    MEDIA_UNKNOWN(VideoJNI.ContainerFormat_MEDIA_UNKNOWN_get()),
  /**
   * Video data
   */
    MEDIA_VIDEO(VideoJNI.ContainerFormat_MEDIA_VIDEO_get()),
  /**
   * Audio data
   */
    MEDIA_AUDIO(VideoJNI.ContainerFormat_MEDIA_AUDIO_get()),
  /**
   * Opaque data, usually continuous
   */
    MEDIA_DATA(VideoJNI.ContainerFormat_MEDIA_DATA_get()),
  /**
   * Subtitle data
   */
    MEDIA_SUBTITLE(VideoJNI.ContainerFormat_MEDIA_SUBTITLE_get()),
  /**
   * Opaque data, usually sparse
   */
    MEDIA_ATTACHMENT(VideoJNI.ContainerFormat_MEDIA_ATTACHMENT_get());

    public final int swigValue() {
      return swigValue;
    }

    public static MediaType swigToEnum(int swigValue) {
      MediaType[] swigValues = MediaType.class.getEnumConstants();
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (MediaType swigEnum : swigValues)
        if (swigEnum.swigValue == swigValue)
          return swigEnum;
      throw new IllegalArgumentException("No enum " + MediaType.class + " with value " + swigValue);
    }

    @SuppressWarnings("unused")
    private MediaType() {
      this.swigValue = SwigNext.next++;
    }

    @SuppressWarnings("unused")
    private MediaType(int swigValue) {
      this.swigValue = swigValue;
      SwigNext.next = swigValue+1;
    }

    @SuppressWarnings("unused")
    private MediaType(MediaType swigEnum) {
      this.swigValue = swigEnum.swigValue;
      SwigNext.next = this.swigValue+1;
    }

    private final int swigValue;

    private static class SwigNext {
      private static int next = 0;
    }
  }

  public enum Flags {
  /**
   * A series of flags that different {@link ContainerFormat}s and their 
   * subclasses
   * can support.
   */
    INVALID_FLAG(VideoJNI.ContainerFormat_INVALID_FLAG_get()),
  /**
   * This format does not use an on-disk file (e.g. a network format) 
   *
   */
    NO_FILE(VideoJNI.ContainerFormat_NO_FILE_get()),
  /**
   * Needs '-643566704' in filename.
   */
    NEED_NUMBER(VideoJNI.ContainerFormat_NEED_NUMBER_get()),
  /**
   * Show format stream IDs numbers.
   */
    SHOW_IDS(VideoJNI.ContainerFormat_SHOW_IDS_get()),
  /**
   * Format wants AVPicture structure for raw picture data.
   */
    RAW_PICTURE(VideoJNI.ContainerFormat_RAW_PICTURE_get()),
  /**
   * Format wants global header.
   */
    GLOBAL_HEADER(VideoJNI.ContainerFormat_GLOBAL_HEADER_get()),
  /**
   * Format does not need have any timestamps.
   */
    NO_TIMESTAMPS(VideoJNI.ContainerFormat_NO_TIMESTAMPS_get()),
  /**
   * Use generic index building code.
   */
    GENERIC_INDEX(VideoJNI.ContainerFormat_GENERIC_INDEX_get()),
  /**
   * Format allows timestamp discontinuities. Note, muxers always require 
   * valid (monotone) timestamps
   */
    TIMESTAMP_DISCONTINUITIES(VideoJNI.ContainerFormat_TIMESTAMP_DISCONTINUITIES_get()),
  /**
   * Format allows variable fps.
   */
    VARIABLE_FPS(VideoJNI.ContainerFormat_VARIABLE_FPS_get()),
  /**
   * Format does not need width/height
   */
    NO_DIMENSIONS(VideoJNI.ContainerFormat_NO_DIMENSIONS_get()),
  /**
   * Format does not require any streams
   */
    NO_STREAMS(VideoJNI.ContainerFormat_NO_STREAMS_get()),
  /**
   * Format does not allow to fallback to binary search via read_timestamp 
   *
   */
    NO_BINARY_SEARCH(VideoJNI.ContainerFormat_NO_BINARY_SEARCH_get()),
  /**
   * Format does not allow to fallback to generic search
   */
    NO_GENERIC_SEARCH(VideoJNI.ContainerFormat_NO_GENERIC_SEARCH_get()),
  /**
   * Format does not allow seeking by bytes
   */
    NO_BYTE_SEEKING(VideoJNI.ContainerFormat_NO_BYTE_SEEKING_get()),
  /**
   * Format allows flushing. If not set, the muxer will not receive a 
   * NULL packet in the write_packet function.
   */
    ALLOW_FLUSH(VideoJNI.ContainerFormat_ALLOW_FLUSH_get()),
  /**
   * Format does not require strictly increasing timestamps, but they 
   * must still be monotonic
   */
    NONSTRICT_TIMESTAMPS(VideoJNI.ContainerFormat_NONSTRICT_TIMESTAMPS_get()),
  /**
   * Seeking is based on PTS
   */
    SEEK_TO_PTS(VideoJNI.ContainerFormat_SEEK_TO_PTS_get());

    public final int swigValue() {
      return swigValue;
    }

    public static Flags swigToEnum(int swigValue) {
      Flags[] swigValues = Flags.class.getEnumConstants();
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (Flags swigEnum : swigValues)
        if (swigEnum.swigValue == swigValue)
          return swigEnum;
      throw new IllegalArgumentException("No enum " + Flags.class + " with value " + swigValue);
    }

    @SuppressWarnings("unused")
    private Flags() {
      this.swigValue = SwigNext.next++;
    }

    @SuppressWarnings("unused")
    private Flags(int swigValue) {
      this.swigValue = swigValue;
      SwigNext.next = swigValue+1;
    }

    @SuppressWarnings("unused")
    private Flags(Flags swigEnum) {
      this.swigValue = swigEnum.swigValue;
      SwigNext.next = this.swigValue+1;
    }

    private final int swigValue;

    private static class SwigNext {
      private static int next = 0;
    }
  }

}
