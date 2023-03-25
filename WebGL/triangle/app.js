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
    var triangleVertices = 
    [// x , y , z     R,  G,  B
        -0.5,0.5,0.0,   255/255,217/255,102/255,
        0.0,0.5,0.0, 244/255,177/255,131/255,
        -0.5,-0.5,0.0,  223/255,166/255,123/255,
        0.0,-0.5,0.0,  223/255,166/255,123/255
    ];

    var triangleVertexBufferObject = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER,triangleVertexBufferObject);
    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(triangleVertices),gl.STATIC_DRAW);

    var positionAttribLocation = gl.getAttribLocation(program,'vertPosition');
    var colorAttribLocation = gl.getAttribLocation(program,'vertColor');

    gl.vertexAttribPointer(
        positionAttribLocation,
        4,
        gl.FLOAT,
        gl.FALSE,
        6*Float32Array.BYTES_PER_ELEMENT,
        0
    );
    gl.vertexAttribPointer(
        colorAttribLocation,
        4,
        gl.FLOAT,
        gl.FALSE,
        6*Float32Array.BYTES_PER_ELEMENT,
        3*Float32Array.BYTES_PER_ELEMENT
    );

    gl.enableVertexAttribArray(positionAttribLocation);
    gl.enableVertexAttribArray(colorAttribLocation);

    gl.useProgram(program);
    gl.drawArrays(gl.TRIANGLES,0,4);
}


function main(){
    const canvas = document.getElementById('glcanvas');
    canvas.width = 800;
    canvas.height = 600;
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