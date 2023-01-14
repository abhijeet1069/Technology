/**
 Synopsis : Using GPU to compute arrays.
 Date Created : 14th January 2023
 
 */

import MetalKit

let count:Int = 5

var array1 = [1,2,3,4,5]
var array2 = [1,2,3,4,5]

func basicForLoop(arr1:[Float], arr2:[Float]){
    print("Basic For Loop Way")
    let startTime = CFAbsoluteTimeGetCurrent()
    var result = [Float].init(repeating:0.0, count:count)
    for i in 0..<count{
        result[i] = arr1[i] + arr[1]
    }
}


//Add using GPU
computeWay(arr1:array1, arr2:array2)

//Add using CPU
basicForLoopWay(arr1:array1, arr2:array2)



