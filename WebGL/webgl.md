In WebGL to draw a triangle:
    gl.TRIANGLES
        Draws each triangle individually by specifying the vertices of each triangles in groups of 3.
    
    gl.TRIANGLE_STRIP
        Creates a strip of connected triangles by reusing the last two vertices of previous triangle
        to form the next triangle.