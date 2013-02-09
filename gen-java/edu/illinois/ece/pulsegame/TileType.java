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
 * ~The type of tiles~
 * 
 * Plains -Readily traversable, pretty much "normal ground"
 * 
 * Hills  -Limits movement, Once you travel over a hill you cant move any further
 * 
 * Oceans -Impassable, Similar to lava in the game "the floor is lava"
 */
public enum TileType implements org.apache.thrift.TEnum {
  PLAINS(0),
  HILL(1),
  OCEAN(2);

  private final int value;

  private TileType(int value) {
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
  public static TileType findByValue(int value) { 
    switch (value) {
      case 0:
        return PLAINS;
      case 1:
        return HILL;
      case 2:
        return OCEAN;
      default:
        return null;
    }
  }
}
