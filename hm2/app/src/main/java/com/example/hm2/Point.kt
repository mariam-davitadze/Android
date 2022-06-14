import java.lang.Math.sqrt

class Point{
    private var x: Int;
    private var y: Int;

    constructor(_x: Int, _y: Int) {
        x=_x;
        y=_y;
    }
    override fun toString(): String{
        return "<$x>, <$y>";
    }

    fun equals(x1: Int, y1:Int): Boolean{
        return (x1==x && y1==y);
    }

    fun findSymmetricPoint(): IntArray {
        return intArrayOf(-x, -y);
    }
    fun findDistance(x1: Int, y1:Int): Double{
        if(equals(x1, y1)){
            return 0.0;
        }
        var d2 = Math.pow((x1-x).toDouble(), 2.0) + Math.pow((y1-y).toDouble(), 2.0);

        return sqrt(d2);
    }
}