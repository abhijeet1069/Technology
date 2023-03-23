Why learn WebGL? Very simply, it is the only cross platform solution for producing real time, 3D computer graphics.
OpenGL is cross platform but it does not has a definitive way to interface to an OS's UI .

Raster graphics - Describes a picture using many small dots of color.
Vector graphics - Describes objects as geometric shapes using mathematical equations.

GLSL (OpenGL Shading Language): https://shaderific.com/glsl.html
    Browser--GLSL-->GPU

    1) Comments:
        //Hello
        /*
            Hello
            World
        */
    
    2) Variables and Constants:
        type variable_identifier = value;
        const type constant_identifier = value;

        int : int a = 4;
        float : float b = 20.0; float e = float(false); //e=0.0
        bool
        chars and string don't exist in GLSL

    a) Vectors:
        Float vectors:
            vec2 : vec2 vectA = vec2(1.0, 6.0);
            vec3 : vec3 vectC = vec3(0.0); //same as vec3(0.0,0.0,0.0)
            vec4 : vec4 vectE = vec4(vectC,vectA); //same as vec4(0.0,0.0,1.0,6.0)
        Int vectors:
            ivec2
            ivec3
            ivec4
        Boolean vectors:
            bvec2
            bvec3
            bvec4 : bvec4 vectB = bvec4(true,true,false,false);

        Accessing components in vectors:
            float a1 = vect.x or vect.r or vect.s
            float a2 = vect.y or vect.g or vect.t
            float a3 = vect.z or vect.b or vect.p
            float a4 = vect.w or vect.a or vect.q
    
    b) Matrices:
        mat2 : [x1,x2,
                y1,y2]
        
        mat3 : [x1,x2,x3        mat3 matB = mat3(x1,y1,z1,x2,y2,z2,x3,y3,z3); //column major
                y1,y2,y3
                z1,z2,z3]
        
        mat4 : [x1,x2,x3,x4
                y1,y2,y3,y4
                z1,z2,z3,z4
                w1,w2,w3,w4]

    c) Sampler
        sampler2D
        samplerCube

    d) Arrays:
        float arrayA[7];
    
    e) Structures:
        struct myType{
            int c1;
            vect3 c2;
        }a;

    3) Control Flow statements:
        if-else and for loop
        for(int i = 0; i < 10; i++){}

    4) Functions:
        float funcA(int a, vec2 b){
            //stuff to do
            return 1.0;
        }
        Also, order of functions matter like C

    5) Storage Qualifier
        const
        attribute - Isolated data between vertices like coordinate. Each vertex has its own coordinate.
                    Only allowed in vertex shader.
        uniform - Common data between vertices like time.
                    Allowed both in attribute and vertex shader.
        varying - Used to transfer data from vertex to fragment shader.

    6) Precision Qualifier:
        Used for optimising memory constraints.
        lowp : mediump float f;
        mediump
        highp : precision highp vec2;

    7) Shaders:
        A shader is a program written in GLSL.
        
        a) Vertex Shader - Coordinates for vertices. If a mesh has 'n' vertices then vertex shader will be executed 'n' times.
        For ex:
            void main(){
                gl_Position = projetionMatrix * modelViewMatrix * vec4(position,1.0);
            }

        b) Fragment Shader - Colorise vertices when vectices have been positioned.
            void main(){
                                    R     G    B   Alpha  
                gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0); //contains color of only one fragment.
            }
