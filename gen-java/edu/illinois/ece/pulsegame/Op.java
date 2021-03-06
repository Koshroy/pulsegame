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
 * Operations
 * It's nice to have a unified, abstract "operation" that can be any operation
 * because queueing works on operations generically, we need to have lists of
 * operations, and clients may do sophisticated (or maybe necessary) things like
 * their own queueing, prioritizing a bunch of operations, or things we didn't think of.
 * 
 * However, it means we have to encode operations. The OpType specifies what
 * this operation is; the other fields are the arguments. Only the set of
 * arguments relevant to the type will be read.
 */
public class Op implements org.apache.thrift.TBase<Op, Op._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Op");

  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField MOVE_FIELD_DESC = new org.apache.thrift.protocol.TField("move", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField ATTACK_FIELD_DESC = new org.apache.thrift.protocol.TField("attack", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField BUY_FIELD_DESC = new org.apache.thrift.protocol.TField("buy", org.apache.thrift.protocol.TType.STRUCT, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new OpStandardSchemeFactory());
    schemes.put(TupleScheme.class, new OpTupleSchemeFactory());
  }

  /**
   * 
   * @see OpType
   */
  public OpType type; // optional
  public MoveOp move; // optional
  public AttackOp attack; // optional
  public BuyOp buy; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see OpType
     */
    TYPE((short)1, "type"),
    MOVE((short)2, "move"),
    ATTACK((short)3, "attack"),
    BUY((short)4, "buy");

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
        case 2: // MOVE
          return MOVE;
        case 3: // ATTACK
          return ATTACK;
        case 4: // BUY
          return BUY;
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
  private _Fields optionals[] = {_Fields.TYPE,_Fields.MOVE,_Fields.ATTACK,_Fields.BUY};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, OpType.class)));
    tmpMap.put(_Fields.MOVE, new org.apache.thrift.meta_data.FieldMetaData("move", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MoveOp.class)));
    tmpMap.put(_Fields.ATTACK, new org.apache.thrift.meta_data.FieldMetaData("attack", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, AttackOp.class)));
    tmpMap.put(_Fields.BUY, new org.apache.thrift.meta_data.FieldMetaData("buy", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, BuyOp.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Op.class, metaDataMap);
  }

  public Op() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Op(Op other) {
    if (other.isSetType()) {
      this.type = other.type;
    }
    if (other.isSetMove()) {
      this.move = new MoveOp(other.move);
    }
    if (other.isSetAttack()) {
      this.attack = new AttackOp(other.attack);
    }
    if (other.isSetBuy()) {
      this.buy = new BuyOp(other.buy);
    }
  }

  public Op deepCopy() {
    return new Op(this);
  }

  @Override
  public void clear() {
    this.type = null;
    this.move = null;
    this.attack = null;
    this.buy = null;
  }

  /**
   * 
   * @see OpType
   */
  public OpType getType() {
    return this.type;
  }

  /**
   * 
   * @see OpType
   */
  public Op setType(OpType type) {
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

  public MoveOp getMove() {
    return this.move;
  }

  public Op setMove(MoveOp move) {
    this.move = move;
    return this;
  }

  public void unsetMove() {
    this.move = null;
  }

  /** Returns true if field move is set (has been assigned a value) and false otherwise */
  public boolean isSetMove() {
    return this.move != null;
  }

  public void setMoveIsSet(boolean value) {
    if (!value) {
      this.move = null;
    }
  }

  public AttackOp getAttack() {
    return this.attack;
  }

  public Op setAttack(AttackOp attack) {
    this.attack = attack;
    return this;
  }

  public void unsetAttack() {
    this.attack = null;
  }

  /** Returns true if field attack is set (has been assigned a value) and false otherwise */
  public boolean isSetAttack() {
    return this.attack != null;
  }

  public void setAttackIsSet(boolean value) {
    if (!value) {
      this.attack = null;
    }
  }

  public BuyOp getBuy() {
    return this.buy;
  }

  public Op setBuy(BuyOp buy) {
    this.buy = buy;
    return this;
  }

  public void unsetBuy() {
    this.buy = null;
  }

  /** Returns true if field buy is set (has been assigned a value) and false otherwise */
  public boolean isSetBuy() {
    return this.buy != null;
  }

  public void setBuyIsSet(boolean value) {
    if (!value) {
      this.buy = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((OpType)value);
      }
      break;

    case MOVE:
      if (value == null) {
        unsetMove();
      } else {
        setMove((MoveOp)value);
      }
      break;

    case ATTACK:
      if (value == null) {
        unsetAttack();
      } else {
        setAttack((AttackOp)value);
      }
      break;

    case BUY:
      if (value == null) {
        unsetBuy();
      } else {
        setBuy((BuyOp)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TYPE:
      return getType();

    case MOVE:
      return getMove();

    case ATTACK:
      return getAttack();

    case BUY:
      return getBuy();

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
    case MOVE:
      return isSetMove();
    case ATTACK:
      return isSetAttack();
    case BUY:
      return isSetBuy();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Op)
      return this.equals((Op)that);
    return false;
  }

  public boolean equals(Op that) {
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

    boolean this_present_move = true && this.isSetMove();
    boolean that_present_move = true && that.isSetMove();
    if (this_present_move || that_present_move) {
      if (!(this_present_move && that_present_move))
        return false;
      if (!this.move.equals(that.move))
        return false;
    }

    boolean this_present_attack = true && this.isSetAttack();
    boolean that_present_attack = true && that.isSetAttack();
    if (this_present_attack || that_present_attack) {
      if (!(this_present_attack && that_present_attack))
        return false;
      if (!this.attack.equals(that.attack))
        return false;
    }

    boolean this_present_buy = true && this.isSetBuy();
    boolean that_present_buy = true && that.isSetBuy();
    if (this_present_buy || that_present_buy) {
      if (!(this_present_buy && that_present_buy))
        return false;
      if (!this.buy.equals(that.buy))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Op other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Op typedOther = (Op)other;

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
    lastComparison = Boolean.valueOf(isSetMove()).compareTo(typedOther.isSetMove());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMove()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.move, typedOther.move);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAttack()).compareTo(typedOther.isSetAttack());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAttack()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.attack, typedOther.attack);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBuy()).compareTo(typedOther.isSetBuy());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBuy()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.buy, typedOther.buy);
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
    StringBuilder sb = new StringBuilder("Op(");
    boolean first = true;

    if (isSetType()) {
      sb.append("type:");
      if (this.type == null) {
        sb.append("null");
      } else {
        sb.append(this.type);
      }
      first = false;
    }
    if (isSetMove()) {
      if (!first) sb.append(", ");
      sb.append("move:");
      if (this.move == null) {
        sb.append("null");
      } else {
        sb.append(this.move);
      }
      first = false;
    }
    if (isSetAttack()) {
      if (!first) sb.append(", ");
      sb.append("attack:");
      if (this.attack == null) {
        sb.append("null");
      } else {
        sb.append(this.attack);
      }
      first = false;
    }
    if (isSetBuy()) {
      if (!first) sb.append(", ");
      sb.append("buy:");
      if (this.buy == null) {
        sb.append("null");
      } else {
        sb.append(this.buy);
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

  private static class OpStandardSchemeFactory implements SchemeFactory {
    public OpStandardScheme getScheme() {
      return new OpStandardScheme();
    }
  }

  private static class OpStandardScheme extends StandardScheme<Op> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Op struct) throws org.apache.thrift.TException {
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
              struct.type = OpType.findByValue(iprot.readI32());
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MOVE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.move = new MoveOp();
              struct.move.read(iprot);
              struct.setMoveIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ATTACK
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.attack = new AttackOp();
              struct.attack.read(iprot);
              struct.setAttackIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // BUY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.buy = new BuyOp();
              struct.buy.read(iprot);
              struct.setBuyIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Op struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.type != null) {
        if (struct.isSetType()) {
          oprot.writeFieldBegin(TYPE_FIELD_DESC);
          oprot.writeI32(struct.type.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.move != null) {
        if (struct.isSetMove()) {
          oprot.writeFieldBegin(MOVE_FIELD_DESC);
          struct.move.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.attack != null) {
        if (struct.isSetAttack()) {
          oprot.writeFieldBegin(ATTACK_FIELD_DESC);
          struct.attack.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.buy != null) {
        if (struct.isSetBuy()) {
          oprot.writeFieldBegin(BUY_FIELD_DESC);
          struct.buy.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class OpTupleSchemeFactory implements SchemeFactory {
    public OpTupleScheme getScheme() {
      return new OpTupleScheme();
    }
  }

  private static class OpTupleScheme extends TupleScheme<Op> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Op struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetType()) {
        optionals.set(0);
      }
      if (struct.isSetMove()) {
        optionals.set(1);
      }
      if (struct.isSetAttack()) {
        optionals.set(2);
      }
      if (struct.isSetBuy()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetType()) {
        oprot.writeI32(struct.type.getValue());
      }
      if (struct.isSetMove()) {
        struct.move.write(oprot);
      }
      if (struct.isSetAttack()) {
        struct.attack.write(oprot);
      }
      if (struct.isSetBuy()) {
        struct.buy.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Op struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.type = OpType.findByValue(iprot.readI32());
        struct.setTypeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.move = new MoveOp();
        struct.move.read(iprot);
        struct.setMoveIsSet(true);
      }
      if (incoming.get(2)) {
        struct.attack = new AttackOp();
        struct.attack.read(iprot);
        struct.setAttackIsSet(true);
      }
      if (incoming.get(3)) {
        struct.buy = new BuyOp();
        struct.buy.read(iprot);
        struct.setBuyIsSet(true);
      }
    }
  }

}

