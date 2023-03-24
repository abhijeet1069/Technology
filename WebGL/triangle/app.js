const vertexShaderGL = `
    attribute vec2 a_position;
    void main(){
        gl_Position = vec4(a_position,1.0,1.0);
    }
`;

const fragmentShaderGL = `
    precision mediump float;
    uniform vec4 u_color;
    void main(){
        gl_FragColor = u_color;
    }
`;

function drawTriangle(){
    var triangleVertices = 
    [// x , y , z     R,  G,  B
        0.0,0.5,0.0,  1.0,1.0,0.0,
        -0.0,-0.5,0.0,  0.7,0.0,1.0,
        0.0,-0.5,0.0,  0.1,1.0,0.6
    ];

    var triangleVertexBufferObject = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER,triangleVertexBufferObject);
    glbufferData(gl.ARRAY_BUFFER, new Float32Array(triangleVertices),gl.STATIC_DRAW);

    var positionAttribLocation = gl.getAttribLocation
}

function main(){
    const canvas = document.getElementById('glcanvas');
    canvas.width = 800;
    canvas.height = 600;
    const gl = canvas.getContext('webgl');
    if(!gl){
        console.log("WebGL not supported, using experimental webgl");
        gl = canvas.getContext('experimental-webgl');
    }
    if(!gl){
        alert('Your browser does not support WebGL');
    }

    gl.clearColor(0.0,0.0,0.0,1.0);
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

    var program = gl.createProgram();
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

    drawTriangle(gl);
}

main();