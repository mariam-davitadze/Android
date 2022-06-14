package com.example.hm2

class AbstPoint constructor(): AbstractPoint() {
    override var x: Int
        get() {
            return  x;
        }
        set(value) {
            x=value;
        }
    override var y: Int
        get(){
            return y;
        }
        set(value) {
            y=value;
        }
    constructor(_x: Int, _y: Int) : this() {
        x=_x;
        y=_y;
    }
}