const vertexShaderGL = `
    precision mediump float;
    attribute vec3 vertPosition;
    attribute vec3 vertColor;
    varying vec3 fragColor;
    void main(){
        fragColor = vertColor;
        gl_Position = vec4(vertPosition,1.0);
    }
`;

const fragmentShaderGL = `
    precision mediump float;
    varying vec3 fragColor;
    void main(){
        gl_FragColor = vec4(fragColor,1.0);
    }
`;
var program;
var gl;

function drawTriangle(){
    var position = 
    [// x , y , z     R,  G,  B
        -0.5,0.0,0.0, //top left corner then clockwise
        0.5,-0.5,0.0,
        0.5,-0.5,0.0,
        0.5,0.5,0.0
    ];

    var color = 
    [
        1.0, 0.0, 0.0, // red
        0.0, 1.0, 0.0, // green
        0.0, 0.0, 1.0, // blue
        1.0, 1.0, 1.0 // white
    ];

    var positionBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER,positionBuffer);
    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(position),gl.STATIC_DRAW);

    var colorBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER,colorBuffer);
    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(color),gl.STATIC_DRAW);

    var positionAttribLocation = gl.getAttribLocation(program,'vertPosition');
    gl.vertexAttribPointer(
        positionAttribLocation, //index of vertex attribute to be modified
        3, //number of components per vertex attribute. Range 1-4
        gl.FLOAT, //datatype of each component
        gl.FALSE,  //normalized
        3*Float32Array.BYTES_PER_ELEMENT, //byte offset between consecutive vertex
        0 //byte offset of the first component in the attribute array
    );
    gl.enableVertexAttribArray(positionAttribLocation);

    var colorAttribLocation = gl.getAttribLocation(program,'vertColor');
    gl.vertexAttribPointer(
        colorAttribLocation,
        3,
        gl.FLOAT,
        gl.FALSE,
        3*Float32Array.BYTES_PER_ELEMENT,
        0
    );
    gl.enableVertexAttribArray(colorAttribLocation);

    gl.useProgram(program);
    gl.drawArrays(gl.TRIANGLE_FAN,0,4);
}


function main(){
    const canvas = document.getElementById('glcanvas');
    canvas.width = 800;
    canvas.height = 800;
    gl = canvas.getContext('webgl');
    if(!gl){
        console.log("WebGL not supported, using experimental webgl");
        gl = canvas.getContext('experimental-webgl');
    }
    if(!gl){
        alert('Your browser does not support WebGL');
    }

    gl.clearColor(255/255,242/255,204/255,1.0);
    gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);

    var vertexShader = gl.createShader(gl.VERTEX_SHADER);
    var fragmentShader = gl.createShader(gl.FRAGMENT_SHADER);

    gl.shaderSource(vertexShader,vertexShaderGL); 
    gl.shaderSource(fragmentShader,fragmentShaderGL);

    gl.compileShader(vertexShader);
    if(!gl.getShaderParameter(vertexShader,gl.COMPILE_STATUS)){
        console.error('Error in compiling vertex shader!',gl.getShaderInfoLog(vertexShader));
        return;
    }

    gl.compileShader(fragmentShader);
    if(!gl.getShaderParameter(fragmentShader,gl.COMPILE_STATUS)){
        console.error('Error in compiling fragment shader!',gl.getShaderInfoLog(fragmentShader));
        return;
    }

    program = gl.createProgram();
    gl.attachShader(program,vertexShader);
    gl.attachShader(program,fragmentShader);
    gl.linkProgram(program);
    if(!gl.getProgramParameter(program,gl.LINK_STATUS)){
        console.error('Error in linking program!',gl.getProgramInfoLog(program));
        return;
    }

    gl.validateProgram(program);
    if(!gl.getProgramParameter(program,gl.VALIDATE_STATUS)){
        console.error('Error in validating program!',gl.getProgramInfoLog(program));
        return;
    }

    drawTriangle();
}

main();