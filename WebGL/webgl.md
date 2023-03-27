In WebGL to draw a triangle:
    gl.TRIANGLES
        Draws each triangle individually by specifying the vertices of each triangles in groups of 3.
    
    gl.TRIANGLE_STRIP
        Creates a strip of connected triangles by reusing the last two vertices of previous triangle
        to form the next triangle.

Vertex:
    Coordinates
    Color
    Normal(Perpendicular from a surface)

WebGL uses a right handed coordinate system. While DirectX uses left handed coordinate system.
    X(thumb)
    Y(pointer finger)
    Z(middle finger)

Uniform are data not related to vertices but global variables like lighting, camera position, current texture, transform matrices etc.

