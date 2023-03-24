WebGL is just a rasterization (converting shapes into a series of pixels) engine.

WegGL runs on the GPU on your computer. You provide that code in the form of pairs of functions(shader).
    a) Vertex Shader - Computes vertex position
    b) Fragment Shader - Color for each pixel of the primtive being drawn.
Paired together they are called a program.

WebGL API is about setting up state for these pairs of functions to run. For each thing you want to draw you 
setup a bunch of state then execute a pair of functions calling gl.drawArrays() or gl.drawElements()

A shader can recieve data via:
    a)Attributes and Buffers
        Buffers are arrays of binary data you upload to the GPU.
        Attributes are used to specify how to pull data out of your buffers and provide them to your vertex shader.
    b)Uniforms
        Uniforms are global variables you set up before you execute your shader program.
    c)Textures
        Textures are arrays of data that you can randomly access in your shader program.
    d)Varyings
        Varyings are a way for a vertex shader to pass data to a fragment shader.