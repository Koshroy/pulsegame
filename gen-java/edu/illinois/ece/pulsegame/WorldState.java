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
 * Wraps together World State, state which is associated with the whole world
 * and concerns both players.
 */
public class WorldState implements org.apache.thrift.TBase<WorldState, WorldState._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("WorldState");

  private static final org.apache.thrift.protocol.TField UNITS_FIELD_DESC = new org.apache.thrift.protocol.TField("units", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField BASES_FIELD_DESC = new org.apache.thrift.protocol.TField("bases", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new WorldStateStandardSchemeFactory());
    schemes.put(TupleScheme.class, new WorldStateTupleSchemeFactory());
  }

  /**
   * A list of maps, where each map corresponds to one player's units.
   * worldstate.units[pid] will get 	your own units and units[1-pid] will get your
   * opponents.  The maps are from the unit id to the unit itself (including its
   * position and health in the UnitPos struct).
   */
  public List<Map<Long,UnitPos>> units; // optional
  /**
   * Similarly, the bases for both players. These are not present in the units maps.
   */
  public List<UnitPos> bases; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * A list of maps, where each map corresponds to one player's units.
     * worldstate.units[pid] will get 	your own units and units[1-pid] will get your
     * opponents.  The maps are from the unit id to the unit itself (including its
     * position and health in the UnitPos struct).
     */
    UNITS((short)1, "units"),
    /**
     * Similarly, the bases for both players. These are not present in the units maps.
     */
    BASES((short)2, "bases");

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
        case 1: // UNITS
          return UNITS;
        case 2: // BASES
          return BASES;
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
  private _Fields optionals[] = {_Fields.UNITS,_Fields.BASES};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.UNITS, new org.apache.thrift.meta_data.FieldMetaData("units", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64), 
                new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, UnitPos.class)))));
    tmpMap.put(_Fields.BASES, new org.apache.thrift.meta_data.FieldMetaData("bases", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, UnitPos.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(WorldState.class, metaDataMap);
  }

  public WorldState() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public WorldState(WorldState other) {
    if (other.isSetUnits()) {
      List<Map<Long,UnitPos>> __this__units = new ArrayList<Map<Long,UnitPos>>();
      for (Map<Long,UnitPos> other_element : other.units) {
        Map<Long,UnitPos> __this__units_copy = new HashMap<Long,UnitPos>();
        for (Map.Entry<Long, UnitPos> other_element_element : other_element.entrySet()) {

          Long other_element_element_key = other_element_element.getKey();
          UnitPos other_element_element_value = other_element_element.getValue();

          Long __this__units_copy_copy_key = other_element_element_key;

          UnitPos __this__units_copy_copy_value = new UnitPos(other_element_element_value);

          __this__units_copy.put(__this__units_copy_copy_key, __this__units_copy_copy_value);
        }
        __this__units.add(__this__units_copy);
      }
      this.units = __this__units;
    }
    if (other.isSetBases()) {
      List<UnitPos> __this__bases = new ArrayList<UnitPos>();
      for (UnitPos other_element : other.bases) {
        __this__bases.add(new UnitPos(other_element));
      }
      this.bases = __this__bases;
    }
  }

  public WorldState deepCopy() {
    return new WorldState(this);
  }

  @Override
  public void clear() {
    this.units = null;
    this.bases = null;
  }

  public int getUnitsSize() {
    return (this.units == null) ? 0 : this.units.size();
  }

  public java.util.Iterator<Map<Long,UnitPos>> getUnitsIterator() {
    return (this.units == null) ? null : this.units.iterator();
  }

  public void addToUnits(Map<Long,UnitPos> elem) {
    if (this.units == null) {
      this.units = new ArrayList<Map<Long,UnitPos>>();
    }
    this.units.add(elem);
  }

  /**
   * A list of maps, where each map corresponds to one player's units.
   * worldstate.units[pid] will get 	your own units and units[1-pid] will get your
   * opponents.  The maps are from the unit id to the unit itself (including its
   * position and health in the UnitPos struct).
   */
  public List<Map<Long,UnitPos>> getUnits() {
    return this.units;
  }

  /**
   * A list of maps, where each map corresponds to one player's units.
   * worldstate.units[pid] will get 	your own units and units[1-pid] will get your
   * opponents.  The maps are from the unit id to the unit itself (including its
   * position and health in the UnitPos struct).
   */
  public WorldState setUnits(List<Map<Long,UnitPos>> units) {
    this.units = units;
    return this;
  }

  public void unsetUnits() {
    this.units = null;
  }

  /** Returns true if field units is set (has been assigned a value) and false otherwise */
  public boolean isSetUnits() {
    return this.units != null;
  }

  public void setUnitsIsSet(boolean value) {
    if (!value) {
      this.units = null;
    }
  }

  public int getBasesSize() {
    return (this.bases == null) ? 0 : this.bases.size();
  }

  public java.util.Iterator<UnitPos> getBasesIterator() {
    return (this.bases == null) ? null : this.bases.iterator();
  }

  public void addToBases(UnitPos elem) {
    if (this.bases == null) {
      this.bases = new ArrayList<UnitPos>();
    }
    this.bases.add(elem);
  }

  /**
   * Similarly, the bases for both players. These are not present in the units maps.
   */
  public List<UnitPos> getBases() {
    return this.bases;
  }

  /**
   * Similarly, the bases for both players. These are not present in the units maps.
   */
  public WorldState setBases(List<UnitPos> bases) {
    this.bases = bases;
    return this;
  }

  public void unsetBases() {
    this.bases = null;
  }

  /** Returns true if field bases is set (has been assigned a value) and false otherwise */
  public boolean isSetBases() {
    return this.bases != null;
  }

  public void setBasesIsSet(boolean value) {
    if (!value) {
      this.bases = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case UNITS:
      if (value == null) {
        unsetUnits();
      } else {
        setUnits((List<Map<Long,UnitPos>>)value);
      }
      break;

    case BASES:
      if (value == null) {
        unsetBases();
      } else {
        setBases((List<UnitPos>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case UNITS:
      return getUnits();

    case BASES:
      return getBases();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case UNITS:
      return isSetUnits();
    case BASES:
      return isSetBases();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof WorldState)
      return this.equals((WorldState)that);
    return false;
  }

  public boolean equals(WorldState that) {
    if (that == null)
      return false;

    boolean this_present_units = true && this.isSetUnits();
    boolean that_present_units = true && that.isSetUnits();
    if (this_present_units || that_present_units) {
      if (!(this_present_units && that_present_units))
        return false;
      if (!this.units.equals(that.units))
        return false;
    }

    boolean this_present_bases = true && this.isSetBases();
    boolean that_present_bases = true && that.isSetBases();
    if (this_present_bases || that_present_bases) {
      if (!(this_present_bases && that_present_bases))
        return false;
      if (!this.bases.equals(that.bases))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(WorldState other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    WorldState typedOther = (WorldState)other;

    lastComparison = Boolean.valueOf(isSetUnits()).compareTo(typedOther.isSetUnits());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUnits()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.units, typedOther.units);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBases()).compareTo(typedOther.isSetBases());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBases()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bases, typedOther.bases);
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
    StringBuilder sb = new StringBuilder("WorldState(");
    boolean first = true;

    if (isSetUnits()) {
      sb.append("units:");
      if (this.units == null) {
        sb.append("null");
      } else {
        sb.append(this.units);
      }
      first = false;
    }
    if (isSetBases()) {
      if (!first) sb.append(", ");
      sb.append("bases:");
      if (this.bases == null) {
        sb.append("null");
      } else {
        sb.append(this.bases);
      }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class WorldStateStandardSchemeFactory implements SchemeFactory {
    public WorldStateStandardScheme getScheme() {
      return new WorldStateStandardScheme();
    }
  }

  private static class WorldStateStandardScheme extends StandardScheme<WorldState> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, WorldState struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // UNITS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.units = new ArrayList<Map<Long,UnitPos>>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  Map<Long,UnitPos> _elem2; // required
                  {
                    org.apache.thrift.protocol.TMap _map3 = iprot.readMapBegin();
                    _elem2 = new HashMap<Long,UnitPos>(2*_map3.size);
                    for (int _i4 = 0; _i4 < _map3.size; ++_i4)
                    {
                      long _key5; // required
                      UnitPos _val6; // optional
                      _key5 = iprot.readI64();
                      _val6 = new UnitPos();
                      _val6.read(iprot);
                      _elem2.put(_key5, _val6);
                    }
                    iprot.readMapEnd();
                  }
                  struct.units.add(_elem2);
                }
                iprot.readListEnd();
              }
              struct.setUnitsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BASES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list7 = iprot.readListBegin();
                struct.bases = new ArrayList<UnitPos>(_list7.size);
                for (int _i8 = 0; _i8 < _list7.size; ++_i8)
                {
                  UnitPos _elem9; // required
                  _elem9 = new UnitPos();
                  _elem9.read(iprot);
                  struct.bases.add(_elem9);
                }
                iprot.readListEnd();
              }
              struct.setBasesIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, WorldState struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.units != null) {
        if (struct.isSetUnits()) {
          oprot.writeFieldBegin(UNITS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.MAP, struct.units.size()));
            for (Map<Long,UnitPos> _iter10 : struct.units)
            {
              {
                oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I64, org.apache.thrift.protocol.TType.STRUCT, _iter10.size()));
                for (Map.Entry<Long, UnitPos> _iter11 : _iter10.entrySet())
                {
                  oprot.writeI64(_iter11.getKey());
                  _iter11.getValue().write(oprot);
                }
                oprot.writeMapEnd();
              }
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.bases != null) {
        if (struct.isSetBases()) {
          oprot.writeFieldBegin(BASES_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.bases.size()));
            for (UnitPos _iter12 : struct.bases)
            {
              _iter12.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class WorldStateTupleSchemeFactory implements SchemeFactory {
    public WorldStateTupleScheme getScheme() {
      return new WorldStateTupleScheme();
    }
  }

  private static class WorldStateTupleScheme extends TupleScheme<WorldState> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, WorldState struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetUnits()) {
        optionals.set(0);
      }
      if (struct.isSetBases()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetUnits()) {
        {
          oprot.writeI32(struct.units.size());
          for (Map<Long,UnitPos> _iter13 : struct.units)
          {
            {
              oprot.writeI32(_iter13.size());
              for (Map.Entry<Long, UnitPos> _iter14 : _iter13.entrySet())
              {
                oprot.writeI64(_iter14.getKey());
                _iter14.getValue().write(oprot);
              }
            }
          }
        }
      }
      if (struct.isSetBases()) {
        {
          oprot.writeI32(struct.bases.size());
          for (UnitPos _iter15 : struct.bases)
          {
            _iter15.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, WorldState struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list16 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.MAP, iprot.readI32());
          struct.units = new ArrayList<Map<Long,UnitPos>>(_list16.size);
          for (int _i17 = 0; _i17 < _list16.size; ++_i17)
          {
            Map<Long,UnitPos> _elem18; // required
            {
              org.apache.thrift.protocol.TMap _map19 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I64, org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
              _elem18 = new HashMap<Long,UnitPos>(2*_map19.size);
              for (int _i20 = 0; _i20 < _map19.size; ++_i20)
              {
                long _key21; // required
                UnitPos _val22; // optional
                _key21 = iprot.readI64();
                _val22 = new UnitPos();
                _val22.read(iprot);
                _elem18.put(_key21, _val22);
              }
            }
            struct.units.add(_elem18);
          }
        }
        struct.setUnitsIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list23 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.bases = new ArrayList<UnitPos>(_list23.size);
          for (int _i24 = 0; _i24 < _list23.size; ++_i24)
          {
            UnitPos _elem25; // required
            _elem25 = new UnitPos();
            _elem25.read(iprot);
            struct.bases.add(_elem25);
          }
        }
        struct.setBasesIsSet(true);
      }
    }
  }

}

