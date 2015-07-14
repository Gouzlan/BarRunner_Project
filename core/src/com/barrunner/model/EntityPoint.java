
package com.barrunner.model;

/* --- CLASS EntityPoint --- */
/**
 * Point class for holding a set of coordinates. Contains an X coordinate,
 * 	and a Y coordinate. Both are Floating Points.
 */
public class EntityPoint {

	/* --- Variables --- */
	public float x;
	public float y;

	/* --- Constructors --- */
	public EntityPoint() {
		x = 0f;
		y = 0f;
	}

	public EntityPoint(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	
	/* --- Methods--- */

	@Override
	public EntityPoint clone()
	{
		return new EntityPoint(x,y);
	}

	@Override
    public boolean equals(Object obj)
    {
	    if (this == obj)
		    return true;
	    if (obj == null)
		    return false;
	    if (getClass() != obj.getClass())
		    return false;
	    EntityPoint other = (EntityPoint) obj;
	    if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
		    return false;
	    if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
		    return false;
	    return true;
    }	
}