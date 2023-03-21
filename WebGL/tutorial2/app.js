/** 
Vector : 4 numbers representing an x, y and z position in 3D space, along with a 4th component
    (1 for positions, 0 for directions). For ex [2,4,5,1]

Matrix : 4x4 set of numbers(in grpahics programming) that represents some mutation(transformation) to perform
    on a vector.
    Forx ex : Identity Matrix(No Operation) : [1,0,0,0]
                                              [0,1,0,0]
                                              [0,0,1,0]
                                              [0,0,0,1]
    Transalation Matrix
    Rotation Matrix
    Scale matrix
    View Transform : Adjust virtual camera
    Projection Transform : Map 3D space to 2D screen space

    Matrix do not change per vertex, so uniform
**/

var vertexShaderText = 
[
    'precision mediump float;',
    '',
    'attribute vec3 vertPosition;',
    'attribute vec3 vertColor;',
    'varying vec3 fragColor;',
    'uniform mat4 mWorld;', 
    'uniform mat4 mView;',
    'uniform mat4 mProj;',
    '',
    'void main()',
    '{',
        'fragColor = vertColor;',
    '  gl_Position = mProj * mView * mWorld * vec4(vertPosition,0.0,1.0);',
    '}' 
].join('\n');

var fragmentShaderText = 
[
    'precision mediump float;',
    '',
    'varying vec3 fragColor;',
    'void main()',
    '{',
    '  gl_FragColor = vec4(fragColor,1.0);',
    '}' 
].join('\n');

var InitDemo = function(){
    console.log("Hello,World!!");

    var canvas = document.getElementById("game-surface");
    var gl = canvas.getContext("webgl");
    //experimental web-gl for Safari or Internet Explorer
    if(!gl){
        console.log("WebGL not supported, using Experimental WebGL");
        gl = canvas.getContext("experimental-webgl");
    }
    //Change your browser
    if(!gl){
        alert("Your browser does not support WebGL");
    }

    //clear background
    gl.clearColor(0.75,0.85,0.8,1.0);
    gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);

    var vertexShader = gl.createShader(gl.VERTEX_SHADER);
    var fragmentShader = gl.createShader(gl.FRAGMENT_SHADER);

    //compile vertex and fragment shader
    gl.shaderSource(vertexShader,vertexShaderText);
    gl.shaderSource(fragmentShader,fragmentShaderText);

    gl.compileShader(vertexShader);
    if(!gl.getShaderParameter(vertexShader,gl.COMPILE_STATUS)){
        console.error('ERROR in compiling vertex shader!',gl.getShaderInfoLog(vertexShader));
        return;
    }
    gl.compileShader(fragmentShader);
    if(!gl.getShaderParameter(fragmentShader,gl.COMPILE_STATUS)){
        console.error('ERROR in compiling fragment shader!',gl.getShaderInfoLog(fragmentShader));
        return;
    }

    //combine vertex and fragment shader
    var program = gl.createProgram();
    gl.attachShader(program, vertexShader);
    gl.attachShader(program,fragmentShader);
    gl.linkProgram(program);
    if(!gl.getProgramParameter(program,gl.LINK_STATUS)){
        console.error("ERROR linking program!",gl.getProgramInfoLog(program));
        return;
    }
    //for debugging but not for release
    gl.validateProgram(program);
    if(!gl.getProgramParameter(program,gl.VALIDATE_STATUS)){
        console.error("ERROR validating program!",gl.getProgramInfoLog(program));
        return;
    }

    //create buffer
    //and transfer buffer to GPU
    var triangleVertices=
    [ //x,y,z      R,G,B
        0.0,0.5,0.0,    1.0,1.0,0.0,
        -0.5,-0.5,0.0,  0.7,0.0,1.0,
        0.5,-0.5,0.0,    0.1,1.0,0.6
    ];
    var triangleVertexBufferObject = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER,triangleVertexBufferObject);
    gl.bufferData(gl.ARRAY_BUFFER,new Float32Array(triangleVertices),gl.STATIC_DRAW);

    var positionAttribLocation = gl.getAttribLocation(program,'vertPosition');
    var colorAttribLocation = gl.getAttribLocation(program,'vertColor');
    gl.vertexAttribPointer(
        positionAttribLocation,//attribute location
        3,
        gl.FLOAT, //ytpe of elements
        gl.FALSE,
        6*Float32Array.BYTES_PER_ELEMENT,//size of an individual vertex
        0//offset from the beginning of a single vertex to this attribute
    );
    gl.vertexAttribPointer(
        colorAttribLocation,//attribute location
        3,
        gl.FLOAT, //ytpe of elements
        gl.FALSE,
        6*Float32Array.BYTES_PER_ELEMENT,//size of an individual vertex
        3*Float32Array.BYTES_PER_ELEMENT//offset from the beginning of a single vertex to this attribute
    );
    gl.enableVertexAttribArray(positionAttribLocation);
    gl.enableVertexAttribArray(colorAttribLocation);

    var matWorldUniformLocation = gl.getUniformLocation(program,'mWorld');
    var matViewUniformLocation = gl.getUniformLocation(program,'mView');
    var matProjUniformLocation = gl.getUniformLocation(program,'mProj');

    var projMatrix =  new Float32Array(16);
    var projMatrix =  new Float32Array(16);
    var projMatrix =  new Float32Array(16);

    gl.useProgram(program);
    gl.drawArrays(gl.TRIANGLES,0,3);
};
