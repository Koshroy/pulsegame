/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package edu.illinois.ece.pulsegame;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
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

/**
 * A wrapper for all the state needed between turns. Both players receieve the
 * same state, except for the user field, which has user-specific state.
 */
public class State implements org.apache.thrift.TBase<State, State._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("State");

  private static final org.apache.thrift.protocol.TField WORLD_FIELD_DESC = new org.apache.thrift.protocol.TField("world", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField TURN_NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("turnNum", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField USER_FIELD_DESC = new org.apache.thrift.protocol.TField("user", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField HAS_LOST_FIELD_DESC = new org.apache.thrift.protocol.TField("hasLost", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField ITS_ON_FIELD_DESC = new org.apache.thrift.protocol.TField("itsOn", org.apache.thrift.protocol.TType.BOOL, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new StateStandardSchemeFactory());
    schemes.put(TupleScheme.class, new StateTupleSchemeFactory());
  }

  public WorldState world; // optional
  public int turnNum; // optional
  public UserState user; // optional
  /**
   * Tells you who has lost so far.
   */
  public List<Boolean> hasLost; // optional
  /**
   * If it's on, you should keep playing.
   */
  public boolean itsOn; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    WORLD((short)1, "world"),
    TURN_NUM((short)2, "turnNum"),
    USER((short)3, "user"),
    /**
     * Tells you who has lost so far.
     */
    HAS_LOST((short)4, "hasLost"),
    /**
     * If it's on, you should keep playing.
     */
    ITS_ON((short)5, "itsOn");

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
        case 1: // WORLD
          return WORLD;
        case 2: // TURN_NUM
          return TURN_NUM;
        case 3: // USER
          return USER;
        case 4: // HAS_LOST
          return HAS_LOST;
        case 5: // ITS_ON
          return ITS_ON;
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
  private static final int __TURNNUM_ISSET_ID = 0;
  private static final int __ITSON_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);
  private _Fields optionals[] = {_Fields.WORLD,_Fields.TURN_NUM,_Fields.USER,_Fields.HAS_LOST,_Fields.ITS_ON};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.WORLD, new org.apache.thrift.meta_data.FieldMetaData("world", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, WorldState.class)));
    tmpMap.put(_Fields.TURN_NUM, new org.apache.thrift.meta_data.FieldMetaData("turnNum", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.USER, new org.apache.thrift.meta_data.FieldMetaData("user", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, UserState.class)));
    tmpMap.put(_Fields.HAS_LOST, new org.apache.thrift.meta_data.FieldMetaData("hasLost", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL))));
    tmpMap.put(_Fields.ITS_ON, new org.apache.thrift.meta_data.FieldMetaData("itsOn", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(State.class, metaDataMap);
  }

  public State() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public State(State other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetWorld()) {
      this.world = new WorldState(other.world);
    }
    this.turnNum = other.turnNum;
    if (other.isSetUser()) {
      this.user = new UserState(other.user);
    }
    if (other.isSetHasLost()) {
      List<Boolean> __this__hasLost = new ArrayList<Boolean>();
      for (Boolean other_element : other.hasLost) {
        __this__hasLost.add(other_element);
      }
      this.hasLost = __this__hasLost;
    }
    this.itsOn = other.itsOn;
  }

  public State deepCopy() {
    return new State(this);
  }

  @Override
  public void clear() {
    this.world = null;
    setTurnNumIsSet(false);
    this.turnNum = 0;
    this.user = null;
    this.hasLost = null;
    setItsOnIsSet(false);
    this.itsOn = false;
  }

  public WorldState getWorld() {
    return this.world;
  }

  public State setWorld(WorldState world) {
    this.world = world;
    return this;
  }

  public void unsetWorld() {
    this.world = null;
  }

  /** Returns true if field world is set (has been assigned a value) and false otherwise */
  public boolean isSetWorld() {
    return this.world != null;
  }

  public void setWorldIsSet(boolean value) {
    if (!value) {
      this.world = null;
    }
  }

  public int getTurnNum() {
    return this.turnNum;
  }

  public State setTurnNum(int turnNum) {
    this.turnNum = turnNum;
    setTurnNumIsSet(true);
    return this;
  }

  public void unsetTurnNum() {
    __isset_bit_vector.clear(__TURNNUM_ISSET_ID);
  }

  /** Returns true if field turnNum is set (has been assigned a value) and false otherwise */
  public boolean isSetTurnNum() {
    return __isset_bit_vector.get(__TURNNUM_ISSET_ID);
  }

  public void setTurnNumIsSet(boolean value) {
    __isset_bit_vector.set(__TURNNUM_ISSET_ID, value);
  }

  public UserState getUser() {
    return this.user;
  }

  public State setUser(UserState user) {
    this.user = user;
    return this;
  }

  public void unsetUser() {
    this.user = null;
  }

  /** Returns true if field user is set (has been assigned a value) and false otherwise */
  public boolean isSetUser() {
    return this.user != null;
  }

  public void setUserIsSet(boolean value) {
    if (!value) {
      this.user = null;
    }
  }

  public int getHasLostSize() {
    return (this.hasLost == null) ? 0 : this.hasLost.size();
  }

  public java.util.Iterator<Boolean> getHasLostIterator() {
    return (this.hasLost == null) ? null : this.hasLost.iterator();
  }

  public void addToHasLost(boolean elem) {
    if (this.hasLost == null) {
      this.hasLost = new ArrayList<Boolean>();
    }
    this.hasLost.add(elem);
  }

  /**
   * Tells you who has lost so far.
   */
  public List<Boolean> getHasLost() {
    return this.hasLost;
  }

  /**
   * Tells you who has lost so far.
   */
  public State setHasLost(List<Boolean> hasLost) {
    this.hasLost = hasLost;
    return this;
  }

  public void unsetHasLost() {
    this.hasLost = null;
  }

  /** Returns true if field hasLost is set (has been assigned a value) and false otherwise */
  public boolean isSetHasLost() {
    return this.hasLost != null;
  }

  public void setHasLostIsSet(boolean value) {
    if (!value) {
      this.hasLost = null;
    }
  }

  /**
   * If it's on, you should keep playing.
   */
  public boolean isItsOn() {
    return this.itsOn;
  }

  /**
   * If it's on, you should keep playing.
   */
  public State setItsOn(boolean itsOn) {
    this.itsOn = itsOn;
    setItsOnIsSet(true);
    return this;
  }

  public void unsetItsOn() {
    __isset_bit_vector.clear(__ITSON_ISSET_ID);
  }

  /** Returns true if field itsOn is set (has been assigned a value) and false otherwise */
  public boolean isSetItsOn() {
    return __isset_bit_vector.get(__ITSON_ISSET_ID);
  }

  public void setItsOnIsSet(boolean value) {
    __isset_bit_vector.set(__ITSON_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case WORLD:
      if (value == null) {
        unsetWorld();
      } else {
        setWorld((WorldState)value);
      }
      break;

    case TURN_NUM:
      if (value == null) {
        unsetTurnNum();
      } else {
        setTurnNum((Integer)value);
      }
      break;

    case USER:
      if (value == null) {
        unsetUser();
      } else {
        setUser((UserState)value);
      }
      break;

    case HAS_LOST:
      if (value == null) {
        unsetHasLost();
      } else {
        setHasLost((List<Boolean>)value);
      }
      break;

    case ITS_ON:
      if (value == null) {
        unsetItsOn();
      } else {
        setItsOn((Boolean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case WORLD:
      return getWorld();

    case TURN_NUM:
      return Integer.valueOf(getTurnNum());

    case USER:
      return getUser();

    case HAS_LOST:
      return getHasLost();

    case ITS_ON:
      return Boolean.valueOf(isItsOn());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case WORLD:
      return isSetWorld();
    case TURN_NUM:
      return isSetTurnNum();
    case USER:
      return isSetUser();
    case HAS_LOST:
      return isSetHasLost();
    case ITS_ON:
      return isSetItsOn();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof State)
      return this.equals((State)that);
    return false;
  }

  public boolean equals(State that) {
    if (that == null)
      return false;

    boolean this_present_world = true && this.isSetWorld();
    boolean that_present_world = true && that.isSetWorld();
    if (this_present_world || that_present_world) {
      if (!(this_present_world && that_present_world))
        return false;
      if (!this.world.equals(that.world))
        return false;
    }

    boolean this_present_turnNum = true && this.isSetTurnNum();
    boolean that_present_turnNum = true && that.isSetTurnNum();
    if (this_present_turnNum || that_present_turnNum) {
      if (!(this_present_turnNum && that_present_turnNum))
        return false;
      if (this.turnNum != that.turnNum)
        return false;
    }

    boolean this_present_user = true && this.isSetUser();
    boolean that_present_user = true && that.isSetUser();
    if (this_present_user || that_present_user) {
      if (!(this_present_user && that_present_user))
        return false;
      if (!this.user.equals(that.user))
        return false;
    }

    boolean this_present_hasLost = true && this.isSetHasLost();
    boolean that_present_hasLost = true && that.isSetHasLost();
    if (this_present_hasLost || that_present_hasLost) {
      if (!(this_present_hasLost && that_present_hasLost))
        return false;
      if (!this.hasLost.equals(that.hasLost))
        return false;
    }

    boolean this_present_itsOn = true && this.isSetItsOn();
    boolean that_present_itsOn = true && that.isSetItsOn();
    if (this_present_itsOn || that_present_itsOn) {
      if (!(this_present_itsOn && that_present_itsOn))
        return false;
      if (this.itsOn != that.itsOn)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(State other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    State typedOther = (State)other;

    lastComparison = Boolean.valueOf(isSetWorld()).compareTo(typedOther.isSetWorld());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWorld()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.world, typedOther.world);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTurnNum()).compareTo(typedOther.isSetTurnNum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTurnNum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.turnNum, typedOther.turnNum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUser()).compareTo(typedOther.isSetUser());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUser()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.user, typedOther.user);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHasLost()).compareTo(typedOther.isSetHasLost());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHasLost()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hasLost, typedOther.hasLost);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetItsOn()).compareTo(typedOther.isSetItsOn());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetItsOn()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.itsOn, typedOther.itsOn);
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
    StringBuilder sb = new StringBuilder("State(");
    boolean first = true;

    if (isSetWorld()) {
      sb.append("world:");
      if (this.world == null) {
        sb.append("null");
      } else {
        sb.append(this.world);
      }
      first = false;
    }
    if (isSetTurnNum()) {
      if (!first) sb.append(", ");
      sb.append("turnNum:");
      sb.append(this.turnNum);
      first = false;
    }
    if (isSetUser()) {
      if (!first) sb.append(", ");
      sb.append("user:");
      if (this.user == null) {
        sb.append("null");
      } else {
        sb.append(this.user);
      }
      first = false;
    }
    if (isSetHasLost()) {
      if (!first) sb.append(", ");
      sb.append("hasLost:");
      if (this.hasLost == null) {
        sb.append("null");
      } else {
        sb.append(this.hasLost);
      }
      first = false;
    }
    if (isSetItsOn()) {
      if (!first) sb.append(", ");
      sb.append("itsOn:");
      sb.append(this.itsOn);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
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
      __isset_bit_vector = new BitSet(1);
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class StateStandardSchemeFactory implements SchemeFactory {
    public StateStandardScheme getScheme() {
      return new StateStandardScheme();
    }
  }

  private static class StateStandardScheme extends StandardScheme<State> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, State struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // WORLD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.world = new WorldState();
              struct.world.read(iprot);
              struct.setWorldIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TURN_NUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.turnNum = iprot.readI32();
              struct.setTurnNumIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // USER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.user = new UserState();
              struct.user.read(iprot);
              struct.setUserIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // HAS_LOST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list26 = iprot.readListBegin();
                struct.hasLost = new ArrayList<Boolean>(_list26.size);
                for (int _i27 = 0; _i27 < _list26.size; ++_i27)
                {
                  boolean _elem28; // required
                  _elem28 = iprot.readBool();
                  struct.hasLost.add(_elem28);
                }
                iprot.readListEnd();
              }
              struct.setHasLostIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // ITS_ON
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.itsOn = iprot.readBool();
              struct.setItsOnIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, State struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.world != null) {
        if (struct.isSetWorld()) {
          oprot.writeFieldBegin(WORLD_FIELD_DESC);
          struct.world.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetTurnNum()) {
        oprot.writeFieldBegin(TURN_NUM_FIELD_DESC);
        oprot.writeI32(struct.turnNum);
        oprot.writeFieldEnd();
      }
      if (struct.user != null) {
        if (struct.isSetUser()) {
          oprot.writeFieldBegin(USER_FIELD_DESC);
          struct.user.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.hasLost != null) {
        if (struct.isSetHasLost()) {
          oprot.writeFieldBegin(HAS_LOST_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.BOOL, struct.hasLost.size()));
            for (boolean _iter29 : struct.hasLost)
            {
              oprot.writeBool(_iter29);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetItsOn()) {
        oprot.writeFieldBegin(ITS_ON_FIELD_DESC);
        oprot.writeBool(struct.itsOn);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class StateTupleSchemeFactory implements SchemeFactory {
    public StateTupleScheme getScheme() {
      return new StateTupleScheme();
    }
  }

  private static class StateTupleScheme extends TupleScheme<State> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, State struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetWorld()) {
        optionals.set(0);
      }
      if (struct.isSetTurnNum()) {
        optionals.set(1);
      }
      if (struct.isSetUser()) {
        optionals.set(2);
      }
      if (struct.isSetHasLost()) {
        optionals.set(3);
      }
      if (struct.isSetItsOn()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetWorld()) {
        struct.world.write(oprot);
      }
      if (struct.isSetTurnNum()) {
        oprot.writeI32(struct.turnNum);
      }
      if (struct.isSetUser()) {
        struct.user.write(oprot);
      }
      if (struct.isSetHasLost()) {
        {
          oprot.writeI32(struct.hasLost.size());
          for (boolean _iter30 : struct.hasLost)
          {
            oprot.writeBool(_iter30);
          }
        }
      }
      if (struct.isSetItsOn()) {
        oprot.writeBool(struct.itsOn);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, State struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.world = new WorldState();
        struct.world.read(iprot);
        struct.setWorldIsSet(true);
      }
      if (incoming.get(1)) {
        struct.turnNum = iprot.readI32();
        struct.setTurnNumIsSet(true);
      }
      if (incoming.get(2)) {
        struct.user = new UserState();
        struct.user.read(iprot);
        struct.setUserIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list31 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.BOOL, iprot.readI32());
          struct.hasLost = new ArrayList<Boolean>(_list31.size);
          for (int _i32 = 0; _i32 < _list31.size; ++_i32)
          {
            boolean _elem33; // required
            _elem33 = iprot.readBool();
            struct.hasLost.add(_elem33);
          }
        }
        struct.setHasLostIsSet(true);
      }
      if (incoming.get(4)) {
        struct.itsOn = iprot.readBool();
        struct.setItsOnIsSet(true);
      }
    }
  }

}

