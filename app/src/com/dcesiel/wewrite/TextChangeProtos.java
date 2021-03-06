// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: com/dcesiel/wewrite/changetextprotos.proto

package com.dcesiel.wewrite;

public final class TextChangeProtos {
  private TextChangeProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface TextChangeOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required int32 session = 1;
    /**
     * <code>required int32 session = 1;</code>
     *
     * <pre>
     *Session number
     * </pre>
     */
    boolean hasSession();
    /**
     * <code>required int32 session = 1;</code>
     *
     * <pre>
     *Session number
     * </pre>
     */
    int getSession();

    // optional bool added = 2;
    /**
     * <code>optional bool added = 2;</code>
     *
     * <pre>
     *Added||deleted.  If true, user added text.  If false, user deleted text.
     * </pre>
     */
    boolean hasAdded();
    /**
     * <code>optional bool added = 2;</code>
     *
     * <pre>
     *Added||deleted.  If true, user added text.  If false, user deleted text.
     * </pre>
     */
    boolean getAdded();

    // optional int32 position = 3;
    /**
     * <code>optional int32 position = 3;</code>
     *
     * <pre>
     *Position of add (after which char index)
     * </pre>
     */
    boolean hasPosition();
    /**
     * <code>optional int32 position = 3;</code>
     *
     * <pre>
     *Position of add (after which char index)
     * </pre>
     */
    int getPosition();

    // optional int32 count = 4;
    /**
     * <code>optional int32 count = 4;</code>
     *
     * <pre>
     *Number of values added or deleted
     * </pre>
     */
    boolean hasCount();
    /**
     * <code>optional int32 count = 4;</code>
     *
     * <pre>
     *Number of values added or deleted
     * </pre>
     */
    int getCount();

