/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package edu.illinois.ece.pulsegame;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

/**
 * Types of units. Unit strengths and weaknesses are weather-dependent.
 */
public enum UnitType implements org.apache.thrift.TEnum {
  TYPE0(0),
  TYPE1(1),
  TYPE2(2),
  BASE(3);

  private final int value;

  private UnitType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static UnitType findByValue(int value) { 
    switch (value) {
      case 0:
        return TYPE0;
      case 1:
        return TYPE1;
      case 2:
        return TYPE2;
      case 3:
        return BASE;
      default:
        return null;
    }
  }
}
