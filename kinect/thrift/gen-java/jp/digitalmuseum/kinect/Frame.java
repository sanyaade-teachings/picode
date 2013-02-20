/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package jp.digitalmuseum.kinect;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Frame implements org.apache.thrift.TBase<Frame, Frame._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Frame");

  private static final org.apache.thrift.protocol.TField FRAME_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("frameId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField IMAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("image", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField POSITION_FIELD_DESC = new org.apache.thrift.protocol.TField("position", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField JOINTS_FIELD_DESC = new org.apache.thrift.protocol.TField("joints", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField KEYWORDS_FIELD_DESC = new org.apache.thrift.protocol.TField("keywords", org.apache.thrift.protocol.TType.SET, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new FrameStandardSchemeFactory());
    schemes.put(TupleScheme.class, new FrameTupleSchemeFactory());
  }

  public int frameId; // required
  public ByteBuffer image; // required
  public Position3D position; // optional
  public List<Joint> joints; // optional
  public Set<String> keywords; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FRAME_ID((short)1, "frameId"),
    IMAGE((short)2, "image"),
    POSITION((short)3, "position"),
    JOINTS((short)4, "joints"),
    KEYWORDS((short)5, "keywords");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // FRAME_ID
          return FRAME_ID;
        case 2: // IMAGE
          return IMAGE;
        case 3: // POSITION
          return POSITION;
        case 4: // JOINTS
          return JOINTS;
        case 5: // KEYWORDS
          return KEYWORDS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __FRAMEID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.POSITION,_Fields.JOINTS,_Fields.KEYWORDS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FRAME_ID, new org.apache.thrift.meta_data.FieldMetaData("frameId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.IMAGE, new org.apache.thrift.meta_data.FieldMetaData("image", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.POSITION, new org.apache.thrift.meta_data.FieldMetaData("position", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Position3D.class)));
    tmpMap.put(_Fields.JOINTS, new org.apache.thrift.meta_data.FieldMetaData("joints", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Joint.class))));
    tmpMap.put(_Fields.KEYWORDS, new org.apache.thrift.meta_data.FieldMetaData("keywords", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Frame.class, metaDataMap);
  }

  public Frame() {
  }

  public Frame(
    int frameId,
    ByteBuffer image)
  {
    this();
    this.frameId = frameId;
    setFrameIdIsSet(true);
    this.image = image;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Frame(Frame other) {
    __isset_bitfield = other.__isset_bitfield;
    this.frameId = other.frameId;
    if (other.isSetImage()) {
      this.image = org.apache.thrift.TBaseHelper.copyBinary(other.image);
;
    }
    if (other.isSetPosition()) {
      this.position = new Position3D(other.position);
    }
    if (other.isSetJoints()) {
      List<Joint> __this__joints = new ArrayList<Joint>();
      for (Joint other_element : other.joints) {
        __this__joints.add(new Joint(other_element));
      }
      this.joints = __this__joints;
    }
    if (other.isSetKeywords()) {
      Set<String> __this__keywords = new HashSet<String>();
      for (String other_element : other.keywords) {
        __this__keywords.add(other_element);
      }
      this.keywords = __this__keywords;
    }
  }

  public Frame deepCopy() {
    return new Frame(this);
  }

  @Override
  public void clear() {
    setFrameIdIsSet(false);
    this.frameId = 0;
    this.image = null;
    this.position = null;
    this.joints = null;
    this.keywords = null;
  }

  public int getFrameId() {
    return this.frameId;
  }

  public Frame setFrameId(int frameId) {
    this.frameId = frameId;
    setFrameIdIsSet(true);
    return this;
  }

  public void unsetFrameId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __FRAMEID_ISSET_ID);
  }

  /** Returns true if field frameId is set (has been assigned a value) and false otherwise */
  public boolean isSetFrameId() {
    return EncodingUtils.testBit(__isset_bitfield, __FRAMEID_ISSET_ID);
  }

  public void setFrameIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __FRAMEID_ISSET_ID, value);
  }

  public byte[] getImage() {
    setImage(org.apache.thrift.TBaseHelper.rightSize(image));
    return image == null ? null : image.array();
  }

  public ByteBuffer bufferForImage() {
    return image;
  }

  public Frame setImage(byte[] image) {
    setImage(image == null ? (ByteBuffer)null : ByteBuffer.wrap(image));
    return this;
  }

  public Frame setImage(ByteBuffer image) {
    this.image = image;
    return this;
  }

  public void unsetImage() {
    this.image = null;
  }

  /** Returns true if field image is set (has been assigned a value) and false otherwise */
  public boolean isSetImage() {
    return this.image != null;
  }

  public void setImageIsSet(boolean value) {
    if (!value) {
      this.image = null;
    }
  }

  public Position3D getPosition() {
    return this.position;
  }

  public Frame setPosition(Position3D position) {
    this.position = position;
    return this;
  }

  public void unsetPosition() {
    this.position = null;
  }

  /** Returns true if field position is set (has been assigned a value) and false otherwise */
  public boolean isSetPosition() {
    return this.position != null;
  }

  public void setPositionIsSet(boolean value) {
    if (!value) {
      this.position = null;
    }
  }

  public int getJointsSize() {
    return (this.joints == null) ? 0 : this.joints.size();
  }

  public java.util.Iterator<Joint> getJointsIterator() {
    return (this.joints == null) ? null : this.joints.iterator();
  }

  public void addToJoints(Joint elem) {
    if (this.joints == null) {
      this.joints = new ArrayList<Joint>();
    }
    this.joints.add(elem);
  }

  public List<Joint> getJoints() {
    return this.joints;
  }

  public Frame setJoints(List<Joint> joints) {
    this.joints = joints;
    return this;
  }

  public void unsetJoints() {
    this.joints = null;
  }

  /** Returns true if field joints is set (has been assigned a value) and false otherwise */
  public boolean isSetJoints() {
    return this.joints != null;
  }

  public void setJointsIsSet(boolean value) {
    if (!value) {
      this.joints = null;
    }
  }

  public int getKeywordsSize() {
    return (this.keywords == null) ? 0 : this.keywords.size();
  }

  public java.util.Iterator<String> getKeywordsIterator() {
    return (this.keywords == null) ? null : this.keywords.iterator();
  }

  public void addToKeywords(String elem) {
    if (this.keywords == null) {
      this.keywords = new HashSet<String>();
    }
    this.keywords.add(elem);
  }

  public Set<String> getKeywords() {
    return this.keywords;
  }

  public Frame setKeywords(Set<String> keywords) {
    this.keywords = keywords;
    return this;
  }

  public void unsetKeywords() {
    this.keywords = null;
  }

  /** Returns true if field keywords is set (has been assigned a value) and false otherwise */
  public boolean isSetKeywords() {
    return this.keywords != null;
  }

  public void setKeywordsIsSet(boolean value) {
    if (!value) {
      this.keywords = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case FRAME_ID:
      if (value == null) {
        unsetFrameId();
      } else {
        setFrameId((Integer)value);
      }
      break;

    case IMAGE:
      if (value == null) {
        unsetImage();
      } else {
        setImage((ByteBuffer)value);
      }
      break;

    case POSITION:
      if (value == null) {
        unsetPosition();
      } else {
        setPosition((Position3D)value);
      }
      break;

    case JOINTS:
      if (value == null) {
        unsetJoints();
      } else {
        setJoints((List<Joint>)value);
      }
      break;

    case KEYWORDS:
      if (value == null) {
        unsetKeywords();
      } else {
        setKeywords((Set<String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case FRAME_ID:
      return Integer.valueOf(getFrameId());

    case IMAGE:
      return getImage();

    case POSITION:
      return getPosition();

    case JOINTS:
      return getJoints();

    case KEYWORDS:
      return getKeywords();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case FRAME_ID:
      return isSetFrameId();
    case IMAGE:
      return isSetImage();
    case POSITION:
      return isSetPosition();
    case JOINTS:
      return isSetJoints();
    case KEYWORDS:
      return isSetKeywords();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Frame)
      return this.equals((Frame)that);
    return false;
  }

  public boolean equals(Frame that) {
    if (that == null)
      return false;

    boolean this_present_frameId = true;
    boolean that_present_frameId = true;
    if (this_present_frameId || that_present_frameId) {
      if (!(this_present_frameId && that_present_frameId))
        return false;
      if (this.frameId != that.frameId)
        return false;
    }

    boolean this_present_image = true && this.isSetImage();
    boolean that_present_image = true && that.isSetImage();
    if (this_present_image || that_present_image) {
      if (!(this_present_image && that_present_image))
        return false;
      if (!this.image.equals(that.image))
        return false;
    }

    boolean this_present_position = true && this.isSetPosition();
    boolean that_present_position = true && that.isSetPosition();
    if (this_present_position || that_present_position) {
      if (!(this_present_position && that_present_position))
        return false;
      if (!this.position.equals(that.position))
        return false;
    }

    boolean this_present_joints = true && this.isSetJoints();
    boolean that_present_joints = true && that.isSetJoints();
    if (this_present_joints || that_present_joints) {
      if (!(this_present_joints && that_present_joints))
        return false;
      if (!this.joints.equals(that.joints))
        return false;
    }

    boolean this_present_keywords = true && this.isSetKeywords();
    boolean that_present_keywords = true && that.isSetKeywords();
    if (this_present_keywords || that_present_keywords) {
      if (!(this_present_keywords && that_present_keywords))
        return false;
      if (!this.keywords.equals(that.keywords))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Frame other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Frame typedOther = (Frame)other;

    lastComparison = Boolean.valueOf(isSetFrameId()).compareTo(typedOther.isSetFrameId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFrameId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.frameId, typedOther.frameId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetImage()).compareTo(typedOther.isSetImage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetImage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.image, typedOther.image);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPosition()).compareTo(typedOther.isSetPosition());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPosition()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.position, typedOther.position);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetJoints()).compareTo(typedOther.isSetJoints());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJoints()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.joints, typedOther.joints);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetKeywords()).compareTo(typedOther.isSetKeywords());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetKeywords()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.keywords, typedOther.keywords);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Frame(");
    boolean first = true;

    sb.append("frameId:");
    sb.append(this.frameId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("image:");
    if (this.image == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.image, sb);
    }
    first = false;
    if (isSetPosition()) {
      if (!first) sb.append(", ");
      sb.append("position:");
      if (this.position == null) {
        sb.append("null");
      } else {
        sb.append(this.position);
      }
      first = false;
    }
    if (isSetJoints()) {
      if (!first) sb.append(", ");
      sb.append("joints:");
      if (this.joints == null) {
        sb.append("null");
      } else {
        sb.append(this.joints);
      }
      first = false;
    }
    if (isSetKeywords()) {
      if (!first) sb.append(", ");
      sb.append("keywords:");
      if (this.keywords == null) {
        sb.append("null");
      } else {
        sb.append(this.keywords);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'frameId' because it's a primitive and you chose the non-beans generator.
    if (image == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'image' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (position != null) {
      position.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class FrameStandardSchemeFactory implements SchemeFactory {
    public FrameStandardScheme getScheme() {
      return new FrameStandardScheme();
    }
  }

  private static class FrameStandardScheme extends StandardScheme<Frame> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Frame struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FRAME_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.frameId = iprot.readI32();
              struct.setFrameIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // IMAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.image = iprot.readBinary();
              struct.setImageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // POSITION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.position = new Position3D();
              struct.position.read(iprot);
              struct.setPositionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // JOINTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.joints = new ArrayList<Joint>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  Joint _elem2; // required
                  _elem2 = new Joint();
                  _elem2.read(iprot);
                  struct.joints.add(_elem2);
                }
                iprot.readListEnd();
              }
              struct.setJointsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // KEYWORDS
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set3 = iprot.readSetBegin();
                struct.keywords = new HashSet<String>(2*_set3.size);
                for (int _i4 = 0; _i4 < _set3.size; ++_i4)
                {
                  String _elem5; // required
                  _elem5 = iprot.readString();
                  struct.keywords.add(_elem5);
                }
                iprot.readSetEnd();
              }
              struct.setKeywordsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetFrameId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'frameId' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Frame struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(FRAME_ID_FIELD_DESC);
      oprot.writeI32(struct.frameId);
      oprot.writeFieldEnd();
      if (struct.image != null) {
        oprot.writeFieldBegin(IMAGE_FIELD_DESC);
        oprot.writeBinary(struct.image);
        oprot.writeFieldEnd();
      }
      if (struct.position != null) {
        if (struct.isSetPosition()) {
          oprot.writeFieldBegin(POSITION_FIELD_DESC);
          struct.position.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.joints != null) {
        if (struct.isSetJoints()) {
          oprot.writeFieldBegin(JOINTS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.joints.size()));
            for (Joint _iter6 : struct.joints)
            {
              _iter6.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.keywords != null) {
        if (struct.isSetKeywords()) {
          oprot.writeFieldBegin(KEYWORDS_FIELD_DESC);
          {
            oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRING, struct.keywords.size()));
            for (String _iter7 : struct.keywords)
            {
              oprot.writeString(_iter7);
            }
            oprot.writeSetEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FrameTupleSchemeFactory implements SchemeFactory {
    public FrameTupleScheme getScheme() {
      return new FrameTupleScheme();
    }
  }

  private static class FrameTupleScheme extends TupleScheme<Frame> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Frame struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.frameId);
      oprot.writeBinary(struct.image);
      BitSet optionals = new BitSet();
      if (struct.isSetPosition()) {
        optionals.set(0);
      }
      if (struct.isSetJoints()) {
        optionals.set(1);
      }
      if (struct.isSetKeywords()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetPosition()) {
        struct.position.write(oprot);
      }
      if (struct.isSetJoints()) {
        {
          oprot.writeI32(struct.joints.size());
          for (Joint _iter8 : struct.joints)
          {
            _iter8.write(oprot);
          }
        }
      }
      if (struct.isSetKeywords()) {
        {
          oprot.writeI32(struct.keywords.size());
          for (String _iter9 : struct.keywords)
          {
            oprot.writeString(_iter9);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Frame struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.frameId = iprot.readI32();
      struct.setFrameIdIsSet(true);
      struct.image = iprot.readBinary();
      struct.setImageIsSet(true);
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.position = new Position3D();
        struct.position.read(iprot);
        struct.setPositionIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list10 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.joints = new ArrayList<Joint>(_list10.size);
          for (int _i11 = 0; _i11 < _list10.size; ++_i11)
          {
            Joint _elem12; // required
            _elem12 = new Joint();
            _elem12.read(iprot);
            struct.joints.add(_elem12);
          }
        }
        struct.setJointsIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TSet _set13 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.keywords = new HashSet<String>(2*_set13.size);
          for (int _i14 = 0; _i14 < _set13.size; ++_i14)
          {
            String _elem15; // required
            _elem15 = iprot.readString();
            struct.keywords.add(_elem15);
          }
        }
        struct.setKeywordsIsSet(true);
      }
    }
  }

}

