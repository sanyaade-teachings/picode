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

public class Joint implements org.apache.thrift.TBase<Joint, Joint._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Joint");

  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField POSITION_FIELD_DESC = new org.apache.thrift.protocol.TField("position", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField SCREEN_POSITION_FIELD_DESC = new org.apache.thrift.protocol.TField("screenPosition", org.apache.thrift.protocol.TType.STRUCT, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new JointStandardSchemeFactory());
    schemes.put(TupleScheme.class, new JointTupleSchemeFactory());
  }

  /**
   * 
   * @see JointType
   */
  public JointType type; // required
  public Position3D position; // required
  public Position2D screenPosition; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see JointType
     */
    TYPE((short)1, "type"),
    POSITION((short)2, "position"),
    SCREEN_POSITION((short)3, "screenPosition");

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
        case 1: // TYPE
          return TYPE;
        case 2: // POSITION
          return POSITION;
        case 3: // SCREEN_POSITION
          return SCREEN_POSITION;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, JointType.class)));
    tmpMap.put(_Fields.POSITION, new org.apache.thrift.meta_data.FieldMetaData("position", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Position3D.class)));
    tmpMap.put(_Fields.SCREEN_POSITION, new org.apache.thrift.meta_data.FieldMetaData("screenPosition", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Position2D.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Joint.class, metaDataMap);
  }

  public Joint() {
  }

  public Joint(
    JointType type,
    Position3D position,
    Position2D screenPosition)
  {
    this();
    this.type = type;
    this.position = position;
    this.screenPosition = screenPosition;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Joint(Joint other) {
    if (other.isSetType()) {
      this.type = other.type;
    }
    if (other.isSetPosition()) {
      this.position = new Position3D(other.position);
    }
    if (other.isSetScreenPosition()) {
      this.screenPosition = new Position2D(other.screenPosition);
    }
  }

  public Joint deepCopy() {
    return new Joint(this);
  }

  @Override
  public void clear() {
    this.type = null;
    this.position = null;
    this.screenPosition = null;
  }

  /**
   * 
   * @see JointType
   */
  public JointType getType() {
    return this.type;
  }

  /**
   * 
   * @see JointType
   */
  public Joint setType(JointType type) {
    this.type = type;
    return this;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  public Position3D getPosition() {
    return this.position;
  }

  public Joint setPosition(Position3D position) {
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

  public Position2D getScreenPosition() {
    return this.screenPosition;
  }

  public Joint setScreenPosition(Position2D screenPosition) {
    this.screenPosition = screenPosition;
    return this;
  }

  public void unsetScreenPosition() {
    this.screenPosition = null;
  }

  /** Returns true if field screenPosition is set (has been assigned a value) and false otherwise */
  public boolean isSetScreenPosition() {
    return this.screenPosition != null;
  }

  public void setScreenPositionIsSet(boolean value) {
    if (!value) {
      this.screenPosition = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((JointType)value);
      }
      break;

    case POSITION:
      if (value == null) {
        unsetPosition();
      } else {
        setPosition((Position3D)value);
      }
      break;

    case SCREEN_POSITION:
      if (value == null) {
        unsetScreenPosition();
      } else {
        setScreenPosition((Position2D)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TYPE:
      return getType();

    case POSITION:
      return getPosition();

    case SCREEN_POSITION:
      return getScreenPosition();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TYPE:
      return isSetType();
    case POSITION:
      return isSetPosition();
    case SCREEN_POSITION:
      return isSetScreenPosition();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Joint)
      return this.equals((Joint)that);
    return false;
  }

  public boolean equals(Joint that) {
    if (that == null)
      return false;

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
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

    boolean this_present_screenPosition = true && this.isSetScreenPosition();
    boolean that_present_screenPosition = true && that.isSetScreenPosition();
    if (this_present_screenPosition || that_present_screenPosition) {
      if (!(this_present_screenPosition && that_present_screenPosition))
        return false;
      if (!this.screenPosition.equals(that.screenPosition))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Joint other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Joint typedOther = (Joint)other;

    lastComparison = Boolean.valueOf(isSetType()).compareTo(typedOther.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, typedOther.type);
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
    lastComparison = Boolean.valueOf(isSetScreenPosition()).compareTo(typedOther.isSetScreenPosition());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetScreenPosition()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.screenPosition, typedOther.screenPosition);
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
    StringBuilder sb = new StringBuilder("Joint(");
    boolean first = true;

    sb.append("type:");
    if (this.type == null) {
      sb.append("null");
    } else {
      sb.append(this.type);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("position:");
    if (this.position == null) {
      sb.append("null");
    } else {
      sb.append(this.position);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("screenPosition:");
    if (this.screenPosition == null) {
      sb.append("null");
    } else {
      sb.append(this.screenPosition);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (type == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'type' was not present! Struct: " + toString());
    }
    if (position == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'position' was not present! Struct: " + toString());
    }
    if (screenPosition == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'screenPosition' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (position != null) {
      position.validate();
    }
    if (screenPosition != null) {
      screenPosition.validate();
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class JointStandardSchemeFactory implements SchemeFactory {
    public JointStandardScheme getScheme() {
      return new JointStandardScheme();
    }
  }

  private static class JointStandardScheme extends StandardScheme<Joint> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Joint struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.type = JointType.findByValue(iprot.readI32());
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // POSITION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.position = new Position3D();
              struct.position.read(iprot);
              struct.setPositionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SCREEN_POSITION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.screenPosition = new Position2D();
              struct.screenPosition.read(iprot);
              struct.setScreenPositionIsSet(true);
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Joint struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.type != null) {
        oprot.writeFieldBegin(TYPE_FIELD_DESC);
        oprot.writeI32(struct.type.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.position != null) {
        oprot.writeFieldBegin(POSITION_FIELD_DESC);
        struct.position.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.screenPosition != null) {
        oprot.writeFieldBegin(SCREEN_POSITION_FIELD_DESC);
        struct.screenPosition.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class JointTupleSchemeFactory implements SchemeFactory {
    public JointTupleScheme getScheme() {
      return new JointTupleScheme();
    }
  }

  private static class JointTupleScheme extends TupleScheme<Joint> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Joint struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.type.getValue());
      struct.position.write(oprot);
      struct.screenPosition.write(oprot);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Joint struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.type = JointType.findByValue(iprot.readI32());
      struct.setTypeIsSet(true);
      struct.position = new Position3D();
      struct.position.read(iprot);
      struct.setPositionIsSet(true);
      struct.screenPosition = new Position2D();
      struct.screenPosition.read(iprot);
      struct.setScreenPositionIsSet(true);
    }
  }

}
