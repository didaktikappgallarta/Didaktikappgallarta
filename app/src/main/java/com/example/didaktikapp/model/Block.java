package com.example.didaktikapp.model;

/**
 * clase para las piezas del puzzle
 * @author didaktikapp
 */

public class Block {
    public Block(int position, int vPosition, int hPosition){
        this.position = position;
        this.vPosition = vPosition;
        this.hPosition = hPosition;
    }
    public int position;
    public int vPosition;
    public int hPosition;
}
