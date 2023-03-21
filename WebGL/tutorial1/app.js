const vertexShaderSource = `
        attribute vec2 a_position;
        void main() {
          gl_Position = vec4(a_position, 0.0, 1.0);
        }
      `;
      
      const fragmentShaderSource = `
        precision mediump float;
        uniform vec4 u_color;
        void main() {
          gl_FragColor = u_color;
        }
      `;
      
      // Initialize WebGL
      const canvas = document.getElementById('game-surface');
      const gl = canvas.getContext('webgl');
      
      // Create shaders
      const vertexShader = gl.createShader(gl.VERTEX_SHADER);
      gl.shaderSource(vertexShader, vertexShaderSource);
      gl.compileShader(vertexShader);
      
      const fragmentShader = gl.createShader(gl.FRAGMENT_SHADER);
      gl.shaderSource(fragmentShader, fragmentShaderSource);
      gl.compileShader(fragmentShader);
      
      // Create program and link shaders
      const program = gl.createProgram();
      gl.attachShader(program, vertexShader);
      gl.attachShader(program, fragmentShader);
      gl.linkProgram(program);
      gl.useProgram(program);
      
      // Set up vertex buffer
      const positionBuffer = gl.createBuffer();
      gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
      const numSegments = 10; // number of segments in the circle
      let positions = [];
      positions.push(0, 0); // center of the circle
      for (let i = 0; i <= numSegments; i++) {
        const angle = i / numSegments * Math.PI * 2;
        const x = Math.cos(angle);
        const y = Math.sin(angle);
        positions.push(x, y);
      }
      gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(positions), gl.STATIC_DRAW);
      const positionAttributeLocation = gl.getAttribLocation(program, 'a_position');
      gl.enableVertexAttribArray(positionAttributeLocation);
      gl.vertexAttribPointer(positionAttributeLocation, 2, gl.FLOAT, false, 0, 0);
      
      // Set up uniform for color
      const colorUniformLocation = gl.getUniformLocation(program, 'u_color');
      gl.uniform4f(colorUniformLocation, 1.0, 0.0, 0.0, 1.0); // Red
      
      // Clear the canvas and draw the circle
      gl.clearColor(0.0, 0.0, 0.0, 1.0); // Black
      gl.clear(gl.COLOR_BUFFER_BIT);
      gl.drawArrays(gl.TRIANGLE_FAN, 0, numSegments + 2); // +2 because of the center point