    // optional string addString = 5;
    /**
     * <code>optional string addString = 5;</code>
     *
     * <pre>
     *String added
     * </pre>
     */
    boolean hasAddString();
    /**
     * <code>optional string addString = 5;</code>
     *
     * <pre>
     *String added
     * </pre>
     */
    java.lang.String getAddString();
    /**
     * <code>optional string addString = 5;</code>
     *
     * <pre>
     *String added
     * </pre>
     */
    com.google.protobuf.ByteString
        getAddStringBytes();
  }
  /**
   * Protobuf type {@code wewrite.TextChange}
   */
  public static final class TextChange extends
      com.google.protobuf.GeneratedMessage
      implements TextChangeOrBuilder {
    // Use TextChange.newBuilder() to construct.
    private TextChange(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private TextChange(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final TextChange defaultInstance;
    public static TextChange getDefaultInstance() {
      return defaultInstance;
    }

    public TextChange getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private TextChange(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              session_ = input.readInt32();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              added_ = input.readBool();
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              position_ = input.readInt32();
              break;
            }
            case 32: {
              bitField0_ |= 0x00000008;
              count_ = input.readInt32();
              break;
            }
            case 42: {
              bitField0_ |= 0x00000010;
              addString_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dcesiel.wewrite.TextChangeProtos.internal_static_wewrite_TextChange_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dcesiel.wewrite.TextChangeProtos.internal_static_wewrite_TextChange_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dcesiel.wewrite.TextChangeProtos.TextChange.class, com.dcesiel.wewrite.TextChangeProtos.TextChange.Builder.class);
    }

    public static com.google.protobuf.Parser<TextChange> PARSER =
        new com.google.protobuf.AbstractParser<TextChange>() {
      public TextChange parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new TextChange(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<TextChange> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required int32 session = 1;
    public static final int SESSION_FIELD_NUMBER = 1;
    private int session_;
    /**
     * <code>required int32 session = 1;</code>
     *
     * <pre>
     *Session number
     * </pre>
     */
    public boolean hasSession() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int32 session = 1;</code>
     *
     * <pre>
     *Session number
     * </pre>
     */
    public int getSession() {
      return session_;
    }

    // optional bool added = 2;
    public static final int ADDED_FIELD_NUMBER = 2;
    private boolean added_;
    /**
     * <code>optional bool added = 2;</code>
     *
     * <pre>
     *Added||deleted.  If true, user added text.  If false, user deleted text.
     * </pre>
     */
    public boolean hasAdded() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional bool added = 2;</code>
     *
     * <pre>
     *Added||deleted.  If true, user added text.  If false, user deleted text.
     * </pre>
     */
    public boolean getAdded() {
      return added_;
    }

    // optional int32 position = 3;
    public static final int POSITION_FIELD_NUMBER = 3;
    private int position_;
    /**
     * <code>optional int32 position = 3;</code>
     *
     * <pre>
     *Position of add (after which char index)
     * </pre>
     */
    public boolean hasPosition() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional int32 position = 3;</code>
     *
     * <pre>
     *Position of add (after which char index)
     * </pre>
     */
    public int getPosition() {
      return position_;
    }

    // optional int32 count = 4;
    public static final int COUNT_FIELD_NUMBER = 4;
    private int count_;
    /**
     * <code>optional int32 count = 4;</code>
     *
     * <pre>
     *Number of values added or deleted
     * </pre>
     */
    public boolean hasCount() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional int32 count = 4;</code>
     *
     * <pre>
     *Number of values added or deleted
     * </pre>
     */
    public int getCount() {
      return count_;
    }

    // optional string addString = 5;
    public static final int ADDSTRING_FIELD_NUMBER = 5;
    private java.lang.Object addString_;
    /**
     * <code>optional string addString = 5;</code>
     *
     * <pre>
     *String added
     * </pre>
     */
    public boolean hasAddString() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional string addString = 5;</code>
     *
     * <pre>
     *String added
     * </pre>
     */
    public java.lang.String getAddString() {
      java.lang.Object ref = addString_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          addString_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string addString = 5;</code>
     *
     * <pre>
     *String added
     * </pre>
     */
    public com.google.protobuf.ByteString
        getAddStringBytes() {
      java.lang.Object ref = addString_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        addString_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      session_ = 0;
      added_ = false;
      position_ = 0;
      count_ = 0;
      addString_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasSession()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, session_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBool(2, added_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeInt32(3, position_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeInt32(4, count_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        output.writeBytes(5, getAddStringBytes());
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, session_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(2, added_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, position_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, count_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(5, getAddStringBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.dcesiel.wewrite.TextChangeProtos.TextChange parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.dcesiel.wewrite.TextChangeProtos.TextChange parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.dcesiel.wewrite.TextChangeProtos.TextChange parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.dcesiel.wewrite.TextChangeProtos.TextChange parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.dcesiel.wewrite.TextChangeProtos.TextChange parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.dcesiel.wewrite.TextChangeProtos.TextChange parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.dcesiel.wewrite.TextChangeProtos.TextChange parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.dcesiel.wewrite.TextChangeProtos.TextChange parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.dcesiel.wewrite.TextChangeProtos.TextChange parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.dcesiel.wewrite.TextChangeProtos.TextChange parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.dcesiel.wewrite.TextChangeProtos.TextChange prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code wewrite.TextChange}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.dcesiel.wewrite.TextChangeProtos.TextChangeOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.dcesiel.wewrite.TextChangeProtos.internal_static_wewrite_TextChange_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.dcesiel.wewrite.TextChangeProtos.internal_static_wewrite_TextChange_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.dcesiel.wewrite.TextChangeProtos.TextChange.class, com.dcesiel.wewrite.TextChangeProtos.TextChange.Builder.class);
      }

      // Construct using com.dcesiel.wewrite.TextChangeProtos.TextChange.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        session_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        added_ = false;
        bitField0_ = (bitField0_ & ~0x00000002);
        position_ = 0;
        bitField0_ = (bitField0_ & ~0x00000004);
        count_ = 0;
        bitField0_ = (bitField0_ & ~0x00000008);
        addString_ = "";
        bitField0_ = (bitField0_ & ~0x00000010);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.dcesiel.wewrite.TextChangeProtos.internal_static_wewrite_TextChange_descriptor;
      }

      public com.dcesiel.wewrite.TextChangeProtos.TextChange getDefaultInstanceForType() {
        return com.dcesiel.wewrite.TextChangeProtos.TextChange.getDefaultInstance();
      }

      public com.dcesiel.wewrite.TextChangeProtos.TextChange build() {
        com.dcesiel.wewrite.TextChangeProtos.TextChange result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.dcesiel.wewrite.TextChangeProtos.TextChange buildPartial() {
        com.dcesiel.wewrite.TextChangeProtos.TextChange result = new com.dcesiel.wewrite.TextChangeProtos.TextChange(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.session_ = session_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.added_ = added_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.position_ = position_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.count_ = count_;
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000010;
        }
        result.addString_ = addString_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.dcesiel.wewrite.TextChangeProtos.TextChange) {
          return mergeFrom((com.dcesiel.wewrite.TextChangeProtos.TextChange)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.dcesiel.wewrite.TextChangeProtos.TextChange other) {
        if (other == com.dcesiel.wewrite.TextChangeProtos.TextChange.getDefaultInstance()) return this;
        if (other.hasSession()) {
          setSession(other.getSession());
        }
        if (other.hasAdded()) {
          setAdded(other.getAdded());
        }
        if (other.hasPosition()) {
          setPosition(other.getPosition());
        }
        if (other.hasCount()) {
          setCount(other.getCount());
        }
        if (other.hasAddString()) {
          bitField0_ |= 0x00000010;
          addString_ = other.addString_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasSession()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.dcesiel.wewrite.TextChangeProtos.TextChange parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.dcesiel.wewrite.TextChangeProtos.TextChange) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required int32 session = 1;
      private int session_ ;
      /**
       * <code>required int32 session = 1;</code>
       *
       * <pre>
       *Session number
       * </pre>
       */
      public boolean hasSession() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int32 session = 1;</code>
       *
       * <pre>
       *Session number
       * </pre>
       */
      public int getSession() {
        return session_;
      }
      /**
       * <code>required int32 session = 1;</code>
       *
       * <pre>
       *Session number
       * </pre>
       */
      public Builder setSession(int value) {
        bitField0_ |= 0x00000001;
        session_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 session = 1;</code>
       *
       * <pre>
       *Session number
       * </pre>
       */
      public Builder clearSession() {
        bitField0_ = (bitField0_ & ~0x00000001);
        session_ = 0;
        onChanged();
        return this;
      }

      // optional bool added = 2;
      private boolean added_ ;
      /**
       * <code>optional bool added = 2;</code>
       *
       * <pre>
       *Added||deleted.  If true, user added text.  If false, user deleted text.
       * </pre>
       */
      public boolean hasAdded() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional bool added = 2;</code>
       *
       * <pre>
       *Added||deleted.  If true, user added text.  If false, user deleted text.
       * </pre>
       */
      public boolean getAdded() {
        return added_;
      }
      /**
       * <code>optional bool added = 2;</code>
       *
       * <pre>
       *Added||deleted.  If true, user added text.  If false, user deleted text.
       * </pre>
       */
      public Builder setAdded(boolean value) {
        bitField0_ |= 0x00000002;
        added_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bool added = 2;</code>
       *
       * <pre>
       *Added||deleted.  If true, user added text.  If false, user deleted text.
       * </pre>
       */
      public Builder clearAdded() {
        bitField0_ = (bitField0_ & ~0x00000002);
        added_ = false;
        onChanged();
        return this;
      }

      // optional int32 position = 3;
      private int position_ ;
      /**
       * <code>optional int32 position = 3;</code>
       *
       * <pre>
       *Position of add (after which char index)
       * </pre>
       */
      public boolean hasPosition() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>optional int32 position = 3;</code>
       *
       * <pre>
       *Position of add (after which char index)
       * </pre>
       */
      public int getPosition() {
        return position_;
      }
      /**
       * <code>optional int32 position = 3;</code>
       *
       * <pre>
       *Position of add (after which char index)
       * </pre>
       */
      public Builder setPosition(int value) {
        bitField0_ |= 0x00000004;
        position_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 position = 3;</code>
       *
       * <pre>
       *Position of add (after which char index)
       * </pre>
       */
      public Builder clearPosition() {
        bitField0_ = (bitField0_ & ~0x00000004);
        position_ = 0;
        onChanged();
        return this;
      }

      // optional int32 count = 4;
      private int count_ ;
      /**
       * <code>optional int32 count = 4;</code>
       *
       * <pre>
       *Number of values added or deleted
       * </pre>
       */
      public boolean hasCount() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>optional int32 count = 4;</code>
       *
       * <pre>
       *Number of values added or deleted
       * </pre>
       */
      public int getCount() {
        return count_;
      }
      /**
       * <code>optional int32 count = 4;</code>
       *
       * <pre>
       *Number of values added or deleted
       * </pre>
       */
      public Builder setCount(int value) {
        bitField0_ |= 0x00000008;
        count_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 count = 4;</code>
       *
       * <pre>
       *Number of values added or deleted
       * </pre>
       */
      public Builder clearCount() {
        bitField0_ = (bitField0_ & ~0x00000008);
        count_ = 0;
        onChanged();
        return this;
      }

      // optional string addString = 5;
      private java.lang.Object addString_ = "";
      /**
       * <code>optional string addString = 5;</code>
       *
       * <pre>
       *String added
       * </pre>
       */
      public boolean hasAddString() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>optional string addString = 5;</code>
       *
       * <pre>
       *String added
       * </pre>
       */
      public java.lang.String getAddString() {
        java.lang.Object ref = addString_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          addString_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string addString = 5;</code>
       *
       * <pre>
       *String added
       * </pre>
       */
      public com.google.protobuf.ByteString
          getAddStringBytes() {
        java.lang.Object ref = addString_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          addString_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string addString = 5;</code>
       *
       * <pre>
       *String added
       * </pre>
       */
      public Builder setAddString(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
        addString_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string addString = 5;</code>
       *
       * <pre>
       *String added
       * </pre>
       */
      public Builder clearAddString() {
        bitField0_ = (bitField0_ & ~0x00000010);
        addString_ = getDefaultInstance().getAddString();
        onChanged();
        return this;
      }
      /**
       * <code>optional string addString = 5;</code>
       *
       * <pre>
       *String added
       * </pre>
       */
      public Builder setAddStringBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
        addString_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:wewrite.TextChange)
    }

    static {
      defaultInstance = new TextChange(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:wewrite.TextChange)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_wewrite_TextChange_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_wewrite_TextChange_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n*com/dcesiel/wewrite/changetextprotos.p" +
      "roto\022\007wewrite\"`\n\nTextChange\022\017\n\007session\030\001" +
      " \002(\005\022\r\n\005added\030\002 \001(\010\022\020\n\010position\030\003 \001(\005\022\r\n" +
      "\005count\030\004 \001(\005\022\021\n\taddString\030\005 \001(\tB\'\n\023com.d" +
      "cesiel.wewriteB\020TextChangeProtos"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_wewrite_TextChange_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_wewrite_TextChange_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_wewrite_TextChange_descriptor,
              new java.lang.String[] { "Session", "Added", "Position", "Count", "AddString", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
