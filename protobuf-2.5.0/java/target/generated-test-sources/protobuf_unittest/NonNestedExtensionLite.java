// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: com/google/protobuf/non_nested_extension_lite.proto

package protobuf_unittest;

public final class NonNestedExtensionLite {
  private NonNestedExtensionLite() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
    registry.add(protobuf_unittest.NonNestedExtensionLite.nonNestedExtensionLite);
  }
  public interface MessageLiteToBeExtendedOrBuilder extends 
       com.google.protobuf.GeneratedMessageLite.
            ExtendableMessageOrBuilder<MessageLiteToBeExtended> {
  }
  /**
   * Protobuf type {@code protobuf_unittest.MessageLiteToBeExtended}
   */
  public static final class MessageLiteToBeExtended extends
      com.google.protobuf.GeneratedMessageLite.ExtendableMessage<
        MessageLiteToBeExtended> implements MessageLiteToBeExtendedOrBuilder {
    // Use MessageLiteToBeExtended.newBuilder() to construct.
    private MessageLiteToBeExtended(com.google.protobuf.GeneratedMessageLite.ExtendableBuilder<protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended, ?> builder) {
      super(builder);

    }
    private MessageLiteToBeExtended(boolean noInit) {}

    private static final MessageLiteToBeExtended defaultInstance;
    public static MessageLiteToBeExtended getDefaultInstance() {
      return defaultInstance;
    }

    public MessageLiteToBeExtended getDefaultInstanceForType() {
      return defaultInstance;
    }

    private MessageLiteToBeExtended(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input,
                                     extensionRegistry, tag)) {
                done = true;
              }
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
        makeExtensionsImmutable();
      }
    }
    public static com.google.protobuf.Parser<MessageLiteToBeExtended> PARSER =
        new com.google.protobuf.AbstractParser<MessageLiteToBeExtended>() {
      public MessageLiteToBeExtended parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new MessageLiteToBeExtended(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<MessageLiteToBeExtended> getParserForType() {
      return PARSER;
    }

    private void initFields() {
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!extensionsAreInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      com.google.protobuf.GeneratedMessageLite
        .ExtendableMessage<protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended>.ExtensionWriter extensionWriter =
          newExtensionWriter();
      extensionWriter.writeUntil(536870912, output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      size += extensionsSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    /**
     * Protobuf type {@code protobuf_unittest.MessageLiteToBeExtended}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.ExtendableBuilder<
          protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended, Builder> implements protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtendedOrBuilder {
      // Construct using protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended getDefaultInstanceForType() {
        return protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended.getDefaultInstance();
      }

      public protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended build() {
        protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended buildPartial() {
        protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended result = new protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended(this);
        return result;
      }

      public Builder mergeFrom(protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended other) {
        if (other == protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended.getDefaultInstance()) return this;
        this.mergeExtensionFields(other);
        return this;
      }

      public final boolean isInitialized() {
        if (!extensionsAreInitialized()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      // @@protoc_insertion_point(builder_scope:protobuf_unittest.MessageLiteToBeExtended)
    }

    static {
      defaultInstance = new MessageLiteToBeExtended(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:protobuf_unittest.MessageLiteToBeExtended)
  }

  public interface MyNonNestedExtensionLiteOrBuilder
      extends com.google.protobuf.MessageLiteOrBuilder {
  }
  /**
   * Protobuf type {@code protobuf_unittest.MyNonNestedExtensionLite}
   */
  public static final class MyNonNestedExtensionLite extends
      com.google.protobuf.GeneratedMessageLite
      implements MyNonNestedExtensionLiteOrBuilder {
    // Use MyNonNestedExtensionLite.newBuilder() to construct.
    private MyNonNestedExtensionLite(com.google.protobuf.GeneratedMessageLite.Builder builder) {
      super(builder);

    }
    private MyNonNestedExtensionLite(boolean noInit) {}

    private static final MyNonNestedExtensionLite defaultInstance;
    public static MyNonNestedExtensionLite getDefaultInstance() {
      return defaultInstance;
    }

    public MyNonNestedExtensionLite getDefaultInstanceForType() {
      return defaultInstance;
    }

    private MyNonNestedExtensionLite(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input,
                                     extensionRegistry, tag)) {
                done = true;
              }
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
        makeExtensionsImmutable();
      }
    }
    public static com.google.protobuf.Parser<MyNonNestedExtensionLite> PARSER =
        new com.google.protobuf.AbstractParser<MyNonNestedExtensionLite>() {
      public MyNonNestedExtensionLite parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new MyNonNestedExtensionLite(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<MyNonNestedExtensionLite> getParserForType() {
      return PARSER;
    }

    private void initFields() {
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    /**
     * Protobuf type {@code protobuf_unittest.MyNonNestedExtensionLite}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
          protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite, Builder>
        implements protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLiteOrBuilder {
      // Construct using protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private void maybeForceBuilderInitialization() {
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite getDefaultInstanceForType() {
        return protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite.getDefaultInstance();
      }

      public protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite build() {
        protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite buildPartial() {
        protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite result = new protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite(this);
        return result;
      }

      public Builder mergeFrom(protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite other) {
        if (other == protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite.getDefaultInstance()) return this;
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      // @@protoc_insertion_point(builder_scope:protobuf_unittest.MyNonNestedExtensionLite)
    }

    static {
      defaultInstance = new MyNonNestedExtensionLite(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:protobuf_unittest.MyNonNestedExtensionLite)
  }

  public static final int NONNESTEDEXTENSIONLITE_FIELD_NUMBER = 1;
  /**
   * <code>extend .protobuf_unittest.MessageLiteToBeExtended { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessageLite.GeneratedExtension<
      protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended,
      protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite> nonNestedExtensionLite = com.google.protobuf.GeneratedMessageLite
          .newSingularGeneratedExtension(
        protobuf_unittest.NonNestedExtensionLite.MessageLiteToBeExtended.getDefaultInstance(),
        protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite.getDefaultInstance(),
        protobuf_unittest.NonNestedExtensionLite.MyNonNestedExtensionLite.getDefaultInstance(),
        null,
        1,
        com.google.protobuf.WireFormat.FieldType.MESSAGE);

  static {
  }

  // @@protoc_insertion_point(outer_class_scope)
}
