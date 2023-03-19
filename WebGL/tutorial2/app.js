//simple triangle

//vertex shader generates clip coordinates
var vertexShaderText = 
[
    'precision mediump float;',
    '',
    'attribute vec2 vertPosition;',
    'attribute vec3 vertColor;',
    'varying vec3 fragColor;',
    'uniform mat4 mWorld;',
    'uniform mat4 mView;',
    'uniform mat4 mProj;',
    '',
    'void main()',
    '{',
    '  fragColor = vertColor;',
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
    [ //x,y      R,G,B
        0.0,0.5,    1.0,1.0,0.0, //top vertex
        -0.5,-0.5,  0.7,0.0,1.0, //left vertex
        0.5,-0.5,    0.1,1.0,0.6 //right vertex
    ];
    var triangleVertexBufferObject = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER,triangleVertexBufferObject);
    gl.bufferData(gl.ARRAY_BUFFER,new Float32Array(triangleVertices),gl.STATIC_DRAW);

    var positionAttribLocation = gl.getAttribLocation(program,'vertPosition');
    var colorAttribLocation = gl.getAttribLocation(program,'vertColor');
    gl.vertexAttribPointer(
        positionAttribLocation,//attribute location
        2,
        gl.FLOAT, //ytpe of elements
        gl.FALSE,
        5*Float32Array.BYTES_PER_ELEMENT,//size of an individual vertex
        0//offset from the beginning of a single vertex to this attribute
    );
    gl.vertexAttribPointer(
        colorAttribLocation,//attribute location
        3,
        gl.FLOAT, //ytpe of elements
        gl.FALSE,
        5*Float32Array.BYTES_PER_ELEMENT,//size of an individual vertex
        2*Float32Array.BYTES_PER_ELEMENT//offset from the beginning of a single vertex to this attribute
    );
    gl.enableVertexAttribArray(positionAttribLocation);
    gl.enableVertexAttribArray(colorAttribLocation);

    gl.useProgram(program);
    gl.drawArrays(gl.TRIANGLES,0,3);
};
