/**
 * Autogenerated by Thrift Compiler (0.9.0)
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

/**
 * ~Attack a unit~
 * 
 * Attacker inflicts damange to enemy based on their types
 * 
 * Failures:
 * 
 * If attacker or enemy is dead, or if enemy is now out-of-range (attack radius
 * is 1)
 */
public class AttackOp implements org.apache.thrift.TBase<AttackOp, AttackOp._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AttackOp");

  private static final org.apache.thrift.protocol.TField ATTACKER_FIELD_DESC = new org.apache.thrift.protocol.TField("attacker", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField ENEMY_FIELD_DESC = new org.apache.thrift.protocol.TField("enemy", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new AttackOpStandardSchemeFactory());
    schemes.put(TupleScheme.class, new AttackOpTupleSchemeFactory());
  }

  public Unit attacker; // optional
  public Unit enemy; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ATTACKER((short)1, "attacker"),
    ENEMY((short)2, "enemy");

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
        case 1: // ATTACKER
          return ATTACKER;
        case 2: // ENEMY
          return ENEMY;
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
  private _Fields optionals[] = {_Fields.ATTACKER,_Fields.ENEMY};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ATTACKER, new org.apache.thrift.meta_data.FieldMetaData("attacker", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Unit.class)));
    tmpMap.put(_Fields.ENEMY, new org.apache.thrift.meta_data.FieldMetaData("enemy", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Unit.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AttackOp.class, metaDataMap);
  }

  public AttackOp() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AttackOp(AttackOp other) {
    if (other.isSetAttacker()) {
      this.attacker = new Unit(other.attacker);
    }
    if (other.isSetEnemy()) {
      this.enemy = new Unit(other.enemy);
    }
  }

  public AttackOp deepCopy() {
    return new AttackOp(this);
  }

  @Override
  public void clear() {
    this.attacker = null;
    this.enemy = null;
  }

  public Unit getAttacker() {
    return this.attacker;
  }

  public AttackOp setAttacker(Unit attacker) {
    this.attacker = attacker;
    return this;
  }

  public void unsetAttacker() {
    this.attacker = null;
  }

  /** Returns true if field attacker is set (has been assigned a value) and false otherwise */
  public boolean isSetAttacker() {
    return this.attacker != null;
  }

  public void setAttackerIsSet(boolean value) {
    if (!value) {
      this.attacker = null;
    }
  }

  public Unit getEnemy() {
    return this.enemy;
  }

  public AttackOp setEnemy(Unit enemy) {
    this.enemy = enemy;
    return this;
  }

  public void unsetEnemy() {
    this.enemy = null;
  }

  /** Returns true if field enemy is set (has been assigned a value) and false otherwise */
  public boolean isSetEnemy() {
    return this.enemy != null;
  }

  public void setEnemyIsSet(boolean value) {
    if (!value) {
      this.enemy = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ATTACKER:
      if (value == null) {
        unsetAttacker();
      } else {
        setAttacker((Unit)value);
      }
      break;

    case ENEMY:
      if (value == null) {
        unsetEnemy();
      } else {
        setEnemy((Unit)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ATTACKER:
      return getAttacker();

    case ENEMY:
      return getEnemy();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ATTACKER:
      return isSetAttacker();
    case ENEMY:
      return isSetEnemy();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof AttackOp)
      return this.equals((AttackOp)that);
    return false;
  }

  public boolean equals(AttackOp that) {
    if (that == null)
      return false;

    boolean this_present_attacker = true && this.isSetAttacker();
    boolean that_present_attacker = true && that.isSetAttacker();
    if (this_present_attacker || that_present_attacker) {
      if (!(this_present_attacker && that_present_attacker))
        return false;
      if (!this.attacker.equals(that.attacker))
        return false;
    }

    boolean this_present_enemy = true && this.isSetEnemy();
    boolean that_present_enemy = true && that.isSetEnemy();
    if (this_present_enemy || that_present_enemy) {
      if (!(this_present_enemy && that_present_enemy))
        return false;
      if (!this.enemy.equals(that.enemy))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(AttackOp other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    AttackOp typedOther = (AttackOp)other;

    lastComparison = Boolean.valueOf(isSetAttacker()).compareTo(typedOther.isSetAttacker());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAttacker()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.attacker, typedOther.attacker);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEnemy()).compareTo(typedOther.isSetEnemy());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEnemy()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.enemy, typedOther.enemy);
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
    StringBuilder sb = new StringBuilder("AttackOp(");
    boolean first = true;

    if (isSetAttacker()) {
      sb.append("attacker:");
      if (this.attacker == null) {
        sb.append("null");
      } else {
        sb.append(this.attacker);
      }
      first = false;
    }
    if (isSetEnemy()) {
      if (!first) sb.append(", ");
      sb.append("enemy:");
      if (this.enemy == null) {
        sb.append("null");
      } else {
        sb.append(this.enemy);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (attacker != null) {
      attacker.validate();
    }
    if (enemy != null) {
      enemy.validate();
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

  private static class AttackOpStandardSchemeFactory implements SchemeFactory {
    public AttackOpStandardScheme getScheme() {
      return new AttackOpStandardScheme();
    }
  }

  private static class AttackOpStandardScheme extends StandardScheme<AttackOp> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, AttackOp struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ATTACKER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.attacker = new Unit();
              struct.attacker.read(iprot);
              struct.setAttackerIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ENEMY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.enemy = new Unit();
              struct.enemy.read(iprot);
              struct.setEnemyIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, AttackOp struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.attacker != null) {
        if (struct.isSetAttacker()) {
          oprot.writeFieldBegin(ATTACKER_FIELD_DESC);
          struct.attacker.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.enemy != null) {
        if (struct.isSetEnemy()) {
          oprot.writeFieldBegin(ENEMY_FIELD_DESC);
          struct.enemy.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AttackOpTupleSchemeFactory implements SchemeFactory {
    public AttackOpTupleScheme getScheme() {
      return new AttackOpTupleScheme();
    }
  }

  private static class AttackOpTupleScheme extends TupleScheme<AttackOp> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, AttackOp struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetAttacker()) {
        optionals.set(0);
      }
      if (struct.isSetEnemy()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetAttacker()) {
        struct.attacker.write(oprot);
      }
      if (struct.isSetEnemy()) {
        struct.enemy.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, AttackOp struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.attacker = new Unit();
        struct.attacker.read(iprot);
        struct.setAttackerIsSet(true);
      }
      if (incoming.get(1)) {
        struct.enemy = new Unit();
        struct.enemy.read(iprot);
        struct.setEnemyIsSet(true);
      }
    }
  }

}

