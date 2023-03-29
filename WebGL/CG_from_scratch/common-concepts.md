Goal:
To create below function:
    canvas.PutPixel(x,y,color)

Coordinate Systems:
    Canvas Width : Cw
    Canvas Height : Ch
    In WebGL coordinate(S) conversion equation:
        Sx = Cw/2 + Cx
        Sy = Ch/2 - Cy
    Origin : (Cw/2, Ch/2)

Color System:
    Subtractive Color Model - With paper, we start with white light and subtract the wavelengths we don't want.
    Additive  Color Model - With screen we start with no light and add the wavelengths we want.

    Most images these days use 8 bits per primary color, which we call color channel. Using 8 bits per channel gives us 24 bits per pixel, for a total of 2^24 colors.
    
    Intensity of color:
        k(R,G,B) = (kR,kG,kB)

    Add two colors:
        (R1,G1,B1) + (R2,G2,B2) = (R1+R2,G1+G2,B1+B2)
        Post transformation clamping to be done to [0-255]

    Rendering a Swiss Landscape:
        Suppose you are visiting some exotic place and come across a stunning landscape - so stunning you just need to make a painting capturing its beauty. You have a canvas and a paint brush, but you absolutely lack artistic talent. Is all hope lost?
        Not necessarily. You may not have artistic talent, but you are methodical. So you do the most obvious thing: you get an insect net. You cut a rectangular piece, frame it, and fix it to a stick. Now you can look at the landscape through a netted window. Next, you choose the best point of view to appreciate this landscape and plant another stick to mark the exact position where your eye should be.
        You haven’t started the painting yet, but now you have a fixed point of view and a fixed frame through which you can see the landscape. Moreover, this fixed frame is divided into small squares by the insect net. Now comes the methodical part. You draw a grid on the canvas, giving it the same number of squares as the insect net. Then you look at the top-left square of the net. What’s the predominant color you can see through it? Sky blue. So you paint the top-left square of the canvas sky blue. You do this for every square, and soon enough the canvas contains a pretty good painting of the landscape, as seen through the frame. 
            Place the eye and the frame as desired
            For each square on the canvas
                Determine which square on the grid corresponds to this square on the canvas
                Determine the color seen through that grid square
                Paint the square with that color

Basic Assumptions:
    We will assume a fixed viewing position. The viewing psoition, the place where you would put your eye in Swiss landscape analogy, is commonly called the camera position.